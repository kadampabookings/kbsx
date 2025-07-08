// File managed by WebFX (DO NOT EDIT MANUALLY)

module kbsx.base.shared.entities {

    // Direct dependencies modules
    requires kbsx.hotel.shared.time;
    requires modality.base.shared.entities;
    requires modality.base.shared.knownitems;
    requires webfx.platform.util;
    requires webfx.stack.orm.entity;

    // Exported packages
    exports org.kadampabookings.kbsx.base.shared.entities;
    exports org.kadampabookings.kbsx.base.shared.entities.impl;
    exports org.kadampabookings.kbsx.base.shared.entities.markers;
    exports org.kadampabookings.kbsx.base.shared.services.systemmetrics;

    // Provided services
    provides dev.webfx.stack.orm.entity.EntityFactoryProvider with org.kadampabookings.kbsx.base.shared.entities.impl.DateInfoImpl.ProvidedFactory, org.kadampabookings.kbsx.base.shared.entities.impl.EventImpl.ProvidedFactory, org.kadampabookings.kbsx.base.shared.entities.impl.OptionImpl.ProvidedFactory, org.kadampabookings.kbsx.base.shared.entities.impl.SystemMetricsEntityImpl.ProvidedFactory;

}