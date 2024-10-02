package com.vaadin.flow.smart.component.infocard;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import jakarta.annotation.Nonnull;

public interface InfoCardSmartComponent<C extends FlexLayout> {

    @Nonnull
    C getContent();

    <T extends Component & HasText & HasSize> T getTitleComponent();

    <T extends Component & HasText & HasSize> T getSubTitleComponent();

    <T extends Component & HasText & HasSize> T getTextComponent();

}
