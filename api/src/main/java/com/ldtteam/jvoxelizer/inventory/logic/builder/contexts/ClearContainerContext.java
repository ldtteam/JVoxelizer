package com.ldtteam.jvoxelizer.inventory.logic.builder.contexts;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.item.handling.IInventory;

public class ClearContainerContext {

    public ClearContainerContext(IPlayerEntity playerIn, IDimension worldIn, IInventory inventoryIn) {
        this.playerIn = playerIn;
        this.worldIn = worldIn;
        this.inventoryIn = inventoryIn;
    }

    private IPlayerEntity playerIn;

    public IPlayerEntity getPlayerIn() {
        return playerIn;
    }

    public void setPlayerIn(IPlayerEntity playerIn) {
        this.playerIn = playerIn;
    }

    private IDimension worldIn;

    public IDimension getWorldIn() {
        return worldIn;
    }

    public void setWorldIn(IDimension worldIn) {
        this.worldIn = worldIn;
    }

    private IInventory inventoryIn;

    public IInventory getInventoryIn() {
        return inventoryIn;
    }

    public void setInventoryIn(IInventory inventoryIn) {
        this.inventoryIn = inventoryIn;
    }
}
