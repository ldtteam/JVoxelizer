package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.item;

import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.client.renderer.item.IItemRenderer;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.font.FontRenderer;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemStack;
import net.minecraft.client.renderer.RenderItem;

public class ItemRenderer implements IItemRenderer, IForgeJVoxelizerWrapper
{

    private final RenderItem forgeItemRenderer;

    private ItemRenderer(final RenderItem forgeItemRenderer) {this.forgeItemRenderer = forgeItemRenderer;}

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

    private RenderItem getForgeItemRenderer()
    {
        return forgeItemRenderer;
    }

    public static RenderItem asForge(final IItemRenderer renderer)
    {
        if (renderer instanceof RenderItem)
        {
            return (RenderItem) renderer;
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

    public static IItemRenderer fromForge(final RenderItem renderer)
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
