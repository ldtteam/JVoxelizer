package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.tessellator;

import com.ldtteam.jvoxelizer.client.renderer.bufferbuilder.IBufferBuilder;
import com.ldtteam.jvoxelizer.client.renderer.tessellator.ITessellator;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.bufferbuilder.BufferBuilder;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;

public class Tessellator implements ITessellator, IForgeJVoxelizerWrapper
{

    private final net.minecraft.client.renderer.Tessellator forgeTessellator;

    private Tessellator(final net.minecraft.client.renderer.Tessellator forgeTessellator) {this.forgeTessellator = forgeTessellator;}

    @Override
    public IBufferBuilder getBuffer()
    {
        return BufferBuilder.fromForge(forgeTessellator.getBuffer());
    }

    @Override
    public void draw()
    {
        forgeTessellator.draw();
    }

    private net.minecraft.client.renderer.Tessellator getForgeTessellator()
    {
        return forgeTessellator;
    }

    public static net.minecraft.client.renderer.Tessellator asForge(ITessellator tessellator)
    {
        if (tessellator instanceof net.minecraft.client.renderer.Tessellator)
            return (net.minecraft.client.renderer.Tessellator) tessellator;

        if (!(tessellator instanceof IForgeJVoxelizerWrapper))
            throw new IllegalArgumentException("Tessellator is not a wrapper");

        return ((IForgeJVoxelizerWrapper) tessellator).getForgeInstance();
    }

    public static ITessellator fromForge(net.minecraft.client.renderer.Tessellator tessellator)
    {
        if (tessellator instanceof ITessellator)
            return (ITessellator) tessellator;

        return new Tessellator(tessellator);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeTessellator();
    }
}
