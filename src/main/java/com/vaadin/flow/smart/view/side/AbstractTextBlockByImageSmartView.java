package com.vaadin.flow.smart.view.side;

import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.smart.component.textblock.DefaultTextBlockSmartComponent;
import jakarta.annotation.Nonnull;
import lombok.Getter;

public abstract class AbstractTextBlockByImageSmartView<C extends FlexLayout>
        extends AbstractSideByImageSmartView<C>
        implements TextBlockByImageSmartView {

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final DefaultTextBlockSmartComponent textBlockContainer = initTextBlockContainer();

    @Nonnull
    protected DefaultTextBlockSmartComponent initTextBlockContainer() {
        var component = new DefaultTextBlockSmartComponent();
        component.setId("side-by-image-smart-view-content-container");
        return component;
    }

}
