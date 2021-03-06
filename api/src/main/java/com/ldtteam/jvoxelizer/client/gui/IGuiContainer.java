package com.ldtteam.jvoxelizer.client.gui;

import com.ldtteam.jvoxelizer.inventory.IContainer;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.item.IItemStack;

import java.util.List;

public interface IGuiContainer<I> extends IGuiScreen<I> {

    ISlot getSlotUnderCursor();

    int getGuiLeft();

    int getGuiTop();

    int getXSize();

    void setXSize(int xSize);

    int getYSize();

    void setYSize(int ySize);

    IContainer<?> getContainer();

    void setHoveredSlot(ISlot slot);

    ISlot<?> getClickedSlot();

    IItemStack getDraggedStack();

    boolean isRightMouseClicked();

    boolean isDragSplitting();

    List<ISlot<?>> getSlotsUsedInDragSplitting();

    int getDragSplittingLimit();

    void updateDragSplitting();
}
