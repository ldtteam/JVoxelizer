package com.ldtteam.jvoxelizer.inventory;

import com.ldtteam.jvoxelizer.core.logic.*;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.handling.IInventory;

import java.util.List;

public interface IContainer<I> extends IInstancedObject<I> {

    static boolean canAddItemToSlot(ISlot slotIn, IItemStack stack, boolean stackSizeMatters)
    {
        return IContainerProviderHolder.getInstance().canAddItemToSlot(slotIn, stack, stackSizeMatters);
    }

    static void computeStackSize(List<ISlot<?>> dragSlotsIn, int dragModeIn, IItemStack stack, int slotStackSize)
    {
        IContainerProviderHolder.getInstance().computeStackSize(dragSlotsIn, dragModeIn, stack, slotStackSize);
    }

    void addSlotToContainer(ISlot<?> slot);

    void addListener(IContainerListener listener);

    List<IItemStack> getContents();

    void removeListener(IContainerListener listener);

    void updateListeners();

    boolean enchantItem(IPlayerEntity playerIn, int id);

    ISlot getSlotFromInventory(IInventory inv, int slotIn);

    ISlot getSlotById(int slotId);

    IItemStack transferStackInSlot(IPlayerEntity playerIn, int index);

    IItemStack slotClick(int slotId, int dragType, IClickType clickTypeIn, IPlayerEntity player);

    boolean canMergeSlot(IItemStack stack, ISlot slotIn);

    void onContainerClosed(IPlayerEntity playerIn);

    void onCraftMatrixChanged(IInventory inventoryIn);

    void putStackInSlot(int slotID, IItemStack stack);

    void setContentsOfAllSlots(List<IItemStack> p_190896_1_);

    void updateProgressBar(int id, int data);

    short getNextTransactionID(IInventoryPlayer invPlayer);

    boolean getCanCraft(IPlayerEntity player);

    void setCanCraft(IPlayerEntity player, boolean canCraft);

    boolean canInteractWith(IPlayerEntity playerIn);

    boolean canDragIntoSlot(ISlot slotIn);

    List<ISlot<?>> getInventorySlots();

    /**
     * Clears the container inventory completely!
     */
    void clearInventory();

    List<IItemStack> getInventoryItemStacks();

    boolean mergeItemStack(final IItemStack stack, final int startIndex, final int endIndex, final boolean reverseDirection);
}
