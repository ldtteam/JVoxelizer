package com.ldtteam.jvoxelizer.launcher.forge_1_13.item.group.logic.pipeline;

import com.ldtteam.jvoxelizer.core.logic.TypedPipelineElementContext;
import com.ldtteam.jvoxelizer.core.logic.VoidPipelineElementContext;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.group.IItemGroup;
import com.ldtteam.jvoxelizer.item.group.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.util.enchantmenttype.IEnchantmentType;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ForgeItemGroupPipeline<O extends IItemGroup<I>, I>
{
    private final List<Function<TypedPipelineElementContext<IsAlignedRightContext, Boolean, O, I>, Boolean>> IsAlignedRightPipeline;

    private final List<Function<TypedPipelineElementContext<GetTabIndexContext, Integer, O, I>, Integer>> GetTabIndexPipeline;

    private final List<Function<TypedPipelineElementContext<GetTabLabelContext, String, O, I>, String>> GetTabLabelPipeline;

    private final List<Function<TypedPipelineElementContext<SetBackgroundImageNameContext, IItemGroup<I>, O, I>, IItemGroup<I>>> SetBackgroundImageNamePipeline;

    private final List<Function<TypedPipelineElementContext<GetTranslatedTabLabelContext, String, O, I>, String>> GetTranslatedTabLabelPipeline;

    private final List<Function<TypedPipelineElementContext<GetSearchbarWidthContext, Integer, O, I>, Integer>> GetSearchbarWidthPipeline;

    private final List<Function<TypedPipelineElementContext<ShouldHidePlayerInventoryContext, Boolean, O, I>, Boolean>> ShouldHidePlayerInventoryPipeline;

    private final List<Function<TypedPipelineElementContext<HasSearchBarContext, Boolean, O, I>, Boolean>> HasSearchBarPipeline;

    private final List<Consumer<VoidPipelineElementContext<DisplayAllRelevantItemsContext, O, I>>> DisplayAllRelevantItemsPipeline;

    private final List<Function<TypedPipelineElementContext<HasRelevantEnchantmentTypeContext, Boolean, O, I>, Boolean>> HasRelevantEnchantmentTypePipeline;

    private final List<Function<TypedPipelineElementContext<SetNoScrollbarContext, IItemGroup<I>, O, I>, IItemGroup<I>>> SetNoScrollbarPipeline;

    private final List<Function<TypedPipelineElementContext<SetNoTitleContext, IItemGroup<I>, O, I>, IItemGroup<I>>> SetNoTitlePipeline;

    private final List<Function<TypedPipelineElementContext<GetBackgroundImageNameContext, String, O, I>, String>> GetBackgroundImageNamePipeline;

    private final List<Function<TypedPipelineElementContext<SetRelevantEnchantmentTypesContext, IItemGroup<I>, O, I>, IItemGroup<I>>> SetRelevantEnchantmentTypesPipeline;

    private final List<Function<TypedPipelineElementContext<GetIconItemStackContext, IItemStack, O, I>, IItemStack>> GetIconItemStackPipeline;

    private final List<Function<TypedPipelineElementContext<GetBackgroundImageContext, IIdentifier, O, I>, IIdentifier>> GetBackgroundImagePipeline;

    private final List<Function<TypedPipelineElementContext<GetTabIconItemContext, IItemStack, O, I>, IItemStack>> GetTabIconItemPipeline;

    private final List<Function<TypedPipelineElementContext<IsTabInFirstRowContext, Boolean, O, I>, Boolean>> IsTabInFirstRowPipeline;

    private final List<Function<TypedPipelineElementContext<DrawInForegroundOfTabContext, Boolean, O, I>, Boolean>> DrawInForegroundOfTabPipeline;

    private final List<Function<TypedPipelineElementContext<GetRelevantEnchantmentTypesContext, IEnchantmentType[], O, I>, IEnchantmentType[]>> GetRelevantEnchantmentTypesPipeline;

    private final List<Function<TypedPipelineElementContext<GetTabColumnContext, Integer, O, I>, Integer>> GetTabColumnPipeline;

    private final List<Function<TypedPipelineElementContext<GetTabPageContext, Integer, O, I>, Integer>> GetTabPagePipeline;

    public ForgeItemGroupPipeline(
      final List<Function<TypedPipelineElementContext<IsAlignedRightContext, Boolean, O, I>, Boolean>> isAlignedRightPipeline,
      final List<Function<TypedPipelineElementContext<GetTabIndexContext, Integer, O, I>, Integer>> getTabIndexPipeline,
      final List<Function<TypedPipelineElementContext<GetTabLabelContext, String, O, I>, String>> getTabLabelPipeline,
      final List<Function<TypedPipelineElementContext<SetBackgroundImageNameContext, IItemGroup<I>, O, I>, IItemGroup<I>>> setBackgroundImageNamePipeline,
      final List<Function<TypedPipelineElementContext<GetTranslatedTabLabelContext, String, O, I>, String>> getTranslatedTabLabelPipeline,
      final List<Function<TypedPipelineElementContext<GetSearchbarWidthContext, Integer, O, I>, Integer>> getSearchbarWidthPipeline,
      final List<Function<TypedPipelineElementContext<ShouldHidePlayerInventoryContext, Boolean, O, I>, Boolean>> shouldHidePlayerInventoryPipeline,
      final List<Function<TypedPipelineElementContext<HasSearchBarContext, Boolean, O, I>, Boolean>> hasSearchBarPipeline,
      final List<Consumer<VoidPipelineElementContext<DisplayAllRelevantItemsContext, O, I>>> displayAllRelevantItemsPipeline,
      final List<Function<TypedPipelineElementContext<HasRelevantEnchantmentTypeContext, Boolean, O, I>, Boolean>> hasRelevantEnchantmentTypePipeline,
      final List<Function<TypedPipelineElementContext<SetNoScrollbarContext, IItemGroup<I>, O, I>, IItemGroup<I>>> setNoScrollbarPipeline,
      final List<Function<TypedPipelineElementContext<SetNoTitleContext, IItemGroup<I>, O, I>, IItemGroup<I>>> setNoTitlePipeline,
      final List<Function<TypedPipelineElementContext<GetBackgroundImageNameContext, String, O, I>, String>> getBackgroundImageNamePipeline,
      final List<Function<TypedPipelineElementContext<SetRelevantEnchantmentTypesContext, IItemGroup<I>, O, I>, IItemGroup<I>>> setRelevantEnchantmentTypesPipeline,
      final List<Function<TypedPipelineElementContext<GetIconItemStackContext, IItemStack, O, I>, IItemStack>> getIconItemStackPipeline,
      final List<Function<TypedPipelineElementContext<GetBackgroundImageContext, IIdentifier, O, I>, IIdentifier>> getBackgroundImagePipeline,
      final List<Function<TypedPipelineElementContext<GetTabIconItemContext, IItemStack, O, I>, IItemStack>> getTabIconItemPipeline,
      final List<Function<TypedPipelineElementContext<IsTabInFirstRowContext, Boolean, O, I>, Boolean>> isTabInFirstRowPipeline,
      final List<Function<TypedPipelineElementContext<DrawInForegroundOfTabContext, Boolean, O, I>, Boolean>> drawInForegroundOfTabPipeline,
      final List<Function<TypedPipelineElementContext<GetRelevantEnchantmentTypesContext, IEnchantmentType[], O, I>, IEnchantmentType[]>> getRelevantEnchantmentTypesPipeline,
      final List<Function<TypedPipelineElementContext<GetTabColumnContext, Integer, O, I>, Integer>> getTabColumnPipeline,
      final List<Function<TypedPipelineElementContext<GetTabPageContext, Integer, O, I>, Integer>> getTabPagePipeline)
    {
        IsAlignedRightPipeline = isAlignedRightPipeline;
        GetTabIndexPipeline = getTabIndexPipeline;
        GetTabLabelPipeline = getTabLabelPipeline;
        SetBackgroundImageNamePipeline = setBackgroundImageNamePipeline;
        GetTranslatedTabLabelPipeline = getTranslatedTabLabelPipeline;
        GetSearchbarWidthPipeline = getSearchbarWidthPipeline;
        ShouldHidePlayerInventoryPipeline = shouldHidePlayerInventoryPipeline;
        HasSearchBarPipeline = hasSearchBarPipeline;
        DisplayAllRelevantItemsPipeline = displayAllRelevantItemsPipeline;
        HasRelevantEnchantmentTypePipeline = hasRelevantEnchantmentTypePipeline;
        SetNoScrollbarPipeline = setNoScrollbarPipeline;
        SetNoTitlePipeline = setNoTitlePipeline;
        GetBackgroundImageNamePipeline = getBackgroundImageNamePipeline;
        SetRelevantEnchantmentTypesPipeline = setRelevantEnchantmentTypesPipeline;
        GetIconItemStackPipeline = getIconItemStackPipeline;
        GetBackgroundImagePipeline = getBackgroundImagePipeline;
        GetTabIconItemPipeline = getTabIconItemPipeline;
        IsTabInFirstRowPipeline = isTabInFirstRowPipeline;
        DrawInForegroundOfTabPipeline = drawInForegroundOfTabPipeline;
        GetRelevantEnchantmentTypesPipeline = getRelevantEnchantmentTypesPipeline;
        GetTabColumnPipeline = getTabColumnPipeline;
        GetTabPagePipeline = getTabPagePipeline;
    }

    public List<Function<TypedPipelineElementContext<IsAlignedRightContext, Boolean, O, I>, Boolean>> getIsAlignedRightPipeline()
    {
        return IsAlignedRightPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetTabIndexContext, Integer, O, I>, Integer>> getGetTabIndexPipeline()
    {
        return GetTabIndexPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetTabLabelContext, String, O, I>, String>> getGetTabLabelPipeline()
    {
        return GetTabLabelPipeline;
    }

    public List<Function<TypedPipelineElementContext<SetBackgroundImageNameContext, IItemGroup<I>, O, I>, IItemGroup<I>>> getSetBackgroundImageNamePipeline()
    {
        return SetBackgroundImageNamePipeline;
    }

    public List<Function<TypedPipelineElementContext<GetTranslatedTabLabelContext, String, O, I>, String>> getGetTranslatedTabLabelPipeline()
    {
        return GetTranslatedTabLabelPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetSearchbarWidthContext, Integer, O, I>, Integer>> getGetSearchbarWidthPipeline()
    {
        return GetSearchbarWidthPipeline;
    }

    public List<Function<TypedPipelineElementContext<ShouldHidePlayerInventoryContext, Boolean, O, I>, Boolean>> getShouldHidePlayerInventoryPipeline()
    {
        return ShouldHidePlayerInventoryPipeline;
    }

    public List<Function<TypedPipelineElementContext<HasSearchBarContext, Boolean, O, I>, Boolean>> getHasSearchBarPipeline()
    {
        return HasSearchBarPipeline;
    }

    public List<Consumer<VoidPipelineElementContext<DisplayAllRelevantItemsContext, O, I>>> getDisplayAllRelevantItemsPipeline()
    {
        return DisplayAllRelevantItemsPipeline;
    }

    public List<Function<TypedPipelineElementContext<HasRelevantEnchantmentTypeContext, Boolean, O, I>, Boolean>> getHasRelevantEnchantmentTypePipeline()
    {
        return HasRelevantEnchantmentTypePipeline;
    }

    public List<Function<TypedPipelineElementContext<SetNoScrollbarContext, IItemGroup<I>, O, I>, IItemGroup<I>>> getSetNoScrollbarPipeline()
    {
        return SetNoScrollbarPipeline;
    }

    public List<Function<TypedPipelineElementContext<SetNoTitleContext, IItemGroup<I>, O, I>, IItemGroup<I>>> getSetNoTitlePipeline()
    {
        return SetNoTitlePipeline;
    }

    public List<Function<TypedPipelineElementContext<GetBackgroundImageNameContext, String, O, I>, String>> getGetBackgroundImageNamePipeline()
    {
        return GetBackgroundImageNamePipeline;
    }

    public List<Function<TypedPipelineElementContext<SetRelevantEnchantmentTypesContext, IItemGroup<I>, O, I>, IItemGroup<I>>> getSetRelevantEnchantmentTypesPipeline()
    {
        return SetRelevantEnchantmentTypesPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetIconItemStackContext, IItemStack, O, I>, IItemStack>> getGetIconItemStackPipeline()
    {
        return GetIconItemStackPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetBackgroundImageContext, IIdentifier, O, I>, IIdentifier>> getGetBackgroundImagePipeline()
    {
        return GetBackgroundImagePipeline;
    }

    public List<Function<TypedPipelineElementContext<GetTabIconItemContext, IItemStack, O, I>, IItemStack>> getGetTabIconItemPipeline()
    {
        return GetTabIconItemPipeline;
    }

    public List<Function<TypedPipelineElementContext<IsTabInFirstRowContext, Boolean, O, I>, Boolean>> getIsTabInFirstRowPipeline()
    {
        return IsTabInFirstRowPipeline;
    }

    public List<Function<TypedPipelineElementContext<DrawInForegroundOfTabContext, Boolean, O, I>, Boolean>> getDrawInForegroundOfTabPipeline()
    {
        return DrawInForegroundOfTabPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetRelevantEnchantmentTypesContext, IEnchantmentType[], O, I>, IEnchantmentType[]>> getGetRelevantEnchantmentTypesPipeline()
    {
        return GetRelevantEnchantmentTypesPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetTabColumnContext, Integer, O, I>, Integer>> getGetTabColumnPipeline()
    {
        return GetTabColumnPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetTabPageContext, Integer, O, I>, Integer>> getGetTabPagePipeline()
    {
        return GetTabPagePipeline;
    }
}
