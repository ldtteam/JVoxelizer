package com.ldtteam.jvoxelizer.item;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;

public interface IItemPropertyGetter
{
    float apply(IItemStack stack, IDimension worldIn, ILivingBaseEntity entityIn);
}
