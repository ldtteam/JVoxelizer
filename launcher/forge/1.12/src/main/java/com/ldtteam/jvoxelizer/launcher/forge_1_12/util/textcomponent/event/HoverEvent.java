package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.textcomponent.event;

import com.ldtteam.jvoxelizer.util.textcomponent.event.IHoverEvent;

public class HoverEvent implements IHoverEvent
{
    private net.minecraft.util.text.event.HoverEvent forgeHoverEvent;

    private HoverEvent(net.minecraft.util.text.event.HoverEvent forgeHoverEvent)
    {
        this.forgeHoverEvent = forgeHoverEvent;
    }

    public static net.minecraft.util.text.event.HoverEvent asForge(IHoverEvent event)
    {
        if (event instanceof net.minecraft.util.text.event.HoverEvent)
            return (net.minecraft.util.text.event.HoverEvent) event;

        return ((HoverEvent) event).forgeHoverEvent;
    }

    public static IHoverEvent fromForge(net.minecraft.util.text.event.HoverEvent event)
    {
        if (event instanceof IHoverEvent)
            return (IHoverEvent) event;

        return new HoverEvent(event);
    }
}
