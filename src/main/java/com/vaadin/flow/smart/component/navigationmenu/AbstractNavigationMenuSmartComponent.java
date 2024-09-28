package com.vaadin.flow.smart.component.navigationmenu;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.router.RouteParameters;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.Nonnull;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractNavigationMenuSmartComponent
        extends Composite<MenuBar>
        implements NavigationMenuSmartComponent<MenuBar> {

    @Getter(AccessLevel.PROTECTED)
    private final LinkedHashMap<MenuItem, Class<? extends Component>> itemsMap = new LinkedHashMap<>();

    @Override
    @Nonnull
    public MenuBar getContent() {
        return super.getContent();
    }

    @Override
    @Nonnull
    protected MenuBar initContent() {
        var content = super.initContent();
        content.setId("smart-component-navigationmenu-container");
        content.addThemeVariants(
                MenuBarVariant.LUMO_TERTIARY
        );
        return content;
    }

    @Nonnull
    public MenuItem addItem(@Nonnull String title,
                            @Nonnull Class<? extends Component> viewClass,
                            @Nonnull RouteParameters routeParameters) {
        var routeLink = new RouterLink();
        routeLink.setText(title);
        routeLink.setRoute(viewClass, routeParameters);

        var item = getContent().addItem(routeLink);
        item.addClassNames(
                LumoUtility.Margin.Horizontal.SMALL
        );

        itemsMap.put(item, viewClass);

        return item;
    }

    @Override
    public void highlightItem(@Nonnull Class<? extends Component> viewClass) {
        itemsMap.entrySet().stream()
                .filter(e -> e.getValue().equals(viewClass))
                .map(Map.Entry::getKey)
                .forEach(item -> {
                            item.addClassNames(LumoUtility.Background.PRIMARY);
                            item.getChildren()
                                    .filter(child -> child instanceof RouterLink)
                                    .forEach(routerLink -> routerLink.addClassNames(LumoUtility.TextColor.PRIMARY_CONTRAST));
                        }
                );
    }
}
