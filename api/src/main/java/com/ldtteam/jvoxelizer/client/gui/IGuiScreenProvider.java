package com.ldtteam.jvoxelizer.client.gui;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface IGuiScreenProvider
{

    boolean isShiftKeyDown();

    boolean isCtrlKeyDown();

    void setClipboardString(String selectedText);

    String getClipboardString();
}
