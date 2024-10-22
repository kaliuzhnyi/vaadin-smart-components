package com.vaadin.flow.smart.component.navigationmenu;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.RouteParameters;
import com.vaadin.flow.smart.component.AdjustableForScreen;
import com.vaadin.flow.smart.component.HasDeviceInfo;
import com.vaadin.flow.smart.component.HasScreenInfo;
import com.vaadin.flow.smart.data.DeviceInfo;
import com.vaadin.flow.smart.data.ScreenInfo;
import com.vaadin.flow.smart.layout.SmartAppLayoutAware;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import java.util.Optional;

public interface NavigationMenuSmartComponent<C extends FlexLayout>
        extends HasScreenInfo, HasDeviceInfo, AdjustableForScreen, SmartAppLayoutAware {

    @Nonnull
    C getContent();

    @Nonnull
    MenuBar getMainMenu();

    @Nonnull
    MenuBar getDropDownMenu();

    @Nonnull
    MenuItem addItem(@Nonnull String title, @Nonnull Class<? extends Component> viewClass, @Nonnull RouteParameters routeParameters);

    @Nonnull
    default MenuItem addItem(@Nonnull String title, @Nonnull Class<? extends Component> viewClass) {
        return addItem(title, viewClass, RouteParameters.empty());
    }

    void highlightItem(@Nonnull Class<? extends Component> viewClass);

    @Override
    default void adjustForScreen() {
        adjustNavigationMenuForScreen();
    }

    default void adjustNavigationMenuForScreen() {
        // Do nothing here
        // It's just stub method
        // This method is only for overriding
    }

    @Override
    @Nullable
    default DeviceInfo getDeviceInfo() {
        return Optional.ofNullable(getAppLayout())
                .map(l -> ((HasDeviceInfo) l).getDeviceInfo())
                .orElse(null);
    }

    @Override
    @Nullable
    default ScreenInfo getScreenInfo() {
        return Optional.ofNullable(getAppLayout())
                .map(l -> ((HasScreenInfo) l).getScreenInfo())
                .orElse(null);
    }
}
