package com.vaadin.flow.smart.component.block.infoblock;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.smart.component.block.BlockSmartComponent;
import com.vaadin.flow.smart.component.infocard.InfoCardSmartComponent;
import jakarta.annotation.Nonnull;

import java.util.List;

@SuppressWarnings("rawtypes")
public interface InfoBlockSmartComponent<C extends FlexLayout,
        TITLE extends Component & HasText & HasSize,
        TEXT extends Component & HasText & HasSize,
        CARD extends InfoCardSmartComponent>
        extends BlockSmartComponent<C> {

    @Nonnull
    TITLE getTitleComponent();

    @Nonnull
    TEXT getTextComponent();

    @Nonnull
    List<CARD> getCardComponents();

}
