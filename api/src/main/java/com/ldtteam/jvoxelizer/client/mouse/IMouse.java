package com.ldtteam.jvoxelizer.client.mouse;

public interface IMouse
{

    static double getX()
    {
        return IMouseProviderHolder.getInstance().provideX();
    }

    static double getY()
    {
        return IMouseProviderHolder.getInstance().provideY();
    }

    static int getDWheel()
    {
        return IMouseProviderHolder.getInstance().provideDWheel();
    }

    static int getEventButton() { return IMouseProviderHolder.getInstance().provideEventButton();}
}
