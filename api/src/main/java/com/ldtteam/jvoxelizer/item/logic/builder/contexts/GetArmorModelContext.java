package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.client.model.IModelBiped;
import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.equipmentslot.IEquipmentSlot;

public class GetArmorModelContext {

    public GetArmorModelContext(ILivingBaseEntity entityLiving, IItemStack itemStack, IEquipmentSlot armorSlot, IModelBiped _default) {
        this.entityLiving = entityLiving;
        this.itemStack = itemStack;
        this.armorSlot = armorSlot;
        this._default = _default;
    }

    private ILivingBaseEntity entityLiving;

    public ILivingBaseEntity getEntityLiving() {
        return entityLiving;
    }

    public void setEntityLiving(ILivingBaseEntity entityLiving) {
        this.entityLiving = entityLiving;
    }

    private IItemStack itemStack;

    public IItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(IItemStack itemStack) {
        this.itemStack = itemStack;
    }

    private IEquipmentSlot armorSlot;

    public IEquipmentSlot getArmorSlot() {
        return armorSlot;
    }

    public void setArmorSlot(IEquipmentSlot armorSlot) {
        this.armorSlot = armorSlot;
    }

    private IModelBiped _default;

    public IModelBiped get_default() {
        return _default;
    }

    public void set_default(IModelBiped _default) {
        this._default = _default;
    }
}
