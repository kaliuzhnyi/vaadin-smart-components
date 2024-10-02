package com.vaadin.flow.smart.view.side.block.infoblock;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.smart.component.block.infoblock.InfoBlockSmartComponent;
import com.vaadin.flow.smart.view.side.block.AbstractBlockByImageSmartView;
import jakarta.annotation.Nonnull;

@SuppressWarnings({"rawtypes"})
public abstract class AbstractInfoBlockByImageSmartView<C extends FlexLayout,
        INFOBLOCK extends Component & InfoBlockSmartComponent>
        extends AbstractBlockByImageSmartView<C, INFOBLOCK>
        implements InfoBlockByImageSmartView {

    @Override
    @Nonnull
    public INFOBLOCK getInfoBlockContainer() {
        return getBlockContainer();
    }
}
