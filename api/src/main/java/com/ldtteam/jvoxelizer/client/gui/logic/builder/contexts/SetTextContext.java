package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class SetTextContext {

    public SetTextContext(String newChatText, boolean shouldOverwrite) {
        this.newChatText = newChatText;
        this.shouldOverwrite = shouldOverwrite;
    }

    private String newChatText;

    public String getNewChatText() {
        return newChatText;
    }

    public void setNewChatText(String newChatText) {
        this.newChatText = newChatText;
    }

    private boolean shouldOverwrite;

    public boolean getShouldOverwrite() {
        return shouldOverwrite;
    }

    public void setShouldOverwrite(boolean shouldOverwrite) {
        this.shouldOverwrite = shouldOverwrite;
    }
}
