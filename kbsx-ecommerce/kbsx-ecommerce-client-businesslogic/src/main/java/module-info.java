// File managed by WebFX (DO NOT EDIT MANUALLY)

module kbsx.ecommerce.client.businesslogic {

    // Direct dependencies modules
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires transitive kbsx.base.client.aggregates;
    requires kbsx.base.shared.entities;
    requires kbsx.event.client.calendar;
    requires kbsx.hotel.shared.time;
    requires modality.base.client.entities;
    requires modality.base.shared.entities;
    requires modality.base.shared.knownitems;
    requires transitive webfx.platform.async;
    requires webfx.platform.util;
    requires webfx.stack.db.query;
    requires webfx.stack.orm.entity;

    // Exported packages
    exports org.kadampabookings.kbsx.ecommerce.client.businessdata.feesgroup;
    exports org.kadampabookings.kbsx.ecommerce.client.businessdata.preselection;
    exports org.kadampabookings.kbsx.ecommerce.client.businessdata.workingdocument;
    exports org.kadampabookings.kbsx.ecommerce.client.businesslogic.feesgroup;
    exports org.kadampabookings.kbsx.ecommerce.client.businesslogic.option;
    exports org.kadampabookings.kbsx.ecommerce.client.businesslogic.pricing;
    exports org.kadampabookings.kbsx.ecommerce.client.businesslogic.rules;
    exports org.kadampabookings.kbsx.ecommerce.client.businesslogic.workingdocument;

}