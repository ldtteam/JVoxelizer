package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.IGui;
import com.ldtteam.jvoxelizer.client.gui.IGuiButton;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.core.logic.VoidPipelineElementContext;

import java.util.function.Consumer;

public interface IGuiBuilder<C extends IGuiBuilder<C, I, O>, I, O extends IGui<I>>
{
    static <T> IGuiBuilder<?, T, IGui<T>> create(T instanceData)
    {
        return IGuiBuilderProviderHolder.getInstance().provide(instanceData);
    }

    C DrawCenteredString(Consumer<VoidPipelineElementContext<DrawCenteredStringContext, O, I>>... components);

    C DrawGradientRect(Consumer<VoidPipelineElementContext<DrawGradientRectContext, O, I>>... components);

    C DrawTexturedModalRect(Consumer<VoidPipelineElementContext<DrawTexturedModalRectContext, O, I>>... components);

    C DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsInt(Consumer<VoidPipelineElementContext<DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntContext, O, I>>... components);

    C DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsInt(Consumer<VoidPipelineElementContext<DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntContext, O, I>>... components);

    C DrawHorizontalLine(Consumer<VoidPipelineElementContext<DrawHorizontalLineContext, O, I>>... components);

    C DrawString(Consumer<VoidPipelineElementContext<DrawStringContext, O, I>>... components);

    C DrawVerticalLine(Consumer<VoidPipelineElementContext<DrawVerticalLineContext, O, I>>... components);

    O build();
}
