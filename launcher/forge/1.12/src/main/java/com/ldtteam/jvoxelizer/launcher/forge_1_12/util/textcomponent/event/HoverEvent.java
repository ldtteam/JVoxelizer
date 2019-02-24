package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.textcomponent.event;

import com.ldtteam.jvoxelizer.util.textcomponent.event.IHoverEvent;

public class HoverEvent implements IHoverEvent {
    private net.minecraft.util.text.event.HoverEvent forgeHoverEvent;

    public HoverEvent(net.minecraft.util.text.event.HoverEvent forgeHoverEvent) {
        this.forgeHoverEvent = forgeHoverEvent;
    }

    public net.minecraft.util.text.event.HoverEvent getForgeHoverEvent()
    {
        return forgeHoverEvent;
    }
}
