package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;

public class HitEntityContext {

    public HitEntityContext(IItemStack stack, ILivingBaseEntity target, ILivingBaseEntity attacker) {
        this.stack = stack;
        this.target = target;
        this.attacker = attacker;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }

    private ILivingBaseEntity target;

    public ILivingBaseEntity getTarget() {
        return target;
    }

    public void setTarget(ILivingBaseEntity target) {
        this.target = target;
    }

    private ILivingBaseEntity attacker;

    public ILivingBaseEntity getAttacker() {
        return attacker;
    }

    public void setAttacker(ILivingBaseEntity attacker) {
        this.attacker = attacker;
    }
}
