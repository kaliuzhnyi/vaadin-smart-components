package com.vaadin.flow.smart.view.base;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.smart.view.AbstractSmartView;
import jakarta.annotation.Nonnull;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

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
    public void adjustViewForScreen() {
        BaseSmartView.super.adjustViewForScreen();
        processEmptyComponents();
    }

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

    protected boolean isHideEmptyComponents() {
        return true;
    }

    private void processEmptyComponents() {
        if (isHideEmptyComponents()) {
            hideEmptyComponents(getContent());
        }
    }

    private <T extends Component> void hideEmptyComponents(T componet) {

        if ((HasText.class.isAssignableFrom(componet.getClass()) && StringUtils.isEmpty(((HasText) componet).getText()))
                && (Image.class.isAssignableFrom(componet.getClass()) && StringUtils.isEmpty(((Image) componet).getSrc()))
                && componet.getChildren().findAny().isEmpty()) {
            componet.setVisible(false);
            return;
        }

        componet.getChildren().forEach(this::hideEmptyComponents);

    }

}
