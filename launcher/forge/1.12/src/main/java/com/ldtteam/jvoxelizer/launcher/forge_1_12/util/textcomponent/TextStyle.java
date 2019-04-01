package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.textcomponent;

import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.textcomponent.event.ClickEvent;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.textcomponent.event.HoverEvent;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.textformatting.TextFormatting;
import com.ldtteam.jvoxelizer.util.textcomponent.ITextStyle;
import com.ldtteam.jvoxelizer.util.textcomponent.event.IClickEvent;
import com.ldtteam.jvoxelizer.util.textcomponent.event.IHoverEvent;
import com.ldtteam.jvoxelizer.util.textformatting.ITextFormatting;
import net.minecraft.util.text.Style;

public class TextStyle implements ITextStyle
{
    private final Style forgeStyle;

    private TextStyle(final Style style)
    {
        this.forgeStyle = style;
    }

    /**
     * Gets the effective color of this ChatStyle.
     */
    @Override
    public ITextFormatting getColor()
    {
        return TextFormatting.fromForge(forgeStyle.getColor());
    }

    /**
     * Whether or not text of this ChatStyle should be in bold.
     */
    @Override
    public boolean getBold()
    {
        return forgeStyle.getBold();
    }

    /**
     * Whether or not text of this ChatStyle should be italicized.
     */
    @Override
    public boolean getItalic()
    {
        return forgeStyle.getItalic();
    }

    /**
     * Whether or not to format text of this ChatStyle using strikethrough.
     */
    @Override
    public boolean getStrikethrough()
    {
        return forgeStyle.getStrikethrough();
    }

    /**
     * Whether or not text of this ChatStyle should be underlined.
     */
    @Override
    public boolean getUnderlined()
    {
        return forgeStyle.getUnderlined();
    }

    /**
     * Whether or not text of this ChatStyle should be obfuscated.
     */
    @Override
    public boolean getObfuscated()
    {
        return forgeStyle.getObfuscated();
    }

    /**
     * Whether or not this style is empty (inherits everything from the parent).
     */
    @Override
    public boolean isEmpty()
    {
        return forgeStyle.isEmpty();
    }

    /**
     * The effective chat click event.
     */
    @Override
    public IClickEvent getClickEvent()
    {
        return ClickEvent.fromForge(forgeStyle.getClickEvent());
    }

    /**
     * The effective chat hover event.
     */
    @Override
    public IHoverEvent getHoverEvent()
    {
        return HoverEvent.fromForge(forgeStyle.getHoverEvent());
    }

    /**
     * Get the text to be inserted into Chat when the component is shift-clicked
     */
    @Override
    public String getInsertion()
    {
        return forgeStyle.getInsertion();
    }

    /**
     * Sets the color for this ChatStyle to the given value.  Only use color values for this; set other values using the
     * specific methods.
     */
    @Override
    public ITextStyle setColor(final ITextFormatting color)
    {
        forgeStyle.setColor(TextFormatting.asForge(color));
        return this;
    }

    /**
     * Sets whether or not text of this ChatStyle should be in bold.  Set to false if, e.g., the parent style is bold
     * and you want text of this style to be unbolded.
     */
    @Override
    public ITextStyle setBold(final Boolean boldIn)
    {
        forgeStyle.setBold(boldIn);
        return this;
    }

    /**
     * Sets whether or not text of this ChatStyle should be italicized.  Set to false if, e.g., the parent style is
     * italicized and you want to override that for this style.
     */
    @Override
    public ITextStyle setItalic(final Boolean italic)
    {
        forgeStyle.setItalic(italic);
        return this;
    }

    /**
     * Sets whether or not to format text of this ChatStyle using strikethrough.  Set to false if, e.g., the parent
     * style uses strikethrough and you want to override that for this style.
     */
    @Override
    public ITextStyle setStrikethrough(final Boolean strikethrough)
    {
        forgeStyle.setStrikethrough(strikethrough);
        return this;
    }

    /**
     * Sets whether or not text of this ChatStyle should be underlined.  Set to false if, e.g., the parent style is
     * underlined and you want to override that for this style.
     */
    @Override
    public ITextStyle setUnderlined(final Boolean underlined)
    {
        forgeStyle.setUnderlined(underlined);
        return this;
    }

    /**
     * Sets whether or not text of this ChatStyle should be obfuscated.  Set to false if, e.g., the parent style is
     * obfuscated and you want to override that for this style.
     */
    @Override
    public ITextStyle setObfuscated(final Boolean obfuscated)
    {
        forgeStyle.setObfuscated(obfuscated);
        return this;
    }

    /**
     * Sets the event that should be run when text of this ChatStyle is clicked on.
     */
    @Override
    public ITextStyle setClickEvent(final IClickEvent event)
    {

        forgeStyle.setClickEvent(ClickEvent.asForge(event));
        return this;
    }

    /**
     * Sets the event that should be run when text of this ChatStyle is hovered over.
     */
    @Override
    public ITextStyle setHoverEvent(final IHoverEvent event)
    {
        forgeStyle.setHoverEvent(HoverEvent.asForge(event));
        return this;
    }

    /**
     * Set a text to be inserted into Chat when the component is shift-clicked
     */
    @Override
    public ITextStyle setInsertion(final String insertion)
    {
        forgeStyle.setInsertion(insertion);
        return this;
    }

    /**
     * Sets the fallback ChatStyle to use if this ChatStyle does not override some value.  Without a parent, obvious
     * defaults are used (bold: false, underlined: false, etc).
     */
    @Override
    public ITextStyle setParentStyle(final ITextStyle parent)
    {
        forgeStyle.setParentStyle(TextStyle.asForge(parent));
        return this;
    }

    /**
     * Gets the equivilent text formatting code(s) for this style, including all needed section sign characters.
     *
     * @return A formatted string that can be combined with text to produce this style.
     */
    @Override
    public String getFormattingCode()
    {
        return forgeStyle.getFormattingCode();
    }

    /**
     * Creates a shallow copy of this style.  Changes to this instance's values will not be reflected in the copy, but
     * changes to the parent style's values WILL be reflected in both this instance and the copy, wherever either does
     * not override a value.
     */
    @Override
    public ITextStyle createShallowCopy()
    {
        return new TextStyle(forgeStyle.createShallowCopy());
    }

    /**
     * Creates a deep copy of this style.  No changes to this instance or its parent style will be reflected in the
     * copy.
     */
    @Override
    public ITextStyle createDeepCopy()
    {
        return new TextStyle(forgeStyle.createDeepCopy());
    }

    public static Style asForge(ITextStyle style)
    {
        if (style instanceof Style)
        {
            return (Style) style;
        }

        return ((TextStyle) style).forgeStyle;
    }

    public static ITextStyle fromForge(Style style)
    {
        if (style instanceof ITextStyle)
        {
            return (ITextStyle) style;
        }

        return new TextStyle(style);
    }
}
