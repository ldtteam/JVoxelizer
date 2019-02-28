package com.ldtteam.jvoxelizer.item.group;

import com.ldtteam.jvoxelizer.core.logic.*;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.enchantmenttype.IEnchantmentType;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

import java.util.List;

public interface IItemGroup<I> extends IInstancedObject<I> {

    int getTabIndex();

    IItemGroup<I> setBackgroundImageName(String texture);

    String getTabLabel();

    String getTranslatedTabLabel();

    IItemStack getIconItemStack();

    IItemStack getTabIconItem();

    String getBackgroundImageName();

    boolean drawInForegroundOfTab();

    IItemGroup<I> setNoTitle();

    boolean shouldHidePlayerInventory();

    IItemGroup<I> setNoScrollbar();

    int getTabColumn();

    boolean isTabInFirstRow();

    boolean isAlignedRight();

    IEnchantmentType[] getRelevantEnchantmentTypes();

    IItemGroup<I> setRelevantEnchantmentTypes(IEnchantmentType... types);

    boolean hasRelevantEnchantmentType(IEnchantmentType enchantmentType);

    void displayAllRelevantItems(List<IItemStack> list);

    int getTabPage();

    boolean hasSearchBar();

    int getSearchbarWidth();

    IIdentifier getBackgroundImage();

    int getLabelColor();
}
