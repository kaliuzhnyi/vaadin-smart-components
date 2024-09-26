package com.vaadin.flow.smart.examples;

import com.vaadin.flow.smart.component.textblock.DefaultTextBlockSmartComponent;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SuppressWarnings("unused")
public class ExampleTextBlockSmartComponent
        extends DefaultTextBlockSmartComponent {

    @Nullable
    @Override
    protected String getTitleComponentText() {
        return "Title";
    }

    @Nullable
    @Override
    protected String getTextComponentText() {
        return "Text";
    }

    @Nullable
    @Override
    protected String getRemarkComponentText() {
        return "Remark";
    }
}
