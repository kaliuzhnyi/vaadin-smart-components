package com.vaadin.flow.smart.view;

import com.vaadin.flow.smart.component.AdjustableForScreen;
import com.vaadin.flow.smart.component.HasDeviceInfo;
import com.vaadin.flow.smart.component.HasScreenInfo;
import com.vaadin.flow.smart.data.DeviceInfo;
import com.vaadin.flow.smart.data.ScreenInfo;
import jakarta.annotation.Nonnull;

public interface SmartView
        extends HasScreenInfo, HasDeviceInfo, AdjustableForScreen {

    @Override
    @Nonnull
    ScreenInfo getScreenInfo();

    @Override
    @Nonnull
    DeviceInfo getDeviceInfo();

    @Override
    default void adjustForScreen() {
        adjustViewForScreen();
    }

    default void adjustViewForScreen() {
        // Do nothing here
        // It's just stub method
        // This method is only for overriding
    }

}
