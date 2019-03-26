package com.ldtteam.jvoxelizer.item.group.logic.builder.contexts;

import com.ldtteam.jvoxelizer.util.enchantmenttype.IEnchantmentType;

public class SetRelevantEnchantmentTypesContext {

    public SetRelevantEnchantmentTypesContext(IEnchantmentType... types) {
        this.types = types;
    }

    private IEnchantmentType[] types;

    public IEnchantmentType[] getTypes() {
        return types;
    }

    public void setTypes(IEnchantmentType... types) {
        this.types = types;
    }
}
