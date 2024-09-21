package com.vaadin.flow.component.smart.view.side;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.smart.view.base.BaseSmartView;
import jakarta.annotation.Nonnull;

public interface SideBySideSmartView
        extends BaseSmartView {

    @Nonnull
    <T extends Component & FlexComponent & HasSize> T getPrimarySide();

    @Nonnull
    <T extends Component & FlexComponent & HasSize> T getSecondarySide();

}
