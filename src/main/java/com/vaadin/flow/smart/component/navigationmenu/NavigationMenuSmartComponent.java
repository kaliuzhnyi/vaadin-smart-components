package com.vaadin.flow.smart.component.navigationmenu;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.router.RouteParameters;
import jakarta.annotation.Nonnull;

public interface NavigationMenuSmartComponent<C extends MenuBar> {

    @Nonnull
    C getContent();

    @Nonnull
    MenuItem addItem(@Nonnull String title, @Nonnull Class<? extends Component> viewClass, @Nonnull RouteParameters routeParameters);

    @Nonnull
    default MenuItem addItem(@Nonnull String title, @Nonnull Class<? extends Component> viewClass) {
        return addItem(title, viewClass, RouteParameters.empty());
    }

    void highlightItem(@Nonnull Class<? extends Component> viewClass);

}
