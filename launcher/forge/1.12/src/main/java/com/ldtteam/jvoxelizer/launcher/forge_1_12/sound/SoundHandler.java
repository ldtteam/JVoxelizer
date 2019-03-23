package com.ldtteam.jvoxelizer.launcher.forge_1_12.sound;

import com.ldtteam.jvoxelizer.entity.IEntity;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player.PlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.identifier.Identifier;
import com.ldtteam.jvoxelizer.sound.*;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;
import org.jetbrains.annotations.NotNull;

public class SoundHandler implements ISoundHandler
{
    private net.minecraft.client.audio.SoundHandler forgeSoundHandler;

    private SoundHandler(@NotNull final net.minecraft.client.audio.SoundHandler forgeSoundHandler)
    {
        this.forgeSoundHandler = forgeSoundHandler;
    }

    @Override
    public ISoundEventAccessor getAccessor(final IIdentifier location)
    {
        return new SoundEventAccessor(forgeSoundHandler.getAccessor(Identifier.asForge(location)));
    }

    @Override
    public void setListener(final IPlayerEntity player, final float p_147691_2_)
    {
        forgeSoundHandler.setListener(PlayerEntity.asForge(player), p_147691_2_);
    }

    @Override
    public void setListener(final IEntity entity, final float partialTicks)
    {
        forgeSoundHandler.setListener(Entity.asForge(entity) ,partialTicks);
    }

    @Override
    public void pauseSounds()
    {
        forgeSoundHandler.pauseSounds();
    }

    @Override
    public void stopSounds()
    {
        forgeSoundHandler.stopSounds();
    }

    @Override
    public void unloadSounds()
    {
        forgeSoundHandler.unloadSounds();
    }

    @Override
    public void update()
    {
        forgeSoundHandler.update();
    }

    @Override
    public void resumeSounds()
    {
        forgeSoundHandler.resumeSounds();
    }

    @Override
    public void setSoundLevel(final ISoundCategory category, final float volume)
    {
        forgeSoundHandler.setSoundLevel(((SoundCategory)category).forgeSoundCategory ,volume);
    }

    @Override
    public void addListener(final ISoundEventListener listener)
    {
        forgeSoundHandler.addListener(SoundEventListener.asForge(listener));
    }

    @Override
    public void removeListener(final ISoundEventListener listener)
    {
        forgeSoundHandler.removeListener(SoundEventListener.asForge(listener));
    }

    @Override
    public void stop(final String p_189520_1_, final ISoundCategory p_189520_2_)
    {
        forgeSoundHandler.stop(p_189520_1_, ((SoundCategory)p_189520_2_).forgeSoundCategory);
    }
    
    public static net.minecraft.client.audio.SoundHandler asForge(final ISoundHandler handler)
    {
        if (handler instanceof net.minecraft.client.audio.SoundHandler)
            return (net.minecraft.client.audio.SoundHandler) handler;

        return ((SoundHandler) handler).forgeSoundHandler;
    }

    public static ISoundHandler fromForge(final net.minecraft.client.audio.SoundHandler handler)
    {
        if (handler instanceof ISoundHandler)
            return (ISoundHandler) handler;

        return new SoundHandler(handler);
    }
}
