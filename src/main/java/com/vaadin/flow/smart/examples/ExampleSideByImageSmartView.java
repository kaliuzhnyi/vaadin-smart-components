package com.vaadin.flow.smart.examples;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.smart.view.side.AbstractSideByImageSmartView;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

@PageTitle("ExampleSideByImageSmartView")
@Route(value = "example/side-by-image-smart-view")
@AnonymousAllowed
@SuppressWarnings("unused")
public class ExampleSideByImageSmartView
        extends AbstractSideByImageSmartView<FlexLayout> {

    @Nonnull
    @Override
    protected FlexLayout initHeaderLayout() {
        var layout = super.initHeaderLayout();
        layout.addClassNames(
                LumoUtility.Background.CONTRAST_5
        );
        var text = new Span("HeaderLayout");
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

    @Nonnull
    @Override
    protected FlexLayout initPrimarySide() {
        var side = super.initPrimarySide();
        side.addClassNames(
                LumoUtility.Background.CONTRAST_30
        );
        return side;
    }

    @Nonnull
    @Override
    protected FlexLayout initSecondarySide() {
        var side = super.initSecondarySide();
        side.addClassNames(
                LumoUtility.Background.CONTRAST_20
        );
        return side;
    }

    @Nonnull
    @Override
    public Component getContentContainer() {
        var container = new Div();
        container.setText("ContentContainer");
        return container;
    }

    @Nonnull
    @Override
    public Image getImageContainer() {
        var image = super.getImageContainer();
        return image;
    }

    @Nullable
    @Override
    protected String getImageResourcePath() {
        return "images/example.png";
    }
}
