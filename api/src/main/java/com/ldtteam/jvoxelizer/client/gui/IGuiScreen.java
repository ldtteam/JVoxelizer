package com.ldtteam.jvoxelizer.client.gui;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.client.renderer.item.IItemRenderer;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.textcomponent.ITextComponent;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.util.List;

public interface IGuiScreen<I> extends IGui<I>, IGuiYesNoCallback {

    static boolean isShiftKeyDown()
    {
        throw new NotImplementedException();
    }

    static boolean isCtrlKeyDown()
    {
        throw new NotImplementedException();
    }

    static void setClipboardString(String selectedText)
    {
        throw new NotImplementedException();
    }

    static String getClipboardString()
    {
        throw new NotImplementedException();
    }

    void drawScreen(int mouseX, int mouseY, float partialTicks);

    List<String> getItemToolTip(IItemStack p_191927_1_);

    void drawHoveringText(String text, int x, int y);

    void setFocused(boolean hasFocusedControlIn);

    boolean isFocused();

    void drawHoveringText(List<String> textLines, int x, int y);

    boolean handleComponentClick(ITextComponent component);

    void sendChatMessage(String msg);

    void sendChatMessage(String msg, boolean addToChat);

    void setWorldAndResolution(IGameEngine mc, int width, int height);

    void setGuiSize(int w, int h);

    void initGui();

    void handleInput() throws IOException;

    void handleMouseInput() throws IOException;

    void handleKeyboardInput() throws IOException;

    void updateScreen();

    void onGuiClosed();

    void drawDefaultBackground();

    void drawWorldBackground(int tint);

    void drawBackground(int tint);

    boolean doesGuiPauseGame();

    void confirmClicked(boolean result, int id);

    void onResize(IGameEngine mcIn, int w, int h);

    IItemRenderer getItemRenderer();
}
