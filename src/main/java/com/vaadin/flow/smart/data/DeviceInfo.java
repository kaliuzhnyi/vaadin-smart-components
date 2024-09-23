package com.vaadin.flow.smart.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeviceInfo {

    private DeviceType deviceType;

    private DevicePlatform devicePlatform;

    private String userAgent;

}
