package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.IItemStack;

public class GetHighlightTipContext {

    public GetHighlightTipContext(IItemStack item, String displayName) {
        this.item = item;
        this.displayName = displayName;
    }

    private IItemStack item;

    public IItemStack getItem() {
        return item;
    }

    public void setItem(IItemStack item) {
        this.item = item;
    }

    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
