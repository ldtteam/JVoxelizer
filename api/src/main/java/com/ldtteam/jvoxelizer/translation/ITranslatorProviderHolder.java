package com.ldtteam.jvoxelizer.translation;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class ITranslatorProviderHolder extends AbstractHolder<ITranslatorProvider> implements ITranslatorProvider
{
    private static ITranslatorProviderHolder ourInstance = new ITranslatorProviderHolder();

    public static ITranslatorProviderHolder getInstance()
    {
        return ourInstance;
    }

    private ITranslatorProviderHolder()
    {
        super(ITranslator.class.getName());
    }

    @Override
    public String format(final String translateKey, final Object... parameters)
    {
        return getProvider().format(translateKey, parameters);
    }
}