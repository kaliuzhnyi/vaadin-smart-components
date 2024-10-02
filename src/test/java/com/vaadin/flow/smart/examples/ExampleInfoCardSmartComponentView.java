package com.vaadin.flow.smart.examples;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.smart.component.infocard.DefaultInfoCardSmartComponent;
import com.vaadin.flow.smart.view.side.AbstractSideByImageSmartView;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("ExampleInfoCardSmartComponentView")
@Route(value = "example/side-by-image-smart-view-with-infocard-smart-component")
@AnonymousAllowed
@SuppressWarnings("unused")
public class ExampleInfoCardSmartComponentView
        extends AbstractSideByImageSmartView<FlexLayout> {

    @Autowired
    private ExampleInfoCardSmartComponent exampleInfoCardSmartComponent;

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final Div contentContainer = initContentContainer();

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
    protected Div initContentContainer() {
        var container = new Div();
        container.add(
                exampleInfoCardSmartComponent,
                DefaultInfoCardSmartComponent.builder()
                        .titleComponentText("Senior Software Engineer")
                        .subTitleComponentText("California · Remote")
                        .textComponentText("""
                                Lorem ipsum odor amet, consectetuer adipiscing elit.
                                Tincidunt phasellus potenti eget, lorem at maecenas.
                                Aenean etiam hac aenean cubilia consectetur aptent molestie est ultricies.
                                Massa odio conubia elit lobortis placerat dictumst dapibus convallis eget.
                                Commodo lobortis ex risus enim blandit non maximus accumsan. Netus efficitur arcu vehicula aptent volutpat pretium.
                                """)
                        .build(),
                DefaultInfoCardSmartComponent.builder()
                        .titleComponentText("Middle Software Engineer")
                        .subTitleComponentText("Toronto · Remote")
                        .textComponentText("""
                                Lorem ipsum odor amet, consectetuer adipiscing elit.
                                Tincidunt phasellus potenti eget, lorem at maecenas.
                                Aenean etiam hac aenean cubilia consectetur aptent molestie est ultricies.
                                """)
                        .build(),
                DefaultInfoCardSmartComponent.builder()
                        .titleComponentText("Junior Software Engineer")
                        .subTitleComponentText("Kyiv · On-site")
                        .textComponentText("""
                                Commodo lobortis ex risus enim blandit non maximus accumsan. Netus efficitur arcu vehicula aptent volutpat pretium.
                                Feugiat cursus ultrices mi tellus libero quam.
                                Vivamus senectus vivamus nullam dignissim venenatis eleifend justo suspendisse.
                                """)
                        .build()
        );
        return container;
    }

    @Nullable
    @Override
    protected String getImageResourcePath() {
        return "images/example.png";
    }

}
