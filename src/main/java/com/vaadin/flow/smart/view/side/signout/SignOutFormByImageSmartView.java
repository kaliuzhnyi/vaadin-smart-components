package com.vaadin.flow.smart.view.side.signout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.smart.component.block.BlockSmartComponent;
import com.vaadin.flow.smart.component.form.signout.SignOutSmartForm;
import com.vaadin.flow.smart.view.side.block.BlockByImageSmartView;
import jakarta.annotation.Nonnull;

@SuppressWarnings("rawtypes")
public interface SignOutFormByImageSmartView<F extends Component & SignOutSmartForm>
        extends BlockByImageSmartView {

    @Nonnull
    F getForm();

    @Nonnull
    @Override
    @SuppressWarnings("unchecked")
    default <T extends Component & BlockSmartComponent> T getBlockContainer() {
        return (T) getForm();
    }

}
