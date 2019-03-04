package com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory;

import com.google.common.collect.Maps;
import com.ldtteam.jvoxelizer.inventory.IClickType;

import java.util.Map;

public enum ClickType implements IClickType
{
    PICKUP(net.minecraft.inventory.ClickType.PICKUP),
    QUICK_MOVE(net.minecraft.inventory.ClickType.QUICK_MOVE),
    SWAP(net.minecraft.inventory.ClickType.SWAP),
    CLONE(net.minecraft.inventory.ClickType.CLONE),
    THROW(net.minecraft.inventory.ClickType.THROW),
    QUICK_CRAFT(net.minecraft.inventory.ClickType.QUICK_CRAFT),
    PICKUP_ALL(net.minecraft.inventory.ClickType.PICKUP_ALL);

    static final Map<net.minecraft.inventory.ClickType, ClickType> FORGE_MAP = Maps.newHashMap();
    static {
        FORGE_MAP.put(net.minecraft.inventory.ClickType.PICKUP, PICKUP);
        FORGE_MAP.put(net.minecraft.inventory.ClickType.QUICK_MOVE, QUICK_MOVE);
        FORGE_MAP.put(net.minecraft.inventory.ClickType.SWAP, SWAP);
        FORGE_MAP.put(net.minecraft.inventory.ClickType.CLONE, CLONE);
        FORGE_MAP.put(net.minecraft.inventory.ClickType.THROW, THROW);
        FORGE_MAP.put(net.minecraft.inventory.ClickType.QUICK_CRAFT, QUICK_CRAFT);
        FORGE_MAP.put(net.minecraft.inventory.ClickType.PICKUP_ALL, PICKUP_ALL);
    }

    private final net.minecraft.inventory.ClickType forgeClickType;

    ClickType(final net.minecraft.inventory.ClickType forgeClickType) {
        this.forgeClickType = forgeClickType;
    }

    public net.minecraft.inventory.ClickType getForgeClickType()
    {
        return forgeClickType;
    }

    public static net.minecraft.inventory.ClickType asForge(IClickType clickType)
    {
        return ((ClickType) clickType).getForgeClickType();
    }

    public static IClickType fromForge(net.minecraft.inventory.ClickType clickType)
    {
        return FORGE_MAP.get(clickType);
    }
}
