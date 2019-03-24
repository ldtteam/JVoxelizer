package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.actionresult;

import com.ldtteam.jvoxelizer.util.actionresult.IActionResult;
import com.ldtteam.jvoxelizer.util.actionresult.IActionResultType;

import net.minecraft.util.EnumActionResult;

import java.util.function.Function;

public class ActionResult<T, I> implements IActionResult<T>
{
    private Function<I, T>                     convertor;
    private net.minecraft.util.ActionResult<I> actionResult;

    private ActionResult(final net.minecraft.util.ActionResult<I> actionResult, Function<I, T> convertor)
    {
        this.convertor = convertor;
        this.actionResult = actionResult;
    }

    @Override
    public T get()
    {
         return convertor.apply(actionResult.getResult());
    }

    @Override
    public IActionResultType getType()
    {
        return ActionResultType.fromForge(actionResult.getType());
    }

    private net.minecraft.util.ActionResult<I> getActionResult()
    {
        return actionResult;
    }

    public static net.minecraft.util.ActionResult<?> asForge(IActionResult<?> actionType)
    {
        if (actionType instanceof net.minecraft.util.ActionResult)
            return (net.minecraft.util.ActionResult) actionType;

        return ((ActionResult) actionType).getActionResult();
    }

    public static <S, R> IActionResult<S> fromForge(final net.minecraft.util.ActionResult<R> actionResult, Function<R, S> convertor)
    {
        if (actionResult instanceof IActionResult)
            return (IActionResult<S>) actionResult;

        return new ActionResult<>(actionResult, convertor);
    }
}