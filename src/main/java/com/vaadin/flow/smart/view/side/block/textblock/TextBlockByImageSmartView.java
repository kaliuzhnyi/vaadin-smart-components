package com.vaadin.flow.smart.view.side.block.textblock;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.smart.component.block.BlockSmartComponent;
import com.vaadin.flow.smart.component.block.textblock.TextBlockSmartComponent;
import com.vaadin.flow.smart.view.side.block.BlockByImageSmartView;
import jakarta.annotation.Nonnull;

@SuppressWarnings({"rawtypes", "unchecked"})
public interface TextBlockByImageSmartView<TEXTBLOCK extends Component & TextBlockSmartComponent>
        extends BlockByImageSmartView {

    @Nonnull
    TEXTBLOCK getTextBlockContainer();

    @Override
    @Nonnull
    default <T extends Component & BlockSmartComponent> T getBlockContainer() {
        return (T) getTextBlockContainer();
    }

}
