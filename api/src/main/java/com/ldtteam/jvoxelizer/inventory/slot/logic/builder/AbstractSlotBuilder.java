package com.ldtteam.jvoxelizer.inventory.slot.logic.builder;

import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISpriteMap;
import com.ldtteam.jvoxelizer.inventory.slot.*;
import com.ldtteam.jvoxelizer.inventory.slot.logic.builder.contexts.*;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.ldtteam.jvoxelizer.core.logic.*;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

public abstract class AbstractSlotBuilder<C extends ISlotBuilder<C, I, O>, I, O extends ISlot<I>> implements ISlotBuilder<C, I, O>
{

    @Override
    public C DecrStackSize(Function<TypedPipelineElementContext<DecrStackSizeContext, IItemStack, O, I>, IItemStack>... components) {
        this.DecrStackSizePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<DecrStackSizeContext, IItemStack, O, I>, IItemStack>> DecrStackSizePipeline = new ArrayList<>();

    @Override
    public C OnSlotChange(Consumer<VoidPipelineElementContext<OnSlotChangeContext, O, I>>... components) {
        this.OnSlotChangePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<OnSlotChangeContext, O, I>>> OnSlotChangePipeline = new ArrayList<>();

    @Override
    public C IsItemValid(Function<TypedPipelineElementContext<IsItemValidContext, Boolean, O, I>, Boolean>... components) {
        this.IsItemValidPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<IsItemValidContext, Boolean, O, I>, Boolean>> IsItemValidPipeline = new ArrayList<>();

    @Override
    public C OnSlotChanged(Consumer<VoidPipelineElementContext<OnSlotChangedContext, O, I>>... components) {
        this.OnSlotChangedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<OnSlotChangedContext, O, I>>> OnSlotChangedPipeline = new ArrayList<>();

    @Override
    public C IsSameInventory(Function<TypedPipelineElementContext<IsSameInventoryContext, Boolean, O, I>, Boolean>... components) {
        this.IsSameInventoryPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<IsSameInventoryContext, Boolean, O, I>, Boolean>> IsSameInventoryPipeline = new ArrayList<>();

    @Override
    public C GetSlotStackLimit(Function<TypedPipelineElementContext<GetSlotStackLimitContext, Integer, O, I>, Integer>... components) {
        this.GetSlotStackLimitPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetSlotStackLimitContext, Integer, O, I>, Integer>> GetSlotStackLimitPipeline = new ArrayList<>();

    @Override
    public C OnCrafting(Consumer<VoidPipelineElementContext<OnCraftingContext, O, I>>... components) {
        this.OnCraftingPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<OnCraftingContext, O, I>>> OnCraftingPipeline = new ArrayList<>();

    @Override
    public C OnCraftingWithAmountAsint(Consumer<VoidPipelineElementContext<OnCraftingWithAmountAsintContext, O, I>>... components) {
        this.OnCraftingWithAmountAsintPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<OnCraftingWithAmountAsintContext, O, I>>> OnCraftingWithAmountAsintPipeline = new ArrayList<>();

    @Override
    public C PutStack(Consumer<VoidPipelineElementContext<PutStackContext, O, I>>... components) {
        this.PutStackPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<PutStackContext, O, I>>> PutStackPipeline = new ArrayList<>();

    @Override
    public C GetHasStack(Function<TypedPipelineElementContext<GetHasStackContext, Boolean, O, I>, Boolean>... components) {
        this.GetHasStackPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetHasStackContext, Boolean, O, I>, Boolean>> GetHasStackPipeline = new ArrayList<>();

    @Override
    public C GetBackgroundSprite(Function<TypedPipelineElementContext<GetBackgroundSpriteContext, ISprite, O, I>, ISprite>... components) {
        this.GetBackgroundSpritePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetBackgroundSpriteContext, ISprite, O, I>, ISprite>> GetBackgroundSpritePipeline = new ArrayList<>();

    @Override
    public C GetItemStackLimit(Function<TypedPipelineElementContext<GetItemStackLimitContext, Integer, O, I>, Integer>... components) {
        this.GetIItemStackLimitPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetItemStackLimitContext, Integer, O, I>, Integer>> GetIItemStackLimitPipeline = new ArrayList<>();

    @Override
    public C SetBackgroundLocation(Consumer<VoidPipelineElementContext<SetBackgroundLocationContext, O, I>>... components) {
        this.SetBackgroundLocationPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<SetBackgroundLocationContext, O, I>>> SetBackgroundLocationPipeline = new ArrayList<>();

    @Override
    public C GetSlotIndex(Function<TypedPipelineElementContext<GetSlotIndexContext, Integer, O, I>, Integer>... components) {
        this.GetSlotIndexPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetSlotIndexContext, Integer, O, I>, Integer>> GetSlotIndexPipeline = new ArrayList<>();

    @Override
    public C IsEnabled(Function<TypedPipelineElementContext<IsEnabledContext, Boolean, O, I>, Boolean>... components) {
        this.IsEnabledPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<IsEnabledContext, Boolean, O, I>, Boolean>> IsEnabledPipeline = new ArrayList<>();

    @Override
    public C GetBackgroundMap(Function<TypedPipelineElementContext<GetBackgroundMapContext, ISpriteMap, O, I>, ISpriteMap>... components) {
        this.GetBackgroundMapPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetBackgroundMapContext, ISpriteMap, O, I>, ISpriteMap>> GetBackgroundMapPipeline = new ArrayList<>();

    @Override
    public C IsHere(Function<TypedPipelineElementContext<IsHereContext, Boolean, O, I>, Boolean>... components) {
        this.IsHerePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<IsHereContext, Boolean, O, I>, Boolean>> IsHerePipeline = new ArrayList<>();

    @Override
    public C OnTake(Function<TypedPipelineElementContext<OnTakeContext, IItemStack, O, I>, IItemStack>... components) {
        this.OnTakePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<OnTakeContext, IItemStack, O, I>, IItemStack>> OnTakePipeline = new ArrayList<>();

    @Override
    public C CanTakeStack(Function<TypedPipelineElementContext<CanTakeStackContext, Boolean, O, I>, Boolean>... components) {
        this.CanTakeStackPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<CanTakeStackContext, Boolean, O, I>, Boolean>> CanTakeStackPipeline = new ArrayList<>();

    @Override
    public C GetStack(Function<TypedPipelineElementContext<GetStackContext, IItemStack, O, I>, IItemStack>... components) {
        this.GetStackPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetStackContext, IItemStack, O, I>, IItemStack>> GetStackPipeline = new ArrayList<>();

    @Override
    public C OnSwapCraft(Consumer<VoidPipelineElementContext<OnSwapCraftContext, O, I>>... components) {
        this.OnSwapCraftPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<OnSwapCraftContext, O, I>>> OnSwapCraftPipeline = new ArrayList<>();

    @Override
    public C SetBackgroundName(Consumer<VoidPipelineElementContext<SetBackgroundNameContext, O, I>>... components) {
        this.SetBackgroundNamePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<SetBackgroundNameContext, O, I>>> SetBackgroundNamePipeline = new ArrayList<>();

    @Override
    public C GetBackgroundLocation(Function<TypedPipelineElementContext<GetBackgroundLocationContext, IIdentifier, O, I>, IIdentifier>... components) {
        this.GetBackgroundLocationPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetBackgroundLocationContext, IIdentifier, O, I>, IIdentifier>> GetBackgroundLocationPipeline = new ArrayList<>();

    @Override
    public C GetSlotTexture(Function<TypedPipelineElementContext<GetSlotTextureContext, String, O, I>, String>... components) {
        this.GetSlotTexturePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetSlotTextureContext, String, O, I>, String>> GetSlotTexturePipeline = new ArrayList<>();
}
