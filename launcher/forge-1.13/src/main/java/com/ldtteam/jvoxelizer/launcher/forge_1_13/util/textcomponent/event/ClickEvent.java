package com.ldtteam.jvoxelizer.launcher.forge_1_13.util.textcomponent.event;

import com.ldtteam.jvoxelizer.util.textcomponent.event.IClickEvent;

public class ClickEvent implements IClickEvent
{
    private net.minecraft.util.text.event.ClickEvent forgeClickEvent;

    private ClickEvent(net.minecraft.util.text.event.ClickEvent forgeClickEvent)
    {
        this.forgeClickEvent = forgeClickEvent;
    }

    public static net.minecraft.util.text.event.ClickEvent asForge(IClickEvent event)
    {
        if (event instanceof net.minecraft.util.text.event.ClickEvent)
        {
            return (net.minecraft.util.text.event.ClickEvent) event;
        }

        return ((ClickEvent) event).forgeClickEvent;
    }

    public static IClickEvent fromForge(net.minecraft.util.text.event.ClickEvent event)
    {
        if (event instanceof IClickEvent)
        {
            return (IClickEvent) event;
        }

        return new ClickEvent(event);
    }
}
