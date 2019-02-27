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
    net.minecraft.client.audio.SoundHandler forgeSoundHandler;

    public SoundHandler(@NotNull final net.minecraft.client.audio.SoundHandler forgeSoundHandler)
    {
        this.forgeSoundHandler = forgeSoundHandler;
    }

    // TODO
    @Override
    public ISoundEventAccessor getAccessor(final IIdentifier location)
    {
        return forgeSoundHandler.getAccessor(((Identifier) location).getForgeIdentifier());
    }

    // TODO: SoundEventAccessor
    @Override
    public void playSound(final ISound sound)
    {
        forgeSoundHandler.playSound(sound);
    }

    // TODO: SoundEventAccessor
    @Override
    public void playDelayedSound(final ISound sound, final int delay)
    {
        forgeSoundHandler.playDelayedSound(sound, delay);
    }

    @Override
    public void setListener(final IPlayerEntity player, final float p_147691_2_)
    {
        forgeSoundHandler.setListener(((PlayerEntity)player).forgePlayer, p_147691_2_);
    }

    @Override
    public void setListener(final IEntity entity, final float partialTicks)
    {
        forgeSoundHandler.setListener(((Entity)entity).forgeEntity,partialTicks);
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

    // TODO: SoundEventAccessor
    @Override
    public void stopSound(final ISound soundIn)
    {
        forgeSoundHandler.stopSound(((Sound)soundIn).forgeSound);
    }

    // TODO: SoundEventAccessor
    @Override
    public boolean isSoundPlaying(final ISound sound)
    {
        return forgeSoundHandler.isSoundPlaying(sound);
    }

    @Override
    public void addListener(final ISoundEventListener listener)
    {
        forgeSoundHandler.addListener();
    }

    @Override
    public void removeListener(final ISoundEventListener listener)
    {
        forgeSoundHandler.removeListener();
    }

    @Override
    public void stop(final String p_189520_1_, final ISoundCategory p_189520_2_)
    {
        forgeSoundHandler.stop(p_189520_1_, ((SoundCategory)p_189520_2_).forgeSoundCategory);
    }
}
