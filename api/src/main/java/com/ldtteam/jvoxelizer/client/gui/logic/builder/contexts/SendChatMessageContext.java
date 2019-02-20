package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class SendChatMessageContext {

    public SendChatMessageContext(String msg) {
        this.msg = msg;
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
