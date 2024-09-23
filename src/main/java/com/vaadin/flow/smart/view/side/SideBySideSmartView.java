package com.vaadin.flow.smart.view.side;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.smart.view.base.BaseSmartView;
import jakarta.annotation.Nonnull;

public interface SideBySideSmartView
        extends BaseSmartView {

    @Nonnull
    <T extends Component & FlexComponent & HasSize> T getPrimarySide();

    @Nonnull
    <T extends Component & FlexComponent & HasSize> T getSecondarySide();

    double getWidthToChangeFlexDirection();

    default FlexLayout.FlexDirection determinateFlexDirection() {
        return getScreenInfo().getWindowWidth() >= getWidthToChangeFlexDirection()
                ? FlexLayout.FlexDirection.ROW
                : FlexLayout.FlexDirection.COLUMN;
    }

    @Override
    default void adjustBodyLayoutForScreen() {
        BaseSmartView.super.adjustBodyLayoutForScreen();
        adjustPrimarySideForScreen();
        adjustSecondarySideForScreen();
    }

    default void adjustPrimarySideForScreen() {
        // Do nothing here
        // It's just stub method
        // This method is only for overriding
    }

    default void adjustSecondarySideForScreen() {
        // Do nothing here
        // It's just stub method
        // This method is only for overriding
    }

}
