package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.util.hand.IHand;

public class OnItemRightClickContext {

    public OnItemRightClickContext(IDimension worldIn, IPlayerEntity playerIn, IHand handIn) {
        this.worldIn = worldIn;
        this.playerIn = playerIn;
        this.handIn = handIn;
    }

    private IDimension worldIn;

    public IDimension getWorldIn() {
        return worldIn;
    }

    public void setWorldIn(IDimension worldIn) {
        this.worldIn = worldIn;
    }

    private IPlayerEntity playerIn;

    public IPlayerEntity getPlayerIn() {
        return playerIn;
    }

    public void setPlayerIn(IPlayerEntity playerIn) {
        this.playerIn = playerIn;
    }

    private IHand handIn;

    public IHand getHandIn() {
        return handIn;
    }

    public void setHandIn(IHand handIn) {
        this.handIn = handIn;
    }
}
