package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic;

import com.ldtteam.jvoxelizer.client.gui.IGuiScreenProvider;
import net.minecraft.client.gui.GuiScreen;

public class GuiScreenProvider implements IGuiScreenProvider
{
    private static GuiScreenProvider ourInstance = new GuiScreenProvider();

    public static GuiScreenProvider getInstance()
    {
        return ourInstance;
    }

    private GuiScreenProvider()
    {
    }

    @Override
    public boolean isShiftKeyDown()
    {
        return GuiScreen.isShiftKeyDown();
    }

    @Override
    public boolean isCtrlKeyDown()
    {
        return GuiScreen.isCtrlKeyDown();
    }

    @Override
    public void setClipboardString(final String selectedText)
    {
        GuiScreen.setClipboardString(selectedText);
    }

    @Override
    public String getClipboardString()
    {
        return GuiScreen.getClipboardString();
    }
}
