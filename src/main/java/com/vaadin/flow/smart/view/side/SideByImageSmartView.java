package com.vaadin.flow.smart.view.side;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;
import jakarta.annotation.Nonnull;

public interface SideByImageSmartView
        extends SideBySideSmartView {

    @Nonnull
    Image getImageContainer();

    @Nonnull
    Component getContentContainer();

    @Override
    default void adjustPrimarySideForScreen() {
        SideBySideSmartView.super.adjustPrimarySideForScreen();
        adjustImageContainerForScreen();
    }

    @Override
    default void adjustSecondarySideForScreen() {
        SideBySideSmartView.super.adjustSecondarySideForScreen();
        adjustContentContainerForScreen();
    }

    default void adjustImageContainerForScreen() {
        // Do nothing here
        // It's just stub method
        // This method is only for overriding
    }

    default void adjustContentContainerForScreen() {
        // Do nothing here
        // It's just stub method
        // This method is only for overriding
    }

}
