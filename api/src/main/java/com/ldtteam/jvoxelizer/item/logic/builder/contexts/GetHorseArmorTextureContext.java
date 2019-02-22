package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.entity.living.ILivingEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;

public class GetHorseArmorTextureContext {

    public GetHorseArmorTextureContext(ILivingEntity wearer, IItemStack stack) {
        this.wearer = wearer;
        this.stack = stack;
    }

    private ILivingEntity wearer;

    public ILivingEntity getWearer() {
        return wearer;
    }

    public void setWearer(ILivingEntity wearer) {
        this.wearer = wearer;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }
}
