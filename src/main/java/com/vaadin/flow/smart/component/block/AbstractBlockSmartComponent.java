package com.vaadin.flow.smart.component.block;

import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.smart.component.AbstractSmartComponent;
import jakarta.annotation.Nonnull;

public abstract class AbstractBlockSmartComponent<C extends FlexLayout>
        extends AbstractSmartComponent<C>
        implements BlockSmartComponent<C> {

    @Override
    @Nonnull
    protected C initContent() {
        var content = super.initContent();
        content.setId("smart-component-block-content");
        content.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        content.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        content.setAlignItems(FlexComponent.Alignment.START);
        return content;
    }

}
