package com.vaadin.flow.smart.view.side.signup;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.smart.component.block.BlockSmartComponent;
import com.vaadin.flow.smart.component.form.signup.SignUpSmartForm;
import com.vaadin.flow.smart.view.side.block.BlockByImageSmartView;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

@SuppressWarnings("rawtypes")
public interface SignUpFormByImageSmartView<F extends Component & SignUpSmartForm>
        extends BlockByImageSmartView {

    @Nonnull
    F getForm();

    @Nullable
    Button getButtonSignIn();

    @Nullable
    default <T extends Component> Class<T> getButtonSignInTarget() {
        return null;
    }

    @Nonnull
    @Override
    @SuppressWarnings("unchecked")
    default <T extends Component & BlockSmartComponent> T getBlockContainer() {
        return (T) getForm();
    }

}
