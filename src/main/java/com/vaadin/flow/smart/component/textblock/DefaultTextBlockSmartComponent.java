package com.vaadin.flow.smart.component.textblock;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.Nonnull;
import lombok.Getter;

public class DefaultTextBlockSmartComponent
        extends Composite<FlexLayout>
        implements TextBlockSmartComponent {

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final H1 titleComponent = initTitleComponent();

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final Paragraph textComponent = initTextComponent();

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final Span remarkComponent = initRemarkComponent();

    @Override
    protected FlexLayout initContent() {
        var layout = super.initContent();
        layout.setId("smart-component-textblock-layout");
        layout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        layout.setWidthFull();
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layout.setAlignItems(FlexComponent.Alignment.START);
        layout.add(
                getTitleComponent(),
                getTextComponent(),
                getRemarkComponent()
        );
        return layout;
    }

    @Nonnull
    protected H1 initTitleComponent() {
        var component = new H1();
        component.setId("smart-component-textblock-title");
        component.setWidthFull();
        component.addClassNames(
                LumoUtility.FontSize.XXLARGE,
                LumoUtility.FontWeight.BOLD,
                LumoUtility.TextColor.HEADER
        );
        return component;
    }

    @Nonnull
    protected Paragraph initTextComponent() {
        var component = new Paragraph();
        component.setId("smart-component-textblock-text");
        component.setWidthFull();
        component.addClassNames(
                LumoUtility.FontSize.MEDIUM,
                LumoUtility.FontWeight.NORMAL,
                LumoUtility.TextColor.BODY
        );
        return component;
    }

    @Nonnull
    protected Span initRemarkComponent() {
        var component = new Span();
        component.setId("smart-component-textblock-remark");
        component.setWidthFull();component.addClassNames(
                LumoUtility.FontSize.XSMALL,
                LumoUtility.FontWeight.NORMAL,
                LumoUtility.TextColor.SECONDARY
        );

        return component;
    }

}
