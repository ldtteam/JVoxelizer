package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

public class SetHasSubtypesContext {

    public SetHasSubtypesContext(boolean hasSubtypes) {
        this.hasSubtypes = hasSubtypes;
    }

    private boolean hasSubtypes;

    public boolean getHasSubtypes() {
        return hasSubtypes;
    }

    public void setHasSubtypes(boolean hasSubtypes) {
        this.hasSubtypes = hasSubtypes;
    }
}
