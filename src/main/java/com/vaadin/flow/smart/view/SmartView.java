package com.vaadin.flow.smart.view;

import com.vaadin.flow.smart.data.DeviceInfo;
import com.vaadin.flow.smart.data.ScreenInfo;
import jakarta.annotation.Nonnull;

public interface SmartView {

    @Nonnull
    ScreenInfo getScreenInfo();

    @Nonnull
    DeviceInfo getDeviceInfo();

    default void adjustViewForScreen() {
        // Do nothing here
        // It's just stub method
        // This method is only for overriding
    }

}
