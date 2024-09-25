package com.vaadin.flow.smart.view.side;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

public abstract class AbstractSideByImageSmartView<C extends FlexLayout>
        extends AbstractSideBySideSmartView<C>
        implements SideByImageSmartView {

    @Autowired
    @Getter(onMethod_ = {@Nonnull}, value = AccessLevel.PROTECTED)
    private ResourceLoader resourceLoader;

    @Getter(onMethod_ = {@Override, @Nonnull}, lazy = true)
    private final Image imageContainer = initImageContainer();

    @Nonnull
    @Override
    protected FlexLayout initPrimarySide() {
        var side = super.initPrimarySide();
        side.add(
                getImageContainer()
        );
        return side;
    }

    @Override
    public void adjustPrimarySideForScreen() {
        super.adjustPrimarySideForScreen();
        if (determinateFlexDirection().equals(FlexLayout.FlexDirection.ROW)) {
            getPrimarySide().setAlignItems(FlexComponent.Alignment.END);
        } else {
            getPrimarySide().setAlignItems(FlexComponent.Alignment.CENTER);
        }
    }

    @Nonnull
    @Override
    protected FlexLayout initSecondarySide() {
        var side = super.initSecondarySide();
        side.add(
                getContentContainer()
        );
        return side;
    }

    @Nonnull
    protected Image initImageContainer() {
        var image = new Image();
        image.setId("side-by-image-smart-view-image-container");
        image.setWidth(null);
        image.setMaxWidth(100, Unit.PERCENTAGE);
        image.addClassNames(
                LumoUtility.BorderRadius.MEDIUM,
                LumoUtility.Margin.LARGE
        );

        Optional.ofNullable(getImageResourcePath())
                .map(this::getFileFromResources)
                .filter(Predicate.not(v -> Arrays.equals(v, new byte[0])))
                .ifPresent(v -> {
                    var streamResource = new StreamResource("Image",
                            () -> new ByteArrayInputStream(v));
                    image.setSrc(streamResource);
                });

        return image;
    }

    @Nullable
    protected String getImageResourcePath() {
        return null;
    }

    @Nonnull
    @SneakyThrows
    private byte[] getFileFromResources(@Nonnull String path) {
        var resource = getResourceLoader().getResource("classpath:" + path);
        return Files.readAllBytes(resource.getFile().toPath());
    }

}
