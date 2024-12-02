package com.vaadin.flow.smart.layout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.smart.component.AdjustableForScreen;
import com.vaadin.flow.smart.component.HasDeviceInfo;
import com.vaadin.flow.smart.component.HasScreenInfo;
import com.vaadin.flow.smart.component.navigationmenu.NavigationMenuSmartComponent;
import com.vaadin.flow.smart.data.DeviceInfo;
import com.vaadin.flow.smart.data.ScreenInfo;
import com.vaadin.flow.smart.view.base.BaseSmartView;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import java.util.Optional;

public interface SmartAppLayout
        extends HasScreenInfo, HasDeviceInfo, AdjustableForScreen {

    @Nonnull
    <T extends Component> T getView();

    @Nonnull
    <T extends FlexLayout> T getNavbarWrapper();

    @Nullable
    <T extends Component> T getNavbarMenu();

    @Nonnull
    @SuppressWarnings("unchecked")
    default <T extends Component> Class<T> getViewClass() {
        return (Class<T>) getView().getClass();
    }

    @Nonnull
    default String getViewTitle() {

        var view = getView();
        var cls = getViewClass();

        // If implements BaseSmartView
        if (BaseSmartView.class.isAssignableFrom(cls)) {
            return ((BaseSmartView) view).getViewTitle();
        }

        // If class has annotation @PageTitle
        if (cls.isAnnotationPresent(PageTitle.class)) {
            var annotation = cls.getAnnotation(PageTitle.class);
            return annotation.value();
        }

        // If implements HasDynamicTitle
        if (HasDynamicTitle.class.isAssignableFrom(cls)) {
            return ((HasDynamicTitle) view).getPageTitle();
        }

        return "";
    }

    @Override
    @Nullable
    default ScreenInfo getScreenInfo() {
        return Optional.of(getView())
                .filter(v -> v instanceof HasScreenInfo)
                .map(v -> ((HasScreenInfo) v).getScreenInfo())
                .orElse(null);
    }

    @Override
    @Nullable
    default DeviceInfo getDeviceInfo() {
        return Optional.of(getView())
                .filter(v -> v instanceof HasDeviceInfo)
                .map(v -> ((HasDeviceInfo) v).getDeviceInfo())
                .orElse(null);
    }

    @Override
    @SuppressWarnings("rawtypes")
    default void adjustForScreen() {
        adjustAppLayoutForScreen();
        Optional.ofNullable(getNavbarMenu())
                .filter(m -> m instanceof NavigationMenuSmartComponent)
                .map(m -> (NavigationMenuSmartComponent) m)
                .ifPresent(NavigationMenuSmartComponent::adjustForScreen);
    }

    default void adjustAppLayoutForScreen() {
        // Do nothing here
        // It's just stub method
        // This method is only for overriding
    }

}
