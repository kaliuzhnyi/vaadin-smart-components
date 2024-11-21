package com.vaadin.flow.smart.component.form.signup;

import com.vaadin.flow.component.ClickEvent;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import java.util.function.Predicate;

public class DefaultSignUpSmartForm
        extends AbstractSignUpSmartForm {

    @Override
    protected void handleEventSignUp(@Nonnull ClickEvent<?> clickEvent) {
    }

    @Nullable
    @Override
    public Predicate<String> getEmailExistProvider() {
        return s -> true;
    }
}
