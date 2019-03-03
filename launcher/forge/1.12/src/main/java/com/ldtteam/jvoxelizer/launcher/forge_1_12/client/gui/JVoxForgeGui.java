package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.client.gui.IGui;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.core.logic.PipelineProcessor;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.pipeline.ForgeGuiPipeline;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.font.FontRenderer;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.texture.Sprite;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

import static com.ldtteam.jvoxelizer.core.logic.PipelineProcessor.processVoidPipeline;

@SuppressWarnings("unchecked")
public class JVoxForgeGui<I> extends Gui implements IGui<I>
{

    private final I instanceData;
    private final ForgeGuiPipeline<IGui<I>, I> pipeline;

    public JVoxForgeGui(final I instanceData, final ForgeGuiPipeline<IGui<I>, I> pipeline) {
        this.instanceData = instanceData;
        this.pipeline = pipeline;}

    @Override
    public void drawHorizontalLine(final int startX, final int endX, final int y, final int color)
    {
        processVoidPipeline(this, new DrawHorizontalLineContext(startX, endX, y, color), pipeline.getDrawHorizontalLinePipeline(), (c) -> super.drawHorizontalLine(c.getStartX(), c.getEndX(), c.getY(), c.getColor()));
    }

    @Override
    public void drawVerticalLine(final int x, final int startY, final int endY, final int color)
    {
        processVoidPipeline(this, new DrawVerticalLineContext(x, startY, endY, color), pipeline.getDrawVerticalLinePipeline(), (c) -> super.drawVerticalLine(c.getX(), c.getStartY(), c.getEndY(), c.getColor()));
    }

    @Override
    public void drawGradientRect(final int left, final int top, final int right, final int bottom, final int startColor, final int endColor)
    {
        processVoidPipeline(this, new DrawGradientRectContext(left, top, right, bottom, startColor, endColor), pipeline.getDrawGradientRectPipeline(), (c) -> super.drawGradientRect(c.getLeft(), c.getTop(), c.getRight(), c.getBottom(), c.getStartColor(), c.getEndColor()));
    }

    @Override
    public void drawCenteredString(final IFontRenderer fontRendererIn, final String text, final int x, final int y, final int color)
    {
        processVoidPipeline(this, new DrawCenteredStringContext(fontRendererIn, text, x, y, color), pipeline.getDrawCenteredStringPipeline(), (c) -> super.drawCenteredString(((FontRenderer) c.getFontRendererIn()).getForgeFontRenderer(), c.getText(), c.getX(), c.getY(), c.getColor()));
    }

    @Override
    public void drawString(final IFontRenderer fontRendererIn, final String text, final int x, final int y, final int color)
    {
        processVoidPipeline(this, new DrawStringContext(fontRendererIn, text, x, y, color), pipeline.getDrawStringPipeline(), (c) -> super.drawString(((FontRenderer) c.getFontRendererIn()).getForgeFontRenderer(), c.getText(), c.getX(), c.getY(), c.getColor()));
    }

    @Override
    public void drawCenteredString(final net.minecraft.client.gui.FontRenderer fontRendererIn, final String text, final int x, final int y, final int color)
    {
        this.drawCenteredString(new FontRenderer(fontRendererIn), text, x, y, color);
    }

    @Override
    public void drawString(final net.minecraft.client.gui.FontRenderer fontRendererIn, final String text, final int x, final int y, final int color)
    {
        this.drawString(new FontRenderer(fontRendererIn), text, x, y, color);
    }

    @Override
    public void drawTexturedModalRect(final int xCoord, final int yCoord, final ISprite textureSprite, final int widthIn, final int heightIn)
    {
        processVoidPipeline(this,
          new DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntContext(xCoord, yCoord, textureSprite, widthIn, heightIn),
          pipeline.getDrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntPipeline(),
          (c) -> super.drawTexturedModalRect(c.getXCoord(), c.getYCoord(), ((Sprite) c.getTextureSprite()).getForgeSprite(), c.getWidthIn(), c.getHeightIn()));
    }

    @Override
    public void drawTexturedModalRect(final int xCoord, final int yCoord, final TextureAtlasSprite textureSprite, final int widthIn, final int heightIn)
    {
        this.drawTexturedModalRect(xCoord, yCoord, new Sprite(textureSprite), widthIn, heightIn);
    }

    @Override
    public void drawTexturedModalRect(final int x, final int y, final int textureX, final int textureY, final int width, final int height)
    {
        processVoidPipeline(this,
          new DrawTexturedModalRectContext(x, y, textureX, textureY, width, height),
          pipeline.getDrawTexturedModalRectPipeline(),
          (c)-> super.drawTexturedModalRect(c.getX(), c.getY(), c.getTextureX(), c.getTextureY(), c.getWidth(), c.getHeight()));
    }

    @Override
    public void drawTexturedModalRect(final float xCoord, final float yCoord, final int minU, final int minV, final int maxU, final int maxV)
    {
        processVoidPipeline(this,
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
