package com.vaadin.flow.component.smart.view;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("ExampleSmartView")
@Route(value = "example/smart-view")
@AnonymousAllowed
public class ExampleSmartView
        extends AbstractSmartView<HorizontalLayout> {
}
