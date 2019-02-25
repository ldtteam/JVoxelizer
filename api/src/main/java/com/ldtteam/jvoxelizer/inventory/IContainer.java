package com.ldtteam.jvoxelizer.inventory;

import com.ldtteam.jvoxelizer.core.logic.*;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.handling.IInventory;
import com.ldtteam.jvoxelizer.dimension.IDimension;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Set;

public interface IContainer<I> extends IInstancedObject<I> {

    static boolean canAddItemToSlot(ISlot slotIn, IItemStack stack, boolean stackSizeMatters)
    {
        throw new NotImplementedException();
    }

    static void computeStackSize(List<ISlot<?>> dragSlotsIn, int dragModeIn, IItemStack stack, int slotStackSize)
    {
        throw new NotImplementedException();
    }

    ISlot addSlotToContainer(ISlot slotIn);

    void addListener(IContainerListener listener);

    List<IItemStack> getInventory();

    void removeListener(IContainerListener listener);

    void detectAndSendChanges();

    boolean enchantItem(IPlayerEntity playerIn, int id);

    ISlot getSlotFromInventory(IInventory inv, int slotIn);

    ISlot getSlot(int slotId);

    IItemStack transferStackInSlot(IPlayerEntity playerIn, int index);

    IItemStack slotClick(int slotId, int dragType, IClickType clickTypeIn, IPlayerEntity player);

    boolean canMergeSlot(IItemStack stack, ISlot slotIn);

    void onContainerClosed(IPlayerEntity playerIn);

    void clearContainer(IPlayerEntity playerIn, IDimension worldIn, IInventory inventoryIn);

    void onCraftMatrixChanged(IInventory inventoryIn);

    void putStackInSlot(int slotID, IItemStack stack);

    void setAll(List<IItemStack> p_190896_1_);

    void updateProgressBar(int id, int data);

    short getNextTransactionID(IInventoryPlayer invPlayer);

    boolean getCanCraft(IPlayerEntity player);

    void setCanCraft(IPlayerEntity player, boolean canCraft);

    boolean canInteractWith(IPlayerEntity playerIn);

    boolean mergeItemStack(IItemStack stack, int startIndex, int endIndex, boolean reverseDirection);

    void resetDrag();

    boolean canDragIntoSlot(ISlot slotIn);

    void slotChangedCraftingGrid(IDimension p_192389_1_, IPlayerEntity p_192389_2_, IInventoryCrafting p_192389_3_, IInventory p_192389_4_);

    List<ISlot<?>> getInventorySlots();

    List<IItemStack> getInventoryItemStacks();
}
