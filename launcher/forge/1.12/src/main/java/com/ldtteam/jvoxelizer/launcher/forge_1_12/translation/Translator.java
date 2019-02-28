package com.ldtteam.jvoxelizer.launcher.forge_1_12.translation;

import com.ldtteam.jvoxelizer.translation.ITranslator;
import net.minecraft.client.resources.I18n;

public class Translator implements ITranslator
{
    private I18n translator;

    public Translator(final I18n translator)
    {
        this.translator = translator;
    }
}
