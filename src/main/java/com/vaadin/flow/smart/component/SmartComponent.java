package com.vaadin.flow.smart.component;

import com.vaadin.flow.component.Component;
import jakarta.annotation.Nonnull;

public interface SmartComponent<C extends Component> {

    @Nonnull
    C getContent();

}
