package com.ldtteam.jvoxelizer.launcher.forge_1_13.item.logic.builder;

import com.ldtteam.jvoxelizer.item.IItem;
import com.ldtteam.jvoxelizer.item.logic.builder.AbstractItemBuilder;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.item.JVoxItem;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.item.logic.pipeline.ForgeItemPipeline;

public class ItemBuilder<I> extends AbstractItemBuilder<ItemBuilder<I>, I, IItem<I>>
{
    @Override
    public IItem<I> build(final I instanceData)
    {
        return new JVoxItem<>(
          instanceData,
          new ForgeItemPipeline<IItem<I>, I>(
            SetMaxDamagePipeline,
            UpdateItemStackNBTPipeline,
            GetDestroySpeedPipeline,
            GetSmeltingExperiencePipeline,
            SetDamagePipeline,
            GetUnlocalizedNamePipeline,
            GetUnlocalizedNameWithStackAsItemStackPipeline,
            GetItemEnchantabilityPipeline,
            GetItemEnchantabilityWithStackAsItemStackPipeline,
            GetTileEntityItemStackRendererPipeline,
            GetArmorModelPipeline,
            OnEntityItemUpdatePipeline,
            GetDamagePipeline,
            CanDisableShieldPipeline,
            HitEntityPipeline,
            CanDestroyBlockInCreativePipeline,
            GetToolClassesPipeline,
            OnPlayerStoppedUsingPipeline,
            AddPropertyOverridePipeline,
            IsMapPipeline,
            GetShareTagPipeline,
            OnDroppedByPlayerPipeline,
            OnEntitySwingPipeline,
            GetAttributeModifiersPipeline,
            SetCreativeTabPipeline,
            SetMaxStackSizePipeline,
            GetCreativeTabPipeline,
            OnBlockStartBreakPipeline,
            GetDefaultInstancePipeline,
            GetAnimationParametersPipeline,
            GetEntityLifespanPipeline,
            GetArmorTexturePipeline,
            IsBeaconPaymentPipeline,
            GetMaxDamagePipeline,
            GetMaxDamageWithStackAsItemStackPipeline,
            GetCreatorModIdPipeline,
            OnItemUsePipeline,
            IsDamagedPipeline,
            OnArmorTickPipeline,
            GetNBTShareTagPipeline,
            IsValidArmorPipeline,
            HasContainerItemPipeline,
            HasContainerItemWithStackAsItemStackPipeline,
            GetSubItemsPipeline,
            IsShieldPipeline,
            OnItemUseFinishPipeline,
            OnItemUseFirstPipeline,
            GetHorseArmorTypePipeline,
            GetItemUseActionPipeline,
            InitCapabilitiesPipeline,
            HasCustomPropertiesPipeline,
            GetItemBurnTimePipeline,
            GetFontRendererPipeline,
            OnUpdatePipeline,
            CanApplyAtEnchantingTablePipeline,
            GetPropertyGetterPipeline,
            GetUnlocalizedNameInefficientlyPipeline,
            GetHarvestLevelPipeline,
            GetRarityPipeline,
            CanHarvestBlockPipeline,
            CanHarvestBlockWithStateAsIBlockStateAndStackAsItemStackPipeline,
            RenderHelmetOverlayPipeline,
            GetItemAttributeModifiersPipeline,
            ShouldCauseBlockBreakResetPipeline,
            ShouldCauseReequipAnimationPipeline,
            AddInformationPipeline,
            IsInCreativeTabPipeline,
            IsEnchantablePipeline,
            SetTileEntityItemStackRendererPipeline,
            SetContainerItemPipeline,
            ShowDurabilityBarPipeline,
            GetMetadataPipeline,
            GetMetadataWithStackAsItemStackPipeline,
            IsBookEnchantablePipeline,
            OnUsingTickPipeline,
            CreateEntityPipeline,
            GetCreativeTabsPipeline,
            ShouldRotateAroundWhenRenderingPipeline,
            IsRepairablePipeline,
            GetMaxItemUseDurationPipeline,
            GetRGBDurabilityForDisplayPipeline,
            IsDamageablePipeline,
            SetUnlocalizedNamePipeline,
            SetFull3DPipeline,
            OnLeftClickEntityPipeline,
            OnBlockDestroyedPipeline,
            GetDurabilityForDisplayPipeline,
            OnHorseArmorTickPipeline,
            IsFull3DPipeline,
            GetIsRepairablePipeline,
            OnItemRightClickPipeline,
            HasCustomEntityPipeline,
            GetHighlightTipPipeline,
            GetHasSubtypesPipeline,
            HasEffectPipeline,
            CanItemEditBlocksPipeline,
            ItemInteractionForEntityPipeline,
            DoesSneakBypassUsePipeline,
            SetNoRepairPipeline,
            GetContainerItemPipeline,
            GetContainerItemWithItemStackAsItemStackPipeline,
            GetItemStackDisplayNamePipeline,
            RayTracePipeline,
            ReadNBTShareTagPipeline,
            GetEquipmentSlotPipeline,
            GetItemStackLimitPipeline,
            GetItemStackLimitWithStackAsItemStackPipeline,
            SetHasSubtypesPipeline,
            GetHorseArmorTexturePipeline,
            OnCreatedPipeline,
            SetHarvestLevelPipeline
          )
        );
    }
}
