package com.ldtteam.jvoxelizer.client.gui;

import com.ldtteam.jvoxelizer.inventory.IClickType;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;

public interface IGuiContainer<I> extends IGuiScreen<I> {

    void initGui();

    void drawScreen(int mouseX, int mouseY, float partialTicks);

    void renderHoveredToolTip(int p_191948_1_, int p_191948_2_);

    void drawGuiContainerForegroundLayer(int mouseX, int mouseY);

    void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY);

    void mouseClicked(int mouseX, int mouseY, int mouseButton);

    boolean hasClickedOutside(int p_193983_1_, int p_193983_2_, int p_193983_3_, int p_193983_4_);

    void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick);

    void mouseReleased(int mouseX, int mouseY, int state);

    boolean isPointInRegion(int rectX, int rectY, int rectWidth, int rectHeight, int pointX, int pointY);

    void handleMouseClick(ISlot slotIn, int slotId, int mouseButton, IClickType type);

    void keyTyped(char typedChar, int keyCode);

    boolean checkHotbarKeys(int keyCode);

    void onGuiClosed();

    boolean doesGuiPauseGame();

    void updateScreen();

    ISlot getSlotUnderMouse();

    int getGuiLeft();

    int getGuiTop();

    int getXSize();

    int getYSize();
}
