package com.ldtteam.jvoxelizer.launcher.forge_1_12.sound;

import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.identifier.Identifier;
import com.ldtteam.jvoxelizer.sound.ISound;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;
import org.jetbrains.annotations.NotNull;

public class Sound implements ISound
{
    private net.minecraft.client.audio.Sound forgeSound;

    private Sound(@NotNull final net.minecraft.client.audio.Sound forgeSound)
    {
        this.forgeSound = forgeSound;
    }

    @Override
    public IIdentifier getSoundLocation()
    {
        return Identifier.fromForge(forgeSound.getSoundLocation());
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

    public static net.minecraft.client.audio.Sound asForge(final ISound sound)
    {
        if (sound instanceof net.minecraft.client.audio.Sound)
            return (net.minecraft.client.audio.Sound) sound;

        return ((Sound) sound).forgeSound;
    }

    public static ISound fromForge(final net.minecraft.client.audio.Sound sound)
    {
        if (sound instanceof ISound)
            return (ISound) sound;

        return new Sound(sound);
    }
}
