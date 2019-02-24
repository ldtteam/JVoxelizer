package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.textformatting;

import com.ldtteam.jvoxelizer.util.textformatting.ITextFormatting;

public class TextFormatting implements ITextFormatting
{

    private final net.minecraft.util.text.TextFormatting forgeTextFormatting;

    public TextFormatting(final net.minecraft.util.text.TextFormatting forgeTextFormatting) {this.forgeTextFormatting = forgeTextFormatting;}

    public net.minecraft.util.text.TextFormatting getForgeTextFormatting()
    {
        return forgeTextFormatting;
    }

    @Override
    public String toString()
    {
        return forgeTextFormatting.toString();
    }
}
