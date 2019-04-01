package com.ldtteam.jvoxelizer.launcher.forge_1_12.translation;

import com.ldtteam.jvoxelizer.translation.ITranslator;
import net.minecraft.util.text.translation.I18n;

public class Translator implements ITranslator
{
    private I18n translator;

    private Translator(final I18n translator)
    {
        this.translator = translator;
    }

    public static I18n asForge(final ITranslator translator)
    {
        if (translator instanceof I18n)
        {
            return (I18n) translator;
        }

        return ((Translator) translator).translator;
    }

    public static ITranslator fromForge(final I18n translator)
    {
        if (translator instanceof ITranslator)
        {
            return (ITranslator) translator;
        }

        return new Translator(translator);
    }
}
