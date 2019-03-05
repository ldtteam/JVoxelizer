package com.ldtteam.jvoxelizer.client.mouse;

/**
 * Represents the mouse.
 */
public interface IMouse
{
    /**
     * The current X coordinate of the mouse.
     *
     * @return The current X coordinate of the mouse.
     */
    static double getX()
    {
        return IMouseProviderHolder.getInstance().provideX();
    }

    /**
     * The current Y coordinate of the mouse.
     *
     * @return The current Y coordinate.
     */
    static double getY()
    {
        return IMouseProviderHolder.getInstance().provideY();
    }

    /**
     * The amount the scroll-wheel was scrolled.
     *
     * @return The amount the scroll-wheel was scrolled.
     */
    static int getDWheel()
    {
        return IMouseProviderHolder.getInstance().provideDWheel();
    }

    /**
     * The button who was pressed.
     *
     * @return The button who was pressed.
     */
    static int getEventButton() { return IMouseProviderHolder.getInstance().provideEventButton();}
}
