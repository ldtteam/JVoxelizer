package com.ldtteam.jvoxelizer.translation;

public interface ITranslatorProvider
{
    String format(String translateKey, Object... parameters);
}
