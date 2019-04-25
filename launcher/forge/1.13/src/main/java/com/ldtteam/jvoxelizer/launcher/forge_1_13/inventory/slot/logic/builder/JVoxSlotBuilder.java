package com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.logic.builder;

import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.inventory.slot.logic.builder.AbstractSlotBuilder;
import com.ldtteam.jvoxelizer.item.handling.IInventory;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.Inventory;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.JVoxSlot;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.logic.pipeline.ForgeSlotPipeline;

public class JVoxSlotBuilder<I> extends AbstractSlotBuilder<JVoxSlotBuilder<I>, I, ISlot<I>>
{
    private final IInventory inventory;
    private final int        index;
    private final int        x;
    private final int        y;

    public JVoxSlotBuilder(final IInventory inventory, final int index, final int x, final int y)
    {
        this.inventory = inventory;
        this.index = index;
        this.x = x;
        this.y = y;
    }

    @Override
    public ISlot<I> build(final I guiContext)
    {
        return new JVoxSlot<>(
          Inventory.asForge(inventory),
          index,
          x,
          y,
          guiContext,
          new ForgeSlotPipeline<>(
            this.DecrStackSizePipeline,
            this.OnSlotChangePipeline,
            this.IsItemValidPipeline,
            this.OnSlotChangedPipeline,
            this.IsSameInventoryPipeline,
            this.GetSlotStackLimitPipeline,
            this.OnCraftingPipeline,
            this.OnCraftingWithAmountAsintPipeline,
            this.PutStackPipeline,
            this.GetHasStackPipeline,
            this.GetBackgroundSpritePipeline,
            this.GetIItemStackLimitPipeline,
            this.SetBackgroundLocationPipeline,
            this.GetSlotIndexPipeline,
            this.IsEnabledPipeline,
            this.GetBackgroundMapPipeline,
            this.IsHerePipeline,
            this.OnTakePipeline,
            this.CanTakeStackPipeline,
            this.GetStackPipeline,
            this.OnSwapCraftPipeline,
            this.SetBackgroundNamePipeline,
            this.GetBackgroundLocationPipeline,
            this.GetSlotTexturePipeline
          ));
    }
}
