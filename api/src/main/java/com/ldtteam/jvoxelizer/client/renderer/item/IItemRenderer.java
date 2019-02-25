package com.ldtteam.jvoxelizer.client.renderer.item;

import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.item.IItemStack;

public interface IItemRenderer
{
    void setZLevel(float v);

    void renderItemAndEffectIntoGUI(IItemStack stack, int x, int y);

    void renderItemOverlayIntoGUI(IFontRenderer font, IItemStack stack, int x, int y, String s);
}
