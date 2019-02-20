package com.ldtteam.jvoxelizer.inventory.slot.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.IItemStack;

public class OnSlotChangeContext {

    public OnSlotChangeContext(IItemStack p_75220_1_, IItemStack p_75220_2_) {
        this.p_75220_1_ = p_75220_1_;
        this.p_75220_2_ = p_75220_2_;
    }

    private IItemStack p_75220_1_;

    public IItemStack getP_75220_1_() {
        return p_75220_1_;
    }

    public void setP_75220_1_(IItemStack p_75220_1_) {
        this.p_75220_1_ = p_75220_1_;
    }

    private IItemStack p_75220_2_;

    public IItemStack getP_75220_2_() {
        return p_75220_2_;
    }

    public void setP_75220_2_(IItemStack p_75220_2_) {
        this.p_75220_2_ = p_75220_2_;
    }
}
