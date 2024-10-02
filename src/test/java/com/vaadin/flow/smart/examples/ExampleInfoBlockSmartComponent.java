package com.vaadin.flow.smart.examples;

import com.vaadin.flow.smart.component.block.infoblock.DefaultInfoBlockSmartComponent;
import com.vaadin.flow.smart.component.infocard.DefaultInfoCardSmartComponent;
import jakarta.annotation.Nonnull;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SuppressWarnings("unused")
public class ExampleInfoBlockSmartComponent
        extends DefaultInfoBlockSmartComponent {

    @Getter(onMethod_ = {@Override, @Nonnull})
    private String titleComponentText = "Title";

    @Getter(onMethod_ = {@Override, @Nonnull})
    private String textComponentText = "Text";

    @PostConstruct
    protected void init() {
        var cards = getCardComponents();
        cards.add(
                DefaultInfoCardSmartComponent.builder()
                        .titleComponentText("Senior Software Engineer")
                        .subTitleComponentText("California · Remote")
                        .textComponentText("""
                                Lorem ipsum odor amet, consectetuer adipiscing elit.
                                Tincidunt phasellus potenti eget, lorem at maecenas.
                                Aenean etiam hac aenean cubilia consectetur aptent molestie est ultricies.
                                Massa odio conubia elit lobortis placerat dictumst dapibus convallis eget.
                                Commodo lobortis ex risus enim blandit non maximus accumsan. Netus efficitur arcu vehicula aptent volutpat pretium.
                                """)
                        .build()
        );
        cards.add(
                DefaultInfoCardSmartComponent.builder()
                        .titleComponentText("Middle Software Engineer")
                        .subTitleComponentText("Toronto · Remote")
                        .textComponentText("""
                                Lorem ipsum odor amet, consectetuer adipiscing elit.
                                Tincidunt phasellus potenti eget, lorem at maecenas.
                                Aenean etiam hac aenean cubilia consectetur aptent molestie est ultricies.
                                """)
                        .build()
        );
    }

}
