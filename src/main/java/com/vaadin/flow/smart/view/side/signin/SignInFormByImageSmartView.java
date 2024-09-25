package com.vaadin.flow.smart.view.side.signin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.smart.view.side.SideByImageSmartView;
import jakarta.annotation.Nonnull;

public interface SignInFormByImageSmartView
        extends SideByImageSmartView {

    @Nonnull
    <T extends LoginForm> T getForm();

    @Override
    @Nonnull
    default Component getContentContainer() {
        return getForm();
    }
}
