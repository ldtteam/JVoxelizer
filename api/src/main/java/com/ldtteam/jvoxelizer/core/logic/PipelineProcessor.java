package com.ldtteam.jvoxelizer.core.logic;

import java.util.List;
import java.util.Optional;
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
     * @return A {@link ProcessingResult} indicating if the pipeline was executed or not.
     */
    public static <T, G extends IInstancedObject<D>, D> ProcessingResult processVoidPipeline(G instance, T context, List<Consumer<VoidPipelineElementContext<T, G, D>>> pipeline, Consumer<T> superCallCallback)
    {
        if (pipeline.isEmpty())
            return new ProcessingResult(false);

        final VoidPipelineElementContext<T,G,D> voidPipelineElementContext = new VoidPipelineElementContext<>(instance, context, pipeline, (v) -> superCallCallback.accept(v.getContext()));
        voidPipelineElementContext.next();

        return new ProcessingResult(true);
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
     * @return A {@link TypedProcessingResult} indicating if the pipeline was processes, and if so, its result.
     */
    public static <T, R, G extends IInstancedObject<D>, D> TypedProcessingResult<R> processTypedPipeline(G instance, T context, List<Function<TypedPipelineElementContext<T, R, G, D>, R>> pipeline, Function<T, R> superCallCallback)
    {
        if (pipeline.isEmpty())
            return new TypedProcessingResult<>();

        final TypedPipelineElementContext<T, R, G, D> typedPipelineElementContext = new TypedPipelineElementContext<>(instance, context, pipeline, (v) -> superCallCallback.apply(v.getContext()));
        return new TypedProcessingResult<>(typedPipelineElementContext.next());
    }

    public static class ProcessingResult
    {
        private final boolean executed;

        private ProcessingResult(final boolean executed) {this.executed = executed;}

        public boolean didExecute()
        {
            return executed;
        }
    }

    public static class TypedProcessingResult<T> extends ProcessingResult
    {
        private final T result;

        public TypedProcessingResult()
        {
            super(false);
            this.result = null;
        }

        public TypedProcessingResult(final T result) {
            super(true);
            this.result = result;
        }

        public T getResult()
        {
            if (!didExecute())
                throw new IllegalStateException("Pipeline did not process");

            return result;
        }
    }
}
