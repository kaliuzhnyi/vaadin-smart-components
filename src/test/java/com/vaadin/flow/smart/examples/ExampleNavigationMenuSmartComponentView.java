package com.vaadin.flow.smart.examples;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.smart.view.base.AbstractBaseSmartView;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.Nonnull;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("ExampleNavigationMenuSmartComponentView")
@Route(value = "example/base-smart-view-with-navigation-menu-smart-component")
@AnonymousAllowed
@SuppressWarnings("unused")
public class ExampleNavigationMenuSmartComponentView
        extends AbstractBaseSmartView<FlexLayout> {

    @Autowired
    @Getter(AccessLevel.PRIVATE)
    private ExampleNavigationMenuSmartComponent menu;

    @Nonnull
    @Override
    protected FlexLayout initHeaderLayout() {
        var layout = super.initHeaderLayout();
        layout.addClassNames(
                LumoUtility.Background.CONTRAST_5
        );
        layout.add(
                getMenu()
        );
        return layout;
    }

    @Nonnull
    @Override
    protected FlexLayout initBodyLayout() {
        var layout = super.initBodyLayout();
        layout.addClassNames(
                LumoUtility.Background.CONTRAST_10
        );
        var text = new Span("BodyLayout");
        layout.add(text);
        return layout;
    }

    @Nonnull
    @Override
    protected FlexLayout initFooterLayout() {
        var layout = super.initFooterLayout();
        layout.addClassNames(
                LumoUtility.Background.CONTRAST_5
        );
        var text = new Span("FooterLayout");
        layout.add(text);
        return layout;
    }

}
