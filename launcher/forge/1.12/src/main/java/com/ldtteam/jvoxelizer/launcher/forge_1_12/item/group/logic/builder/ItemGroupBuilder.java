package com.ldtteam.jvoxelizer.launcher.forge_1_12.item.group.logic.builder;

import com.ldtteam.jvoxelizer.item.group.IItemGroup;
import com.ldtteam.jvoxelizer.item.group.logic.builder.AbstractItemGroupBuilder;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.group.JVoxItemGroup;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.group.logic.pipeline.ForgeItemGroupPipeline;

public class ItemGroupBuilder<I> extends AbstractItemGroupBuilder<ItemGroupBuilder<I>, I, IItemGroup<I>>
{
    private final int index;
    private final String label;

    public ItemGroupBuilder(final String label)
    {
        this.index = -1;
        this.label = label;
    }

    public ItemGroupBuilder(final int index, final String label) {
        this.index = index;
        this.label = label;
    }

    @Override
    public IItemGroup<I> build(final I context)
    {
        final ForgeItemGroupPipeline<IItemGroup<I>, I> pipeline = new ForgeItemGroupPipeline<>(
          this.IsAlignedRightPipeline,
          this.GetTabIndexPipeline,
          this.GetTabLabelPipeline,
          this.SetBackgroundImageNamePipeline,
          this.GetTranslatedTabLabelPipeline,
          this.GetLabelColorPipeline,
          this.GetSearchbarWidthPipeline,
          this.ShouldHidePlayerInventoryPipeline,
          this.HasSearchBarPipeline,
          this.DisplayAllRelevantItemsPipeline,
          this.HasRelevantEnchantmentTypePipeline,
          this.SetNoScrollbarPipeline,
          this.SetNoTitlePipeline,
          this.GetBackgroundImageNamePipeline,
          this.SetRelevantEnchantmentTypesPipeline,
          this.GetIconItemStackPipeline,
          this.GetBackgroundImagePipeline,
          this.GetTabIconItemPipeline,
          this.IsTabInFirstRowPipeline,
          this.DrawInForegroundOfTabPipeline,
          this.GetRelevantEnchantmentTypesPipeline,
          this.GetTabColumnPipeline,
          this.GetTabPagePipeline
        );

        if (index == -1)
            return new JVoxItemGroup<>(label, context, pipeline);

        return new JVoxItemGroup<>(index, label, context, pipeline);
    }
}
