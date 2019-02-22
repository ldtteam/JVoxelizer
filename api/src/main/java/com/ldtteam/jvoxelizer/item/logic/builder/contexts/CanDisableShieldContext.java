package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;

public class CanDisableShieldContext {

    public CanDisableShieldContext(IItemStack stack, IItemStack shield, ILivingBaseEntity entity, ILivingBaseEntity attacker) {
        this.stack = stack;
        this.shield = shield;
        this.entity = entity;
        this.attacker = attacker;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }

    private IItemStack shield;

    public IItemStack getShield() {
        return shield;
    }

    public void setShield(IItemStack shield) {
        this.shield = shield;
    }

    private ILivingBaseEntity entity;

    public ILivingBaseEntity getEntity() {
        return entity;
    }

    public void setEntity(ILivingBaseEntity entity) {
        this.entity = entity;
    }

    private ILivingBaseEntity attacker;

    public ILivingBaseEntity getAttacker() {
        return attacker;
    }

    public void setAttacker(ILivingBaseEntity attacker) {
        this.attacker = attacker;
    }
}
