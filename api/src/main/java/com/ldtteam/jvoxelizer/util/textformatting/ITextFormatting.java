package com.ldtteam.jvoxelizer.util.textformatting;

public interface ITextFormatting
{

    static ITextFormatting black()
    {
        return ITextFormattingProviderHolder.getInstance().provideBlack();
    }

    static ITextFormatting darkBlue()
    {
        return ITextFormattingProviderHolder.getInstance().provideDarkBlue();
    }

    static ITextFormatting darkGreen()
    {
        return ITextFormattingProviderHolder.getInstance().provideDarkGreen();
    }

    static ITextFormatting darkAqua()
    {
        return ITextFormattingProviderHolder.getInstance().provideDarkAqua();
    }

    static ITextFormatting darkRed()
    {
        return ITextFormattingProviderHolder.getInstance().provideDarkRed();
    }

    static ITextFormatting darkPurple()
    {
        return ITextFormattingProviderHolder.getInstance().provideDarkPurple();
    }

    static ITextFormatting gold()
    {
        return ITextFormattingProviderHolder.getInstance().provideGold();
    }

    static ITextFormatting gray()
    {
        return ITextFormattingProviderHolder.getInstance().provideGray();
    }

    static ITextFormatting darkGray()
    {
        return ITextFormattingProviderHolder.getInstance().provideDarkGray();
    }

    static ITextFormatting blue()
    {
        return ITextFormattingProviderHolder.getInstance().provideBlue();
    }

    static ITextFormatting green()
    {
        return ITextFormattingProviderHolder.getInstance().provideGreen();
    }

    static ITextFormatting aqua()
    {
        return ITextFormattingProviderHolder.getInstance().provideAqua();
    }

    static ITextFormatting red()
    {
        return ITextFormattingProviderHolder.getInstance().provideRed();
    }

    static ITextFormatting lightPurple()
    {
        return ITextFormattingProviderHolder.getInstance().provideLightPurple();
    }

    static ITextFormatting yellow()
    {
        return ITextFormattingProviderHolder.getInstance().provideYellow();
    }

    static ITextFormatting white()
    {
        return ITextFormattingProviderHolder.getInstance().provideWhite();
    }

    static ITextFormatting obsfuscated()
    {
        return ITextFormattingProviderHolder.getInstance().provideObsfuscated();
    }

    static ITextFormatting bold()
    {
        return ITextFormattingProviderHolder.getInstance().provideBold();
    }

    static ITextFormatting strikethrough()
    {
        return ITextFormattingProviderHolder.getInstance().provideStrikethrough();
    }

    static ITextFormatting underline()
    {
        return ITextFormattingProviderHolder.getInstance().provideUnderline();
    }

    static ITextFormatting italic()
    {
        return ITextFormattingProviderHolder.getInstance().provideItalic();
    }

    static ITextFormatting reset()
    {
        return ITextFormattingProviderHolder.getInstance().provideReset();
    }
}
