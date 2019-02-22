package com.ldtteam.jvoxelizer.inventory.logic.builder.contexts;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.IInventoryCraftResult;
import com.ldtteam.jvoxelizer.inventory.IInventoryCrafting;

public class SlotChangedCraftingGridContext {

    public SlotChangedCraftingGridContext(IDimension p_192389_1_, IPlayerEntity p_192389_2_, IInventoryCrafting p_192389_3_, IInventoryCraftResult p_192389_4_) {
        this.p_192389_1_ = p_192389_1_;
        this.p_192389_2_ = p_192389_2_;
        this.p_192389_3_ = p_192389_3_;
        this.p_192389_4_ = p_192389_4_;
    }

    private IDimension p_192389_1_;

    public IDimension getP_192389_1_() {
        return p_192389_1_;
    }

    public void setP_192389_1_(IDimension p_192389_1_) {
        this.p_192389_1_ = p_192389_1_;
    }

    private IPlayerEntity p_192389_2_;

    public IPlayerEntity getP_192389_2_() {
        return p_192389_2_;
    }

    public void setP_192389_2_(IPlayerEntity p_192389_2_) {
        this.p_192389_2_ = p_192389_2_;
    }

    private IInventoryCrafting p_192389_3_;

    public IInventoryCrafting getP_192389_3_() {
        return p_192389_3_;
    }

    public void setP_192389_3_(IInventoryCrafting p_192389_3_) {
        this.p_192389_3_ = p_192389_3_;
    }

    private IInventoryCraftResult p_192389_4_;

    public IInventoryCraftResult getP_192389_4_() {
        return p_192389_4_;
    }

    public void setP_192389_4_(IInventoryCraftResult p_192389_4_) {
        this.p_192389_4_ = p_192389_4_;
    }
}
