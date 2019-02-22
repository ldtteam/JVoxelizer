package com.ldtteam.jvoxelizer.item.group.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.IItemStack;

import java.util.List;

public class DisplayAllRelevantItemsContext {

    public DisplayAllRelevantItemsContext(List<IItemStack> p_78018_1_) {
        this.p_78018_1_ = p_78018_1_;
    }

    private List<IItemStack> p_78018_1_;

    public List<IItemStack> getP_78018_1_() {
        return p_78018_1_;
    }

    public void setP_78018_1_(List<IItemStack> p_78018_1_) {
        this.p_78018_1_ = p_78018_1_;
    }
}
