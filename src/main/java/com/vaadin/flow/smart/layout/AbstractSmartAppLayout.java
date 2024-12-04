package com.vaadin.flow.smart.layout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.annotation.PostConstruct;
import lombok.Getter;

import java.util.Optional;

@SuppressWarnings({"unchecked"})
public abstract class AbstractSmartAppLayout
        extends AppLayout
        implements SmartAppLayout {

    @Getter(onMethod_ = {@Override, @Nullable}, lazy = true)
    private final FlexLayout navbarWrapper = initNavbarWrapper();

    @Getter(onMethod_ = {@Nonnull}, lazy = true)
    private final FlexLayout navbarLeftWrapper = initNavbarLeftWrapper();

    @Getter(onMethod_ = {@Nonnull}, lazy = true)
    private final FlexLayout navbarCenterWrapper = initNavbarCenterWrapper();

    @Getter(onMethod_ = {@Nonnull}, lazy = true)
    private final FlexLayout navbarRightWrapper = initNavbarRightWrapper();

    @Getter(onMethod_ = {@Override, @Nullable}, lazy = true)
    private final FlexLayout drawerWrapper = initDrawerWrapper();

    @Getter(onMethod_ = {@Nonnull}, lazy = true)
    private final Header drawerHeader = initDrawerHeader();

    @Getter(onMethod_ = {@Nonnull}, lazy = true)
    private final Scroller drawerScroller = initDrawerScroller();

    @Getter(onMethod_ = {@Nonnull}, lazy = true)
    private final Footer drawerFooter = initDrawerFooter();

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        Optional.ofNullable(getContent())
                .filter(c -> c instanceof SmartAppLayoutAware)
                .ifPresent(c -> ((SmartAppLayoutAware) c).setAppLayout(this));
        Optional.ofNullable(getNavbarMenu())
                .filter(m -> m instanceof SmartAppLayoutAware)
                .ifPresent(m -> ((SmartAppLayoutAware) m).setAppLayout(this));
    }

    @PostConstruct
    protected void init() {
        setPrimarySection(Section.DRAWER);
        initNavbar();
        initDrawer();
    }

    protected void initNavbar() {
        Optional.ofNullable(getNavbarWrapper())
                .ifPresent(w -> addToNavbar(false, w));
    }

    protected void initDrawer() {
        Optional.ofNullable(getDrawerWrapper())
                .ifPresent(this::addToDrawer);
    }

    @Nonnull
    protected FlexLayout initNavbarWrapper() {
        var wrapper = new FlexLayout();
        wrapper.setSizeFull();
        wrapper.setFlexDirection(FlexLayout.FlexDirection.ROW);
        wrapper.add(
                getNavbarLeftWrapper(),
                getNavbarCenterWrapper(),
                getNavbarRightWrapper()
        );
        wrapper.setFlexGrow(1, getNavbarLeftWrapper());
        wrapper.setFlexGrow(2, getNavbarCenterWrapper());
        wrapper.setFlexGrow(1, getNavbarRightWrapper());
        return wrapper;
    }

    @Nonnull
    protected FlexLayout initNavbarLeftWrapper() {
        var wrapper = new FlexLayout();
        wrapper.setSizeFull();
        wrapper.setFlexDirection(FlexLayout.FlexDirection.ROW);
        wrapper.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        wrapper.setAlignItems(FlexComponent.Alignment.CENTER);
        return wrapper;
    }

    @Nonnull
    protected FlexLayout initNavbarCenterWrapper() {
        var wrapper = new FlexLayout();
        wrapper.setSizeFull();
        wrapper.setFlexDirection(FlexLayout.FlexDirection.ROW);
        wrapper.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        wrapper.setAlignItems(FlexComponent.Alignment.CENTER);

        Optional.ofNullable(getNavbarMenu())
                .map(m -> (Component) m)
                .ifPresent(wrapper::add);

        return wrapper;
    }

    @Nonnull
    protected FlexLayout initNavbarRightWrapper() {
        var wrapper = new FlexLayout();
        wrapper.setSizeFull();
        wrapper.setFlexDirection(FlexLayout.FlexDirection.ROW);
        wrapper.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        wrapper.setAlignItems(FlexComponent.Alignment.CENTER);
        return wrapper;
    }

    @Nonnull
    protected FlexLayout initDrawerWrapper() {
        var wrapper = new FlexLayout();
        wrapper.setSizeFull();
        wrapper.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        wrapper.add(
                getDrawerHeader(),
                getDrawerScroller(),
                getDrawerFooter()
        );
        return wrapper;
    }

    @Nonnull
    protected Header initDrawerHeader() {
        var component = new Header();
        component.addClassNames(LumoUtility.Margin.Horizontal.MEDIUM);
        return component;
    }

    @Nonnull
    protected Scroller initDrawerScroller() {
        var component = new Scroller();
        component.addClassNames(LumoUtility.Margin.MEDIUM);
        component.setHeightFull();
        return component;
    }

    @Nonnull
    protected Footer initDrawerFooter() {
        var component = new Footer();
        component.addClassNames(LumoUtility.Margin.Horizontal.MEDIUM);
        return component;
    }

    @Override
    @Nonnull
    public <T extends Component> T getView() {
        return (T) getContent();
    }

    @Override
    @Nullable
    public <T extends Component> T getNavbarMenu() {
        return null;
    }
}
