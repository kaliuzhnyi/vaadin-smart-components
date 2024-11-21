package com.vaadin.flow.smart.component.block;

import com.vaadin.flow.component.Component;
import jakarta.annotation.Nonnull;

public interface BlockSmartComponent<C extends Component> {

    @Nonnull
    C getContent();

}
