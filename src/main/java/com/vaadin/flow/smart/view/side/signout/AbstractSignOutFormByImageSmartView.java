package com.vaadin.flow.smart.view.side.signout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.smart.component.form.signout.SignOutSmartForm;
import com.vaadin.flow.smart.util.GenericUtils;
import com.vaadin.flow.smart.view.side.AbstractSideByImageSmartView;
import jakarta.annotation.Nonnull;
import lombok.Getter;

@SuppressWarnings("rawtypes")
public abstract class AbstractSignOutFormByImageSmartView<C extends FlexLayout,
        F extends Component & SignOutSmartForm>
        extends AbstractSideByImageSmartView<C>
        implements SignOutFormByImageSmartView<F> {

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final F form = initForm();

    @Nonnull
    protected F initForm() {
        Class<F> type = GenericUtils.getType(getClass(), AbstractSignOutFormByImageSmartView.class, 1);
        var form = getBeanFactory().createBean(type);
        form.setId("signout-form-by-image-smart-view-form");
        form.getContent().setWidth(50, Unit.PERCENTAGE);
        return form;
    }

}
