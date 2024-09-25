package com.vaadin.flow.smart.view.side.signin;

import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.annotation.Nullable;

@PageTitle("ExampleSignInFormByImageSmartView")
@Route(value = "example/signin-form-by-image-smart-view")
@AnonymousAllowed
@SuppressWarnings("unused")
public class ExampleSignInFormByImageSmartView
        extends AbstractSignInFormByImageSmartView<FlexLayout> {

    @Nullable
    @Override
    protected String getImageResourcePath() {
        return "images/example.png";
    }

}
