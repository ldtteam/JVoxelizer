package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.textcomponent.event;

import com.ldtteam.jvoxelizer.util.textcomponent.event.IClickEvent;

public class ClickEvent implements IClickEvent {
    private net.minecraft.util.text.event.ClickEvent forgeClickEvent;

    public ClickEvent(net.minecraft.util.text.event.ClickEvent forgeClickEvent) {
        this.forgeClickEvent = forgeClickEvent;
    }

    public net.minecraft.util.text.event.ClickEvent getForgeClickEvent()
    {
        return forgeClickEvent;
    }
}
