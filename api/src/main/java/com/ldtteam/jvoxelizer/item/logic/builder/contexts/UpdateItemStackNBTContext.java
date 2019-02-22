package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.util.nbt.INBTCompound;

public class UpdateItemStackNBTContext {

    public UpdateItemStackNBTContext(INBTCompound nbt) {
        this.nbt = nbt;
    }

    private INBTCompound nbt;

    public INBTCompound getNbt() {
        return nbt;
    }

    public void setNbt(INBTCompound nbt) {
        this.nbt = nbt;
    }
}
