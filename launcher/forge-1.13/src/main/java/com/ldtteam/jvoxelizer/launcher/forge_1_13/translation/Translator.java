package com.ldtteam.jvoxelizer.launcher.forge_1_13.translation;

import com.ldtteam.jvoxelizer.translation.ITranslator;
import net.minecraft.util.text.translation.LanguageMap;

public class Translator implements ITranslator
{
    private LanguageMap translator;

    private Translator(final LanguageMap translator)
    {
        this.translator = translator;
    }

    public static LanguageMap asForge(final ITranslator translator)
    {
        if (translator instanceof LanguageMap)
        {
            return (LanguageMap) translator;
        }

        return ((Translator) translator).translator;
    }

    public static ITranslator fromForge(final LanguageMap translator)
    {
        if (translator instanceof ITranslator)
        {
            return (ITranslator) translator;
        }

        return new Translator(translator);
    }
}
