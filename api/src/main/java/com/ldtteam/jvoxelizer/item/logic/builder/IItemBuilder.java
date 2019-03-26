package com.ldtteam.jvoxelizer.item.logic.builder;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import com.ldtteam.jvoxelizer.client.model.IModelBiped;
import com.ldtteam.jvoxelizer.client.renderer.blockentity.IBlockEntityRenderer;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.common.animation.ITimedValue;
import com.ldtteam.jvoxelizer.common.capability.ICapabilityManager;
import com.ldtteam.jvoxelizer.core.logic.TypedPipelineElementContext;
import com.ldtteam.jvoxelizer.core.logic.VoidPipelineElementContext;
import com.ldtteam.jvoxelizer.entity.IEntity;
import com.ldtteam.jvoxelizer.entity.ai.IAttributeModifier;
import com.ldtteam.jvoxelizer.entity.passive.IHorseArmorType;
import com.ldtteam.jvoxelizer.item.IItem;
import com.ldtteam.jvoxelizer.item.IItemPropertyGetter;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.group.IItemGroup;
import com.ldtteam.jvoxelizer.item.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.util.action.IActionType;
import com.ldtteam.jvoxelizer.util.actionresult.IActionResult;
import com.ldtteam.jvoxelizer.util.equipmentslot.IEquipmentSlot;
import com.ldtteam.jvoxelizer.util.math.raytraceresult.IRayTraceResult;
import com.ldtteam.jvoxelizer.util.nbt.INBTCompound;
import com.ldtteam.jvoxelizer.util.rarity.IRarity;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public interface IItemBuilder<C extends AbstractItemBuilder<C, I, O>, I, O extends IItem<I>>
{
    static <I> IItemBuilder<?, I, IItem<I>> create()
    {
        return IItemBuilderProviderHolder.getInstance().provide();
    }

    C SetMaxDamage(Function<TypedPipelineElementContext<SetMaxDamageContext, O, O, I>, O>... components);

    C UpdateItemStackNBT(Function<TypedPipelineElementContext<UpdateItemStackNBTContext, Boolean, O, I>, Boolean>... components);

    C GetDestroySpeed(Function<TypedPipelineElementContext<GetDestroySpeedContext, Float, O, I>, Float>... components);

    C GetSmeltingExperience(Function<TypedPipelineElementContext<GetSmeltingExperienceContext, Float, O, I>, Float>... components);

    C SetDamage(Consumer<VoidPipelineElementContext<SetDamageContext, O, I>>... components);

    C GetUnlocalizedName(Function<TypedPipelineElementContext<GetUnlocalizedNameContext, String, O, I>, String>... components);

    C GetUnlocalizedNameWithStackAsItemStack(Function<TypedPipelineElementContext<GetUnlocalizedNameWithStackAsItemStackContext, String, O, I>, String>... components);

    C GetItemEnchantability(Function<TypedPipelineElementContext<GetItemEnchantabilityContext, Integer, O, I>, Integer>... components);

    C GetItemEnchantabilityWithStackAsItemStack(Function<TypedPipelineElementContext<GetItemEnchantabilityWithStackAsItemStackContext, Integer, O, I>, Integer>... components);

    C GetTileEntityItemStackRenderer(Function<TypedPipelineElementContext<GetTileEntityItemStackRendererContext, IBlockEntityRenderer, O, I>, IBlockEntityRenderer>... components);

    C GetXpRepairRatio(Function<TypedPipelineElementContext<GetXpRepairRatioContext, Float, O, I>, Float>... components);

    C GetArmorModel(Function<TypedPipelineElementContext<GetArmorModelContext, IModelBiped, O, I>, IModelBiped>... components);

    C OnEntityItemUpdate(Function<TypedPipelineElementContext<OnEntityItemUpdateContext, Boolean, O, I>, Boolean>... components);

    C GetDamage(Function<TypedPipelineElementContext<GetDamageContext, Integer, O, I>, Integer>... components);

    C CanDisableShield(Function<TypedPipelineElementContext<CanDisableShieldContext, Boolean, O, I>, Boolean>... components);

    C HitEntity(Function<TypedPipelineElementContext<HitEntityContext, Boolean, O, I>, Boolean>... components);

    C CanDestroyBlockInCreative(Function<TypedPipelineElementContext<CanDestroyBlockInCreativeContext, Boolean, O, I>, Boolean>... components);

    C GetToolClasses(Function<TypedPipelineElementContext<GetToolClassesContext, Set<String>, O, I>, Set<String>>... components);

    C OnPlayerStoppedUsing(Consumer<VoidPipelineElementContext<OnPlayerStoppedUsingContext, O, I>>... components);

    C AddPropertyOverride(Consumer<VoidPipelineElementContext<AddPropertyOverrideContext, O, I>>... components);

    C IsMap(Function<TypedPipelineElementContext<IsMapContext, Boolean, O, I>, Boolean>... components);

    C GetShareTag(Function<TypedPipelineElementContext<GetShareTagContext, Boolean, O, I>, Boolean>... components);

    C OnDroppedByPlayer(Function<TypedPipelineElementContext<OnDroppedByPlayerContext, Boolean, O, I>, Boolean>... components);

    C OnEntitySwing(Function<TypedPipelineElementContext<OnEntitySwingContext, Boolean, O, I>, Boolean>... components);

    C GetAttributeModifiers(Function<TypedPipelineElementContext<GetAttributeModifiersContext, Multimap<String, IAttributeModifier>, O, I>, Multimap<String, IAttributeModifier>>... components);

    C SetCreativeTab(Function<TypedPipelineElementContext<SetCreativeTabContext, O, O, I>, O>... components);

    C SetMaxStackSize(Function<TypedPipelineElementContext<SetMaxStackSizeContext, O, O, I>, O>... components);

    C GetCreativeTab(Function<TypedPipelineElementContext<GetCreativeTabContext, IItemGroup<?>, O, I>, IItemGroup<?>>... components);

    C OnBlockStartBreak(Function<TypedPipelineElementContext<OnBlockStartBreakContext, Boolean, O, I>, Boolean>... components);

    C GetDefaultInstance(Function<TypedPipelineElementContext<GetDefaultInstanceContext, IItemStack, O, I>, IItemStack>... components);

    C GetAnimationParameters(Function<TypedPipelineElementContext<GetAnimationParametersContext, ImmutableMap<String, ITimedValue>, O, I>, ImmutableMap<String, ITimedValue>>... components);

    C GetEntityLifespan(Function<TypedPipelineElementContext<GetEntityLifespanContext, Integer, O, I>, Integer>... components);

    C GetArmorTexture(Function<TypedPipelineElementContext<GetArmorTextureContext, String, O, I>, String>... components);

    C IsBeaconPayment(Function<TypedPipelineElementContext<IsBeaconPaymentContext, Boolean, O, I>, Boolean>... components);

    C GetMaxDamage(Function<TypedPipelineElementContext<GetMaxDamageContext, Integer, O, I>, Integer>... components);

    C GetMaxDamageWithStackAsItemStack(Function<TypedPipelineElementContext<GetMaxDamageWithStackAsItemStackContext, Integer, O, I>, Integer>... components);

    C GetCreatorModId(Function<TypedPipelineElementContext<GetCreatorModIdContext, String, O, I>, String>... components);

    C OnItemUse(Function<TypedPipelineElementContext<OnItemUseContext, IActionResult, O, I>, IActionResult>... components);

    C IsDamaged(Function<TypedPipelineElementContext<IsDamagedContext, Boolean, O, I>, Boolean>... components);

    C OnArmorTick(Consumer<VoidPipelineElementContext<OnArmorTickContext, O, I>>... components);

    C GetNBTShareTag(Function<TypedPipelineElementContext<GetNBTShareTagContext, INBTCompound, O, I>, INBTCompound>... components);

    C IsValidArmor(Function<TypedPipelineElementContext<IsValidArmorContext, Boolean, O, I>, Boolean>... components);

    C HasContainerItem(Function<TypedPipelineElementContext<HasContainerItemContext, Boolean, O, I>, Boolean>... components);

    C HasContainerItemWithStackAsItemStack(Function<TypedPipelineElementContext<HasContainerItemWithStackAsItemStackContext, Boolean, O, I>, Boolean>... components);

    C GetSubItems(Consumer<VoidPipelineElementContext<GetSubItemsContext, O, I>>... components);

    C IsShield(Function<TypedPipelineElementContext<IsShieldContext, Boolean, O, I>, Boolean>... components);

    C OnItemUseFinish(Function<TypedPipelineElementContext<OnItemUseFinishContext, IItemStack, O, I>, IItemStack>... components);

    C OnItemUseFirst(Function<TypedPipelineElementContext<OnItemUseFirstContext, IActionResult, O, I>, IActionResult>... components);

    C GetHorseArmorType(Function<TypedPipelineElementContext<GetHorseArmorTypeContext, IHorseArmorType, O, I>, IHorseArmorType>... components);

    C GetItemUseAction(Function<TypedPipelineElementContext<GetItemUseActionContext, IActionType, O, I>, IActionType>... components);

    C InitCapabilities(Function<TypedPipelineElementContext<InitCapabilitiesContext, ICapabilityManager, O, I>, ICapabilityManager>... components);

    C HasCustomProperties(Function<TypedPipelineElementContext<HasCustomPropertiesContext, Boolean, O, I>, Boolean>... components);

    C GetItemBurnTime(Function<TypedPipelineElementContext<GetItemBurnTimeContext, Integer, O, I>, Integer>... components);

    C GetFontRenderer(Function<TypedPipelineElementContext<GetFontRendererContext, IFontRenderer, O, I>, IFontRenderer>... components);

    C OnUpdate(Consumer<VoidPipelineElementContext<OnUpdateContext, O, I>>... components);

    C CanApplyAtEnchantingTable(Function<TypedPipelineElementContext<CanApplyAtEnchantingTableContext, Boolean, O, I>, Boolean>... components);

    C GetPropertyGetter(Function<TypedPipelineElementContext<GetPropertyGetterContext, IItemPropertyGetter, O, I>, IItemPropertyGetter>... components);

    C GetUnlocalizedNameInefficiently(Function<TypedPipelineElementContext<GetUnlocalizedNameInefficientlyContext, String, O, I>, String>... components);

    C GetHarvestLevel(Function<TypedPipelineElementContext<GetHarvestLevelContext, Integer, O, I>, Integer>... components);

    C GetRarity(Function<TypedPipelineElementContext<GetRarityContext, IRarity, O, I>, IRarity>... components);

    C CanHarvestBlock(Function<TypedPipelineElementContext<CanHarvestBlockContext, Boolean, O, I>, Boolean>... components);

    C CanHarvestBlockWithStateAsIBlockStateAndStackAsItemStack(Function<TypedPipelineElementContext<CanHarvestBlockWithStateAsIBlockStateAndStackAsItemStackContext, Boolean, O, I>, Boolean>... components);

    C RenderHelmetOverlay(Consumer<VoidPipelineElementContext<RenderHelmetOverlayContext, O, I>>... components);

    C GetItemAttributeModifiers(Function<TypedPipelineElementContext<GetItemAttributeModifiersContext, Multimap<String, IAttributeModifier>, O, I>, Multimap<String, IAttributeModifier>>... components);

    C ShouldCauseBlockBreakReset(Function<TypedPipelineElementContext<ShouldCauseBlockBreakResetContext, Boolean, O, I>, Boolean>... components);

    C ShouldCauseReequipAnimation(Function<TypedPipelineElementContext<ShouldCauseReequipAnimationContext, Boolean, O, I>, Boolean>... components);

    C AddInformation(Consumer<VoidPipelineElementContext<AddInformationContext, O, I>>... components);

    C IsInCreativeTab(Function<TypedPipelineElementContext<IsInCreativeTabContext, Boolean, O, I>, Boolean>... components);

    C IsEnchantable(Function<TypedPipelineElementContext<IsEnchantableContext, Boolean, O, I>, Boolean>... components);

    C SetTileEntityItemStackRenderer(Consumer<VoidPipelineElementContext<SetTileEntityItemStackRendererContext, O, I>>... components);

    C SetContainerItem(Function<TypedPipelineElementContext<SetContainerItemContext, O, O, I>, O>... components);

    C ShowDurabilityBar(Function<TypedPipelineElementContext<ShowDurabilityBarContext, Boolean, O, I>, Boolean>... components);

    C GetMetadata(Function<TypedPipelineElementContext<GetMetadataContext, Integer, O, I>, Integer>... components);

    C GetMetadataWithStackAsItemStack(Function<TypedPipelineElementContext<GetMetadataWithStackAsItemStackContext, Integer, O, I>, Integer>... components);

    C IsBookEnchantable(Function<TypedPipelineElementContext<IsBookEnchantableContext, Boolean, O, I>, Boolean>... components);

    C OnUsingTick(Consumer<VoidPipelineElementContext<OnUsingTickContext, O, I>>... components);

    C CreateEntity(Function<TypedPipelineElementContext<CreateEntityContext, IEntity, O, I>, IEntity>... components);

    C GetCreativeTabs(Function<TypedPipelineElementContext<GetCreativeTabsContext, IItemGroup<?>[], O, I>, IItemGroup<?>[]>... components);

    C ShouldRotateAroundWhenRendering(Function<TypedPipelineElementContext<ShouldRotateAroundWhenRenderingContext, Boolean, O, I>, Boolean>... components);

    C IsRepairable(Function<TypedPipelineElementContext<IsRepairableContext, Boolean, O, I>, Boolean>... components);

    C GetMaxItemUseDuration(Function<TypedPipelineElementContext<GetMaxItemUseDurationContext, Integer, O, I>, Integer>... components);

    C GetRGBDurabilityForDisplay(Function<TypedPipelineElementContext<GetRGBDurabilityForDisplayContext, Integer, O, I>, Integer>... components);

    C IsDamageable(Function<TypedPipelineElementContext<IsDamageableContext, Boolean, O, I>, Boolean>... components);

    C SetUnlocalizedName(Function<TypedPipelineElementContext<SetUnlocalizedNameContext, O, O, I>, O>... components);

    C SetFull3D(Function<TypedPipelineElementContext<SetFull3DContext, O, O, I>, O>... components);

    C OnLeftClickEntity(Function<TypedPipelineElementContext<OnLeftClickEntityContext, Boolean, O, I>, Boolean>... components);

    C OnBlockDestroyed(Function<TypedPipelineElementContext<OnBlockDestroyedContext, Boolean, O, I>, Boolean>... components);

    C GetDurabilityForDisplay(Function<TypedPipelineElementContext<GetDurabilityForDisplayContext, Double, O, I>, Double>... components);

    C OnHorseArmorTick(Consumer<VoidPipelineElementContext<OnHorseArmorTickContext, O, I>>... components);

    C CanContinueUsing(Function<TypedPipelineElementContext<CanContinueUsingContext, Boolean, O, I>, Boolean>... components);

    C IsFull3D(Function<TypedPipelineElementContext<IsFull3DContext, Boolean, O, I>, Boolean>... components);

    C GetIsRepairable(Function<TypedPipelineElementContext<GetIsRepairableContext, Boolean, O, I>, Boolean>... components);

    C OnItemRightClick(Function<TypedPipelineElementContext<OnItemRightClickContext, IActionResult<IItemStack>, O, I>, IActionResult<IItemStack>>... components);

    C HasCustomEntity(Function<TypedPipelineElementContext<HasCustomEntityContext, Boolean, O, I>, Boolean>... components);

    C GetHighlightTip(Function<TypedPipelineElementContext<GetHighlightTipContext, String, O, I>, String>... components);

    C GetHasSubtypes(Function<TypedPipelineElementContext<GetHasSubtypesContext, Boolean, O, I>, Boolean>... components);

    C HasEffect(Function<TypedPipelineElementContext<HasEffectContext, Boolean, O, I>, Boolean>... components);

    C CanItemEditBlocks(Function<TypedPipelineElementContext<CanItemEditBlocksContext, Boolean, O, I>, Boolean>... components);

    C ItemInteractionForEntity(Function<TypedPipelineElementContext<ItemInteractionForEntityContext, Boolean, O, I>, Boolean>... components);

    C DoesSneakBypassUse(Function<TypedPipelineElementContext<DoesSneakBypassUseContext, Boolean, O, I>, Boolean>... components);

    C SetNoRepair(Function<TypedPipelineElementContext<SetNoRepairContext, O, O, I>, O>... components);

    C GetContainerItem(Function<TypedPipelineElementContext<GetContainerItemContext, O, O, I>, O>... components);

    C GetContainerItemWithItemStackAsItemStack(Function<TypedPipelineElementContext<GetContainerItemWithItemStackAsItemStackContext, IItemStack, O, I>, IItemStack>... components);

    C GetItemStackDisplayName(Function<TypedPipelineElementContext<GetItemStackDisplayNameContext, String, O, I>, String>... components);

    C RayTrace(Function<TypedPipelineElementContext<RayTraceContext, IRayTraceResult, O, I>, IRayTraceResult>... components);

    C ReadNBTShareTag(Consumer<VoidPipelineElementContext<ReadNBTShareTagContext, O, I>>... components);

    C GetEquipmentSlot(Function<TypedPipelineElementContext<GetEquipmentSlotContext, IEquipmentSlot, O, I>, IEquipmentSlot>... components);

    C GetItemStackLimit(Function<TypedPipelineElementContext<GetItemStackLimitContext, Integer, O, I>, Integer>... components);

    C GetItemStackLimitWithStackAsItemStack(Function<TypedPipelineElementContext<GetItemStackLimitWithStackAsItemStackContext, Integer, O, I>, Integer>... components);

    C SetHasSubtypes(Function<TypedPipelineElementContext<SetHasSubtypesContext, O, O, I>, O>... components);

    C GetHorseArmorTexture(Function<TypedPipelineElementContext<GetHorseArmorTextureContext, String, O, I>, String>... components);

    C OnCreated(Consumer<VoidPipelineElementContext<OnCreatedContext, O, I>>... components);

    C SetHarvestLevel(Consumer<VoidPipelineElementContext<SetHarvestLevelContext, O, I>>... components);
}
