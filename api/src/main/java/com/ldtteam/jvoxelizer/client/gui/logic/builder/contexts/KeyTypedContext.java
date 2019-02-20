package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class KeyTypedContext {

    public KeyTypedContext(char typedChar, int keyCode) {
        this.typedChar = typedChar;
        this.keyCode = keyCode;
    }

    private char typedChar;

    public char getTypedChar() {
        return typedChar;
    }

    public void setTypedChar(char typedChar) {
        this.typedChar = typedChar;
    }

    private int keyCode;

    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }
}
