package com.vaadin.flow.smart.view.side.signup;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.smart.component.form.signup.SignUpSmartForm;
import com.vaadin.flow.smart.util.GenericUtils;
import com.vaadin.flow.smart.view.side.AbstractSideByImageSmartView;
import jakarta.annotation.Nonnull;
import lombok.Getter;

@SuppressWarnings("rawtypes")
public abstract class AbstractSignUpFormByImageSmartView<C extends FlexLayout,
        F extends Component & SignUpSmartForm>
        extends AbstractSideByImageSmartView<C>
        implements SignUpFormByImageSmartView<F> {

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final F form = initForm();

    @Nonnull
    protected F initForm() {
        Class<F> type = GenericUtils.getType(getClass(), AbstractSignUpFormByImageSmartView.class, 1);
        var form = getBeanFactory().createBean(type);
        form.setId("signup-form-by-image-smart-view-form");
        return form;
    }

}
