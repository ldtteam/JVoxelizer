package com.ldtteam.jvoxelizer.launcher.forge_1_12.common.animation;

import com.ldtteam.jvoxelizer.common.animation.ITimedValue;
import net.minecraftforge.common.animation.ITimeValue;

public class TimedValue implements ITimedValue
{
    private ITimeValue timeValue;

    private TimedValue(final ITimeValue timeValue)
    {
        this.timeValue = timeValue;
    }

    /**
     * Get the wrapped forge class.
     * @return the ITimeValue.
     */
    private ITimeValue getForgeTimeValue()
    {
        return this.timeValue;
    }

    public static ITimedValue fromForge(ITimeValue value)
    {
        if (value instanceof ITimedValue)
            return (ITimedValue) value;

        return new TimedValue(value);
    }

    public static ITimeValue asForge(ITimedValue value)
    {
        if (value instanceof ITimeValue)
            return (ITimeValue) value;

        return ((TimedValue) value).getForgeTimeValue();
    }
}
