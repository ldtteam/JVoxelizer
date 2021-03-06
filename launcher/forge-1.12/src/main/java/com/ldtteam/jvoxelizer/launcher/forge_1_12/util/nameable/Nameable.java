package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nameable;

import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.textcomponent.TextComponent;
import com.ldtteam.jvoxelizer.util.nameable.INameable;
import com.ldtteam.jvoxelizer.util.textcomponent.ITextComponent;
import net.minecraft.world.IWorldNameable;

public class Nameable implements INameable
{
    private IWorldNameable nameable;

    private Nameable(final IWorldNameable nameable)
    {
        this.nameable = nameable;
    }

    @Override
    public String getName()
    {
        return nameable.getName();
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

    public static IWorldNameable asForge(INameable nameable)
    {
        if (nameable instanceof IWorldNameable)
        {
            return (IWorldNameable) nameable;
        }

        return ((Nameable) nameable).nameable;
    }

    public static INameable fromForge(IWorldNameable nameable)
    {
        if (nameable instanceof INameable)
        {
            return (INameable) nameable;
        }

        return new Nameable(nameable);
    }
}
