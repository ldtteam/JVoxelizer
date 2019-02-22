package com.ldtteam.jvoxelizer.inventory.logic.builder.contexts;

import com.ldtteam.jvoxelizer.inventory.IInventoryPlayer;

public class GetNextTransactionIDContext {

    public GetNextTransactionIDContext(IInventoryPlayer invPlayer) {
        this.invPlayer = invPlayer;
    }

    private IInventoryPlayer invPlayer;

    public IInventoryPlayer getInvPlayer() {
        return invPlayer;
    }

    public void setInvPlayer(IInventoryPlayer invPlayer) {
        this.invPlayer = invPlayer;
    }
}
