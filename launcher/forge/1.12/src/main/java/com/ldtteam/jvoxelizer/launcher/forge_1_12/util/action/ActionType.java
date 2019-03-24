package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.action;

import com.ldtteam.jvoxelizer.util.action.IActionType;

import net.minecraft.item.EnumAction;

public class ActionType implements IActionType
{
    private EnumAction forgeAction;

    private ActionType(final EnumAction forgeAction)
    {
        this.forgeAction = forgeAction;
    }

    @Override
    public boolean isNone()
    {
        return this.forgeAction == EnumAction.NONE;
    }

    @Override
    public boolean isEat()
    {
        return this.forgeAction == EnumAction.EAT;
    }

    @Override
    public boolean isBlock()
    {
        return this.forgeAction == EnumAction.BLOCK;
    }

    @Override
    public boolean isBow()
    {
        return this.forgeAction == EnumAction.BOW;
    }

    @Override
    public boolean isDrink()
    {
        return this.forgeAction == EnumAction.DRINK;
    }

    private EnumAction getForgeAction()
    {
        return forgeAction;
    }

    public static EnumAction asForge(IActionType actionType)
    {
        return ((ActionType) actionType).getForgeAction();
    }

    public static IActionType fromForge(EnumAction actionType)
    {
        return new ActionType(actionType);
    }
}