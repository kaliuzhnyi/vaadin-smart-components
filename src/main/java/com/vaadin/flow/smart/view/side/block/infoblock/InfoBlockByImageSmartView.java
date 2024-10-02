package com.vaadin.flow.smart.view.side.block.infoblock;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.smart.component.block.BlockSmartComponent;
import com.vaadin.flow.smart.component.block.infoblock.InfoBlockSmartComponent;
import com.vaadin.flow.smart.view.side.block.BlockByImageSmartView;
import jakarta.annotation.Nonnull;

@SuppressWarnings({"rawtypes", "unchecked"})
public interface InfoBlockByImageSmartView<INFOBLOCK extends Component & InfoBlockSmartComponent>
        extends BlockByImageSmartView {

    @Nonnull
    INFOBLOCK getInfoBlockContainer();

    @Override
    @Nonnull
    default <T extends Component & BlockSmartComponent> T getBlockContainer() {
        return (T) getInfoBlockContainer();
    }

}
