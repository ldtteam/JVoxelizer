package com.ldtteam.jvoxelizer.client.mouse;

/**
 * Provides access to mouse data.
 */
public interface IMouseProvider
{
    double provideX();

    double provideY();

    int provideDWheel();

    int provideEventButton();
}
