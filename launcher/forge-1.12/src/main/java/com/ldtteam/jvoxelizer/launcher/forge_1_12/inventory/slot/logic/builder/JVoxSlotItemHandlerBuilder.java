package com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.slot.logic.builder;

import com.ldtteam.jvoxelizer.inventory.slot.ISlotItemHandler;
import com.ldtteam.jvoxelizer.inventory.slot.logic.builder.AbstractSlotItemHandlerBuilder;
import com.ldtteam.jvoxelizer.item.handling.IItemHandler;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.slot.JVoxSlotItemHandler;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.slot.logic.pipeline.ForgeSlotItemHandlerPipeline;

public class JVoxSlotItemHandlerBuilder<I> extends AbstractSlotItemHandlerBuilder<JVoxSlotItemHandlerBuilder<I>, I, ISlotItemHandler<I>>
{
    private final IItemHandler inventory;
    private final int          index;
    private final int          x;
    private final int          y;

    public JVoxSlotItemHandlerBuilder(final IItemHandler inventory, final int index, final int x, final int y)
    {
        this.inventory = inventory;
        this.index = index;
        this.x = x;
        this.y = y;
    }

    @Override
    public ISlotItemHandler<I> build(final I guiContext)
    {
        return new JVoxSlotItemHandler<>(
          inventory,
          index,
          x,
          y,
          guiContext,
          new ForgeSlotItemHandlerPipeline<>(
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
            this.GetSlotTexturePipeline,
            this.GetItemHandlerPipeline
          ));
    }
}
