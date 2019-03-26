package com.ldtteam.jvoxelizer.launcher.forge_1_12.item;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.client.gui.IScaledResolution;
import com.ldtteam.jvoxelizer.client.model.IModelBiped;
import com.ldtteam.jvoxelizer.client.renderer.blockentity.IBlockEntityRenderer;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.common.animation.ITimedValue;
import com.ldtteam.jvoxelizer.common.capability.ICapabilityProvider;
import com.ldtteam.jvoxelizer.core.logic.DummyInstanceData;
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
import com.ldtteam.jvoxelizer.launcher.forge_1_12.block.state.BlockState;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.ScaledResolution;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.model.ModelBiped;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.blockentity.BlockEntityRenderer;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.font.FontRenderer;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.common.animation.TimedValue;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.Dimension;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.enchantment.Enchantment;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.ai.AttributeModifier;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.item.ItemStackEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.LivingBaseEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.LivingEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player.PlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.passive.HorseArmorType;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.group.ItemGroup;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.action.ActionType;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.actionresult.ActionResult;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.actionresult.ActionResultType;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.equipmentslot.EquipmentSlot;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.facing.Facing;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.hand.Hand;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.identifier.Identifier;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.coordinate.block.BlockCoordinate;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.raytraceresult.RayTraceResult;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt.NBTCompound;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.rarity.Rarity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.tooltipflag.ToolTipFlag;
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
import com.ldtteam.jvoxelizer.util.stream.multimap.MultiMapCollector;
import com.ldtteam.jvoxelizer.util.tooltipflag.IToolTipFlag;
import com.sun.xml.internal.bind.v2.model.core.ID;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.animation.ITimeValue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Item implements IItem<DummyInstanceData>
{
    private net.minecraft.item.Item forgeItem;

    private Item(final net.minecraft.item.Item forgeItem)
    {
        this.forgeItem = forgeItem;
    }

    @Override
    public void addPropertyOverride(final IIdentifier key, final IItemPropertyGetter getter)
    {
        forgeItem.addPropertyOverride(Identifier.asForge(key), ItemPropertyGetter.asForge(getter));
    }

    @Override
    public IItemPropertyGetter getPropertyGetter(final IIdentifier key)
    {
        return ItemPropertyGetter.fromForge(forgeItem.getPropertyGetter(Identifier.asForge(key)));
    }

    @Override
    public boolean updateItemStackNBT(final INBTCompound nbt)
    {
        return forgeItem.updateItemStackNBT(NBTCompound.asForge(nbt));
    }

    @Override
    public boolean hasCustomProperties()
    {
        return forgeItem.hasCustomProperties();
    }

    @Override
    public IItem setMaxItemStackSize(final int maxStackSize)
    {
        return new Item(forgeItem.setMaxStackSize(maxStackSize));
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
        return ActionResultType.fromForge(forgeItem.onItemUse(PlayerEntity.asForge(player), Dimension.asForge(worldIn), BlockCoordinate.asForge(pos), Hand.asForge(hand), Facing.asForge(facing), hitX, hitY, hitZ));
    }

    @Override
    public float getDestroySpeed(final IItemStack stack, final IBlockState state)
    {
        return forgeItem.getDestroySpeed(ItemStack.asForge(stack), BlockState.asForge(state));
    }

    @Override
    public IActionResult<IItemStack> onItemRightClick(final IDimension worldIn, final IPlayerEntity playerIn, final IHand handIn)
    {
        final net.minecraft.util.ActionResult<net.minecraft.item.ItemStack>
          result = forgeItem.onItemRightClick(Dimension.asForge(worldIn), PlayerEntity.asForge(playerIn), Hand.asForge(handIn));
        return ActionResult.fromForge(result, ItemStack::fromForge);
    }

    @Override
    public IItemStack onItemUseFinish(final IItemStack stack, final IDimension worldIn, final ILivingBaseEntity entityLiving)
    {
        return ItemStack.fromForge(forgeItem.onItemUseFinish(ItemStack.asForge(stack), Dimension.asForge(worldIn), LivingBaseEntity.asForge(entityLiving)));
    }

    @Override
    public int getItemStackLimit()
    {
        return forgeItem.getItemStackLimit();
    }

    @Override
    public int getMetadata(final int damage)
    {
        return forgeItem.getMetadata(damage);
    }

    @Override
    public boolean getHasSubtypes()
    {
        return forgeItem.getHasSubtypes();
    }

    @Override
    public IItem setHasSubItems(final boolean hasSubtypes)
    {
        return new Item(forgeItem.setHasSubtypes(hasSubtypes));
    }

    @Override
    public int getMaxDamage()
    {
        return forgeItem.getMaxDamage();
    }

    @Override
    public IItem setMaxSustainableDamage(final int maxDamageIn)
    {
        return new Item(forgeItem.setMaxDamage(maxDamageIn));
    }

    @Override
    public boolean isDamageable()
    {
        return forgeItem.isDamageable();
    }

    @Override
    public boolean hitEntity(final IItemStack stack, final ILivingBaseEntity target, final ILivingBaseEntity attacker)
    {
        return forgeItem.hitEntity(ItemStack.asForge(stack), LivingBaseEntity.asForge(target), LivingBaseEntity.asForge(attacker));
    }

    @Override
    public boolean onBlockDestroyed(final IItemStack stack, final IDimension worldIn, final IBlockState state, final IBlockCoordinate pos, final ILivingBaseEntity entityLiving)
    {
        return forgeItem.onBlockDestroyed(ItemStack.asForge(stack), Dimension.asForge(worldIn),
          BlockState.asForge(state), BlockCoordinate.asForge(pos), LivingBaseEntity.asForge(entityLiving));
    }

    @Override
    public boolean canHarvestBlock(final IBlockState blockIn)
    {
        return forgeItem.canHarvestBlock(BlockState.asForge(blockIn));
    }

    @Override
    public boolean itemInteractionForEntity(final IItemStack stack, final IPlayerEntity playerIn, final ILivingBaseEntity target, final IHand hand)
    {
        return forgeItem.itemInteractionForEntity(ItemStack.asForge(stack), PlayerEntity.asForge(playerIn), LivingBaseEntity.asForge(target), Hand.asForge(hand));
    }

    @Override
    public IItem setItemIsFull3D()
    {
        return new Item(forgeItem.setFull3D());
    }

    @Override
    public boolean isFull3D()
    {
        return forgeItem.isFull3D();
    }

    @Override
    public boolean shouldRotateAroundWhenRendering()
    {
        return forgeItem.shouldRotateAroundWhenRendering();
    }

    @Override
    public IItem setUnlocalizedNameForItem(final String unlocalizedName)
    {
        return new Item(forgeItem.setUnlocalizedName(unlocalizedName));
    }

    @Override
    public String getUnlocalizedNameInefficiently(final IItemStack stack)
    {
        return forgeItem.getUnlocalizedNameInefficiently(ItemStack.asForge(stack));
    }

    @Override
    public String getUnlocalizedName()
    {
        return forgeItem.getUnlocalizedName();
    }

    @Override
    public String getUnlocalizedName(final IItemStack stack)
    {
        return forgeItem.getUnlocalizedName(ItemStack.asForge(stack));
    }

    @Override
    public IItem setContainerItem(final IItem containerItem)
    {
        return new Item(forgeItem.setContainerItem(((Item)containerItem).forgeItem));
    }

    @Override
    public boolean getShareTag()
    {
        return forgeItem.getShareTag();
    }

    @Override
    public IItem getRemainderItemAfterUse()
    {
        return new Item(forgeItem.getContainerItem());
    }

    @Override
    public boolean hasContainerItem()
    {
        return forgeItem.hasContainerItem();
    }

    @Override
    public void onUpdate(final IItemStack stack, final IDimension worldIn, final IEntity entityIn, final int itemSlot, final boolean isSelected)
    {
        forgeItem.onUpdate(ItemStack.asForge(stack), Dimension.asForge(worldIn), Entity.asForge(entityIn), itemSlot, isSelected);
    }

    @Override
    public void onCreated(final IItemStack stack, final IDimension worldIn, final IPlayerEntity playerIn)
    {
        forgeItem.onCreated(ItemStack.asForge(stack), Dimension.asForge(worldIn), PlayerEntity.asForge(playerIn));
    }

    @Override
    public boolean isMap()
    {
        return forgeItem.isMap();
    }

    @Override
    public IActionType getItemUseAction(final IItemStack stack)
    {
        return ActionType.fromForge(forgeItem.getItemUseAction(ItemStack.asForge(stack)));
    }

    @Override
    public int getMaxItemUseDuration(final IItemStack stack)
    {
        return forgeItem.getMaxItemUseDuration(ItemStack.asForge(stack));
    }

    @Override
    public void onPlayerStoppedUsing(final IItemStack stack, final IDimension worldIn, final ILivingBaseEntity entityLiving, final int timeLeft)
    {
        forgeItem.onPlayerStoppedUsing(ItemStack.asForge(stack), Dimension.asForge(worldIn), LivingBaseEntity.asForge(entityLiving), timeLeft);
    }

    @Override
    public String getItemStackDisplayName(final IItemStack stack)
    {
        return forgeItem.getItemStackDisplayName(ItemStack.asForge(stack));
    }

    @Override
    public boolean hasEffect(final IItemStack stack)
    {
        return forgeItem.hasEffect(ItemStack.asForge(stack));
    }

    @Override
    public IRarity getRarity(final IItemStack stack)
    {
        return Rarity.fromForge(forgeItem.getRarity(ItemStack.asForge(stack)));
    }

    @Override
    public boolean isEnchantable(final IItemStack stack)
    {
        return forgeItem.isEnchantable(ItemStack.asForge(stack));
    }

    @Override
    public int getItemEnchantability()
    {
        return forgeItem.getItemEnchantability();
    }

    @Override
    public IItemGroup<?> getItemGroup()
    {
        return ItemGroup.fromForge(forgeItem.getCreativeTab());
    }

    @Override
    public boolean canItemEditBlocks()
    {
        return forgeItem.canItemEditBlocks();
    }

    @Override
    public boolean getIsRepairable(final IItemStack toRepair, final IItemStack repair)
    {
        return forgeItem.getIsRepairable(ItemStack.asForge(toRepair), ItemStack.asForge(repair));
    }

    @Override
    public Multimap<String, IAttributeModifier> getItemAttributeModifiers(final IEquipmentSlot equipmentSlot)
    {
        return forgeItem.getItemAttributeModifiers(EquipmentSlot.asForge(equipmentSlot)).entries().stream()
          .collect(MultiMapCollector.toMultimap(Map.Entry::getKey, e -> AttributeModifier.fromForge(e.getValue())));
    }

    @Override
    public Multimap<String, IAttributeModifier> getAttributeModifiers(final IEquipmentSlot slot, final IItemStack stack)
    {
        return forgeItem.getAttributeModifiers(EquipmentSlot.asForge(slot), ItemStack.asForge(stack)).entries().stream()
                 .collect(MultiMapCollector.toMultimap(Map.Entry::getKey, e -> AttributeModifier.fromForge(e.getValue())));
    }

    @Override
    public boolean onDroppedByPlayer(final IItemStack iItem, final IPlayerEntity player)
    {
        return forgeItem.onDroppedByPlayer(ItemStack.asForge(iItem), PlayerEntity.asForge(player));
    }

    @Override
    public String getHighlightTip(final IItemStack iItem, final String displayName)
    {
        return forgeItem.getHighlightTip(ItemStack.asForge(iItem), displayName);
    }

    @Override
    public IActionResultType onItemUseFirst(
      final IPlayerEntity player,
      final IDimension iDimension,
      final IBlockCoordinate pos,
      final IFacing side,
      final float hitX,
      final float hitY,
      final float hitZ,
      final IHand hand)
    {
        return ActionResultType.fromForge(forgeItem.onItemUse(PlayerEntity.asForge(player), Dimension.asForge(iDimension), BlockCoordinate.asForge(pos), Hand.asForge(hand), Facing.asForge(side), hitX, hitY, hitZ));
    }

    @Override
    public boolean isRepairable()
    {
        return forgeItem.isRepairable();
    }

    @Override
    public IItem disableRepair()
    {
        return new Item(forgeItem.setNoRepair());
    }

    @Override
    public float getXpRepairRatio(final IItemStack stack)
    {
        return forgeItem.getXpRepairRatio(ItemStack.asForge(stack));
    }

    @Override
    public INBTCompound getNBTShareTag(final IItemStack stack)
    {
        return NBTCompound.fromForge(forgeItem.getNBTShareTag(ItemStack.asForge(stack)));
    }

    @Override
    public void readNBTShareTag(final IItemStack stack, final INBTCompound nbt)
    {
        forgeItem.readNBTShareTag(ItemStack.asForge(stack), NBTCompound.asForge(nbt));
    }

    @Override
    public boolean onBlockStartBreak(final IItemStack iItemStack, final IBlockCoordinate pos, final IPlayerEntity player)
    {
        return forgeItem.onBlockStartBreak(ItemStack.asForge(iItemStack), BlockCoordinate.asForge(pos), PlayerEntity.asForge(player));
    }

    @Override
    public void onUsingTick(final IItemStack stack, final ILivingBaseEntity player, final int count)
    {
        forgeItem.onUsingTick(ItemStack.asForge(stack), LivingBaseEntity.asForge(player), count);
    }

    @Override
    public boolean onLeftClickEntity(final IItemStack stack, final IPlayerEntity player, final IEntity iEntity)
    {
        return forgeItem.onLeftClickEntity(ItemStack.asForge(stack), PlayerEntity.asForge(player), Entity.asForge(iEntity));
    }

    @Override
    public IItemStack getRemainderItemAfterUse(final IItemStack iItemStack)
    {
        return ItemStack.fromForge(forgeItem.getContainerItem(ItemStack.asForge(iItemStack)));
    }

    @Override
    public boolean hasContainerItem(final IItemStack stack)
    {
        return forgeItem.hasContainerItem(ItemStack.asForge(stack));
    }

    @Override
    public int getEntityLifespan(final IItemStack iItemStack, final IDimension iDimension)
    {
        return forgeItem.getEntityLifespan(ItemStack.asForge(iItemStack), Dimension.asForge(iDimension));
    }

    @Override
    public boolean hasCustomEntity(final IItemStack stack)
    {
        return forgeItem.hasCustomEntity(ItemStack.asForge(stack));
    }

    @Override
    public IEntity createEntity(final IDimension iDimension, final IEntity location, final IItemStack stack)
    {
        return Entity.fromForge(forgeItem.createEntity(Dimension.asForge(iDimension), Entity.asForge(location), ItemStack.asForge(stack)));
    }

    @Override
    public boolean onEntityItemUpdate(final IItemStackEntity entityItem)
    {
        return forgeItem.onEntityItemUpdate((EntityItem) ItemStackEntity.asForge(entityItem));
    }

    @Override
    public IItemGroup<?>[] getItemGroups()
    {
        return Arrays.stream(forgeItem.getCreativeTabs()).map(ItemGroup::fromForge).toArray(ItemGroup[]::new);
    }

    @Override
    public float getSmeltingExperience(final IItemStack iItem)
    {
        return forgeItem.getSmeltingExperience(ItemStack.asForge(iItem));
    }

    @Override
    public boolean doesSneakBypassUse(final IItemStack stack, final IDimension world, final IBlockCoordinate pos, final IPlayerEntity player)
    {
        return forgeItem.doesSneakBypassUse(ItemStack.asForge(stack), Dimension.asForge(world), BlockCoordinate.asForge(pos), PlayerEntity.asForge(player));
    }

    @Override
    public void onArmorTick(final IDimension iDimension, final IPlayerEntity player, final IItemStack iItemStack)
    {
        forgeItem.onArmorTick(Dimension.asForge(iDimension), PlayerEntity.asForge(player), ItemStack.asForge(iItemStack));
    }

    @Override
    public boolean isValidArmor(final IItemStack stack, final IEquipmentSlot armorType, final IEntity iEntity)
    {
        return forgeItem.isValidArmor(ItemStack.asForge(stack), EquipmentSlot.asForge(armorType), Entity.asForge(iEntity));
    }

    @Override
    public IEquipmentSlot getEquipmentSlot(final IItemStack stack)
    {
        return EquipmentSlot.fromForge(forgeItem.getEquipmentSlot(ItemStack.asForge(stack)));
    }

    @Override
    public boolean isBookEnchantable(final IItemStack stack, final IItemStack book)
    {
        return forgeItem.isBookEnchantable(ItemStack.asForge(stack), ItemStack.asForge(book));
    }

    @Override
    public String getArmorTexture(final IItemStack stack, final IEntity iEntity, final IEquipmentSlot slot, final String type)
    {
        return forgeItem.getArmorTexture(ItemStack.asForge(stack), Entity.asForge(iEntity), EquipmentSlot.asForge(slot), type);
    }

    @Override
    public IFontRenderer getFontRenderer(final IItemStack stack)
    {
        return FontRenderer.fromForge(forgeItem.getFontRenderer(ItemStack.asForge(stack)));
    }

    @Override
    public IModelBiped getArmorModel(
      final ILivingBaseEntity entityLiving, final IItemStack IItemStack, final IEquipmentSlot armorSlot, final IModelBiped _default)
    {
        return ModelBiped.fromForge(forgeItem.getArmorModel(LivingBaseEntity.asForge(entityLiving), ItemStack.asForge(IItemStack), EquipmentSlot.asForge(armorSlot), ModelBiped.asForge(_default)));
    }

    @Override
    public boolean onEntitySwing(final ILivingBaseEntity entityLiving, final IItemStack stack)
    {
        return forgeItem.onEntitySwing(LivingBaseEntity.asForge(entityLiving), ItemStack.asForge(stack));
    }

    @Override
    public void renderHelmetOverlay(final IItemStack stack, final IPlayerEntity player, final IScaledResolution resolution, final float partialTicks)
    {
        forgeItem.renderHelmetOverlay(ItemStack.asForge(stack), PlayerEntity.asForge(player), ((ScaledResolution)resolution).getForgeResolution(), partialTicks);
    }

    @Override
    public int getDamage(final IItemStack stack)
    {
        return forgeItem.getDamage(ItemStack.asForge(stack));
    }

    @Override
    public int getMetadata(final IItemStack stack)
    {
        return forgeItem.getMetadata(ItemStack.asForge(stack));
    }

    @Override
    public boolean showDurabilityBar(final IItemStack stack)
    {
        return forgeItem.showDurabilityBar(ItemStack.asForge(stack));
    }

    @Override
    public double getDurabilityForDisplay(final IItemStack stack)
    {
        return forgeItem.getDurabilityForDisplay(ItemStack.asForge(stack));
    }

    @Override
    public int getRGBDurabilityForDisplay(final IItemStack stack)
    {
        return forgeItem.getRGBDurabilityForDisplay(ItemStack.asForge(stack));
    }

    @Override
    public int getMaxDamage(final IItemStack stack)
    {
        return forgeItem.getMaxDamage(ItemStack.asForge(stack));
    }

    @Override
    public boolean isDamaged(final IItemStack stack)
    {
        return forgeItem.isDamaged(ItemStack.asForge(stack));
    }

    @Override
    public void setDamage(final IItemStack stack, final int damage)
    {
        forgeItem.setDamage(ItemStack.asForge(stack), damage);
    }

    @Override
    public boolean canDestroyBlockInCreative(final IDimension IDimension, final IBlockCoordinate pos, final IItemStack stack, final IPlayerEntity player)
    {
        return forgeItem.canDestroyBlockInCreative(Dimension.asForge(IDimension), BlockCoordinate.asForge(pos), ItemStack.asForge(stack), PlayerEntity.asForge(player));
    }

    @Override
    public boolean canHarvestBlock(final IBlockState state, final IItemStack stack)
    {
        return forgeItem.canHarvestBlock(BlockState.asForge(state), ItemStack.asForge(stack));
    }

    @Override
    public int getItemStackLimit(final IItemStack stack)
    {
        return forgeItem.getItemStackLimit(ItemStack.asForge(stack));
    }

    @Override
    public void setHarvestLevel(final String toolClass, final int level)
    {
        forgeItem.setHarvestLevel(toolClass, level);
    }

    @Override
    public Set<String> getToolClasses(final IItemStack stack)
    {
        return forgeItem.getToolClasses(ItemStack.asForge(stack));
    }

    @Override
    public int getHarvestLevel(final IItemStack stack, final String toolClass, final IPlayerEntity player, final IBlockState blockState)
    {
        return forgeItem.getHarvestLevel(ItemStack.asForge(stack), toolClass, PlayerEntity.asForge(player), BlockState.asForge(blockState));
    }

    @Override
    public int getItemEnchantability(final IItemStack stack)
    {
        return forgeItem.getItemEnchantability(ItemStack.asForge(stack));
    }

    @Override
    public boolean canApplyAtEnchantingTable(final IItemStack stack, final IEnchantment enchantment)
    {
        return forgeItem.canApplyAtEnchantingTable(ItemStack.asForge(stack), Enchantment.asForge(enchantment));
    }

    @Override
    public boolean isBeaconPayment(final IItemStack stack)
    {
        return forgeItem.isBeaconPayment(ItemStack.asForge(stack));
    }

    @Override
    public boolean shouldCauseReequipAnimation(final IItemStack oldStack, final IItemStack newStack, final boolean slotChanged)
    {
        return forgeItem.shouldCauseReequipAnimation(ItemStack.asForge(oldStack), ItemStack.asForge(newStack), slotChanged);
    }

    @Override
    public boolean shouldCauseBlockBreakReset(final IItemStack oldStack, final IItemStack newStack)
    {
        return forgeItem.shouldCauseBlockBreakReset(ItemStack.asForge(oldStack), ItemStack.asForge(newStack));
    }

    @Override
    public boolean canContinueUsing(final IItemStack oldStack, final IItemStack newStack)
    {
        return forgeItem.canContinueUsing(ItemStack.asForge(oldStack), ItemStack.asForge(newStack));
    }

    @Override
    public String getCreatorModId(final IItemStack stack)
    {
        return forgeItem.getCreatorModId(ItemStack.asForge(stack));
    }

    @Override
    public ImmutableMap<String, ITimedValue> getAnimationParameters(
      final IItemStack stack, final IDimension world, final ILivingBaseEntity iEntity)
    {
        final Map<String, ITimedValue> value = forgeItem.getAnimationParameters(ItemStack.asForge(stack), Dimension.asForge(world), LivingBaseEntity.asForge(iEntity))
                                                .entrySet().stream()
                                                    .collect(Collectors.toMap(
                                                      Map.Entry::getKey,
                                                      e -> TimedValue.fromForge(e.getValue())
                                                    ));
        
        return ImmutableMap.<String, ITimedValue>builder().putAll(value).build();
    }

    @Override
    public boolean canDisableShield(final IItemStack stack, final IItemStack shield, final ILivingBaseEntity iEntity, final ILivingBaseEntity attacker)
    {
        return forgeItem.canDisableShield(ItemStack.asForge(stack), ItemStack.asForge(shield), LivingBaseEntity.asForge(iEntity), LivingBaseEntity.asForge(attacker));
    }

    @Override
    public boolean isShield(final IItemStack stack, final ILivingBaseEntity iEntity)
    {
        return forgeItem.isShield(ItemStack.asForge(stack), LivingBaseEntity.asForge(iEntity));
    }

    @Override
    public int getItemBurnTime(final IItemStack stack)
    {
        return forgeItem.getItemBurnTime(ItemStack.asForge(stack));
    }

    @Override
    public IHorseArmorType getHorseArmorType(final IItemStack stack)
    {
        return HorseArmorType.fromForge(forgeItem.getHorseArmorType(ItemStack.asForge(stack)));
    }

    @Override
    public String getHorseArmorTexture(final ILivingEntity wearer, final IItemStack stack)
    {
        return forgeItem.getHorseArmorTexture(LivingEntity.asForge(wearer), ItemStack.asForge(stack));
    }

    @Override
    public void onHorseArmorTick(final IDimension world, final ILivingEntity horse, final IItemStack armor)
    {
        forgeItem.onHorseArmorTick(Dimension.asForge(world), LivingEntity.asForge(horse), ItemStack.asForge(armor));
    }

    @Override
    public IBlockEntityRenderer getBlockEntityItemStackRenderer()
    {
        return BlockEntityRenderer.fromForge(forgeItem.getTileEntityItemStackRenderer());
    }

    @Override
    public void setBlockEntityItemStackRenderer(final IBlockEntityRenderer teisr)
    {
        forgeItem.setTileEntityItemStackRenderer(BlockEntityRenderer.asForge(teisr));
    }

    @Override
    public IItemStack createDefaultItemStack()
    {
        return ItemStack.fromForge(forgeItem.getDefaultInstance());
    }

    @Override
    public String getTranslationKey(final IItemStack pItemStack1)
    {
        return forgeItem.getUnlocalizedName();
    }

    @Override
    public IItem setItemGroup(final IItemGroup tab)
    {
        return new Item(forgeItem.setCreativeTab(ItemGroup.asForge(tab)));
    }

    @Override
    public void getSubItems(IItemGroup<?> tab, List<IItemStack> items)
    {
        final NonNullList<net.minecraft.item.ItemStack> nonNullList = NonNullList.create();
        forgeItem.getSubItems(ItemGroup.asForge(tab), nonNullList);
        nonNullList.forEach(item -> items.add(ItemStack.fromForge(item)));
    }

    @Override
    public void addInformation(final IItemStack stack, final IDimension worldIn, final List<String> tooltip, final IToolTipFlag flagIn)
    {
        forgeItem.addInformation(ItemStack.asForge(stack), Dimension.asForge(worldIn), tooltip, ToolTipFlag.asForge(flagIn));
    }

    @Override
    public DummyInstanceData getInstanceData()
    {
        return new DummyInstanceData();
    }

    @Override
    public IItem<DummyInstanceData> setRegistryIdentifier(final IIdentifier name)
    {
        forgeItem = forgeItem.setRegistryName(Identifier.asForge(name));
        return this;
    }

    @Override
    public IIdentifier getRegistryIdentifier()
    {
        return Identifier.fromForge(forgeItem.getRegistryName());
    }

    @Override
    public Class<? extends IItem<DummyInstanceData>> getTypeUsedForRegistration()
    {
        return getClass();
    }

    private net.minecraft.item.Item getForgeItem()
    {
        return forgeItem;
    }

    public static net.minecraft.item.Item asForge(IItem<?> item)
    {
        if (item instanceof net.minecraft.item.Item)
            return (net.minecraft.item.Item) item;

        return ((Item) item).getForgeItem();
    }

    public static IItem<?> fromForge(net.minecraft.item.Item item)
    {
        if (item instanceof IItem)
            return (IItem<?>) item;

        return new Item(item);
    }
}
