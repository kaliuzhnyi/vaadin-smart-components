package com.vaadin.flow.smart.component.form.signup;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.smart.component.AbstractSmartComponent;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public abstract class AbstractSignUpSmartForm
        extends AbstractSmartComponent<FormLayout>
        implements SignUpSmartForm<FormLayout> {

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final H2 componentTitle = initComponentTitle();

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final EmailField fieldEmail = initFieldEmail();

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final PasswordField fieldPassword = initFieldPassword();

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final PasswordField fieldPasswordConfirm = initFieldPasswordConfirm();

    @Getter(value = AccessLevel.PROTECTED, onMethod_ = {@Nonnull}, lazy = true)
    private final Div buttonsWrapper = initButtonsWrapper();

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final Button buttonSignUp = initButtonSignUp();

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
                getFieldEmail(),
                getFieldPassword(),
                getFieldPasswordConfirm(),
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
                .orElse("Sign Up");
    }

    @Nullable
    protected String getComponentTitleTextMessageCode() {
        return null;
    }

    @Nonnull
    protected EmailField initFieldEmail() {
        var field = new EmailField();
        field.setId("signup-form-field-email");
        field.setRequired(true);
        field.setAutofocus(true);
        field.setLabel(getFieldEmailLabel());
        return field;
    }

    @Nonnull
    protected String getFieldEmailLabel() {
        return Optional.ofNullable(getMessage(getFieldEmailLabelMessageCode()))
                .orElse("Email");
    }

    @Nullable
    protected String getFieldEmailLabelMessageCode() {
        return null;
    }

    @Nonnull
    protected PasswordField initFieldPassword() {
        var field = new PasswordField();
        field.setId("signup-form-field-password");
        field.setRequired(true);
        field.setLabel(getFieldPasswordLabel());
        Optional.ofNullable(getPasswordMinLength()).ifPresent(field::setMinLength);
        Optional.ofNullable(getPasswordMaxLength()).ifPresent(field::setMaxLength);
        Optional.ofNullable(getPasswordPattern()).ifPresent(field::setPattern);
        return field;
    }

    @Nonnull
    protected String getFieldPasswordLabel() {
        return Optional.ofNullable(getMessage(getFieldPasswordLabelMessageCode()))
                .orElse("Password");
    }

    @Nullable
    protected String getFieldPasswordLabelMessageCode() {
        return null;
    }

    @Nonnull
    protected PasswordField initFieldPasswordConfirm() {
        var field = new PasswordField();
        field.setId("signup-form-field-password-confirm");
        field.setRequired(true);
        field.setLabel(getFieldPasswordConfirmLabel());
        return field;
    }

    @Nonnull
    protected String getFieldPasswordConfirmLabel() {
        return Optional.ofNullable(getMessage(getFieldPasswordConfirmLabelMessageCode()))
                .orElse("Confirm password");
    }

    @Nullable
    protected String getFieldPasswordConfirmLabelMessageCode() {
        return null;
    }

    @Nonnull
    protected Div initButtonsWrapper() {
        var wrapper = new Div();
        wrapper.setWidth(100, Unit.PERCENTAGE);
        wrapper.add(
                getButtonSignUp()
        );
        return wrapper;
    }

    @Nonnull
    protected Button initButtonSignUp() {
        var button = new Button();
        button.setId("signup-form-button-sign-up");
        button.setWidth(100, Unit.PERCENTAGE);
        button.setText(getButtonSignUpText());
        button.addClickListener(this::beforeHandleEventSignUp);
        button.addThemeVariants(
                ButtonVariant.LUMO_PRIMARY
        );
        button.addClassNames(
                LumoUtility.Margin.Top.LARGE
        );
        return button;
    }

    protected void beforeHandleEventSignUp(@Nonnull ClickEvent<?> clickEvent) {

        // Check email
        getFieldEmail().setHelperText(getEmailHelperText());
        getFieldEmail().setHelperComponent(new Span(getEmailHelperText()));
        var email = getFieldEmail().getValue();
        var emailHasError = false;
        var emailErrorMessage = new StringBuilder();

        if (getEmailPattern() != null && !email.matches(getEmailPattern())) {
            emailHasError = true;
            if (getEmailPatternErrorMessage() != null) {
                emailErrorMessage.append(getEmailPatternErrorMessage()).append(StringUtils.SPACE);
            }
        }

        if (getEmailExistProvider() != null && !emailHasError
                && getEmailExistProvider().test(email)) {
            emailHasError = true;
            if (getEmailExistErrorMessage() != null) {
                emailErrorMessage.append(getEmailExistErrorMessage());
            }
        }

        if (!emailErrorMessage.isEmpty()) {
            var errorMessageComponent = new Span();
            errorMessageComponent.addClassNames(
                    LumoUtility.TextColor.ERROR
            );
            errorMessageComponent.setText(emailErrorMessage.toString());
            getFieldEmail().setHelperComponent(errorMessageComponent);
        }

        // Check password
        getFieldPassword().setHelperText(getPasswordConfirmHelperText());
        getFieldPassword().setHelperComponent(new Span(getPasswordHelperText()));
        var password = getFieldPassword().getValue();
        var passwordHasError = false;
        var passwordErrorMessage = new StringBuilder();

        if (getPasswordMinLength() != null && password.length() < getPasswordMinLength()) {
            passwordHasError = true;
            if (getPasswordMinLengthErrorMessage() != null) {
                passwordErrorMessage.append(getPasswordMinLengthErrorMessage()).append(StringUtils.SPACE);
            }
        }

        if (getPasswordMaxLength() != null && password.length() > getPasswordMaxLength()) {
            passwordHasError = true;
            if (getPasswordMaxLengthErrorMessage() != null) {
                passwordErrorMessage.append(getPasswordMaxLengthErrorMessage()).append(StringUtils.SPACE);
            }
        }

        if (getPasswordPattern() != null && !passwordHasError && !password.matches(getPasswordPattern())) {
            passwordHasError = true;
            if (getPasswordPatternErrorMessage() != null) {
                passwordErrorMessage.append(getPasswordPatternErrorMessage());
            }
        }

        if (!passwordErrorMessage.isEmpty()) {
            var errorMessageComponent = new Span();
            errorMessageComponent.addClassNames(
                    LumoUtility.TextColor.ERROR
            );
            errorMessageComponent.setText(passwordErrorMessage.toString());
            getFieldPassword().setHelperComponent(errorMessageComponent);
        }

        // Check confirm password
        //getFieldPasswordConfirm().setHelperText(getPasswordConfirmHelperText());
        getFieldPasswordConfirm().setHelperComponent(new Span(getPasswordConfirmHelperText()));
        var passwordConfirm = getFieldPasswordConfirm().getValue();
        var passwordConfirmHasError = false;
        var passwordConfirmErrorMessage = new StringBuilder();

        if (!passwordHasError && !StringUtils.isNoneBlank(passwordConfirm) && !StringUtils.equals(password, passwordConfirm)) {
            passwordConfirmHasError = true;
            if (getPasswordConfirmEqualsErrorMessage() != null) {
                passwordConfirmErrorMessage.append(getPasswordConfirmEqualsErrorMessage());
            }
        }

        if (!passwordConfirmErrorMessage.isEmpty()) {
            var errorMessageComponent = new Span();
            errorMessageComponent.addClassNames(
                    LumoUtility.TextColor.ERROR
            );
            errorMessageComponent.setText(passwordConfirmErrorMessage.toString());
            getFieldPasswordConfirm().setHelperComponent(errorMessageComponent);
        }

        // Final check
        if (passwordHasError || passwordConfirmHasError || emailHasError) {
            return;
        }

        handleEventSignUp(clickEvent);
    }

    abstract protected void handleEventSignUp(@Nonnull ClickEvent<?> clickEvent);

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
