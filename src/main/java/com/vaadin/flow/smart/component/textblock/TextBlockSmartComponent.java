package com.vaadin.flow.smart.component.textblock;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasText;
import jakarta.annotation.Nonnull;

public interface TextBlockSmartComponent {

    @Nonnull
    <T extends Component & HasText> T getTitleComponent();

    @Nonnull
    <T extends Component & HasText> T getTextComponent();

    @Nonnull
    <T extends Component & HasText> T getRemarkComponent();

}
