package com.vaadin.flow.component.smart.data;

import jakarta.annotation.Nonnull;

public enum DevicePlatform {
    Windows,
    MacOS,
    Android,
    iOS,
    Linux,
    Unknown;

    @Nonnull
    public static DevicePlatform determinateFromUserAgent(@Nonnull String userAgent) {
        userAgent = userAgent.toLowerCase();
        if (userAgent.contains("windows")) {
            return DevicePlatform.Windows;
        } else if (userAgent.contains("mac os") || userAgent.contains("macos")) {
            return DevicePlatform.MacOS;
        } else if (userAgent.contains("android")) {
            return DevicePlatform.Android;
        } else if (userAgent.contains("iphone") || userAgent.contains("ipad")) {
            return DevicePlatform.iOS;
        } else if (userAgent.contains("linux")) {
            return DevicePlatform.Linux;
        } else {
            return DevicePlatform.Unknown;
        }
    }

}
