package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.nbt.INBTCompound;

public class ReadNBTShareTagContext {

    public ReadNBTShareTagContext(IItemStack stack, INBTCompound nbt) {
        this.stack = stack;
        this.nbt = nbt;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }

    private INBTCompound nbt;

    public INBTCompound getNbt() {
        return nbt;
    }

    public void setNbt(INBTCompound nbt) {
        this.nbt = nbt;
    }
}
