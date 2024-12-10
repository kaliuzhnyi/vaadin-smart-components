package com.vaadin.flow.smart.view.side.signup;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.smart.component.form.SmartForm;
import com.vaadin.flow.smart.component.form.signup.SignUpSmartForm;
import com.vaadin.flow.smart.view.side.block.AbstractBlockByImageSmartView;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;

import java.util.Optional;

@SuppressWarnings("rawtypes")
public abstract class AbstractSignUpFormByImageSmartView<C extends FlexLayout,
        F extends Component & SignUpSmartForm>
        extends AbstractBlockByImageSmartView<C, F>
        implements SignUpFormByImageSmartView<F> {

    @Getter(onMethod_ = {@Nonnull}, lazy = true)
    private final FlexLayout formWrapper = initFormWrapper();

    @Getter(onMethod_ = {@Nonnull}, lazy = true)
    private final FlexLayout buttonSignInWrapper = initButtonSignInWrapper();

    @Getter(onMethod_ = {@Nullable}, lazy = true)
    private final Component buttonSignInEncouragementMessage = initButtonSignInEncouragementMessage();

    @Getter(onMethod_ = {@Override, @Nullable}, lazy = true)
    private final Button buttonSignIn = initButtonSignIn();

    @Nonnull
    @Override
    public F getForm() {
        return getBlockContainer();
    }

    @Override
    @Nonnull
    public Component getContentContainer() {
        return getFormWrapper();
    }

    @Nonnull
    protected FlexLayout initFormWrapper() {
        var wrapper = new FlexLayout();
        wrapper.setWidth(SmartForm.DEFAULT_CONTENT_WIDTH_VALUE, SmartForm.DEFAULT_CONTENT_WIDTH_UNIT);
        wrapper.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        wrapper.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        wrapper.setAlignItems(FlexComponent.Alignment.CENTER);
        wrapper.addClassNames(
                LumoUtility.Padding.MEDIUM
        );
        wrapper.add(
                getForm(),
                getButtonSignInWrapper()
        );
        return wrapper;
    }

    protected FlexLayout initButtonSignInWrapper() {
        var wrapper = new FlexLayout();
        wrapper.setWidthFull();
        wrapper.setFlexDirection(FlexLayout.FlexDirection.ROW);
        wrapper.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        wrapper.setAlignItems(FlexComponent.Alignment.CENTER);
        Optional.ofNullable(getButtonSignInEncouragementMessage()).ifPresent(wrapper::add);
        Optional.ofNullable(getButtonSignIn()).ifPresent(wrapper::add);
        return wrapper;
    }

    @Nullable
    protected Span initButtonSignInEncouragementMessage() {
        var component = new Span();
        component.setText(getButtonSignInEncouragementMessageText());
        return component;
    }

    @Nonnull
    protected String getButtonSignInEncouragementMessageText() {
        return Optional.ofNullable(getMessage(getButtonSignInEncouragementMessageTextMessageCode()))
                .orElse("Do you already have an account?");
    }

    @Nullable
    protected String getButtonSignInEncouragementMessageTextMessageCode() {
        return null;
    }

    @Nullable
    protected Button initButtonSignIn() {
        var button = new Button();
        button.setId("signin-form-by-image-smart-view-button-signin");
        button.setText(getButtonSignInText());
        button.addThemeVariants(
                ButtonVariant.LUMO_TERTIARY_INLINE
        );
        button.addClassNames(
                LumoUtility.Margin.Horizontal.SMALL
        );

        Optional.ofNullable(getButtonSignInTarget())
                .ifPresent(t ->
                        button.addClickListener(event -> UI.getCurrent().navigate(t)));
        return button;
    }

    @Nonnull
    protected String getButtonSignInText() {
        return Optional.ofNullable(getMessage(getButtonSignInTextMessageCode()))
                .orElse("Sign In");
    }

    @Nullable
    protected String getButtonSignInTextMessageCode() {
        return null;
    }

}
