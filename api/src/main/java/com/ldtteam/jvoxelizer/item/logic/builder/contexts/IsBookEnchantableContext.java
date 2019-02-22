package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.IItemStack;

public class IsBookEnchantableContext {

    public IsBookEnchantableContext(IItemStack stack, IItemStack book) {
        this.stack = stack;
        this.book = book;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }

    private IItemStack book;

    public IItemStack getBook() {
        return book;
    }

    public void setBook(IItemStack book) {
        this.book = book;
    }
}
