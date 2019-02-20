package com.ldtteam.jvoxelizer.util.textcomponent;

import com.ldtteam.jvoxelizer.util.textcomponent.event.IClickEvent;
import com.ldtteam.jvoxelizer.util.textcomponent.event.IHoverEvent;
import com.ldtteam.jvoxelizer.util.textformatting.ITextFormatting;

public interface ITextStyle
{
    /**
     * Gets the effective color of this ChatStyle.
     */
    ITextFormatting getColor();

    /**
     * Whether or not text of this ChatStyle should be in bold.
     */
    boolean getBold();

    /**
     * Whether or not text of this ChatStyle should be italicized.
     */
    boolean getItalic();

    /**
     * Whether or not to format text of this ChatStyle using strikethrough.
     */
    boolean getStrikethrough();

    /**
     * Whether or not text of this ChatStyle should be underlined.
     */
    boolean getUnderlined();

    /**
     * Whether or not text of this ChatStyle should be obfuscated.
     */
    boolean getObfuscated();

    /**
     * Whether or not this style is empty (inherits everything from the parent).
     */
    boolean isEmpty();

    /**
     * The effective chat click event.
     */
    IClickEvent getClickEvent();

    /**
     * The effective chat hover event.
     */
    IHoverEvent getHoverEvent();

    /**
     * Get the text to be inserted into Chat when the component is shift-clicked
     */
    String getInsertion();

    /**
     * Sets the color for this ChatStyle to the given value.  Only use color values for this; set other values using the
     * specific methods.
     */
    ITextStyle setColor(ITextFormatting color);

    /**
     * Sets whether or not text of this ChatStyle should be in bold.  Set to false if, e.g., the parent style is bold
     * and you want text of this style to be unbolded.
     */
    ITextStyle setBold(Boolean boldIn);

    /**
     * Sets whether or not text of this ChatStyle should be italicized.  Set to false if, e.g., the parent style is
     * italicized and you want to override that for this style.
     */
    ITextStyle setItalic(Boolean italic);

    /**
     * Sets whether or not to format text of this ChatStyle using strikethrough.  Set to false if, e.g., the parent
     * style uses strikethrough and you want to override that for this style.
     */
    ITextStyle setStrikethrough(Boolean strikethrough);

    /**
     * Sets whether or not text of this ChatStyle should be underlined.  Set to false if, e.g., the parent style is
     * underlined and you want to override that for this style.
     */
    ITextStyle setUnderlined(Boolean underlined);

    /**
     * Sets whether or not text of this ChatStyle should be obfuscated.  Set to false if, e.g., the parent style is
     * obfuscated and you want to override that for this style.
     */
    ITextStyle setObfuscated(Boolean obfuscated);

    /**
     * Sets the event that should be run when text of this ChatStyle is clicked on.
     */
    ITextStyle setClickEvent(IClickEvent event);

    /**
     * Sets the event that should be run when text of this ChatStyle is hovered over.
     */
    ITextStyle setHoverEvent(IHoverEvent event);

    /**
     * Set a text to be inserted into Chat when the component is shift-clicked
     */
    ITextStyle setInsertion(String insertion);

    /**
     * Sets the fallback ChatStyle to use if this ChatStyle does not override some value.  Without a parent, obvious
     * defaults are used (bold: false, underlined: false, etc).
     */
    ITextStyle setParentStyle(ITextStyle parent);

    /**
     * Gets the equivilent text formatting code(s) for this style, including all needed section sign characters.
     *
     * @return A formatted string that can be combined with text to produce this style.
     */
    String getFormattingCode();

    /**
     * Creates a shallow copy of this style.  Changes to this instance's values will not be reflected in the copy, but
     * changes to the parent style's values WILL be reflected in both this instance and the copy, wherever either does
     * not override a value.
     */
    ITextStyle createShallowCopy();

    /**
     * Creates a deep copy of this style.  No changes to this instance or its parent style will be reflected in the
     * copy.
     */
    ITextStyle createDeepCopy();
}
