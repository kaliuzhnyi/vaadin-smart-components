package com.vaadin.flow.smart.layout;

import com.vaadin.flow.router.RouterLayout;
import jakarta.annotation.Nullable;

public interface SmartAppLayoutAware {

    @Nullable
    <T extends RouterLayout & SmartAppLayout> T getAppLayout();

    <T extends RouterLayout & SmartAppLayout> void setAppLayout(@Nullable T appLayout);

}
