package com.vaadin.flow.smart.util;

import com.vaadin.flow.component.Component;
import jakarta.annotation.Nonnull;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ComponentStyleUtils {

    public void hideScroll(@Nonnull Component component) {
//        component.getElement().getStyle().set("--webkit-scrollbar", "none");
//        component.getElement().getStyle().set("-ms-overflow-style", "none");
//        component.getElement().getStyle().set("scrollbar-width", "none");
        component.addClassName("hide-scrollbar");
    }

    public void unhideScroll(@Nonnull Component component) {
//        component.getElement().getStyle().remove("--webkit-scrollbar");
//        component.getElement().getStyle().remove("-ms-overflow-style");
//        component.getElement().getStyle().remove("scrollbar-width");
        component.removeClassName("hide-scrollbar");
    }

}
