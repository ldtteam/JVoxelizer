package com.ldtteam.jvoxelizer.inventory.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.handling.IInventory;

public class OnCraftMatrixChangedContext {

    public OnCraftMatrixChangedContext(IInventory inventoryIn) {
        this.inventoryIn = inventoryIn;
    }

    private IInventory inventoryIn;

    public IInventory getInventoryIn() {
        return inventoryIn;
    }

    public void setInventoryIn(IInventory inventoryIn) {
        this.inventoryIn = inventoryIn;
    }
}
