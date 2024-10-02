package com.vaadin.flow.smart.view.side.block;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.smart.component.block.BlockSmartComponent;
import com.vaadin.flow.smart.view.side.AbstractSideByImageSmartView;
import jakarta.annotation.Nonnull;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("rawtypes")
public abstract class AbstractBlockByImageSmartView<C extends FlexLayout,
        BLOCK extends Component & BlockSmartComponent>
        extends AbstractSideByImageSmartView<C>
        implements BlockByImageSmartView {

    @Autowired
    @Getter(onMethod_ = {@Override, @Nonnull})
    BLOCK blockContainer;

}
