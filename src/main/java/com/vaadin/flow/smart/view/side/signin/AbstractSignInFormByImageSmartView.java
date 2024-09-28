package com.vaadin.flow.smart.view.side.signin;

import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.smart.view.side.AbstractSideByImageSmartView;
import jakarta.annotation.Nonnull;
import lombok.Getter;

public abstract class AbstractSignInFormByImageSmartView<C extends FlexLayout>
        extends AbstractSideByImageSmartView<C>
        implements SignInFormByImageSmartView {

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final LoginForm form = initForm();

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        super.beforeEnter(beforeEnterEvent);

        if (beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            getForm().setError(true);
        }

    }

    @Override
    public void adjustSecondarySideForScreen() {
        super.adjustSecondarySideForScreen();
        if (determinateFlexDirection().equals(FlexLayout.FlexDirection.ROW)) {
            getSecondarySide().setAlignItems(FlexComponent.Alignment.START);
        } else {
            getSecondarySide().setAlignItems(FlexComponent.Alignment.CENTER);
        }
    }

    @Nonnull
    protected LoginForm initForm() {
        var form = new LoginForm();
        form.setId("signin-form-by-image-smart-view-form");
        form.setAction("login");
        return form;
    }

}
