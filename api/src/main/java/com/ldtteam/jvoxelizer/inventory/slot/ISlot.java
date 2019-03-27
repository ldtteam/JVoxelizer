package com.ldtteam.jvoxelizer.inventory.slot;

import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.core.logic.*;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.item.handling.IInventory;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

public interface ISlot<I> extends IInstancedObject<I> {

    void onSlotChange(IItemStack p_75220_1_, IItemStack p_75220_2_);

    IItemStack onTake(IPlayerEntity thePlayer, IItemStack stack);

    boolean isItemValid(IItemStack stack);

    IItemStack getContainedStack();

    boolean getHasStack();

    void putStack(IItemStack stack);

    void onSlotChanged();

    int getSlotStackLimit();

    int getIItemStackLimit(IItemStack stack);

    String getSlotTexture();

    IItemStack decreaseContainedStacksSize(int amount);

    boolean isHere(IInventory inv, int slotIn);

    boolean canTakeStack(IPlayerEntity playerIn);

    boolean isEnabled();

    IIdentifier getIdentifierOfBackgroundLocation();

    void setBackgroundLocation(IIdentifier texture);

    void setBackgroundName(String name);

    ISprite getBackgroundTexture();

    int getSlotIndex();

    boolean isSameInventory(ISlot other);

    int getSlotNumber();

    int getItemStackLimit(IItemStack itemstack);
}
