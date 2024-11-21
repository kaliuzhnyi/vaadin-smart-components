package com.vaadin.flow.smart.view.side.signin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.smart.component.form.signin.SignInSmartForm;
import com.vaadin.flow.smart.view.side.SideByImageSmartView;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

@SuppressWarnings("rawtypes")
public interface SignInFormByImageSmartView<F extends Component & SignInSmartForm>
        extends SideByImageSmartView {

    @Nonnull
    F getForm();

    @Nullable
    Button getButtonSignUp();

    @Nullable
    default <T extends Component> Class<T> getButtonSignUpTarget() {
        return null;
    }

    @Override
    @Nonnull
    default Component getContentContainer() {
        return getForm();
    }
}
