package com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.logic.builder;

import com.ldtteam.jvoxelizer.inventory.IContainer;
import com.ldtteam.jvoxelizer.inventory.logic.builder.AbstractContainerBuilder;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.JVoxContainer;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.logic.pipeline.ForgeContainerPipeline;

public class ContainerBuilder<I> extends AbstractContainerBuilder<ContainerBuilder<I>, I, IContainer<I>>
{
    @Override
    public IContainer<I> build(final I context)
    {
        return new JVoxContainer<>(
          context,
          new ForgeContainerPipeline<>(
            this.SlotChangedCraftingGridPipeline,
            this.ClearContainerPipeline,
            this.PutStackInSlotPipeline,
            this.SetCanCraftPipeline,
            this.SlotClickPipeline,
            this.OnContainerClosedPipeline,
            this.GetInventoryPipeline,
            this.SetAllPipeline,
            this.AddListenerPipeline,
            this.UpdateProgressBarPipeline,
            this.DetectAndSendChangesPipeline,
            this.GetCanCraftPipeline,
            this.TransferStackInSlotPipeline,
            this.OnCraftMatrixChangedPipeline,
            this.RemoveListenerPipeline,
            this.CanInteractWithPipeline,
            this.CanDragIntoSlotPipeline,
            this.GetSlotPipeline,
            this.GetSlotFromInventoryPipeline,
            this.AddSlotToContainerPipeline,
            this.CanMergeSlotPipeline,
            this.ResetDragPipeline,
            this.EnchantItemPipeline,
            this.GetNextTransactionIDPipeline,
            this.MergeItemStackPipeline
          )
        );
    }
}
