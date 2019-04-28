package com.ldtteam.jvoxelizer.launcher.forge_1_12.translation;

import com.ldtteam.jvoxelizer.translation.ITranslatorProvider;
import net.minecraft.util.text.translation.I18n;

public class TranslatorProvider implements ITranslatorProvider
{
    private static TranslatorProvider ourInstance = new TranslatorProvider();

    public static TranslatorProvider getInstance()
    {
        return ourInstance;
    }

    private TranslatorProvider()
    {
    }

    @Override
    public String format(final String translateKey, final Object... parameters)
    {
        return I18n.translateToLocalFormatted(translateKey, parameters);
    }
}
