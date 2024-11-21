package com.vaadin.flow.smart.examples.form;

import com.vaadin.flow.smart.component.form.signout.DefaultSignOutSmartForm;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SuppressWarnings("unused")
public class ExampleSigOutSmartForm
        extends DefaultSignOutSmartForm {
}
