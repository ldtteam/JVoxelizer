package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.distribution.executor;

import com.ldtteam.jvoxelizer.util.distribution.IDistribution;
import com.ldtteam.jvoxelizer.util.distribution.executor.IDistributionExecutor;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

import java.util.function.Supplier;

public class DistributionExecutor implements IDistributionExecutor
{
    private static DistributionExecutor ourInstance = new DistributionExecutor();

    public static DistributionExecutor getInstance()
    {
        return ourInstance;
    }

    private DistributionExecutor()
    {
    }

    /**
     * Method used to only run code on the clien {@link IDistribution}t.
     *
     * @param runnable The code that needs to be run on the client {@link IDistribution} only.
     */
    @Override
    public void runOnClient(final Runnable runnable)
    {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
        {
            runnable.run();
        }
    }

    /**
     * Method used to only run code on the server {@link IDistribution}.
     *
     * @param runnable The code that needs to be run on the server {@link IDistribution} only.
     */
    @Override
    public void runOnServer(final Runnable runnable)
    {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER)
        {
            runnable.run();
        }
    }

    /**
     * A {@link Supplier} version of {@link #on(Runnable, Runnable)}.
     *
     * @param clientSide The {@link Supplier} that executes on the client {@link IDistribution}.
     * @param serverSide The {@link Supplier} that executes on the server {@link IDistribution}.
     * @return The value from the client or the server {@link IDistribution}.
     */
    @Override
    public <T> T runOn(final Supplier<T> clientSide, final Supplier<T> serverSide)
    {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
        {
            return clientSide.get();
        }

        return serverSide.get();
    }
}
