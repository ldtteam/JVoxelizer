package com.ldtteam.jvoxelizer.item.group.logic.builder;

import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.group.*;
import com.ldtteam.jvoxelizer.item.group.logic.builder.contexts.*;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.ldtteam.jvoxelizer.core.logic.*;
import com.ldtteam.jvoxelizer.util.enchantmenttype.IEnchantmentType;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

public abstract class AbstractItemGroupBuilder<C extends AbstractItemGroupBuilder<C, I, O>, I, O extends IItemGroup<I>> implements IItemGroupBuilder<C, I, O>
{

    @Override
    public C IsAlignedRight(Function<TypedPipelineElementContext<IsAlignedRightContext, Boolean, O, I>, Boolean>... components) {
        this.IsAlignedRightPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<IsAlignedRightContext, Boolean, O, I>, Boolean>> IsAlignedRightPipeline = new ArrayList<>();

    @Override
    public C GetTabIndex(Function<TypedPipelineElementContext<GetTabIndexContext, Integer, O, I>, Integer>... components) {
        this.GetTabIndexPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetTabIndexContext, Integer, O, I>, Integer>> GetTabIndexPipeline = new ArrayList<>();

    @Override
    public C GetTabLabel(Function<TypedPipelineElementContext<GetTabLabelContext, String, O, I>, String>... components) {
        this.GetTabLabelPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetTabLabelContext, String, O, I>, String>> GetTabLabelPipeline = new ArrayList<>();

    @Override
    public C SetBackgroundImageName(Function<TypedPipelineElementContext<SetBackgroundImageNameContext, IItemGroup<I>, O, I>, IItemGroup<I>>... components) {
        this.SetBackgroundImageNamePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<SetBackgroundImageNameContext, IItemGroup<I>, O, I>, IItemGroup<I>>> SetBackgroundImageNamePipeline = new ArrayList<>();

    @Override
    public C GetTranslatedTabLabel(Function<TypedPipelineElementContext<GetTranslatedTabLabelContext, String, O, I>, String>... components) {
        this.GetTranslatedTabLabelPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetTranslatedTabLabelContext, String, O, I>, String>> GetTranslatedTabLabelPipeline = new ArrayList<>();

    @Override
    public C GetLabelColor(Function<TypedPipelineElementContext<GetLabelColorContext, Integer, O, I>, Integer>... components) {
        this.GetLabelColorPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetLabelColorContext, Integer, O, I>, Integer>> GetLabelColorPipeline = new ArrayList<>();

    @Override
    public C GetSearchbarWidth(Function<TypedPipelineElementContext<GetSearchbarWidthContext, Integer, O, I>, Integer>... components) {
        this.GetSearchbarWidthPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetSearchbarWidthContext, Integer, O, I>, Integer>> GetSearchbarWidthPipeline = new ArrayList<>();

    @Override
    public C ShouldHidePlayerInventory(Function<TypedPipelineElementContext<ShouldHidePlayerInventoryContext, Boolean, O, I>, Boolean>... components) {
        this.ShouldHidePlayerInventoryPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<ShouldHidePlayerInventoryContext, Boolean, O, I>, Boolean>> ShouldHidePlayerInventoryPipeline = new ArrayList<>();

    @Override
    public C HasSearchBar(Function<TypedPipelineElementContext<HasSearchBarContext, Boolean, O, I>, Boolean>... components) {
        this.HasSearchBarPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<HasSearchBarContext, Boolean, O, I>, Boolean>> HasSearchBarPipeline = new ArrayList<>();

    @Override
    public C DisplayAllRelevantItems(Consumer<VoidPipelineElementContext<DisplayAllRelevantItemsContext, O, I>>... components) {
        this.DisplayAllRelevantItemsPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<DisplayAllRelevantItemsContext, O, I>>> DisplayAllRelevantItemsPipeline = new ArrayList<>();

    @Override
    public C HasRelevantEnchantmentType(Function<TypedPipelineElementContext<HasRelevantEnchantmentTypeContext, Boolean, O, I>, Boolean>... components) {
        this.HasRelevantEnchantmentTypePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<HasRelevantEnchantmentTypeContext, Boolean, O, I>, Boolean>> HasRelevantEnchantmentTypePipeline = new ArrayList<>();

    @Override
    public C SetNoScrollbar(Function<TypedPipelineElementContext<SetNoScrollbarContext, IItemGroup<I>, O, I>, IItemGroup<I>>... components) {
        this.SetNoScrollbarPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<SetNoScrollbarContext, IItemGroup<I>, O, I>, IItemGroup<I>>> SetNoScrollbarPipeline = new ArrayList<>();

    @Override
    public C SetNoTitle(Function<TypedPipelineElementContext<SetNoTitleContext, IItemGroup<I>, O, I>, IItemGroup<I>>... components) {
        this.SetNoTitlePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<SetNoTitleContext, IItemGroup<I>, O, I>, IItemGroup<I>>> SetNoTitlePipeline = new ArrayList<>();

    @Override
    public C GetBackgroundImageName(Function<TypedPipelineElementContext<GetBackgroundImageNameContext, String, O, I>, String>... components) {
        this.GetBackgroundImageNamePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetBackgroundImageNameContext, String, O, I>, String>> GetBackgroundImageNamePipeline = new ArrayList<>();

    @Override
    public C SetRelevantEnchantmentTypes(Function<TypedPipelineElementContext<SetRelevantEnchantmentTypesContext, IItemGroup<I>, O, I>, IItemGroup<I>>... components) {
        this.SetRelevantEnchantmentTypesPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<SetRelevantEnchantmentTypesContext, IItemGroup<I>, O, I>, IItemGroup<I>>> SetRelevantEnchantmentTypesPipeline = new ArrayList<>();

    @Override
    public C GetIconItemStack(Function<TypedPipelineElementContext<GetIconItemStackContext, IItemStack, O, I>, IItemStack>... components) {
        this.GetIconItemStackPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetIconItemStackContext, IItemStack, O, I>, IItemStack>> GetIconItemStackPipeline = new ArrayList<>();

    @Override
    public C GetBackgroundImage(Function<TypedPipelineElementContext<GetBackgroundImageContext, IIdentifier, O, I>, IIdentifier>... components) {
        this.GetBackgroundImagePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetBackgroundImageContext, IIdentifier, O, I>, IIdentifier>> GetBackgroundImagePipeline = new ArrayList<>();

    @Override
    public C GetTabIconItem(Function<TypedPipelineElementContext<GetTabIconItemContext, IItemStack, O, I>, IItemStack>... components) {
        this.GetTabIconItemPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetTabIconItemContext, IItemStack, O, I>, IItemStack>> GetTabIconItemPipeline = new ArrayList<>();

    @Override
    public C IsTabInFirstRow(Function<TypedPipelineElementContext<IsTabInFirstRowContext, Boolean, O, I>, Boolean>... components) {
        this.IsTabInFirstRowPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<IsTabInFirstRowContext, Boolean, O, I>, Boolean>> IsTabInFirstRowPipeline = new ArrayList<>();

    @Override
    public C DrawInForegroundOfTab(Function<TypedPipelineElementContext<DrawInForegroundOfTabContext, Boolean, O, I>, Boolean>... components) {
        this.DrawInForegroundOfTabPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<DrawInForegroundOfTabContext, Boolean, O, I>, Boolean>> DrawInForegroundOfTabPipeline = new ArrayList<>();

    @Override
    public C GetRelevantEnchantmentTypes(Function<TypedPipelineElementContext<GetRelevantEnchantmentTypesContext, IEnchantmentType[], O, I>, IEnchantmentType[]>... components) {
        this.GetRelevantEnchantmentTypesPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetRelevantEnchantmentTypesContext, IEnchantmentType[], O, I>, IEnchantmentType[]>> GetRelevantEnchantmentTypesPipeline = new ArrayList<>();

    @Override
    public C GetTabColumn(Function<TypedPipelineElementContext<GetTabColumnContext, Integer, O, I>, Integer>... components) {
        this.GetTabColumnPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetTabColumnContext, Integer, O, I>, Integer>> GetTabColumnPipeline = new ArrayList<>();

    @Override
    public C GetTabPage(Function<TypedPipelineElementContext<GetTabPageContext, Integer, O, I>, Integer>... components) {
        this.GetTabPagePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetTabPageContext, Integer, O, I>, Integer>> GetTabPagePipeline = new ArrayList<>();
}
