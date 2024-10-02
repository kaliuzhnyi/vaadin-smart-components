package com.vaadin.flow.smart.component.block;

import com.vaadin.flow.component.orderedlayout.FlexLayout;
import jakarta.annotation.Nonnull;

public interface BlockSmartComponent<C extends FlexLayout> {

    @Nonnull
    C getContent();

}
