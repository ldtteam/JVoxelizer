package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

public class GetMetadataContext {

    public GetMetadataContext(int damage) {
        this.damage = damage;
    }

    private int damage;

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
