package com.ldtteam.jvoxelizer.launcher.forge_1_12.common.capability;

import com.ldtteam.jvoxelizer.common.capability.ICapability;
import com.ldtteam.jvoxelizer.common.capability.ICapabilityLogicProvider;
import com.ldtteam.jvoxelizer.item.handling.IItemHandler;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.handling.ItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;

public class CapabilityLogicProvider implements ICapabilityLogicProvider
{
    private static CapabilityLogicProvider ourInstance = new CapabilityLogicProvider();

    public static CapabilityLogicProvider getInstance()
    {
        return ourInstance;
    }

    private CapabilityLogicProvider()
    {
    }

    @Override
    public ICapability<IItemHandler> getItemHandlerCapability()
    {
        return Capability.fromForge(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, ItemHandler::fromForge);
    }
}
