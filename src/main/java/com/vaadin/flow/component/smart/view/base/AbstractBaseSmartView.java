package com.vaadin.flow.component.smart.view.base;

import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.smart.view.AbstractSmartView;
import jakarta.annotation.Nonnull;
import lombok.Getter;

public abstract class AbstractBaseSmartView<C extends FlexLayout>
        extends AbstractSmartView<C>
        implements BaseSmartView {

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final FlexLayout headerLayout = initHeaderLayout();

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final FlexLayout bodyLayout = initBodyLayout();

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final FlexLayout footerLayout = initFooterLayout();

    @Override
    protected C initContent() {
        var content = super.initContent();
        content.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        content.add(
                getHeaderLayout(),
                getBodyLayout(),
                getFooterLayout()
        );
        return content;
    }

    @Nonnull
    protected FlexLayout initHeaderLayout() {
        var layout = new FlexLayout();
        layout.setId("base-smart-view-header-layout");
        layout.setFlexDirection(FlexLayout.FlexDirection.ROW);
        layout.setWidthFull();
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        return layout;
    }

    @Nonnull
    protected FlexLayout initBodyLayout() {
        var layout = new FlexLayout();
        layout.setId("base-smart-view-body-layout");
        layout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        layout.setSizeFull();
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        return layout;
    }

    @Nonnull
    protected FlexLayout initFooterLayout() {
        var layout = new FlexLayout();
        layout.setId("base-smart-view-footer-layout");
        layout.setFlexDirection(FlexLayout.FlexDirection.ROW);
        layout.setWidthFull();
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        return layout;
    }

}
