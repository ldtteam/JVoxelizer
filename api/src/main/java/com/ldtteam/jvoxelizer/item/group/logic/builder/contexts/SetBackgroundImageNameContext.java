package com.ldtteam.jvoxelizer.item.group.logic.builder.contexts;

public class SetBackgroundImageNameContext {

    public SetBackgroundImageNameContext(String texture) {
        this.texture = texture;
    }

    private String texture;

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }
}
