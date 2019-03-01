package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.tooltipflag;

import com.ldtteam.jvoxelizer.util.tooltipflag.IToolTipFlag;
import net.minecraft.client.util.ITooltipFlag;

public class ToolTipFlag implements IToolTipFlag
{
    private ITooltipFlag flag;

    public ToolTipFlag(final ITooltipFlag flags)
    {
        this.flag = flags;
    }

    @Override
    public boolean isNormal()
    {
        return flag == ITooltipFlag.TooltipFlags.NORMAL;
    }

    @Override
    public boolean isAdvanced()
    {
        return flag == ITooltipFlag.TooltipFlags.ADVANCED;
    }

    /**
     * Get the wrapped forge flag.
     * @return the ITooltipFlag.
     */
    public ITooltipFlag getForgeFlag()
    {
        return this.flag;
    }
}

