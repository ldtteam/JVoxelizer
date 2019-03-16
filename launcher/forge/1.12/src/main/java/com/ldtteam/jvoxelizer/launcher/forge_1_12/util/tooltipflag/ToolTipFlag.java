package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.tooltipflag;

import com.ldtteam.jvoxelizer.util.tooltipflag.IToolTipFlag;
import net.minecraft.client.util.ITooltipFlag;

public class ToolTipFlag implements IToolTipFlag
{
    private ITooltipFlag flag;

    private ToolTipFlag(final ITooltipFlag flags)
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

    public static ITooltipFlag asForge(final IToolTipFlag flag)
    {
        return ((ToolTipFlag) flag).flag;
    }

    public static IToolTipFlag fromForge(final ITooltipFlag flag)
    {
        return new ToolTipFlag(flag);
    }
}

