package com.ldtteam.jvoxelizer.launcher.forge_1_13.util.textformatting;

import com.ldtteam.jvoxelizer.util.textformatting.ITextFormatting;
import com.ldtteam.jvoxelizer.util.textformatting.ITextFormattingProvider;

public class TextFormattingProvider implements ITextFormattingProvider
{
    private static TextFormattingProvider ourInstance = new TextFormattingProvider();

    public static TextFormattingProvider getInstance()
    {
        return ourInstance;
    }

    private TextFormattingProvider()
    {
    }

    @Override
    public ITextFormatting provideBlack()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.BLACK);
    }

    @Override
    public ITextFormatting provideDarkBlue()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.DARK_BLUE);
    }

    @Override
    public ITextFormatting provideDarkGreen()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.DARK_GREEN);
    }

    @Override
    public ITextFormatting provideDarkAqua()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.DARK_AQUA);
    }

    @Override
    public ITextFormatting provideDarkRed()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.DARK_RED);
    }

    @Override
    public ITextFormatting provideDarkPurple()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.DARK_PURPLE);
    }

    @Override
    public ITextFormatting provideGold()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.GOLD);
    }

    @Override
    public ITextFormatting provideGray()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.GRAY);
    }

    @Override
    public ITextFormatting provideDarkGray()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.DARK_GRAY);
    }

    @Override
    public ITextFormatting provideBlue()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.BLUE);
    }

    @Override
    public ITextFormatting provideGreen()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.GREEN);
    }

    @Override
    public ITextFormatting provideAqua()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.AQUA);
    }

    @Override
    public ITextFormatting provideRed()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.RED);
    }

    @Override
    public ITextFormatting provideLightPurple()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.LIGHT_PURPLE);
    }

    @Override
    public ITextFormatting provideYellow()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.YELLOW);
    }

    @Override
    public ITextFormatting provideWhite()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.WHITE);
    }

    @Override
    public ITextFormatting provideObsfuscated()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.OBFUSCATED);
    }

    @Override
    public ITextFormatting provideBold()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.BOLD);
    }

    @Override
    public ITextFormatting provideStrikethrough()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.STRIKETHROUGH);
    }

    @Override
    public ITextFormatting provideUnderline()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.UNDERLINE);
    }

    @Override
    public ITextFormatting provideItalic()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.ITALIC);
    }

    @Override
    public ITextFormatting provideReset()
    {
        return TextFormatting.fromForge(net.minecraft.util.text.TextFormatting.RESET);
    }
}
