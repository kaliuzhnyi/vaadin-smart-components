package com.vaadin.flow.smart.component.form.signin;

import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.smart.component.form.SmartForm;
import jakarta.annotation.Nonnull;

public interface SignInSmartForm<C extends LoginForm>
        extends SmartForm<C> {

    @Override
    @Nonnull
    C getContent();

}
