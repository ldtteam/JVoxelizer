package com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory;

import com.ldtteam.jvoxelizer.core.exceptions.FeatureNotImplementedException;
import com.ldtteam.jvoxelizer.core.logic.DummyInstanceData;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.*;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.handling.IInventory;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player.PlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.slot.Slot;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemStack;

import java.util.List;
import java.util.stream.Collectors;

public class Container implements IContainer<DummyInstanceData>, IForgeJVoxelizerWrapper
{
    private final net.minecraft.inventory.Container forgeContainer;

    private Container(final net.minecraft.inventory.Container forgeContainer) {this.forgeContainer = forgeContainer;}

    @Override
    public void addSlotToContainer(final ISlot<?> slot)
    {
        throw new FeatureNotImplementedException("Adding Slots to Wrapped Container");
    }

    @Override
    public void addListener(final IContainerListener listener)
    {
        forgeContainer.addListener(ContainerListener.asForge(listener));
    }

    @Override
    public List<IItemStack> getContents()
    {
        return forgeContainer.getInventory().stream().map(ItemStack::fromForge).collect(Collectors.toList());
    }

    @Override
    public void removeListener(final IContainerListener listener)
    {
        forgeContainer.removeListener(ContainerListener.asForge(listener));
    }

    @Override
    public void updateListeners()
    {
        forgeContainer.detectAndSendChanges();
    }

    @Override
    public boolean enchantItem(final IPlayerEntity playerIn, final int id)
    {
        return forgeContainer.enchantItem(PlayerEntity.asForge(playerIn), id);
    }

    @Override
    public ISlot getSlotFromInventory(final IInventory inv, final int slotIn)
    {
        return Slot.fromForge(forgeContainer.getSlotFromInventory(Inventory.asForge(inv), slotIn));
    }

    @Override
    public ISlot getSlotById(final int slotId)
    {
        return Slot.fromForge(forgeContainer.getSlot(slotId));
    }

    @Override
    public IItemStack transferStackInSlot(final IPlayerEntity playerIn, final int index)
    {
        return ItemStack.fromForge(forgeContainer.transferStackInSlot(PlayerEntity.asForge(playerIn), index));
    }

    @Override
    public IItemStack slotClick(final int slotId, final int dragType, final IClickType clickTypeIn, final IPlayerEntity player)
    {
        return ItemStack.fromForge(forgeContainer.slotClick(slotId, dragType, ClickType.asForge(clickTypeIn), PlayerEntity.asForge(player)));
    }

    @Override
    public boolean canMergeSlot(final IItemStack stack, final ISlot slotIn)
    {
        return forgeContainer.canMergeSlot(ItemStack.asForge(stack), Slot.asForge(slotIn));
    }

    @Override
    public void onContainerClosed(final IPlayerEntity playerIn)
    {
        forgeContainer.onContainerClosed(PlayerEntity.asForge(playerIn));
    }

    @Override
    public void onCraftMatrixChanged(final IInventory inventoryIn)
    {
        forgeContainer.onCraftMatrixChanged(Inventory.asForge(inventoryIn));
    }

    @Override
    public void putStackInSlot(final int slotID, final IItemStack stack)
    {
        forgeContainer.putStackInSlot(slotID, ItemStack.asForge(stack));
    }

    @Override
    public void setContentsOfAllSlots(final List<IItemStack> p_190896_1_)
    {
        forgeContainer.setAll(p_190896_1_.stream().map(ItemStack::asForge).collect(Collectors.toList()));
    }

    @Override
    public void updateProgressBar(final int id, final int data)
    {
        forgeContainer.updateProgressBar(id, data);
    }

    @Override
    public short getNextTransactionID(final IInventoryPlayer invPlayer)
    {
        return forgeContainer.getNextTransactionID(InventoryPlayer.asForge(invPlayer));
    }

    @Override
    public boolean getCanCraft(final IPlayerEntity player)
    {
        return forgeContainer.getCanCraft(PlayerEntity.asForge(player));
    }

    @Override
    public void setCanCraft(final IPlayerEntity player, final boolean canCraft)
    {
        forgeContainer.setCanCraft(PlayerEntity.asForge(player), canCraft);
    }

    @Override
    public boolean canInteractWith(final IPlayerEntity playerIn)
    {
        return forgeContainer.canInteractWith(PlayerEntity.asForge(playerIn));
    }

    @Override
    public boolean canDragIntoSlot(final ISlot slotIn)
    {
        return forgeContainer.canDragIntoSlot(Slot.asForge(slotIn));
    }

    @Override
    public List<ISlot<?>> getInventorySlots()
    {
        return forgeContainer.inventorySlots.stream().map(Slot::fromForge).collect(Collectors.toList());
    }

    /**
     * Clears the container inventory completely!
     */
    public void clearInventory()
    {
        forgeContainer.inventorySlots.clear();
        forgeContainer.inventoryItemStacks.clear();
    }

    @Override
    public List<IItemStack> getInventoryItemStacks()
    {
        return getContents();
    }

    @Override
    public boolean mergeItemStack(final IItemStack stack, final int startIndex, final int endIndex, final boolean reverseDirection)
    {
        throw new FeatureNotImplementedException("Merging ItemStack with Slot contents");
    }

    @Override
    public DummyInstanceData getInstanceData()
    {
        return new DummyInstanceData();
    }

    private net.minecraft.inventory.Container getForgeContainer()
    {
        return forgeContainer;
    }

    public static net.minecraft.inventory.Container asForge(IContainer<?> container)
    {
        if (container instanceof net.minecraft.inventory.Container)
        {
            return (net.minecraft.inventory.Container) container;
        }

        if (container == null)
        {
            return null;
        }

        if (!(container instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("Container is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) container).getForgeInstance();
    }

    public static IContainer<?> fromForge(net.minecraft.inventory.Container container)
    {
        if (container instanceof IContainer)
        {
            return (IContainer<?>) container;
        }

        return new Container(container);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeContainer();
    }
}
