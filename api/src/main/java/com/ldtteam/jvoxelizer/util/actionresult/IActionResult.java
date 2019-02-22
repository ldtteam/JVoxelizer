package com.ldtteam.jvoxelizer.util.actionresult;

public interface IActionResult<T>
{

    T get();

    IActionResultType getType();
}
