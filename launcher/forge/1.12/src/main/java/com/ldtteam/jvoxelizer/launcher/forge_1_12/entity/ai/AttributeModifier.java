package com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.ai;

import com.ldtteam.jvoxelizer.entity.ai.IAttributeModifier;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class AttributeModifier implements IAttributeModifier
{
    private net.minecraft.entity.ai.attributes.AttributeModifier forgeAttributeModifier;

    private AttributeModifier(@NotNull final net.minecraft.entity.ai.attributes.AttributeModifier attributeModifier)
    {
        this.forgeAttributeModifier = attributeModifier;
    }

    @Override
    public UUID getID()
    {
        return forgeAttributeModifier.getID();
    }

    @Override
    public String getName()
    {
        return forgeAttributeModifier.getName();
    }

    @Override
    public int getOperation()
    {
        return forgeAttributeModifier.getOperation();
    }

    @Override
    public double getAmount()
    {
        return forgeAttributeModifier.getAmount();
    }

    @Override
    public boolean isSaved()
    {
        return forgeAttributeModifier.isSaved();
    }

    @Override
    public IAttributeModifier setSaved(final boolean saved)
    {
        forgeAttributeModifier.setSaved(saved);
        return this;
    }

    private net.minecraft.entity.ai.attributes.AttributeModifier getForgeAttributeModifier()
    {
        return forgeAttributeModifier;
    }

    public static net.minecraft.entity.ai.attributes.AttributeModifier asForge(IAttributeModifier modifier)
    {
        if (modifier instanceof net.minecraft.entity.ai.attributes.AttributeModifier)
            return (net.minecraft.entity.ai.attributes.AttributeModifier) modifier;

        return ((AttributeModifier) modifier).getForgeAttributeModifier();
    }

    public static IAttributeModifier fromForge(net.minecraft.entity.ai.attributes.AttributeModifier modifier)
    {
        if (modifier instanceof IAttributeModifier)
            return (IAttributeModifier) modifier;

        return new AttributeModifier(modifier);
    }
}
