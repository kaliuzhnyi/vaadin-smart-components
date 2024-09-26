package com.vaadin.flow.smart.view.side.textblock;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.smart.component.textblock.TextBlockSmartComponent;
import com.vaadin.flow.smart.view.side.AbstractSideByImageSmartView;
import jakarta.annotation.Nonnull;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractTextBlockByImageSmartView<C extends FlexLayout,
        TEXTBLOCK extends Component & TextBlockSmartComponent>
        extends AbstractSideByImageSmartView<C>
        implements TextBlockByImageSmartView {

    @Autowired
    @Getter(onMethod_ = {@Override, @Nonnull})
    TEXTBLOCK textBlockContainer;

}
