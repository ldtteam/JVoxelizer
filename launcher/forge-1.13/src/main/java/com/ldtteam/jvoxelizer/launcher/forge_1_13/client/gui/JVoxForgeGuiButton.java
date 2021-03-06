package com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.client.gui.IGuiButton;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.client.mouse.IMouse;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.core.logic.PipelineProcessor;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.GameEngine;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.GameEngineProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui.logic.pipeline.ForgeGuiButtonPipeline;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.font.FontRenderer;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.texture.Sprite;
import com.ldtteam.jvoxelizer.sound.ISoundHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class JVoxForgeGuiButton<I> extends GuiButton implements IGuiButton<I>
{

    private final I                                        instanceData;
    private final ForgeGuiButtonPipeline<IGuiButton<I>, I> pipeline;

    public JVoxForgeGuiButton(
      final int buttonId,
      final int x,
      final int y,
      final String buttonText,
      final I instanceData,
      final ForgeGuiButtonPipeline<IGuiButton<I>, I> pipeline)
    {
        super(buttonId, x, y, buttonText);
        this.instanceData = instanceData;
        this.pipeline = pipeline;
    }

    @Override
    public int getHoverState(final boolean mouseOver)
    {
        return PipelineProcessor.processTypedPipeline(this, new GetHoverStateContext(mouseOver), pipeline.getGetHoverStatePipeline(), (c) -> super.getHoverState(c.getMouseOver()));
    }

    @Override
    public void render(final int mouseX, final int mouseY, final float partialTicks)
    {

        PipelineProcessor.processVoidPipeline(this,
          new DrawButtonContext(GameEngineProvider.getInstance().provide(), mouseX, mouseY, partialTicks),
          pipeline.getDrawButtonPipeline(),
          c -> super.render(c.getMouseX(), c.getMouseY(), c.getPartialTicks()));
    }

    @Override
    public boolean mouseDragged(
      final double p_mouseDragged_1_,
      final double p_mouseDragged_3_,
      final int p_mouseDragged_5_,
      final double p_mouseDragged_6_,
      final double p_mouseDragged_8_)
    {
        PipelineProcessor.processVoidPipeline(this,
          new MouseDraggedContext(IGameEngine.getInstance(), (int) p_mouseDragged_1_, (int) p_mouseDragged_3_),
          pipeline.getMouseDraggedPipeline(),
          c -> super.mouseDragged(c.getMouseX(), c.getMouseY(), p_mouseDragged_5_, p_mouseDragged_6_, p_mouseDragged_8_));

        return !pipeline.getMouseDraggedPipeline().isEmpty();
    }

    @Override
    public boolean mouseReleased(final double p_mouseReleased_1_, final double p_mouseReleased_3_, final int p_mouseReleased_5_)
    {
        PipelineProcessor.processVoidPipeline(this,
          new MouseReleasedContext((int) p_mouseReleased_1_, (int) p_mouseReleased_3_, p_mouseReleased_5_),
          pipeline.getMouseReleasedPipeline(),
          c -> super.mouseReleased(c.getMouseX(), c.getMouseY(), c.getState()));

        return !pipeline.getMouseDraggedPipeline().isEmpty();
    }

    @Override
    public boolean mouseClicked(final double p_mouseClicked_1_, final double p_mouseClicked_3_, final int p_mouseClicked_5_)
    {
        return PipelineProcessor.processTypedPipeline(this,
          new MousePressedContext(IGameEngine.getInstance(), (int) p_mouseClicked_1_, (int) p_mouseClicked_3_),
          pipeline.getMousePressedPipeline(),
          c -> super.mouseClicked(c.getMouseX(), c.getMouseY(), p_mouseClicked_5_)
        );
    }

    @Override
    public boolean isMouseOver()
    {
        return PipelineProcessor.processTypedPipeline(this, new IsMouseOverContext(), pipeline.getIsMouseOverPipeline(), c -> super.isMouseOver());
    }

    @Override
    public void drawButtonForegroundLayer(final int mouseX, final int mouseY)
    {
        PipelineProcessor.processVoidPipeline(this,
          new DrawButtonForegroundLayerContext(mouseX, mouseY),
          pipeline.getDrawButtonForegroundLayerPipeline(),
          c -> super.drawButtonForegroundLayer(c.getMouseX(), c.getMouseY()));
    }

    @Override
    public void playPressSound(final SoundHandler soundHandlerIn)
    {
        this.playPressSound(com.ldtteam.jvoxelizer.launcher.forge_1_13.sound.SoundHandler.fromForge(soundHandlerIn));
    }

    @Override
    public int getButtonWidth()
    {
        return PipelineProcessor.processTypedPipeline(this, new GetButtonWidthContext(), pipeline.getGetButtonWidthPipeline(), c -> super.getWidth());
    }

    @Override
    public void setWidth(final int width)
    {
        PipelineProcessor.processVoidPipeline(this, new SetWidthContext(width), pipeline.getSetWidthPipeline(), c -> super.setWidth(c.getWidth()));
    }

    @Override
    public void drawButton(final IGameEngine mc, final int mouseX, final int mouseY, final float partialTicks)
    {
    }

    @Override
    public void mouseReleased(final int mouseX, final int mouseY)
    {
        this.mouseReleased(mouseX, mouseY, 0);
    }

    @Override
    public boolean mousePressed(final IGameEngine mc, final int mouseX, final int mouseY)
    {
        return this.mouseClicked(mouseX, mouseY, 0);
    }

    @Override
    public void playPressSound(final ISoundHandler soundHandlerIn)
    {
        PipelineProcessor.processVoidPipeline(this,
          new PlayPressSoundContext(soundHandlerIn),
          pipeline.getPlayPressSoundPipeline(),
          c -> super.playPressSound(com.ldtteam.jvoxelizer.launcher.forge_1_13.sound.SoundHandler.asForge(c.getSoundHandlerIn())));
    }

    @Override
    public void drawHorizontalLine(final int startX, final int endX, final int y, final int color)
    {
        PipelineProcessor.processVoidPipeline(this,
          new DrawHorizontalLineContext(startX, endX, y, color),
          pipeline.getDrawHorizontalLinePipeline(),
          (c) -> super.drawHorizontalLine(c.getStartX(), c.getEndX(), c.getY(), c.getColor()));
    }

    @Override
    public void drawVerticalLine(final int x, final int startY, final int endY, final int color)
    {
        PipelineProcessor.processVoidPipeline(this,
          new DrawVerticalLineContext(x, startY, endY, color),
          pipeline.getDrawVerticalLinePipeline(),
          (c) -> super.drawVerticalLine(c.getX(), c.getStartY(), c.getEndY(), c.getColor()));
    }

    @Override
    public void drawGradientRect(final int left, final int top, final int right, final int bottom, final int startColor, final int endColor)
    {
        PipelineProcessor.processVoidPipeline(this,
          new DrawGradientRectContext(left, top, right, bottom, startColor, endColor),
          pipeline.getDrawGradientRectPipeline(),
          (c) -> super.drawGradientRect(c.getLeft(), c.getTop(), c.getRight(), c.getBottom(), c.getStartColor(), c.getEndColor()));
    }

    @Override
    public void drawCenteredString(final IFontRenderer fontRendererIn, final String text, final int x, final int y, final int color)
    {
        PipelineProcessor.processVoidPipeline(this,
          new DrawCenteredStringContext(fontRendererIn, text, x, y, color),
          pipeline.getDrawCenteredStringPipeline(),
          (c) -> super.drawCenteredString(FontRenderer.asForge(c.getFontRendererIn()), c.getText(), c.getX(), c.getY(), c.getColor()));
    }

    @Override
    public void drawString(final IFontRenderer fontRendererIn, final String text, final int x, final int y, final int color)
    {
        PipelineProcessor.processVoidPipeline(this,
          new DrawStringContext(fontRendererIn, text, x, y, color),
          pipeline.getDrawStringPipeline(),
          (c) -> super.drawString(FontRenderer.asForge(c.getFontRendererIn()), c.getText(), c.getX(), c.getY(), c.getColor()));
    }

    @Override
    public void drawCenteredString(final net.minecraft.client.gui.FontRenderer fontRendererIn, final String text, final int x, final int y, final int color)
    {
        this.drawCenteredString(FontRenderer.fromForge(fontRendererIn), text, x, y, color);
    }

    @Override
    public void drawString(final net.minecraft.client.gui.FontRenderer fontRendererIn, final String text, final int x, final int y, final int color)
    {
        this.drawString(FontRenderer.fromForge(fontRendererIn), text, x, y, color);
    }

    @Override
    public void drawTexturedModalRect(final int xCoord, final int yCoord, final ISprite textureSprite, final int widthIn, final int heightIn)
    {
        PipelineProcessor.processVoidPipeline(this,
          new DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntContext(xCoord,
            yCoord,
            textureSprite,
            widthIn,
            heightIn),
          pipeline.getDrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntPipeline(),
          (c) -> super.drawTexturedModalRect(c.getXCoord(), c.getYCoord(), Sprite.asForge(c.getTextureSprite()), c.getWidthIn(), c.getHeightIn()));
    }

    @Override
    public void drawTexturedModalRect(final int xCoord, final int yCoord, final TextureAtlasSprite textureSprite, final int widthIn, final int heightIn)
    {
        this.drawTexturedModalRect(xCoord, yCoord, Sprite.fromForge(textureSprite), widthIn, heightIn);
    }

    @Override
    public void drawTexturedModalRect(final int x, final int y, final int textureX, final int textureY, final int width, final int height)
    {
        PipelineProcessor.processVoidPipeline(this,
          new DrawTexturedModalRectContext(x, y, textureX, textureY, width, height),
          pipeline.getDrawTexturedModalRectPipeline(),
          (c) -> super.drawTexturedModalRect(c.getX(), c.getY(), c.getTextureX(), c.getTextureY(), c.getWidth(), c.getHeight()));
    }

    @Override
    public void drawTexturedModalRect(final float xCoord, final float yCoord, final int minU, final int minV, final int maxU, final int maxV)
    {
        PipelineProcessor.processVoidPipeline(this,
          new DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntContext(xCoord, yCoord, minU, minV, maxU, maxV),
          pipeline.getDrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntPipeline(),
          (c) -> super.drawTexturedModalRect(c.getXCoord(), c.getYCoord(), c.getMinU(), c.getMinV(), c.getMaxU(), c.getMaxV()));
    }

    @Override
    public IGameEngine getGameEngine()
    {
        return IGameEngine.getInstance();
    }

    @Override
    public I getInstanceData()
    {
        return instanceData;
    }
}
