package com.vaadin.flow.component.smart.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import elemental.json.JsonObject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractSmartView<C extends Component & HasSize>
        extends Composite<C>
        implements SmartView, BeforeEnterObserver {

    @Getter
    @Setter(value = AccessLevel.PRIVATE)
    private Info info;

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {

        // Define screen size and run adjusting content for screen
        UI.getCurrent().getPage().executeJs("""
                        return {
                        screenWidth: screen.width,
                        screenHeight: screen.height,
                        innerWidth: window.innerWidth,
                        innerHeight: window.innerHeight,
                        availWidth: screen.availWidth,
                        availHeight: screen.availHeight
                        };""")
                .then(JsonObject.class, result -> {
                    setInfo(Info.builder()
                            .screenWidth(result.getNumber("screenWidth"))
                            .screenHeight(result.getNumber("screenHeight"))
                            .windowWidth(result.getNumber("innerWidth"))
                            .windowHeight(result.getNumber("innerHeight"))
                            .availWidth(result.getNumber("availWidth"))
                            .availHeight(result.getNumber("availHeight"))
                            .build());
                    adjustViewForScreen();
                    getContent().setVisible(true);
                });

        // Set listener for define screen size and adjusting content for screen
        UI.getCurrent().getPage().addBrowserWindowResizeListener(event -> {
            var info = getInfo();
            info.setWindowWidth(event.getWidth());
            info.setWindowHeight(event.getHeight());
            adjustViewForScreen();
        });

    }

    @Override
    protected C initContent() {
        var content = super.initContent();
        content.setSizeFull();
        content.setVisible(false);
        return content;
    }

}
