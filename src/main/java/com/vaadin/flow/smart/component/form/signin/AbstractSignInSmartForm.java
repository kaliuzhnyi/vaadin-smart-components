package com.vaadin.flow.smart.component.form.signin;

import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.smart.component.AbstractSmartComponent;
import com.vaadin.flow.theme.lumo.LumoUtility;

public abstract class AbstractSignInSmartForm
        extends AbstractSmartComponent<LoginForm>
        implements SignInSmartForm<LoginForm> {

    @Override
    protected LoginForm initContent() {
        var content = super.initContent();
        content.getStyle().setWidth(HasSize.getCssSize(DEFAULT_CONTENT_WIDTH_VALUE, DEFAULT_CONTENT_WIDTH_UNIT));
        content.setAction("login");
        return content;
    }
}
