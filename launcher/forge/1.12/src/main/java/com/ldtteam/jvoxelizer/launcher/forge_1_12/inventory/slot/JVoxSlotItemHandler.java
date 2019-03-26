package com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.slot;

import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.core.logic.PipelineProcessor;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.inventory.slot.ISlotItemHandler;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.handling.IInventory;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.slot.logic.pipeline.ForgeSlotItemHandlerPipeline;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.slot.logic.pipeline.ForgeSlotPipeline;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class JVoxSlotItemHandler<I> extends SlotItemHandler implements ISlotItemHandler<I>
{

    private final I instanceData;
    private final ForgeSlotItemHandlerPipeline<ISlotItemHandler<I>, I> pipeline;

    @Override
    public IItemHandler getItemHandler()
    {
    }
}
