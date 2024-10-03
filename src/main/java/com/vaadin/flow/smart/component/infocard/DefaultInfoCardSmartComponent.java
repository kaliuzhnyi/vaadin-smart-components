package com.vaadin.flow.smart.component.infocard;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import lombok.*;

import java.util.List;

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

    private List<String> subTitleComponentTextParts;

    private List<Component> subTitleComponentTextComponents;

}
