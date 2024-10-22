package com.vaadin.flow.smart.component.navigationmenu;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.RouteParameters;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.smart.view.side.AbstractSideBySideSmartView;
import com.vaadin.flow.theme.lumo.LumoIcon;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractNavigationMenuSmartComponent
        extends Composite<FlexLayout>
        implements NavigationMenuSmartComponent<FlexLayout> {

    @Getter(onMethod_ = {@Override, @Nullable})
    @Setter(onMethod_ = {@Override}, onParam_ = {@Nullable})
    private RouterLayout appLayout;

    @Getter(value = AccessLevel.PROTECTED, onMethod_ = {@Nonnull})
    private final LinkedHashMap<MenuItem, Class<? extends Component>> mainMenuItemsMap = new LinkedHashMap<>();

    @Getter(value = AccessLevel.PROTECTED, onMethod_ = {@Nonnull})
    private final LinkedHashMap<MenuItem, Class<? extends Component>> dropDownMenuItemsMap = new LinkedHashMap<>();

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final MenuBar mainMenu = initMainMenu();

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final MenuBar dropDownMenu = initDropDownMenu();

    @Getter(value = AccessLevel.PROTECTED, onMethod_ = {@Nonnull}, lazy = true)
    private final MenuItem dropDownMenuToggleItem = initDropDownMenuToggleItem();

    @Override
    @Nonnull
    public FlexLayout getContent() {
        return super.getContent();
    }

    @Override
    @Nonnull
    protected FlexLayout initContent() {
        var content = super.initContent();
        content.setId("smart-component-navigationmenu-container");
        content.setFlexDirection(FlexLayout.FlexDirection.ROW);
        content.setWidthFull();
        content.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        content.setAlignItems(FlexComponent.Alignment.CENTER);
        content.add(
                getMainMenu(),
                getDropDownMenu()
        );
        return content;
    }

    @Nonnull
    protected MenuBar initMainMenu() {
        var menu = new MenuBar();
        menu.setId("smart-component-navigationmenu-main-menu");
        menu.setVisible(false);
        menu.addThemeVariants(
                MenuBarVariant.LUMO_TERTIARY
        );
        return menu;
    }

    @Nonnull
    protected MenuBar initDropDownMenu() {
        var menu = new MenuBar();
        menu.setId("smart-component-navigationmenu-drop-down-menu");
        menu.setVisible(false);
        menu.addThemeVariants(
                MenuBarVariant.LUMO_TERTIARY
        );
        return menu;
    }

    @Nonnull
    protected MenuItem initDropDownMenuToggleItem() {
        return getDropDownMenu().addItem(LumoIcon.MENU.create());
    }

    @Nonnull
    public MenuItem addItem(@Nonnull String title,
                            @Nonnull Class<? extends Component> viewClass,
                            @Nonnull RouteParameters routeParameters) {

        //
        var mainMenuRouteLink = new RouterLink();
        mainMenuRouteLink.setText(title);
        mainMenuRouteLink.setRoute(viewClass, routeParameters);

        var mainMenuItem = getMainMenu().addItem(mainMenuRouteLink);
        mainMenuItem.addClassNames(
                LumoUtility.Margin.Horizontal.SMALL
        );
        mainMenuItemsMap.put(mainMenuItem, viewClass);

        //
        var dropDownMenuRouteLink = new RouterLink();
        dropDownMenuRouteLink.setText(title);
        dropDownMenuRouteLink.setRoute(viewClass, routeParameters);

        var dropDownMenuItem = getDropDownMenuToggleItem().getSubMenu().addItem(dropDownMenuRouteLink);
        dropDownMenuItem.addClassNames(
                LumoUtility.Margin.Horizontal.SMALL
        );
        dropDownMenuItemsMap.put(dropDownMenuItem, viewClass);

        return mainMenuItem;
    }

    @Override
    public void highlightItem(@Nonnull Class<? extends Component> viewClass) {
        highlightMenuItem(getMainMenuItemsMap(), viewClass);
        highlightMenuItem(getDropDownMenuItemsMap(), viewClass);
    }

    private void highlightMenuItem(@Nonnull Map<MenuItem, Class<? extends Component>> menuItemsMap,
                                   @Nonnull Class<? extends Component> viewClass) {

        var classNamesForMenuItem = new String[]{
                LumoUtility.Background.PRIMARY
        };
        var classNamesForRouterLink = new String[]{
                LumoUtility.TextColor.PRIMARY_CONTRAST
        };

        menuItemsMap.entrySet().stream()
                .peek(e -> {
                    e.getKey().removeClassNames(classNamesForMenuItem);
                    e.getKey().getChildren()
                            .filter(child -> child instanceof RouterLink)
                            .forEach(routerLink -> routerLink.removeClassNames(classNamesForRouterLink));
                })
                .filter(e -> e.getValue().equals(viewClass))
                .map(Map.Entry::getKey)
                .forEach(item -> {
                    item.addClassNames(classNamesForMenuItem);
                    item.getChildren()
                            .filter(child -> child instanceof RouterLink)
                            .forEach(routerLink -> routerLink.addClassNames(classNamesForRouterLink));
                });
    }

    @Override
    public void adjustNavigationMenuForScreen() {
        NavigationMenuSmartComponent.super.adjustNavigationMenuForScreen();
        Optional.ofNullable(getScreenInfo())
                .ifPresent(info -> {
                    if (info.getWindowWidth() >= AbstractSideBySideSmartView.DEFAULT_WIDTH_TO_CHANGE_FLEX_DIRECTION) {
                        getMainMenu().setVisible(true);
                        getDropDownMenu().setVisible(false);
                    } else {
                        getMainMenu().setVisible(false);
                        getDropDownMenu().setVisible(true);
                    }
                });
    }
}
