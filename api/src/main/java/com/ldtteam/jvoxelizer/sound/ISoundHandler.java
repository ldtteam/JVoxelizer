package com.ldtteam.jvoxelizer.sound;

import com.ldtteam.jvoxelizer.entity.IEntity;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface ISoundHandler
{

    static ISound getMissingSound()
    {
        throw new NotImplementedException();
    }

    ISoundEventAccessor getAccessor(IIdentifier location);

    void setListener(IPlayerEntity player, float p_147691_2_);

    void setListener(IEntity entity, float partialTicks);

    void pauseSounds();

    void stopSounds();

    void unloadSounds();

    void update();

    void resumeSounds();

    void setSoundLevel(ISoundCategory category, float volume);

    void addListener(ISoundEventListener listener);

    void removeListener(ISoundEventListener listener);

    void stop(String p_189520_1_, ISoundCategory p_189520_2_);
}
