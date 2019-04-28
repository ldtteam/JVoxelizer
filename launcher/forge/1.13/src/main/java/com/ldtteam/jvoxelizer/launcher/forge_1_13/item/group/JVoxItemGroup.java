package com.ldtteam.jvoxelizer.launcher.forge_1_13.item.group;

import com.ldtteam.jvoxelizer.core.logic.PipelineProcessor;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.group.IItemGroup;
import com.ldtteam.jvoxelizer.item.group.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.item.group.logic.pipeline.ForgeItemGroupPipeline;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.enchantmentType.EnchantmentType;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.identifier.Identifier;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.stream.nonnulllist.NonNullListCollector;
import com.ldtteam.jvoxelizer.util.enchantmenttype.IEnchantmentType;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.LanguageMap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge;
import static com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge;

public class JVoxItemGroup<I> extends net.minecraft.item.ItemGroup implements IItemGroup<I>
{

    private final I                                        instanceData;
    private final ForgeItemGroupPipeline<IItemGroup<I>, I> pipeline;

    public JVoxItemGroup(
      final String label,
      final I instanceData,
      final ForgeItemGroupPipeline<IItemGroup<I>, I> pipeline)
    {
        super(label);
        this.instanceData = instanceData;
        this.pipeline = pipeline;
    }

    public JVoxItemGroup(
      final int index,
      final String label,
      final I instanceData,
      final ForgeItemGroupPipeline<IItemGroup<I>, I> pipeline)
    {
        super(index, label);
        this.instanceData = instanceData;
        this.pipeline = pipeline;
    }

    @Override
    public int getIndex()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetTabIndexContext(),
          pipeline.getGetTabIndexPipeline(),
          (c) -> super.getIndex()
        );
    }

    @Override
    public net.minecraft.item.ItemGroup setBackgroundImageName(final String texture)
    {
        return ItemGroup.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new SetBackgroundImageNameContext(texture),
          pipeline.getSetBackgroundImageNamePipeline(),
          (c) -> ItemGroup.fromForge(super.setBackgroundImageName(c.getTexture()))
        ));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public String getTabLabel()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetTabLabelContext(),
          pipeline.getGetTabLabelPipeline(),
          (c) -> super.getTabLabel()
        );
    }

    /**
     * Gets the translated Label.
     */
    @Override
    public String getTranslatedTabLabel()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetTranslatedTabLabelContext(),
          pipeline.getGetTranslatedTabLabelPipeline(),
          (c) -> LanguageMap.getInstance().translateKey(super.getTranslationKey())
        );
    }

    @Override
    public ItemStack getIcon()
    {
        return asForge(PipelineProcessor.processTypedPipeline(
          this,
          new GetIconItemStackContext(),
          pipeline.getGetIconItemStackPipeline(),
          (c) -> fromForge(super.getIcon())
        ));
    }

    @Override
    public ItemStack createIcon()
    {
        return null;
    }

    @Override
    public String getBackgroundImageName()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetBackgroundImageNameContext(),
          pipeline.getGetBackgroundImageNamePipeline(),
          (c) -> super.getBackgroundImageName()
        );
    }

    @Override
    public boolean drawInForegroundOfTab()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new DrawInForegroundOfTabContext(),
          pipeline.getDrawInForegroundOfTabPipeline(),
          (c) -> super.drawInForegroundOfTab()
        );
    }

    @Override
    public net.minecraft.item.ItemGroup setNoTitle()
    {
        return ItemGroup.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new SetNoTitleContext(),
          pipeline.getSetNoTitlePipeline(),
          (c) -> ItemGroup.fromForge(super.setNoTitle())
        ));
    }

    @Override
    public net.minecraft.item.ItemGroup setNoScrollbar()
    {
        return ItemGroup.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new SetNoScrollbarContext(),
          pipeline.getSetNoScrollbarPipeline(),
          (c) -> ItemGroup.fromForge(super.setNoScrollbar())
        ));
    }

    /**
     * returns index % 6
     */
    @Override
    public int getColumn()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetTabColumnContext(),
          pipeline.getGetTabColumnPipeline(),
          (c) -> super.getColumn()
        );
    }

    /**
     * returns {@code tabIndex < 6}
     */
    @Override
    public boolean isOnTopRow()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsTabInFirstRowContext(),
          pipeline.getIsTabInFirstRowPipeline(),
          (c) -> super.isOnTopRow()
        );
    }

    @Override
    public boolean isAlignedRight()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsAlignedRightContext(),
          pipeline.getIsAlignedRightPipeline(),
          (c) -> super.isAlignedRight()
        );
    }

    /**
     * Returns the enchantment types relevant to this tab
     */
    @Override
    public EnumEnchantmentType[] getRelevantEnchantmentTypes()
    {
        return Arrays.stream(PipelineProcessor.processTypedPipeline(
          this,
          new GetRelevantEnchantmentTypesContext(),
          pipeline.getGetRelevantEnchantmentTypesPipeline(),
          (c) -> Arrays.stream(super.getRelevantEnchantmentTypes()).map(EnchantmentType::fromForge).toArray(IEnchantmentType[]::new)
        )).map(EnchantmentType::asForge).toArray(EnumEnchantmentType[]::new);
    }

    /**
     * Sets the enchantment types for populating this tab with enchanting books
     */
    @Override
    public net.minecraft.item.ItemGroup setRelevantEnchantmentTypes(final EnumEnchantmentType... types)
    {
        return ItemGroup.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new SetRelevantEnchantmentTypesContext(Arrays.stream(types).map(EnchantmentType::fromForge).toArray(IEnchantmentType[]::new)),
            pipeline.getSetRelevantEnchantmentTypesPipeline(),
            (c) -> ItemGroup.fromForge(super.setRelevantEnchantmentTypes(
              Arrays.stream(c.getTypes()).map(EnchantmentType::asForge).toArray(EnumEnchantmentType[]::new)
            ))
          )
        );
    }

    @Override
    public boolean hasRelevantEnchantmentType(@Nullable final EnumEnchantmentType enchantmentType)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new HasRelevantEnchantmentTypeContext(EnchantmentType.fromForge(enchantmentType)),
          pipeline.getHasRelevantEnchantmentTypePipeline(),
          (c) -> super.hasRelevantEnchantmentType(EnchantmentType.asForge(c.getEnchantmentType()))
        );
    }

    /**
     * only shows items which have tabToDisplayOn == this
     */
    @Override
    public void fill(final NonNullList<ItemStack> p_78018_1_)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new DisplayAllRelevantItemsContext(p_78018_1_.stream().map(i -> fromForge(i)).collect(Collectors.toList())),
          pipeline.getDisplayAllRelevantItemsPipeline(),
          (c) -> super.fill(
            c.getP_78018_1_().stream().map(i -> asForge(i)).collect(NonNullListCollector.toList())
          )
        );
    }

    @Override
    public int getTabPage()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetTabPageContext(),
          pipeline.getGetTabPagePipeline(),
          (c) -> super.getTabPage()
        );
    }

    /**
     * Determines if the search bar should be shown for this tab.
     *
     * @return True to show the bar
     */
    @Override
    public boolean hasSearchBar()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new HasSearchBarContext(),
          pipeline.getHasSearchBarPipeline(),
          (c) -> super.hasSearchBar()
        );
    }

    /**
     * Gets the width of the search bar of the creative tab, use this if your
     * creative tab name overflows together with a custom texture.
     *
     * @return The width of the search bar, 89 by default
     */
    @Override
    public int getSearchbarWidth()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetSearchbarWidthContext(),
          pipeline.getGetSearchbarWidthPipeline(),
          (c) -> super.getSearchbarWidth()
        );
    }

    @Override
    public ResourceLocation getBackgroundImage()
    {
        return Identifier.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new GetBackgroundImageContext(),
          pipeline.getGetBackgroundImagePipeline(),
          (c) -> Identifier.fromForge(super.getBackgroundImage())
        ));
    }

    @Override
    public int getTabIndex()
    {
        return getIndex();
    }

    @Override
    public IItemGroup<I> setBackgroundImage(final String texture)
    {
        this.setBackgroundImageName(texture);
        return this;
    }

    @Override
    public IItemStack getDisplayedStack()
    {
        return fromForge(this.getIcon());
    }

    @Override
    public IItemStack getTabStack()
    {
        return fromForge(this.getIcon());
    }

    @Override
    public IItemGroup<I> disableTitle()
    {
        this.setNoTitle();
        return this;
    }

    @Override
    public boolean shouldHidePlayerInventory()
    {
        return false;
    }

    @Override
    public IItemGroup<I> disableScrollbar()
    {
        this.setNoScrollbar();
        return this;
    }

    @Override
    public int getTabColumn()
    {
        return getColumn();
    }

    @Override
    public boolean isTabInFirstRow()
    {
        return isOnTopRow();
    }

    @Override
    public IEnchantmentType[] getPossibleEnchantmentTypes()
    {
        return Arrays.stream(this.getRelevantEnchantmentTypes()).map(EnchantmentType::fromForge).toArray(IEnchantmentType[]::new);
    }

    @Override
    public IItemGroup<I> setPossibleEnchantmentTypes(final IEnchantmentType... types)
    {
        this.setRelevantEnchantmentTypes(
          Arrays.stream(types).map(EnchantmentType::asForge).toArray(EnumEnchantmentType[]::new)
        );
        return this;
    }

    @Override
    public boolean hasPossibleEnchantmentType(final IEnchantmentType enchantmentType)
    {
        return this.hasRelevantEnchantmentType(EnchantmentType.asForge(enchantmentType));
    }

    @Override
    public void displayAllItems(final List<IItemStack> list)
    {
        this.fill(list.stream().map(i -> asForge(i)).collect(NonNullListCollector.toList()));
    }

    @Override
    public IIdentifier getBackgroundImageIdentifier()
    {
        return Identifier.fromForge(this.getBackgroundImage());
    }

    @Override
    public I getInstanceData()
    {
        return instanceData;
    }
}
