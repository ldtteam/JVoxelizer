package com.ldtteam.jvoxelizer.core.logic;

import java.util.List;
import java.util.function.Consumer;

/**
 * Pipeline component used when the method is of type void.
 *
 * @param <T> The context type.
 * @param <G> The type of the instance for which the pipeline is executed.
 * @param <D> The type if the data of which the instance carries an instance as additional data.
 */
public class VoidPipelineElementContext<T, G extends IInstancedObject<D>, D>
{

    private final G                                                                            instance;
    private final T                                                                            context;
    private final List<Consumer<VoidPipelineElementContext<T, G, D>>>                          elements;
    private final PipelineProcessor.PipelineSuperCallback<VoidPipelineElementContext<T, G, D>> superCallback;
    private final int                                                                          index;

    public VoidPipelineElementContext(
      final G instance, final T context,
      final List<Consumer<VoidPipelineElementContext<T, G, D>>> elements,
      final PipelineProcessor.PipelineSuperCallback<VoidPipelineElementContext<T, G, D>> superCallback)
    {
        this.instance = instance;
        this.context = context;
        this.elements = elements;
        this.superCallback = superCallback;
        this.index = 0;
    }

    public VoidPipelineElementContext(
      final G instance, final T context,
      final List<Consumer<VoidPipelineElementContext<T, G, D>>> elements,
      final PipelineProcessor.PipelineSuperCallback<VoidPipelineElementContext<T, G, D>> superCallback,
      final int index) {
        this.instance = instance;
        this.context = context;
        this.elements = elements;
        this.superCallback = superCallback;
        this.index = index;
    }

    /**
     * The instance for which the pipeline is executed.
     *
     * @return The instance for which the pipeline is executed.
     */
    public G getInstance()
    {
        return instance;
    }

    /**
     * The additional data carried by the instance.
     *
     * @return The additional data carried by the instance.
     */
    public D getInstanceData()
    {
        return getInstance().getInstanceData();
    }

    /**
     * The context of the pipeline.
     *
     * @return The context of the pipeline.
     */
    public T getContext()
    {
        return context;
    }

    /**
     * Calls the next component in the pipeline.
     */
    public void next()
    {
        if (index == elements.size())
            return;

        elements.get(index).accept(new VoidPipelineElementContext<>(instance, context, elements, superCallback, index + 1));
    }

    /**
     * Performs a super call for the method for which this pipeline is executed.
     * If the method is abstract an exception is thrown.
     */
    public void callSuper()
    {
        try
        {
            superCallback.apply(this);
        }
        catch (Exception e)
        {
            throw new IllegalStateException("Super exception in pipeline", e);
        }
    }
}
