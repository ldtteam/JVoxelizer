package com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player;

import com.ldtteam.jvoxelizer.entity.living.player.IFakePlayer;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import org.jetbrains.annotations.NotNull;

public class FakePlayer extends PlayerEntity implements IFakePlayer
{
    private final net.minecraftforge.common.util.FakePlayer forgeEntity;

    private FakePlayer(@NotNull final net.minecraftforge.common.util.FakePlayer forgeEntity)
    {
        super(forgeEntity);
        this.forgeEntity = forgeEntity;
    }

    private net.minecraftforge.common.util.FakePlayer getForgeEntity()
    {
        return forgeEntity;
    }

    public net.minecraftforge.common.util.FakePlayer asForge(IFakePlayer fakePlayer)
    {
        if (fakePlayer instanceof net.minecraftforge.common.util.FakePlayer)
        {
            return (net.minecraftforge.common.util.FakePlayer) fakePlayer;
        }

        if (fakePlayer == null)
        {
            return null;
        }

        if (!(fakePlayer instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("FakePlayer is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) fakePlayer).getForgeInstance();
    }

    public IFakePlayer fromForge(net.minecraftforge.common.util.FakePlayer fakePlayer)
    {
        if (fakePlayer instanceof IFakePlayer)
        {
            return (IFakePlayer) fakePlayer;
        }

        return new FakePlayer(fakePlayer);
    }
}
