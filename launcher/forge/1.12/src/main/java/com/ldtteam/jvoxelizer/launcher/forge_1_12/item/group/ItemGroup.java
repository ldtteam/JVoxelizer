package com.ldtteam.jvoxelizer.launcher.forge_1_12.item.group;

import com.ldtteam.jvoxelizer.core.logic.DummyInstanceData;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.group.IItemGroup;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.enchantmentType.EnchantmentType;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.identifier.Identifier;
import com.ldtteam.jvoxelizer.util.enchantmenttype.IEnchantmentType;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.util.NonNullList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ItemGroup implements IItemGroup
{
    private CreativeTabs creativeTab;

    public ItemGroup(final CreativeTabs creativeTab)
    {
        this.creativeTab = creativeTab;
    }

    @Override
    public int getTabIndex()
    {
        return creativeTab.getTabIndex();
    }

    @Override
    public IItemGroup setBackgroundImageName(final String texture)
    {
        return new ItemGroup(creativeTab.setBackgroundImageName(texture));
    }

    @Override
    public String getTabLabel()
    {
        return creativeTab.getTabLabel();
    }

    @Override
    public String getTranslatedTabLabel()
    {
        return creativeTab.getTranslatedTabLabel();
    }

    @Override
    public IItemStack getIconItemStack()
    {
        return new ItemStack(creativeTab.getIconItemStack());
    }

    @Override
    public IItemStack getTabIconItem()
    {
        return new ItemStack(creativeTab.getTabIconItem());
    }

    @Override
    public String getBackgroundImageName()
    {
        return creativeTab.getBackgroundImageName();
    }

    @Override
    public boolean drawInForegroundOfTab()
    {
        return creativeTab.drawInForegroundOfTab();
    }

    @Override
    public IItemGroup setNoTitle()
    {
        return new ItemGroup(creativeTab.setNoTitle());
    }

    @Override
    public boolean shouldHidePlayerInventory()
    {
        return creativeTab.shouldHidePlayerInventory();
    }

    @Override
    public IItemGroup setNoScrollbar()
    {
        return new ItemGroup(creativeTab.setNoScrollbar());
    }

    @Override
    public int getTabColumn()
    {
        return creativeTab.getTabColumn();
    }

    @Override
    public boolean isTabInFirstRow()
    {
        return creativeTab.isTabInFirstRow();
    }

    @Override
    public boolean isAlignedRight()
    {
        return creativeTab.isAlignedRight();
    }

    @Override
    public IEnchantmentType[] getRelevantEnchantmentTypes()
    {
        return Arrays.stream(creativeTab.getRelevantEnchantmentTypes()).map(EnchantmentType::new).toArray(IEnchantmentType[]::new);
    }

    @Override
    public IItemGroup setRelevantEnchantmentTypes(final IEnchantmentType... types)
    {
        return new ItemGroup(creativeTab.setRelevantEnchantmentTypes(Arrays.stream(types).map(type -> ((EnchantmentType) type).getForgeType()).toArray(EnumEnchantmentType[]::new)));
    }

    @Override
    public boolean hasRelevantEnchantmentType(final IEnchantmentType enchantmentType)
    {
        return creativeTab.hasRelevantEnchantmentType(((EnchantmentType)enchantmentType).getForgeType());
    }

    @Override
    public int getTabPage()
    {
        return creativeTab.getTabPage();
    }

    @Override
    public boolean hasSearchBar()
    {
        return creativeTab.hasSearchBar();
    }

    @Override
    public int getSearchbarWidth()
    {
        return creativeTab.getSearchbarWidth();
    }

    @Override
    public IIdentifier getBackgroundImage()
    {
        return new Identifier(creativeTab.getBackgroundImage());
    }

    @Override
    public int getLabelColor()
    {
        return creativeTab.getLabelColor();
    }

    @Override
    public void displayAllRelevantItems(final List<IItemStack> list)
    {
        NonNullList<net.minecraft.item.ItemStack> stacks = NonNullList.create();
        stacks.addAll(list.stream().filter(stack -> stack instanceof ItemStack).map(stack -> ((ItemStack)stack).getForgeItem()).collect(Collectors.toList()));
        creativeTab.displayAllRelevantItems(stacks);
    }

    @Override
    public Object getInstanceData()
    {
        return DummyInstanceData[];
    }

    /**
     * Getter to get the wrapped forge class.
     * @return CreativeTabs.
     */
    public CreativeTabs getForgeItemGroup()
    {
        return this.creativeTab;
    }
}
