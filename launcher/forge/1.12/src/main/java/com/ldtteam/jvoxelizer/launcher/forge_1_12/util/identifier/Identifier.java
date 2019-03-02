package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.identifier;

import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;
import net.minecraft.util.ResourceLocation;

/**
 * Identifier class for holding resource locations
 */
public class Identifier implements IIdentifier {
    private ResourceLocation forgeIdentifier;

    public Identifier(ResourceLocation forgeIdentifier) {
        this.forgeIdentifier = forgeIdentifier;
    }

    @Override
    public String getDomain() {
        return forgeIdentifier.getResourceDomain();
    }

    @Override
    public String getPath() {
        return forgeIdentifier.getResourcePath();
    }

    public ResourceLocation getForgeIdentifier()
    {
        return forgeIdentifier;
    }

    public static ResourceLocation asForge(IIdentifier identifier)
    {
        return ((Identifier) identifier).getForgeIdentifier();
    }
}
