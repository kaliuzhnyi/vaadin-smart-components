package com.vaadin.flow.smart.view.side.signin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.smart.component.block.BlockSmartComponent;
import com.vaadin.flow.smart.component.form.signin.SignInSmartForm;
import com.vaadin.flow.smart.view.side.block.BlockByImageSmartView;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

@SuppressWarnings("rawtypes")
public interface SignInFormByImageSmartView<F extends Component & SignInSmartForm>
        extends BlockByImageSmartView {

    @Nonnull
    F getForm();

    @Nullable
    Button getButtonSignUp();

    @Nullable
    default <T extends Component> Class<T> getButtonSignUpTarget() {
        return null;
    }

    @Nonnull
    @Override
    @SuppressWarnings("unchecked")
    default <T extends Component & BlockSmartComponent> T getBlockContainer() {
        return (T) getForm();
    }

}
