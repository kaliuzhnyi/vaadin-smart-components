package com.vaadin.flow.smart.component.form;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import jakarta.annotation.Nonnull;

public interface SmartForm<C extends Component> {

    float DEFAULT_CONTENT_WIDTH_VALUE = 50;
    Unit DEFAULT_CONTENT_WIDTH_UNIT = Unit.PERCENTAGE;

    @Nonnull
    C getContent();

}
