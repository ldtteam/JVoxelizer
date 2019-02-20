package com.ldtteam.jvoxelizer.core.logic;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class TypedPipelineElementContext<T, R>
{
    private final T                                             context;
    private final List<Function<TypedPipelineElementContext<T, R>, R>> elements;
    private final Function<TypedPipelineElementContext<T, R>, R>       superCallback;
    private final int                                           index;

    public TypedPipelineElementContext(
      final T context,
      final List<Function<TypedPipelineElementContext<T, R>, R>> elements,
      final Function<TypedPipelineElementContext<T, R>, R> superCallback)
    {
        this.context = context;
        this.elements = elements;
        this.superCallback = superCallback;
        this.index = 0;
    }

    public TypedPipelineElementContext(
      final T context,
      final List<Function<TypedPipelineElementContext<T, R>, R>> elements,
      final Function<TypedPipelineElementContext<T, R>, R> superCallback,
      final int index) {
        this.context = context;
        this.elements = elements;
        this.superCallback = superCallback;
        this.index = index;
    }

    public R next()
    {
        if (index == elements.size())
            return null;

        return elements.get(index).apply(new TypedPipelineElementContext<>(context, elements, superCallback, index + 1));
    }

    public R callSuper()
    {
        return superCallback.apply(this);
    }
}
