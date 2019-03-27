package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.enchantmentType;

import com.ldtteam.jvoxelizer.item.IItem;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item;
import com.ldtteam.jvoxelizer.util.enchantmenttype.IEnchantmentType;
import net.minecraft.enchantment.EnumEnchantmentType;
import org.jetbrains.annotations.NotNull;

/**
 * Replaces EnumEnchantmentType from Minecraft.
 */
public class EnchantmentType implements IEnchantmentType
{
    /**
     * The minecraft enchantment type.
     */
    private EnumEnchantmentType minecraftEnchantMentType;

    private EnchantmentType(@NotNull final EnumEnchantmentType minecraftEnchantMentType)
    {
        this.minecraftEnchantMentType = minecraftEnchantMentType;
    }

    @Override
    public boolean canEnchantItem(final IItem itemInput)
    {
        return minecraftEnchantMentType.canEnchantItem(Item.asForge(itemInput));
    }

    public static EnumEnchantmentType asForge(IEnchantmentType type)
    {
        if (type instanceof EnumEnchantmentType)
            return (EnumEnchantmentType) type;

        return ((EnchantmentType) type).minecraftEnchantMentType;
    }

    public static IEnchantmentType fromForge(EnumEnchantmentType type)
    {
        if (type instanceof IEnchantmentType)
            return (IEnchantmentType) type;

        return new EnchantmentType(type);
    }
}
