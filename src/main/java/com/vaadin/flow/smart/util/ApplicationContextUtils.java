package com.vaadin.flow.smart.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtils {

    @Getter
    private static ApplicationContext context;

    @Autowired
    public void setApplicationContext(ApplicationContext context) {
        ApplicationContextUtils.context = context;
    }

}
