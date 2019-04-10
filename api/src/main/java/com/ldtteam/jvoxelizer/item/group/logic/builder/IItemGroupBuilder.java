package com.ldtteam.jvoxelizer.item.group.logic.builder;

import com.ldtteam.jvoxelizer.core.logic.TypedPipelineElementContext;
import com.ldtteam.jvoxelizer.core.logic.VoidPipelineElementContext;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.group.IItemGroup;
import com.ldtteam.jvoxelizer.item.group.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.util.enchantmenttype.IEnchantmentType;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

import java.util.function.Consumer;
import java.util.function.Function;

public interface IItemGroupBuilder<C extends IItemGroupBuilder<C, I, O>, I, O extends IItemGroup<I>>
{
    static <T> IItemGroupBuilder<?, T, IItemGroup<T>> create(String label)
    {
        return IItemGroupBuilderProviderHolder.getInstance().provide(label);
    }

    static <T> IItemGroupBuilder<?, T, IItemGroup<T>> create(int index, String label)
    {
        return IItemGroupBuilderProviderHolder.getInstance().provide(index, label);
    }

    C IsAlignedRight(Function<TypedPipelineElementContext<IsAlignedRightContext, Boolean, O, I>, Boolean>... components);

    C GetTabIndex(Function<TypedPipelineElementContext<GetTabIndexContext, Integer, O, I>, Integer>... components);

    C GetTabLabel(Function<TypedPipelineElementContext<GetTabLabelContext, String, O, I>, String>... components);

    C SetBackgroundImageName(Function<TypedPipelineElementContext<SetBackgroundImageNameContext, IItemGroup<I>, O, I>, IItemGroup<I>>... components);

    C GetTranslatedTabLabel(Function<TypedPipelineElementContext<GetTranslatedTabLabelContext, String, O, I>, String>... components);

    C GetSearchbarWidth(Function<TypedPipelineElementContext<GetSearchbarWidthContext, Integer, O, I>, Integer>... components);

    C ShouldHidePlayerInventory(Function<TypedPipelineElementContext<ShouldHidePlayerInventoryContext, Boolean, O, I>, Boolean>... components);

    C HasSearchBar(Function<TypedPipelineElementContext<HasSearchBarContext, Boolean, O, I>, Boolean>... components);

    C DisplayAllRelevantItems(Consumer<VoidPipelineElementContext<DisplayAllRelevantItemsContext, O, I>>... components);

    C HasRelevantEnchantmentType(Function<TypedPipelineElementContext<HasRelevantEnchantmentTypeContext, Boolean, O, I>, Boolean>... components);

    C SetNoScrollbar(Function<TypedPipelineElementContext<SetNoScrollbarContext, IItemGroup<I>, O, I>, IItemGroup<I>>... components);

    C SetNoTitle(Function<TypedPipelineElementContext<SetNoTitleContext, IItemGroup<I>, O, I>, IItemGroup<I>>... components);

    C GetBackgroundImageName(Function<TypedPipelineElementContext<GetBackgroundImageNameContext, String, O, I>, String>... components);

    C SetRelevantEnchantmentTypes(Function<TypedPipelineElementContext<SetRelevantEnchantmentTypesContext, IItemGroup<I>, O, I>, IItemGroup<I>>... components);

    C GetIconItemStack(Function<TypedPipelineElementContext<GetIconItemStackContext, IItemStack, O, I>, IItemStack>... components);

    C GetBackgroundImage(Function<TypedPipelineElementContext<GetBackgroundImageContext, IIdentifier, O, I>, IIdentifier>... components);

    C GetTabIconItem(Function<TypedPipelineElementContext<GetTabIconItemContext, IItemStack, O, I>, IItemStack>... components);

    C IsTabInFirstRow(Function<TypedPipelineElementContext<IsTabInFirstRowContext, Boolean, O, I>, Boolean>... components);

    C DrawInForegroundOfTab(Function<TypedPipelineElementContext<DrawInForegroundOfTabContext, Boolean, O, I>, Boolean>... components);

    C GetRelevantEnchantmentTypes(Function<TypedPipelineElementContext<GetRelevantEnchantmentTypesContext, IEnchantmentType[], O, I>, IEnchantmentType[]>... components);

    C GetTabColumn(Function<TypedPipelineElementContext<GetTabColumnContext, Integer, O, I>, Integer>... components);

    C GetTabPage(Function<TypedPipelineElementContext<GetTabPageContext, Integer, O, I>, Integer>... components);

    IItemGroup<I> build(I guiContext);
}
