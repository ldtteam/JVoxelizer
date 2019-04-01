package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.client.gui.IGuiButton;
import com.ldtteam.jvoxelizer.core.logic.DummyInstanceData;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.GameEngine;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.sound.SoundHandler;
import com.ldtteam.jvoxelizer.sound.ISoundHandler;

public class GuiButton extends Gui implements IGuiButton<DummyInstanceData>
{
    private final net.minecraft.client.gui.GuiButton forgeGuiButton;

    public GuiButton(final net.minecraft.client.gui.GuiButton forgeGuiButton)
    {
        super(forgeGuiButton);
        this.forgeGuiButton = forgeGuiButton;
    }

    @Override
    public void drawButton(final IGameEngine mc, final int mouseX, final int mouseY, final float partialTicks)
    {
        forgeGuiButton.drawButton(GameEngine.asForge(mc), mouseX, mouseY, partialTicks);
    }

    @Override
    public void mouseReleased(final int mouseX, final int mouseY)
    {
        forgeGuiButton.mouseReleased(mouseX, mouseY);
    }

    @Override
    public boolean mousePressed(final IGameEngine mc, final int mouseX, final int mouseY)
    {
        return forgeGuiButton.mousePressed(GameEngine.asForge(mc), mouseX, mouseY);
    }

    @Override
    public boolean isMouseOver()
    {
        return forgeGuiButton.isMouseOver();
    }

    @Override
    public void drawButtonForegroundLayer(final int mouseX, final int mouseY)
    {
        forgeGuiButton.drawButtonForegroundLayer(mouseX, mouseY);
    }

    @Override
    public void playPressSound(final ISoundHandler soundHandlerIn)
    {
        forgeGuiButton.playPressSound(SoundHandler.asForge(soundHandlerIn));
    }

    @Override
    public int getButtonWidth()
    {
        return forgeGuiButton.getButtonWidth();
    }

    @Override
    public void setWidth(final int width)
    {
        forgeGuiButton.setWidth(width);
    }

    private net.minecraft.client.gui.GuiButton getForgeGuiButton()
    {
        return forgeGuiButton;
    }

    public static net.minecraft.client.gui.GuiButton asForge(IGuiButton<?> guiButton)
    {
        if (guiButton.getInstanceData() instanceof GuiButton)
        {
            return ((GuiButton) guiButton).getForgeGuiButton();
        }

        if(!(guiButton instanceof IForgeJVoxelizerWrapper))
            throw new IllegalArgumentException("GuiButton is not a wrapper");

        return ((IForgeJVoxelizerWrapper) guiButton).getForgeInstance();
    }

    public static IGuiButton<?> fromForge(net.minecraft.client.gui.GuiButton guiButton)
    {
        if (guiButton instanceof IGuiButton)
        {
            return (IGuiButton<?>) guiButton;
        }

        return new GuiButton(guiButton);
    }
}
