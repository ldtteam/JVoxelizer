package com.ldtteam.jvoxelizer.item;

import com.google.common.collect.Multimap;
import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.common.capability.ICapabilityManager;
import com.ldtteam.jvoxelizer.client.gui.IScaledResolution;
import com.ldtteam.jvoxelizer.client.model.IModelBiped;
import com.ldtteam.jvoxelizer.client.renderer.blockentity.IBlockEntityRenderer;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.common.animation.ITimedValue;
import com.ldtteam.jvoxelizer.core.logic.IInstancedObject;
import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.enchantment.IEnchantment;
import com.ldtteam.jvoxelizer.entity.IEntity;
import com.ldtteam.jvoxelizer.entity.ai.IAttributeModifier;
import com.ldtteam.jvoxelizer.entity.item.IItemStackEntity;
import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;
import com.ldtteam.jvoxelizer.entity.living.ILivingEntity;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.entity.passive.IHorseArmorType;
import com.ldtteam.jvoxelizer.item.group.IItemGroup;
import com.ldtteam.jvoxelizer.registries.IRegistryEntry;
import com.ldtteam.jvoxelizer.util.action.IActionType;
import com.ldtteam.jvoxelizer.util.equipmentslot.IEquipmentSlot;
import com.ldtteam.jvoxelizer.util.facing.IFacing;
import com.ldtteam.jvoxelizer.util.actionresult.IActionResult;
import com.ldtteam.jvoxelizer.util.actionresult.IActionResultType;
import com.ldtteam.jvoxelizer.util.hand.IHand;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import com.ldtteam.jvoxelizer.util.math.raytraceresult.IRayTraceResult;
import com.ldtteam.jvoxelizer.util.nbt.INBTCompound;
import com.ldtteam.jvoxelizer.util.rarity.IRarity;
import com.ldtteam.jvoxelizer.util.tooltipflag.IToolTipFlag;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public interface IItem<I> extends IRegistryEntry<IItem<I>>, IInstancedObject<I>
{

    static int getIdFromItem(IItem<?> item)
    {
        //TODO: Implement
        throw new NotImplementedException();
    }

    void addPropertyOverride(IIdentifier key, IItemPropertyGetter getter);

    IItemPropertyGetter getPropertyGetter(IIdentifier key);

    boolean updateItemStackNBT(INBTCompound nbt);

    boolean hasCustomProperties();

    IItem setMaxStackSize(int maxStackSize);

    IActionResultType onItemUse(IPlayerEntity player, IDimension worldIn, IBlockCoordinate pos, IHand hand, IFacing facing, float hitX, float hitY, float hitZ);

    float getDestroySpeed(IItemStack stack, IBlockState state);

    IActionResult<IItemStack> onItemRightClick(IDimension worldIn, IPlayerEntity playerIn, IHand handIn);

    IItemStack onItemUseFinish(IItemStack stack, IDimension worldIn, ILivingBaseEntity entityLiving);

    int getItemStackLimit();

    int getMetadata(int damage);

    boolean getHasSubtypes();

    IItem setHasSubtypes(boolean hasSubtypes);

    int getMaxDamage();

    IItem setMaxDamage(int maxDamageIn);

    boolean isDamageable();

    boolean hitEntity(IItemStack stack, ILivingBaseEntity target, ILivingBaseEntity attacker);

    boolean onBlockDestroyed(IItemStack stack, IDimension worldIn, IBlockState state, IBlockCoordinate pos, ILivingBaseEntity entityLiving);

    boolean canHarvestBlock(IBlockState blockIn);

    boolean itemInteractionForEntity(IItemStack stack, IPlayerEntity playerIn, ILivingBaseEntity target, IHand hand);

    IItem setFull3D();

    boolean isFull3D();

    boolean shouldRotateAroundWhenRendering();

    IItem setUnlocalizedName(String unlocalizedName);

    String getUnlocalizedNameInefficiently(IItemStack stack);

    String getUnlocalizedName();

    String getUnlocalizedName(IItemStack stack);

    IItem setContainerItem(IItem containerItem);

    boolean getShareTag();

    IItem getContainerItem();

    boolean hasContainerItem();

    void onUpdate(IItemStack stack, IDimension worldIn, IEntity entityIn, int itemSlot, boolean isSelected);

    void onCreated(IItemStack stack, IDimension worldIn, IPlayerEntity playerIn);

    boolean isMap();

    IActionType getItemUseAction(IItemStack stack);

    int getMaxItemUseDuration(IItemStack stack);

    void onPlayerStoppedUsing(IItemStack stack, IDimension worldIn, ILivingBaseEntity entityLiving, int timeLeft);

    void addInformation(IItemStack stack, IDimension worldIn, List<String> tooltip, IToolTipFlag flagIn);

    String getItemStackDisplayName(IItemStack stack);

    boolean hasEffect(IItemStack stack);

    IRarity getRarity(IItemStack stack);

    boolean isEnchantable(IItemStack stack);

    IRayTraceResult rayTrace(IDimension worldIn, IPlayerEntity playerIn, boolean useLiquids);

    int getItemEnchantability();

    void getSubItems(IItemGroup<?> tab, List<IItemStack> items);

    boolean isInCreativeTab(IItemGroup<?> targetTab);

    IItemGroup<?> getCreativeTab();

    IItem setCreativeTab(IItemGroup<?> tab);

    boolean canItemEditBlocks();

    boolean getIsRepairable(IItemStack toRepair, IItemStack repair);

    Multimap<String, IAttributeModifier> getItemAttributeModifiers(IEquipmentSlot equipmentSlot);

    Multimap<String, IAttributeModifier> getAttributeModifiers(IEquipmentSlot slot, IItemStack stack);

    boolean onDroppedByPlayer(IItemStack IItem, IPlayerEntity player);

    String getHighlightTip(IItemStack IItem, String displayName);

    IActionResultType onItemUseFirst(IPlayerEntity player, IDimension IDimension, IBlockCoordinate pos, IFacing side, float hitX, float hitY, float hitZ, IHand hand);

    boolean isRepairable();

    IItem setNoRepair();

    float getXpRepairRatio(IItemStack stack);

    INBTCompound getNBTShareTag(IItemStack stack);

    void readNBTShareTag(IItemStack stack, INBTCompound nbt);

    boolean onBlockStartBreak(IItemStack IItemStack, IBlockCoordinate pos, IPlayerEntity player);

    void onUsingTick(IItemStack stack, ILivingBaseEntity player, int count);

    boolean onLeftClickEntity(IItemStack stack, IPlayerEntity player, IEntity IEntity);

    IItemStack getContainerItem(IItemStack IItemStack);

    boolean hasContainerItem(IItemStack stack);

    int getEntityLifespan(IItemStack IItemStack, IDimension IDimension);

    boolean hasCustomEntity(IItemStack stack);

    IEntity createEntity(IDimension IDimension, IEntity location, IItemStack IItemStack);

    boolean onEntityItemUpdate(IItemStackEntity entityItem);

    IItemGroup<?>[] getCreativeTabs();

    float getSmeltingExperience(IItemStack IItem);

    boolean doesSneakBypassUse(IItemStack stack, IDimension world, IBlockCoordinate pos, IPlayerEntity player);

    void onArmorTick(IDimension IDimension, IPlayerEntity player, IItemStack IItemStack);

    boolean isValidArmor(IItemStack stack, IEquipmentSlot armorType, IEntity IEntity);

    IEquipmentSlot getEquipmentSlot(IItemStack stack);

    boolean isBookEnchantable(IItemStack stack, IItemStack book);

    String getArmorTexture(IItemStack stack, IEntity IEntity, IEquipmentSlot slot, String type);

    IFontRenderer getFontRenderer(IItemStack stack);

    IModelBiped getArmorModel(ILivingBaseEntity entityLiving, IItemStack IItemStack, IEquipmentSlot armorSlot, IModelBiped _default);

    boolean onEntitySwing(ILivingBaseEntity entityLiving, IItemStack stack);

    void renderHelmetOverlay(IItemStack stack, IPlayerEntity player, IScaledResolution resolution, float partialTicks);

    int getDamage(IItemStack stack);

    int getMetadata(IItemStack stack);

    boolean showDurabilityBar(IItemStack stack);

    double getDurabilityForDisplay(IItemStack stack);

    int getRGBDurabilityForDisplay(IItemStack stack);

    int getMaxDamage(IItemStack stack);

    boolean isDamaged(IItemStack stack);

    void setDamage(IItemStack stack, int damage);

    boolean canDestroyBlockInCreative(IDimension IDimension, IBlockCoordinate pos, IItemStack stack, IPlayerEntity player);

    boolean canHarvestBlock(IBlockState state, IItemStack stack);

    int getItemStackLimit(IItemStack stack);

    void setHarvestLevel(String toolClass, int level);

    java.util.Set<String> getToolClasses(IItemStack stack);

    int getHarvestLevel(IItemStack stack, String toolClass, IPlayerEntity player, IBlockState blockState);

    int getItemEnchantability(IItemStack stack);

    boolean canApplyAtEnchantingTable(IItemStack stack, IEnchantment enchantment);

    boolean isBeaconPayment(IItemStack stack);

    boolean shouldCauseReequipAnimation(IItemStack oldStack, IItemStack newStack, boolean slotChanged);

    boolean shouldCauseBlockBreakReset(IItemStack oldStack, IItemStack newStack);

    boolean canContinueUsing(IItemStack oldStack, IItemStack newStack);

    String getCreatorModId(IItemStack IItemStack);

    ICapabilityManager initCapabilities(IItemStack stack, INBTCompound nbt);

    com.google.common.collect.ImmutableMap<String, ITimedValue> getAnimationParameters(final IItemStack stack, final IDimension IDimension, final ILivingBaseEntity IEntity);

    boolean canDisableShield(IItemStack stack, IItemStack shield, ILivingBaseEntity IEntity, ILivingBaseEntity attacker);

    boolean isShield(IItemStack stack, ILivingBaseEntity IEntity);

    int getItemBurnTime(IItemStack IItemStack);

    IHorseArmorType getHorseArmorType(IItemStack stack);

    String getHorseArmorTexture(ILivingEntity wearer, IItemStack stack);

    void onHorseArmorTick(IDimension IDimension, ILivingEntity horse, IItemStack armor);

    IBlockEntityRenderer getTileEntityItemStackRenderer();

    void setTileEntityItemStackRenderer(IBlockEntityRenderer teisr);

    IItemStack getDefaultInstance();

    String getTranslationKey(IItemStack pItemStack1);
}
