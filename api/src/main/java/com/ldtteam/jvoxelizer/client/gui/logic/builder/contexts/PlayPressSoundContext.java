package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

import com.ldtteam.jvoxelizer.sound.ISoundHandler;

public class PlayPressSoundContext {

    public PlayPressSoundContext(ISoundHandler soundHandlerIn) {
        this.soundHandlerIn = soundHandlerIn;
    }

    private ISoundHandler soundHandlerIn;

    public ISoundHandler getSoundHandlerIn() {
        return soundHandlerIn;
    }

    public void setSoundHandlerIn(ISoundHandler soundHandlerIn) {
        this.soundHandlerIn = soundHandlerIn;
    }
}
