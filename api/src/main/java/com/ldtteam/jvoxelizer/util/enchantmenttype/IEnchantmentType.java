package com.ldtteam.jvoxelizer.util.enchantmenttype;

import com.ldtteam.jvoxelizer.item.IItem;

public interface IEnchantmentType
{
    /**
     * Whether we can enchant this item.
     * @param item to check
     * @return true or false
     */
    public boolean canEnchantItem(IItem item);
}
