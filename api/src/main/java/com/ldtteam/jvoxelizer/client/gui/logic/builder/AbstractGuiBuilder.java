package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.*;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts.*;
import java.util.function.Consumer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.ldtteam.jvoxelizer.core.logic.*;

public abstract class AbstractGuiBuilder<C extends AbstractGuiBuilder<C, I>, I> {

    public C DrawCenteredString(Consumer<VoidPipelineElementContext<DrawCenteredStringContext>>... components) {
        this.DrawCenteredStringPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawCenteredStringContext>>> DrawCenteredStringPipeline = new ArrayList<>();

    public C DrawGradientRect(Consumer<VoidPipelineElementContext<DrawGradientRectContext>>... components) {
        this.DrawGradientRectPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawGradientRectContext>>> DrawGradientRectPipeline = new ArrayList<>();

    public C DrawTexturedModalRect(Consumer<VoidPipelineElementContext<DrawTexturedModalRectContext>>... components) {
        this.DrawTexturedModalRectPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawTexturedModalRectContext>>> DrawTexturedModalRectPipeline = new ArrayList<>();

    public C DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsInt(Consumer<VoidPipelineElementContext<DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntContext>>... components) {
        this.DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntContext>>> DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntPipeline = new ArrayList<>();

    public C DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsInt(Consumer<VoidPipelineElementContext<DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntContext>>... components) {
        this.DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntContext>>> DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntPipeline = new ArrayList<>();

    public C DrawHorizontalLine(Consumer<VoidPipelineElementContext<DrawHorizontalLineContext>>... components) {
        this.DrawHorizontalLinePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawHorizontalLineContext>>> DrawHorizontalLinePipeline = new ArrayList<>();

    public C DrawString(Consumer<VoidPipelineElementContext<DrawStringContext>>... components) {
        this.DrawStringPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawStringContext>>> DrawStringPipeline = new ArrayList<>();

    public C DrawVerticalLine(Consumer<VoidPipelineElementContext<DrawVerticalLineContext>>... components) {
        this.DrawVerticalLinePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawVerticalLineContext>>> DrawVerticalLinePipeline = new ArrayList<>();

    public abstract IGui<I> build(I guiContext);
}
