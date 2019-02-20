package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.*;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts.*;
import java.util.function.Consumer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.ldtteam.jvoxelizer.core.logic.*;

public abstract class AbstractGuiBuilder<C extends AbstractGuiBuilder<C, I, O>, I, O extends IGui<I>> implements IGuiBuilder<C, I, O>
{

    @Override
    public C DrawCenteredString(Consumer<VoidPipelineElementContext<DrawCenteredStringContext, O, I>>... components) {
        this.DrawCenteredStringPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawCenteredStringContext, O, I>>> DrawCenteredStringPipeline = new ArrayList<>();

    @Override
    public C DrawGradientRect(Consumer<VoidPipelineElementContext<DrawGradientRectContext, O, I>>... components) {
        this.DrawGradientRectPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawGradientRectContext, O, I>>> DrawGradientRectPipeline = new ArrayList<>();

    @Override
    public C DrawTexturedModalRect(Consumer<VoidPipelineElementContext<DrawTexturedModalRectContext, O, I>>... components) {
        this.DrawTexturedModalRectPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawTexturedModalRectContext, O, I>>> DrawTexturedModalRectPipeline = new ArrayList<>();

    @Override
    public C DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsInt(Consumer<VoidPipelineElementContext<DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntContext, O, I>>... components) {
        this.DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntContext, O, I>>> DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntPipeline = new ArrayList<>();

    @Override
    public C DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsInt(Consumer<VoidPipelineElementContext<DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntContext, O, I>>... components) {
        this.DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntContext, O, I>>> DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntPipeline = new ArrayList<>();

    @Override
    public C DrawHorizontalLine(Consumer<VoidPipelineElementContext<DrawHorizontalLineContext, O, I>>... components) {
        this.DrawHorizontalLinePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawHorizontalLineContext, O, I>>> DrawHorizontalLinePipeline = new ArrayList<>();

    @Override
    public C DrawString(Consumer<VoidPipelineElementContext<DrawStringContext, O, I>>... components) {
        this.DrawStringPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawStringContext, O, I>>> DrawStringPipeline = new ArrayList<>();

    @Override
    public C DrawVerticalLine(Consumer<VoidPipelineElementContext<DrawVerticalLineContext, O, I>>... components) {
        this.DrawVerticalLinePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DrawVerticalLineContext, O, I>>> DrawVerticalLinePipeline = new ArrayList<>();
}
