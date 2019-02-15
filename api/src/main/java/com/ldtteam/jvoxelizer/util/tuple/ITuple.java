package com.ldtteam.jvoxelizer.util.tuple;

/**
 * Represents a pair of objects.
 *
 * @param <A> The type of the first object.
 * @param <B> The type of the second.
 */
public interface ITuple<A, B>
{
    /**
     * Creates a new tuple.
     * Functions as the constructor.
     *
     * @param one The first object
     * @param two The second object.
     * @param <C> The type of the first object.
     * @param <D> The type of the second object.
     * @return a {@link ITuple} containing the two objects.
     */
    static <C, D> ITuple<C, D> create(C one, D two) {
        return TupleProviderHolder.getInstance().provide(one, two);
    }

    A getFirst();

    B getSecond();
}
