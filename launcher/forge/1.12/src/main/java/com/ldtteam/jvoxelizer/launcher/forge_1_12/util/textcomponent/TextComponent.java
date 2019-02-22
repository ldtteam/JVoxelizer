package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.textcomponent;

import com.ldtteam.jvoxelizer.util.textcomponent.ITextComponent;
import com.ldtteam.jvoxelizer.util.textcomponent.ITextStyle;

import java.util.Iterator;
import java.util.List;

public class TextComponent implements ITextComponent {
    private net.minecraft.util.text.ITextComponent forgeTextComponent;

    public TextComponent(net.minecraft.util.text.ITextComponent forgeTextComponent) {
        this.forgeTextComponent = forgeTextComponent;
    }

    @Override
    public ITextComponent setStyle(ITextStyle style) {
        return new TextComponent(forgeTextComponent.setStyle());
    }

    @Override
    public ITextStyle getStyle() {
        return new TextComponent(forgeTextComponent.getStyle());
    }

    @Override
    public ITextComponent appendText(String text) {
        return new ITextComponent(forgeTextComponent.appendText());
    }

    @Override
    public ITextComponent appendSibling(ITextComponent component) {
        return new TextComponent(forgeTextComponent.appendSibling());
    }

    @Override
    public String getUnformattedComponentText() {
        return forgeTextComponent.getUnformattedComponentText();
    }

    @Override
    public String getUnformattedText() {
        return forgeTextComponent.getFormattedText();
    }

    @Override
    public String getFormattedText() {
        return forgeTextComponent.getFormattedText();
    }

    @Override
    public List<ITextComponent> getSiblings() {
        return forgeTextComponent.getSiblings();
    }

    @Override
    public ITextComponent createCopy() {
        return new TextComponent(forgeTextComponent.createCopy());
    }

    @Override
    public Iterator<ITextComponent> iterator() {
        return forgeTextComponent.iterator();
    }
}
