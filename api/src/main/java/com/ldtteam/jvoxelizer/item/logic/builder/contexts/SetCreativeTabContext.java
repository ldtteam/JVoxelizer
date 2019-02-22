package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.group.IItemGroup;

public class SetCreativeTabContext {

    public SetCreativeTabContext(IItemGroup<?> tab) {
        this.tab = tab;
    }

    private IItemGroup<?> tab;

    public IItemGroup<?> getTab() {
        return tab;
    }

    public void setTab(IItemGroup<?> tab) {
        this.tab = tab;
    }
}
