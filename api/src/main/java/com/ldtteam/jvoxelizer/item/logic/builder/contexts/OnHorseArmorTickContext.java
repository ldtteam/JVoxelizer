package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.entity.living.ILivingEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;

public class OnHorseArmorTickContext {

    public OnHorseArmorTickContext(IDimension world, ILivingEntity horse, IItemStack armor) {
        this.world = world;
        this.horse = horse;
        this.armor = armor;
    }

    private IDimension world;

    public IDimension getWorld() {
        return world;
    }

    public void setWorld(IDimension world) {
        this.world = world;
    }

    private ILivingEntity horse;

    public ILivingEntity getHorse() {
        return horse;
    }

    public void setHorse(ILivingEntity horse) {
        this.horse = horse;
    }

    private IItemStack armor;

    public IItemStack getArmor() {
        return armor;
    }

    public void setArmor(IItemStack armor) {
        this.armor = armor;
    }
}
