package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.hand.IHand;

public class ItemInteractionForEntityContext {

    public ItemInteractionForEntityContext(IItemStack stack, IPlayerEntity playerIn, ILivingBaseEntity target, IHand hand) {
        this.stack = stack;
        this.playerIn = playerIn;
        this.target = target;
        this.hand = hand;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }

    private IPlayerEntity playerIn;

    public IPlayerEntity getPlayerIn() {
        return playerIn;
    }

    public void setPlayerIn(IPlayerEntity playerIn) {
        this.playerIn = playerIn;
    }

    private ILivingBaseEntity target;

    public ILivingBaseEntity getTarget() {
        return target;
    }

    public void setTarget(ILivingBaseEntity target) {
        this.target = target;
    }

    private IHand hand;

    public IHand getHand() {
        return hand;
    }

    public void setHand(IHand hand) {
        this.hand = hand;
    }
}
