package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

public class SetHarvestLevelContext {

    public SetHarvestLevelContext(String toolClass, int level) {
        this.toolClass = toolClass;
        this.level = level;
    }

    private String toolClass;

    public String getToolClass() {
        return toolClass;
    }

    public void setToolClass(String toolClass) {
        this.toolClass = toolClass;
    }

    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
