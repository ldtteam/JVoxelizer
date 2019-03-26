package com.ldtteam.jvoxelizer.launcher.forge_1_12.item.logic.pipeline;

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

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public class ForgeItemPipeline<O extends IItem<I>, I>
{

        private final List<Function<TypedPipelineElementContext<SetMaxDamageContext, O, O, I>, O>> SetMaxDamagePipeline;

        private final List<Function<TypedPipelineElementContext<UpdateItemStackNBTContext, Boolean, O, I>, Boolean>> UpdateItemStackNBTPipeline;

        private final List<Function<TypedPipelineElementContext<GetDestroySpeedContext, Float, O, I>, Float>> GetDestroySpeedPipeline;

        private final List<Function<TypedPipelineElementContext<GetSmeltingExperienceContext, Float, O, I>, Float>> GetSmeltingExperiencePipeline;

        private final List<Consumer<VoidPipelineElementContext<SetDamageContext, O, I>>> SetDamagePipeline;

        private final List<Function<TypedPipelineElementContext<GetUnlocalizedNameContext, String, O, I>, String>> GetUnlocalizedNamePipeline;

        private final List<Function<TypedPipelineElementContext<GetUnlocalizedNameWithStackAsItemStackContext, String, O, I>, String>> GetUnlocalizedNameWithStackAsItemStackPipeline;

        private final List<Function<TypedPipelineElementContext<GetItemEnchantabilityContext, Integer, O, I>, Integer>> GetItemEnchantabilityPipeline;

        private final List<Function<TypedPipelineElementContext<GetItemEnchantabilityWithStackAsItemStackContext, Integer, O, I>, Integer>> GetItemEnchantabilityWithStackAsItemStackPipeline;

        private final List<Function<TypedPipelineElementContext<GetTileEntityItemStackRendererContext, IBlockEntityRenderer, O, I>, IBlockEntityRenderer>> GetTileEntityItemStackRendererPipeline;

        private final List<Function<TypedPipelineElementContext<GetXpRepairRatioContext, Float, O, I>, Float>> GetXpRepairRatioPipeline;

        private final List<Function<TypedPipelineElementContext<GetArmorModelContext, IModelBiped, O, I>, IModelBiped>> GetArmorModelPipeline;

        private final List<Function<TypedPipelineElementContext<OnEntityItemUpdateContext, Boolean, O, I>, Boolean>> OnEntityItemUpdatePipeline;

        private final List<Function<TypedPipelineElementContext<GetDamageContext, Integer, O, I>, Integer>> GetDamagePipeline;

        private final List<Function<TypedPipelineElementContext<CanDisableShieldContext, Boolean, O, I>, Boolean>> CanDisableShieldPipeline;

        private final List<Function<TypedPipelineElementContext<HitEntityContext, Boolean, O, I>, Boolean>> HitEntityPipeline;

        private final List<Function<TypedPipelineElementContext<CanDestroyBlockInCreativeContext, Boolean, O, I>, Boolean>> CanDestroyBlockInCreativePipeline;

        private final List<Function<TypedPipelineElementContext<GetToolClassesContext, Set<String>, O, I>, Set<String>>> GetToolClassesPipeline;

        private final List<Consumer<VoidPipelineElementContext<OnPlayerStoppedUsingContext, O, I>>> OnPlayerStoppedUsingPipeline;

        private final List<Consumer<VoidPipelineElementContext<AddPropertyOverrideContext, O, I>>> AddPropertyOverridePipeline;

        private final List<Function<TypedPipelineElementContext<IsMapContext, Boolean, O, I>, Boolean>> IsMapPipeline;

        private final List<Function<TypedPipelineElementContext<GetShareTagContext, Boolean, O, I>, Boolean>> GetShareTagPipeline;

        private final List<Function<TypedPipelineElementContext<OnDroppedByPlayerContext, Boolean, O, I>, Boolean>> OnDroppedByPlayerPipeline;

        private final List<Function<TypedPipelineElementContext<OnEntitySwingContext, Boolean, O, I>, Boolean>> OnEntitySwingPipeline;

        private final List<Function<TypedPipelineElementContext<GetAttributeModifiersContext, Multimap<String, IAttributeModifier>, O, I>, Multimap<String, IAttributeModifier>>> GetAttributeModifiersPipeline;

        private final List<Function<TypedPipelineElementContext<SetCreativeTabContext, O, O, I>, O>> SetCreativeTabPipeline;

        private final List<Function<TypedPipelineElementContext<SetMaxStackSizeContext, O, O, I>, O>> SetMaxStackSizePipeline;

        private final List<Function<TypedPipelineElementContext<GetCreativeTabContext, IItemGroup<?>, O, I>, IItemGroup<?>>> GetCreativeTabPipeline;

        private final List<Function<TypedPipelineElementContext<OnBlockStartBreakContext, Boolean, O, I>, Boolean>> OnBlockStartBreakPipeline;

        private final List<Function<TypedPipelineElementContext<GetDefaultInstanceContext, IItemStack, O, I>, IItemStack>> GetDefaultInstancePipeline;

        private final List<Function<TypedPipelineElementContext<GetAnimationParametersContext, ImmutableMap<String, ITimedValue>, O, I>, ImmutableMap<String, ITimedValue>>> GetAnimationParametersPipeline;

        private final List<Function<TypedPipelineElementContext<GetEntityLifespanContext, Integer, O, I>, Integer>> GetEntityLifespanPipeline;

        private final List<Function<TypedPipelineElementContext<GetArmorTextureContext, String, O, I>, String>> GetArmorTexturePipeline;

        private final List<Function<TypedPipelineElementContext<IsBeaconPaymentContext, Boolean, O, I>, Boolean>> IsBeaconPaymentPipeline;

        private final List<Function<TypedPipelineElementContext<GetMaxDamageContext, Integer, O, I>, Integer>> GetMaxDamagePipeline;

        private final List<Function<TypedPipelineElementContext<GetMaxDamageWithStackAsItemStackContext, Integer, O, I>, Integer>> GetMaxDamageWithStackAsItemStackPipeline;

        private final List<Function<TypedPipelineElementContext<GetCreatorModIdContext, String, O, I>, String>> GetCreatorModIdPipeline;

        private final List<Function<TypedPipelineElementContext<OnItemUseContext, IActionResult, O, I>, IActionResult>> OnItemUsePipeline;

        private final List<Function<TypedPipelineElementContext<IsDamagedContext, Boolean, O, I>, Boolean>> IsDamagedPipeline;

        private final List<Consumer<VoidPipelineElementContext<OnArmorTickContext, O, I>>> OnArmorTickPipeline;

        private final List<Function<TypedPipelineElementContext<GetNBTShareTagContext, INBTCompound, O, I>, INBTCompound>> GetNBTShareTagPipeline;

        private final List<Function<TypedPipelineElementContext<IsValidArmorContext, Boolean, O, I>, Boolean>> IsValidArmorPipeline;

        private final List<Function<TypedPipelineElementContext<HasContainerItemContext, Boolean, O, I>, Boolean>> HasContainerItemPipeline;

        private final List<Function<TypedPipelineElementContext<HasContainerItemWithStackAsItemStackContext, Boolean, O, I>, Boolean>> HasContainerItemWithStackAsItemStackPipeline;

        private final List<Consumer<VoidPipelineElementContext<GetSubItemsContext, O, I>>> GetSubItemsPipeline;

        private final List<Function<TypedPipelineElementContext<IsShieldContext, Boolean, O, I>, Boolean>> IsShieldPipeline;

        private final List<Function<TypedPipelineElementContext<OnItemUseFinishContext, IItemStack, O, I>, IItemStack>> OnItemUseFinishPipeline;

        private final List<Function<TypedPipelineElementContext<OnItemUseFirstContext, IActionResult, O, I>, IActionResult>> OnItemUseFirstPipeline;

        private final List<Function<TypedPipelineElementContext<GetHorseArmorTypeContext, IHorseArmorType, O, I>, IHorseArmorType>> GetHorseArmorTypePipeline;

        private final List<Function<TypedPipelineElementContext<GetItemUseActionContext, IActionType, O, I>, IActionType>> GetItemUseActionPipeline;

        private final List<Function<TypedPipelineElementContext<InitCapabilitiesContext, ICapabilityManager, O, I>, ICapabilityManager>> InitCapabilitiesPipeline;

        private final List<Function<TypedPipelineElementContext<HasCustomPropertiesContext, Boolean, O, I>, Boolean>> HasCustomPropertiesPipeline;

        private final List<Function<TypedPipelineElementContext<GetItemBurnTimeContext, Integer, O, I>, Integer>> GetItemBurnTimePipeline;

        private final List<Function<TypedPipelineElementContext<GetFontRendererContext, IFontRenderer, O, I>, IFontRenderer>> GetFontRendererPipeline;

        private final List<Consumer<VoidPipelineElementContext<OnUpdateContext, O, I>>> OnUpdatePipeline;

        private final List<Function<TypedPipelineElementContext<CanApplyAtEnchantingTableContext, Boolean, O, I>, Boolean>> CanApplyAtEnchantingTablePipeline;

        private final List<Function<TypedPipelineElementContext<GetPropertyGetterContext, IItemPropertyGetter, O, I>, IItemPropertyGetter>> GetPropertyGetterPipeline;

        private final List<Function<TypedPipelineElementContext<GetUnlocalizedNameInefficientlyContext, String, O, I>, String>> GetUnlocalizedNameInefficientlyPipeline;

        private final List<Function<TypedPipelineElementContext<GetHarvestLevelContext, Integer, O, I>, Integer>> GetHarvestLevelPipeline;

        private final List<Function<TypedPipelineElementContext<GetRarityContext, IRarity, O, I>, IRarity>> GetRarityPipeline;

        private final List<Function<TypedPipelineElementContext<CanHarvestBlockContext, Boolean, O, I>, Boolean>> CanHarvestBlockPipeline;

        private final List<Function<TypedPipelineElementContext<CanHarvestBlockWithStateAsIBlockStateAndStackAsItemStackContext, Boolean, O, I>, Boolean>> CanHarvestBlockWithStateAsIBlockStateAndStackAsItemStackPipeline;

        private final List<Consumer<VoidPipelineElementContext<RenderHelmetOverlayContext, O, I>>> RenderHelmetOverlayPipeline;

        private final List<Function<TypedPipelineElementContext<GetItemAttributeModifiersContext, Multimap<String, IAttributeModifier>, O, I>, Multimap<String, IAttributeModifier>>> GetItemAttributeModifiersPipeline;

        private final List<Function<TypedPipelineElementContext<ShouldCauseBlockBreakResetContext, Boolean, O, I>, Boolean>> ShouldCauseBlockBreakResetPipeline;

        private final List<Function<TypedPipelineElementContext<ShouldCauseReequipAnimationContext, Boolean, O, I>, Boolean>> ShouldCauseReequipAnimationPipeline;

        private final List<Consumer<VoidPipelineElementContext<AddInformationContext, O, I>>> AddInformationPipeline;

        private final List<Function<TypedPipelineElementContext<IsInCreativeTabContext, Boolean, O, I>, Boolean>> IsInCreativeTabPipeline;

        private final List<Function<TypedPipelineElementContext<IsEnchantableContext, Boolean, O, I>, Boolean>> IsEnchantablePipeline;

        private final List<Consumer<VoidPipelineElementContext<SetTileEntityItemStackRendererContext, O, I>>> SetTileEntityItemStackRendererPipeline;

        private final List<Function<TypedPipelineElementContext<SetContainerItemContext, O, O, I>, O>> SetContainerItemPipeline;

        private final List<Function<TypedPipelineElementContext<ShowDurabilityBarContext, Boolean, O, I>, Boolean>> ShowDurabilityBarPipeline;

        private final List<Function<TypedPipelineElementContext<GetMetadataContext, Integer, O, I>, Integer>> GetMetadataPipeline;

        private final List<Function<TypedPipelineElementContext<GetMetadataWithStackAsItemStackContext, Integer, O, I>, Integer>> GetMetadataWithStackAsItemStackPipeline;

        private final List<Function<TypedPipelineElementContext<IsBookEnchantableContext, Boolean, O, I>, Boolean>> IsBookEnchantablePipeline;

        private final List<Consumer<VoidPipelineElementContext<OnUsingTickContext, O, I>>> OnUsingTickPipeline;

        private final List<Function<TypedPipelineElementContext<CreateEntityContext, IEntity, O, I>, IEntity>> CreateEntityPipeline;

        private final List<Function<TypedPipelineElementContext<GetCreativeTabsContext, IItemGroup<?>[], O, I>, IItemGroup<?>[]>> GetCreativeTabsPipeline;

        private final List<Function<TypedPipelineElementContext<ShouldRotateAroundWhenRenderingContext, Boolean, O, I>, Boolean>> ShouldRotateAroundWhenRenderingPipeline;

        private final List<Function<TypedPipelineElementContext<IsRepairableContext, Boolean, O, I>, Boolean>> IsRepairablePipeline;

        private final List<Function<TypedPipelineElementContext<GetMaxItemUseDurationContext, Integer, O, I>, Integer>> GetMaxItemUseDurationPipeline;

        private final List<Function<TypedPipelineElementContext<GetRGBDurabilityForDisplayContext, Integer, O, I>, Integer>> GetRGBDurabilityForDisplayPipeline;

        private final List<Function<TypedPipelineElementContext<IsDamageableContext, Boolean, O, I>, Boolean>> IsDamageablePipeline;

        private final List<Function<TypedPipelineElementContext<SetUnlocalizedNameContext, O, O, I>, O>> SetUnlocalizedNamePipeline;

        private final List<Function<TypedPipelineElementContext<SetFull3DContext, O, O, I>, O>> SetFull3DPipeline;

        private final List<Function<TypedPipelineElementContext<OnLeftClickEntityContext, Boolean, O, I>, Boolean>> OnLeftClickEntityPipeline;

        private final List<Function<TypedPipelineElementContext<OnBlockDestroyedContext, Boolean, O, I>, Boolean>> OnBlockDestroyedPipeline;

        private final List<Function<TypedPipelineElementContext<GetDurabilityForDisplayContext, Double, O, I>, Double>> GetDurabilityForDisplayPipeline;

        private final List<Consumer<VoidPipelineElementContext<OnHorseArmorTickContext, O, I>>> OnHorseArmorTickPipeline;

        private final List<Function<TypedPipelineElementContext<CanContinueUsingContext, Boolean, O, I>, Boolean>> CanContinueUsingPipeline;

        private final List<Function<TypedPipelineElementContext<IsFull3DContext, Boolean, O, I>, Boolean>> IsFull3DPipeline;

        private final List<Function<TypedPipelineElementContext<GetIsRepairableContext, Boolean, O, I>, Boolean>> GetIsRepairablePipeline;

        private final List<Function<TypedPipelineElementContext<OnItemRightClickContext, IActionResult<IItemStack>, O, I>, IActionResult<IItemStack>>> OnItemRightClickPipeline;

        private final List<Function<TypedPipelineElementContext<HasCustomEntityContext, Boolean, O, I>, Boolean>> HasCustomEntityPipeline;

        private final List<Function<TypedPipelineElementContext<GetHighlightTipContext, String, O, I>, String>> GetHighlightTipPipeline;

        private final List<Function<TypedPipelineElementContext<GetHasSubtypesContext, Boolean, O, I>, Boolean>> GetHasSubtypesPipeline;

        private final List<Function<TypedPipelineElementContext<HasEffectContext, Boolean, O, I>, Boolean>> HasEffectPipeline;

        private final List<Function<TypedPipelineElementContext<CanItemEditBlocksContext, Boolean, O, I>, Boolean>> CanItemEditBlocksPipeline;

        private final List<Function<TypedPipelineElementContext<ItemInteractionForEntityContext, Boolean, O, I>, Boolean>> ItemInteractionForEntityPipeline;

        private final List<Function<TypedPipelineElementContext<DoesSneakBypassUseContext, Boolean, O, I>, Boolean>> DoesSneakBypassUsePipeline;

        private final List<Function<TypedPipelineElementContext<SetNoRepairContext, O, O, I>, O>> SetNoRepairPipeline;

        private final List<Function<TypedPipelineElementContext<GetContainerItemContext, O, O, I>, O>> GetContainerItemPipeline;

        private final List<Function<TypedPipelineElementContext<GetContainerItemWithItemStackAsItemStackContext, IItemStack, O, I>, IItemStack>> GetContainerItemWithItemStackAsItemStackPipeline;

        private final List<Function<TypedPipelineElementContext<GetItemStackDisplayNameContext, String, O, I>, String>> GetItemStackDisplayNamePipeline;

        private final List<Function<TypedPipelineElementContext<RayTraceContext, IRayTraceResult, O, I>, IRayTraceResult>> RayTracePipeline;

        private final List<Consumer<VoidPipelineElementContext<ReadNBTShareTagContext, O, I>>> ReadNBTShareTagPipeline;

        private final List<Function<TypedPipelineElementContext<GetEquipmentSlotContext, IEquipmentSlot, O, I>, IEquipmentSlot>> GetEquipmentSlotPipeline;

        private final List<Function<TypedPipelineElementContext<GetItemStackLimitContext, Integer, O, I>, Integer>> GetItemStackLimitPipeline;

        private final List<Function<TypedPipelineElementContext<GetItemStackLimitWithStackAsItemStackContext, Integer, O, I>, Integer>> GetItemStackLimitWithStackAsItemStackPipeline;

        private final List<Function<TypedPipelineElementContext<SetHasSubtypesContext, O, O, I>, O>> SetHasSubtypesPipeline;

        private final List<Function<TypedPipelineElementContext<GetHorseArmorTextureContext, String, O, I>, String>> GetHorseArmorTexturePipeline;

        private final List<Consumer<VoidPipelineElementContext<OnCreatedContext, O, I>>> OnCreatedPipeline;

        private final List<Consumer<VoidPipelineElementContext<SetHarvestLevelContext, O, I>>> SetHarvestLevelPipeline;

    public ForgeItemPipeline(
      final List<Function<TypedPipelineElementContext<SetMaxDamageContext, O, O, I>, O>> setMaxDamagePipeline,
      final List<Function<TypedPipelineElementContext<UpdateItemStackNBTContext, Boolean, O, I>, Boolean>> updateItemStackNBTPipeline,
      final List<Function<TypedPipelineElementContext<GetDestroySpeedContext, Float, O, I>, Float>> getDestroySpeedPipeline,
      final List<Function<TypedPipelineElementContext<GetSmeltingExperienceContext, Float, O, I>, Float>> getSmeltingExperiencePipeline,
      final List<Consumer<VoidPipelineElementContext<SetDamageContext, O, I>>> setDamagePipeline,
      final List<Function<TypedPipelineElementContext<GetUnlocalizedNameContext, String, O, I>, String>> getUnlocalizedNamePipeline,
      final List<Function<TypedPipelineElementContext<GetUnlocalizedNameWithStackAsItemStackContext, String, O, I>, String>> getUnlocalizedNameWithStackAsItemStackPipeline,
      final List<Function<TypedPipelineElementContext<GetItemEnchantabilityContext, Integer, O, I>, Integer>> getItemEnchantabilityPipeline,
      final List<Function<TypedPipelineElementContext<GetItemEnchantabilityWithStackAsItemStackContext, Integer, O, I>, Integer>> getItemEnchantabilityWithStackAsItemStackPipeline,
      final List<Function<TypedPipelineElementContext<GetTileEntityItemStackRendererContext, IBlockEntityRenderer, O, I>, IBlockEntityRenderer>> getTileEntityItemStackRendererPipeline,
      final List<Function<TypedPipelineElementContext<GetXpRepairRatioContext, Float, O, I>, Float>> getXpRepairRatioPipeline,
      final List<Function<TypedPipelineElementContext<GetArmorModelContext, IModelBiped, O, I>, IModelBiped>> getArmorModelPipeline,
      final List<Function<TypedPipelineElementContext<OnEntityItemUpdateContext, Boolean, O, I>, Boolean>> onEntityItemUpdatePipeline,
      final List<Function<TypedPipelineElementContext<GetDamageContext, Integer, O, I>, Integer>> getDamagePipeline,
      final List<Function<TypedPipelineElementContext<CanDisableShieldContext, Boolean, O, I>, Boolean>> canDisableShieldPipeline,
      final List<Function<TypedPipelineElementContext<HitEntityContext, Boolean, O, I>, Boolean>> hitEntityPipeline,
      final List<Function<TypedPipelineElementContext<CanDestroyBlockInCreativeContext, Boolean, O, I>, Boolean>> canDestroyBlockInCreativePipeline,
      final List<Function<TypedPipelineElementContext<GetToolClassesContext, Set<String>, O, I>, Set<String>>> getToolClassesPipeline,
      final List<Consumer<VoidPipelineElementContext<OnPlayerStoppedUsingContext, O, I>>> onPlayerStoppedUsingPipeline,
      final List<Consumer<VoidPipelineElementContext<AddPropertyOverrideContext, O, I>>> addPropertyOverridePipeline,
      final List<Function<TypedPipelineElementContext<IsMapContext, Boolean, O, I>, Boolean>> isMapPipeline,
      final List<Function<TypedPipelineElementContext<GetShareTagContext, Boolean, O, I>, Boolean>> getShareTagPipeline,
      final List<Function<TypedPipelineElementContext<OnDroppedByPlayerContext, Boolean, O, I>, Boolean>> onDroppedByPlayerPipeline,
      final List<Function<TypedPipelineElementContext<OnEntitySwingContext, Boolean, O, I>, Boolean>> onEntitySwingPipeline,
      final List<Function<TypedPipelineElementContext<GetAttributeModifiersContext, Multimap<String, IAttributeModifier>, O, I>, Multimap<String, IAttributeModifier>>> getAttributeModifiersPipeline,
      final List<Function<TypedPipelineElementContext<SetCreativeTabContext, O, O, I>, O>> setCreativeTabPipeline,
      final List<Function<TypedPipelineElementContext<SetMaxStackSizeContext, O, O, I>, O>> setMaxStackSizePipeline,
      final List<Function<TypedPipelineElementContext<GetCreativeTabContext, IItemGroup<?>, O, I>, IItemGroup<?>>> getCreativeTabPipeline,
      final List<Function<TypedPipelineElementContext<OnBlockStartBreakContext, Boolean, O, I>, Boolean>> onBlockStartBreakPipeline,
      final List<Function<TypedPipelineElementContext<GetDefaultInstanceContext, IItemStack, O, I>, IItemStack>> getDefaultInstancePipeline,
      final List<Function<TypedPipelineElementContext<GetAnimationParametersContext, ImmutableMap<String, ITimedValue>, O, I>, ImmutableMap<String, ITimedValue>>> getAnimationParametersPipeline,
      final List<Function<TypedPipelineElementContext<GetEntityLifespanContext, Integer, O, I>, Integer>> getEntityLifespanPipeline,
      final List<Function<TypedPipelineElementContext<GetArmorTextureContext, String, O, I>, String>> getArmorTexturePipeline,
      final List<Function<TypedPipelineElementContext<IsBeaconPaymentContext, Boolean, O, I>, Boolean>> isBeaconPaymentPipeline,
      final List<Function<TypedPipelineElementContext<GetMaxDamageContext, Integer, O, I>, Integer>> getMaxDamagePipeline,
      final List<Function<TypedPipelineElementContext<GetMaxDamageWithStackAsItemStackContext, Integer, O, I>, Integer>> getMaxDamageWithStackAsItemStackPipeline,
      final List<Function<TypedPipelineElementContext<GetCreatorModIdContext, String, O, I>, String>> getCreatorModIdPipeline,
      final List<Function<TypedPipelineElementContext<OnItemUseContext, IActionResult, O, I>, IActionResult>> onItemUsePipeline,
      final List<Function<TypedPipelineElementContext<IsDamagedContext, Boolean, O, I>, Boolean>> isDamagedPipeline,
      final List<Consumer<VoidPipelineElementContext<OnArmorTickContext, O, I>>> onArmorTickPipeline,
      final List<Function<TypedPipelineElementContext<GetNBTShareTagContext, INBTCompound, O, I>, INBTCompound>> getNBTShareTagPipeline,
      final List<Function<TypedPipelineElementContext<IsValidArmorContext, Boolean, O, I>, Boolean>> isValidArmorPipeline,
      final List<Function<TypedPipelineElementContext<HasContainerItemContext, Boolean, O, I>, Boolean>> hasContainerItemPipeline,
      final List<Function<TypedPipelineElementContext<HasContainerItemWithStackAsItemStackContext, Boolean, O, I>, Boolean>> hasContainerItemWithStackAsItemStackPipeline,
      final List<Consumer<VoidPipelineElementContext<GetSubItemsContext, O, I>>> getSubItemsPipeline,
      final List<Function<TypedPipelineElementContext<IsShieldContext, Boolean, O, I>, Boolean>> isShieldPipeline,
      final List<Function<TypedPipelineElementContext<OnItemUseFinishContext, IItemStack, O, I>, IItemStack>> onItemUseFinishPipeline,
      final List<Function<TypedPipelineElementContext<OnItemUseFirstContext, IActionResult, O, I>, IActionResult>> onItemUseFirstPipeline,
      final List<Function<TypedPipelineElementContext<GetHorseArmorTypeContext, IHorseArmorType, O, I>, IHorseArmorType>> getHorseArmorTypePipeline,
      final List<Function<TypedPipelineElementContext<GetItemUseActionContext, IActionType, O, I>, IActionType>> getItemUseActionPipeline,
      final List<Function<TypedPipelineElementContext<InitCapabilitiesContext, ICapabilityManager, O, I>, ICapabilityManager>> initCapabilitiesPipeline,
      final List<Function<TypedPipelineElementContext<HasCustomPropertiesContext, Boolean, O, I>, Boolean>> hasCustomPropertiesPipeline,
      final List<Function<TypedPipelineElementContext<GetItemBurnTimeContext, Integer, O, I>, Integer>> getItemBurnTimePipeline,
      final List<Function<TypedPipelineElementContext<GetFontRendererContext, IFontRenderer, O, I>, IFontRenderer>> getFontRendererPipeline,
      final List<Consumer<VoidPipelineElementContext<OnUpdateContext, O, I>>> onUpdatePipeline,
      final List<Function<TypedPipelineElementContext<CanApplyAtEnchantingTableContext, Boolean, O, I>, Boolean>> canApplyAtEnchantingTablePipeline,
      final List<Function<TypedPipelineElementContext<GetPropertyGetterContext, IItemPropertyGetter, O, I>, IItemPropertyGetter>> getPropertyGetterPipeline,
      final List<Function<TypedPipelineElementContext<GetUnlocalizedNameInefficientlyContext, String, O, I>, String>> getUnlocalizedNameInefficientlyPipeline,
      final List<Function<TypedPipelineElementContext<GetHarvestLevelContext, Integer, O, I>, Integer>> getHarvestLevelPipeline,
      final List<Function<TypedPipelineElementContext<GetRarityContext, IRarity, O, I>, IRarity>> getRarityPipeline,
      final List<Function<TypedPipelineElementContext<CanHarvestBlockContext, Boolean, O, I>, Boolean>> canHarvestBlockPipeline,
      final List<Function<TypedPipelineElementContext<CanHarvestBlockWithStateAsIBlockStateAndStackAsItemStackContext, Boolean, O, I>, Boolean>> canHarvestBlockWithStateAsIBlockStateAndStackAsItemStackPipeline,
      final List<Consumer<VoidPipelineElementContext<RenderHelmetOverlayContext, O, I>>> renderHelmetOverlayPipeline,
      final List<Function<TypedPipelineElementContext<GetItemAttributeModifiersContext, Multimap<String, IAttributeModifier>, O, I>, Multimap<String, IAttributeModifier>>> getItemAttributeModifiersPipeline,
      final List<Function<TypedPipelineElementContext<ShouldCauseBlockBreakResetContext, Boolean, O, I>, Boolean>> shouldCauseBlockBreakResetPipeline,
      final List<Function<TypedPipelineElementContext<ShouldCauseReequipAnimationContext, Boolean, O, I>, Boolean>> shouldCauseReequipAnimationPipeline,
      final List<Consumer<VoidPipelineElementContext<AddInformationContext, O, I>>> addInformationPipeline,
      final List<Function<TypedPipelineElementContext<IsInCreativeTabContext, Boolean, O, I>, Boolean>> isInCreativeTabPipeline,
      final List<Function<TypedPipelineElementContext<IsEnchantableContext, Boolean, O, I>, Boolean>> isEnchantablePipeline,
      final List<Consumer<VoidPipelineElementContext<SetTileEntityItemStackRendererContext, O, I>>> setTileEntityItemStackRendererPipeline,
      final List<Function<TypedPipelineElementContext<SetContainerItemContext, O, O, I>, O>> setContainerItemPipeline,
      final List<Function<TypedPipelineElementContext<ShowDurabilityBarContext, Boolean, O, I>, Boolean>> showDurabilityBarPipeline,
      final List<Function<TypedPipelineElementContext<GetMetadataContext, Integer, O, I>, Integer>> getMetadataPipeline,
      final List<Function<TypedPipelineElementContext<GetMetadataWithStackAsItemStackContext, Integer, O, I>, Integer>> getMetadataWithStackAsItemStackPipeline,
      final List<Function<TypedPipelineElementContext<IsBookEnchantableContext, Boolean, O, I>, Boolean>> isBookEnchantablePipeline,
      final List<Consumer<VoidPipelineElementContext<OnUsingTickContext, O, I>>> onUsingTickPipeline,
      final List<Function<TypedPipelineElementContext<CreateEntityContext, IEntity, O, I>, IEntity>> createEntityPipeline,
      final List<Function<TypedPipelineElementContext<GetCreativeTabsContext, IItemGroup<?>[], O, I>, IItemGroup<?>[]>> getCreativeTabsPipeline,
      final List<Function<TypedPipelineElementContext<ShouldRotateAroundWhenRenderingContext, Boolean, O, I>, Boolean>> shouldRotateAroundWhenRenderingPipeline,
      final List<Function<TypedPipelineElementContext<IsRepairableContext, Boolean, O, I>, Boolean>> isRepairablePipeline,
      final List<Function<TypedPipelineElementContext<GetMaxItemUseDurationContext, Integer, O, I>, Integer>> getMaxItemUseDurationPipeline,
      final List<Function<TypedPipelineElementContext<GetRGBDurabilityForDisplayContext, Integer, O, I>, Integer>> getRGBDurabilityForDisplayPipeline,
      final List<Function<TypedPipelineElementContext<IsDamageableContext, Boolean, O, I>, Boolean>> isDamageablePipeline,
      final List<Function<TypedPipelineElementContext<SetUnlocalizedNameContext, O, O, I>, O>> setUnlocalizedNamePipeline,
      final List<Function<TypedPipelineElementContext<SetFull3DContext, O, O, I>, O>> setFull3DPipeline,
      final List<Function<TypedPipelineElementContext<OnLeftClickEntityContext, Boolean, O, I>, Boolean>> onLeftClickEntityPipeline,
      final List<Function<TypedPipelineElementContext<OnBlockDestroyedContext, Boolean, O, I>, Boolean>> onBlockDestroyedPipeline,
      final List<Function<TypedPipelineElementContext<GetDurabilityForDisplayContext, Double, O, I>, Double>> getDurabilityForDisplayPipeline,
      final List<Consumer<VoidPipelineElementContext<OnHorseArmorTickContext, O, I>>> onHorseArmorTickPipeline,
      final List<Function<TypedPipelineElementContext<CanContinueUsingContext, Boolean, O, I>, Boolean>> canContinueUsingPipeline,
      final List<Function<TypedPipelineElementContext<IsFull3DContext, Boolean, O, I>, Boolean>> isFull3DPipeline,
      final List<Function<TypedPipelineElementContext<GetIsRepairableContext, Boolean, O, I>, Boolean>> getIsRepairablePipeline,
      final List<Function<TypedPipelineElementContext<OnItemRightClickContext, IActionResult<IItemStack>, O, I>, IActionResult<IItemStack>>> onItemRightClickPipeline,
      final List<Function<TypedPipelineElementContext<HasCustomEntityContext, Boolean, O, I>, Boolean>> hasCustomEntityPipeline,
      final List<Function<TypedPipelineElementContext<GetHighlightTipContext, String, O, I>, String>> getHighlightTipPipeline,
      final List<Function<TypedPipelineElementContext<GetHasSubtypesContext, Boolean, O, I>, Boolean>> getHasSubtypesPipeline,
      final List<Function<TypedPipelineElementContext<HasEffectContext, Boolean, O, I>, Boolean>> hasEffectPipeline,
      final List<Function<TypedPipelineElementContext<CanItemEditBlocksContext, Boolean, O, I>, Boolean>> canItemEditBlocksPipeline,
      final List<Function<TypedPipelineElementContext<ItemInteractionForEntityContext, Boolean, O, I>, Boolean>> itemInteractionForEntityPipeline,
      final List<Function<TypedPipelineElementContext<DoesSneakBypassUseContext, Boolean, O, I>, Boolean>> doesSneakBypassUsePipeline,
      final List<Function<TypedPipelineElementContext<SetNoRepairContext, O, O, I>, O>> setNoRepairPipeline,
      final List<Function<TypedPipelineElementContext<GetContainerItemContext, O, O, I>, O>> getContainerItemPipeline,
      final List<Function<TypedPipelineElementContext<GetContainerItemWithItemStackAsItemStackContext, IItemStack, O, I>, IItemStack>> getContainerItemWithItemStackAsItemStackPipeline,
      final List<Function<TypedPipelineElementContext<GetItemStackDisplayNameContext, String, O, I>, String>> getItemStackDisplayNamePipeline,
      final List<Function<TypedPipelineElementContext<RayTraceContext, IRayTraceResult, O, I>, IRayTraceResult>> rayTracePipeline,
      final List<Consumer<VoidPipelineElementContext<ReadNBTShareTagContext, O, I>>> readNBTShareTagPipeline,
      final List<Function<TypedPipelineElementContext<GetEquipmentSlotContext, IEquipmentSlot, O, I>, IEquipmentSlot>> getEquipmentSlotPipeline,
      final List<Function<TypedPipelineElementContext<GetItemStackLimitContext, Integer, O, I>, Integer>> getItemStackLimitPipeline,
      final List<Function<TypedPipelineElementContext<GetItemStackLimitWithStackAsItemStackContext, Integer, O, I>, Integer>> getItemStackLimitWithStackAsItemStackPipeline,
      final List<Function<TypedPipelineElementContext<SetHasSubtypesContext, O, O, I>, O>> setHasSubtypesPipeline,
      final List<Function<TypedPipelineElementContext<GetHorseArmorTextureContext, String, O, I>, String>> getHorseArmorTexturePipeline,
      final List<Consumer<VoidPipelineElementContext<OnCreatedContext, O, I>>> onCreatedPipeline,
      final List<Consumer<VoidPipelineElementContext<SetHarvestLevelContext, O, I>>> setHarvestLevelPipeline) {
        SetMaxDamagePipeline = setMaxDamagePipeline;
        UpdateItemStackNBTPipeline = updateItemStackNBTPipeline;
        GetDestroySpeedPipeline = getDestroySpeedPipeline;
        GetSmeltingExperiencePipeline = getSmeltingExperiencePipeline;
        SetDamagePipeline = setDamagePipeline;
        GetUnlocalizedNamePipeline = getUnlocalizedNamePipeline;
        GetUnlocalizedNameWithStackAsItemStackPipeline = getUnlocalizedNameWithStackAsItemStackPipeline;
        GetItemEnchantabilityPipeline = getItemEnchantabilityPipeline;
        GetItemEnchantabilityWithStackAsItemStackPipeline = getItemEnchantabilityWithStackAsItemStackPipeline;
        GetTileEntityItemStackRendererPipeline = getTileEntityItemStackRendererPipeline;
        GetXpRepairRatioPipeline = getXpRepairRatioPipeline;
        GetArmorModelPipeline = getArmorModelPipeline;
        OnEntityItemUpdatePipeline = onEntityItemUpdatePipeline;
        GetDamagePipeline = getDamagePipeline;
        CanDisableShieldPipeline = canDisableShieldPipeline;
        HitEntityPipeline = hitEntityPipeline;
        CanDestroyBlockInCreativePipeline = canDestroyBlockInCreativePipeline;
        GetToolClassesPipeline = getToolClassesPipeline;
        OnPlayerStoppedUsingPipeline = onPlayerStoppedUsingPipeline;
        AddPropertyOverridePipeline = addPropertyOverridePipeline;
        IsMapPipeline = isMapPipeline;
        GetShareTagPipeline = getShareTagPipeline;
        OnDroppedByPlayerPipeline = onDroppedByPlayerPipeline;
        OnEntitySwingPipeline = onEntitySwingPipeline;
        GetAttributeModifiersPipeline = getAttributeModifiersPipeline;
        SetCreativeTabPipeline = setCreativeTabPipeline;
        SetMaxStackSizePipeline = setMaxStackSizePipeline;
        GetCreativeTabPipeline = getCreativeTabPipeline;
        OnBlockStartBreakPipeline = onBlockStartBreakPipeline;
        GetDefaultInstancePipeline = getDefaultInstancePipeline;
        GetAnimationParametersPipeline = getAnimationParametersPipeline;
        GetEntityLifespanPipeline = getEntityLifespanPipeline;
        GetArmorTexturePipeline = getArmorTexturePipeline;
        IsBeaconPaymentPipeline = isBeaconPaymentPipeline;
        GetMaxDamagePipeline = getMaxDamagePipeline;
        GetMaxDamageWithStackAsItemStackPipeline = getMaxDamageWithStackAsItemStackPipeline;
        GetCreatorModIdPipeline = getCreatorModIdPipeline;
        OnItemUsePipeline = onItemUsePipeline;
        IsDamagedPipeline = isDamagedPipeline;
        OnArmorTickPipeline = onArmorTickPipeline;
        GetNBTShareTagPipeline = getNBTShareTagPipeline;
        IsValidArmorPipeline = isValidArmorPipeline;
        HasContainerItemPipeline = hasContainerItemPipeline;
        HasContainerItemWithStackAsItemStackPipeline = hasContainerItemWithStackAsItemStackPipeline;
        GetSubItemsPipeline = getSubItemsPipeline;
        IsShieldPipeline = isShieldPipeline;
        OnItemUseFinishPipeline = onItemUseFinishPipeline;
        OnItemUseFirstPipeline = onItemUseFirstPipeline;
        GetHorseArmorTypePipeline = getHorseArmorTypePipeline;
        GetItemUseActionPipeline = getItemUseActionPipeline;
        InitCapabilitiesPipeline = initCapabilitiesPipeline;
        HasCustomPropertiesPipeline = hasCustomPropertiesPipeline;
        GetItemBurnTimePipeline = getItemBurnTimePipeline;
        GetFontRendererPipeline = getFontRendererPipeline;
        OnUpdatePipeline = onUpdatePipeline;
        CanApplyAtEnchantingTablePipeline = canApplyAtEnchantingTablePipeline;
        GetPropertyGetterPipeline = getPropertyGetterPipeline;
        GetUnlocalizedNameInefficientlyPipeline = getUnlocalizedNameInefficientlyPipeline;
        GetHarvestLevelPipeline = getHarvestLevelPipeline;
        GetRarityPipeline = getRarityPipeline;
        CanHarvestBlockPipeline = canHarvestBlockPipeline;
        CanHarvestBlockWithStateAsIBlockStateAndStackAsItemStackPipeline = canHarvestBlockWithStateAsIBlockStateAndStackAsItemStackPipeline;
        RenderHelmetOverlayPipeline = renderHelmetOverlayPipeline;
        GetItemAttributeModifiersPipeline = getItemAttributeModifiersPipeline;
        ShouldCauseBlockBreakResetPipeline = shouldCauseBlockBreakResetPipeline;
        ShouldCauseReequipAnimationPipeline = shouldCauseReequipAnimationPipeline;
        AddInformationPipeline = addInformationPipeline;
        IsInCreativeTabPipeline = isInCreativeTabPipeline;
        IsEnchantablePipeline = isEnchantablePipeline;
        SetTileEntityItemStackRendererPipeline = setTileEntityItemStackRendererPipeline;
        SetContainerItemPipeline = setContainerItemPipeline;
        ShowDurabilityBarPipeline = showDurabilityBarPipeline;
        GetMetadataPipeline = getMetadataPipeline;
        GetMetadataWithStackAsItemStackPipeline = getMetadataWithStackAsItemStackPipeline;
        IsBookEnchantablePipeline = isBookEnchantablePipeline;
        OnUsingTickPipeline = onUsingTickPipeline;
        CreateEntityPipeline = createEntityPipeline;
        GetCreativeTabsPipeline = getCreativeTabsPipeline;
        ShouldRotateAroundWhenRenderingPipeline = shouldRotateAroundWhenRenderingPipeline;
        IsRepairablePipeline = isRepairablePipeline;
        GetMaxItemUseDurationPipeline = getMaxItemUseDurationPipeline;
        GetRGBDurabilityForDisplayPipeline = getRGBDurabilityForDisplayPipeline;
        IsDamageablePipeline = isDamageablePipeline;
        SetUnlocalizedNamePipeline = setUnlocalizedNamePipeline;
        SetFull3DPipeline = setFull3DPipeline;
        OnLeftClickEntityPipeline = onLeftClickEntityPipeline;
        OnBlockDestroyedPipeline = onBlockDestroyedPipeline;
        GetDurabilityForDisplayPipeline = getDurabilityForDisplayPipeline;
        OnHorseArmorTickPipeline = onHorseArmorTickPipeline;
        CanContinueUsingPipeline = canContinueUsingPipeline;
        IsFull3DPipeline = isFull3DPipeline;
        GetIsRepairablePipeline = getIsRepairablePipeline;
        OnItemRightClickPipeline = onItemRightClickPipeline;
        HasCustomEntityPipeline = hasCustomEntityPipeline;
        GetHighlightTipPipeline = getHighlightTipPipeline;
        GetHasSubtypesPipeline = getHasSubtypesPipeline;
        HasEffectPipeline = hasEffectPipeline;
        CanItemEditBlocksPipeline = canItemEditBlocksPipeline;
        ItemInteractionForEntityPipeline = itemInteractionForEntityPipeline;
        DoesSneakBypassUsePipeline = doesSneakBypassUsePipeline;
        SetNoRepairPipeline = setNoRepairPipeline;
        GetContainerItemPipeline = getContainerItemPipeline;
        GetContainerItemWithItemStackAsItemStackPipeline = getContainerItemWithItemStackAsItemStackPipeline;
        GetItemStackDisplayNamePipeline = getItemStackDisplayNamePipeline;
        RayTracePipeline = rayTracePipeline;
        ReadNBTShareTagPipeline = readNBTShareTagPipeline;
        GetEquipmentSlotPipeline = getEquipmentSlotPipeline;
        GetItemStackLimitPipeline = getItemStackLimitPipeline;
        GetItemStackLimitWithStackAsItemStackPipeline = getItemStackLimitWithStackAsItemStackPipeline;
        SetHasSubtypesPipeline = setHasSubtypesPipeline;
        GetHorseArmorTexturePipeline = getHorseArmorTexturePipeline;
        OnCreatedPipeline = onCreatedPipeline;
        SetHarvestLevelPipeline = setHarvestLevelPipeline;
    }
}
