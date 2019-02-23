package com.ldtteam.jvoxelizer.inventory.logic.builder;

import com.ldtteam.jvoxelizer.inventory.*;
import com.ldtteam.jvoxelizer.inventory.logic.builder.contexts.*;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.ldtteam.jvoxelizer.core.logic.*;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.item.IItemStack;

public abstract class AbstractContainerBuilder<C extends IContainerBuilder<C, I, O>, I, O extends IContainer<I>> implements IContainerBuilder<C, I, O>
{

    @Override
    public C SlotChangedCraftingGrid(Consumer<VoidPipelineElementContext<SlotChangedCraftingGridContext, O, I>>... components) {
        this.SlotChangedCraftingGridPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<SlotChangedCraftingGridContext, O, I>>> SlotChangedCraftingGridPipeline = new ArrayList<>();

    @Override
    public C ClearContainer(Consumer<VoidPipelineElementContext<ClearContainerContext, O, I>>... components) {
        this.ClearContainerPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<ClearContainerContext, O, I>>> ClearContainerPipeline = new ArrayList<>();

    @Override
    public C PutStackInSlot(Consumer<VoidPipelineElementContext<PutStackInSlotContext, O, I>>... components) {
        this.PutStackInSlotPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<PutStackInSlotContext, O, I>>> PutStackInSlotPipeline = new ArrayList<>();

    @Override
    public C SetCanCraft(Consumer<VoidPipelineElementContext<SetCanCraftContext, O, I>>... components) {
        this.SetCanCraftPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<SetCanCraftContext, O, I>>> SetCanCraftPipeline = new ArrayList<>();

    @Override
    public C SlotClick(Function<TypedPipelineElementContext<SlotClickContext, IItemStack, O, I>, IItemStack>... components) {
        this.SlotClickPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<SlotClickContext, IItemStack, O, I>, IItemStack>> SlotClickPipeline = new ArrayList<>();

    @Override
    public C OnContainerClosed(Consumer<VoidPipelineElementContext<OnContainerClosedContext, O, I>>... components) {
        this.OnContainerClosedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<OnContainerClosedContext, O, I>>> OnContainerClosedPipeline = new ArrayList<>();

    @Override
    public C GetInventory(Function<TypedPipelineElementContext<GetInventoryContext, List<IItemStack>, O, I>, List<IItemStack>>... components) {
        this.GetInventoryPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetInventoryContext, List<IItemStack>, O, I>, List<IItemStack>>> GetInventoryPipeline = new ArrayList<>();

    @Override
    public C SetAll(Consumer<VoidPipelineElementContext<SetAllContext, O, I>>... components) {
        this.SetAllPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<SetAllContext, O, I>>> SetAllPipeline = new ArrayList<>();

    @Override
    public C AddListener(Consumer<VoidPipelineElementContext<AddListenerContext, O, I>>... components) {
        this.AddListenerPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<AddListenerContext, O, I>>> AddListenerPipeline = new ArrayList<>();

    @Override
    public C UpdateProgressBar(Consumer<VoidPipelineElementContext<UpdateProgressBarContext, O, I>>... components) {
        this.UpdateProgressBarPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<UpdateProgressBarContext, O, I>>> UpdateProgressBarPipeline = new ArrayList<>();

    @Override
    public C DetectAndSendChanges(Consumer<VoidPipelineElementContext<DetectAndSendChangesContext, O, I>>... components) {
        this.DetectAndSendChangesPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<DetectAndSendChangesContext, O, I>>> DetectAndSendChangesPipeline = new ArrayList<>();

    @Override
    public C GetCanCraft(Function<TypedPipelineElementContext<GetCanCraftContext, Boolean, O, I>, Boolean>... components) {
        this.GetCanCraftPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetCanCraftContext, Boolean, O, I>, Boolean>> GetCanCraftPipeline = new ArrayList<>();

    @Override
    public C TransferStackInSlot(Function<TypedPipelineElementContext<TransferStackInSlotContext, IItemStack, O, I>, IItemStack>... components) {
        this.TransferStackInSlotPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<TransferStackInSlotContext, IItemStack, O, I>, IItemStack>> TransferStackInSlotPipeline = new ArrayList<>();

    @Override
    public C OnCraftMatrixChanged(Consumer<VoidPipelineElementContext<OnCraftMatrixChangedContext, O, I>>... components) {
        this.OnCraftMatrixChangedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<OnCraftMatrixChangedContext, O, I>>> OnCraftMatrixChangedPipeline = new ArrayList<>();

    @Override
    public C RemoveListener(Consumer<VoidPipelineElementContext<RemoveListenerContext, O, I>>... components) {
        this.RemoveListenerPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<RemoveListenerContext, O, I>>> RemoveListenerPipeline = new ArrayList<>();

    @Override
    public C CanInteractWith(Function<TypedPipelineElementContext<CanInteractWithContext, Boolean, O, I>, Boolean>... components) {
        this.CanInteractWithPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<CanInteractWithContext, Boolean, O, I>, Boolean>> CanInteractWithPipeline = new ArrayList<>();

    @Override
    public C CanDragIntoSlot(Function<TypedPipelineElementContext<CanDragIntoSlotContext, Boolean, O, I>, Boolean>... components) {
        this.CanDragIntoSlotPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<CanDragIntoSlotContext, Boolean, O, I>, Boolean>> CanDragIntoSlotPipeline = new ArrayList<>();

    @Override
    public C GetSlot(Function<TypedPipelineElementContext<GetSlotContext, ISlot, O, I>, ISlot>... components) {
        this.GetSlotPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetSlotContext, ISlot, O, I>, ISlot>> GetSlotPipeline = new ArrayList<>();

    @Override
    public C GetSlotFromInventory(Function<TypedPipelineElementContext<GetSlotFromInventoryContext, ISlot, O, I>, ISlot>... components) {
        this.GetSlotFromInventoryPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetSlotFromInventoryContext, ISlot, O, I>, ISlot>> GetSlotFromInventoryPipeline = new ArrayList<>();

    @Override
    public C AddSlotToContainer(Function<TypedPipelineElementContext<AddSlotToContainerContext, ISlot, O, I>, ISlot>... components) {
        this.AddSlotToContainerPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<AddSlotToContainerContext, ISlot, O, I>, ISlot>> AddSlotToContainerPipeline = new ArrayList<>();

    @Override
    public C CanMergeSlot(Function<TypedPipelineElementContext<CanMergeSlotContext, Boolean, O, I>, Boolean>... components) {
        this.CanMergeSlotPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<CanMergeSlotContext, Boolean, O, I>, Boolean>> CanMergeSlotPipeline = new ArrayList<>();

    @Override
    public C ResetDrag(Consumer<VoidPipelineElementContext<ResetDragContext, O, I>>... components) {
        this.ResetDragPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<ResetDragContext, O, I>>> ResetDragPipeline = new ArrayList<>();

    @Override
    public C EnchantItem(Function<TypedPipelineElementContext<EnchantItemContext, Boolean, O, I>, Boolean>... components) {
        this.EnchantItemPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<EnchantItemContext, Boolean, O, I>, Boolean>> EnchantItemPipeline = new ArrayList<>();

    @Override
    public C GetNextTransactionID(Function<TypedPipelineElementContext<GetNextTransactionIDContext, Short, O, I>, Short>... components) {
        this.GetNextTransactionIDPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetNextTransactionIDContext, Short, O, I>, Short>> GetNextTransactionIDPipeline = new ArrayList<>();

    @Override
    public C MergeItemStack(Function<TypedPipelineElementContext<MergeItemStackContext, Boolean, O, I>, Boolean>... components) {
        this.MergeItemStackPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<MergeItemStackContext, Boolean, O, I>, Boolean>> MergeItemStackPipeline = new ArrayList<>();
}
