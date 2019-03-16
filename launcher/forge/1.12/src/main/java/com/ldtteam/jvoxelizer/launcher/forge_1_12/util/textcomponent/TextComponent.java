package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.textcomponent;

import com.ldtteam.jvoxelizer.util.textcomponent.ITextComponent;
import com.ldtteam.jvoxelizer.util.textcomponent.ITextStyle;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TextComponent implements ITextComponent
{
    private net.minecraft.util.text.ITextComponent forgeTextComponent;

    private TextComponent(net.minecraft.util.text.ITextComponent forgeTextComponent)
    {
        this.forgeTextComponent = forgeTextComponent;
    }

    @Override
    public ITextComponent setStyle(ITextStyle style)
    {
        return new TextComponent(forgeTextComponent.setStyle(TextStyle.asForge(style)));
    }

    @Override
    public ITextStyle getStyle()
    {
        return TextStyle.fromForge(forgeTextComponent.getStyle());
    }

    @Override
    public ITextComponent appendText(String text)
    {
        return new TextComponent(forgeTextComponent.appendText(text));
    }

    @Override
    public ITextComponent appendSibling(ITextComponent component)
    {
        return new TextComponent(forgeTextComponent.appendSibling(((TextComponent) component).getForgeTextComponent()));
    }

    @Override
    public String getUnformattedComponentText()
    {
        return forgeTextComponent.getUnformattedComponentText();
    }

    @Override
    public String getUnformattedText()
    {
        return forgeTextComponent.getFormattedText();
    }

    @Override
    public String getFormattedText()
    {
        return forgeTextComponent.getFormattedText();
    }

    @Override
    public List<ITextComponent> getSiblings()
    {
        return forgeTextComponent.getSiblings().stream().map(TextComponent::new).collect(Collectors.toList());
    }

    @Override
    public ITextComponent createCopy()
    {
        return new TextComponent(forgeTextComponent.createCopy());
    }

    @NotNull
    @Override
    public Iterator<ITextComponent> iterator()
    {
        final Iterator<net.minecraft.util.text.ITextComponent> iterator = forgeTextComponent.iterator();

        return new Iterator<ITextComponent>()
        {
            @Override
            public boolean hasNext()
            {
                return iterator.hasNext();
            }

            @Override
            public ITextComponent next()
            {
                return new TextComponent(iterator.next());
            }
        };
    }

    public net.minecraft.util.text.ITextComponent getForgeTextComponent()
    {
        return forgeTextComponent;
    }

    public static net.minecraft.util.text.ITextComponent asForge(final ITextComponent component)
    {
        if (component instanceof net.minecraft.util.text.ITextComponent)
            return (net.minecraft.util.text.ITextComponent) component;

        return ((TextComponent) component).getForgeTextComponent();
    }

    public static ITextComponent fromForge(final net.minecraft.util.text.ITextComponent textComponent)
    {
        if (textComponent instanceof ITextComponent)
            return (ITextComponent) textComponent;

        return new TextComponent(textComponent);
    }
}
