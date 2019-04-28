package com.ldtteam.jvoxelizer.launcher.forge_1_13.server;

import com.ldtteam.jvoxelizer.launcher.forge_1_13.server.manager.PlayerManager;
import com.ldtteam.jvoxelizer.server.IServerInstance;
import com.ldtteam.jvoxelizer.server.manager.IPlayerManager;
import net.minecraft.server.MinecraftServer;

public class ServerInstance implements IServerInstance
{
    private final MinecraftServer server;

    private ServerInstance(final MinecraftServer integratedServer)
    {
        this.server = integratedServer;
    }

    @Override
    public IPlayerManager getPlayerManager()
    {
        return PlayerManager.fromForge(server.getPlayerList());
    }

    public static MinecraftServer asForge(final IServerInstance engine)
    {
        return ((ServerInstance) engine).server;
    }

    public static IServerInstance fromForge(final MinecraftServer engine)
    {
        return new ServerInstance(engine);
    }
}
