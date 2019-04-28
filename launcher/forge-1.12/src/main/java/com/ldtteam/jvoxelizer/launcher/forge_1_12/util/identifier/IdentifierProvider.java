package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.identifier;

import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifierProvider;
import net.minecraft.util.ResourceLocation;

public class IdentifierProvider implements IIdentifierProvider
{
    private static IdentifierProvider ourInstance = new IdentifierProvider();

    public static IdentifierProvider getInstance()
    {
        return ourInstance;
    }

    private IdentifierProvider()
    {
    }

    @Override
    public IIdentifier provide(final String domain, final String path)
    {
        return Identifier.fromForge(new ResourceLocation(domain, path));
    }

    @Override
    public IIdentifier provide(final String string)
    {
        return Identifier.fromForge(new ResourceLocation(string));
    }
}
