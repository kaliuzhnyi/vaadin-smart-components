package com.vaadin.flow.smart.component.block.textblock;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.smart.component.block.AbstractBlockSmartComponent;
import com.vaadin.flow.smart.util.GenericUtils;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;

import java.util.Optional;

public abstract class AbstractTextBlockSmartComponent<C extends FlexLayout,
        TITLE extends Component & HasText & HasSize,
        TEXT extends Component & HasText & HasSize,
        REMARK extends Component & HasText & HasSize>
        extends AbstractBlockSmartComponent<C>
        implements TextBlockSmartComponent<C> {

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final TITLE titleComponent = initTitleComponent();

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final TEXT textComponent = initTextComponent();

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final REMARK remarkComponent = initRemarkComponent();

    @Override
    @Nonnull
    protected C initContent() {
        var content = super.initContent();
        content.add(
                getTitleComponent(),
                getTextComponent(),
                getRemarkComponent()
        );
        return content;
    }

    @Nonnull
    protected TITLE initTitleComponent() {
        Class<TITLE> type = GenericUtils.getType(getClass(), AbstractTextBlockSmartComponent.class, 1);
        var component = getBeanFactory().createBean(type);
        component.setId("smart-component-textblock-title");
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
        Class<TEXT> type = GenericUtils.getType(getClass(), AbstractTextBlockSmartComponent.class, 2);
        var component = getBeanFactory().createBean(type);
        component.setId("smart-component-textblock-text");
        component.setWidthFull();
        component.setWhiteSpace(HasText.WhiteSpace.PRE_WRAP);
        component.addClassNames(
                LumoUtility.FontSize.MEDIUM,
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

    @Nonnull
    protected REMARK initRemarkComponent() {
        Class<REMARK> type = GenericUtils.getType(getClass(), AbstractTextBlockSmartComponent.class, 3);
        var component = getBeanFactory().createBean(type);
        component.setId("smart-component-textblock-remark");
        component.setWidthFull();
        component.setWhiteSpace(HasText.WhiteSpace.PRE_WRAP);
        component.addClassNames(
                LumoUtility.FontSize.XSMALL,
                LumoUtility.FontWeight.NORMAL,
                LumoUtility.TextColor.SECONDARY
        );

        Optional.ofNullable(getRemarkComponentText())
                .ifPresent(component::setText);

        return component;
    }

    @Nullable
    protected String getRemarkComponentText() {
        return getMessage(getRemarkComponentMessageCode());
    }

    @Nullable
    protected String getRemarkComponentMessageCode() {
        return null;
    }

}
