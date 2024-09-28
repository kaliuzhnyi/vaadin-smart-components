package com.vaadin.flow.smart.component.textblock;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import jakarta.annotation.Nonnull;

public interface TextBlockSmartComponent<C extends FlexLayout> {

    @Nonnull
    C getContent();

    @Nonnull
    <T extends Component & HasText> T getTitleComponent();

    @Nonnull
    <T extends Component & HasText> T getTextComponent();

    @Nonnull
    <T extends Component & HasText> T getRemarkComponent();

}
