package com.ldtteam.jvoxelizer.launcher.forge_1_13.translation;

import com.ldtteam.jvoxelizer.translation.ITranslatorProvider;
import net.minecraftforge.fml.ForgeI18n;

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
        return ForgeI18n.parseFormat(translateKey, parameters);
    }
}
