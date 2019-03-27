package com.ldtteam.jvoxelizer.client.gui;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IGuiScreenProviderHolder extends AbstractHolder<IGuiScreenProvider> implements IGuiScreenProvider
{
    private static IGuiScreenProviderHolder ourInstance = new IGuiScreenProviderHolder();

    public static IGuiScreenProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IGuiScreenProviderHolder()
    {
        super(IGuiScreen.class.getName());
    }

    @Override
    public boolean isShiftKeyDown()
    {
        return getProvider().isShiftKeyDown();
    }

    @Override
    public boolean isCtrlKeyDown()
    {
        return getProvider().isCtrlKeyDown();
    }

    @Override
    public void setClipboardString(final String selectedText)
    {
        getProvider().setClipboardString(selectedText);
    }

    @Override
    public String getClipboardString()
    {
        return getProvider().getClipboardString();
    }
}