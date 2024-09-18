package com.vaadin.flow.component.smart.view;

import lombok.Builder;
import lombok.Data;

public interface SmartView {

    @Data
    @Builder
    class Info {
        private double screenWidth;
        private double screenHeight;
        private double windowWidth;
        private double windowHeight;
        private double availWidth;
        private double availHeight;
    }

    Info getInfo();

    default void adjustViewForScreen() {
        // Do nothing here
        // It's just stub method
        // This method is only for overriding
    }

}
