package com.vaadin.flow.smart.examples;

import com.vaadin.flow.smart.component.block.textblock.DefaultTextBlockSmartComponent;
import jakarta.annotation.Nonnull;
import lombok.Getter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SuppressWarnings("unused")
public class ExampleTextBlockSmartComponent
        extends DefaultTextBlockSmartComponent {

    @Getter(onMethod_ = {@Override, @Nonnull})
    private String titleComponentText = "Title";

    @Getter(onMethod_ = {@Override, @Nonnull})
    private String textComponentText = "Text";

    @Getter(onMethod_ = {@Override, @Nonnull})
    private String remarkComponentText = "Remark";

}
