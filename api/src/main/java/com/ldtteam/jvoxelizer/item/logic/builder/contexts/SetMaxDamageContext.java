package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

public class SetMaxDamageContext {

    public SetMaxDamageContext(int maxDamageIn) {
        this.maxDamageIn = maxDamageIn;
    }

    private int maxDamageIn;

    public int getMaxDamageIn() {
        return maxDamageIn;
    }

    public void setMaxDamageIn(int maxDamageIn) {
        this.maxDamageIn = maxDamageIn;
    }
}
