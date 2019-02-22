package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.IItemStack;

public class GetIsRepairableContext {

    public GetIsRepairableContext(IItemStack toRepair, IItemStack repair) {
        this.toRepair = toRepair;
        this.repair = repair;
    }

    private IItemStack toRepair;

    public IItemStack getToRepair() {
        return toRepair;
    }

    public void setToRepair(IItemStack toRepair) {
        this.toRepair = toRepair;
    }

    private IItemStack repair;

    public IItemStack getRepair() {
        return repair;
    }

    public void setRepair(IItemStack repair) {
        this.repair = repair;
    }
}
