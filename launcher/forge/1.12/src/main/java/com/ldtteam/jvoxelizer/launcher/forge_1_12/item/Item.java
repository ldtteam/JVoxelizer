package com.ldtteam.jvoxelizer.launcher.forge_1_12.item;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.common.capability.ICapabilityManager;
import com.ldtteam.jvoxelizer.client.gui.IScaledResolution;
import com.ldtteam.jvoxelizer.client.model.IModelBiped;
import com.ldtteam.jvoxelizer.client.renderer.blockentity.IBlockEntityRenderer;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.common.animation.ITimedValue;
import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.enchantment.IEnchantment;
import com.ldtteam.jvoxelizer.entity.IEntity;
import com.ldtteam.jvoxelizer.entity.ai.IAttributeModifier;
import com.ldtteam.jvoxelizer.entity.item.IItemStackEntity;
import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;
import com.ldtteam.jvoxelizer.entity.living.ILivingEntity;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.entity.passive.IHorseArmorType;
import com.ldtteam.jvoxelizer.item.IItem;
import com.ldtteam.jvoxelizer.item.IItemPropertyGetter;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.group.IItemGroup;
import com.ldtteam.jvoxelizer.util.action.IActionType;
import com.ldtteam.jvoxelizer.util.actionresult.IActionResult;
import com.ldtteam.jvoxelizer.util.actionresult.IActionResultType;
import com.ldtteam.jvoxelizer.util.equipmentslot.IEquipmentSlot;
import com.ldtteam.jvoxelizer.util.facing.IFacing;
import com.ldtteam.jvoxelizer.util.hand.IHand;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import com.ldtteam.jvoxelizer.util.math.raytraceresult.IRayTraceResult;
import com.ldtteam.jvoxelizer.util.nbt.INBTCompound;
import com.ldtteam.jvoxelizer.util.rarity.IRarity;
import com.ldtteam.jvoxelizer.util.tooltipflag.IToolTipFlag;

import java.util.List;
import java.util.Set;

public class Item implements IItem
{

    private net.minecraft.item.Item forgeItem;

    public net.minecraft.item.Item getForgeItem()
    {
        return forgeItem;
    }

    @Override
    public void addPropertyOverride(final IIdentifier key, final IItemPropertyGetter getter)
    {

    }

    @Override
    public IItemPropertyGetter getPropertyGetter(final IIdentifier key)
    {
        return null;
    }

    @Override
    public boolean updateItemStackNBT(final INBTCompound nbt)
    {
        return false;
    }

    @Override
    public boolean hasCustomProperties()
    {
        return false;
    }

    @Override
    public IItem setMaxStackSize(final int maxStackSize)
    {
        return null;
    }

    @Override
    public IActionResultType onItemUse(
      final IPlayerEntity player,
      final IDimension worldIn,
      final IBlockCoordinate pos,
      final IHand hand,
      final IFacing facing,
      final float hitX,
      final float hitY,
      final float hitZ)
    {
        return null;
    }

    @Override
    public float getDestroySpeed(final IItemStack stack, final IBlockState state)
    {
        return 0;
    }

    @Override
    public IActionResult<IItemStack> onItemRightClick(
      final IDimension worldIn, final IPlayerEntity playerIn, final IHand handIn)
    {
        return null;
    }

    @Override
    public IItemStack onItemUseFinish(final IItemStack stack, final IDimension worldIn, final ILivingBaseEntity entityLiving)
    {
        return null;
    }

    @Override
    public int getItemStackLimit()
    {
        return 0;
    }

    @Override
    public int getMetadata(final int damage)
    {
        return 0;
    }

    @Override
    public boolean getHasSubtypes()
    {
        return false;
    }

    @Override
    public IItem setHasSubtypes(final boolean hasSubtypes)
    {
        return null;
    }

    @Override
    public int getMaxDamage()
    {
        return 0;
    }

    @Override
    public IItem setMaxDamage(final int maxDamageIn)
    {
        return null;
    }

    @Override
    public boolean isDamageable()
    {
        return false;
    }

    @Override
    public boolean hitEntity(final IItemStack stack, final ILivingBaseEntity target, final ILivingBaseEntity attacker)
    {
        return false;
    }

    @Override
    public boolean onBlockDestroyed(final IItemStack stack, final IDimension worldIn, final IBlockState state, final IBlockCoordinate pos, final ILivingBaseEntity entityLiving)
    {
        return false;
    }

    @Override
    public boolean canHarvestBlock(final IBlockState blockIn)
    {
        return false;
    }

    @Override
    public boolean itemInteractionForEntity(final IItemStack stack, final IPlayerEntity playerIn, final ILivingBaseEntity target, final IHand hand)
    {
        return false;
    }

    @Override
    public IItem setFull3D()
    {
        return null;
    }

    @Override
    public boolean isFull3D()
    {
        return false;
    }

    @Override
    public boolean shouldRotateAroundWhenRendering()
    {
        return false;
    }

    @Override
    public IItem setUnlocalizedName(final String unlocalizedName)
    {
        return null;
    }

    @Override
    public String getUnlocalizedNameInefficiently(final IItemStack stack)
    {
        return null;
    }

    @Override
    public String getUnlocalizedName()
    {
        return null;
    }

    @Override
    public String getUnlocalizedName(final IItemStack stack)
    {
        return null;
    }

    @Override
    public IItem setContainerItem(final IItem containerItem)
    {
        return null;
    }

    @Override
    public boolean getShareTag()
    {
        return false;
    }

    @Override
    public IItem getContainerItem()
    {
        return null;
    }

    @Override
    public boolean hasContainerItem()
    {
        return false;
    }

    @Override
    public void onUpdate(final IItemStack stack, final IDimension worldIn, final IEntity entityIn, final int itemSlot, final boolean isSelected)
    {

    }

    @Override
    public void onCreated(final IItemStack stack, final IDimension worldIn, final IPlayerEntity playerIn)
    {

    }

    @Override
    public boolean isMap()
    {
        return false;
    }

    @Override
    public IActionType getItemUseAction(final IItemStack stack)
    {
        return null;
    }

    @Override
    public int getMaxItemUseDuration(final IItemStack stack)
    {
        return 0;
    }

    @Override
    public void onPlayerStoppedUsing(final IItemStack stack, final IDimension worldIn, final ILivingBaseEntity entityLiving, final int timeLeft)
    {

    }

    @Override
    public String getItemStackDisplayName(final IItemStack stack)
    {
        return null;
    }

    @Override
    public boolean hasEffect(final IItemStack stack)
    {
        return false;
    }

    @Override
    public IRarity getRarity(final IItemStack stack)
    {
        return null;
    }

    @Override
    public boolean isEnchantable(final IItemStack stack)
    {
        return false;
    }

    @Override
    public IRayTraceResult rayTrace(final IDimension worldIn, final IPlayerEntity playerIn, final boolean useLiquids)
    {
        return null;
    }

    @Override
    public int getItemEnchantability()
    {
        return 0;
    }

    @Override
    public IItemGroup<?> getCreativeTab()
    {
        return null;
    }

    @Override
    public boolean canItemEditBlocks()
    {
        return false;
    }

    @Override
    public boolean getIsRepairable(final IItemStack toRepair, final IItemStack repair)
    {
        return false;
    }

    @Override
    public Multimap<String, IAttributeModifier> getItemAttributeModifiers(final IEquipmentSlot equipmentSlot)
    {
        return null;
    }

    @Override
    public Multimap<String, IAttributeModifier> getAttributeModifiers(final IEquipmentSlot slot, final IItemStack stack)
    {
        return null;
    }

    @Override
    public boolean onDroppedByPlayer(final IItemStack IItem, final IPlayerEntity player)
    {
        return false;
    }

    @Override
    public String getHighlightTip(final IItemStack IItem, final String displayName)
    {
        return null;
    }

    @Override
    public IActionResult onItemUseFirst(
      final IPlayerEntity player,
      final IDimension IDimension,
      final IBlockCoordinate pos,
      final IFacing side,
      final float hitX,
      final float hitY,
      final float hitZ,
      final IHand hand)
    {
        return null;
    }

    @Override
    public boolean isRepairable()
    {
        return false;
    }

    @Override
    public IItem setNoRepair()
    {
        return null;
    }

    @Override
    public float getXpRepairRatio(final IItemStack stack)
    {
        return 0;
    }

    @Override
    public INBTCompound getNBTShareTag(final IItemStack stack)
    {
        return null;
    }

    @Override
    public void readNBTShareTag(final IItemStack stack, final INBTCompound nbt)
    {

    }

    @Override
    public boolean onBlockStartBreak(final IItemStack IItemStack, final IBlockCoordinate pos, final IPlayerEntity player)
    {
        return false;
    }

    @Override
    public void onUsingTick(final IItemStack stack, final ILivingBaseEntity player, final int count)
    {

    }

    @Override
    public boolean onLeftClickEntity(final IItemStack stack, final IPlayerEntity player, final IEntity IEntity)
    {
        return false;
    }

    @Override
    public IItemStack getContainerItem(final IItemStack IItemStack)
    {
        return null;
    }

    @Override
    public boolean hasContainerItem(final IItemStack stack)
    {
        return false;
    }

    @Override
    public int getEntityLifespan(final IItemStack IItemStack, final IDimension IDimension)
    {
        return 0;
    }

    @Override
    public boolean hasCustomEntity(final IItemStack stack)
    {
        return false;
    }

    @Override
    public IEntity createEntity(final IDimension IDimension, final IEntity location, final IItemStack IItemStack)
    {
        return null;
    }

    @Override
    public boolean onEntityItemUpdate(final IItemStackEntity entityItem)
    {
        return false;
    }

    @Override
    public IItemGroup<?>[] getCreativeTabs()
    {
        return new IItemGroup[0];
    }

    @Override
    public float getSmeltingExperience(final IItemStack IItem)
    {
        return 0;
    }

    @Override
    public boolean doesSneakBypassUse(final IItemStack stack, final IDimension world, final IBlockCoordinate pos, final IPlayerEntity player)
    {
        return false;
    }

    @Override
    public void onArmorTick(final IDimension IDimension, final IPlayerEntity player, final IItemStack IItemStack)
    {

    }

    @Override
    public boolean isValidArmor(final IItemStack stack, final IEquipmentSlot armorType, final IEntity IEntity)
    {
        return false;
    }

    @Override
    public IEquipmentSlot getEquipmentSlot(final IItemStack stack)
    {
        return null;
    }

    @Override
    public boolean isBookEnchantable(final IItemStack stack, final IItemStack book)
    {
        return false;
    }

    @Override
    public String getArmorTexture(final IItemStack stack, final IEntity IEntity, final IEquipmentSlot slot, final String type)
    {
        return null;
    }

    @Override
    public IFontRenderer getFontRenderer(final IItemStack stack)
    {
        return null;
    }

    @Override
    public IModelBiped getArmorModel(
      final ILivingBaseEntity entityLiving, final IItemStack IItemStack, final IEquipmentSlot armorSlot, final IModelBiped _default)
    {
        return null;
    }

    @Override
    public boolean onEntitySwing(final ILivingBaseEntity entityLiving, final IItemStack stack)
    {
        return false;
    }

    @Override
    public void renderHelmetOverlay(final IItemStack stack, final IPlayerEntity player, final IScaledResolution resolution, final float partialTicks)
    {

    }

    @Override
    public int getDamage(final IItemStack stack)
    {
        return 0;
    }

    @Override
    public int getMetadata(final IItemStack stack)
    {
        return 0;
    }

    @Override
    public boolean showDurabilityBar(final IItemStack stack)
    {
        return false;
    }

    @Override
    public double getDurabilityForDisplay(final IItemStack stack)
    {
        return 0;
    }

    @Override
    public int getRGBDurabilityForDisplay(final IItemStack stack)
    {
        return 0;
    }

    @Override
    public int getMaxDamage(final IItemStack stack)
    {
        return 0;
    }

    @Override
    public boolean isDamaged(final IItemStack stack)
    {
        return false;
    }

    @Override
    public void setDamage(final IItemStack stack, final int damage)
    {

    }

    @Override
    public boolean canDestroyBlockInCreative(final IDimension IDimension, final IBlockCoordinate pos, final IItemStack stack, final IPlayerEntity player)
    {
        return false;
    }

    @Override
    public boolean canHarvestBlock(final IBlockState state, final IItemStack stack)
    {
        return false;
    }

    @Override
    public int getItemStackLimit(final IItemStack stack)
    {
        return 0;
    }

    @Override
    public void setHarvestLevel(final String toolClass, final int level)
    {

    }

    @Override
    public Set<String> getToolClasses(final IItemStack stack)
    {
        return null;
    }

    @Override
    public int getHarvestLevel(final IItemStack stack, final String toolClass, final IPlayerEntity player, final IBlockState blockState)
    {
        return 0;
    }

    @Override
    public int getItemEnchantability(final IItemStack stack)
    {
        return 0;
    }

    @Override
    public boolean canApplyAtEnchantingTable(final IItemStack stack, final IEnchantment enchantment)
    {
        return false;
    }

    @Override
    public boolean isBeaconPayment(final IItemStack stack)
    {
        return false;
    }

    @Override
    public boolean shouldCauseReequipAnimation(final IItemStack oldStack, final IItemStack newStack, final boolean slotChanged)
    {
        return false;
    }

    @Override
    public boolean shouldCauseBlockBreakReset(final IItemStack oldStack, final IItemStack newStack)
    {
        return false;
    }

    @Override
    public boolean canContinueUsing(final IItemStack oldStack, final IItemStack newStack)
    {
        return false;
    }

    @Override
    public String getCreatorModId(final IItemStack IItemStack)
    {
        return null;
    }

    @Override
    public ICapabilityManager initCapabilities(final IItemStack stack, final INBTCompound nbt)
    {
        return null;
    }

    @Override
    public ImmutableMap<String, ITimedValue> getAnimationParameters(
      final IItemStack stack, final IDimension IDimension, final ILivingBaseEntity IEntity)
    {
        return null;
    }

    @Override
    public boolean canDisableShield(final IItemStack stack, final IItemStack shield, final ILivingBaseEntity IEntity, final ILivingBaseEntity attacker)
    {
        return false;
    }

    @Override
    public boolean isShield(final IItemStack stack, final ILivingBaseEntity IEntity)
    {
        return false;
    }

    @Override
    public int getItemBurnTime(final IItemStack IItemStack)
    {
        return 0;
    }

    @Override
    public IHorseArmorType getHorseArmorType(final IItemStack stack)
    {
        return null;
    }

    @Override
    public String getHorseArmorTexture(final ILivingEntity wearer, final IItemStack stack)
    {
        return null;
    }

    @Override
    public void onHorseArmorTick(final IDimension IDimension, final ILivingEntity horse, final IItemStack armor)
    {

    }

    @Override
    public IBlockEntityRenderer getTileEntityItemStackRenderer()
    {
        return null;
    }

    @Override
    public void setTileEntityItemStackRenderer(final IBlockEntityRenderer teisr)
    {

    }

    @Override
    public IItemStack getDefaultInstance()
    {
        return null;
    }

    @Override
    public String getTranslationKey(final IItemStack pItemStack1)
    {
        return null;
    }

    @Override
    public IItem setCreativeTab(final IItemGroup tab)
    {
        return null;
    }

    @Override
    public boolean isInCreativeTab(final IItemGroup targetTab)
    {
        return false;
    }

    @Override
    public void getSubItems(final IItemGroup tab, final List items)
    {

    }

    @Override
    public void addInformation(final IItemStack stack, final IDimension worldIn, final List tooltip, final IToolTipFlag flagIn)
    {

    }

    @Override
    public Object getInstanceData()
    {
        return null;
    }

    @Override
    public Object setRegistryName(final IIdentifier name)
    {
        return null;
    }

    @Override
    public IIdentifier getRegistryName()
    {
        return null;
    }

    @Override
    public Class getRegistryType()
    {
        return null;
    }
}
