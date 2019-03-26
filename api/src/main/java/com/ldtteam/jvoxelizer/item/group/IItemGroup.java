package com.ldtteam.jvoxelizer.item.group;

import com.ldtteam.jvoxelizer.core.logic.*;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.enchantmenttype.IEnchantmentType;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

import java.util.List;

public interface IItemGroup<I> extends IInstancedObject<I> {

    int getTabIndex();

    IItemGroup<I> setBackgroundImage(String texture);

    String getTabLabel();

    String getTranslatedTabLabel();

    IItemStack getDisplayedStack();

    IItemStack getTabStack();

    String getBackgroundImageName();

    boolean drawInForegroundOfTab();

    IItemGroup<I> disableTitle();

    boolean shouldHidePlayerInventory();

    IItemGroup<I> disableScrollbar();

    int getTabColumn();

    boolean isTabInFirstRow();

    boolean isAlignedRight();

    IEnchantmentType[] getPossibleEnchantmentTypes();

    IItemGroup<I> setPossibleEnchantmentTypes(IEnchantmentType... types);

    boolean hasPossibleEnchantmentType(IEnchantmentType enchantmentType);

    void displayAllItems(List<IItemStack> list);

    int getTabPage();

    boolean hasSearchBar();

    int getSearchbarWidth();

    IIdentifier getBackgroundImageIdentifier();

    int getLabelColor();
}
