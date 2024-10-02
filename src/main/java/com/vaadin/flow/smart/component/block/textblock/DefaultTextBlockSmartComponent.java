package com.vaadin.flow.smart.component.block.textblock;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import lombok.*;

@Data
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class DefaultTextBlockSmartComponent
        extends AbstractTextBlockSmartComponent<FlexLayout, H1, Paragraph, Span> {
}
