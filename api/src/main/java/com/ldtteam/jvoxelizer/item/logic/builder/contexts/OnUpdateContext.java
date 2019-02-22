package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.entity.IEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;

public class OnUpdateContext {

    public OnUpdateContext(IItemStack stack, IDimension worldIn, IEntity entityIn, int itemSlot, boolean isSelected) {
        this.stack = stack;
        this.worldIn = worldIn;
        this.entityIn = entityIn;
        this.itemSlot = itemSlot;
        this.isSelected = isSelected;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }

    private IDimension worldIn;

    public IDimension getWorldIn() {
        return worldIn;
    }

    public void setWorldIn(IDimension worldIn) {
        this.worldIn = worldIn;
    }

    private IEntity entityIn;

    public IEntity getEntityIn() {
        return entityIn;
    }

    public void setEntityIn(IEntity entityIn) {
        this.entityIn = entityIn;
    }

    private int itemSlot;

    public int getItemSlot() {
        return itemSlot;
    }

    public void setItemSlot(int itemSlot) {
        this.itemSlot = itemSlot;
    }

    private boolean isSelected;

    public boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
