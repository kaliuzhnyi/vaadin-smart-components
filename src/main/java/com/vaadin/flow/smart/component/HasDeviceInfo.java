package com.vaadin.flow.smart.component;

import com.vaadin.flow.smart.data.DeviceInfo;
import jakarta.annotation.Nullable;

public interface HasDeviceInfo {

    @Nullable
    DeviceInfo getDeviceInfo();

}
