package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.actionresult;

import com.ldtteam.jvoxelizer.util.actionresult.IActionResult;
import com.ldtteam.jvoxelizer.util.actionresult.IActionResultType;

import net.minecraft.util.EnumActionResult;

public class ActionResult<T> implements IActionResult<T>
{
    private net.minecraft.util.ActionResult<T> actionResult;

    private ActionResult(EnumActionResult typeIn, T resultIn)
    {
        actionResult = new net.minecraft.util.ActionResult<>(typeIn, resultIn);
    }

    @Override
    public T get()
    {
        return actionResult.getResult();
    }

    @Override
    public IActionResultType getType()
    {
        return ActionResultType.fromForge(actionResult.getType());
    }

    public static net.minecraft.util.ActionResult asForge(IActionResult actionType)
    {
        if (actionType instanceof net.minecraft.util.ActionResult)
            return (net.minecraft.util.ActionResult) actionType;

        return ((ActionResult) actionType).actionResult;
    }

    //TODO orion wants to look at this here.
    public static IActionResult fromForge(net.minecraft.util.EnumActionResult actionType, Object resultIn)
    {
        return new ActionResult<>(actionType, resultIn);
    }
}