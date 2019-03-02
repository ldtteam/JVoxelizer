package com.ldtteam.jvoxelizer.core.logic;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Utility class that handles processing pipelines.
 */
public final class PipelineProcessor
{

    private PipelineProcessor()
    {
        throw new IllegalStateException("Tried to initialize: PipelineProcessor but this is a Utility class.");
    }

    /**
     * Processes a list of void pipeline components.
     *
     * @param instance The instance to process the pipeline for.
     * @param context The context with the method parameter.
     * @param pipeline The pipeline.
     * @param superCallCallback The callback, made when one of the components requires a super call.
     * @param <T> The type of the context
     * @param <G> The type of the object for which the pipeline is processes.
     * @param <D> The type of the instance data on the object.
     */
    public static <T, G extends IInstancedObject<D>, D> void processVoidPipeline(G instance, T context, List<Consumer<VoidPipelineElementContext<T, G, D>>> pipeline, PipelineSuperCallback<T> superCallCallback)
    {
        if (pipeline.isEmpty())
        {
            try
            {
                superCallCallback.apply(context);
            }
            catch (Exception e)
            {
                throw new IllegalStateException("Super exception in pipeline", e);
            }
            return;
        }

        final VoidPipelineElementContext<T,G,D> voidPipelineElementContext = new VoidPipelineElementContext<>(instance, context, pipeline, (v) -> superCallCallback.apply(v.getContext()));
        voidPipelineElementContext.next();
    }

    /**
     * Processes a list of typed pipeline components.
     *
     * @param instance THe instance to process the pipeline for.
     * @param context The context with the method parameter.
     * @param pipeline The pipeline
     * @param superCallCallback The callback, made when one of the components requires a super call.
     * @param <T> The type of the context.
     * @param <R> The type returned by the pipeline
     * @param <G> The type of the object for which the pipeline is processes.
     * @param <D> The type of the instance data on said object.
     * @return The pipelines result.
     */
    public static <T, R, G extends IInstancedObject<D>, D> R processTypedPipeline(G instance, T context, List<Function<TypedPipelineElementContext<T, R, G, D>, R>> pipeline, PipelineSuperFunction<T, R> superCallCallback)
    {
        if (pipeline.isEmpty())
        {
            try
            {
                return superCallCallback.apply(context);
            }
            catch (Exception e)
            {
                throw new IllegalStateException("Super exception in pipeline", e);
            }
        }

        final TypedPipelineElementContext<T, R, G, D> typedPipelineElementContext = new TypedPipelineElementContext<>(instance, context, pipeline, (v) -> superCallCallback.apply(v.getContext()));
        return typedPipelineElementContext.next();
    }

    @FunctionalInterface
    public interface PipelineSuperCallback<T>
    {
        void apply(T value) throws Exception;
    }

    @FunctionalInterface
    public interface PipelineSuperFunction<T, R>
    {
        R apply(T value) throws Exception;
    }
}
