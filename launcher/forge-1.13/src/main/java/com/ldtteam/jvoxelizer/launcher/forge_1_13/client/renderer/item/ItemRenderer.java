package com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.item;

import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.client.renderer.item.IItemRenderer;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.font.FontRenderer;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack;

public class ItemRenderer implements IItemRenderer, IForgeJVoxelizerWrapper
{

    private final net.minecraft.client.renderer.ItemRenderer forgeItemRenderer;

    private ItemRenderer(final net.minecraft.client.renderer.ItemRenderer forgeItemRenderer) {this.forgeItemRenderer = forgeItemRenderer;}

    @Override
    public void setZLevel(final float v)
    {
        forgeItemRenderer.zLevel = v;
    }

    @Override
    public void renderItemAndEffectIntoGUI(final IItemStack stack, final int x, final int y)
    {
        forgeItemRenderer.renderItemAndEffectIntoGUI(ItemStack.asForge(stack), x, y);
    }

    @Override
    public void renderItemOverlayIntoGUI(final IFontRenderer font, final IItemStack stack, final int x, final int y, final String s)
    {
        forgeItemRenderer.renderItemOverlayIntoGUI(FontRenderer.asForge(font), ItemStack.asForge(stack), x, y, s);
    }

    private net.minecraft.client.renderer.ItemRenderer getForgeItemRenderer()
    {
        return forgeItemRenderer;
    }

    public static net.minecraft.client.renderer.ItemRenderer asForge(final IItemRenderer renderer)
    {
        if (renderer instanceof net.minecraft.client.renderer.ItemRenderer)
        {
            return (net.minecraft.client.renderer.ItemRenderer) renderer;
        }

        if (renderer == null)
        {
            return null;
        }

        if (!(renderer instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("ItemRenderer is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) renderer).getForgeInstance();
    }

    public static IItemRenderer fromForge(final net.minecraft.client.renderer.ItemRenderer renderer)
    {
        if (renderer instanceof IItemRenderer)
        {
            return (IItemRenderer) renderer;
        }

        return new ItemRenderer(renderer);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeItemRenderer();
    }
}
