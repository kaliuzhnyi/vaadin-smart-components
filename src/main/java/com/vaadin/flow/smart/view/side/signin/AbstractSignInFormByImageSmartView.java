package com.vaadin.flow.smart.view.side.signin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.smart.component.form.SmartForm;
import com.vaadin.flow.smart.component.form.signin.SignInSmartForm;
import com.vaadin.flow.smart.view.side.block.AbstractBlockByImageSmartView;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.annotation.PostConstruct;
import lombok.Getter;

import java.util.Optional;

@SuppressWarnings("rawtypes")
public abstract class AbstractSignInFormByImageSmartView<C extends FlexLayout,
        F extends Component & SignInSmartForm>
        extends AbstractBlockByImageSmartView<C, F>
        implements SignInFormByImageSmartView<F> {

    @Getter(onMethod_ = {@Nonnull}, lazy = true)
    private final FlexLayout formWrapper = initFormWrapper();

    @Getter(onMethod_ = {@Nonnull}, lazy = true)
    private final FlexLayout buttonSignUpWrapper = initButtonSignUpWrapper();

    @Getter(onMethod_ = {@Nullable}, lazy = true)
    private final Component buttonSignUpEncouragementMessage = initButtonSignUpEncouragementMessage();

    @Getter(onMethod_ = {@Override, @Nullable}, lazy = true)
    private final Button buttonSignUp = initButtonSignUp();

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        super.beforeEnter(beforeEnterEvent);

        if (beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            getForm().getContent().setError(true);
        }

    }

    @PostConstruct
    protected void adjustForm() {
        var form = getForm();
        form.getContent().getStyle().setWidth(HasSize.getCssSize(100, Unit.PERCENTAGE)); // override
    }

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
                getButtonSignUpWrapper()
        );
        return wrapper;
    }

    @Nonnull
    protected FlexLayout initButtonSignUpWrapper() {
        var wrapper = new FlexLayout();
        wrapper.setWidthFull();
        wrapper.setFlexDirection(FlexLayout.FlexDirection.ROW);
        wrapper.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        wrapper.setAlignItems(FlexComponent.Alignment.CENTER);
        Optional.ofNullable(getButtonSignUpEncouragementMessage()).ifPresent(wrapper::add);
        Optional.ofNullable(getButtonSignUp()).ifPresent(wrapper::add);
        return wrapper;
    }

    @Nullable
    protected Span initButtonSignUpEncouragementMessage() {
        var component = new Span();
        component.setText(getButtonSignUpEncouragementMessageText());
        return component;
    }

    @Nonnull
    protected String getButtonSignUpEncouragementMessageText() {
        return Optional.ofNullable(getMessage(getButtonSignUpEncouragementMessageTextMessageCode()))
                .orElse("Don't have an account yet?");
    }

    @Nullable
    protected String getButtonSignUpEncouragementMessageTextMessageCode() {
        return null;
    }

    @Nullable
    protected Button initButtonSignUp() {
        var button = new Button();
        button.setId("signin-form-by-image-smart-view-button-signup");
        button.setText(getButtonSignUpText());
        button.addThemeVariants(
                ButtonVariant.LUMO_TERTIARY_INLINE
        );
        button.addClassNames(
                LumoUtility.Margin.Horizontal.SMALL
        );

        Optional.ofNullable(getButtonSignUpTarget())
                .ifPresent(t ->
                        button.addClickListener(event -> UI.getCurrent().navigate(t)));
        return button;
    }

    @Nonnull
    protected String getButtonSignUpText() {
        return Optional.ofNullable(getMessage(getButtonSignUpTextMessageCode()))
                .orElse("Sign Up");
    }

    @Nullable
    protected String getButtonSignUpTextMessageCode() {
        return null;
    }

}
