package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;

public class RayTraceContext {

    public RayTraceContext(IDimension worldIn, IPlayerEntity playerIn, boolean useLiquids) {
        this.worldIn = worldIn;
        this.playerIn = playerIn;
        this.useLiquids = useLiquids;
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

    private boolean useLiquids;

    public boolean getUseLiquids() {
        return useLiquids;
    }

    public void setUseLiquids(boolean useLiquids) {
        this.useLiquids = useLiquids;
    }
}
