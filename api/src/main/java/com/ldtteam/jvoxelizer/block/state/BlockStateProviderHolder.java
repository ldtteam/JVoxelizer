package com.ldtteam.jvoxelizer.block.state;

class BlockStateProviderHolder implements IBlockStateProvider
{
    private static BlockStateProviderHolder ourInstance = new BlockStateProviderHolder();

    public static BlockStateProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IBlockStateProvider provider = null;

    private BlockStateProviderHolder()
    {
    }

    @Override
    public IBlockState provide()
    {
        if (provider == null) throw new IllegalStateException("BlockState provider not set");

        return provider.provide();
    }
}
