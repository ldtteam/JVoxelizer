package com.ldtteam.jvoxelizer.client.gui;

import com.ldtteam.jvoxelizer.inventory.IClickType;
import com.ldtteam.jvoxelizer.inventory.IContainer;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;

public interface IGuiContainer<I> extends IGuiScreen<I> {

    void renderHoveredToolTip(int p_191948_1_, int p_191948_2_);

    void drawGuiContainerForegroundLayer(int mouseX, int mouseY);

    void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY);

    boolean hasClickedOutside(int p_193983_1_, int p_193983_2_, int p_193983_3_, int p_193983_4_);

    boolean isPointInRegion(int rectX, int rectY, int rectWidth, int rectHeight, int pointX, int pointY);

    void handleMouseClick(ISlot slotIn, int slotId, int mouseButton, IClickType type);

    boolean checkHotbarKeys(int keyCode);

    ISlot getSlotUnderMouse();

    int getGuiLeft();

    int getGuiTop();

    int getWidth();

    int getHeight();

    int getXSize();

    void setXSize(int xSize);

    int getYSize();

    void setYSize(int ySize);

    IContainer<?> getContainer();
}
