package com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.slot.logic.pipeline;

import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISpriteMap;
import com.ldtteam.jvoxelizer.core.logic.TypedPipelineElementContext;
import com.ldtteam.jvoxelizer.core.logic.VoidPipelineElementContext;
import com.ldtteam.jvoxelizer.inventory.slot.ISlotItemHandler;
import com.ldtteam.jvoxelizer.inventory.slot.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.handling.IItemHandler;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ForgeSlotItemHandlerPipeline<O extends ISlotItemHandler<I>, I> extends ForgeSlotPipeline<O, I>
{
    private final List<Function<TypedPipelineElementContext<GetItemHandlerContext, IItemHandler, O, I>, IItemHandler>> GetItemHandlerPipeline;

    public ForgeSlotItemHandlerPipeline(
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
      final List<Function<TypedPipelineElementContext<GetSlotTextureContext, String, O, I>, String>> getSlotTexturePipeline,
      final List<Function<TypedPipelineElementContext<GetItemHandlerContext, IItemHandler, O, I>, IItemHandler>> getItemHandlerPipeline)
    {
        super(decrStackSizePipeline,
          onSlotChangePipeline,
          isItemValidPipeline,
          onSlotChangedPipeline,
          isSameInventoryPipeline,
          getSlotStackLimitPipeline,
          onCraftingPipeline,
          onCraftingWithAmountAsintPipeline,
          putStackPipeline,
          getHasStackPipeline,
          getBackgroundSpritePipeline,
          getIItemStackLimitPipeline,
          setBackgroundLocationPipeline,
          getSlotIndexPipeline,
          isEnabledPipeline,
          getBackgroundMapPipeline,
          isHerePipeline,
          onTakePipeline,
          canTakeStackPipeline,
          getStackPipeline,
          onSwapCraftPipeline,
          setBackgroundNamePipeline,
          getBackgroundLocationPipeline,
          getSlotTexturePipeline);
        GetItemHandlerPipeline = getItemHandlerPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetItemHandlerContext, IItemHandler, O, I>, IItemHandler>> getGetItemHandlerPipeline()
    {
        return GetItemHandlerPipeline;
    }
}
