package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.actionresult;

import com.ldtteam.jvoxelizer.util.actionresult.IActionResultType;

import net.minecraft.util.EnumActionResult;

public class ActionResultType implements IActionResultType
{
    private EnumActionResult forgeActionResult;

    public ActionResultType(final EnumActionResult forgeActionResult)
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
}