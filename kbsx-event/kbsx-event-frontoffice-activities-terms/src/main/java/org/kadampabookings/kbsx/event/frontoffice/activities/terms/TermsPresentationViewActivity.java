package org.kadampabookings.kbsx.event.frontoffice.activities.terms;

//import dev.webfx.extras.cell.collator.grid.GridCollator;

import dev.webfx.extras.util.layout.Layouts;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.kadampabookings.kbsx.base.client.icons.ModalityIcons;
import org.kadampabookings.kbsx.ecommerce.client.activity.bookingprocess.BookingProcessPresentationViewActivity;
import org.kadampabookings.kbsx.event.client.controls.sectionpanel.SectionPanelFactory;

/**
 * @author Bruno Salmon
 */
final class TermsPresentationViewActivity extends BookingProcessPresentationViewActivity<TermsPresentationModel> {

    private BorderPane termsPanel;

    @Override
    protected void createViewNodes(TermsPresentationModel pm) {
        super.createViewNodes(pm);
        //GridCollator termsLetterCollator = new GridCollator("first", "first");
        termsPanel = SectionPanelFactory.createSectionPanel(ModalityIcons.certificateMonoSvg16JsonUrl, "TermsAndConditions");
        //termsPanel.setCenter(ControlUtil.createVerticalScrollPaneWithPadding(termsLetterCollator));

        //termsLetterCollator.visualResultProperty().bind(pm.termsLetterVisualResultProperty());
    }

    @Override
    protected Node assemblyViewNodes() {
        return Layouts.createPadding(new VBox(10, Layouts.setVGrowable(termsPanel), Layouts.setMaxWidthToInfinite(backButton)), 10);
    }
}
