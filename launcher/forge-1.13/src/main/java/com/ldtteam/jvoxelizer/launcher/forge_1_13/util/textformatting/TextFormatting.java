package com.ldtteam.jvoxelizer.launcher.forge_1_13.util.textformatting;

import com.ldtteam.jvoxelizer.util.textformatting.ITextFormatting;

public class TextFormatting implements ITextFormatting
{
    private final net.minecraft.util.text.TextFormatting forgeTextFormatting;

    private TextFormatting(final net.minecraft.util.text.TextFormatting forgeTextFormatting) {this.forgeTextFormatting = forgeTextFormatting;}

    @Override
    public String toString()
    {
        return forgeTextFormatting.toString();
    }

    public static net.minecraft.util.text.TextFormatting asForge(final ITextFormatting component)
    {
        return ((TextFormatting) component).forgeTextFormatting;
    }

    public static ITextFormatting fromForge(final net.minecraft.util.text.TextFormatting textComponent)
    {
        return new TextFormatting(textComponent);
    }
}
