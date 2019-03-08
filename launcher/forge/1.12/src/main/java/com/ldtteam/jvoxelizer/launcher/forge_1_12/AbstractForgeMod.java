package com.ldtteam.jvoxelizer.launcher.forge_1_12;

import com.ldtteam.jvoxelizer.biome.IBiome;
import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.client.gui.IGuiContainer;
import com.ldtteam.jvoxelizer.client.gui.IGuiScreen;
import com.ldtteam.jvoxelizer.client.gui.IScaledResolution;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.IGuiBuilder;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.IGuiButtonBuilder;
import com.ldtteam.jvoxelizer.client.mouse.IMouse;
import com.ldtteam.jvoxelizer.client.renderer.opengl.IOpenGl;
import com.ldtteam.jvoxelizer.client.renderer.opengl.util.vertexformat.IVertexFormat;
import com.ldtteam.jvoxelizer.client.renderer.tessellator.ITessellator;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISpriteMap;
import com.ldtteam.jvoxelizer.common.capability.ICapability;
import com.ldtteam.jvoxelizer.common.gameevent.event.player.IPlayerEvent;
import com.ldtteam.jvoxelizer.core.provider.holder.ProviderResolver;
import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.dimension.logic.builder.IDimensionReaderBuilder;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.biome.BiomeProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.block.state.BlockStateProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.ScaledResolutionProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.builder.provider.GuiBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.builder.provider.GuiButtonBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.builder.provider.GuiContainerBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.builder.provider.GuiScreenBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.mouse.MouseProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.opengl.OpenGlProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.opengl.vertexformat.VertexFormatProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.tessellator.Tessellator;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.tessellator.TessellatorProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.texture.SpriteMapProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.common.animation.CapabilityLogicProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.common.gameevent.event.player.PlayerEventProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.DimensionProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.logic.builder.provider.DimensionReaderBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.distribution.DistributionProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt.NBTProvider;
import com.ldtteam.jvoxelizer.util.distribution.IDistribution;
import com.ldtteam.jvoxelizer.util.nbt.INBTBase;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.security.Provider;

public abstract class AbstractForgeMod
{

    private Logger logger;

    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        logger.info("Initializing JVoxelizer.");

        registerProviders();
    }

    private void registerProviders()
    {
        registerInternalProviders();
        registerModProviders();
    }

    private void registerInternalProviders()
    {
        //Biome
        ProviderResolver.getInstance().registerProvider(IBiome.class.getName(), BiomeProvider.getInstance());

        //Block
        ProviderResolver.getInstance().registerProvider(IBlockState.class.getName(), BlockStateProvider.getInstance());

        //Client
        ProviderResolver.getInstance().registerProvider(IGuiBuilder.class.getName(), GuiBuilderProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IGuiButtonBuilder.class.getName(), GuiButtonBuilderProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IGuiScreen.class.getName(), GuiScreenBuilderProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IGuiContainer.class.getName(), GuiContainerBuilderProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IScaledResolution.class.getName(), ScaledResolutionProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IMouse.class.getName(), MouseProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IVertexFormat.class.getName(), VertexFormatProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IOpenGl.class.getName(), OpenGlProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(ITessellator.class.getName(), TessellatorProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(ISpriteMap.class.getName(), SpriteMapProvider.getInstance());

        //Common
        ProviderResolver.getInstance().registerProvider(ICapability.class.getName(), CapabilityLogicProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IPlayerEvent.class.getName(), PlayerEventProvider.getInstance());

        //Dimension
        ProviderResolver.getInstance().registerProvider(IDimensionReaderBuilder.class.getName(), DimensionReaderBuilderProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IDimension.class.getName(), DimensionProvider.getInstance());

        //Util
        ProviderResolver.getInstance().registerProvider(IDistribution.class.getName(), DistributionProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(INBTBase.class.getName(), NBTProvider.getInstance());
    }

    protected abstract void registerModProviders();


}
