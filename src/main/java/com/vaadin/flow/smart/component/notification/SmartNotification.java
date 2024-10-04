package com.vaadin.flow.smart.component.notification;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import jakarta.annotation.Nonnull;

@SuppressWarnings("unused")
public class SmartNotification
        extends Notification {

    protected static final int DEFAULT_DURATION = 5000;
    protected static final Position DEFAULT_POSITION = Position.BOTTOM_START;

    public SmartNotification() {
        super();
    }

    public SmartNotification(@Nonnull String text) {
        super(text);
    }

    public SmartNotification(@Nonnull String text, int duration) {
        super(text, duration);
    }

    public SmartNotification(@Nonnull String text, int duration, @Nonnull Position position) {
        super(text, duration, position);
    }

    public SmartNotification(@Nonnull Component... components) {
        super(components);
    }

    public static SmartNotification show(@Nonnull String text, @Nonnull NotificationVariant notificationVariant) {
        var notification = new SmartNotification(text, DEFAULT_DURATION, DEFAULT_POSITION);
        notification.addThemeVariants(notificationVariant);
        notification.open();
        return notification;
    }

    public static SmartNotification showSuccess(@Nonnull String text) {
        return show(text, NotificationVariant.LUMO_SUCCESS);
    }

    public static SmartNotification showError(@Nonnull String text) {
        return show(text, NotificationVariant.LUMO_ERROR);
    }

    public static SmartNotification showWarning(@Nonnull String text) {
        return show(text, NotificationVariant.LUMO_WARNING);
    }

    public static SmartNotification showPrimary(@Nonnull String text) {
        return show(text, NotificationVariant.LUMO_PRIMARY);
    }

    public static SmartNotification showContrast(@Nonnull String text) {
        return show(text, NotificationVariant.LUMO_CONTRAST);
    }

}
