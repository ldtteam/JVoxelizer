package com.ldtteam.jvoxelizer.launcher.forge_1_12.sound;

import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.identifier.Identifier;
import com.ldtteam.jvoxelizer.sound.ISound;
import com.ldtteam.jvoxelizer.sound.ISoundType;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;
import org.jetbrains.annotations.NotNull;

public class Sound implements ISound
{
    net.minecraft.client.audio.ISound forgeSound;

    public Sound(@NotNull final net.minecraft.client.audio.Sound forgeSound)
    {
        this.forgeSound = forgeSound;
    }

    @Override
    public IIdentifier getSoundLocation()
    {
        return new Identifier(forgeSound.getSoundLocation());
    }

    @Override
    public float getVolume()
    {
        return forgeSound.getVolume();
    }

    @Override
    public float getPitch()
    {
        return forgeSound.getPitch();
    }

    @Override
    public ISound cloneEntry()
    {
        return this;
    }

    public net.minecraft.client.audio.ISound getForgeSound()
    {
        return forgeSound;
    }
}
