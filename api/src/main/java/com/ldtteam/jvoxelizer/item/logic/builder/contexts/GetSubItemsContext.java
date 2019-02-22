package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.group.IItemGroup;

import java.util.List;

public class GetSubItemsContext {

    public GetSubItemsContext(IItemGroup<?> tab, List<IItemStack> items) {
        this.tab = tab;
        this.items = items;
    }

    private IItemGroup<?> tab;

    public IItemGroup<?> getTab() {
        return tab;
    }

    public void setTab(IItemGroup<?> tab) {
        this.tab = tab;
    }

    private List<IItemStack> items;

    public List<IItemStack> getItems() {
        return items;
    }

    public void setItems(List<IItemStack> items) {
        this.items = items;
    }
}
