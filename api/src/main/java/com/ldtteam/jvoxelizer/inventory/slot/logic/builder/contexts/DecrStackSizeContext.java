package com.ldtteam.jvoxelizer.inventory.slot.logic.builder.contexts;

public class DecrStackSizeContext {

    public DecrStackSizeContext(int amount) {
        this.amount = amount;
    }

    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
