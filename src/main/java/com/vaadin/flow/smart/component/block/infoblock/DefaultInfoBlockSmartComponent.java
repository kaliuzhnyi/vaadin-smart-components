package com.vaadin.flow.smart.component.block.infoblock;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.smart.component.infocard.DefaultInfoCardSmartComponent;
import lombok.*;

@Data
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class DefaultInfoBlockSmartComponent
        extends AbstractInfoBlockSmartComponent<FlexLayout, H1, Paragraph, DefaultInfoCardSmartComponent> {
}
