package com.vaadin.flow.smart.component.infocard;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class DefaultInfoCardSmartComponent
        extends AbstractInfoCardSmartComponent<FlexLayout, Span, Span, Span> {

    private String titleComponentText;

    private String subTitleComponentText;

    private String textComponentText;

}
