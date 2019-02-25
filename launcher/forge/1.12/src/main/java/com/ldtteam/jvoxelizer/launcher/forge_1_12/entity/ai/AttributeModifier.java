package com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.ai;

import com.ldtteam.jvoxelizer.entity.ai.IAttributeModifier;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class AttributeModifier implements IAttributeModifier
{

    /**
     * The Forge attribute modifier
     */
    private net.minecraft.entity.ai.attributes.AttributeModifier forgeAttributeModifier;

    public AttributeModifier(@NotNull final net.minecraft.entity.ai.attributes.AttributeModifier attributeModifier)
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
}
