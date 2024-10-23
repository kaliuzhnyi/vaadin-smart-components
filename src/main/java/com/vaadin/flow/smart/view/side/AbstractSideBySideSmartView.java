package com.vaadin.flow.smart.view.side;

import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.smart.view.base.AbstractBaseSmartView;
import jakarta.annotation.Nonnull;
import lombok.Getter;

public abstract class AbstractSideBySideSmartView<C extends FlexLayout>
        extends AbstractBaseSmartView<C>
        implements SideBySideSmartView {

    public static double DEFAULT_WIDTH_TO_CHANGE_FLEX_DIRECTION = 800;

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final FlexLayout primarySide = initPrimarySide();

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final FlexLayout secondarySide = initSecondarySide();

    @Override
    public double getWidthToChangeFlexDirection() {
        return DEFAULT_WIDTH_TO_CHANGE_FLEX_DIRECTION;
    }

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

    @Override
    public void adjustBodyLayoutForScreen() {
        SideBySideSmartView.super.adjustBodyLayoutForScreen();
        getBodyLayout().setFlexDirection(determinateFlexDirection());
    }

    @Nonnull
    protected FlexLayout initPrimarySide() {
        var side = new FlexLayout();
        side.setId("side-by-side-smart-view-primary-side");
        side.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        side.setSizeFull();
        side.setWidth("50%");
        side.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        side.setAlignItems(FlexComponent.Alignment.END);
        return side;
    }

    @Override
    public void adjustPrimarySideForScreen() {
        SideBySideSmartView.super.adjustPrimarySideForScreen();
        getPrimarySide().setAlignItems(isFlexDirectionRow()
                ? FlexComponent.Alignment.END
                : FlexComponent.Alignment.START);
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

    @Override
    public final boolean isFlexDirectionRow() {
        return SideBySideSmartView.super.isFlexDirectionRow();
    }

    @Override
    public final boolean isFlexDirectionColumn() {
        return SideBySideSmartView.super.isFlexDirectionColumn();
    }
}
