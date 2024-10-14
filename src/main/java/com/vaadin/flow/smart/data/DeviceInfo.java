package com.vaadin.flow.smart.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeviceInfo {

    private DeviceType deviceType;

    private DevicePlatform devicePlatform;

    private String userAgent;

    public boolean isMobile() {
        return deviceType.equals(DeviceType.Mobile);
    }

    public boolean isTablet() {
        return deviceType.equals(DeviceType.Tablet);
    }

    public boolean isDesktop() {
        return deviceType.equals(DeviceType.Desktop);
    }

    public boolean isWindows() {
        return devicePlatform.equals(DevicePlatform.Windows);
    }

    public boolean isLinux() {
        return devicePlatform.equals(DevicePlatform.Linux);
    }

    public boolean isMacOS() {
        return devicePlatform.equals(DevicePlatform.MacOS);
    }

    public boolean isIOS() {
        return devicePlatform.equals(DevicePlatform.iOS);
    }

    public boolean isAndroid() {
        return devicePlatform.equals(DevicePlatform.Android);
    }

}
