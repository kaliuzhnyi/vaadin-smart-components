package com.vaadin.flow.smart.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScreenInfo {

    private double screenWidth;

    private double screenHeight;

    private double windowWidth;

    private double windowHeight;

    private double availWidth;

    private double availHeight;

    private double scrollWidth;

    private double scrollHeight;

}
