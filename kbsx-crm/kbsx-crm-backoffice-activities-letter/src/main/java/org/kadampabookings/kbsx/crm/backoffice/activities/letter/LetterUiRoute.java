package org.kadampabookings.kbsx.crm.backoffice.activities.letter;

import org.kadampabookings.kbsx.crm.backoffice.activities.letter.routing.LetterRouting;
import dev.webfx.stack.orm.domainmodel.activity.viewdomain.impl.ViewDomainActivityContextFinal;
import dev.webfx.stack.routing.uirouter.UiRoute;
import dev.webfx.stack.routing.uirouter.impl.UiRouteImpl;

/**
 * @author Bruno Salmon
 */
public final class LetterUiRoute extends UiRouteImpl {

    public LetterUiRoute() {
        super(uiRoute());
    }

    public static UiRoute<?> uiRoute() {
        return UiRoute.create(LetterRouting.getPath()
                , false
                , LetterActivity::new
                , ViewDomainActivityContextFinal::new
        );
    }
}
