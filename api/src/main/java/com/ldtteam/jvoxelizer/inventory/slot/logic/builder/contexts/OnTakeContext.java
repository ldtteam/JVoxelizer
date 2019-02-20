package com.ldtteam.jvoxelizer.inventory.slot.logic.builder.contexts;

public class OnTakeContext {

    public OnTakeContext(EntityPlayer thePlayer, ItemStack stack) {
        this.thePlayer = thePlayer;
        this.stack = stack;
    }

    private EntityPlayer thePlayer;

    public EntityPlayer getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(EntityPlayer thePlayer) {
        this.thePlayer = thePlayer;
    }

    private ItemStack stack;

    public ItemStack getStack() {
        return stack;
    }

    public void setStack(ItemStack stack) {
        this.stack = stack;
    }
}
