package com.vaadin.flow.smart.view.base;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.smart.component.AdjustableForScreen;
import com.vaadin.flow.smart.layout.SmartAppLayoutAware;
import com.vaadin.flow.smart.view.SmartView;
import jakarta.annotation.Nonnull;

import java.util.Optional;

public interface BaseSmartView
        extends SmartView, SmartAppLayoutAware {

    @Nonnull
    <T extends Component & FlexComponent & HasSize> T getHeaderLayout();

    @Nonnull
    <T extends Component & FlexComponent & HasSize> T getBodyLayout();

    @Nonnull
    <T extends Component & FlexComponent & HasSize> T getFooterLayout();

    @Override
    default void adjustViewForScreen() {
        adjustHeaderLayoutForScreen();
        adjustBodyLayoutForScreen();
        adjustFooterLayoutForScreen();

        Optional.ofNullable(getAppLayout())
                .map(l -> (AdjustableForScreen) l)
                .ifPresent(AdjustableForScreen::adjustForScreen);

    }

    default void adjustHeaderLayoutForScreen() {
        // Do nothing here
        // It's just stub method
        // This method is only for overriding
    }

    default void adjustBodyLayoutForScreen() {
        // Do nothing here
        // It's just stub method
        // This method is only for overriding
    }

    default void adjustFooterLayoutForScreen() {
        // Do nothing here
        // It's just stub method
        // This method is only for overriding
    }

    @Nonnull
    default String getViewTitle() {

        var cls = getClass();

        // If class has annotation @PageTitle
        if (cls.isAnnotationPresent(PageTitle.class)) {
            var annotation = cls.getAnnotation(PageTitle.class);
            return annotation.value();
        }

        // If implements HasDynamicTitle
        if (HasDynamicTitle.class.isAssignableFrom(cls)) {
            return ((HasDynamicTitle) this).getPageTitle();
        }

        return "";

    }

    default void updateViewTitle() {
        UI.getCurrent().getPage().setTitle(getViewTitle());
    }

}
