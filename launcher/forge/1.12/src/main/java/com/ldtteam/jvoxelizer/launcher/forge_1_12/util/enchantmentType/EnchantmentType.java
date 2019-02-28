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

    public EnchantmentType(@NotNull final EnumEnchantmentType minecraftEnchantMentType)
    {
        this.minecraftEnchantMentType = minecraftEnchantMentType;
    }

    @Override
    public boolean canEnchantItem(final IItem itemInput)
    {
        return minecraftEnchantMentType.canEnchantItem(((Item)itemInput).getForgeItem());
    }

    /**
     * Getter for the wrapped forge element.
     * @return the EnumEnchantmentType.
     */
    public EnumEnchantmentType getForgeType()
    {
       return this.minecraftEnchantMentType;
    }
}
