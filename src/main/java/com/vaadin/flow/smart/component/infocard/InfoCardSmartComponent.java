package com.vaadin.flow.smart.component.infocard;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

public interface InfoCardSmartComponent<C extends FlexLayout> {

    @Nonnull
    C getContent();

    @Nonnull
    <T extends Component & HasText & HasSize> T getTitleComponent();

    @Nullable
    <T extends Component & HasText & HasSize> T getSubTitleComponent();

    @Nullable
    <T extends Component & HasText & HasSize> T getTextComponent();

}
