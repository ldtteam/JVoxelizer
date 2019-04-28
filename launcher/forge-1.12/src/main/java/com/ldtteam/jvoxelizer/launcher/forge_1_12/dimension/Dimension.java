package com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension;

import com.ldtteam.jvoxelizer.core.logic.DummyInstanceData;
import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.entity.IEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity;
import net.minecraft.world.World;

import java.util.List;
import java.util.stream.Collectors;

public class Dimension extends DimensionReader implements IDimension<DummyInstanceData>
{
    private final World forgeWorld;

    private Dimension(final World world)
    {
        super(world);
        this.forgeWorld = world;
    }

    @Override
    public int getId()
    {
        return forgeWorld.provider.getDimension();
    }

    @Override
    public List<IEntity> getLoadedEntities()
    {
        return forgeWorld.getLoadedEntityList().stream().map(Entity::fromForge).collect(Collectors.toList());
    }

    private World getForgeWorld()
    {
        return forgeWorld;
    }

    public static World asForge(IDimension<?> dimension)
    {
        if (dimension instanceof World)
        {
            return (World) dimension;
        }

        if (dimension == null)
        {
            return null;
        }

        if (!(dimension instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("Dimension is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) dimension).getForgeInstance();
    }

    public static IDimension<?> fromForge(World world)
    {
        if (world instanceof IDimension)
        {
            return (IDimension<?>) world;
        }

        return new Dimension(world);
    }
}
