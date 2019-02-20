package com.ldtteam.jvoxelizer.util.textformatting;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class ITextFormattingProviderHolder extends AbstractHolder<ITextFormattingProvider> implements ITextFormattingProvider
{
    private static ITextFormattingProviderHolder ourInstance = new ITextFormattingProviderHolder();

    public static ITextFormattingProviderHolder getInstance()
    {
        return ourInstance;
    }

    private ITextFormattingProviderHolder()
    {
        super(ITextFormatting.class.getName());
    }

    @Override
    public ITextFormatting provideBlack()
    {
        return getProvider().provideBlack();
    }

    @Override
    public ITextFormatting provideDarkBlue()
    {
        return getProvider().provideDarkBlue();
    }

    @Override
    public ITextFormatting provideDarkGreen()
    {
        return getProvider().provideDarkGreen();
    }

    @Override
    public ITextFormatting provideDarkAqua()
    {
        return getProvider().provideDarkAqua();
    }

    @Override
    public ITextFormatting provideDarkRed()
    {
        return getProvider().provideDarkRed();
    }

    @Override
    public ITextFormatting provideDarkPurple()
    {
        return getProvider().provideDarkPurple();
    }

    @Override
    public ITextFormatting provideGold()
    {
        return getProvider().provideGold();
    }

    @Override
    public ITextFormatting provideGray()
    {
        return getProvider().provideGray();
    }

    @Override
    public ITextFormatting provideDarkGray()
    {
        return getProvider().provideDarkGray();
    }

    @Override
    public ITextFormatting provideBlue()
    {
        return getProvider().provideBlue();
    }

    @Override
    public ITextFormatting provideGreen()
    {
        return getProvider().provideGreen();
    }

    @Override
    public ITextFormatting provideAqua()
    {
        return getProvider().provideAqua();
    }

    @Override
    public ITextFormatting provideRed()
    {
        return getProvider().provideRed();
    }

    @Override
    public ITextFormatting provideLightPurple()
    {
        return getProvider().provideLightPurple();
    }

    @Override
    public ITextFormatting provideYellow()
    {
        return getProvider().provideYellow();
    }

    @Override
    public ITextFormatting provideWhite()
    {
        return getProvider().provideWhite();
    }

    @Override
    public ITextFormatting provideObsfuscated()
    {
        return getProvider().provideObsfuscated();
    }

    @Override
    public ITextFormatting provideBold()
    {
        return getProvider().provideBold();
    }

    @Override
    public ITextFormatting provideStrikethrough()
    {
        return getProvider().provideStrikethrough();
    }

    @Override
    public ITextFormatting provideUnderline()
    {
        return getProvider().provideUnderline();
    }

    @Override
    public ITextFormatting provideItalic()
    {
        return getProvider().provideItalic();
    }

    @Override
    public ITextFormatting provideReset()
    {
        return getProvider().provideReset();
    }
}