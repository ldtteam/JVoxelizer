package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.pipeline;

import com.ldtteam.jvoxelizer.client.gui.IGuiButton;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.core.logic.TypedPipelineElementContext;
import com.ldtteam.jvoxelizer.core.logic.VoidPipelineElementContext;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ForgeGuiButtonPipeline<O extends IGuiButton<I>, I> extends ForgeGuiPipeline<O, I>
{
    private final List<Consumer<VoidPipelineElementContext<MouseReleasedContext, O, I>>> MouseReleasedPipeline;
    private final List<Function<TypedPipelineElementContext<IsMouseOverContext, Boolean, O, I>, Boolean>> IsMouseOverPipeline;
    private final List<Consumer<VoidPipelineElementContext<MouseDraggedContext, O, I>>> MouseDraggedPipeline;
    private final List<Function<TypedPipelineElementContext<GetHoverStateContext, Integer, O, I>, Integer>> GetHoverStatePipeline;
    private final List<Consumer<VoidPipelineElementContext<PlayPressSoundContext, O, I>>> PlayPressSoundPipeline;
    private final List<Consumer<VoidPipelineElementContext<DrawButtonForegroundLayerContext, O, I>>> DrawButtonForegroundLayerPipeline;
    private final List<Function<TypedPipelineElementContext<GetButtonWidthContext, Integer, O, I>, Integer>> GetButtonWidthPipeline;
    private final List<Consumer<VoidPipelineElementContext<SetWidthContext, O, I>>> SetWidthPipeline;
    private final List<Consumer<VoidPipelineElementContext<DrawButtonContext, O, I>>> DrawButtonPipeline;
    private final List<Function<TypedPipelineElementContext<MousePressedContext, Boolean, O, I>, Boolean>> MousePressedPipeline;

    public ForgeGuiButtonPipeline(
      final List<Consumer<VoidPipelineElementContext<DrawCenteredStringContext, O, I>>> drawCenteredStringPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawGradientRectContext, O, I>>> drawGradientRectPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawTexturedModalRectContext, O, I>>> drawTexturedModalRectPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntContext, O, I>>> drawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntContext, O, I>>> drawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawHorizontalLineContext, O, I>>> drawHorizontalLinePipeline,
      final List<Consumer<VoidPipelineElementContext<DrawStringContext, O, I>>> drawStringPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawVerticalLineContext, O, I>>> drawVerticalLinePipeline,
      final List<Consumer<VoidPipelineElementContext<MouseReleasedContext, O, I>>> mouseReleasedPipeline,
      final List<Function<TypedPipelineElementContext<IsMouseOverContext, Boolean, O, I>, Boolean>> isMouseOverPipeline,
      final List<Consumer<VoidPipelineElementContext<MouseDraggedContext, O, I>>> mouseDraggedPipeline,
      final List<Function<TypedPipelineElementContext<GetHoverStateContext, Integer, O, I>, Integer>> getHoverStatePipeline,
      final List<Consumer<VoidPipelineElementContext<PlayPressSoundContext, O, I>>> playPressSoundPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawButtonForegroundLayerContext, O, I>>> drawButtonForegroundLayerPipeline,
      final List<Function<TypedPipelineElementContext<GetButtonWidthContext, Integer, O, I>, Integer>> getButtonWidthPipeline,
      final List<Consumer<VoidPipelineElementContext<SetWidthContext, O, I>>> setWidthPipeline,
      final List<Consumer<VoidPipelineElementContext<DrawButtonContext, O, I>>> drawButtonPipeline,
      final List<Function<TypedPipelineElementContext<MousePressedContext, Boolean, O, I>, Boolean>> mousePressedPipeline)
    {
        super(drawCenteredStringPipeline,
          drawGradientRectPipeline,
          drawTexturedModalRectPipeline,
          drawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntPipeline,
          drawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntPipeline,
          drawHorizontalLinePipeline,
          drawStringPipeline,
          drawVerticalLinePipeline);
        MouseReleasedPipeline = mouseReleasedPipeline;
        IsMouseOverPipeline = isMouseOverPipeline;
        MouseDraggedPipeline = mouseDraggedPipeline;
        GetHoverStatePipeline = getHoverStatePipeline;
        PlayPressSoundPipeline = playPressSoundPipeline;
        DrawButtonForegroundLayerPipeline = drawButtonForegroundLayerPipeline;
        GetButtonWidthPipeline = getButtonWidthPipeline;
        SetWidthPipeline = setWidthPipeline;
        DrawButtonPipeline = drawButtonPipeline;
        MousePressedPipeline = mousePressedPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<MouseReleasedContext, O, I>>> getMouseReleasedPipeline()
    {
        return MouseReleasedPipeline;
    }

    public List<Function<TypedPipelineElementContext<IsMouseOverContext, Boolean, O, I>, Boolean>> getIsMouseOverPipeline()
    {
        return IsMouseOverPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<MouseDraggedContext, O, I>>> getMouseDraggedPipeline()
    {
        return MouseDraggedPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetHoverStateContext, Integer, O, I>, Integer>> getGetHoverStatePipeline()
    {
        return GetHoverStatePipeline;
    }

    public List<Consumer<VoidPipelineElementContext<PlayPressSoundContext, O, I>>> getPlayPressSoundPipeline()
    {
        return PlayPressSoundPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DrawButtonForegroundLayerContext, O, I>>> getDrawButtonForegroundLayerPipeline()
    {
        return DrawButtonForegroundLayerPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetButtonWidthContext, Integer, O, I>, Integer>> getGetButtonWidthPipeline()
    {
        return GetButtonWidthPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<SetWidthContext, O, I>>> getSetWidthPipeline()
    {
        return SetWidthPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DrawButtonContext, O, I>>> getDrawButtonPipeline()
    {
        return DrawButtonPipeline;
    }

    public List<Function<TypedPipelineElementContext<MousePressedContext, Boolean, O, I>, Boolean>> getMousePressedPipeline()
    {
        return MousePressedPipeline;
    }
}
