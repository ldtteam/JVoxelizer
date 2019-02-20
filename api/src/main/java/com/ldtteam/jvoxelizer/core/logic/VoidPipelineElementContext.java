package com.ldtteam.jvoxelizer.core.logic;

import java.util.List;
import java.util.function.Consumer;

public class VoidPipelineElementContext<T>
{

    private final T                                             context;
    private final List<Consumer<VoidPipelineElementContext<T>>> elements;
    private final int                                           index;

    public VoidPipelineElementContext(final T context, final List<Consumer<VoidPipelineElementContext<T>>> elements)
    {
        this.context = context;
        this.elements = elements;
        this.index = 0;
    }

    public VoidPipelineElementContext(final T context, final List<Consumer<VoidPipelineElementContext<T>>> elements, final int index) {
        this.context = context;
        this.elements = elements;
        this.index = index;
    }

    public void next()
    {
        if (index == elements.size())
            return;

        elements.get(index).accept(new VoidPipelineElementContext<>(context, elements, index + 1));
    }
}
