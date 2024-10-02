package com.vaadin.flow.smart.component.block.textblock;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.smart.component.block.BlockSmartComponent;
import jakarta.annotation.Nonnull;

public interface TextBlockSmartComponent<C extends FlexLayout>
        extends BlockSmartComponent<C> {

    @Nonnull
    <T extends Component & HasText> T getTitleComponent();

    @Nonnull
    <T extends Component & HasText> T getTextComponent();

    @Nonnull
    <T extends Component & HasText> T getRemarkComponent();

}
