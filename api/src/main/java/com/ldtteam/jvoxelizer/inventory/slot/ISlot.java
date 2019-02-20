package com.ldtteam.jvoxelizer.inventory.slot;

import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISpriteMap;
import com.ldtteam.jvoxelizer.entity.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.handling.IItemHandler;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

public interface ISlot {

    void onSlotChange(IItemStack p_75220_1_, IItemStack p_75220_2_);

    void onCrafting(IItemStack stack, int amount);

    void onSwapCraft(int p_190900_1_);

    void onCrafting(IItemStack stack);

    IItemStack onTake(IPlayerEntity thePlayer, IItemStack stack);

    boolean isItemValid(IItemStack stack);

    IItemStack getStack();

    boolean getHasStack();

    void putStack(IItemStack stack);

    void onSlotChanged();

    int getSlotStackLimit();

    int getIItemStackLimit(IItemStack stack);

    String getSlotTexture();

    IItemStack decrStackSize(int amount);

    boolean isHere(IItemHandler inv, int slotIn);

    boolean canTakeStack(IPlayerEntity playerIn);

    boolean isEnabled();

    IIdentifier getBackgroundLocation();

    void setBackgroundLocation(IIdentifier texture);

    void setBackgroundName(String name);

    ISprite getBackgroundSprite();

    ISpriteMap getBackgroundMap();

    int getSlotIndex();

    boolean isSameInventory(ISlot other);
}
