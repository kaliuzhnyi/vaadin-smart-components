package com.vaadin.flow.component.smart.view.side;

import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.smart.view.base.AbstractBaseSmartView;
import jakarta.annotation.Nonnull;
import lombok.Getter;

public abstract class AbstractSideBySideSmartView<C extends FlexLayout>
        extends AbstractBaseSmartView<C>
        implements SideBySideSmartView {

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final FlexLayout primarySide = initPrimarySide();

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final FlexLayout secondarySide = initSecondarySide();

    @Nonnull
    @Override
    protected FlexLayout initBodyLayout() {
        var layout = super.initBodyLayout();
        layout.setFlexDirection(FlexLayout.FlexDirection.ROW);
        layout.add(
                getPrimarySide(),
                getSecondarySide()
        );
        return layout;
    }

    @Nonnull
    protected FlexLayout initPrimarySide() {
        var side = new FlexLayout();
        side.setId("side-by-side-smart-view-primary-side");
        side.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        side.setSizeFull();
        side.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        side.setAlignItems(FlexComponent.Alignment.END);
        return side;
    }

    @Nonnull
    protected FlexLayout initSecondarySide() {
        var side = new FlexLayout();
        side.setId("side-by-side-smart-view-secondary-side");
        side.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        side.setSizeFull();
        side.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        side.setAlignItems(FlexComponent.Alignment.START);
        return side;
    }

}
