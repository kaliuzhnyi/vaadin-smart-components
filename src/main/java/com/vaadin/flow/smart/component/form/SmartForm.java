package com.vaadin.flow.smart.component.form;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.smart.component.block.BlockSmartComponent;

public interface SmartForm<C extends Component>
        extends BlockSmartComponent<C> {

    float DEFAULT_CONTENT_WIDTH_VALUE = 50;
    Unit DEFAULT_CONTENT_WIDTH_UNIT = Unit.PERCENTAGE;

}
