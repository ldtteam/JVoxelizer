package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.client.gui.IGuiScreen;
import com.ldtteam.jvoxelizer.client.renderer.item.IItemRenderer;
import com.ldtteam.jvoxelizer.core.logic.DummyInstanceData;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.GameEngine;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.textcomponent.TextComponent;
import com.ldtteam.jvoxelizer.util.textcomponent.ITextComponent;

import java.io.IOException;
import java.util.List;

public class GuiScreen extends Gui implements IGuiScreen<DummyInstanceData>
{

    private final net.minecraft.client.gui.GuiScreen forgeGuiScreen;

    public GuiScreen(final net.minecraft.client.gui.GuiScreen forgeGuiScreen)
    {
        super(forgeGuiScreen);
        this.forgeGuiScreen = forgeGuiScreen;
    }

    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks)
    {
        forgeGuiScreen.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public List<String> getItemToolTip(final IItemStack stack)
    {
        return forgeGuiScreen.getItemToolTip(ItemStack.asForge(stack));
    }

    @Override
    public void drawHoveringText(final String text, final int x, final int y)
    {
        forgeGuiScreen.drawHoveringText(text, x, y);
    }

    @Override
    public void setFocused(final boolean hasFocusedControlIn)
    {
        forgeGuiScreen.setFocused(hasFocusedControlIn);
    }

    @Override
    public boolean isFocused()
    {
        return forgeGuiScreen.isFocused();
    }

    @Override
    public void drawHoveringText(final List<String> textLines, final int x, final int y)
    {
        forgeGuiScreen.drawHoveringText(textLines, x, y);
    }

    @Override
    public boolean handleComponentClick(final ITextComponent component)
    {
        return forgeGuiScreen.handleComponentClick(TextComponent.asForge(component));
    }

    @Override
    public void sendChatMessage(final String msg)
    {
        forgeGuiScreen.sendChatMessage(msg);
    }

    @Override
    public void sendChatMessage(final String msg, final boolean addToChat)
    {
        forgeGuiScreen.sendChatMessage(msg, addToChat);
    }

    @Override
    public void setWorldAndResolution(final IGameEngine mc, final int width, final int height)
    {
        forgeGuiScreen.setWorldAndResolution(GameEngine.asForge(mc), width, height);
    }

    @Override
    public void setGuiSize(final int w, final int h)
    {
        forgeGuiScreen.setGuiSize(w, h);
    }

    @Override
    public void initGui()
    {
        forgeGuiScreen.initGui();
    }

    @Override
    public void handleInput() throws IOException
    {
        forgeGuiScreen.handleInput();
    }

    @Override
    public void handleMouseInput() throws IOException
    {
        forgeGuiScreen.handleMouseInput();
    }

    @Override
    public void handleKeyboardInput() throws IOException
    {
        forgeGuiScreen.handleKeyboardInput();
    }

    @Override
    public void updateScreen()
    {
        forgeGuiScreen.updateScreen();
    }

    @Override
    public void onGuiClosed()
    {
        forgeGuiScreen.onGuiClosed();
    }

    @Override
    public void drawDefaultBackground()
    {
        forgeGuiScreen.drawDefaultBackground();
    }

    @Override
    public void drawWorldBackground(final int tint)
    {
        forgeGuiScreen.drawWorldBackground(tint);
    }

    @Override
    public void drawBackground(final int tint)
    {
        forgeGuiScreen.drawBackground(tint);
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return forgeGuiScreen.doesGuiPauseGame();
    }

    @Override
    public void confirmClicked(final boolean result, final int id)
    {
        forgeGuiScreen.confirmClicked(result, id);
    }

    @Override
    public void onResize(final IGameEngine mcIn, final int w, final int h)
    {
        forgeGuiScreen.onResize(GameEngine.asForge(mcIn), w, h);
    }

    @Override
    public IItemRenderer getItemRenderer()
    {
        return IGameEngine.getInstance().getItemRenderer();
    }

    public static net.minecraft.client.gui.GuiScreen asForge(IGuiScreen<?> gui)
    {
        if (gui instanceof net.minecraft.client.gui.GuiScreen)
            return (net.minecraft.client.gui.GuiScreen) gui;

        return ((GuiScreen) gui).forgeGuiScreen;
    }

    public static IGuiScreen<?> fromForge(final net.minecraft.client.gui.GuiScreen ingameGUI)
    {
        if (ingameGUI instanceof IGuiScreen)
            return (IGuiScreen<?>) ingameGUI;

        return new GuiScreen(ingameGUI);
    }
}
