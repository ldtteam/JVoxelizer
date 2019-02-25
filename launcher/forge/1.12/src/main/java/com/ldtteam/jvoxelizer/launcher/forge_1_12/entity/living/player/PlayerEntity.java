package com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player;

import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.IContainer;
import com.ldtteam.jvoxelizer.inventory.IInventoryPlayer;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.LivingBaseEntity;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

public class PlayerEntity extends LivingBaseEntity implements IPlayerEntity
{
    private EntityPlayer forgePlayer;

    public PlayerEntity(@NotNull final EntityPlayer forgeEntity)
    {
        super(forgeEntity);
        forgePlayer = forgeEntity;
    }

    @Override
    public IInventoryPlayer getInventory()
    {
        // TODO
        return forgePlayer.inventory;
    }

    @Override
    public IContainer<?> getOpenContainer()
    {
        // TODO
        return forgePlayer.openContainer;
    }

    @Override
    public IPlayerEntity setOpenContainer(final IContainer<?> container)
    {
        // TODO
        forgePlayer.inventoryContainer;
        return this;
    }
}
