package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.group.IItemGroup;

public class IsInCreativeTabContext {

    public IsInCreativeTabContext(IItemGroup<?> targetTab) {
        this.targetTab = targetTab;
    }

    private IItemGroup<?> targetTab;

    public IItemGroup<?> getTargetTab() {
        return targetTab;
    }

    public void setTargetTab(IItemGroup<?> targetTab) {
        this.targetTab = targetTab;
    }
}
