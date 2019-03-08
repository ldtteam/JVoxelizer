package com.ldtteam.jvoxelizer.core.logic;

import com.ldtteam.jvoxelizer.client.gui.IGui;

import java.util.List;
import java.util.function.Function;

/**
 * Pipeline component used when the pipeline returns an object.
 *
 * @param <T> The type of the context.
 * @param <R> The type returned by the pipeline.
 * @param <O> THe instance for which the pipeline is executed.
 * @param <I> THe type of the data carried by the instance.
 */
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

    /**
     * The instance that the pipeline is executed for.
     *
     * @return The instance that the pipeline is executed for.
     */
    public O getInstance()
    {
        return instance;
    }

    /**
     * The additional data that the instance carries.
     *
     * @return The additional data that the instance carries.
     */
    public I getInstanceData()
    {
        return getInstance().getInstanceData();
    }

    /**
     * The pipeline context.
     * Gives access to the current parameters of the method for which the pipeline is executed and their values.
     *
     * @return The pipeline context.
     */
    public T getContext()
    {
        return context;
    }

    /**
     * Calls the next method in the pipeline if available.
     * If no method exists in the pipeline, null is returned.
     *
     * @return The result of the next method in the pipeline, or null.
     */
    public R next()
    {
        if (index == elements.size())
            return null;

        return elements.get(index).apply(new TypedPipelineElementContext<>(instance, context, elements, superCallback, index + 1));
    }

    /**
     * Used to call the super of the method for which the pipeline is executed.
     * If the pipeline is executed for an abstract method it will throw an exception.
     *
     * @return The result of the super call.
     */
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
