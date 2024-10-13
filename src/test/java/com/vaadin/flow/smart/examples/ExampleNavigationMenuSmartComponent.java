package com.vaadin.flow.smart.examples;

import com.vaadin.flow.smart.component.navigationmenu.DefaultNavigationMenuSmartComponent;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SuppressWarnings("unused")
public class ExampleNavigationMenuSmartComponent
        extends DefaultNavigationMenuSmartComponent {

    @PostConstruct
    private void init() {
        addItem("Link", ExampleNavigationMenuSmartComponentView.class);
        addItem("Link", ExampleNavigationMenuSmartComponentView.class);
        addItem("Link", ExampleSideByImageSmartView.class);
        addItem("Link", ExampleNavigationMenuSmartComponentView.class);
        addItem("Link", ExampleNavigationMenuSmartComponentView.class);
        highlightItem(ExampleSideByImageSmartView.class);
    }

}
