package com.ldtteam.jvoxelizer.inventory.slot.logic.builder.contexts;

import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

public class SetBackgroundLocationContext {

    public SetBackgroundLocationContext(IIdentifier texture) {
        this.texture = texture;
    }

    private IIdentifier texture;

    public IIdentifier getTexture() {
        return texture;
    }

    public void setTexture(IIdentifier texture) {
        this.texture = texture;
    }
}
