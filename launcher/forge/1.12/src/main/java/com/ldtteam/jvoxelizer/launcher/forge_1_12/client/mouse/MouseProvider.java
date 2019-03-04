package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.mouse;

import com.ldtteam.jvoxelizer.client.mouse.IMouseProvider;
import org.lwjgl.input.Mouse;

public class MouseProvider implements IMouseProvider
{
    private static MouseProvider ourInstance = new MouseProvider();

    public static MouseProvider getInstance()
    {
        return ourInstance;
    }

    private MouseProvider()
    {
    }

    @Override
    public double provideX()
    {
        return Mouse.getX();
    }

    @Override
    public double provideY()
    {
        return Mouse.getY();
    }

    @Override
    public int provideDWheel()
    {
        return Mouse.getDWheel();
    }

    @Override
    public int provideEventButton()
    {
        return Mouse.getEventButton();
    }
}
