package com.ldtteam.jvoxelizer.launcher.forge_1_12.enchantment;

import com.ldtteam.jvoxelizer.enchantment.IEnchantment;

public class Enchantment implements IEnchantment
{
    private net.minecraft.enchantment.Enchantment enchantment;

    public Enchantment(final net.minecraft.enchantment.Enchantment enchantment)
    {
        this.enchantment = enchantment;
    }

    /**
     * Getter for the wrapped forge class.
     * @return net.minecraft.enchantment.Enchantment.
     */
    public net.minecraft.enchantment.Enchantment getForgeEnchantment()
    {
        return this.enchantment;
    }
}
