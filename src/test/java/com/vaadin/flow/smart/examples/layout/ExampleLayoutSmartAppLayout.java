package com.vaadin.flow.smart.examples.layout;

import com.vaadin.flow.smart.examples.ExampleNavigationMenuSmartComponent;
import com.vaadin.flow.smart.layout.DefaultSmartAppLayout;
import jakarta.annotation.Nonnull;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

public class ExampleLayoutSmartAppLayout
        extends DefaultSmartAppLayout {

    @Autowired
    @Getter(onMethod_ = {@Override, @Nonnull})
    private ExampleNavigationMenuSmartComponent navbarMenu;

}
