package com.vaadin.flow.component.smart.data;

import jakarta.annotation.Nonnull;

public enum DeviceType {
    Mobile,
    Tablet,
    Desktop;

    @Nonnull
    public static DeviceType determinateFromUserAgent(@Nonnull String userAgent) {
        userAgent = userAgent.toLowerCase();
        if (userAgent.contains("mobi")) {
            return DeviceType.Mobile;
        } else if (userAgent.contains("tablet") || userAgent.contains("ipad")) {
            return DeviceType.Tablet;
        } else {
            return DeviceType.Desktop;
        }
    }

}
