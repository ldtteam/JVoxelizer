package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.font;

import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;

public class IFontRendererExtensions
{

    public static net.minecraft.client.gui.FontRenderer asForge(IFontRenderer fontRenderer)
    {
        return ((FontRenderer) fontRenderer).getForgeFontRenderer();
    }
}
