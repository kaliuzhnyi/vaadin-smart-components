package com.vaadin.flow.smart.examples.view;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.smart.examples.layout.ExampleLayoutSmartAppLayout;
import com.vaadin.flow.smart.view.base.AbstractBaseSmartView;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.Nonnull;

@PageTitle("ExampleNavigationMenuSmartComponentView")
@Route(value = "example/base-smart-view-with-navigation-menu-smart-component", layout = ExampleLayoutSmartAppLayout.class)
@AnonymousAllowed
@SuppressWarnings("unused")
public class ExampleNavigationMenuSmartComponentView
        extends AbstractBaseSmartView<FlexLayout> {

    @Nonnull
    @Override
    protected FlexLayout initHeaderLayout() {
        var layout = super.initHeaderLayout();
        layout.addClassNames(
                LumoUtility.Background.CONTRAST_5
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
