package com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.living.player;

import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.IContainer;
import com.ldtteam.jvoxelizer.inventory.IInventoryPlayer;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.living.LivingBaseEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.Container;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.InventoryPlayer;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

public class PlayerEntity extends LivingBaseEntity implements IPlayerEntity
{
    private final EntityPlayer forgePlayer;

    protected PlayerEntity(@NotNull final EntityPlayer forgeEntity)
    {
        super(forgeEntity);
        forgePlayer = forgeEntity;
    }

    @Override
    public IInventoryPlayer getInventory()
    {
        return InventoryPlayer.fromForge(forgePlayer.inventory);
    }

    @Override
    public IContainer<?> getOpenContainer()
    {
        return Container.fromForge(forgePlayer.openContainer);
    }

    @Override
    public IPlayerEntity setOpenContainer(final IContainer<?> container)
    {
        forgePlayer.openContainer = Container.asForge(container);
        return this;
    }

    private EntityPlayer getForgePlayer()
    {
        return forgePlayer;
    }

    public static EntityPlayer asForge(IPlayerEntity playerEntity)
    {
        if (playerEntity instanceof EntityPlayer)
        {
            return (EntityPlayer) playerEntity;
        }

        if (playerEntity == null)
        {
            return null;
        }

        if (!(playerEntity instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("PlayerEntity is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) playerEntity).getForgeInstance();
    }

    public static IPlayerEntity fromForge(EntityPlayer player)
    {
        if (player instanceof IPlayerEntity)
        {
            return (IPlayerEntity) player;
        }

        return new PlayerEntity(player);
    }
}
