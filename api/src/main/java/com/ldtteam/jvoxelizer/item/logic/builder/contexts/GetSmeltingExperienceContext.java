package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.IItemStack;

public class GetSmeltingExperienceContext {

    public GetSmeltingExperienceContext(IItemStack item) {
        this.item = item;
    }

    private IItemStack item;

    public IItemStack getItem() {
        return item;
    }

    public void setItem(IItemStack item) {
        this.item = item;
    }
}
