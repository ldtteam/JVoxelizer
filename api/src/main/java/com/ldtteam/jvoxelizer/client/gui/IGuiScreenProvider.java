package com.ldtteam.jvoxelizer.client.gui;

public interface IGuiScreenProvider
{

    boolean isShiftKeyDown();

    boolean isCtrlKeyDown();

    void setClipboardString(String selectedText);

    String getClipboardString();
}
