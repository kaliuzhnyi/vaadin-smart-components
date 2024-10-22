package com.vaadin.flow.smart.component;

import com.vaadin.flow.smart.data.ScreenInfo;
import jakarta.annotation.Nullable;

public interface HasScreenInfo {

    @Nullable
    ScreenInfo getScreenInfo();

}
