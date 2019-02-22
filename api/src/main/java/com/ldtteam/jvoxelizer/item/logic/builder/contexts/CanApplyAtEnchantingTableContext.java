package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.enchantment.IEnchantment;
import com.ldtteam.jvoxelizer.item.IItemStack;

public class CanApplyAtEnchantingTableContext {

    public CanApplyAtEnchantingTableContext(IItemStack stack, IEnchantment enchantment) {
        this.stack = stack;
        this.enchantment = enchantment;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }

    private IEnchantment enchantment;

    public IEnchantment getEnchantment() {
        return enchantment;
    }

    public void setEnchantment(IEnchantment enchantment) {
        this.enchantment = enchantment;
    }
}
