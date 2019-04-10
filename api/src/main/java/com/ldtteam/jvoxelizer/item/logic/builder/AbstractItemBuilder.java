package com.ldtteam.jvoxelizer.item.logic.builder;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import com.ldtteam.jvoxelizer.common.capability.ICapabilityManager;
import com.ldtteam.jvoxelizer.client.model.IModelBiped;
import com.ldtteam.jvoxelizer.client.renderer.blockentity.IBlockEntityRenderer;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.common.animation.ITimedValue;
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
import com.ldtteam.jvoxelizer.util.actionresult.IActionResultType;
import com.ldtteam.jvoxelizer.util.equipmentslot.IEquipmentSlot;
import com.ldtteam.jvoxelizer.util.math.raytraceresult.IRayTraceResult;
import com.ldtteam.jvoxelizer.util.nbt.INBTCompound;
import com.ldtteam.jvoxelizer.util.rarity.IRarity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class AbstractItemBuilder<C extends AbstractItemBuilder<C, I, O>, I, O extends IItem<I>> implements IItemBuilder<C, I, O>
{
    @Override
    public C SetMaxDamage(Function<TypedPipelineElementContext<SetMaxDamageContext, O, O, I>, O>... components) {
        this.SetMaxDamagePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<SetMaxDamageContext, O, O, I>, O>> SetMaxDamagePipeline = new ArrayList<>();

    @Override
    public C UpdateItemStackNBT(Function<TypedPipelineElementContext<UpdateItemStackNBTContext, Boolean, O, I>, Boolean>... components) {
        this.UpdateItemStackNBTPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<UpdateItemStackNBTContext, Boolean, O, I>, Boolean>> UpdateItemStackNBTPipeline = new ArrayList<>();

    @Override
    public C GetDestroySpeed(Function<TypedPipelineElementContext<GetDestroySpeedContext, Float, O, I>, Float>... components) {
        this.GetDestroySpeedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetDestroySpeedContext, Float, O, I>, Float>> GetDestroySpeedPipeline = new ArrayList<>();

    @Override
    public C GetSmeltingExperience(Function<TypedPipelineElementContext<GetSmeltingExperienceContext, Float, O, I>, Float>... components) {
        this.GetSmeltingExperiencePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetSmeltingExperienceContext, Float, O, I>, Float>> GetSmeltingExperiencePipeline = new ArrayList<>();

    @Override
    public C SetDamage(Consumer<VoidPipelineElementContext<SetDamageContext, O, I>>... components) {
        this.SetDamagePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<SetDamageContext, O, I>>> SetDamagePipeline = new ArrayList<>();

    @Override
    public C GetUnlocalizedName(Function<TypedPipelineElementContext<GetUnlocalizedNameContext, String, O, I>, String>... components) {
        this.GetUnlocalizedNamePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetUnlocalizedNameContext, String, O, I>, String>> GetUnlocalizedNamePipeline = new ArrayList<>();

    @Override
    public C GetUnlocalizedNameWithStackAsItemStack(Function<TypedPipelineElementContext<GetUnlocalizedNameWithStackAsItemStackContext, String, O, I>, String>... components) {
        this.GetUnlocalizedNameWithStackAsItemStackPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetUnlocalizedNameWithStackAsItemStackContext, String, O, I>, String>> GetUnlocalizedNameWithStackAsItemStackPipeline = new ArrayList<>();

    @Override
    public C GetItemEnchantability(Function<TypedPipelineElementContext<GetItemEnchantabilityContext, Integer, O, I>, Integer>... components) {
        this.GetItemEnchantabilityPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetItemEnchantabilityContext, Integer, O, I>, Integer>> GetItemEnchantabilityPipeline = new ArrayList<>();

    @Override
    public C GetItemEnchantabilityWithStackAsItemStack(Function<TypedPipelineElementContext<GetItemEnchantabilityWithStackAsItemStackContext, Integer, O, I>, Integer>... components) {
        this.GetItemEnchantabilityWithStackAsItemStackPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetItemEnchantabilityWithStackAsItemStackContext, Integer, O, I>, Integer>> GetItemEnchantabilityWithStackAsItemStackPipeline = new ArrayList<>();

    @Override
    public C GetTileEntityItemStackRenderer(Function<TypedPipelineElementContext<GetTileEntityItemStackRendererContext, IBlockEntityRenderer, O, I>, IBlockEntityRenderer>... components) {
        this.GetTileEntityItemStackRendererPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetTileEntityItemStackRendererContext, IBlockEntityRenderer, O, I>, IBlockEntityRenderer>> GetTileEntityItemStackRendererPipeline = new ArrayList<>();

    @Override
    public C GetArmorModel(Function<TypedPipelineElementContext<GetArmorModelContext, IModelBiped, O, I>, IModelBiped>... components) {
        this.GetArmorModelPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetArmorModelContext, IModelBiped, O, I>, IModelBiped>> GetArmorModelPipeline = new ArrayList<>();

    @Override
    public C OnEntityItemUpdate(Function<TypedPipelineElementContext<OnEntityItemUpdateContext, Boolean, O, I>, Boolean>... components) {
        this.OnEntityItemUpdatePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<OnEntityItemUpdateContext, Boolean, O, I>, Boolean>> OnEntityItemUpdatePipeline = new ArrayList<>();

    @Override
    public C GetDamage(Function<TypedPipelineElementContext<GetDamageContext, Integer, O, I>, Integer>... components) {
        this.GetDamagePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetDamageContext, Integer, O, I>, Integer>> GetDamagePipeline = new ArrayList<>();

    @Override
    public C CanDisableShield(Function<TypedPipelineElementContext<CanDisableShieldContext, Boolean, O, I>, Boolean>... components) {
        this.CanDisableShieldPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<CanDisableShieldContext, Boolean, O, I>, Boolean>> CanDisableShieldPipeline = new ArrayList<>();

    @Override
    public C HitEntity(Function<TypedPipelineElementContext<HitEntityContext, Boolean, O, I>, Boolean>... components) {
        this.HitEntityPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<HitEntityContext, Boolean, O, I>, Boolean>> HitEntityPipeline = new ArrayList<>();

    @Override
    public C CanDestroyBlockInCreative(Function<TypedPipelineElementContext<CanDestroyBlockInCreativeContext, Boolean, O, I>, Boolean>... components) {
        this.CanDestroyBlockInCreativePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<CanDestroyBlockInCreativeContext, Boolean, O, I>, Boolean>> CanDestroyBlockInCreativePipeline = new ArrayList<>();

    @Override
    public C GetToolClasses(Function<TypedPipelineElementContext<GetToolClassesContext, Set<String>, O, I>, Set<String>>... components) {
        this.GetToolClassesPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetToolClassesContext, Set<String>, O, I>, Set<String>>> GetToolClassesPipeline = new ArrayList<>();

    @Override
    public C OnPlayerStoppedUsing(Consumer<VoidPipelineElementContext<OnPlayerStoppedUsingContext, O, I>>... components) {
        this.OnPlayerStoppedUsingPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<OnPlayerStoppedUsingContext, O, I>>> OnPlayerStoppedUsingPipeline = new ArrayList<>();

    @Override
    public C AddPropertyOverride(Consumer<VoidPipelineElementContext<AddPropertyOverrideContext, O, I>>... components) {
        this.AddPropertyOverridePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<AddPropertyOverrideContext, O, I>>> AddPropertyOverridePipeline = new ArrayList<>();

    @Override
    public C IsMap(Function<TypedPipelineElementContext<IsMapContext, Boolean, O, I>, Boolean>... components) {
        this.IsMapPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<IsMapContext, Boolean, O, I>, Boolean>> IsMapPipeline = new ArrayList<>();

    @Override
    public C GetShareTag(Function<TypedPipelineElementContext<GetShareTagContext, Boolean, O, I>, Boolean>... components) {
        this.GetShareTagPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetShareTagContext, Boolean, O, I>, Boolean>> GetShareTagPipeline = new ArrayList<>();

    @Override
    public C OnDroppedByPlayer(Function<TypedPipelineElementContext<OnDroppedByPlayerContext, Boolean, O, I>, Boolean>... components) {
        this.OnDroppedByPlayerPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<OnDroppedByPlayerContext, Boolean, O, I>, Boolean>> OnDroppedByPlayerPipeline = new ArrayList<>();

    @Override
    public C OnEntitySwing(Function<TypedPipelineElementContext<OnEntitySwingContext, Boolean, O, I>, Boolean>... components) {
        this.OnEntitySwingPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<OnEntitySwingContext, Boolean, O, I>, Boolean>> OnEntitySwingPipeline = new ArrayList<>();

    @Override
    public C GetAttributeModifiers(Function<TypedPipelineElementContext<GetAttributeModifiersContext, Multimap<String, IAttributeModifier>, O, I>, Multimap<String, IAttributeModifier>>... components) {
        this.GetAttributeModifiersPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetAttributeModifiersContext, Multimap<String, IAttributeModifier>, O, I>, Multimap<String, IAttributeModifier>>> GetAttributeModifiersPipeline = new ArrayList<>();

    @Override
    public C SetCreativeTab(Function<TypedPipelineElementContext<SetCreativeTabContext, O, O, I>, O>... components) {
        this.SetCreativeTabPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<SetCreativeTabContext, O, O, I>, O>> SetCreativeTabPipeline = new ArrayList<>();

    @Override
    public C SetMaxStackSize(Function<TypedPipelineElementContext<SetMaxStackSizeContext, O, O, I>, O>... components) {
        this.SetMaxStackSizePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<SetMaxStackSizeContext, O, O, I>, O>> SetMaxStackSizePipeline = new ArrayList<>();

    @Override
    public C GetCreativeTab(Function<TypedPipelineElementContext<GetCreativeTabContext, IItemGroup<?>, O, I>, IItemGroup<?>>... components) {
        this.GetCreativeTabPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetCreativeTabContext, IItemGroup<?>, O, I>, IItemGroup<?>>> GetCreativeTabPipeline = new ArrayList<>();

    @Override
    public C OnBlockStartBreak(Function<TypedPipelineElementContext<OnBlockStartBreakContext, Boolean, O, I>, Boolean>... components) {
        this.OnBlockStartBreakPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<OnBlockStartBreakContext, Boolean, O, I>, Boolean>> OnBlockStartBreakPipeline = new ArrayList<>();

    @Override
    public C GetDefaultInstance(Function<TypedPipelineElementContext<GetDefaultInstanceContext, IItemStack, O, I>, IItemStack>... components) {
        this.GetDefaultInstancePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetDefaultInstanceContext, IItemStack, O, I>, IItemStack>> GetDefaultInstancePipeline = new ArrayList<>();

    @Override
    public C GetAnimationParameters(Function<TypedPipelineElementContext<GetAnimationParametersContext, ImmutableMap<String, ITimedValue>, O, I>, ImmutableMap<String, ITimedValue>>... components) {
        this.GetAnimationParametersPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetAnimationParametersContext, ImmutableMap<String, ITimedValue>, O, I>, ImmutableMap<String, ITimedValue>>> GetAnimationParametersPipeline = new ArrayList<>();

    @Override
    public C GetEntityLifespan(Function<TypedPipelineElementContext<GetEntityLifespanContext, Integer, O, I>, Integer>... components) {
        this.GetEntityLifespanPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetEntityLifespanContext, Integer, O, I>, Integer>> GetEntityLifespanPipeline = new ArrayList<>();

    @Override
    public C GetArmorTexture(Function<TypedPipelineElementContext<GetArmorTextureContext, String, O, I>, String>... components) {
        this.GetArmorTexturePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetArmorTextureContext, String, O, I>, String>> GetArmorTexturePipeline = new ArrayList<>();

    @Override
    public C IsBeaconPayment(Function<TypedPipelineElementContext<IsBeaconPaymentContext, Boolean, O, I>, Boolean>... components) {
        this.IsBeaconPaymentPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<IsBeaconPaymentContext, Boolean, O, I>, Boolean>> IsBeaconPaymentPipeline = new ArrayList<>();

    @Override
    public C GetMaxDamage(Function<TypedPipelineElementContext<GetMaxDamageContext, Integer, O, I>, Integer>... components) {
        this.GetMaxDamagePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetMaxDamageContext, Integer, O, I>, Integer>> GetMaxDamagePipeline = new ArrayList<>();

    @Override
    public C GetMaxDamageWithStackAsItemStack(Function<TypedPipelineElementContext<GetMaxDamageWithStackAsItemStackContext, Integer, O, I>, Integer>... components) {
        this.GetMaxDamageWithStackAsItemStackPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetMaxDamageWithStackAsItemStackContext, Integer, O, I>, Integer>> GetMaxDamageWithStackAsItemStackPipeline = new ArrayList<>();

    @Override
    public C GetCreatorModId(Function<TypedPipelineElementContext<GetCreatorModIdContext, String, O, I>, String>... components) {
        this.GetCreatorModIdPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetCreatorModIdContext, String, O, I>, String>> GetCreatorModIdPipeline = new ArrayList<>();

    @Override
    public C OnItemUse(Function<TypedPipelineElementContext<OnItemUseContext, IActionResultType, O, I>, IActionResultType>... components) {
        this.OnItemUsePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<OnItemUseContext, IActionResultType, O, I>, IActionResultType>> OnItemUsePipeline = new ArrayList<>();

    @Override
    public C IsDamaged(Function<TypedPipelineElementContext<IsDamagedContext, Boolean, O, I>, Boolean>... components) {
        this.IsDamagedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<IsDamagedContext, Boolean, O, I>, Boolean>> IsDamagedPipeline = new ArrayList<>();

    @Override
    public C OnArmorTick(Consumer<VoidPipelineElementContext<OnArmorTickContext, O, I>>... components) {
        this.OnArmorTickPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<OnArmorTickContext, O, I>>> OnArmorTickPipeline = new ArrayList<>();

    @Override
    public C GetNBTShareTag(Function<TypedPipelineElementContext<GetNBTShareTagContext, INBTCompound, O, I>, INBTCompound>... components) {
        this.GetNBTShareTagPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetNBTShareTagContext, INBTCompound, O, I>, INBTCompound>> GetNBTShareTagPipeline = new ArrayList<>();

    @Override
    public C IsValidArmor(Function<TypedPipelineElementContext<IsValidArmorContext, Boolean, O, I>, Boolean>... components) {
        this.IsValidArmorPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<IsValidArmorContext, Boolean, O, I>, Boolean>> IsValidArmorPipeline = new ArrayList<>();

    @Override
    public C HasContainerItem(Function<TypedPipelineElementContext<HasContainerItemContext, Boolean, O, I>, Boolean>... components) {
        this.HasContainerItemPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<HasContainerItemContext, Boolean, O, I>, Boolean>> HasContainerItemPipeline = new ArrayList<>();

    @Override
    public C HasContainerItemWithStackAsItemStack(Function<TypedPipelineElementContext<HasContainerItemWithStackAsItemStackContext, Boolean, O, I>, Boolean>... components) {
        this.HasContainerItemWithStackAsItemStackPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<HasContainerItemWithStackAsItemStackContext, Boolean, O, I>, Boolean>> HasContainerItemWithStackAsItemStackPipeline = new ArrayList<>();

    @Override
    public C GetSubItems(Consumer<VoidPipelineElementContext<GetSubItemsContext, O, I>>... components) {
        this.GetSubItemsPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<GetSubItemsContext, O, I>>> GetSubItemsPipeline = new ArrayList<>();

    @Override
    public C IsShield(Function<TypedPipelineElementContext<IsShieldContext, Boolean, O, I>, Boolean>... components) {
        this.IsShieldPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<IsShieldContext, Boolean, O, I>, Boolean>> IsShieldPipeline = new ArrayList<>();

    @Override
    public C OnItemUseFinish(Function<TypedPipelineElementContext<OnItemUseFinishContext, IItemStack, O, I>, IItemStack>... components) {
        this.OnItemUseFinishPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<OnItemUseFinishContext, IItemStack, O, I>, IItemStack>> OnItemUseFinishPipeline = new ArrayList<>();

    @Override
    public C OnItemUseFirst(Function<TypedPipelineElementContext<OnItemUseFirstContext, IActionResultType, O, I>, IActionResultType>... components) {
        this.OnItemUseFirstPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<OnItemUseFirstContext, IActionResultType, O, I>, IActionResultType>> OnItemUseFirstPipeline = new ArrayList<>();

    @Override
    public C GetHorseArmorType(Function<TypedPipelineElementContext<GetHorseArmorTypeContext, IHorseArmorType, O, I>, IHorseArmorType>... components) {
        this.GetHorseArmorTypePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetHorseArmorTypeContext, IHorseArmorType, O, I>, IHorseArmorType>> GetHorseArmorTypePipeline = new ArrayList<>();

    @Override
    public C GetItemUseAction(Function<TypedPipelineElementContext<GetItemUseActionContext, IActionType, O, I>, IActionType>... components) {
        this.GetItemUseActionPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetItemUseActionContext, IActionType, O, I>, IActionType>> GetItemUseActionPipeline = new ArrayList<>();

    @Override
    public C InitCapabilities(Function<TypedPipelineElementContext<InitCapabilitiesContext, ICapabilityManager, O, I>, ICapabilityManager>... components) {
        this.InitCapabilitiesPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<InitCapabilitiesContext, ICapabilityManager, O, I>, ICapabilityManager>> InitCapabilitiesPipeline = new ArrayList<>();

    @Override
    public C HasCustomProperties(Function<TypedPipelineElementContext<HasCustomPropertiesContext, Boolean, O, I>, Boolean>... components) {
        this.HasCustomPropertiesPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<HasCustomPropertiesContext, Boolean, O, I>, Boolean>> HasCustomPropertiesPipeline = new ArrayList<>();

    @Override
    public C GetItemBurnTime(Function<TypedPipelineElementContext<GetItemBurnTimeContext, Integer, O, I>, Integer>... components) {
        this.GetItemBurnTimePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetItemBurnTimeContext, Integer, O, I>, Integer>> GetItemBurnTimePipeline = new ArrayList<>();

    @Override
    public C GetFontRenderer(Function<TypedPipelineElementContext<GetFontRendererContext, IFontRenderer, O, I>, IFontRenderer>... components) {
        this.GetFontRendererPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetFontRendererContext, IFontRenderer, O, I>, IFontRenderer>> GetFontRendererPipeline = new ArrayList<>();

    @Override
    public C OnUpdate(Consumer<VoidPipelineElementContext<OnUpdateContext, O, I>>... components) {
        this.OnUpdatePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<OnUpdateContext, O, I>>> OnUpdatePipeline = new ArrayList<>();

    @Override
    public C CanApplyAtEnchantingTable(Function<TypedPipelineElementContext<CanApplyAtEnchantingTableContext, Boolean, O, I>, Boolean>... components) {
        this.CanApplyAtEnchantingTablePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<CanApplyAtEnchantingTableContext, Boolean, O, I>, Boolean>> CanApplyAtEnchantingTablePipeline = new ArrayList<>();

    @Override
    public C GetPropertyGetter(Function<TypedPipelineElementContext<GetPropertyGetterContext, IItemPropertyGetter, O, I>, IItemPropertyGetter>... components) {
        this.GetPropertyGetterPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetPropertyGetterContext, IItemPropertyGetter, O, I>, IItemPropertyGetter>> GetPropertyGetterPipeline = new ArrayList<>();

    @Override
    public C GetUnlocalizedNameInefficiently(Function<TypedPipelineElementContext<GetUnlocalizedNameInefficientlyContext, String, O, I>, String>... components) {
        this.GetUnlocalizedNameInefficientlyPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetUnlocalizedNameInefficientlyContext, String, O, I>, String>> GetUnlocalizedNameInefficientlyPipeline = new ArrayList<>();

    @Override
    public C GetHarvestLevel(Function<TypedPipelineElementContext<GetHarvestLevelContext, Integer, O, I>, Integer>... components) {
        this.GetHarvestLevelPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetHarvestLevelContext, Integer, O, I>, Integer>> GetHarvestLevelPipeline = new ArrayList<>();

    @Override
    public C GetRarity(Function<TypedPipelineElementContext<GetRarityContext, IRarity, O, I>, IRarity>... components) {
        this.GetRarityPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetRarityContext, IRarity, O, I>, IRarity>> GetRarityPipeline = new ArrayList<>();

    @Override
    public C CanHarvestBlock(Function<TypedPipelineElementContext<CanHarvestBlockContext, Boolean, O, I>, Boolean>... components) {
        this.CanHarvestBlockPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<CanHarvestBlockContext, Boolean, O, I>, Boolean>> CanHarvestBlockPipeline = new ArrayList<>();

    @Override
    public C CanHarvestBlockWithStateAsIBlockStateAndStackAsItemStack(Function<TypedPipelineElementContext<CanHarvestBlockWithStateAsIBlockStateAndStackAsItemStackContext, Boolean, O, I>, Boolean>... components) {
        this.CanHarvestBlockWithStateAsIBlockStateAndStackAsItemStackPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<CanHarvestBlockWithStateAsIBlockStateAndStackAsItemStackContext, Boolean, O, I>, Boolean>> CanHarvestBlockWithStateAsIBlockStateAndStackAsItemStackPipeline = new ArrayList<>();

    @Override
    public C RenderHelmetOverlay(Consumer<VoidPipelineElementContext<RenderHelmetOverlayContext, O, I>>... components) {
        this.RenderHelmetOverlayPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<RenderHelmetOverlayContext, O, I>>> RenderHelmetOverlayPipeline = new ArrayList<>();

    @Override
    public C GetItemAttributeModifiers(Function<TypedPipelineElementContext<GetItemAttributeModifiersContext, Multimap<String, IAttributeModifier>, O, I>, Multimap<String, IAttributeModifier>>... components) {
        this.GetItemAttributeModifiersPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetItemAttributeModifiersContext, Multimap<String, IAttributeModifier>, O, I>, Multimap<String, IAttributeModifier>>> GetItemAttributeModifiersPipeline = new ArrayList<>();

    @Override
    public C ShouldCauseBlockBreakReset(Function<TypedPipelineElementContext<ShouldCauseBlockBreakResetContext, Boolean, O, I>, Boolean>... components) {
        this.ShouldCauseBlockBreakResetPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<ShouldCauseBlockBreakResetContext, Boolean, O, I>, Boolean>> ShouldCauseBlockBreakResetPipeline = new ArrayList<>();

    @Override
    public C ShouldCauseReequipAnimation(Function<TypedPipelineElementContext<ShouldCauseReequipAnimationContext, Boolean, O, I>, Boolean>... components) {
        this.ShouldCauseReequipAnimationPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<ShouldCauseReequipAnimationContext, Boolean, O, I>, Boolean>> ShouldCauseReequipAnimationPipeline = new ArrayList<>();

    @Override
    public C AddInformation(Consumer<VoidPipelineElementContext<AddInformationContext, O, I>>... components) {
        this.AddInformationPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<AddInformationContext, O, I>>> AddInformationPipeline = new ArrayList<>();

    @Override
    public C IsInCreativeTab(Function<TypedPipelineElementContext<IsInCreativeTabContext, Boolean, O, I>, Boolean>... components) {
        this.IsInCreativeTabPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<IsInCreativeTabContext, Boolean, O, I>, Boolean>> IsInCreativeTabPipeline = new ArrayList<>();

    @Override
    public C IsEnchantable(Function<TypedPipelineElementContext<IsEnchantableContext, Boolean, O, I>, Boolean>... components) {
        this.IsEnchantablePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<IsEnchantableContext, Boolean, O, I>, Boolean>> IsEnchantablePipeline = new ArrayList<>();

    @Override
    public C SetTileEntityItemStackRenderer(Consumer<VoidPipelineElementContext<SetTileEntityItemStackRendererContext, O, I>>... components) {
        this.SetTileEntityItemStackRendererPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<SetTileEntityItemStackRendererContext, O, I>>> SetTileEntityItemStackRendererPipeline = new ArrayList<>();

    @Override
    public C SetContainerItem(Function<TypedPipelineElementContext<SetContainerItemContext, O, O, I>, O>... components) {
        this.SetContainerItemPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<SetContainerItemContext, O, O, I>, O>> SetContainerItemPipeline = new ArrayList<>();

    @Override
    public C ShowDurabilityBar(Function<TypedPipelineElementContext<ShowDurabilityBarContext, Boolean, O, I>, Boolean>... components) {
        this.ShowDurabilityBarPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<ShowDurabilityBarContext, Boolean, O, I>, Boolean>> ShowDurabilityBarPipeline = new ArrayList<>();

    @Override
    public C GetMetadata(Function<TypedPipelineElementContext<GetMetadataContext, Integer, O, I>, Integer>... components) {
        this.GetMetadataPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetMetadataContext, Integer, O, I>, Integer>> GetMetadataPipeline = new ArrayList<>();

    @Override
    public C GetMetadataWithStackAsItemStack(Function<TypedPipelineElementContext<GetMetadataWithStackAsItemStackContext, Integer, O, I>, Integer>... components) {
        this.GetMetadataWithStackAsItemStackPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetMetadataWithStackAsItemStackContext, Integer, O, I>, Integer>> GetMetadataWithStackAsItemStackPipeline = new ArrayList<>();

    @Override
    public C IsBookEnchantable(Function<TypedPipelineElementContext<IsBookEnchantableContext, Boolean, O, I>, Boolean>... components) {
        this.IsBookEnchantablePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<IsBookEnchantableContext, Boolean, O, I>, Boolean>> IsBookEnchantablePipeline = new ArrayList<>();

    @Override
    public C OnUsingTick(Consumer<VoidPipelineElementContext<OnUsingTickContext, O, I>>... components) {
        this.OnUsingTickPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<OnUsingTickContext, O, I>>> OnUsingTickPipeline = new ArrayList<>();

    @Override
    public C CreateEntity(Function<TypedPipelineElementContext<CreateEntityContext, IEntity, O, I>, IEntity>... components) {
        this.CreateEntityPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<CreateEntityContext, IEntity, O, I>, IEntity>> CreateEntityPipeline = new ArrayList<>();

    @Override
    public C GetCreativeTabs(Function<TypedPipelineElementContext<GetCreativeTabsContext, IItemGroup<?>[], O, I>, IItemGroup<?>[]>... components) {
        this.GetCreativeTabsPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetCreativeTabsContext, IItemGroup<?>[], O, I>, IItemGroup<?>[]>> GetCreativeTabsPipeline = new ArrayList<>();

    @Override
    public C ShouldRotateAroundWhenRendering(Function<TypedPipelineElementContext<ShouldRotateAroundWhenRenderingContext, Boolean, O, I>, Boolean>... components) {
        this.ShouldRotateAroundWhenRenderingPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<ShouldRotateAroundWhenRenderingContext, Boolean, O, I>, Boolean>> ShouldRotateAroundWhenRenderingPipeline = new ArrayList<>();

    @Override
    public C IsRepairable(Function<TypedPipelineElementContext<IsRepairableContext, Boolean, O, I>, Boolean>... components) {
        this.IsRepairablePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<IsRepairableContext, Boolean, O, I>, Boolean>> IsRepairablePipeline = new ArrayList<>();

    @Override
    public C GetMaxItemUseDuration(Function<TypedPipelineElementContext<GetMaxItemUseDurationContext, Integer, O, I>, Integer>... components) {
        this.GetMaxItemUseDurationPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetMaxItemUseDurationContext, Integer, O, I>, Integer>> GetMaxItemUseDurationPipeline = new ArrayList<>();

    @Override
    public C GetRGBDurabilityForDisplay(Function<TypedPipelineElementContext<GetRGBDurabilityForDisplayContext, Integer, O, I>, Integer>... components) {
        this.GetRGBDurabilityForDisplayPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetRGBDurabilityForDisplayContext, Integer, O, I>, Integer>> GetRGBDurabilityForDisplayPipeline = new ArrayList<>();

    @Override
    public C IsDamageable(Function<TypedPipelineElementContext<IsDamageableContext, Boolean, O, I>, Boolean>... components) {
        this.IsDamageablePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<IsDamageableContext, Boolean, O, I>, Boolean>> IsDamageablePipeline = new ArrayList<>();

    @Override
    public C SetUnlocalizedName(Function<TypedPipelineElementContext<SetUnlocalizedNameContext, O, O, I>, O>... components) {
        this.SetUnlocalizedNamePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<SetUnlocalizedNameContext, O, O, I>, O>> SetUnlocalizedNamePipeline = new ArrayList<>();

    @Override
    public C SetFull3D(Function<TypedPipelineElementContext<SetFull3DContext, O, O, I>, O>... components) {
        this.SetFull3DPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<SetFull3DContext, O, O, I>, O>> SetFull3DPipeline = new ArrayList<>();

    @Override
    public C OnLeftClickEntity(Function<TypedPipelineElementContext<OnLeftClickEntityContext, Boolean, O, I>, Boolean>... components) {
        this.OnLeftClickEntityPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<OnLeftClickEntityContext, Boolean, O, I>, Boolean>> OnLeftClickEntityPipeline = new ArrayList<>();

    @Override
    public C OnBlockDestroyed(Function<TypedPipelineElementContext<OnBlockDestroyedContext, Boolean, O, I>, Boolean>... components) {
        this.OnBlockDestroyedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<OnBlockDestroyedContext, Boolean, O, I>, Boolean>> OnBlockDestroyedPipeline = new ArrayList<>();

    @Override
    public C GetDurabilityForDisplay(Function<TypedPipelineElementContext<GetDurabilityForDisplayContext, Double, O, I>, Double>... components) {
        this.GetDurabilityForDisplayPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetDurabilityForDisplayContext, Double, O, I>, Double>> GetDurabilityForDisplayPipeline = new ArrayList<>();

    @Override
    public C OnHorseArmorTick(Consumer<VoidPipelineElementContext<OnHorseArmorTickContext, O, I>>... components) {
        this.OnHorseArmorTickPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<OnHorseArmorTickContext, O, I>>> OnHorseArmorTickPipeline = new ArrayList<>();

    @Override
    public C IsFull3D(Function<TypedPipelineElementContext<IsFull3DContext, Boolean, O, I>, Boolean>... components) {
        this.IsFull3DPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<IsFull3DContext, Boolean, O, I>, Boolean>> IsFull3DPipeline = new ArrayList<>();

    @Override
    public C GetIsRepairable(Function<TypedPipelineElementContext<GetIsRepairableContext, Boolean, O, I>, Boolean>... components) {
        this.GetIsRepairablePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetIsRepairableContext, Boolean, O, I>, Boolean>> GetIsRepairablePipeline = new ArrayList<>();

    @Override
    public C OnItemRightClick(Function<TypedPipelineElementContext<OnItemRightClickContext, IActionResult<IItemStack>, O, I>, IActionResult<IItemStack>>... components) {
        this.OnItemRightClickPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<OnItemRightClickContext, IActionResult<IItemStack>, O, I>, IActionResult<IItemStack>>> OnItemRightClickPipeline = new ArrayList<>();

    @Override
    public C HasCustomEntity(Function<TypedPipelineElementContext<HasCustomEntityContext, Boolean, O, I>, Boolean>... components) {
        this.HasCustomEntityPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<HasCustomEntityContext, Boolean, O, I>, Boolean>> HasCustomEntityPipeline = new ArrayList<>();

    @Override
    public C GetHighlightTip(Function<TypedPipelineElementContext<GetHighlightTipContext, String, O, I>, String>... components) {
        this.GetHighlightTipPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetHighlightTipContext, String, O, I>, String>> GetHighlightTipPipeline = new ArrayList<>();

    @Override
    public C GetHasSubtypes(Function<TypedPipelineElementContext<GetHasSubtypesContext, Boolean, O, I>, Boolean>... components) {
        this.GetHasSubtypesPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetHasSubtypesContext, Boolean, O, I>, Boolean>> GetHasSubtypesPipeline = new ArrayList<>();

    @Override
    public C HasEffect(Function<TypedPipelineElementContext<HasEffectContext, Boolean, O, I>, Boolean>... components) {
        this.HasEffectPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<HasEffectContext, Boolean, O, I>, Boolean>> HasEffectPipeline = new ArrayList<>();

    @Override
    public C CanItemEditBlocks(Function<TypedPipelineElementContext<CanItemEditBlocksContext, Boolean, O, I>, Boolean>... components) {
        this.CanItemEditBlocksPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<CanItemEditBlocksContext, Boolean, O, I>, Boolean>> CanItemEditBlocksPipeline = new ArrayList<>();

    @Override
    public C ItemInteractionForEntity(Function<TypedPipelineElementContext<ItemInteractionForEntityContext, Boolean, O, I>, Boolean>... components) {
        this.ItemInteractionForEntityPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<ItemInteractionForEntityContext, Boolean, O, I>, Boolean>> ItemInteractionForEntityPipeline = new ArrayList<>();

    @Override
    public C DoesSneakBypassUse(Function<TypedPipelineElementContext<DoesSneakBypassUseContext, Boolean, O, I>, Boolean>... components) {
        this.DoesSneakBypassUsePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<DoesSneakBypassUseContext, Boolean, O, I>, Boolean>> DoesSneakBypassUsePipeline = new ArrayList<>();

    @Override
    public C SetNoRepair(Function<TypedPipelineElementContext<SetNoRepairContext, O, O, I>, O>... components) {
        this.SetNoRepairPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<SetNoRepairContext, O, O, I>, O>> SetNoRepairPipeline = new ArrayList<>();

    @Override
    public C GetContainerItem(Function<TypedPipelineElementContext<GetContainerItemContext, O, O, I>, O>... components) {
        this.GetContainerItemPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetContainerItemContext, O, O, I>, O>> GetContainerItemPipeline = new ArrayList<>();

    @Override
    public C GetContainerItemWithItemStackAsItemStack(Function<TypedPipelineElementContext<GetContainerItemWithItemStackAsItemStackContext, IItemStack, O, I>, IItemStack>... components) {
        this.GetContainerItemWithItemStackAsItemStackPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetContainerItemWithItemStackAsItemStackContext, IItemStack, O, I>, IItemStack>> GetContainerItemWithItemStackAsItemStackPipeline = new ArrayList<>();

    @Override
    public C GetItemStackDisplayName(Function<TypedPipelineElementContext<GetItemStackDisplayNameContext, String, O, I>, String>... components) {
        this.GetItemStackDisplayNamePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetItemStackDisplayNameContext, String, O, I>, String>> GetItemStackDisplayNamePipeline = new ArrayList<>();

    @Override
    public C RayTrace(Function<TypedPipelineElementContext<RayTraceContext, IRayTraceResult, O, I>, IRayTraceResult>... components) {
        this.RayTracePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<RayTraceContext, IRayTraceResult, O, I>, IRayTraceResult>> RayTracePipeline = new ArrayList<>();

    @Override
    public C ReadNBTShareTag(Consumer<VoidPipelineElementContext<ReadNBTShareTagContext, O, I>>... components) {
        this.ReadNBTShareTagPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<ReadNBTShareTagContext, O, I>>> ReadNBTShareTagPipeline = new ArrayList<>();

    @Override
    public C GetEquipmentSlot(Function<TypedPipelineElementContext<GetEquipmentSlotContext, IEquipmentSlot, O, I>, IEquipmentSlot>... components) {
        this.GetEquipmentSlotPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetEquipmentSlotContext, IEquipmentSlot, O, I>, IEquipmentSlot>> GetEquipmentSlotPipeline = new ArrayList<>();

    @Override
    public C GetItemStackLimit(Function<TypedPipelineElementContext<GetItemStackLimitContext, Integer, O, I>, Integer>... components) {
        this.GetItemStackLimitPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetItemStackLimitContext, Integer, O, I>, Integer>> GetItemStackLimitPipeline = new ArrayList<>();

    @Override
    public C GetItemStackLimitWithStackAsItemStack(Function<TypedPipelineElementContext<GetItemStackLimitWithStackAsItemStackContext, Integer, O, I>, Integer>... components) {
        this.GetItemStackLimitWithStackAsItemStackPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetItemStackLimitWithStackAsItemStackContext, Integer, O, I>, Integer>> GetItemStackLimitWithStackAsItemStackPipeline = new ArrayList<>();

    @Override
    public C SetHasSubtypes(Function<TypedPipelineElementContext<SetHasSubtypesContext, O, O, I>, O>... components) {
        this.SetHasSubtypesPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<SetHasSubtypesContext, O, O, I>, O>> SetHasSubtypesPipeline = new ArrayList<>();

    @Override
    public C GetHorseArmorTexture(Function<TypedPipelineElementContext<GetHorseArmorTextureContext, String, O, I>, String>... components) {
        this.GetHorseArmorTexturePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Function<TypedPipelineElementContext<GetHorseArmorTextureContext, String, O, I>, String>> GetHorseArmorTexturePipeline = new ArrayList<>();

    @Override
    public C OnCreated(Consumer<VoidPipelineElementContext<OnCreatedContext, O, I>>... components) {
        this.OnCreatedPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<OnCreatedContext, O, I>>> OnCreatedPipeline = new ArrayList<>();

    @Override
    public C SetHarvestLevel(Consumer<VoidPipelineElementContext<SetHarvestLevelContext, O, I>>... components) {
        this.SetHarvestLevelPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    protected final List<Consumer<VoidPipelineElementContext<SetHarvestLevelContext, O, I>>> SetHarvestLevelPipeline = new ArrayList<>();
}
