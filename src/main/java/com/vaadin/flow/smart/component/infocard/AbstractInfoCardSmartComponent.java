package com.vaadin.flow.smart.component.infocard;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.smart.component.AbstractSmartComponent;
import com.vaadin.flow.smart.util.GenericUtils;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;

import java.util.Optional;

public abstract class AbstractInfoCardSmartComponent<C extends FlexLayout,
        TITLE extends Component & HasText & HasSize,
        SUBTITLE extends Component & HasText & HasSize,
        TEXT extends Component & HasText & HasSize>
        extends AbstractSmartComponent<C>
        implements InfoCardSmartComponent<C> {

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final TITLE titleComponent = initTitleComponent();

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final SUBTITLE subTitleComponent = initSubTitleComponent();

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final TEXT textComponent = initTextComponent();

    @Override
    @Nonnull
    protected C initContent() {
        var layout = super.initContent();
        layout.setId("smart-component-textblock-container");
        layout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layout.setAlignItems(FlexComponent.Alignment.START);
        layout.addClassNames(
                LumoUtility.Margin.Bottom.MEDIUM
        );
        layout.add(
                getTitleComponent(),
                getSubTitleComponent(),
                getTextComponent()
        );
        return layout;
    }

    @Nonnull
    protected TITLE initTitleComponent() {
        Class<TITLE> type = GenericUtils.getType(getClass(), AbstractInfoCardSmartComponent.class, 1);
        var component = getBeanFactory().createBean(type);
        component.setId("smart-component-infocard-title");
        component.setWidthFull();
        component.setWhiteSpace(HasText.WhiteSpace.PRE_WRAP);
        component.addClassNames(
                LumoUtility.FontSize.MEDIUM,
                LumoUtility.FontWeight.BOLD,
                LumoUtility.TextColor.HEADER
        );

        Optional.ofNullable(getTitleComponentText())
                .ifPresent(component::setText);

        return component;
    }

    @Nullable
    protected String getTitleComponentText() {
        return getMessage(getTitleComponentMessageCode());
    }

    @Nullable
    protected String getTitleComponentMessageCode() {
        return null;
    }

    @Nonnull
    protected SUBTITLE initSubTitleComponent() {
        Class<SUBTITLE> type = GenericUtils.getType(getClass(), AbstractInfoCardSmartComponent.class, 2);
        var component = getBeanFactory().createBean(type);
        component.setId("smart-component-infocard-subtitle");
        component.setWidthFull();
        component.setWhiteSpace(HasText.WhiteSpace.PRE_WRAP);
        component.addClassNames(
                LumoUtility.FontSize.SMALL,
                LumoUtility.FontWeight.NORMAL,
                LumoUtility.TextColor.SECONDARY
        );

        Optional.ofNullable(getSubTitleComponentText())
                .ifPresent(component::setText);

        return component;
    }

    @Nullable
    protected String getSubTitleComponentText() {
        return getMessage(getSubTitleComponentMessageCode());
    }

    @Nullable
    protected String getSubTitleComponentMessageCode() {
        return null;
    }

    @Nonnull
    protected TEXT initTextComponent() {
        Class<TEXT> type = GenericUtils.getType(getClass(), AbstractInfoCardSmartComponent.class, 3);
        var component = getBeanFactory().createBean(type);
        component.setId("smart-component-infocard-text");
        component.setWidthFull();
        component.setWhiteSpace(HasText.WhiteSpace.PRE_WRAP);
        component.addClassNames(
                LumoUtility.FontSize.SMALL,
                LumoUtility.FontWeight.NORMAL,
                LumoUtility.TextColor.BODY
        );

        Optional.ofNullable(getTextComponentText())
                .ifPresent(component::setText);

        return component;
    }

    @Nullable
    protected String getTextComponentText() {
        return getMessage(getTextComponentMessageCode());
    }

    @Nullable
    protected String getTextComponentMessageCode() {
        return null;
    }

}
