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

public abstract class AbstractSlotBuilder<C extends AbstractSlotBuilder<C, I>, I> {

    public C DecrStackSize(Function<TypedPipelineElementContext<DecrStackSizeContext, IItemStack>, IItemStack>... components) {
        this.DecrStackSizePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<DecrStackSizeContext, IItemStack>, IItemStack>> DecrStackSizePipeline = new ArrayList<>();

    public C OnSlotChange(Consumer<VoidPipelineElementContext<OnSlotChangeContext>>... components) {
        this.OnSlotChangePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<OnSlotChangeContext>>> OnSlotChangePipeline = new ArrayList<>();

    public C IsItemValid(Function<TypedPipelineElementContext<IsItemValidContext, Boolean>, Boolean>... components) {
        this.IsItemValidPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<IsItemValidContext, Boolean>, Boolean>> IsItemValidPipeline = new ArrayList<>();

    public C OnSlotChanged(Consumer<VoidPipelineElementContext<OnSlotChangedContext>>... components) {
        this.OnSlotChangedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<OnSlotChangedContext>>> OnSlotChangedPipeline = new ArrayList<>();

    public C IsSameInventory(Function<TypedPipelineElementContext<IsSameInventoryContext, Boolean>, Boolean>... components) {
        this.IsSameInventoryPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<IsSameInventoryContext, Boolean>, Boolean>> IsSameInventoryPipeline = new ArrayList<>();

    public C GetSlotStackLimit(Function<TypedPipelineElementContext<GetSlotStackLimitContext, Integer>, Integer>... components) {
        this.GetSlotStackLimitPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetSlotStackLimitContext, Integer>, Integer>> GetSlotStackLimitPipeline = new ArrayList<>();

    public C OnCrafting(Consumer<VoidPipelineElementContext<OnCraftingContext>>... components) {
        this.OnCraftingPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<OnCraftingContext>>> OnCraftingPipeline = new ArrayList<>();

    public C OnCraftingWithAmountAsint(Consumer<VoidPipelineElementContext<OnCraftingWithAmountAsintContext>>... components) {
        this.OnCraftingWithAmountAsintPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<OnCraftingWithAmountAsintContext>>> OnCraftingWithAmountAsintPipeline = new ArrayList<>();

    public C PutStack(Consumer<VoidPipelineElementContext<PutStackContext>>... components) {
        this.PutStackPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<PutStackContext>>> PutStackPipeline = new ArrayList<>();

    public C GetHasStack(Function<TypedPipelineElementContext<GetHasStackContext, Boolean>, Boolean>... components) {
        this.GetHasStackPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetHasStackContext, Boolean>, Boolean>> GetHasStackPipeline = new ArrayList<>();

    public C GetBackgroundSprite(Function<TypedPipelineElementContext<GetBackgroundSpriteContext, ISprite>, ISprite>... components) {
        this.GetBackgroundSpritePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetBackgroundSpriteContext, ISprite>, ISprite>> GetBackgroundSpritePipeline = new ArrayList<>();

    public C GetIItemStackLimit(Function<TypedPipelineElementContext<GetItemStackLimitContext, Integer>, Integer>... components) {
        this.GetIItemStackLimitPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetItemStackLimitContext, Integer>, Integer>> GetIItemStackLimitPipeline = new ArrayList<>();

    public C SetBackgroundLocation(Consumer<VoidPipelineElementContext<SetBackgroundLocationContext>>... components) {
        this.SetBackgroundLocationPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<SetBackgroundLocationContext>>> SetBackgroundLocationPipeline = new ArrayList<>();

    public C GetSlotIndex(Function<TypedPipelineElementContext<GetSlotIndexContext, Integer>, Integer>... components) {
        this.GetSlotIndexPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetSlotIndexContext, Integer>, Integer>> GetSlotIndexPipeline = new ArrayList<>();

    public C IsEnabled(Function<TypedPipelineElementContext<IsEnabledContext, Boolean>, Boolean>... components) {
        this.IsEnabledPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<IsEnabledContext, Boolean>, Boolean>> IsEnabledPipeline = new ArrayList<>();

    public C GetBackgroundMap(Function<TypedPipelineElementContext<GetBackgroundMapContext, ISpriteMap>, ISpriteMap>... components) {
        this.GetBackgroundMapPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetBackgroundMapContext, ISpriteMap>, ISpriteMap>> GetBackgroundMapPipeline = new ArrayList<>();

    public C IsHere(Function<TypedPipelineElementContext<IsHereContext, Boolean>, Boolean>... components) {
        this.IsHerePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<IsHereContext, Boolean>, Boolean>> IsHerePipeline = new ArrayList<>();

    public C OnTake(Function<TypedPipelineElementContext<OnTakeContext, IItemStack>, IItemStack>... components) {
        this.OnTakePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<OnTakeContext, IItemStack>, IItemStack>> OnTakePipeline = new ArrayList<>();

    public C CanTakeStack(Function<TypedPipelineElementContext<CanTakeStackContext, Boolean>, Boolean>... components) {
        this.CanTakeStackPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<CanTakeStackContext, Boolean>, Boolean>> CanTakeStackPipeline = new ArrayList<>();

    public C GetStack(Function<TypedPipelineElementContext<GetStackContext, IItemStack>, IItemStack>... components) {
        this.GetStackPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetStackContext, IItemStack>, IItemStack>> GetStackPipeline = new ArrayList<>();

    public C OnSwapCraft(Consumer<VoidPipelineElementContext<OnSwapCraftContext>>... components) {
        this.OnSwapCraftPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<OnSwapCraftContext>>> OnSwapCraftPipeline = new ArrayList<>();

    public C SetBackgroundName(Consumer<VoidPipelineElementContext<SetBackgroundNameContext>>... components) {
        this.SetBackgroundNamePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Consumer<VoidPipelineElementContext<SetBackgroundNameContext>>> SetBackgroundNamePipeline = new ArrayList<>();

    public C GetBackgroundLocation(Function<TypedPipelineElementContext<GetBackgroundLocationContext, IIdentifier>, IIdentifier>... components) {
        this.GetBackgroundLocationPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetBackgroundLocationContext, IIdentifier>, IIdentifier>> GetBackgroundLocationPipeline = new ArrayList<>();

    public C GetSlotTexture(Function<TypedPipelineElementContext<GetSlotTextureContext, String>, String>... components) {
        this.GetSlotTexturePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetSlotTextureContext, String>, String>> GetSlotTexturePipeline = new ArrayList<>();

    public abstract ISlot<I> build(I guiContext);
}
