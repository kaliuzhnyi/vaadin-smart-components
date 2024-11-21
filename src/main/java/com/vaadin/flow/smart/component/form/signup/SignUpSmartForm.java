package com.vaadin.flow.smart.component.form.signup;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.smart.component.form.SmartForm;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import java.util.Optional;
import java.util.function.Predicate;

public interface SignUpSmartForm<C extends FormLayout>
        extends SmartForm<C> {

    @Override
    @Nonnull
    C getContent();

    @Nonnull
    <T extends Component & HasText> T getComponentTitle();

    @Nonnull
    EmailField getFieldEmail();

    @Nonnull
    PasswordField getFieldPassword();

    @Nonnull
    PasswordField getFieldPasswordConfirm();

    @Nonnull
    Button getButtonSignUp();

    @Nullable
    default Predicate<String> getEmailExistProvider() {
        return s -> false;
    }

    @Nullable
    default String getEmailExistErrorMessage() {
        return Optional.ofNullable(getEmailPattern())
                .map(p -> "Email is already exists.")
                .orElse(null);
    }

    @Nullable
    default String getEmailPattern() {
        return "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    }

    @Nullable
    default String getEmailPatternErrorMessage() {
        return Optional.ofNullable(getEmailPattern())
                .map(p -> "Email is not valid.")
                .orElse(null);
    }

    @Nullable
    default String getEmailHelperText() {
        return null;
    }

    @Nullable
    default Integer getPasswordMinLength() {
        return 10;
    }

    @Nullable
    default String getPasswordMinLengthErrorMessage() {
        return Optional.ofNullable(getPasswordMinLength())
                .map("Password must be at least %s characters long."::formatted)
                .orElse(null);
    }

    @Nullable
    default Integer getPasswordMaxLength() {
        return 128;
    }

    @Nullable
    default String getPasswordMaxLengthErrorMessage() {
        return Optional.ofNullable(getPasswordMaxLength())
                .map("Password must be no more than %s characters long."::formatted)
                .orElse(null);
    }

    @Nullable
    default String getPasswordPattern() {
        return "^(?=.*[A-Za-z])(?=.*\\d)(?=.*["+getPasswordPatternSpecialCharacter()+"])[A-Za-z\\d@$!%*?&]*$";
    }

    @Nonnull
    default String getPasswordPatternSpecialCharacter() {
        return "@$!%*?&";
    }

    @Nullable
    default String getPasswordPatternErrorMessage() {
        return Optional.ofNullable(getPasswordPattern())
                .map(s -> ("Password must contain at least one letter, " +
                        "one number, and one special character (%s), " +
                        "and can only include letters, numbers, " +
                        "and these special characters.").formatted(getPasswordPatternSpecialCharacter()))
                .orElse(null);
    }

    @Nullable
    default String getPasswordHelperText() {
        return null;
    }

    @Nullable
    default String getPasswordConfirmEqualsErrorMessage() {
        return "Confirm password must be equals password.";
    }

    @Nullable
    default String getPasswordConfirmHelperText() {
        return null;
    }

}
