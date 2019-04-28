package com.ldtteam.jvoxelizer.launcher.forge_1_13.util.nameable;

import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.textcomponent.TextComponent;
import com.ldtteam.jvoxelizer.util.nameable.INameable;
import com.ldtteam.jvoxelizer.util.textcomponent.ITextComponent;

public class Nameable implements INameable
{
    private net.minecraft.util.INameable nameable;

    private Nameable(final net.minecraft.util.INameable nameable)
    {
        this.nameable = nameable;
    }

    @Override
    public String getName()
    {
        return nameable.getCustomName().getFormattedText();
    }

    @Override
    public boolean hasCustomName()
    {
        return nameable.hasCustomName();
    }

    @Override
    public ITextComponent getDisplayName()
    {
        return TextComponent.fromForge(nameable.getDisplayName());
    }

    public static net.minecraft.util.INameable asForge(INameable nameable)
    {
        if (nameable instanceof net.minecraft.util.INameable)
        {
            return (net.minecraft.util.INameable) nameable;
        }

        return ((Nameable) nameable).nameable;
    }

    public static INameable fromForge(net.minecraft.util.INameable nameable)
    {
        if (nameable instanceof INameable)
        {
            return (INameable) nameable;
        }

        return new Nameable(nameable);
    }
}
