package com.ldtteam.jvoxelizer.core.logic;

import com.ldtteam.jvoxelizer.client.gui.IGui;

import java.util.List;
import java.util.function.Function;

public class TypedPipelineElementContext<T, R, O extends IInstancedObject<I>, I>
{
    private final O                                                                                   instance;
    private final T                                                                                   context;
    private final List<Function<TypedPipelineElementContext<T, R, O, I>, R>>                          elements;
    private final PipelineProcessor.PipelineSuperFunction<TypedPipelineElementContext<T, R, O, I>, R> superCallback;
    private final int                                                                                 index;

    public TypedPipelineElementContext(
      final O instance,
      final T context,
      final List<Function<TypedPipelineElementContext<T, R, O, I>, R>> elements,
      final PipelineProcessor.PipelineSuperFunction<TypedPipelineElementContext<T, R, O, I>, R> superCallback)
    {
        this.instance = instance;
        this.context = context;
        this.elements = elements;
        this.superCallback = superCallback;
        this.index = 0;
    }

    public TypedPipelineElementContext(
      final O instance,
      final T context,
      final List<Function<TypedPipelineElementContext<T, R, O, I>, R>> elements,
      final PipelineProcessor.PipelineSuperFunction<TypedPipelineElementContext<T, R, O, I>, R> superCallback,
      final int index) {
        this.instance = instance;
        this.context = context;
        this.elements = elements;
        this.superCallback = superCallback;
        this.index = index;
    }

    public O getInstance()
    {
        return instance;
    }

    public I getInstanceData()
    {
        return getInstance().getInstanceData();
    }

    public T getContext()
    {
        return context;
    }

    public R next()
    {
        if (index == elements.size())
            return null;

        return elements.get(index).apply(new TypedPipelineElementContext<>(instance, context, elements, superCallback, index + 1));
    }

    public R callSuper()
    {
        try
        {
            return superCallback.apply(this);
        }
        catch (Exception e)
        {
            throw new IllegalStateException("Super exception in pipeline", e);
        }
    }
}
