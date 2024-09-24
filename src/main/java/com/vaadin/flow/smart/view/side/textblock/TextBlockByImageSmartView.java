package com.vaadin.flow.smart.view.side.textblock;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.smart.component.textblock.TextBlockSmartComponent;
import com.vaadin.flow.smart.view.side.SideByImageSmartView;
import jakarta.annotation.Nonnull;

public interface TextBlockByImageSmartView
        extends SideByImageSmartView {

    <T extends Component & TextBlockSmartComponent> T getTextBlockContainer();

    @Override
    @Nonnull
    default Component getContentContainer() {
        return getTextBlockContainer();
    }
}
