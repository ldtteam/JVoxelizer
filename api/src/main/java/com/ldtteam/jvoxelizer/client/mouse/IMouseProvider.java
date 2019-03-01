package com.ldtteam.jvoxelizer.client.mouse;

public interface IMouseProvider
{

    double provideX();

    double provideY();

    int provideDWheel();

    int provideEventButton();
}
