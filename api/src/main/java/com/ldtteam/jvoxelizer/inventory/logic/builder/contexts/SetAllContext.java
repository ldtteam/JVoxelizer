package com.ldtteam.jvoxelizer.inventory.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.IItemStack;

import java.util.List;

public class SetAllContext {

    public SetAllContext(List<IItemStack> p_190896_1_) {
        this.p_190896_1_ = p_190896_1_;
    }

    private List<IItemStack> p_190896_1_;

    public List<IItemStack> getP_190896_1_() {
        return p_190896_1_;
    }

    public void setP_190896_1_(List<IItemStack> p_190896_1_) {
        this.p_190896_1_ = p_190896_1_;
    }
}
