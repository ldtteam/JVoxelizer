package com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui;

import com.ldtteam.jvoxelizer.client.gui.IGuiContainer;
import com.ldtteam.jvoxelizer.core.exceptions.FeatureNotImplementedException;
import com.ldtteam.jvoxelizer.core.logic.DummyInstanceData;
import com.ldtteam.jvoxelizer.inventory.IContainer;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.Container;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack;

import java.util.List;
import java.util.stream.Collectors;

public class GuiContainer extends GuiScreen implements IGuiContainer<DummyInstanceData>
{

    private final net.minecraft.client.gui.inventory.GuiContainer forgeGuiContainer;

    public GuiContainer(final net.minecraft.client.gui.inventory.GuiContainer forgeGuiContainer)
    {
        super(forgeGuiContainer);
        this.forgeGuiContainer = forgeGuiContainer;
    }

    @Override
    public ISlot getSlotUnderCursor()
    {
        return Slot.fromForge(forgeGuiContainer.getSlotUnderMouse());
    }

    @Override
    public int getGuiLeft()
    {
        return forgeGuiContainer.getGuiLeft();
    }

    @Override
    public int getGuiTop()
    {
        return forgeGuiContainer.getGuiTop();
    }

    @Override
    public int getWidth()
    {
        return forgeGuiContainer.width;
    }

    @Override
    public int getHeight()
    {
        return forgeGuiContainer.height;
    }

    @Override
    public int getXSize()
    {
        return forgeGuiContainer.getXSize();
    }

    @Override
    public void setXSize(int xSize)
    {
        throw new FeatureNotImplementedException("Can not set x size on wrapped container");
    }

    @Override
    public int getYSize()
    {
        return forgeGuiContainer.getYSize();
    }

    @Override
    public void setYSize(int ySize)
    {
        throw new FeatureNotImplementedException("Can not set x size on wrapped container");
    }

    @Override
    public IContainer<?> getContainer()
    {
        return Container.fromForge(forgeGuiContainer.inventorySlots);
    }

    @Override
    public void setHoveredSlot(final ISlot slot)
    {
        forgeGuiContainer.hoveredSlot = Slot.asForge(slot);
    }

    @Override
    public ISlot<?> getClickedSlot()
    {
        return Slot.fromForge(forgeGuiContainer.clickedSlot);
    }

    @Override
    public IItemStack getDraggedStack()
    {
        return ItemStack.fromForge(forgeGuiContainer.draggedStack);
    }

    @Override
    public boolean isRightMouseClicked()
    {
        return forgeGuiContainer.isRightMouseClick;
    }

    @Override
    public boolean isDragSplitting()
    {
        return forgeGuiContainer.dragSplitting;
    }

    @Override
    public List<ISlot<?>> getSlotsUsedInDragSplitting()
    {
        return forgeGuiContainer.dragSplittingSlots.stream().map(Slot::fromForge).collect(Collectors.toList());
    }

    @Override
    public int getDragSplittingLimit()
    {
        return forgeGuiContainer.dragSplittingLimit;
    }

    @Override
    public void updateDragSplitting()
    {
        forgeGuiContainer.updateDragSplitting();
    }

    private net.minecraft.client.gui.inventory.GuiContainer getForgeGuiContainer()
    {
        return forgeGuiContainer;
    }

    public static net.minecraft.client.gui.inventory.GuiContainer asForge(IGuiContainer<?> guiContainer)
    {
        if (guiContainer instanceof net.minecraft.client.gui.inventory.GuiContainer)
        {
            return (net.minecraft.client.gui.inventory.GuiContainer) guiContainer;
        }

        if (guiContainer == null)
        {
            return null;
        }

        if (!(guiContainer instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("GuiContainer is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) guiContainer).getForgeInstance();
    }

    public static IGuiContainer<?> fromForge(net.minecraft.client.gui.inventory.GuiContainer guiContainer)
    {
        if (guiContainer instanceof IGuiContainer)
        {
            return (IGuiContainer<?>) guiContainer;
        }

        return new GuiContainer(guiContainer);
    }
}
