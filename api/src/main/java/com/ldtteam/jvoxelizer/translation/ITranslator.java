package com.ldtteam.jvoxelizer.translation;

public interface ITranslator
{
    static String format(String translateKey, Object... parameters)
    {
        return ITranslatorProviderHolder.getInstance().format(translateKey, parameters);
    }
}
