package com.ldtteam.jvoxelizer.sound;

import com.ldtteam.jvoxelizer.entity.IEntity;
import com.ldtteam.jvoxelizer.entity.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface ISoundHandler
{

    static ISound getMissingSound()
    {
        throw new NotImplementedException();
    }

    ISoundEventAccessor getAccessor(IIdentifier location);

    /**
     * Play a sound
     */
    void playSound(ISound sound);

    /**
     * Plays the sound in n ticks
     */
    void playDelayedSound(ISound sound, int delay);

    void setListener(IPlayerEntity player, float p_147691_2_);

    void setListener(IEntity entity, float partialTicks);

    void pauseSounds();

    void stopSounds();

    void unloadSounds();

    /**
     * Like the old updateEntity(), except more generic.
     */
    void update();

    void resumeSounds();

    void setSoundLevel(ISoundCategory category, float volume);

    void stopSound(ISound soundIn);

    boolean isSoundPlaying(ISound sound);

    void addListener(ISoundEventListener listener);

    void removeListener(ISoundEventListener listener);

    void stop(String p_189520_1_, ISoundCategory p_189520_2_);
}
