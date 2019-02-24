package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.actionresult;

import com.ldtteam.jvoxelizer.util.actionresult.IActionResult;
import com.ldtteam.jvoxelizer.util.actionresult.IActionResultType;

import net.minecraft.util.EnumActionResult;

public class ActionResult<T> implements IActionResult<T>
{
    private net.minecraft.util.ActionResult<T> actionResult;

    public ActionResult(EnumActionResult typeIn, T resultIn)
    {
        actionResult = new net.minecraft.util.ActionResult<T>(typeIn, resultIn);
    }

    @Override
    public T get()
    {
        return actionResult.getResult();
    }

    @Override
    public IActionResultType getType()
    {
        return new ActionResultType(actionResult.getType());
    }
}