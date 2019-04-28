package com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui.logic.pipeline;

import com.ldtteam.jvoxelizer.client.gui.IGui;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.core.logic.VoidPipelineElementContext;

import java.util.List;
import java.util.function.Consumer;

public class ForgeGuiPipeline<O extends IGui<I>, I>
{
    private final List<Consumer<VoidPipelineElementContext<DrawCenteredStringContext, O, I>>>    DrawCenteredStringPipeline;
    private final List<Consumer<VoidPipelineElementContext<DrawGradientRectContext, O, I>>>      DrawGradientRectPipeline;
    private final List<Consumer<VoidPipelineElementContext<DrawTexturedModalRectContext, O, I>>> DrawTexturedModalRectPipeline;
    private final List<Consumer<VoidPipelineElementContext<DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntContext, O, I>>>
                                                                                                 DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntPipeline;
    private final List<Consumer<VoidPipelineElementContext<DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntContext, O, I>>>
                                                                                                 DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntPipeline;
    private final List<Consumer<VoidPipelineElementContext<DrawHorizontalLineContext, O, I>>>    DrawHorizontalLinePipeline;
    private final List<Consumer<VoidPipelineElementContext<DrawStringContext, O, I>>>            DrawStringPipeline;
    private final List<Consumer<VoidPipelineElementContext<DrawVerticalLineContext, O, I>>>      DrawVerticalLinePipeline;

    public ForgeGuiPipeline(
      final List<Consumer<VoidPipelineElementContext<DrawCenteredStringContext, O, I>>> drawCenteredStringPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawGradientRectContext, O, I>>> drawGradientRectPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawTexturedModalRectContext, O, I>>> drawTexturedModalRectPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntContext, O, I>>> drawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntContext, O, I>>> drawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawHorizontalLineContext, O, I>>> drawHorizontalLinePipeline,
      final List<Consumer<VoidPipelineElementContext<DrawStringContext, O, I>>> drawStringPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawVerticalLineContext, O, I>>> drawVerticalLinePipeline)
    {
        DrawCenteredStringPipeline = drawCenteredStringPipeline;
        DrawGradientRectPipeline = drawGradientRectPipeline;
        DrawTexturedModalRectPipeline = drawTexturedModalRectPipeline;
        DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntPipeline =
          drawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntPipeline;
        DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntPipeline =
          drawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntPipeline;
        DrawHorizontalLinePipeline = drawHorizontalLinePipeline;
        DrawStringPipeline = drawStringPipeline;
        DrawVerticalLinePipeline = drawVerticalLinePipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DrawCenteredStringContext, O, I>>> getDrawCenteredStringPipeline()
    {
        return DrawCenteredStringPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DrawGradientRectContext, O, I>>> getDrawGradientRectPipeline()
    {
        return DrawGradientRectPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DrawTexturedModalRectContext, O, I>>> getDrawTexturedModalRectPipeline()
    {
        return DrawTexturedModalRectPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntContext, O, I>>> getDrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntPipeline()
    {
        return DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntContext, O, I>>> getDrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntPipeline()
    {
        return DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DrawHorizontalLineContext, O, I>>> getDrawHorizontalLinePipeline()
    {
        return DrawHorizontalLinePipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DrawStringContext, O, I>>> getDrawStringPipeline()
    {
        return DrawStringPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DrawVerticalLineContext, O, I>>> getDrawVerticalLinePipeline()
    {
        return DrawVerticalLinePipeline;
    }
}
