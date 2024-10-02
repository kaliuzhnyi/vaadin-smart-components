package com.vaadin.flow.smart.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.smart.util.ApplicationContextUtils;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.MessageSource;

import java.util.Optional;

@SuppressWarnings("unused")
public abstract class AbstractSmartComponent<C extends Component>
        extends Composite<C> {

    @Autowired
    private AutowireCapableBeanFactory beanFactory;

    @Autowired
    private MessageSource messageSource;

    @Override
    @Nonnull
    public C getContent() {
        return super.getContent();
    }

    @Nonnull
    protected AutowireCapableBeanFactory getBeanFactory() {
        return Optional.ofNullable(beanFactory)
                .orElseGet(() -> {
                    beanFactory = ApplicationContextUtils.getContext().getAutowireCapableBeanFactory();
                    return beanFactory;
                });
    }

    @Nonnull
    protected MessageSource getMessageSource() {
        return Optional.ofNullable(messageSource)
                .orElseGet(() -> {
                    messageSource = ApplicationContextUtils.getContext().getBean(MessageSource.class);
                    return messageSource;
                });
    }

    @Nullable
    protected String getMessage(@Nullable String code) {
        return Optional.ofNullable(code)
                .map(c -> getMessageSource().getMessage(code, null, getLocale()))
                .orElse(null);
    }

}
