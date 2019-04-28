package com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.slot.logic.pipeline;

import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISpriteMap;
import com.ldtteam.jvoxelizer.core.logic.TypedPipelineElementContext;
import com.ldtteam.jvoxelizer.core.logic.VoidPipelineElementContext;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.inventory.slot.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ForgeSlotPipeline<O extends ISlot<I>, I>
{
    private final List<Function<TypedPipelineElementContext<DecrStackSizeContext, IItemStack, O, I>, IItemStack>> DecrStackSizePipeline;

    private final List<Consumer<VoidPipelineElementContext<OnSlotChangeContext, O, I>>> OnSlotChangePipeline;

    private final List<Function<TypedPipelineElementContext<IsItemValidContext, Boolean, O, I>, Boolean>> IsItemValidPipeline;

    private final List<Consumer<VoidPipelineElementContext<OnSlotChangedContext, O, I>>> OnSlotChangedPipeline;

    private final List<Function<TypedPipelineElementContext<IsSameInventoryContext, Boolean, O, I>, Boolean>> IsSameInventoryPipeline;

    private final List<Function<TypedPipelineElementContext<GetSlotStackLimitContext, Integer, O, I>, Integer>> GetSlotStackLimitPipeline;

    private final List<Consumer<VoidPipelineElementContext<OnCraftingContext, O, I>>> OnCraftingPipeline;

    private final List<Consumer<VoidPipelineElementContext<OnCraftingWithAmountAsintContext, O, I>>> OnCraftingWithAmountAsintPipeline;

    private final List<Consumer<VoidPipelineElementContext<PutStackContext, O, I>>> PutStackPipeline;

    private final List<Function<TypedPipelineElementContext<GetHasStackContext, Boolean, O, I>, Boolean>> GetHasStackPipeline;

    private final List<Function<TypedPipelineElementContext<GetBackgroundSpriteContext, ISprite, O, I>, ISprite>> GetBackgroundSpritePipeline;

    private final List<Function<TypedPipelineElementContext<GetItemStackLimitContext, Integer, O, I>, Integer>> GetIItemStackLimitPipeline;

    private final List<Consumer<VoidPipelineElementContext<SetBackgroundLocationContext, O, I>>> SetBackgroundLocationPipeline;

    private final List<Function<TypedPipelineElementContext<GetSlotIndexContext, Integer, O, I>, Integer>> GetSlotIndexPipeline;

    private final List<Function<TypedPipelineElementContext<IsEnabledContext, Boolean, O, I>, Boolean>> IsEnabledPipeline;

    private final List<Function<TypedPipelineElementContext<GetBackgroundMapContext, ISpriteMap, O, I>, ISpriteMap>> GetBackgroundMapPipeline;

    private final List<Function<TypedPipelineElementContext<IsHereContext, Boolean, O, I>, Boolean>> IsHerePipeline;

    private final List<Function<TypedPipelineElementContext<OnTakeContext, IItemStack, O, I>, IItemStack>> OnTakePipeline;

    private final List<Function<TypedPipelineElementContext<CanTakeStackContext, Boolean, O, I>, Boolean>> CanTakeStackPipeline;

    private final List<Function<TypedPipelineElementContext<GetStackContext, IItemStack, O, I>, IItemStack>> GetStackPipeline;

    private final List<Consumer<VoidPipelineElementContext<OnSwapCraftContext, O, I>>> OnSwapCraftPipeline;

    private final List<Consumer<VoidPipelineElementContext<SetBackgroundNameContext, O, I>>> SetBackgroundNamePipeline;

    private final List<Function<TypedPipelineElementContext<GetBackgroundLocationContext, IIdentifier, O, I>, IIdentifier>> GetBackgroundLocationPipeline;

    private final List<Function<TypedPipelineElementContext<GetSlotTextureContext, String, O, I>, String>> GetSlotTexturePipeline;

    public ForgeSlotPipeline(
      final List<Function<TypedPipelineElementContext<DecrStackSizeContext, IItemStack, O, I>, IItemStack>> decrStackSizePipeline,
      final List<Consumer<VoidPipelineElementContext<OnSlotChangeContext, O, I>>> onSlotChangePipeline,
      final List<Function<TypedPipelineElementContext<IsItemValidContext, Boolean, O, I>, Boolean>> isItemValidPipeline,
      final List<Consumer<VoidPipelineElementContext<OnSlotChangedContext, O, I>>> onSlotChangedPipeline,
      final List<Function<TypedPipelineElementContext<IsSameInventoryContext, Boolean, O, I>, Boolean>> isSameInventoryPipeline,
      final List<Function<TypedPipelineElementContext<GetSlotStackLimitContext, Integer, O, I>, Integer>> getSlotStackLimitPipeline,
      final List<Consumer<VoidPipelineElementContext<OnCraftingContext, O, I>>> onCraftingPipeline,
      final List<Consumer<VoidPipelineElementContext<OnCraftingWithAmountAsintContext, O, I>>> onCraftingWithAmountAsintPipeline,
      final List<Consumer<VoidPipelineElementContext<PutStackContext, O, I>>> putStackPipeline,
      final List<Function<TypedPipelineElementContext<GetHasStackContext, Boolean, O, I>, Boolean>> getHasStackPipeline,
      final List<Function<TypedPipelineElementContext<GetBackgroundSpriteContext, ISprite, O, I>, ISprite>> getBackgroundSpritePipeline,
      final List<Function<TypedPipelineElementContext<GetItemStackLimitContext, Integer, O, I>, Integer>> getIItemStackLimitPipeline,
      final List<Consumer<VoidPipelineElementContext<SetBackgroundLocationContext, O, I>>> setBackgroundLocationPipeline,
      final List<Function<TypedPipelineElementContext<GetSlotIndexContext, Integer, O, I>, Integer>> getSlotIndexPipeline,
      final List<Function<TypedPipelineElementContext<IsEnabledContext, Boolean, O, I>, Boolean>> isEnabledPipeline,
      final List<Function<TypedPipelineElementContext<GetBackgroundMapContext, ISpriteMap, O, I>, ISpriteMap>> getBackgroundMapPipeline,
      final List<Function<TypedPipelineElementContext<IsHereContext, Boolean, O, I>, Boolean>> isHerePipeline,
      final List<Function<TypedPipelineElementContext<OnTakeContext, IItemStack, O, I>, IItemStack>> onTakePipeline,
      final List<Function<TypedPipelineElementContext<CanTakeStackContext, Boolean, O, I>, Boolean>> canTakeStackPipeline,
      final List<Function<TypedPipelineElementContext<GetStackContext, IItemStack, O, I>, IItemStack>> getStackPipeline,
      final List<Consumer<VoidPipelineElementContext<OnSwapCraftContext, O, I>>> onSwapCraftPipeline,
      final List<Consumer<VoidPipelineElementContext<SetBackgroundNameContext, O, I>>> setBackgroundNamePipeline,
      final List<Function<TypedPipelineElementContext<GetBackgroundLocationContext, IIdentifier, O, I>, IIdentifier>> getBackgroundLocationPipeline,
      final List<Function<TypedPipelineElementContext<GetSlotTextureContext, String, O, I>, String>> getSlotTexturePipeline)
    {
        DecrStackSizePipeline = decrStackSizePipeline;
        OnSlotChangePipeline = onSlotChangePipeline;
        IsItemValidPipeline = isItemValidPipeline;
        OnSlotChangedPipeline = onSlotChangedPipeline;
        IsSameInventoryPipeline = isSameInventoryPipeline;
        GetSlotStackLimitPipeline = getSlotStackLimitPipeline;
        OnCraftingPipeline = onCraftingPipeline;
        OnCraftingWithAmountAsintPipeline = onCraftingWithAmountAsintPipeline;
        PutStackPipeline = putStackPipeline;
        GetHasStackPipeline = getHasStackPipeline;
        GetBackgroundSpritePipeline = getBackgroundSpritePipeline;
        GetIItemStackLimitPipeline = getIItemStackLimitPipeline;
        SetBackgroundLocationPipeline = setBackgroundLocationPipeline;
        GetSlotIndexPipeline = getSlotIndexPipeline;
        IsEnabledPipeline = isEnabledPipeline;
        GetBackgroundMapPipeline = getBackgroundMapPipeline;
        IsHerePipeline = isHerePipeline;
        OnTakePipeline = onTakePipeline;
        CanTakeStackPipeline = canTakeStackPipeline;
        GetStackPipeline = getStackPipeline;
        OnSwapCraftPipeline = onSwapCraftPipeline;
        SetBackgroundNamePipeline = setBackgroundNamePipeline;
        GetBackgroundLocationPipeline = getBackgroundLocationPipeline;
        GetSlotTexturePipeline = getSlotTexturePipeline;
    }

    public List<Function<TypedPipelineElementContext<DecrStackSizeContext, IItemStack, O, I>, IItemStack>> getDecrStackSizePipeline()
    {
        return DecrStackSizePipeline;
    }

    public List<Consumer<VoidPipelineElementContext<OnSlotChangeContext, O, I>>> getOnSlotChangePipeline()
    {
        return OnSlotChangePipeline;
    }

    public List<Function<TypedPipelineElementContext<IsItemValidContext, Boolean, O, I>, Boolean>> getIsItemValidPipeline()
    {
        return IsItemValidPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<OnSlotChangedContext, O, I>>> getOnSlotChangedPipeline()
    {
        return OnSlotChangedPipeline;
    }

    public List<Function<TypedPipelineElementContext<IsSameInventoryContext, Boolean, O, I>, Boolean>> getIsSameInventoryPipeline()
    {
        return IsSameInventoryPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetSlotStackLimitContext, Integer, O, I>, Integer>> getGetSlotStackLimitPipeline()
    {
        return GetSlotStackLimitPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<OnCraftingContext, O, I>>> getOnCraftingPipeline()
    {
        return OnCraftingPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<OnCraftingWithAmountAsintContext, O, I>>> getOnCraftingWithAmountAsintPipeline()
    {
        return OnCraftingWithAmountAsintPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<PutStackContext, O, I>>> getPutStackPipeline()
    {
        return PutStackPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetHasStackContext, Boolean, O, I>, Boolean>> getGetHasStackPipeline()
    {
        return GetHasStackPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetBackgroundSpriteContext, ISprite, O, I>, ISprite>> getGetBackgroundSpritePipeline()
    {
        return GetBackgroundSpritePipeline;
    }

    public List<Function<TypedPipelineElementContext<GetItemStackLimitContext, Integer, O, I>, Integer>> getGetIItemStackLimitPipeline()
    {
        return GetIItemStackLimitPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<SetBackgroundLocationContext, O, I>>> getSetBackgroundLocationPipeline()
    {
        return SetBackgroundLocationPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetSlotIndexContext, Integer, O, I>, Integer>> getGetSlotIndexPipeline()
    {
        return GetSlotIndexPipeline;
    }

    public List<Function<TypedPipelineElementContext<IsEnabledContext, Boolean, O, I>, Boolean>> getIsEnabledPipeline()
    {
        return IsEnabledPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetBackgroundMapContext, ISpriteMap, O, I>, ISpriteMap>> getGetBackgroundMapPipeline()
    {
        return GetBackgroundMapPipeline;
    }

    public List<Function<TypedPipelineElementContext<IsHereContext, Boolean, O, I>, Boolean>> getIsHerePipeline()
    {
        return IsHerePipeline;
    }

    public List<Function<TypedPipelineElementContext<OnTakeContext, IItemStack, O, I>, IItemStack>> getOnTakePipeline()
    {
        return OnTakePipeline;
    }

    public List<Function<TypedPipelineElementContext<CanTakeStackContext, Boolean, O, I>, Boolean>> getCanTakeStackPipeline()
    {
        return CanTakeStackPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetStackContext, IItemStack, O, I>, IItemStack>> getGetStackPipeline()
    {
        return GetStackPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<OnSwapCraftContext, O, I>>> getOnSwapCraftPipeline()
    {
        return OnSwapCraftPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<SetBackgroundNameContext, O, I>>> getSetBackgroundNamePipeline()
    {
        return SetBackgroundNamePipeline;
    }

    public List<Function<TypedPipelineElementContext<GetBackgroundLocationContext, IIdentifier, O, I>, IIdentifier>> getGetBackgroundLocationPipeline()
    {
        return GetBackgroundLocationPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetSlotTextureContext, String, O, I>, String>> getGetSlotTexturePipeline()
    {
        return GetSlotTexturePipeline;
    }
}
