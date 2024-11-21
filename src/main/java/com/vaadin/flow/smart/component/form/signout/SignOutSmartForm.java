package com.vaadin.flow.smart.component.form.signout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.smart.component.form.SmartForm;
import jakarta.annotation.Nonnull;

public interface SignOutSmartForm<C extends FormLayout>
        extends SmartForm<C> {

    @Override
    @Nonnull
    C getContent();

    @Nonnull
    <T extends Component & HasText> T getComponentTitle();

    @Nonnull
    Button getButtonSignOut();

}
