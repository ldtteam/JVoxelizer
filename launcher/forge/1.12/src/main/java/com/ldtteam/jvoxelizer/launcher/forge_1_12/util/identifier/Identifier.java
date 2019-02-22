package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.identifier;

import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;
import net.minecraft.util.ResourceLocation;

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
}
