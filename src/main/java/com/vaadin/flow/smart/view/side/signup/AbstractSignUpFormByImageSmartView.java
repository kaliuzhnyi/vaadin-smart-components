package com.vaadin.flow.smart.view.side.signup;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.smart.component.form.signup.SignUpSmartForm;
import com.vaadin.flow.smart.view.side.block.AbstractBlockByImageSmartView;
import jakarta.annotation.Nonnull;

@SuppressWarnings("rawtypes")
public abstract class AbstractSignUpFormByImageSmartView<C extends FlexLayout,
        F extends Component & SignUpSmartForm>
        extends AbstractBlockByImageSmartView<C, F>
        implements SignUpFormByImageSmartView<F> {

    @Nonnull
    @Override
    public F getForm() {
        return getBlockContainer();
    }

}
