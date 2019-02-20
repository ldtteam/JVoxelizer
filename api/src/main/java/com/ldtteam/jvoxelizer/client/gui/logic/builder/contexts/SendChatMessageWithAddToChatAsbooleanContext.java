package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class SendChatMessageWithAddToChatAsbooleanContext {

    public SendChatMessageWithAddToChatAsbooleanContext(String msg, boolean addToChat) {
        this.msg = msg;
        this.addToChat = addToChat;
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private boolean addToChat;

    public boolean getAddToChat() {
        return addToChat;
    }

    public void setAddToChat(boolean addToChat) {
        this.addToChat = addToChat;
    }
}
