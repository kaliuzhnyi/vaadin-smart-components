package com.vaadin.flow.smart.examples;

import com.vaadin.flow.smart.component.navigationmenu.DefaultNavigationMenuSmartComponent;
import com.vaadin.flow.smart.examples.view.ExampleNavigationMenuSmartComponentView;
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
        addItem("Link 1", ExampleSideByImageSmartView.class);
        addItem("Link 2", ExampleNavigationMenuSmartComponentView.class);
        addItem("Link 3", ExampleSideByImageSmartView.class);
        addItem("Link 4", ExampleSideByImageSmartView.class);
        addItem("Link 5", ExampleSideByImageSmartView.class);
    }

}
