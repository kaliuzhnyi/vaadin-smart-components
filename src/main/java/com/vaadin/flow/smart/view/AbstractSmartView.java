package com.vaadin.flow.smart.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.smart.data.DeviceInfo;
import com.vaadin.flow.smart.data.DevicePlatform;
import com.vaadin.flow.smart.data.DeviceType;
import com.vaadin.flow.smart.data.ScreenInfo;
import elemental.json.JsonObject;
import jakarta.annotation.Nonnull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@CssImport(value = "frontend://styles/styles.css")
public abstract class AbstractSmartView<C extends Component & FlexComponent & HasSize>
        extends Composite<C>
        implements SmartView, BeforeEnterObserver, AfterNavigationObserver {

    @Getter(onMethod_ = {@Override, @Nonnull})
    @Setter(onParam_ = {@Nonnull}, value = AccessLevel.PRIVATE)
    private ScreenInfo screenInfo;

    @Getter(onMethod_ = {@Override, @Nonnull})
    @Setter(onParam_ = {@Nonnull}, value = AccessLevel.PRIVATE)
    private DeviceInfo deviceInfo;

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
                        availHeight: screen.availHeight,
                        scrollWidth: document.documentElement.scrollWidth,
                        scrollHeight: document.documentElement.scrollHeight
                        userAgent: navigator.userAgent
                        };""")
                .then(JsonObject.class, result -> {

                    setScreenInfo(ScreenInfo.builder()
                            .screenWidth(result.getNumber("screenWidth"))
                            .screenHeight(result.getNumber("screenHeight"))
                            .windowWidth(result.getNumber("innerWidth"))
                            .windowHeight(result.getNumber("innerHeight"))
                            .availWidth(result.getNumber("availWidth"))
                            .availHeight(result.getNumber("availHeight"))
                            .scrollWidth(result.getNumber("scrollWidth"))
                            .availHeight(result.getNumber("scrollHeight"))
                            .build());

                    setDeviceInfo(DeviceInfo.builder()
                            .userAgent(result.getString("userAgent"))
                            .deviceType(DeviceType.determinateFromUserAgent(result.getString("userAgent")))
                            .devicePlatform(DevicePlatform.determinateFromUserAgent(result.getString("userAgent")))
                            .build());

                    adjustViewForScreen();
                    getContent().setVisible(true);
                });

        // Set listener for define screen size and adjusting content for screen
        UI.getCurrent().getPage().addBrowserWindowResizeListener(event -> {
            var info = getScreenInfo();
            info.setWindowWidth(event.getWidth());
            info.setWindowHeight(event.getHeight());
            adjustViewForScreen();
        });

    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        // Do nothing here
        // It's just stub method
        // This method is only for overriding
    }

    @Override
    protected C initContent() {
        var content = super.initContent();
        content.setSizeFull();
        content.setVisible(false);
        content.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        content.setAlignItems(FlexComponent.Alignment.CENTER);
        return content;
    }

}
