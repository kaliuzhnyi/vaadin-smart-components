package com.vaadin.flow.smart.component.block.infoblock;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.smart.component.block.AbstractBlockSmartComponent;
import com.vaadin.flow.smart.component.infocard.InfoCardSmartComponent;
import com.vaadin.flow.smart.util.GenericUtils;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SuppressWarnings("rawtypes")
public abstract class AbstractInfoBlockSmartComponent<C extends FlexLayout,
        TITLE extends Component & HasText & HasSize,
        TEXT extends Component & HasText & HasSize,
        CARD extends Component & InfoCardSmartComponent>
        extends AbstractBlockSmartComponent<C>
        implements InfoBlockSmartComponent<C, TITLE, TEXT, CARD> {

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final TITLE titleComponent = initTitleComponent();

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final TEXT textComponent = initTextComponent();

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final List<CARD> cardComponents = new ArrayList<>();

    @Override
    @Nonnull
    protected C initContent() {
        var content = super.initContent();
        content.add(
                getTitleComponent(),
                getTextComponent()
        );

        content.add(cardComponents.stream().map(card -> (Component) card).collect(Collectors.toList()));
        //getCardComponents().forEach(content::add);

        return content;
    }

    @Nonnull
    protected TITLE initTitleComponent() {
        Class<TITLE> type = GenericUtils.getType(getClass(), AbstractInfoBlockSmartComponent.class, 1);
        var component = getBeanFactory().createBean(type);
        component.setId("smart-component-infoblock-title");
        component.setWidthFull();
        component.setWhiteSpace(HasText.WhiteSpace.PRE_WRAP);
        component.addClassNames(
                LumoUtility.FontSize.XXLARGE,
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
    protected TEXT initTextComponent() {
        Class<TEXT> type = GenericUtils.getType(getClass(), AbstractInfoBlockSmartComponent.class, 2);
        var component = getBeanFactory().createBean(type);
        component.setId("smart-component-infoblock-text");
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
