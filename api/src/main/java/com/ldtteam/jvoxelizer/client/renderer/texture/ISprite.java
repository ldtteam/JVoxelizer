package com.ldtteam.jvoxelizer.client.renderer.texture;

/**
 * Represents a single texture.
 */
public interface ISprite
{
    /**
     * Gets the lower left x-coordinate of the texture in the sheet.
     * @return the lower left x-coordinate
     */
    float getMinU();

    /**
     * Gets the upper right x-coordinate of the texture in the sheet.
     * @return the upper right x-coordinate
     */
    float getMaxU();

    /**
     * Gets the upper right y-coordinate of the texture in the sheet.
     * @return the upper right x-coordinate
     */
    float getMaxV();

    /**
     * Gets the lower left y-coordinate of the texture in the sheet.
     * @return the lower left y-coordinate
     */
    float getMinV();

    /**
     * Calculates the linearly interpolated V from the given parameter.
     *
     * @param h The value to interpolate with, should be between 0 and 1.
     * @return The interpolated V between min and max, as far as the parameter defines it to be.
     */
    float getInterpolatedV(double h);

    /**
     * Calculates the linearly interpolated U from the given parameter.
     *
     * @param w The value to interpolate with, should be between 0 and 1.
     * @return The interpolated U between min and max, as far as the parameter defines it to be.
     */
    float getInterpolatedU(double w);

}
