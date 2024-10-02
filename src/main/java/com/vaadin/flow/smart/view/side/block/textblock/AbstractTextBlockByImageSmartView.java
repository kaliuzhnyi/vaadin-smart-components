package com.vaadin.flow.smart.view.side.block.textblock;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.smart.component.block.textblock.TextBlockSmartComponent;
import com.vaadin.flow.smart.view.side.block.AbstractBlockByImageSmartView;
import jakarta.annotation.Nonnull;

@SuppressWarnings({"rawtypes"})
public abstract class AbstractTextBlockByImageSmartView<C extends FlexLayout,
        TEXTBLOCK extends Component & TextBlockSmartComponent>
        extends AbstractBlockByImageSmartView<C, TEXTBLOCK>
        implements TextBlockByImageSmartView<TEXTBLOCK> {

    @Override
    @Nonnull
    public TEXTBLOCK getTextBlockContainer() {
        return getBlockContainer();
    }
}
