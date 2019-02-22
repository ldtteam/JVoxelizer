package com.ldtteam.jvoxelizer.inventory.slot.logic.builder;

import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISpriteMap;
import com.ldtteam.jvoxelizer.core.logic.TypedPipelineElementContext;
import com.ldtteam.jvoxelizer.core.logic.VoidPipelineElementContext;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.inventory.slot.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

import java.util.function.Consumer;
import java.util.function.Function;

public interface ISlotBuilder<C extends ISlotBuilder<C, I, O>, I, O extends ISlot<I>>
{
    C DecrStackSize(Function<TypedPipelineElementContext<DecrStackSizeContext, IItemStack, O, I>, IItemStack>... components);

    C OnSlotChange(Consumer<VoidPipelineElementContext<OnSlotChangeContext, O, I>>... components);

    C IsItemValid(Function<TypedPipelineElementContext<IsItemValidContext, Boolean, O, I>, Boolean>... components);

    C OnSlotChanged(Consumer<VoidPipelineElementContext<OnSlotChangedContext, O, I>>... components);

    C IsSameInventory(Function<TypedPipelineElementContext<IsSameInventoryContext, Boolean, O, I>, Boolean>... components);

    C GetSlotStackLimit(Function<TypedPipelineElementContext<GetSlotStackLimitContext, Integer, O, I>, Integer>... components);

    C OnCrafting(Consumer<VoidPipelineElementContext<OnCraftingContext, O, I>>... components);

    C OnCraftingWithAmountAsint(Consumer<VoidPipelineElementContext<OnCraftingWithAmountAsintContext, O, I>>... components);

    C PutStack(Consumer<VoidPipelineElementContext<PutStackContext, O, I>>... components);

    C GetHasStack(Function<TypedPipelineElementContext<GetHasStackContext, Boolean, O, I>, Boolean>... components);

    C GetBackgroundSprite(Function<TypedPipelineElementContext<GetBackgroundSpriteContext, ISprite, O, I>, ISprite>... components);

    C GetItemStackLimit(Function<TypedPipelineElementContext<GetItemStackLimitContext, Integer, O, I>, Integer>... components);

    C SetBackgroundLocation(Consumer<VoidPipelineElementContext<SetBackgroundLocationContext, O, I>>... components);

    C GetSlotIndex(Function<TypedPipelineElementContext<GetSlotIndexContext, Integer, O, I>, Integer>... components);

    C IsEnabled(Function<TypedPipelineElementContext<IsEnabledContext, Boolean, O, I>, Boolean>... components);

    C GetBackgroundMap(Function<TypedPipelineElementContext<GetBackgroundMapContext, ISpriteMap, O, I>, ISpriteMap>... components);

    C IsHere(Function<TypedPipelineElementContext<IsHereContext, Boolean, O, I>, Boolean>... components);

    C OnTake(Function<TypedPipelineElementContext<OnTakeContext, IItemStack, O, I>, IItemStack>... components);

    C CanTakeStack(Function<TypedPipelineElementContext<CanTakeStackContext, Boolean, O, I>, Boolean>... components);

    C GetStack(Function<TypedPipelineElementContext<GetStackContext, IItemStack, O, I>, IItemStack>... components);

    C OnSwapCraft(Consumer<VoidPipelineElementContext<OnSwapCraftContext, O, I>>... components);

    C SetBackgroundName(Consumer<VoidPipelineElementContext<SetBackgroundNameContext, O, I>>... components);

    C GetBackgroundLocation(Function<TypedPipelineElementContext<GetBackgroundLocationContext, IIdentifier, O, I>, IIdentifier>... components);

    C GetSlotTexture(Function<TypedPipelineElementContext<GetSlotTextureContext, String, O, I>, String>... components);

    ISlot<I> build(I guiContext);
}
