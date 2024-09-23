package com.vaadin.flow.smart.view;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("ExampleSmartView")
@Route(value = "example/smart-view")
@AnonymousAllowed
@SuppressWarnings("unused")
public class ExampleSmartView
        extends AbstractSmartView<FlexLayout> {

    @Override
    protected FlexLayout initContent() {
        var content = super.initContent();
        content.addClassNames(
                LumoUtility.Background.CONTRAST_5
        );
        content.add(new Span("Content"));
        return content;
    }
}
