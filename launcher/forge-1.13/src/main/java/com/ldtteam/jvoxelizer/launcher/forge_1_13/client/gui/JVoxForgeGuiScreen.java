package com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.client.gui.IGuiScreen;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.client.renderer.item.IItemRenderer;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.core.logic.PipelineProcessor;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.GameEngine;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui.logic.pipeline.ForgeGuiScreenPipeline;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.texture.Sprite;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.textcomponent.TextComponent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;

import java.io.IOException;
import java.util.List;

import static com.ldtteam.jvoxelizer.core.logic.PipelineProcessor.processTypedPipeline;
import static com.ldtteam.jvoxelizer.core.logic.PipelineProcessor.processVoidPipeline;
import static com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui.GuiButton.asForge;
import static com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui.GuiButton.fromForge;
import static com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.font.FontRenderer.asForge;
import static com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.font.FontRenderer.fromForge;
import static com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.texture.Sprite.asForge;
import static com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.texture.Sprite.fromForge;
import static com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge;
import static com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge;

public class JVoxForgeGuiScreen<I> extends GuiScreen implements IGuiScreen<I>
{

    private final I                                        instanceData;
    private final ForgeGuiScreenPipeline<IGuiScreen<I>, I> pipeline;

    public JVoxForgeGuiScreen(final I instanceData, final ForgeGuiScreenPipeline<IGuiScreen<I>, I> pipeline)
    {
        this.instanceData = instanceData;
        this.pipeline = pipeline;
    }

    @Override
    public void render(final int mouseX, final int mouseY, final float partialTicks)
    {
        processVoidPipeline(
          this,
          new DrawScreenContext(mouseX, mouseY, partialTicks),
          pipeline.getDrawScreenPipeline(),
          (c) -> super.render(c.getMouseX(), c.getMouseY(), c.getPartialTicks())
        );
    }

    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks)
    {
        this.render(mouseX, mouseY, partialTicks);
    }

    @Override
    public List<String> getItemToolTip(final IItemStack p_191927_1_)
    {
        return this.getItemToolTip(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(p_191927_1_));
    }

    @Override
    public boolean charTyped(final char typedChar, final int keyCode)
    {
        processVoidPipeline(
          this,
          new KeyTypedContext(typedChar, keyCode),
          pipeline.getKeyTypedPipeline(),
          (c) -> super.charTyped(typedChar, keyCode)
        );

        return !pipeline.getKeyTypedPipeline().isEmpty();
    }

    @Override
    protected void renderToolTip(final ItemStack stack, final int x, final int y)
    {
        processVoidPipeline(
          this,
          new RenderToolTipContext(fromForge(stack), x, y),
          pipeline.getRenderToolTipPipeline(),
          (c) -> super.renderToolTip(asForge(c.getStack()), c.getX(), c.getY())
        );
    }

    @Override
    public List<String> getItemToolTip(final ItemStack p_191927_1_)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetItemToolTipContext(fromForge(p_191927_1_)),
          pipeline.getGetItemToolTipPipeline(),
          (c) -> super.getItemToolTip(asForge(c.getItemStack()))
        );
    }

    @Override
    public void drawHoveringText(final String text, final int x, final int y)
    {
        processVoidPipeline(
          this,
          new DrawHoveringTextContext(text, x, y),
          pipeline.getDrawHoveringTextPipeline(),
          (c) -> super.drawHoveringText(c.getText(), c.getX(), c.getY())
        );
    }

    @Override
    public void setFocused(final boolean hasFocusedControlIn)
    {
        processVoidPipeline(
          this,
          new SetFocusedContext(hasFocusedControlIn),
          pipeline.getSetFocusedPipeline(),
          (c) -> super.setFocused(c.getHasFocusedControlIn()? this : null)
        );
    }

    @Override
    public boolean isFocused()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsFocusedContext(),
          pipeline.getIsFocusedPipeline(),
          (c) -> super.getFocused() == this
        );
    }

    @Override
    public void drawHoveringText(final List<String> textLines, final int x, final int y)
    {
        processVoidPipeline(
          this,
          new DrawHoveringTextWithTextLinesAsStringListContext(textLines, x, y),
          pipeline.getDrawHoveringTextWithTextLinesAsStringListPipeline(),
          (c) -> super.drawHoveringText(c.getTextLines(), c.getX(), c.getY())
        );
    }

    @Override
    public boolean handleComponentClick(final com.ldtteam.jvoxelizer.util.textcomponent.ITextComponent component)
    {
        return this.handleComponentClick(TextComponent.asForge(component));
    }

    @Override
    public void drawHoveringText(final List<String> textLines, final int x, final int y, final FontRenderer font)
    {
        processVoidPipeline(
          this,
          new DrawHoveringTextWithFontAsFontRendererContext(textLines, x, y, fromForge(font)),
          pipeline.getDrawHoveringTextWithFontAsFontRendererPipeline(),
          (c) -> super.drawHoveringText(c.getTextLines(), c.getX(), c.getY(), asForge(c.getFont()))
        );
    }

    @Override
    protected void handleComponentHover(final ITextComponent component, final int x, final int y)
    {
        processVoidPipeline(
          this,
          new HandleComponentHoverContext(TextComponent.fromForge(component), x, y),
          pipeline.getHandleComponentHoverPipeline(),
          (c) -> super.handleComponentHover(TextComponent.asForge(c.getComponent()), c.getX(), c.getY())
        );
    }

    @Override
    protected void setText(final String newChatText, final boolean shouldOverwrite)
    {
        processVoidPipeline(
          this,
          new SetTextContext(newChatText, shouldOverwrite),
          pipeline.getSetTextPipeline(),
          (c) -> super.setText(c.getNewChatText(), c.getShouldOverwrite())
        );
    }

    @Override
    public boolean handleComponentClick(final ITextComponent component)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new HandleComponentClickContext(TextComponent.fromForge(component)),
          pipeline.getHandleComponentClickPipeline(),
          (c) -> super.handleComponentClick(TextComponent.asForge(c.getComponent()))
        );
    }

    @Override
    public void sendChatMessage(final String msg)
    {
        processVoidPipeline(
          this,
          new SendChatMessageContext(msg),
          pipeline.getSendChatMessagePipeline(),
          (c) -> super.sendChatMessage(c.getMsg())
        );
    }

    @Override
    public void sendChatMessage(final String msg, final boolean addToChat)
    {
        processVoidPipeline(
          this,
          new SendChatMessageWithAddToChatAsbooleanContext(msg, addToChat),
          pipeline.getSendChatMessageWithAddToChatAsbooleanPipeline(),
          (c) -> super.sendChatMessage(c.getMsg(), c.getAddToChat())
        );
    }

    @Override
    public void setWorldAndResolution(final IGameEngine mc, final int width, final int height)
    {
        this.setWorldAndResolution(GameEngine.asForge(mc), width, height);
    }

    @Override
    public boolean mouseClicked(final double mouseX, final double mouseY, final int mouseButton)
    {
        processVoidPipeline(
          this,
          new MouseClickedContext((int) mouseX, (int) mouseY, mouseButton),
          pipeline.getMouseClickedPipeline(),
          (c) -> super.mouseClicked(c.getMouseX(), c.getMouseY(), c.getMouseButton())
        );

        return !pipeline.getMouseClickedPipeline().isEmpty();
    }

    @Override
    public boolean mouseReleased(final double mouseX, final double mouseY, final int state)
    {
        processVoidPipeline(
          this,
          new MouseReleasedContext((int) mouseX, (int) mouseY, state),
          pipeline.getMouseReleasedPipeline(),
          (c) -> super.mouseReleased(c.getMouseX(), c.getMouseY(), c.getState())
        );

        return !pipeline.getMouseReleasedPipeline().isEmpty();
    }

    @Override
    public boolean mouseDragged(
      final double p_mouseDragged_1_,
      final double p_mouseDragged_3_,
      final int p_mouseDragged_5_,
      final double p_mouseDragged_6_,
      final double p_mouseDragged_8_)
    {
        processVoidPipeline(
          this,
          new MouseClickMoveContext((int) p_mouseDragged_1_, (int) p_mouseDragged_3_, p_mouseDragged_5_, 0),
          pipeline.getMouseClickMovePipeline(),
          (c) -> super.mouseDragged(c.getMouseX(), c.getMouseY(), c.getClickedMouseButton(), p_mouseDragged_6_, p_mouseDragged_8_)
        );

        return !pipeline.getMouseReleasedPipeline().isEmpty();
    }

    @Override
    public void setWorldAndResolution(final Minecraft mc, final int width, final int height)
    {
        processVoidPipeline(
          this,
          new SetWorldAndResolutionContext(getGameEngine(), width, height),
          pipeline.getSetWorldAndResolutionPipeline(),
          (c) -> super.setWorldAndResolution(GameEngine.asForge(c.getMc()), c.getWidth(), c.getHeight())
        );
    }

    @Override
    public void setGuiSize(final int w, final int h)
    {
        processVoidPipeline(
          this,
          new SetGuiSizeContext(w, h),
          pipeline.getSetGuiSizePipeline(),
          (c) ->
          {
              this.width = c.getW();
              this.height = c.getH();
          });
    }

    @Override
    public void initGui()
    {
        processVoidPipeline(
          this,
          new InitGuiContext(),
          pipeline.getInitGuiPipeline(),
          (c) -> super.initGui()
        );
    }

    @Override
    public void tick()
    {
        processVoidPipeline(
          this,
          new UpdateScreenContext(),
          pipeline.getUpdateScreenPipeline(),
          (c) -> super.tick()
        );
    }

    @Override
    public void onGuiClosed()
    {
        processVoidPipeline(
          this,
          new OnGuiClosedContext(),
          pipeline.getOnGuiClosedPipeline(),
          (c) -> super.onGuiClosed()
        );
    }

    @Override
    public void drawDefaultBackground()
    {
        processVoidPipeline(
          this,
          new DrawDefaultBackgroundContext(),
          pipeline.getDrawDefaultBackgroundPipeline(),
          (c) -> super.drawDefaultBackground()
        );
    }

    @Override
    public void drawWorldBackground(final int tint)
    {
        processVoidPipeline(
          this,
          new DrawWorldBackgroundContext(tint),
          pipeline.getDrawWorldBackgroundPipeline(),
          (c) -> super.drawWorldBackground(c.getTint())
        );
    }

    @Override
    public void drawBackground(final int tint)
    {
        processVoidPipeline(
          this,
          new DrawBackgroundContext(tint),
          pipeline.getDrawBackgroundPipeline(),
          (c) -> super.drawBackground(c.getTint())
        );
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return processTypedPipeline(
          this,
          new DoesGuiPauseGameContext(),
          pipeline.getDoesGuiPauseGamePipeline(),
          (c) -> super.doesGuiPauseGame()
        );
    }

    @Override
    public void onResize(final IGameEngine mcIn, final int w, final int h)
    {
        this.onResize(GameEngine.asForge(mcIn), w, h);
    }

    @Override
    public IItemRenderer getItemRenderer()
    {
        return getGameEngine().getItemRenderer();
    }

    @Override
    public void onResize(final Minecraft mcIn, final int w, final int h)
    {
        processVoidPipeline(
          this,
          new OnResizeContext(getGameEngine(), w, h),
          pipeline.getOnResizePipeline(),
          (c) -> super.onResize(GameEngine.asForge(c.getMcIn()), c.getW(), c.getH())
        );
    }

    @Override
    public void drawHorizontalLine(final int startX, final int endX, final int y, final int color)
    {
        processVoidPipeline(
          this,
          new DrawHorizontalLineContext(startX, endX, y, color),
          pipeline.getDrawHorizontalLinePipeline(),
          (c) -> super.drawHorizontalLine(c.getStartX(), c.getEndX(), c.getY(), c.getColor())
        );
    }

    @Override
    public void drawVerticalLine(final int x, final int startY, final int endY, final int color)
    {
        processVoidPipeline(
          this,
          new DrawVerticalLineContext(x, startY, endY, color),
          pipeline.getDrawVerticalLinePipeline(),
          (c) -> drawVerticalLine(c.getX(), c.getStartY(), c.getEndY(), c.getColor())
        );
    }

    @Override
    public void drawGradientRect(final int left, final int top, final int right, final int bottom, final int startColor, final int endColor)
    {
        processVoidPipeline(
          this,
          new DrawGradientRectContext(left, top, right, bottom, startColor, endColor),
          pipeline.getDrawGradientRectPipeline(),
          (c) -> super.drawGradientRect(c.getLeft(), c.getTop(), c.getRight(), c.getBottom(), c.getStartColor(), c.getEndColor())
        );
    }

    @Override
    public void drawCenteredString(final IFontRenderer fontRendererIn, final String text, final int x, final int y, final int color)
    {
        this.drawCenteredString(com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.font.FontRenderer.asForge(fontRendererIn), text, x, y, color);
    }

    @Override
    public void drawString(final IFontRenderer fontRendererIn, final String text, final int x, final int y, final int color)
    {
        this.drawString(com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.font.FontRenderer.asForge(fontRendererIn), text, x, y, color);
    }

    @Override
    public void drawCenteredString(final FontRenderer fontRendererIn, final String text, final int x, final int y, final int color)
    {
        processVoidPipeline(
          this,
          new DrawCenteredStringContext(fromForge(fontRenderer), text, x, y, color),
          pipeline.getDrawCenteredStringPipeline(),
          (c) -> super.drawCenteredString(asForge(c.getFontRendererIn()), c.getText(), c.getX(), c.getY(), c.getColor())
        );
    }

    @Override
    public void drawString(final FontRenderer fontRendererIn, final String text, final int x, final int y, final int color)
    {
        processVoidPipeline(
          this,
          new DrawStringContext(fromForge(fontRendererIn), text, x, y, color),
          pipeline.getDrawStringPipeline(),
          (c) -> super.drawString(asForge(c.getFontRendererIn()), c.getText(), c.getX(), c.getY(), c.getColor())
        );
    }

    @Override
    public void drawTexturedModalRect(final int x, final int y, final int textureX, final int textureY, final int width, final int height)
    {
        processVoidPipeline(
          this,
          new DrawTexturedModalRectContext(x, y, textureX, textureY, width, height),
          pipeline.getDrawTexturedModalRectPipeline(),
          (c) -> super.drawTexturedModalRect(c.getX(), c.getY(), c.getTextureX(), c.getTextureY(), c.getWidth(), c.getHeight())
        );
    }

    @Override
    public void drawTexturedModalRect(final float xCoord, final float yCoord, final int minU, final int minV, final int maxU, final int maxV)
    {
        processVoidPipeline(
          this,
          new DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntContext(xCoord, yCoord, minU, minV, maxU, maxV),
          pipeline.getDrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntPipeline(),
          (c) -> super.drawTexturedModalRect(c.getXCoord(), c.getYCoord(), c.getMinU(), c.getMinV(), c.getMaxU(), c.getMaxV())
        );
    }

    @Override
    public void drawTexturedModalRect(final int xCoord, final int yCoord, final ISprite textureSprite, final int widthIn, final int heightIn)
    {
        this.drawTexturedModalRect(xCoord, yCoord, Sprite.asForge(textureSprite), widthIn, heightIn);
    }

    @Override
    public IGameEngine getGameEngine()
    {
        return IGameEngine.getInstance();
    }

    @Override
    public void drawTexturedModalRect(final int xCoord, final int yCoord, final TextureAtlasSprite textureSprite, final int widthIn, final int heightIn)
    {
        processVoidPipeline(
          this,
          new DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntContext(xCoord,
            yCoord,
            fromForge(textureSprite),
            widthIn,
            heightIn),
          pipeline.getDrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntPipeline(),
          (c) -> super.drawTexturedModalRect(c.getXCoord(), c.getYCoord(), asForge(c.getTextureSprite()), c.getWidthIn(), c.getHeightIn())
        );
    }

    @Override
    public int getWidth()
    {
        return width;
    }

    @Override
    public int getHeight()
    {
        return height;
    }

    @Override
    public void initializeGui()
    {
        this.initGui();
    }

    @Override
    public void updateScreen()
    {
        this.tick();
    }

    @Override
    public I getInstanceData()
    {
        return instanceData;
    }
}
