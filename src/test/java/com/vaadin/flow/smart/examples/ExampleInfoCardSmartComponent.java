package com.vaadin.flow.smart.examples;

import com.vaadin.flow.smart.component.infocard.DefaultInfoCardSmartComponent;
import jakarta.annotation.Nonnull;
import lombok.Getter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SuppressWarnings("unused")
public class ExampleInfoCardSmartComponent
        extends DefaultInfoCardSmartComponent {

    @Getter(onMethod_ = {@Override, @Nonnull})
    private String titleComponentText = "Example title";

    @Getter(onMethod_ = {@Override, @Nonnull})
    private String subTitleComponentText = "Example subtitle";

    @Getter(onMethod_ = {@Override, @Nonnull})
    private String textComponentText = "Example text";

}
