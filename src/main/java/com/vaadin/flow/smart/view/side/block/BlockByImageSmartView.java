package com.vaadin.flow.smart.view.side.block;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.smart.component.block.BlockSmartComponent;
import com.vaadin.flow.smart.view.side.SideByImageSmartView;
import jakarta.annotation.Nonnull;

@SuppressWarnings("rawtypes")
public interface BlockByImageSmartView
        extends SideByImageSmartView {

    @Nonnull
    <T extends Component & BlockSmartComponent> T getBlockContainer();

    @Override
    @Nonnull
    default Component getContentContainer() {
        return getBlockContainer();
    }

}
