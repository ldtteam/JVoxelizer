package com.ldtteam.jvoxelizer.core.logic;

import com.ldtteam.jvoxelizer.client.gui.IGui;

import java.util.List;
import java.util.function.Consumer;

public class VoidPipelineElementContext<T, G extends IInstancedObject<D>, D>
{

    private final G instance;
    private final T                                             context;
    private final List<Consumer<VoidPipelineElementContext<T, G, D>>> elements;
    private final Consumer<VoidPipelineElementContext<T, G, D>> superCallback;
    private final int                                           index;

    public VoidPipelineElementContext(
      final G instance, final T context,
      final List<Consumer<VoidPipelineElementContext<T, G, D>>> elements,
      final Consumer<VoidPipelineElementContext<T, G, D>> superCallback)
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
      final Consumer<VoidPipelineElementContext<T, G, D>> superCallback,
      final int index) {
        this.instance = instance;
        this.context = context;
        this.elements = elements;
        this.superCallback = superCallback;
        this.index = index;
    }

    public G getInstance()
    {
        return instance;
    }

    public D getInstanceData()
    {
        return getInstance().getInstanceData();
    }

    public T getContext()
    {
        return context;
    }

    public void next()
    {
        if (index == elements.size())
            return;

        elements.get(index).accept(new VoidPipelineElementContext<>(instance, context, elements, superCallback, index + 1));
    }

    public void callSuper()
    {
        superCallback.accept(this);
    }
}
