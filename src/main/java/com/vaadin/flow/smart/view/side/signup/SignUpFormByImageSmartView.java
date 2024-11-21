package com.vaadin.flow.smart.view.side.signup;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.smart.component.form.signup.SignUpSmartForm;
import com.vaadin.flow.smart.view.side.SideByImageSmartView;
import jakarta.annotation.Nonnull;

@SuppressWarnings("rawtypes")
public interface SignUpFormByImageSmartView<F extends Component & SignUpSmartForm>
        extends SideByImageSmartView {

    @Nonnull
    F getForm();

    @Override
    @Nonnull
    default Component getContentContainer() {
        return getForm();
    }

}
