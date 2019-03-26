package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.stream.nonnulllist;

import net.minecraft.util.NonNullList;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class NonNullListCollector
{

    private NonNullListCollector()
    {
        throw new IllegalStateException("Tried to create utility class: NonNullListCollector");
    }

    public static <T>
    Collector<T, ?, NonNullList<T>> toList() {
        return new Collector<T, NonNullList<T>, NonNullList<T>>()
          {
            @Override
            public Supplier<NonNullList<T>> supplier()
            {
                return NonNullList::create;
            }

            @Override
            public BiConsumer<NonNullList<T>, T> accumulator()
            {
                return List::add;
            }

            @Override
            public BinaryOperator<NonNullList<T>> combiner()
            {
                return (left, right) -> {
                    left.addAll(right);
                    return left;
                };
            }

            @Override
            public Function<NonNullList<T>, NonNullList<T>> finisher()
            {
                return i -> (NonNullList<T>) i;
            }

            @Override
            public Set<Characteristics> characteristics()
            {
                return Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));
            }
        };
    }
}
