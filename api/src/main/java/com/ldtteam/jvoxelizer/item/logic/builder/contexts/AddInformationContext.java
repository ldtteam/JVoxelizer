package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.tooltipflag.IToolTipFlag;

import java.util.List;

public class AddInformationContext {

    public AddInformationContext(IItemStack stack, IDimension worldIn, List<String> tooltip, IToolTipFlag flagIn) {
        this.stack = stack;
        this.worldIn = worldIn;
        this.tooltip = tooltip;
        this.flagIn = flagIn;
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

    private List<String> tooltip;

    public List<String> getTooltip() {
        return tooltip;
    }

    public void setTooltip(List<String> tooltip) {
        this.tooltip = tooltip;
    }

    private IToolTipFlag flagIn;

    public IToolTipFlag getFlagIn() {
        return flagIn;
    }

    public void setFlagIn(IToolTipFlag flagIn) {
        this.flagIn = flagIn;
    }
}
