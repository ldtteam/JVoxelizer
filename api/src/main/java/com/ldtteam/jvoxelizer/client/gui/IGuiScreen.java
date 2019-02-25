package com.ldtteam.jvoxelizer.client.gui;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.client.renderer.item.IItemRenderer;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.textcomponent.ITextComponent;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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

    void keyTyped(char typedChar, int keyCode);

    <T extends IGuiButton> T addButton(T buttonIn);

    void renderToolTip(IItemStack stack, int x, int y);

    List<String> getItemToolTip(IItemStack p_191927_1_);

    void drawHoveringText(String text, int x, int y);

    void setFocused(boolean hasFocusedControlIn);

    boolean isFocused();

    void drawHoveringText(List<String> textLines, int x, int y);

    void drawHoveringText(List<String> textLines, int x, int y, IFontRenderer font);

    void handleComponentHover(ITextComponent component, int x, int y);

    void setText(String newChatText, boolean shouldOverwrite);

    boolean handleComponentClick(ITextComponent component);

    void sendChatMessage(String msg);

    void sendChatMessage(String msg, boolean addToChat);

    void mouseClicked(int mouseX, int mouseY, int mouseButton);

    void mouseReleased(int mouseX, int mouseY, int state);

    void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick);

    void actionPerformed(IGuiButton button);

    void setWorldAndResolution(IGameEngine mc, int width, int height);

    void setGuiSize(int w, int h);

    void initGui();

    void handleInput();

    void handleMouseInput();

    void handleKeyboardInput();

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
