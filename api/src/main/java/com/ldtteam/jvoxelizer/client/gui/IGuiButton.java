package com.ldtteam.jvoxelizer.client.gui;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.sound.ISoundHandler;

public interface IGuiButton<I> extends IGui<I> {

    void drawButton(IGameEngine mc, int mouseX, int mouseY, float partialTicks);

    void mouseReleased(int mouseX, int mouseY);

    boolean mousePressed(IGameEngine mc, int mouseX, int mouseY);

    boolean isMouseOver();

    void drawButtonForegroundLayer(int mouseX, int mouseY);

    void playPressSound(ISoundHandler soundHandlerIn);

    int getButtonWidth();

    void setWidth(int width);
}
