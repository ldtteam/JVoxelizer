package com.ldtteam.jvoxelizer.launcher.forge_1_12.proxy;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.biome.IBiome;
import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.bootstrap.IGameEngineBootstrapper;
import com.ldtteam.jvoxelizer.client.gui.IGuiScreen;
import com.ldtteam.jvoxelizer.client.gui.IScaledResolution;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.IGuiBuilder;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.IGuiButtonBuilder;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.IGuiContainerBuilder;
import com.ldtteam.jvoxelizer.client.gui.logic.builder.IGuiScreenBuilder;
import com.ldtteam.jvoxelizer.client.mouse.IMouse;
import com.ldtteam.jvoxelizer.client.renderer.opengl.IOpenGl;
import com.ldtteam.jvoxelizer.client.renderer.opengl.util.vertexformat.IVertexFormat;
import com.ldtteam.jvoxelizer.client.renderer.tessellator.ITessellator;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISpriteMap;
import com.ldtteam.jvoxelizer.common.capability.ICapability;
import com.ldtteam.jvoxelizer.common.gameevent.event.player.IPlayerEntityEvent;
import com.ldtteam.jvoxelizer.common.gameevent.event.player.IPlayerGameEvent;
import com.ldtteam.jvoxelizer.core.provider.holder.ProviderResolver;
import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.dimension.IDimensionType;
import com.ldtteam.jvoxelizer.dimension.logic.builder.IDimensionReaderBuilder;
import com.ldtteam.jvoxelizer.discovery.IJVoxModPluginDiscoverer;
import com.ldtteam.jvoxelizer.event.handler.IEventHandlerManager;
import com.ldtteam.jvoxelizer.event.manager.IEventManager;
import com.ldtteam.jvoxelizer.inventory.IContainer;
import com.ldtteam.jvoxelizer.inventory.logic.builder.IContainerBuilder;
import com.ldtteam.jvoxelizer.inventory.slot.logic.builder.ISlotBuilder;
import com.ldtteam.jvoxelizer.inventory.slot.logic.builder.ISlotItemHandlerBuilder;
import com.ldtteam.jvoxelizer.item.IItem;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.group.logic.builder.IItemGroupBuilder;
import com.ldtteam.jvoxelizer.item.handling.IItemHandler;
import com.ldtteam.jvoxelizer.item.logic.builder.IItemBuilder;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.DedicatedServerGameEngine;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.GameEngineProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.biome.BiomeProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.block.state.BlockStateProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.bootstrap.GameEngineBootstrapperProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.ScaledResolutionProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.GuiScreenProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.builder.provider.GuiBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.builder.provider.GuiButtonBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.builder.provider.GuiContainerBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.logic.builder.provider.GuiScreenBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.mouse.MouseProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.opengl.OpenGlProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.opengl.vertexformat.VertexFormatProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.tessellator.TessellatorProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.texture.SpriteMapProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.common.capability.CapabilityLogicProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.common.gameevent.event.player.PlayerEntityEventProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.common.gameevent.event.player.PlayerGameEventProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerSetupProxy;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.DimensionProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.DimensionTypeProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.logic.builder.provider.DimensionReaderBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.discovery.JVoxASMDataTableBasedPluginDiscoverer;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.event.handler.EventHandlerManagerProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.event.manager.EventManagerProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.ContainerProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.logic.builder.provider.ContainerBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.slot.logic.builder.provider.SlotBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.slot.logic.builder.provider.SlotItemHandlerBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemStackProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.group.logic.builder.provider.ItemGroupBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.handling.ItemHandlerProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.logic.builder.provider.ItemBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.modloader.ModLoaderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.endpoint.NetworkEndpointProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.utils.target.NetworkTargetPointProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.profiler.ProfilerProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.progressmanager.ProgressManagerProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.sound.SoundHandlerProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.translation.TranslatorProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.distribution.DistributionProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.distribution.executor.DistributionExecutor;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.identifier.IdentifierProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt.NBTProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.textformatting.TextFormattingProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.tuple.TupleProvider;
import com.ldtteam.jvoxelizer.modloader.IModLoader;
import com.ldtteam.jvoxelizer.networking.endpoint.INetworkEndpoint;
import com.ldtteam.jvoxelizer.networking.utils.target.INetworkTargetPoint;
import com.ldtteam.jvoxelizer.profiler.IProfiler;
import com.ldtteam.jvoxelizer.progressmanager.IProgressManager;
import com.ldtteam.jvoxelizer.sound.ISoundHandler;
import com.ldtteam.jvoxelizer.translation.ITranslator;
import com.ldtteam.jvoxelizer.util.distribution.IDistribution;
import com.ldtteam.jvoxelizer.util.distribution.executor.IDistributionExecutor;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;
import com.ldtteam.jvoxelizer.util.nbt.INBTBase;
import com.ldtteam.jvoxelizer.util.textformatting.ITextFormatting;
import com.ldtteam.jvoxelizer.util.tuple.ITuple;

public class CommonProxy implements IForgeJVoxelizerSetupProxy
{
    @Override
    public void onPreInit()
    {
        //Biome
        ProviderResolver.getInstance().registerProvider(IBiome.class.getName(), BiomeProvider.getInstance());

        //Block
        ProviderResolver.getInstance().registerProvider(IBlockState.class.getName(), BlockStateProvider.getInstance());

        //Bootstrap
        ProviderResolver.getInstance().registerProvider(IGameEngineBootstrapper.class.getName(), GameEngineBootstrapperProvider.getInstance());

        //Common
        ProviderResolver.getInstance().registerProvider(ICapability.class.getName(), CapabilityLogicProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IPlayerEntityEvent.class.getName(), PlayerEntityEventProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IPlayerGameEvent.class.getName(), PlayerGameEventProvider.getInstance());

        //Discovery
        ProviderResolver.getInstance().registerProvider(IJVoxModPluginDiscoverer.class.getName(), JVoxASMDataTableBasedPluginDiscoverer.getInstance());

        //Dimension
        ProviderResolver.getInstance().registerProvider(IDimensionReaderBuilder.class.getName(), DimensionReaderBuilderProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IDimension.class.getName(), DimensionProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IDimensionType.class.getName(), DimensionTypeProvider.getInstance());

        //Event
        ProviderResolver.getInstance().registerProvider(IEventHandlerManager.class, EventHandlerManagerProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IEventManager.class.getName(), EventManagerProvider.getInstance());

        //Inventory
        ProviderResolver.getInstance().registerProvider(IContainer.class.getName(), ContainerProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IContainerBuilder.class.getName(), ContainerBuilderProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(ISlotBuilder.class.getName(), SlotBuilderProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(ISlotItemHandlerBuilder.class.getName(), SlotItemHandlerBuilderProvider.getInstance());

        //Item
        ProviderResolver.getInstance().registerProvider(IItem.class.getName(), ItemProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IItemBuilder.class.getName(), ItemBuilderProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IItemGroupBuilder.class.getName(), ItemGroupBuilderProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IItemHandler.class.getName(), ItemHandlerProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IItemStack.class.getName(), ItemStackProvider.getInstance());

        //Modloader
        ProviderResolver.getInstance().registerProvider(IModLoader.class.getName(), ModLoaderProvider.getInstance());

        //Network
        ProviderResolver.getInstance().registerProvider(INetworkEndpoint.class.getName(), NetworkEndpointProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(INetworkTargetPoint.class.getName(), NetworkTargetPointProvider.getInstance());

        //Profiler
        ProviderResolver.getInstance().registerProvider(IProfiler.class.getName(), ProfilerProvider.getInstance());

        //ProgressManager
        ProviderResolver.getInstance().registerProvider(IProgressManager.class.getName(), ProgressManagerProvider.getInstance());

        //Sound
        ProviderResolver.getInstance().registerProvider(ISoundHandler.class.getName(), SoundHandlerProvider.getInstance());

        //Translation
        ProviderResolver.getInstance().registerProvider(ITranslator.class.getName(), TranslatorProvider.getInstance());

        //Util
        ProviderResolver.getInstance().registerProvider(IDistribution.class.getName(), DistributionProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IDistributionExecutor.class.getName(), DistributionExecutor.getInstance());
        ProviderResolver.getInstance().registerProvider(INBTBase.class.getName(), NBTProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IIdentifier.class.getName(), IdentifierProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(ITextFormatting.class.getName(), TextFormattingProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(ITuple.class.getName(), TupleProvider.getInstance());

        //JVox
        ProviderResolver.getInstance().registerProvider(IGameEngine.class.getName(), DedicatedServerGameEngine.getInstance());
    }
}
