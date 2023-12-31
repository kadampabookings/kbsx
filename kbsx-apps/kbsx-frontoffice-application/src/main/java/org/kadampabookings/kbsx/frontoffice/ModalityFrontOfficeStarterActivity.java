package org.kadampabookings.kbsx.frontoffice;

import one.modality.base.client.application.ModalityClientStarterActivity;

/**
 * @author Bruno Salmon
 */
final class ModalityFrontOfficeStarterActivity extends ModalityClientStarterActivity {

    private static final String DEFAULT_START_PATH = "/app-home";

    ModalityFrontOfficeStarterActivity() {
        super(DEFAULT_START_PATH, ModalityFrontOfficeFrameContainerActivity::new);
    }

}
