package org.kadampabookings.kbsx.crm.backoffice.activities.authorizations;

import dev.webfx.extras.visual.controls.grid.VisualGrid;
import dev.webfx.kit.util.properties.FXProperties;
import dev.webfx.stack.orm.domainmodel.activity.viewdomain.impl.ViewDomainActivityBase;
import dev.webfx.stack.orm.entity.Entity;
import dev.webfx.stack.orm.entity.controls.entity.sheet.EntityPropertiesSheet;
import dev.webfx.stack.orm.reactive.mapping.entities_to_visual.ReactiveVisualMapper;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import one.modality.base.client.mainframe.fx.FXMainFrameDialogArea;
import one.modality.base.client.tile.TabsBar;
import one.modality.base.client.activity.ModalityButtonFactoryMixin;
import one.modality.base.backoffice.mainframe.fx.FXMainFrameHeaderTabs;

import static dev.webfx.stack.orm.dql.DqlStatement.where;

/**
 * @author Bruno Salmon
 */
final class AuthorizationsActivity extends ViewDomainActivityBase implements ModalityButtonFactoryMixin {

    private final static String roleColumns = "[{label: 'Role', expression: 'name'}]";
    private final static String manageeColumns = "[{label: 'Managee', expression: 'active, user.genderIcon, user.firstName, user.lastName,` (` + user.email + `)`'}]";
    private final static String rolesAssignmentColumns = "active, role.name";
    private final static String routesAssignmentColumns = "active, operation.name, operation.code, operation.grantRoute";
    private final static String operationsAssignmentColumns = "active, operation.name, operation.code";
    private final static String rulesAssignmentColumns = "active, rule.name, rule.rule";
    private final static String statesAssignmentColumns = "active, activityState";

    enum AuthorizationTab { ROLES, ROUTES, OPERATIONS, RULES, STATES }

    private ReactiveVisualMapper<Entity> assignmentVisualMapper;
    private final ObjectProperty<AuthorizationTab> selectedTabProperty = FXProperties.newObjectProperty(selectedTab -> {
            String columns = null;
            switch (selectedTab) {
                case ROLES: columns = rolesAssignmentColumns; break;
                case ROUTES: columns = routesAssignmentColumns; break;
                case OPERATIONS: columns = operationsAssignmentColumns; break;
                case RULES: columns = rulesAssignmentColumns; break;
                case STATES: columns = statesAssignmentColumns; break;
            }
            assignmentVisualMapper.setEntityColumns(columns); // Note: this change only doesn't trigger a new server call (TODO: fix this)
            // But assignmentVisualMapper is reacting to selectedTabProperty, so it will call the server in the end.
        });

    private final TabsBar<AuthorizationTab> headerTabsBar = new TabsBar<>(this, selectedTabProperty::set);
    private final VisualGrid manageesGrid = new VisualGrid();
    private final VisualGrid rolesGrid = new VisualGrid();
    private final VisualGrid assignmentsGrid = new VisualGrid();
    private final CheckBox rolesCheckBox = new CheckBox("Display roles");
    private final ObjectProperty<Entity> selectedEntityProperty = new SimpleObjectProperty<>();

    @Override
    public Node buildUi() {
        headerTabsBar.setTabs(
                headerTabsBar.createTab("Roles", AuthorizationTab.ROLES),
                headerTabsBar.createTab("Routes", AuthorizationTab.ROUTES),
                headerTabsBar.createTab("Operations", AuthorizationTab.OPERATIONS),
                headerTabsBar.createTab("Rules", AuthorizationTab.RULES),
                headerTabsBar.createTab("States", AuthorizationTab.STATES)
        );
        assignmentsGrid.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2)
                EntityPropertiesSheet.editEntity(assignmentVisualMapper.getSelectedEntity(), operationsAssignmentColumns, FXMainFrameDialogArea.getDialogArea());
        });
        BorderPane leftPane = new BorderPane();
        leftPane.centerProperty().bind(rolesCheckBox.selectedProperty().map(roles -> roles ? rolesGrid : manageesGrid));
        SplitPane splitPane = new SplitPane(leftPane, assignmentsGrid);
        splitPane.getDividers().get(0).setPosition(0.25);
        BorderPane container = new BorderPane(splitPane);
        container.setBottom(rolesCheckBox);
        BorderPane.setMargin(rolesCheckBox, new Insets(5));
        return container;
    }

    @Override
    public void onResume() {
        super.onResume();
        FXMainFrameHeaderTabs.setHeaderTabs(headerTabsBar.getTabs());
    }

    @Override
    public void onPause() {
        FXMainFrameHeaderTabs.resetToDefault();
        super.onPause();
    }


    protected void startLogic() {

        // Managees
        ReactiveVisualMapper.createPushReactiveChain(this)
                .always("{class: 'AuthorizationManagement', orderBy: 'id'}")
                // Temporary commented as ModalityUserPrincipal provisioning is not yet done. TODO: uncomment this once provisioning is done.
                //.ifNotNullOtherwiseEmpty(FXModalityUserPrincipal.modalityUserPrincipalProperty(), principal -> where("manager=?", principal.getUserPersonId()))
                .setEntityColumns(manageeColumns)
                .appendNullEntity(false)
                .visualizeResultInto(manageesGrid)
                .setSelectedEntityHandler(selectedEntityProperty::setValue)
                .start();

        // Roles
        ReactiveVisualMapper.createPushReactiveChain(this)
                .always("{class: 'AuthorizationRole', orderBy: 'id'}")
                .setEntityColumns(roleColumns)
                .visualizeResultInto(rolesGrid)
                .setSelectedEntityHandler(selectedEntityProperty::setValue)
                .start();

        // Authorization assignments
        assignmentVisualMapper = ReactiveVisualMapper.createPushReactiveChain(this)
                .always("{class: 'AuthorizationAssignment', orderBy: 'id'}")
                .ifNotNullOtherwise(selectedEntityProperty,
                        entity -> where("AuthorizationManagement".equals(entity.getDomainClass().getName()) ? "management=?" : "management=null and role=?", entity),
                        where("management=null and role=null"))
                .ifNotNull(selectedTabProperty, tab -> where(
                        tab == AuthorizationTab.ROLES ?      "management != null and role != null" :
                        tab == AuthorizationTab.ROUTES ?     "operation.code like 'RouteTo%'" :
                        tab == AuthorizationTab.OPERATIONS ? "operation != null && operation.code not like 'RouteTo%'" :
                        tab == AuthorizationTab.RULES ?      "rule != null" :
                        /* State */                          "activityState != null"))
                .visualizeResultInto(assignmentsGrid)
                .start();
    }
}