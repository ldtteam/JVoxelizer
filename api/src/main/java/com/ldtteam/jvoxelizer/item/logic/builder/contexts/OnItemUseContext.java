package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.util.facing.IFacing;
import com.ldtteam.jvoxelizer.util.hand.IHand;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;

public class OnItemUseContext {

    public OnItemUseContext(IPlayerEntity player, IDimension worldIn, IBlockCoordinate pos, IHand hand, IFacing facing, float hitX, float hitY, float hitZ) {
        this.player = player;
        this.worldIn = worldIn;
        this.pos = pos;
        this.hand = hand;
        this.facing = facing;
        this.hitX = hitX;
        this.hitY = hitY;
        this.hitZ = hitZ;
    }

    private IPlayerEntity player;

    public IPlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(IPlayerEntity player) {
        this.player = player;
    }

    private IDimension worldIn;

    public IDimension getWorldIn() {
        return worldIn;
    }

    public void setWorldIn(IDimension worldIn) {
        this.worldIn = worldIn;
    }

    private IBlockCoordinate pos;

    public IBlockCoordinate getPos() {
        return pos;
    }

    public void setPos(IBlockCoordinate pos) {
        this.pos = pos;
    }

    private IHand hand;

    public IHand getHand() {
        return hand;
    }

    public void setHand(IHand hand) {
        this.hand = hand;
    }

    private IFacing facing;

    public IFacing getFacing() {
        return facing;
    }

    public void setFacing(IFacing facing) {
        this.facing = facing;
    }

    private float hitX;

    public float getHitX() {
        return hitX;
    }

    public void setHitX(float hitX) {
        this.hitX = hitX;
    }

    private float hitY;

    public float getHitY() {
        return hitY;
    }

    public void setHitY(float hitY) {
        this.hitY = hitY;
    }

    private float hitZ;

    public float getHitZ() {
        return hitZ;
    }

    public void setHitZ(float hitZ) {
        this.hitZ = hitZ;
    }
}
