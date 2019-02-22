package com.ldtteam.jvoxelizer.item.group.logic.builder.contexts;

import com.ldtteam.jvoxelizer.util.enchantmenttype.IEnchantmentType;

public class HasRelevantEnchantmentTypeContext {

    public HasRelevantEnchantmentTypeContext(IEnchantmentType enchantmentType) {
        this.enchantmentType = enchantmentType;
    }

    private IEnchantmentType enchantmentType;

    public IEnchantmentType getEnchantmentType() {
        return enchantmentType;
    }

    public void setEnchantmentType(IEnchantmentType enchantmentType) {
        this.enchantmentType = enchantmentType;
    }
}
