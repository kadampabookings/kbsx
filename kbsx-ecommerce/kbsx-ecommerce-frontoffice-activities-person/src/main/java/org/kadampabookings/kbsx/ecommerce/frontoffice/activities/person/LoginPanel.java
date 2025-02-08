package org.kadampabookings.kbsx.ecommerce.frontoffice.activities.person;

import dev.webfx.kit.util.properties.FXProperties;
import dev.webfx.stack.authn.AuthenticationRequest;
import dev.webfx.stack.authn.AuthenticateWithUsernamePasswordCredentials;
import dev.webfx.stack.i18n.controls.I18nControls;
import dev.webfx.stack.session.state.client.fx.FXUserPrincipal;
import dev.webfx.stack.ui.controls.button.ButtonFactory;
import dev.webfx.stack.ui.controls.dialog.GridPaneBuilder;
import dev.webfx.extras.util.animation.Animations;
import dev.webfx.extras.util.layout.Layouts;
import dev.webfx.extras.util.scene.SceneUtil;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import one.modality.base.client.activity.ModalityButtonFactoryMixin;
import dev.webfx.stack.ui.validation.ValidationSupport;
import org.kadampabookings.kbsx.event.client.controls.sectionpanel.SectionPanelFactory;


/**
 * @author Bruno Salmon
 */
public final class LoginPanel implements ModalityButtonFactoryMixin {

    private final Node node;
    private final TextField usernameField;
    private final PasswordField passwordField;
    private final Button button;
    private final Property<Boolean> signInModeProperty = new SimpleObjectProperty<>(true);
    private final ValidationSupport validationSupport = new ValidationSupport();

    public LoginPanel() {
        BorderPane loginWindow = SectionPanelFactory.createSectionPanel("SignInWindowTitle"); // ???
        Hyperlink hyperLink = newHyperlink("ForgotPassword?", e -> signInModeProperty.setValue(!signInModeProperty.getValue()));
        GridPane gridPane;
        loginWindow.setCenter(
            gridPane = new GridPaneBuilder()
                .addNodeFillingRow(usernameField = newMaterialTextField("Email")) // ???
                .addNodeFillingRow(passwordField = newMaterialPasswordField("Password")) // ???
                .addNewRow(hyperLink)
                .addNodeFillingRow(button = newLargeGreenButton(null))
                .build()
        );
        gridPane.setPadding(new Insets(20));
        GridPane.setHalignment(hyperLink, HPos.CENTER);
        hyperLink.setOnAction(e -> signInModeProperty.setValue(!signInModeProperty.getValue()));
        Layouts.bindManagedAndVisiblePropertiesTo(signInModeProperty, passwordField);
        FXProperties.runNowAndOnPropertyChange(signIn ->
                I18nControls.bindI18nProperties(button, signIn ? "SignIn>>" : "SendPassword>>"), signInModeProperty  // ???
            );
        node = Layouts.createGoldLayout(loginWindow);
        initValidation();
        button.setOnAction(event -> {
            if (validationSupport.isValid())
                new AuthenticationRequest()
                    .setUserCredentials(new AuthenticateWithUsernamePasswordCredentials(usernameField.getText(), passwordField.getText()))
                    .executeAsync()
                    .onFailure(cause -> Animations.shake(loginWindow))
                    .onSuccess(FXUserPrincipal::setUserPrincipal);
        });
        prepareShowing();
    }

    private void initValidation() {
        validationSupport.addRequiredInput(usernameField, new SimpleStringProperty("Username is required"));
        validationSupport.addRequiredInput(passwordField, new SimpleStringProperty("Password is required"));
    }

    public Node getNode() {
        return node;
    }

    public void prepareShowing() {
        // Resetting the default button (required for JavaFX if displayed a second time)
        ButtonFactory.resetDefaultButton(button);
        SceneUtil.autoFocusIfEnabled(usernameField);
    }
}
