package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.client.gui.IGuiButton;
import com.ldtteam.jvoxelizer.client.gui.IGuiScreen;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.client.renderer.item.IItemRenderer;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.core.logic.PipelineProcessor;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.pipeline.ForgeGuiScreenPipeline;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.font.FontRenderer;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.texture.Sprite;
import com.ldtteam.jvoxelizer.util.textcomponent.ITextComponent;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

import java.io.IOException;
import java.util.List;

public class JVoxForgeGuiScreen<I> extends GuiScreen implements IGuiScreen<I>
{

    private final I                            instanceData;
    private final ForgeGuiScreenPipeline<IGuiScreen<I>, I> pipeline;

    public JVoxForgeGuiScreen(final I instanceData, final ForgeGuiScreenPipeline<IGuiScreen<I>, I> pipeline)
    {
        this.instanceData = instanceData;
        this.pipeline = pipeline;
    }

    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks)
    {
        PipelineProcessor.processVoidPipeline(this,
          new DrawScreenContext(mouseX, mouseY, partialTicks),
          pipeline.getDrawScreenPipeline(),
          (c) -> super.drawScreen(mouseX, mouseY, partialTicks));
    }

    @Override
    public void keyTyped(final char typedChar, final int keyCode)
    {
        PipelineProcessor.processVoidPipeline(this,
          new KeyTypedContext(typedChar, keyCode),
          pipeline.getKeyTypedPipeline(),
          (c) -> {
              try
              {
                  super.keyTyped(c.getTypedChar(), c.getKeyCode());
              }
              catch (IOException e)
              {
                  //Ignore
              }
          });
    }

    @Override
    public <T extends IGuiButton> T addButton(final T buttonIn)
    {
        return PipelineProcessor.processTypedPipeline(this,
          new AddButtonContext<>(buttonIn))
    }

    /**
     * Adds a control to this GUI's button list. Any type that subclasses button may be added (particularly, GuiSlider,
     * but not text fields).
     *
     * @param buttonIn The control to add
     * @return The control passed in.
     */
    @Override
    protected <T extends GuiButton> T addButton(final T buttonIn)
    {
        return super.addButton(buttonIn);
    }

    @Override
    public void renderToolTip(final IItemStack stack, final int x, final int y)
    {

    }

    @Override
    public List<String> getItemToolTip(final IItemStack p_191927_1_)
    {
        return null;
    }

    @Override
    public void drawHoveringText(final String text, final int x, final int y)
    {

    }

    @Override
    public void setFocused(final boolean hasFocusedControlIn)
    {

    }

    @Override
    public boolean isFocused()
    {
        return false;
    }

    @Override
    public void drawHoveringText(final List<String> textLines, final int x, final int y)
    {

    }

    @Override
    public void drawHoveringText(final List<String> textLines, final int x, final int y, final IFontRenderer font)
    {

    }

    @Override
    public void handleComponentHover(final ITextComponent component, final int x, final int y)
    {

    }

    @Override
    public void setText(final String newChatText, final boolean shouldOverwrite)
    {

    }

    @Override
    public boolean handleComponentClick(final ITextComponent component)
    {
        return false;
    }

    @Override
    public void sendChatMessage(final String msg)
    {

    }

    @Override
    public void sendChatMessage(final String msg, final boolean addToChat)
    {

    }

    @Override
    public void mouseClicked(final int mouseX, final int mouseY, final int mouseButton)
    {

    }

    @Override
    public void mouseReleased(final int mouseX, final int mouseY, final int state)
    {

    }

    @Override
    public void mouseClickMove(final int mouseX, final int mouseY, final int clickedMouseButton, final long timeSinceLastClick)
    {

    }

    @Override
    public void actionPerformed(final IGuiButton button)
    {

    }

    @Override
    public void setWorldAndResolution(final IGameEngine mc, final int width, final int height)
    {

    }

    @Override
    public void setGuiSize(final int w, final int h)
    {

    }

    @Override
    public void initGui()
    {

    }

    @Override
    public void handleInput()
    {

    }

    @Override
    public void handleMouseInput()
    {

    }

    @Override
    public void handleKeyboardInput()
    {

    }

    @Override
    public void updateScreen()
    {

    }

    @Override
    public void onGuiClosed()
    {

    }

    @Override
    public void drawDefaultBackground()
    {

    }

    @Override
    public void drawWorldBackground(final int tint)
    {

    }

    @Override
    public void drawBackground(final int tint)
    {

    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    @Override
    public void confirmClicked(final boolean result, final int id)
    {

    }

    @Override
    public void onResize(final IGameEngine mcIn, final int w, final int h)
    {

    }

    @Override
    public IItemRenderer getItemRenderer()
    {
        return null;
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
          (c) -> super.drawVerticalLine(c.getX(), c.getStartY(), c.getEndY(), c.getColor())))
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
          (c) -> super.drawCenteredString(((FontRenderer) c.getFontRendererIn()).getForgeFontRenderer(), c.getText(), c.getX(), c.getY(), c.getColor()));
    }

    @Override
    public void drawString(final IFontRenderer fontRendererIn, final String text, final int x, final int y, final int color)
    {
        PipelineProcessor.processVoidPipeline(this,
          new DrawStringContext(fontRendererIn, text, x, y, color),
          pipeline.getDrawStringPipeline(),
          (c) -> super.drawString(((FontRenderer) c.getFontRendererIn()).getForgeFontRenderer(), c.getText(), c.getX(), c.getY(), c.getColor()));
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
        PipelineProcessor.processVoidPipeline(this,
          new DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntContext(xCoord,
            yCoord,
            textureSprite,
            widthIn,
            heightIn),
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
