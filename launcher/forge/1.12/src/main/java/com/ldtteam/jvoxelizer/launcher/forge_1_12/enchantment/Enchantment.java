package com.ldtteam.jvoxelizer.launcher.forge_1_12.enchantment;

import com.ldtteam.jvoxelizer.enchantment.IEnchantment;

public class Enchantment implements IEnchantment
{
    private net.minecraft.enchantment.Enchantment enchantment;

    private Enchantment(final net.minecraft.enchantment.Enchantment enchantment)
    {
        this.enchantment = enchantment;
    }

    /**
     * Getter for the wrapped forge class.
     * @return net.minecraft.enchantment.Enchantment.
     */
    private net.minecraft.enchantment.Enchantment getForgeEnchantment()
    {
        return this.enchantment;
    }

    public static net.minecraft.enchantment.Enchantment asForge(IEnchantment enchantment)
    {
        if (enchantment instanceof Enchantment)
            return (net.minecraft.enchantment.Enchantment) enchantment;

        return ((Enchantment) enchantment).getForgeEnchantment();
    }

    public static IEnchantment fromForge(net.minecraft.enchantment.Enchantment enchantment)
    {
        if (enchantment instanceof IEnchantment)
            return (IEnchantment) enchantment;

        return new Enchantment(enchantment);
    }
}
