package com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.slot;

import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISpriteMap;
import com.ldtteam.jvoxelizer.core.logic.DummyInstanceData;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.handling.IInventory;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.texture.Sprite;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.texture.SpriteMap;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player.PlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.Inventory;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.identifier.Identifier;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

public class Slot implements ISlot<DummyInstanceData>
{
    private final net.minecraft.inventory.Slot forgeSlot;

    private Slot(final net.minecraft.inventory.Slot forgeSlot) {this.forgeSlot = forgeSlot;}

    @Override
    public void onSlotChange(final IItemStack p_75220_1_, final IItemStack p_75220_2_)
    {
        forgeSlot.onSlotChange(ItemStack.asForge(p_75220_1_), ItemStack.asForge(p_75220_2_));
    }

    @Override
    public IItemStack onTake(final IPlayerEntity thePlayer, final IItemStack stack)
    {
        return ItemStack.fromForge(forgeSlot.onTake(PlayerEntity.asForge(thePlayer),  ItemStack.asForge(stack)));
    }

    @Override
    public boolean isItemValid(final IItemStack stack)
    {
        return forgeSlot.isItemValid(ItemStack.asForge(stack));
    }

    @Override
    public IItemStack getStack()
    {
        return ItemStack.fromForge(forgeSlot.getStack());
    }

    @Override
    public boolean getHasStack()
    {
        return forgeSlot.getHasStack();
    }

    @Override
    public void putStack(final IItemStack stack)
    {
        forgeSlot.putStack(ItemStack.asForge(stack));
    }

    @Override
    public void onSlotChanged()
    {
        forgeSlot.onSlotChanged();
    }

    @Override
    public int getSlotStackLimit()
    {
        return forgeSlot.getSlotStackLimit();
    }

    @Override
    public int getIItemStackLimit(final IItemStack stack)
    {
        return forgeSlot.getItemStackLimit(ItemStack.asForge(stack));
    }

    @Override
    public String getSlotTexture()
    {
        return forgeSlot.getSlotTexture();
    }

    @Override
    public IItemStack decrStackSize(final int amount)
    {
        return ItemStack.fromForge(forgeSlot.decrStackSize(amount));
    }

    @Override
    public boolean isHere(final IInventory inv, final int slotIn)
    {
        return forgeSlot.isHere(Inventory.asForge(inv), slotIn);
    }

    @Override
    public boolean canTakeStack(final IPlayerEntity playerIn)
    {
        return forgeSlot.canTakeStack(PlayerEntity.asForge(playerIn));
    }

    @Override
    public boolean isEnabled()
    {
        return forgeSlot.isEnabled();
    }

    @Override
    public IIdentifier getBackgroundLocation()
    {
        return Identifier.fromForge(forgeSlot.getBackgroundLocation());
    }

    @Override
    public void setBackgroundLocation(final IIdentifier texture)
    {
        forgeSlot.setBackgroundLocation(Identifier.asForge(texture));
    }

    @Override
    public void setBackgroundName(final String name)
    {
        forgeSlot.setBackgroundName(name);
    }

    @Override
    public ISprite getBackgroundSprite()
    {
        return Sprite.fromForge(forgeSlot.getBackgroundSprite());
    }

    @Override
    public int getSlotIndex()
    {
        return forgeSlot.getSlotIndex();
    }

    @Override
    public boolean isSameInventory(final ISlot other)
    {
        return forgeSlot.isSameInventory(Slot.asForge(other));
    }

    @Override
    public int getSlotNumber()
    {
        return forgeSlot.slotNumber;
    }

    @Override
    public int getItemStackLimit(final IItemStack itemstack)
    {
        return forgeSlot.getItemStackLimit(ItemStack.asForge(itemstack));
    }

    @Override
    public DummyInstanceData getInstanceData()
    {
        return new DummyInstanceData();
    }

    public net.minecraft.inventory.Slot getForgeSlot()
    {
        return forgeSlot;
    }

    public static net.minecraft.inventory.Slot asForge(ISlot slot)
    {
        if (slot instanceof net.minecraft.inventory.Slot)
            return (net.minecraft.inventory.Slot) slot;

        return ((Slot) slot).getForgeSlot();
    }

    public static ISlot<?> fromForge(net.minecraft.inventory.Slot slot)
    {
        if (slot instanceof ISlot)
            return (ISlot<?>) slot;

        return new Slot(slot);
    }
}
