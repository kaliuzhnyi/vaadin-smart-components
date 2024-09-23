package com.vaadin.flow.smart.view.side;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.smart.component.textblock.TextBlockSmartComponent;

@SuppressWarnings("unchecked")
public interface TextBlockByImageSmartView
        extends SideByImageSmartView {

    <T extends Component & TextBlockSmartComponent> T getTextBlockContainer();

    @Override
    default <T extends Component> T getContentContainer() {
        return getTextBlockContainer();
    }
}
