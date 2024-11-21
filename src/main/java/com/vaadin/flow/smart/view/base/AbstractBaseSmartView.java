package com.vaadin.flow.smart.view.base;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.textfield.TextFieldBase;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.smart.component.navigationmenu.NavigationMenuSmartComponent;
import com.vaadin.flow.smart.layout.SmartAppLayout;
import com.vaadin.flow.smart.view.AbstractSmartView;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public abstract class AbstractBaseSmartView<C extends FlexLayout>
        extends AbstractSmartView<C>
        implements BaseSmartView {

    @Getter(onMethod_ = {@Override, @Nullable})
    @Setter(onMethod_ = {@Override}, onParam_ = {@Nullable})
    private RouterLayout appLayout;

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final FlexLayout headerLayout = initHeaderLayout();

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final FlexLayout bodyLayout = initBodyLayout();

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final FlexLayout footerLayout = initFooterLayout();

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        super.afterNavigation(event);

        // Highlight current view in menu
        Optional.ofNullable(getAppLayout())
                .filter(l -> l instanceof SmartAppLayout)
                .map(l -> ((SmartAppLayout) l).getNavbarMenu())
                .filter(m -> m instanceof NavigationMenuSmartComponent<?>)
                .map(m -> (NavigationMenuSmartComponent<?>) m)
                .ifPresent(m -> m.highlightItem(this.getClass()));
    }

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
        componet.getChildren().forEach(this::hideEmptyComponents);
        if (isComponentEmpty(componet)) {
            componet.setVisible(false);
        }
    }

    private <T extends Component> boolean isComponentEmpty(T component) {
        var componentClass = component.getClass();

        if (LoginForm.class.isAssignableFrom(componentClass)
                || FormLayout.class.isAssignableFrom(componentClass)
                || TextFieldBase.class.isAssignableFrom(componentClass)) {
            return false;
        }

        if (Image.class.isAssignableFrom(componentClass)) {
            return StringUtils.isEmpty(((Image) component).getSrc())
                    && (component.getChildren().findAny().isEmpty()
                    || component.getChildren().noneMatch(Component::isVisible));
        }

        if (HasText.class.isAssignableFrom(componentClass)) {
            return StringUtils.isEmpty(((HasText) component).getText())
                    && (component.getChildren().findAny().isEmpty()
                    || component.getChildren().noneMatch(Component::isVisible));
        }

        return component.getChildren().findAny().isEmpty()
                || component.getChildren().noneMatch(Component::isVisible);

    }

}
