package com.vaadin.flow.smart.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.smart.util.ApplicationContextUtils;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.MessageSource;

import java.util.Locale;
import java.util.Optional;

@SuppressWarnings("unused")
public abstract class AbstractSmartComponent<C extends Component>
        extends Composite<C>
        implements SmartComponent<C> {

    @Autowired
    private AutowireCapableBeanFactory beanFactory;

    @Autowired(required = false)
    @Getter(value = AccessLevel.PROTECTED, onMethod_ = {@Nullable})
    private MessageSource messageSource;

    @Nonnull
    protected AutowireCapableBeanFactory getBeanFactory() {
        return Optional.ofNullable(beanFactory)
                .orElseGet(() -> {
                    beanFactory = ApplicationContextUtils.getContext().getAutowireCapableBeanFactory();
                    return beanFactory;
                });
    }

    @Nullable
    protected String getMessage(@Nullable String code, @Nullable Object... params) {
        return getMessage(code, getLocale(), params);
    }

    @Nullable
    protected String getMessage(@Nullable String code, @Nonnull Locale locale, @Nullable Object... params) {

        if (StringUtils.isBlank(code)) {
            return null;
        }

        return Optional.ofNullable(getMessageSource())
                .map(ms -> ms.getMessage(code, params, locale))
                .orElseGet(() -> getTranslation(locale, code, params));

    }

}
