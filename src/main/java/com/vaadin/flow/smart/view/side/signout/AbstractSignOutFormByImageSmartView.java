package com.vaadin.flow.smart.view.side.signout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.smart.component.form.signout.SignOutSmartForm;
import com.vaadin.flow.smart.view.side.block.AbstractBlockByImageSmartView;
import jakarta.annotation.Nonnull;

@SuppressWarnings("rawtypes")
public abstract class AbstractSignOutFormByImageSmartView<C extends FlexLayout,
        F extends Component & SignOutSmartForm>
        extends AbstractBlockByImageSmartView<C, F>
        implements SignOutFormByImageSmartView<F> {

    @Nonnull
    @Override
    public F getForm() {
        return getBlockContainer();
    }

}
