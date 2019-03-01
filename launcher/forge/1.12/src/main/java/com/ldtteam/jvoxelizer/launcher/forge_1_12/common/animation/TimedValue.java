package com.ldtteam.jvoxelizer.launcher.forge_1_12.common.animation;

import com.ldtteam.jvoxelizer.common.animation.ITimedValue;
import net.minecraftforge.common.animation.ITimeValue;

public class TimedValue implements ITimedValue
{
    private ITimeValue timeValue;

    public TimedValue(final ITimeValue timeValue)
    {
        this.timeValue = timeValue;
    }

    /**
     * Get the wrapped forge class.
     * @return the ITimeValue.
     */
    public ITimeValue getForgeTimeValue()
    {
        return this.timeValue;
    }
}
