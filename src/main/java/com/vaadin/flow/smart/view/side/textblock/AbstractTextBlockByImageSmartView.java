package com.vaadin.flow.smart.view.side.textblock;

import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.smart.component.textblock.DefaultTextBlockSmartComponent;
import com.vaadin.flow.smart.view.side.AbstractSideByImageSmartView;
import com.vaadin.flow.theme.lumo.LumoUtility;
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
        component.setId("text-block-by-image-smart-view-text-block-container");
        component.addClassNames(LumoUtility.Margin.LARGE);
        return component;
    }

}
