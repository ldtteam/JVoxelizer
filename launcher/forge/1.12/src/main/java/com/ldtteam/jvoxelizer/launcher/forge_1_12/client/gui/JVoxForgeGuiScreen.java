package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.client.gui.IGuiButton;
import com.ldtteam.jvoxelizer.client.gui.IGuiScreen;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.client.renderer.item.IItemRenderer;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.core.logic.IInstancedObject;
import com.ldtteam.jvoxelizer.core.logic.PipelineProcessor;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.pipeline.ForgeGuiScreenPipeline;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.texture.Sprite;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;

import java.io.IOException;
import java.nio.channels.Pipe;
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

    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new DrawScreenContext(mouseX, mouseY, partialTicks),
          pipeline.getDrawScreenPipeline(),
          (c) -> super.drawScreen(c.getMouseX(), c.getMouseY(), c.getPartialTicks())
        );
    }

    /**
     * Fired when a key is typed (except F11 which toggles full screen). This is the equivalent of
     * KeyListener.keyTyped(KeyEvent e). Args : character (character on the key), keyCode (lwjgl Keyboard key code)
     */
    @Override
    protected void keyTyped(final char typedChar, final int keyCode) throws IOException
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new KeyTypedContext(typedChar, keyCode),
          pipeline.getKeyTypedPipeline(),
          (c)-> super.keyTyped(typedChar, keyCode)
        );
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
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.GuiButton.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new AddButtonContext<IGuiButton<?>>(com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.GuiButton.fromForge(buttonIn)),
          pipeline.getAddButtonPipeline(),
          (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.GuiButton.fromForge(super.addButton(com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.GuiButton.asForge(c.getButtonIn())))
        ));
    }

    @Override
    protected void renderToolTip(final ItemStack stack, final int x, final int y)
    {
        super.renderToolTip(stack, x, y);
    }

    @Override
    public List<String> getItemToolTip(final ItemStack p_191927_1_)
    {
        return super.getItemToolTip(p_191927_1_);
    }

    /**
     * Draws the given text as a tooltip.
     */
    @Override
    public void drawHoveringText(final String text, final int x, final int y)
    {
        super.drawHoveringText(text, x, y);
    }

    @Override
    public void setFocused(final boolean hasFocusedControlIn)
    {
        super.setFocused(hasFocusedControlIn);
    }

    @Override
    public boolean isFocused()
    {
        return super.isFocused();
    }

    /**
     * Draws a List of strings as a tooltip. Every entry is drawn on a seperate line.
     */
    @Override
    public void drawHoveringText(final List<String> textLines, final int x, final int y)
    {
        super.drawHoveringText(textLines, x, y);
    }

    @Override
    protected void drawHoveringText(final List<String> textLines, final int x, final int y, final FontRenderer font)
    {
        super.drawHoveringText(textLines, x, y, font);
    }

    /**
     * Draws the hover event specified by the given chat component
     */
    @Override
    protected void handleComponentHover(final ITextComponent component, final int x, final int y)
    {
        super.handleComponentHover(component, x, y);
    }

    /**
     * Sets the text of the chat
     */
    @Override
    protected void setText(final String newChatText, final boolean shouldOverwrite)
    {
        super.setText(newChatText, shouldOverwrite);
    }

    /**
     * Executes the click event specified by the given chat component
     */
    @Override
    public boolean handleComponentClick(final ITextComponent component)
    {
        return super.handleComponentClick(component);
    }

    /**
     * Used to add chat messages to the client's GuiChat.
     */
    @Override
    public void sendChatMessage(final String msg)
    {
        super.sendChatMessage(msg);
    }

    @Override
    public void sendChatMessage(final String msg, final boolean addToChat)
    {
        super.sendChatMessage(msg, addToChat);
    }

    /**
     * Called when the mouse is clicked. Args : mouseX, mouseY, clickedButton
     */
    @Override
    protected void mouseClicked(final int mouseX, final int mouseY, final int mouseButton) throws IOException
    {
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    /**
     * Called when a mouse button is released.
     */
    @Override
    protected void mouseReleased(final int mouseX, final int mouseY, final int state)
    {
        super.mouseReleased(mouseX, mouseY, state);
    }

    /**
     * Called when a mouse button is pressed and the mouse is moved around. Parameters are : mouseX, mouseY,
     * lastButtonClicked & timeSinceMouseClick.
     */
    @Override
    protected void mouseClickMove(final int mouseX, final int mouseY, final int clickedMouseButton, final long timeSinceLastClick)
    {
        super.mouseClickMove(mouseX, mouseY, clickedMouseButton, timeSinceLastClick);
    }

    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
    @Override
    protected void actionPerformed(final GuiButton button) throws IOException
    {
        super.actionPerformed(button);
    }

    /**
     * Causes the screen to lay out its subcomponents again. This is the equivalent of the Java call
     * Container.validate()
     */
    @Override
    public void setWorldAndResolution(final Minecraft mc, final int width, final int height)
    {
        super.setWorldAndResolution(mc, width, height);
    }

    /**
     * Set the gui to the specified width and height
     */
    @Override
    public void setGuiSize(final int w, final int h)
    {
        super.setGuiSize(w, h);
    }

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    @Override
    public void initGui()
    {
        super.initGui();
    }

    /**
     * Delegates mouse and keyboard input.
     */
    @Override
    public void handleInput() throws IOException
    {
        super.handleInput();
    }

    /**
     * Handles mouse input.
     */
    @Override
    public void handleMouseInput() throws IOException
    {
        super.handleMouseInput();
    }

    /**
     * Handles keyboard input.
     */
    @Override
    public void handleKeyboardInput() throws IOException
    {
        super.handleKeyboardInput();
    }

    /**
     * Called from the main game loop to update the screen.
     */
    @Override
    public void updateScreen()
    {
        super.updateScreen();
    }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    @Override
    public void onGuiClosed()
    {
        super.onGuiClosed();
    }

    /**
     * Draws either a gradient over the background screen (when it exists) or a flat gradient over background.png
     */
    @Override
    public void drawDefaultBackground()
    {
        super.drawDefaultBackground();
    }

    @Override
    public void drawWorldBackground(final int tint)
    {
        super.drawWorldBackground(tint);
    }

    /**
     * Draws the background (i is always 0 as of 1.2.2)
     */
    @Override
    public void drawBackground(final int tint)
    {
        super.drawBackground(tint);
    }

    /**
     * Returns true if this GUI should pause the game when it is displayed in single-player
     */
    @Override
    public boolean doesGuiPauseGame()
    {
        return super.doesGuiPauseGame();
    }

    @Override
    public void confirmClicked(final boolean result, final int id)
    {
        super.confirmClicked(result, id);
    }

    /**
     * Called when the GUI is resized in order to update the world and the resolution
     */
    @Override
    public void onResize(final Minecraft mcIn, final int w, final int h)
    {
        super.onResize(mcIn, w, h);
    }

    /**
     * Draws a thin horizontal line between two points.
     */
    @Override
    public void drawHorizontalLine(final int startX, final int endX, final int y, final int color)
    {
        super.drawHorizontalLine(startX, endX, y, color);
    }

    /**
     * Draw a 1 pixel wide vertical line. Args : x, y1, y2, color
     */
    @Override
    public void drawVerticalLine(final int x, final int startY, final int endY, final int color)
    {
        super.drawVerticalLine(x, startY, endY, color);
    }

    /**
     * Draws a rectangle with a vertical gradient between the specified colors (ARGB format). Args : x1, y1, x2, y2,
     * topColor, bottomColor
     */
    @Override
    public void drawGradientRect(final int left, final int top, final int right, final int bottom, final int startColor, final int endColor)
    {
        super.drawGradientRect(left, top, right, bottom, startColor, endColor);
    }

    /**
     * Renders the specified text to the screen, center-aligned. Args : renderer, string, x, y, color
     */
    @Override
    public void drawCenteredString(final FontRenderer fontRendererIn, final String text, final int x, final int y, final int color)
    {
        super.drawCenteredString(fontRendererIn, text, x, y, color);
    }

    /**
     * Renders the specified text to the screen. Args : renderer, string, x, y, color
     */
    @Override
    public void drawString(final FontRenderer fontRendererIn, final String text, final int x, final int y, final int color)
    {
        super.drawString(fontRendererIn, text, x, y, color);
    }

    /**
     * Draws a textured rectangle at the current z-value.
     */
    @Override
    public void drawTexturedModalRect(final int x, final int y, final int textureX, final int textureY, final int width, final int height)
    {
        super.drawTexturedModalRect(x, y, textureX, textureY, width, height);
    }

    /**
     * Draws a textured rectangle using the texture currently bound to the TextureManager
     */
    @Override
    public void drawTexturedModalRect(final float xCoord, final float yCoord, final int minU, final int minV, final int maxU, final int maxV)
    {
        super.drawTexturedModalRect(xCoord, yCoord, minU, minV, maxU, maxV);
    }

    /**
     * Draws a texture rectangle using the texture currently bound to the TextureManager
     */
    @Override
    public void drawTexturedModalRect(final int xCoord, final int yCoord, final TextureAtlasSprite textureSprite, final int widthIn, final int heightIn)
    {
        super.drawTexturedModalRect(xCoord, yCoord, textureSprite, widthIn, heightIn);
    }
}
