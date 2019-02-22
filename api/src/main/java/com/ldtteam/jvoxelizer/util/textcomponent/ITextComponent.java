package com.ldtteam.jvoxelizer.util.textcomponent;

import java.util.List;

public interface ITextComponent extends Iterable<ITextComponent>
{
    /**
     * Sets the style of this component and updates the parent style of all of the sibling components.
     */
    ITextComponent setStyle(ITextStyle style);

    /**
     * Gets the style of this component. Returns a direct reference; changes to this style will modify the style of this
     * component (IE, there is no need to call {@link #setStyle(ITextStyle)} again after modifying it).
     *
     * If this component's style is currently <code>null</code>, it will be initialized to the default style, and the
     * parent style of all sibling components will be set to that style. (IE, changes to this style will also be
     * reflected in sibling components.)
     *
     * This method never returns <code>null</code>.
     */
    ITextStyle getStyle();

    /**
     * Adds a new component to the end of the sibling list, with the specified text.
     *
     * @return This component, for chaining (and not the newly added component)
     */
    ITextComponent appendText(String text);

    /**
     * Adds a new component to the end of the sibling list, setting that component's style's parent style to this
     * component's style.
     *
     * @return This component, for chaining (and not the newly added component)
     */
    ITextComponent appendSibling(ITextComponent component);

    /**
     * Gets the raw content of this component (but not its sibling components), without any formatting codes.
     */
    String getUnformattedComponentText();

    /**
     * Gets the text of this component <em>and all sibling components</em>, without any formatting codes.
     */
    String getUnformattedText();

    /**
     * Gets the text of this component <em>and all sibling components</em>, with formatting codes added for rendering.
     */
    String getFormattedText();

    /**
     * Gets the sibling components of this one.
     */
    List<ITextComponent> getSiblings();

    /**
     * Creates a copy of this component.  Almost a deep copy, except the style is shallow-copied.
     */
    ITextComponent createCopy();
}
