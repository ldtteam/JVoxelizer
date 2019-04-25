package com.ldtteam.jvoxelizer.launcher.forge_1_13.proxy;

import com.ldtteam.jvoxelizer.IGameEngine;
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
import com.ldtteam.jvoxelizer.core.provider.holder.ProviderResolver;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.GameEngineProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui.ScaledResolutionProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui.logic.GuiScreenProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui.logic.builder.provider.GuiBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui.logic.builder.provider.GuiButtonBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui.logic.builder.provider.GuiContainerBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui.logic.builder.provider.GuiScreenBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.mouse.MouseProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.opengl.OpenGlProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.opengl.vertexformat.VertexFormatProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.tessellator.TessellatorProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.texture.SpriteMapProvider;

public class ClientProxy extends CommonProxy
{

    @Override
    public void onPreInit()
    {
        super.onPreInit();

        //Client
        ProviderResolver.getInstance().registerProvider(IGuiScreen.class.getName(), GuiScreenProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IGuiBuilder.class.getName(), GuiBuilderProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IGuiButtonBuilder.class.getName(), GuiButtonBuilderProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IGuiScreenBuilder.class.getName(), GuiScreenBuilderProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IGuiContainerBuilder.class.getName(), GuiContainerBuilderProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IScaledResolution.class.getName(), ScaledResolutionProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IMouse.class.getName(), MouseProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IVertexFormat.class.getName(), VertexFormatProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(IOpenGl.class.getName(), OpenGlProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(ITessellator.class.getName(), TessellatorProvider.getInstance());
        ProviderResolver.getInstance().registerProvider(ISpriteMap.class.getName(), SpriteMapProvider.getInstance());

        //JVox
        ProviderResolver.getInstance().registerProvider(IGameEngine.class.getName(), GameEngineProvider.getInstance());
    }
}
