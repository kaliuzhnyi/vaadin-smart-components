package com.vaadin.flow.smart.view.base;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.smart.component.AdjustableForScreen;
import com.vaadin.flow.smart.layout.SmartAppLayoutAware;
import com.vaadin.flow.smart.view.SmartView;
import jakarta.annotation.Nonnull;

import java.util.Optional;

public interface BaseSmartView
        extends SmartView, SmartAppLayoutAware {

    @Nonnull
    <T extends Component & FlexComponent & HasSize> T getHeaderLayout();

    @Nonnull
    <T extends Component & FlexComponent & HasSize> T getBodyLayout();

    @Nonnull
    <T extends Component & FlexComponent & HasSize> T getFooterLayout();

    @Override
    default void adjustViewForScreen() {
        adjustHeaderLayoutForScreen();
        adjustBodyLayoutForScreen();
        adjustFooterLayoutForScreen();

        Optional.ofNullable(getAppLayout())
                .map(l -> (AdjustableForScreen) l)
                .ifPresent(AdjustableForScreen::adjustForScreen);

    }

    default void adjustHeaderLayoutForScreen() {
        // Do nothing here
        // It's just stub method
        // This method is only for overriding
    }

    default void adjustBodyLayoutForScreen() {
        // Do nothing here
        // It's just stub method
        // This method is only for overriding
    }

    default void adjustFooterLayoutForScreen() {
        // Do nothing here
        // It's just stub method
        // This method is only for overriding
    }

}
