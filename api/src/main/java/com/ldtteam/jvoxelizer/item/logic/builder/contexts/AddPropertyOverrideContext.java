package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.IItemPropertyGetter;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

public class AddPropertyOverrideContext {

    public AddPropertyOverrideContext(IIdentifier key, IItemPropertyGetter getter) {
        this.key = key;
        this.getter = getter;
    }

    private IIdentifier key;

    public IIdentifier getKey() {
        return key;
    }

    public void setKey(IIdentifier key) {
        this.key = key;
    }

    private IItemPropertyGetter getter;

    public IItemPropertyGetter getGetter() {
        return getter;
    }

    public void setGetter(IItemPropertyGetter getter) {
        this.getter = getter;
    }
}
