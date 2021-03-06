package com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.client.gui.IGuiScreen;
import com.ldtteam.jvoxelizer.client.renderer.item.IItemRenderer;
import com.ldtteam.jvoxelizer.core.logic.DummyInstanceData;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.GameEngine;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.textcomponent.TextComponent;
import com.ldtteam.jvoxelizer.util.textcomponent.ITextComponent;

import java.io.IOException;
import java.util.List;

public class GuiScreen extends Gui implements IGuiScreen<DummyInstanceData>
{

    private final net.minecraft.client.gui.GuiScreen forgeGuiScreen;

    protected GuiScreen(final net.minecraft.client.gui.GuiScreen forgeGuiScreen)
    {
        super(forgeGuiScreen);
        this.forgeGuiScreen = forgeGuiScreen;
    }

    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks)
    {
        forgeGuiScreen.render(mouseX, mouseY, partialTicks);
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
        forgeGuiScreen.focusOn(forgeGuiScreen);
    }

    @Override
    public boolean isFocused()
    {
        return forgeGuiScreen.getFocused() == forgeGuiScreen;
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
        forgeGuiScreen.width = w;
        forgeGuiScreen.height = h;
    }

    @Override
    public void initializeGui()
    {
        throw new IllegalArgumentException("JVox wrapped GuiScreens can not be initialized in 1.13 externally.");
    }

    @Override
    public void updateScreen()
    {
        forgeGuiScreen.tick();
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
    public void onResize(final IGameEngine mcIn, final int w, final int h)
    {
        forgeGuiScreen.onResize(GameEngine.asForge(mcIn), w, h);
    }

    @Override
    public IItemRenderer getItemRenderer()
    {
        return IGameEngine.getInstance().getItemRenderer();
    }

    private net.minecraft.client.gui.GuiScreen getForgeGuiScreen()
    {
        return forgeGuiScreen;
    }

    public static net.minecraft.client.gui.GuiScreen asForge(IGuiScreen<?> guiScreen)
    {
        if (guiScreen instanceof net.minecraft.client.gui.GuiScreen)
        {
            return (net.minecraft.client.gui.GuiScreen) guiScreen;
        }

        if (guiScreen == null)
        {
            return null;
        }

        if (!(guiScreen instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("GuiScreen is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) guiScreen).getForgeInstance();
    }

    public static IGuiScreen<?> fromForge(final net.minecraft.client.gui.GuiScreen guiScreen)
    {
        if (guiScreen instanceof IGuiScreen)
        {
            return (IGuiScreen<?>) guiScreen;
        }

        return new GuiScreen(guiScreen);
    }

    @Override
    public int getWidth()
    {
        return forgeGuiScreen.width;
    }

    @Override
    public int getHeight()
    {
        return forgeGuiScreen.height;
    }
}
