package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.tessellator;

import com.ldtteam.jvoxelizer.client.renderer.bufferbuilder.IBufferBuilder;
import com.ldtteam.jvoxelizer.client.renderer.tessellator.ITessellator;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.bufferbuilder.BufferBuilder;

public class Tessellator implements ITessellator
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

    public net.minecraft.client.renderer.Tessellator getForgeTessellator()
    {
        return forgeTessellator;
    }

    public static net.minecraft.client.renderer.Tessellator asForge(ITessellator tessellator)
    {
        if (tessellator instanceof net.minecraft.client.renderer.Tessellator)
            return (net.minecraft.client.renderer.Tessellator) tessellator;

        return ((Tessellator) tessellator).getForgeTessellator();
    }

    public static ITessellator fromForge(net.minecraft.client.renderer.Tessellator tessellator)
    {
        if (tessellator instanceof ITessellator)
            return (ITessellator) tessellator;

        return new Tessellator(tessellator);
    }
}
