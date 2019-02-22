package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.util.facing.IFacing;
import com.ldtteam.jvoxelizer.util.hand.IHand;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;

public class OnItemUseFirstContext {

    public OnItemUseFirstContext(IPlayerEntity player, IDimension world, IBlockCoordinate pos, IFacing side, float hitX, float hitY, float hitZ, IHand hand) {
        this.player = player;
        this.world = world;
        this.pos = pos;
        this.side = side;
        this.hitX = hitX;
        this.hitY = hitY;
        this.hitZ = hitZ;
        this.hand = hand;
    }

    private IPlayerEntity player;

    public IPlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(IPlayerEntity player) {
        this.player = player;
    }

    private IDimension world;

    public IDimension getWorld() {
        return world;
    }

    public void setWorld(IDimension world) {
        this.world = world;
    }

    private IBlockCoordinate pos;

    public IBlockCoordinate getPos() {
        return pos;
    }

    public void setPos(IBlockCoordinate pos) {
        this.pos = pos;
    }

    private IFacing side;

    public IFacing getSide() {
        return side;
    }

    public void setSide(IFacing side) {
        this.side = side;
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

    private IHand hand;

    public IHand getHand() {
        return hand;
    }

    public void setHand(IHand hand) {
        this.hand = hand;
    }
}
