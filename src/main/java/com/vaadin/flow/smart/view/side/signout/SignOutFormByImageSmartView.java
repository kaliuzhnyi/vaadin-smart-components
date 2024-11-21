package com.vaadin.flow.smart.view.side.signout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.smart.component.form.signout.SignOutSmartForm;
import com.vaadin.flow.smart.view.side.SideByImageSmartView;
import jakarta.annotation.Nonnull;

@SuppressWarnings("rawtypes")
public interface SignOutFormByImageSmartView<F extends Component & SignOutSmartForm>
        extends SideByImageSmartView {

    @Nonnull
    F getForm();

    @Override
    @Nonnull
    default Component getContentContainer() {
        return getForm();
    }

}
