package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

public class GetPropertyGetterContext {

    public GetPropertyGetterContext(IIdentifier key) {
        this.key = key;
    }

    private IIdentifier key;

    public IIdentifier getKey() {
        return key;
    }

    public void setKey(IIdentifier key) {
        this.key = key;
    }
}
