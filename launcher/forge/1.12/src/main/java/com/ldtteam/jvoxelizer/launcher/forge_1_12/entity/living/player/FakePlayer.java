package com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player;

import com.ldtteam.jvoxelizer.entity.living.player.IFakePlayer;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

public class FakePlayer extends PlayerEntity implements IFakePlayer
{
    public FakePlayer(@NotNull final EntityPlayer forgeEntity)
    {
        super(forgeEntity);
    }
}
