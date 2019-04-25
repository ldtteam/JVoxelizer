package com.ldtteam.jvoxelizer.launcher.forge_1_13.util.actionresult;

import com.ldtteam.jvoxelizer.util.actionresult.IActionResultType;

import net.minecraft.util.EnumActionResult;

public class ActionResultType implements IActionResultType
{
    private EnumActionResult forgeActionResult;

    private ActionResultType(final EnumActionResult forgeActionResult)
    {
        this.forgeActionResult = forgeActionResult;
    }

    @Override
    public boolean isSuccess()
    {
        return this.forgeActionResult == EnumActionResult.SUCCESS;
    }

    @Override
    public boolean isFailure()
    {
        return this.forgeActionResult == EnumActionResult.FAIL;
    }

    @Override
    public boolean isPass()
    {
        return this.forgeActionResult == EnumActionResult.PASS;
    }

    public static EnumActionResult asForge(IActionResultType distribution)
    {
        return ((ActionResultType) distribution).forgeActionResult;
    }

    public static IActionResultType fromForge(EnumActionResult side)
    {
        return new ActionResultType(side);
    }
}