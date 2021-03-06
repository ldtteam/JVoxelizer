package com.ldtteam.jvoxelizer.launcher.forge_1_13.enchantment;

import com.ldtteam.jvoxelizer.enchantment.IEnchantment;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;

public class Enchantment implements IEnchantment, IForgeJVoxelizerWrapper
{
    private net.minecraft.enchantment.Enchantment enchantment;

    private Enchantment(final net.minecraft.enchantment.Enchantment enchantment)
    {
        this.enchantment = enchantment;
    }

    /**
     * Getter for the wrapped forge class.
     *
     * @return net.minecraft.enchantment.Enchantment.
     */
    private net.minecraft.enchantment.Enchantment getForgeEnchantment()
    {
        return this.enchantment;
    }

    public static net.minecraft.enchantment.Enchantment asForge(IEnchantment enchantment)
    {
        if (enchantment instanceof Enchantment)
        {
            return (net.minecraft.enchantment.Enchantment) enchantment;
        }

        if (enchantment == null)
        {
            return null;
        }

        if (!(enchantment instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("Enchantment is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) enchantment).getForgeInstance();
    }

    public static IEnchantment fromForge(net.minecraft.enchantment.Enchantment enchantment)
    {
        if (enchantment instanceof IEnchantment)
        {
            return (IEnchantment) enchantment;
        }

        return new Enchantment(enchantment);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeEnchantment();
    }
}
