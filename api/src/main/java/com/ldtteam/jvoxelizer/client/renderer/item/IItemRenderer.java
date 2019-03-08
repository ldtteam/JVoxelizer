package com.ldtteam.jvoxelizer.client.renderer.item;

import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.item.IItemStack;

/**
 * Renderer for items and itemstacks.
 */
public interface IItemRenderer
{
    /**
     * Sets the current z-coordinate of the renderer.
     *
     * @param v The new z-level.
     */
    void setZLevel(float v);

    /**
     * Renders a given itemstack at a given position.
     *
     * @param stack The stack.
     * @param x The x-coordinate of the upper left corner
     * @param y The y-coordinate of the upper left corner
     */
    void renderItemAndEffectIntoGUI(IItemStack stack, int x, int y);

    /**
     * Renders a given stack at a given position, with a given tooltip/name
     *
     * @param font The font renderer to render the tooltip with.
     * @param stack The stack
     * @param x The x-coordinate of the upper left corner
     * @param y The y-coordinate of the upper left corner
     * @param s The string to render in the tooltip.
     */
    void renderItemOverlayIntoGUI(IFontRenderer font, IItemStack stack, int x, int y, String s);
}
