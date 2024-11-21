package com.vaadin.flow.smart.view.side.signup;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.smart.component.block.BlockSmartComponent;
import com.vaadin.flow.smart.component.form.signup.SignUpSmartForm;
import com.vaadin.flow.smart.view.side.block.BlockByImageSmartView;
import jakarta.annotation.Nonnull;

@SuppressWarnings("rawtypes")
public interface SignUpFormByImageSmartView<F extends Component & SignUpSmartForm>
        extends BlockByImageSmartView {

    @Nonnull
    F getForm();

    @Override
    @Nonnull
    default Component getContentContainer() {
        return getForm();
    }

    @Nonnull
    @Override
    @SuppressWarnings("unchecked")
    default <T extends Component & BlockSmartComponent> T getBlockContainer() {
        return (T) getForm();
    }

}
