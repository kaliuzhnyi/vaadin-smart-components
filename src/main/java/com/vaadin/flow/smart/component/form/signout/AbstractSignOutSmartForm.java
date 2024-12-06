package com.vaadin.flow.smart.component.form.signout;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.smart.component.AbstractSmartComponent;
import com.vaadin.flow.spring.security.AuthenticationContext;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public abstract class AbstractSignOutSmartForm
        extends AbstractSmartComponent<FormLayout>
        implements SignOutSmartForm<FormLayout> {

    @Autowired
    @Getter(onMethod_ = {@Nonnull}, value = AccessLevel.PROTECTED)
    private AuthenticationContext authenticationContext;

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final H2 componentTitle = initComponentTitle();

    @Getter(value = AccessLevel.PROTECTED, onMethod_ = {@Nonnull}, lazy = true)
    private final Div buttonsWrapper = initButtonsWrapper();

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final Button buttonSignOut = initButtonSignOut();

    @Override
    protected FormLayout initContent() {
        var content = super.initContent();
        content.setWidth(DEFAULT_CONTENT_WIDTH_VALUE, DEFAULT_CONTENT_WIDTH_UNIT);
        content.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));
        content.addClassNames(
                LumoUtility.Padding.MEDIUM
        );
        content.add(
                getComponentTitle(),
                getButtonsWrapper()
        );
        return content;
    }

    @Nonnull
    protected H2 initComponentTitle() {
        var component = new H2();
        component.setText(getComponentTitleText());
        return component;
    }

    @Nonnull
    protected String getComponentTitleText() {
        return Optional.ofNullable(getMessage(getComponentTitleTextMessageCode()))
                .orElse("Sign Out");
    }

    @Nullable
    protected String getComponentTitleTextMessageCode() {
        return null;
    }

    @Nonnull
    protected Div initButtonsWrapper() {
        var wrapper = new Div();
        wrapper.add(
                getButtonSignOut()
        );
        return wrapper;
    }

    @Nonnull
    protected Button initButtonSignOut() {
        var button = new Button();
        button.setId("signout-form-button-sign-out");
        button.setText(getButtonSignOutText());
        button.addClickListener(this::handleEventSignOut);
        button.addThemeVariants(
                ButtonVariant.LUMO_PRIMARY,
                ButtonVariant.LUMO_ERROR
        );
        button.addClassNames(
                LumoUtility.Margin.Top.LARGE
        );
        return button;
    }

    protected void handleEventSignOut(@Nonnull ClickEvent<?> clickEvent) {
        getAuthenticationContext().logout();
    }

    @Nonnull
    protected String getButtonSignOutText() {
        return Optional.ofNullable(getMessage(getButtonSignOutTextMessageCode()))
                .orElse("Sign Out");
    }

    @Nullable
    protected String getButtonSignOutTextMessageCode() {
        return null;
    }

}
