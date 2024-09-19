package com.vaadin.flow.component.smart.view.base;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.Nonnull;

@PageTitle("ExampleBaseSmartView")
@Route(value = "example/base-smart-view")
@AnonymousAllowed
@SuppressWarnings("unused")
public class ExampleBaseSmartView
        extends AbstractBaseSmartView<FlexLayout> {

    @Nonnull
    @Override
    protected FlexLayout initHeaderLayout() {
        var layout = super.initHeaderLayout();
        layout.addClassNames(
                LumoUtility.Background.CONTRAST_5
        );
        layout.add(new Span("HeaderLayout"));
        return layout;
    }

    @Nonnull
    @Override
    protected FlexLayout initBodyLayout() {
        var layout = super.initBodyLayout();
        layout.addClassNames(
                LumoUtility.Background.CONTRAST_10
        );
        layout.add(new Span("BodyLayout"));
        return layout;
    }

    @Nonnull
    @Override
    protected FlexLayout initFooterLayout() {
        var layout = super.initFooterLayout();
        layout.addClassNames(
                LumoUtility.Background.CONTRAST_5
        );
        layout.add(new Span("FooterLayout"));
        return layout;
    }
}
