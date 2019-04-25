package com.ldtteam.jvoxelizer.launcher.forge_1_13.item;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import com.ldtteam.jvoxelizer.client.gui.IScaledResolution;
import com.ldtteam.jvoxelizer.client.model.IModelBiped;
import com.ldtteam.jvoxelizer.client.renderer.blockentity.IBlockEntityRenderer;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.common.animation.ITimedValue;
import com.ldtteam.jvoxelizer.core.logic.PipelineProcessor;
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
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.group.IItemGroup;
import com.ldtteam.jvoxelizer.item.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.block.state.BlockState;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui.ScaledResolution;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.model.ModelBiped;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.blockentity.BlockEntityRenderer;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.common.animation.TimedValue;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.dimension.Dimension;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.dimension.DimensionReader;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.item.ItemStackEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.living.LivingBaseEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.living.LivingEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.living.player.PlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.item.group.ItemGroup;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.item.logic.pipeline.ForgeItemPipeline;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.action.ActionType;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.actionresult.ActionResultType;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.equipmentslot.EquipmentSlot;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.facing.Facing;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.hand.Hand;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.identifier.Identifier;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.math.coordinate.block.BlockCoordinate;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.nbt.NBTCompound;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.rarity.Rarity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.stream.nonnulllist.NonNullListCollector;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.tooltipflag.ToolTipFlag;
import com.ldtteam.jvoxelizer.util.action.IActionType;
import com.ldtteam.jvoxelizer.util.actionresult.IActionResult;
import com.ldtteam.jvoxelizer.util.actionresult.IActionResultType;
import com.ldtteam.jvoxelizer.util.equipmentslot.IEquipmentSlot;
import com.ldtteam.jvoxelizer.util.facing.IFacing;
import com.ldtteam.jvoxelizer.util.hand.IHand;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import com.ldtteam.jvoxelizer.util.nbt.INBTCompound;
import com.ldtteam.jvoxelizer.util.rarity.IRarity;
import com.ldtteam.jvoxelizer.util.stream.multimap.MultiMapCollector;
import com.ldtteam.jvoxelizer.util.tooltipflag.IToolTipFlag;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.HorseArmorType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.GameType;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.animation.ITimeValue;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;

public class JVoxItem<I> extends Item implements IItem<I>
{
    private final I                              instanceData;
    private final ForgeItemPipeline<IItem<I>, I> pipeline;

    public JVoxItem(final I instanceData, final ForgeItemPipeline<IItem<I>, I> pipeline)
    {
        super(new ItemPropertiesBuilder<I>().build(pipeline));
        this.instanceData = instanceData;
        this.pipeline = pipeline;
    }

    @Nullable
    @Override
    public IItemPropertyGetter getPropertyGetter(@NotNull final ResourceLocation key)
    {
        return ItemPropertyGetter.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new GetPropertyGetterContext(Identifier.fromForge(key)),
            pipeline.getPropertyGetterPipeline(),
            (c) -> ItemPropertyGetter.fromForge(super.getPropertyGetter(Identifier.asForge(c.getKey())))
          )
        );
    }

    /**
     * Called when an ItemStack with NBT data is read to potentially that ItemStack's NBT data
     */
    @Override
    public boolean updateItemStackNBT(final NBTTagCompound nbt)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new UpdateItemStackNBTContext(NBTCompound.fromForge(nbt)),
          pipeline.getUpdateItemStackNBTPipeline(),
          (c) -> super.updateItemStackNBT(NBTCompound.asForge(c.getNbt()))
        );
    }

    @Override
    public boolean hasCustomProperties()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new HasCustomPropertiesContext(),
          pipeline.getHasCustomPropertiesPipeline(),
          (c) -> super.hasCustomProperties()
        );
    }

    /**
     * Called when this item is used when targetting a Block
     */
    @Override
    public EnumActionResult onItemUse(final ItemUseContext context)
    {
        EnumHand hand = EnumHand.MAIN_HAND;
        if (context.getPlayer() != null && context.getPlayer().inventory.offHandInventory.stream().anyMatch(stack -> ItemStack.areItemStacksEqual(stack, context.getItem())))
        {
            hand = EnumHand.OFF_HAND;
        }

        return this.onItemUse(context.getPlayer(), context.getWorld(), context.getPos(), hand, context.getFace(), context.getHitX(), context.getHitY(), context.getHitZ());
    }

    private EnumActionResult onItemUse(
      final EntityPlayer player, final World worldIn, final BlockPos pos, final EnumHand hand, final EnumFacing facing, final float hitX, final float hitY, final float hitZ)
    {
        return ActionResultType.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new OnItemUseContext(PlayerEntity.fromForge(player),
              Dimension.fromForge(worldIn),
              BlockCoordinate.fromForge(pos),
              Hand.fromForge(hand),
              Facing.fromForge(facing),
              hitX,
              hitY,
              hitZ),
            pipeline.getOnItemUsePipeline(),
            (c) -> ActionResultType.fromForge(super.onItemUse(new ItemUseContext(
              PlayerEntity.asForge(c.getPlayer()),
              PlayerEntity.asForge(c.getPlayer()).getHeldItem(Hand.asForge(c.getHand())),
              BlockCoordinate.asForge(c.getPos()),
              Facing.asForge(c.getFacing()),
              c.getHitX(),
              c.getHitY(),
              c.getHitZ())))
          )
        );
    }

    @Override
    public float getDestroySpeed(final ItemStack stack, final IBlockState state)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetDestroySpeedContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack), BlockState.fromForge(state)),
          pipeline.getGetDestroySpeedPipeline(),
          (c) -> super.getDestroySpeed(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()), BlockState.asForge(c.getState()))
        );
    }

    /**
     * Called when the equipped item is right clicked.
     */
    @NotNull
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World worldIn, final EntityPlayer playerIn, @NotNull final EnumHand handIn)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.util.actionresult.ActionResult.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new OnItemRightClickContext(Dimension.fromForge(worldIn), PlayerEntity.fromForge(playerIn), Hand.fromForge(handIn)),
            pipeline.getOnItemRightClickPipeline(),
            (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_13.util.actionresult.ActionResult.fromForge(super.onItemRightClick(Dimension.asForge(c.getWorldIn()),
              PlayerEntity.asForge(c.getPlayerIn()),
              Hand.asForge(c.getHandIn())),
              com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack::fromForge)
          )
        );
    }

    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    @NotNull
    @Override
    public ItemStack onItemUseFinish(@NotNull final ItemStack stack, final World worldIn, final EntityLivingBase entityLiving)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new OnItemUseFinishContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack),
              Dimension.fromForge(worldIn),
              LivingBaseEntity.fromForge(entityLiving)),
            pipeline.getOnItemUseFinishPipeline(),
            (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(super.onItemUseFinish(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
                                                                                                               .asForge(c.getStack()),
              Dimension.asForge(c.getWorldIn()),
              LivingBaseEntity.asForge(c.getEntityLiving())))
          )
        );
    }

    @Override
    public boolean isDamageable()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsDamageableContext(),
          pipeline.getIsDamageablePipeline(),
          (c) -> super.isDamageable()
        );
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    @Override
    public boolean hitEntity(final ItemStack stack, final EntityLivingBase target, final EntityLivingBase attacker)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new HitEntityContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack),
            LivingBaseEntity.fromForge(target),
            LivingBaseEntity.fromForge(attacker)),
          pipeline.getHitEntityPipeline(),
          (c) -> super.hitEntity(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()),
            LivingBaseEntity.asForge(c.getTarget()),
            LivingBaseEntity.asForge(c.getAttacker()))
        );
    }

    /**
     * Called when a Block is destroyed using this Item. Return true to trigger the "Use Item" statistic.
     */
    @Override
    public boolean onBlockDestroyed(
      final ItemStack stack, final World worldIn, final IBlockState state, final BlockPos pos, final EntityLivingBase entityLiving)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new OnBlockDestroyedContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack),
            Dimension.fromForge(worldIn),
            BlockState.fromForge(state),
            BlockCoordinate.fromForge(pos),
            LivingBaseEntity.fromForge(entityLiving)),
          pipeline.getOnBlockDestroyedPipeline(),
          (c) -> super.onBlockDestroyed(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()),
            Dimension.asForge(c.getWorldIn()),
            BlockState.asForge(c.getState()),
            BlockCoordinate.asForge(c.getPos()),
            LivingBaseEntity.asForge(c.getEntityLiving()))
        );
    }

    /**
     * Check whether this Item can harvest the given Block
     */
    @Override
    public boolean canHarvestBlock(final IBlockState blockIn)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new CanHarvestBlockContext(BlockState.fromForge(blockIn)),
          pipeline.getCanHarvestBlockPipeline(),
          (c) -> super.canHarvestBlock(BlockState.asForge(c.getBlockIn()))
        );
    }

    /**
     * Returns true if the item can be used on the given entity, e.g. shears on sheep.
     */
    @Override
    public boolean itemInteractionForEntity(
      final ItemStack stack, final EntityPlayer playerIn, final EntityLivingBase target, final EnumHand hand)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new ItemInteractionForEntityContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack),
            PlayerEntity.fromForge(playerIn),
            LivingBaseEntity.fromForge(target),
            Hand.fromForge(hand)),
          pipeline.getItemInteractionForEntityPipeline(),
          (c) -> super.itemInteractionForEntity(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()),
            PlayerEntity.asForge(c.getPlayerIn()),
            LivingBaseEntity.asForge(c.getPlayerIn()),
            Hand.asForge(c.getHand()))
        );
    }

    @Override
    protected String getDefaultTranslationKey()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetUnlocalizedNameContext(),
          pipeline.getGetUnlocalizedNamePipeline(),
          (c) -> super.getDefaultTranslationKey());
    }

    /**
     * Returns the unlocalized name of this item.
     */
    @Override
    public String getTranslationKey()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetUnlocalizedNameContext(),
          pipeline.getGetUnlocalizedNamePipeline(),
          (c) -> super.getTranslationKey());
    }

    @Override
    public String getTranslationKey(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetUnlocalizedNameWithStackAsItemStackContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getGetUnlocalizedNameWithStackAsItemStackPipeline(),
          (c) -> super.getTranslationKey(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack())));
    }

    /**
     * If this function returns true (or the item is damageable), the ItemStack's NBT tag will be sent to the client.
     */
    @Override
    public boolean getShareTag()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetShareTagContext(),
          pipeline.getGetShareTagPipeline(),
          (c) -> super.getShareTag());
    }

    /**
     * True if this Item has a container item (a.k.a. crafting result)
     */
    @Override
    public boolean hasContainerItem()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new HasContainerItemContext(),
          pipeline.getHasContainerItemPipeline(),
          (c) -> super.hasContainerItem());
    }

    /**
     * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
     * update it's contents.
     */
    @Override
    public void inventoryTick(final ItemStack stack, final World worldIn, final Entity entityIn, final int itemSlot, final boolean isSelected)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new OnUpdateContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack), Dimension.fromForge(worldIn),
            com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.Entity.fromForge(entityIn), itemSlot, isSelected),
          pipeline.getOnUpdatePipeline(),
          (c) -> super.inventoryTick(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()), Dimension.asForge(c.getWorldIn()),
            com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.Entity.asForge(c.getEntityIn()), c.getItemSlot(), c.getIsSelected()));
    }

    /**
     * Called when item is crafted/smelted. Used only by maps so far.
     */
    @Override
    public void onCreated(final ItemStack stack, final World worldIn, final EntityPlayer playerIn)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new OnCreatedContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack), Dimension.fromForge(worldIn),
            PlayerEntity.fromForge(playerIn)),
          pipeline.getOnCreatedPipeline(),
          (c) -> super.onCreated(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()), Dimension.asForge(c.getWorldIn()),
            PlayerEntity.asForge(c.getPlayerIn())));
    }

    /**
     * false for all Items except sub-classes of ItemMapBase
     */
    @Override
    public boolean isMap()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsMapContext(),
          pipeline.getIsMapPipeline(),
          (c) -> this.getItem() instanceof ItemMap);
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    @Override
    public EnumAction getUseAction(final ItemStack stack)
    {
        return ActionType.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new GetItemUseActionContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getGetItemUseActionPipeline(),
          (c) -> ActionType.fromForge(super.getUseAction(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()))))
        );
    }

    /**
     * How long it takes to use or consume an item
     */
    @Override
    public int getUseDuration(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetMaxItemUseDurationContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getGetMaxItemUseDurationPipeline(),
          (c) -> super.getUseDuration(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack())));
    }

    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
    @Override
    public void onPlayerStoppedUsing(final ItemStack stack, final World worldIn, final EntityLivingBase entityLiving, final int timeLeft)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new OnPlayerStoppedUsingContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack), Dimension.fromForge(worldIn),
            LivingBaseEntity.fromForge(entityLiving), timeLeft),
          pipeline.getOnPlayerStoppedUsingPipeline(),
          (c) -> super.onPlayerStoppedUsing(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()), Dimension.asForge(c.getWorldIn()),
            LivingBaseEntity.asForge(c.getEntityLiving()), timeLeft));
    }

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    @Override
    public void addInformation(
      final ItemStack stack, @Nullable final World worldIn, final List<ITextComponent> tooltip, final ITooltipFlag flagIn)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new AddInformationContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack), Dimension.fromForge(worldIn),
            tooltip.stream().map(ITextComponent::getFormattedText).collect(Collectors.toList()), ToolTipFlag.fromForge(flagIn)),
          pipeline.getAddInformationPipeline(),
          (c) -> super.addInformation(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()), Dimension.asForge(c.getWorldIn()),
            c.getTooltip().stream().map(TextComponentString::new).collect(Collectors.toList()), ToolTipFlag.asForge(c.getFlagIn())));
    }

    @NotNull
    @Override
    public ITextComponent getDisplayName(@NotNull final ItemStack stack)
    {
        return new TextComponentString(PipelineProcessor.processTypedPipeline(
          this,
          new GetItemStackDisplayNameContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getGetItemStackDisplayNamePipeline(),
          (c) -> super.getDisplayName(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack())).getFormattedText()));
    }

    /**
     * Returns true if this item has an enchantment glint. By default, this returns
     * <code>stack.isItemEnchanted()</code>, but other items can override it (for instance, written books always return
     * true).
     * <p>
     * Note that if you override this method, you generally want to also call the super version (on {@link Item}) to get
     * the glint for enchanted items. Of course, that is unnecessary if the overwritten version always returns true.
     */
    @Override
    public boolean hasEffect(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new HasEffectContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getHasEffectPipeline(),
          (c) -> super.hasEffect(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack())));
    }

    /**
     * Return an item rarity from EnumRarity
     */
    @NotNull
    @Override
    public EnumRarity getRarity(final ItemStack stack)
    {
        return Rarity.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new GetRarityContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getGetRarityPipeline(),
          (c) -> Rarity.fromForge(super.getRarity(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()))))
        );
    }

    /**
     * Checks isDamagable and if it cannot be stacked
     */
    @Override
    public boolean isEnchantable(@NotNull final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsEnchantableContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getIsEnchantablePipeline(),
          (c) -> super.isEnchantable(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack())));
    }

    @NotNull
    @Override
    protected RayTraceResult rayTrace(final World worldIn, final EntityPlayer playerIn, final boolean useLiquids)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.util.math.raytraceresult.RayTraceResult.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new RayTraceContext(Dimension.fromForge(worldIn), PlayerEntity.fromForge(playerIn), useLiquids),
          pipeline.getRayTracePipeline(),
          (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_13.util.math.raytraceresult.RayTraceResult.fromForge(super.rayTrace(Dimension.asForge(c.getWorldIn()),
            PlayerEntity.asForge(c.getPlayerIn()),
            c.getUseLiquids())))
        );
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    @Override
    public int getItemEnchantability()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetItemEnchantabilityContext(),
          pipeline.getGetItemEnchantabilityPipeline(),
          (c) -> super.getItemEnchantability());
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @Override
    public void fillItemGroup(final net.minecraft.item.ItemGroup group, final NonNullList<ItemStack> items)
    {
        List<IItemStack> theItems = new ArrayList<>();
        items.forEach(item -> theItems.add(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(item)));

        PipelineProcessor.processVoidPipeline(
          this,
          new GetSubItemsContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.group.ItemGroup.fromForge(group), theItems),
          pipeline.getGetSubItemsPipeline(),
          (c) -> super.fillItemGroup(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.group.ItemGroup.asForge(c.getTab()), getNonNullListFromList(c.getItems())));
    }

    @NotNull
    private static NonNullList<ItemStack> getNonNullListFromList(@NotNull final List<IItemStack> theItems)
    {
        final NonNullList<ItemStack> list = NonNullList.create();
        theItems.stream().map(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack::asForge).forEach(list::add);
        return list;
    }

    @Override
    protected boolean isInGroup(final net.minecraft.item.ItemGroup targetTab)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsInCreativeTabContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.group.ItemGroup.fromForge(targetTab)),
          pipeline.getIsInCreativeTabPipeline(),
          (c) -> super.isInGroup(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.group.ItemGroup.asForge(c.getTargetTab())));
    }

    /**
     * Return whether this item is repairable in an anvil.
     *
     * @param toRepair the {@code ItemStack} being repaired
     * @param repair   the {@code ItemStack} being used to perform the repair
     */
    @Override
    public boolean getIsRepairable(final ItemStack toRepair, final ItemStack repair)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetIsRepairableContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(toRepair), com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
                                                                                                                      .fromForge(repair)),
          pipeline.getGetIsRepairablePipeline(),
          (c) -> super.getIsRepairable(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getToRepair()), com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
                                                                                                                             .asForge(c.getRepair())));
    }

    /**
     * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
     */
    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(final EntityEquipmentSlot equipmentSlot)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetItemAttributeModifiersContext(EquipmentSlot.fromForge(equipmentSlot)),
          pipeline.getGetItemAttributeModifiersPipeline(),
          (c) -> super.getAttributeModifiers(EquipmentSlot.asForge(c.getEquipmentSlot()))
                   .entries()
                   .stream()
                   .map(e -> new Tuple<>(e.getKey(), com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.ai.AttributeModifier
                                                       .fromForge(e.getValue())))
                   .collect(
                     MultiMapCollector.toMultimap(Tuple::getA, Tuple::getB))
        )
                 .entries()
                 .stream()
                 .map(e -> new Tuple<>(e.getKey(), com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.ai.AttributeModifier.asForge(e.getValue())))
                 .collect(MultiMapCollector.toMultimap(Tuple::getA, Tuple::getB));
    }

    /**
     * ItemStack sensitive version of getItemAttributeModifiers
     */
    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(
      final EntityEquipmentSlot slot, final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetAttributeModifiersContext(EquipmentSlot.fromForge(slot), com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getGetAttributeModifiersPipeline(),
          (c) -> super.getAttributeModifiers(EquipmentSlot.asForge(c.getSlot()), com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()))
                   .entries()
                   .stream()
                   .map(e -> new Tuple<>(e.getKey(), com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.ai.AttributeModifier.fromForge(e.getValue())))
                   .collect(
                     MultiMapCollector.toMultimap(Tuple::getA, Tuple::getB))
        )
                 .entries()
                 .stream()
                 .map(e -> new Tuple<>(e.getKey(), com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.ai.AttributeModifier.asForge(e.getValue())))
                 .collect(MultiMapCollector.toMultimap(Tuple::getA, Tuple::getB));
    }

    /**
     * Called when a player drops the item into the world,
     * returning false from this will prevent the item from
     * being removed from the players inventory and spawning
     * in the world
     *
     * @param item   The item stack, before the item is removed.
     * @param player The player that dropped the item
     */
    @Override
    public boolean onDroppedByPlayer(final ItemStack item, final EntityPlayer player)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new OnDroppedByPlayerContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(item), PlayerEntity.fromForge(player)),
          pipeline.getOnDroppedByPlayerPipeline(),
          (c) -> super.onDroppedByPlayer(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getItem()), PlayerEntity.asForge(c.getPlayer()))
        );
    }

    /**
     * Allow the item one last chance to modify its name used for the
     * tool highlight useful for adding something extra that can't be removed
     * by a user in the displayed name, such as a mode of operation.
     *
     * @param item        the ItemStack for the item.
     * @param displayName the name that will be displayed unless it is changed in this method.
     */
    @Override
    public String getHighlightTip(final ItemStack item, final String displayName)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetHighlightTipContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(item), displayName),
          pipeline.getGetHighlightTipPipeline(),
          (c) -> super.getHighlightTip(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getItem()), c.getDisplayName())
        );
    }

    /**
     * This is called when the item is used, before the block is activated.
     *
     * @return Return PASS to allow vanilla handling, any other to skip normal code.
     */
    @Override
    public EnumActionResult onItemUseFirst(final ItemStack stack, final ItemUseContext context)
    {
        EnumHand hand = EnumHand.MAIN_HAND;
        if (context.getPlayer() != null && context.getPlayer().inventory.offHandInventory.stream().anyMatch(s -> ItemStack.areItemStacksEqual(s, stack)))
        {
            hand = EnumHand.OFF_HAND;
        }

        return onItemUseFirst(context.getPlayer(), context.getWorld(), context.getPos(), hand, context.getFace(), context.getHitX(), context.getHitY(), context.getHitZ());
    }

    private EnumActionResult onItemUseFirst(
      final EntityPlayer player, final World worldIn, final BlockPos pos, final EnumHand hand, final EnumFacing facing, final float hitX, final float hitY, final float hitZ)
    {
        return ActionResultType.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new OnItemUseFirstContext(
              PlayerEntity.fromForge(player),
              Dimension.fromForge(worldIn),
              BlockCoordinate.fromForge(pos),
              Facing.fromForge(facing),
              hitX,
              hitY,
              hitZ,
              Hand.fromForge(hand)),
            pipeline.getOnItemUseFirstPipeline(),
            (c) -> ActionResultType.fromForge(super.onItemUseFirst(
              PlayerEntity.asForge(c.getPlayer()).getHeldItem(Hand.asForge(c.getHand())),
              new ItemUseContext(
                PlayerEntity.asForge(c.getPlayer()),
                PlayerEntity.asForge(c.getPlayer()).getHeldItem(Hand.asForge(c.getHand())),
                BlockCoordinate.asForge(c.getPos()),
                Facing.asForge(c.getSide()),
                c.getHitX(),
                c.getHitY(),
                c.getHitZ()
              )))
          )
        );
    }

    /**
     * Called by CraftingManager to determine if an item is reparable.
     *
     * @return True if reparable
     */
    @Override
    public boolean isRepairable()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsRepairableContext(),
          pipeline.getIsRepairablePipeline(),
          (c) -> super.isRepairable()
        );
    }

    /**
     * Override this method to change the NBT data being sent to the client.
     * You should ONLY override this when you have no other choice, as this might change behavior client side!
     * <p>
     * Note that this will sometimes be applied multiple times, the following MUST be supported:
     * Item item = stack.getItem();
     * NBTTagCompound nbtShare1 = item.getNBTShareTag(stack);
     * stack.setTagCompound(nbtShare1);
     * NBTTagCompound nbtShare2 = item.getNBTShareTag(stack);
     * assert nbtShare1.equals(nbtShare2);
     *
     * @param stack The stack to send the NBT tag for
     * @return The NBT tag
     */
    @Nullable
    @Override
    public NBTTagCompound getShareTag(final ItemStack stack)
    {
        return NBTCompound.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new GetNBTShareTagContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
            pipeline.getGetNBTShareTagPipeline(),
            (c) -> NBTCompound.fromForge(super.getShareTag(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack())))
          )
        );
    }

    /**
     * Override this method to decide what to do with the NBT data received from getNBTShareTag().
     *
     * @param stack The stack that received NBT
     * @param nbt   Received NBT, can be null
     */
    @Override
    public void readShareTag(final ItemStack stack, @Nullable final NBTTagCompound nbt)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new ReadNBTShareTagContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack), NBTCompound.fromForge(nbt)),
          pipeline.getReadNBTShareTagPipeline(),
          (c) -> super.readShareTag(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()), NBTCompound.asForge(c.getNbt()))
        );
    }

    /**
     * Called before a block is broken.  Return true to prevent default block harvesting.
     * <p>
     * Note: In SMP, this is called on both client and server sides!
     *
     * @param itemstack The current ItemStack
     * @param pos       Block's position in world
     * @param player    The Player that is wielding the item
     * @return True to prevent harvesting, false to continue as normal
     */
    @Override
    public boolean onBlockStartBreak(final ItemStack itemstack, final BlockPos pos, final EntityPlayer player)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new OnBlockStartBreakContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(itemstack),
            BlockCoordinate.fromForge(pos),
            PlayerEntity.fromForge(player)),
          pipeline.getOnBlockStartBreakPipeline(),
          (c) -> super.onBlockStartBreak(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getItemstack()),
            BlockCoordinate.asForge(c.getPos()),
            PlayerEntity.asForge(c.getPlayer()))
        );
    }

    /**
     * Called each tick while using an item.
     *
     * @param stack  The Item being used
     * @param player The Player using the item
     * @param count  The amount of time in tick the item has been used for continuously
     */
    @Override
    public void onUsingTick(final ItemStack stack, final EntityLivingBase player, final int count)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new OnUsingTickContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack), LivingBaseEntity.fromForge(player), count),
          pipeline.getOnUsingTickPipeline(),
          (c) -> super.onUsingTick(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()), LivingBaseEntity.asForge(c.getPlayer()), c.getCount())
        );
    }

    /**
     * Called when the player Left Clicks (attacks) an entity.
     * Processed before damage is done, if return value is true further processing is canceled
     * and the entity is not attacked.
     *
     * @param stack  The Item being used
     * @param player The player that is attacking
     * @param entity The entity being attacked
     * @return True to cancel the rest of the interaction.
     */
    @Override
    public boolean onLeftClickEntity(final ItemStack stack, final EntityPlayer player, final Entity entity)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new OnLeftClickEntityContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack),
            PlayerEntity.fromForge(player),
            com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.Entity
              .fromForge(entity)),
          pipeline.getOnLeftClickEntityPipeline(),
          (c) -> super.onLeftClickEntity(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()),
            PlayerEntity.asForge(c.getPlayer()),
            com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.Entity.asForge(c.getEntity()))
        );
    }

    /**
     * ItemStack sensitive version of getRemainderItemAfterUse.
     * Returns a full ItemStack instance of the result.
     *
     * @param itemStack The current ItemStack
     * @return The resulting ItemStack
     */
    @Override
    public ItemStack getContainerItem(final ItemStack itemStack)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new GetContainerItemWithItemStackAsItemStackContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(itemStack)),
            pipeline.getGetContainerItemWithItemStackAsItemStackPipeline(),
            (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(super.getContainerItem(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
                                                                                                                .asForge(c.getItemStack())))
          )
        );
    }

    /**
     * ItemStack sensitive version of hasContainerItem
     *
     * @param stack The current item stack
     * @return True if this item has a 'container'
     */
    @Override
    public boolean hasContainerItem(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new HasContainerItemWithStackAsItemStackContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getHasContainerItemWithStackAsItemStackPipeline(),
          (c) -> super.hasContainerItem(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()))
        );
    }

    /**
     * Retrieves the normal 'lifespan' of this item when it is dropped on the ground as a EntityItem.
     * This is in ticks, standard result is 6000, or 5 mins.
     *
     * @param itemStack The current ItemStack
     * @param world     The world the entity is in
     * @return The normal lifespan in ticks.
     */
    @Override
    public int getEntityLifespan(final ItemStack itemStack, final World world)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetEntityLifespanContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(itemStack), Dimension.fromForge(world)),
          pipeline.getGetEntityLifespanPipeline(),
          (c) -> super.getEntityLifespan(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getItemStack()), Dimension.asForge(c.getWorld()))
        );
    }

    /**
     * Determines if this Item has a special entity for when they are in the world.
     * Is called when a EntityItem is spawned in the world, if true and Item#createCustomEntity
     * returns non null, the EntityItem will be destroyed and the new Entity will be added to the world.
     *
     * @param stack The current item stack
     * @return True of the item has a custom entity, If true, Item#createCustomEntity will be called
     */
    @Override
    public boolean hasCustomEntity(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new HasCustomEntityContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getHasCustomEntityPipeline(),
          (c) -> super.hasCustomEntity(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()))
        );
    }

    /**
     * This function should return a new entity to replace the dropped item.
     * Returning null here will not kill the EntityItem and will leave it to function normally.
     * Called when the item it placed in a world.
     *
     * @param world     The world object
     * @param location  The EntityItem object, useful for getting the position of the entity
     * @param itemstack The current item stack
     * @return A new Entity object to spawn or null
     */
    @Nullable
    @Override
    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.Entity.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new CreateEntityContext(Dimension.fromForge(world),
              com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.Entity.fromForge(location),
              com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(itemstack)),
            pipeline.getCreateEntityPipeline(),
            (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.Entity.fromForge(
              super.createEntity(
                Dimension.asForge(c.getWorld()),
                com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.Entity.asForge(c.getLocation()),
                com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getItemstack())
              )
            )
          )
        );
    }

    /**
     * Gets a list of tabs that items belonging to this class can display on,
     * combined properly with getSubItems allows for a single item to span
     * many sub-items across many tabs.
     *
     * @return A list of all tabs that this item could possibly be one.
     */
    @Override
    public Collection<net.minecraft.item.ItemGroup> getCreativeTabs()
    {
        return Arrays.stream(
          PipelineProcessor.processTypedPipeline(
            this,
            new GetCreativeTabsContext(),
            pipeline.getGetCreativeTabsPipeline(),
            (c) -> super.getCreativeTabs().stream().map(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.group.ItemGroup::fromForge).toArray(IItemGroup<?>[]::new)
          )
        ).map(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.group.ItemGroup::asForge).collect(Collectors.toList());
    }

    /**
     * Determines the base experience for a player when they remove this item from a furnace slot.
     * This number must be between 0 and 1 for it to be valid.
     * This number will be multiplied by the stack size to get the total experience.
     *
     * @param item The item stack the player is picking up.
     * @return The amount to award for each item.
     */
    @Override
    public float getSmeltingExperience(final ItemStack item)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetSmeltingExperienceContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(item)),
          pipeline.getGetSmeltingExperiencePipeline(),
          (c) -> super.getSmeltingExperience(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getItem()))
        );
    }

    /**
     * Should this item, when held, allow sneak-clicks to pass through to the underlying block?
     *
     * @param world  The world
     * @param pos    Block position in world
     * @param player The Player that is wielding the item
     */
    @Override
    public boolean doesSneakBypassUse(
      final ItemStack stack, final IWorldReader world, final BlockPos pos, final EntityPlayer player)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new DoesSneakBypassUseContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack),
            DimensionReader.fromForge(world),
            BlockCoordinate.fromForge(pos),
            PlayerEntity.fromForge(player)),
          pipeline.getDoesSneakBypassUsePipeline(),
          (c) -> super.doesSneakBypassUse(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()),
            DimensionReader.asForge(c.getWorld()),
            BlockCoordinate.asForge(c.getPos()),
            PlayerEntity.asForge(c.getPlayer()))
        );
    }

    /**
     * Called to tick armor in the armor slot. Override to do something
     */
    @Override
    public void onArmorTick(final ItemStack itemStack, final World world, final EntityPlayer player)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new OnArmorTickContext(Dimension.fromForge(world), PlayerEntity.fromForge(player), com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(itemStack)),
          pipeline.getOnArmorTickPipeline(),
          (c) -> super.onArmorTick(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getItemStack()),
            Dimension.asForge(c.getWorld()),
            PlayerEntity.asForge(c.getPlayer()))
        );
    }

    /**
     * Determines if the specific ItemStack can be placed in the specified armor slot, for the entity.
     *
     * @param stack     The ItemStack
     * @param armorType Armor slot to be verified.
     * @param entity    The entity trying to equip the armor
     * @return True if the given ItemStack can be inserted in the slot
     */
    @Override
    public boolean canEquip(final ItemStack stack, final EntityEquipmentSlot armorType, final Entity entity)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsValidArmorContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack),
            EquipmentSlot.fromForge(armorType),
            com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.Entity
              .fromForge(entity)),
          pipeline.getIsValidArmorPipeline(),
          (c) -> super.canEquip(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()),
            EquipmentSlot.asForge(c.getArmorType()),
            com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.Entity
              .asForge(c.getEntity()))
        );
    }

    /**
     * Override this to set a non-default armor slot for an ItemStack, but
     * <em>do not use this to get the armor slot of said stack; for that, use
     * {@link EntityLiving#getSlotForItemStack(ItemStack)}.</em>
     *
     * @param stack the ItemStack
     * @return the armor slot of the ItemStack, or {@code null} to let the default
     * vanilla logic as per {@code EntityLiving.getSlotForItemStack(stack)} decide
     */
    @Nullable
    @Override
    public EntityEquipmentSlot getEquipmentSlot(final ItemStack stack)
    {
        return EquipmentSlot.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new GetEquipmentSlotContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
            pipeline.getGetEquipmentSlotPipeline(),
            (c) -> EquipmentSlot.fromForge(super.getEquipmentSlot(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack())))
          )
        );
    }

    /**
     * Allow or forbid the specific book/item combination as an anvil enchant
     *
     * @param stack The item
     * @param book  The book
     * @return if the enchantment is allowed
     */
    @Override
    public boolean isBookEnchantable(final ItemStack stack, final ItemStack book)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsBookEnchantableContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack), com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
                                                                                                                     .fromForge(book)),
          pipeline.getIsBookEnchantablePipeline(),
          (c) -> super.isBookEnchantable(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()), com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
                                                                                                                            .asForge(c.getBook()))
        );
    }

    /**
     * Called by RenderBiped and RenderPlayer to determine the armor texture that
     * should be use for the currently equipped item.
     * This will only be called on instances of ItemArmor.
     * <p>
     * Returning null from this function will use the default value.
     *
     * @param stack  ItemStack for the equipped armor
     * @param entity The entity wearing the armor
     * @param slot   The slot the armor is in
     * @param type   The subtype, can be null or "overlay"
     * @return Path of texture to bind, or null to use default
     */
    @Nullable
    @Override
    public String getArmorTexture(final ItemStack stack, final Entity entity, final EntityEquipmentSlot slot, final String type)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetArmorTextureContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack), com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.Entity
                                                                                                                   .fromForge(entity), EquipmentSlot.fromForge(slot), type),
          pipeline.getGetArmorTexturePipeline(),
          (c) -> super.getArmorTexture(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()),
            com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.Entity.asForge(c.getEntity()),
            EquipmentSlot.asForge(c.getSlot()),
            c.getType())
        );
    }

    /**
     * Returns the font renderer used to render tooltips and overlays for this item.
     * Returning null will use the standard font renderer.
     *
     * @param stack The current item stack
     * @return A instance of FontRenderer or null to use default
     */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    @Override
    public FontRenderer getFontRenderer(final ItemStack stack)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.font.FontRenderer.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new GetFontRendererContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
            pipeline.getGetFontRendererPipeline(),
            (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.font.FontRenderer.fromForge(super.getFontRenderer(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
                                                                                                                                  .asForge(c.getStack())))
          )
        );
    }

    /**
     * Override this method to have an item handle its own armor rendering.
     *
     * @param entityLiving The entity wearing the armor
     * @param itemStack    The itemStack to render the model of
     * @param armorSlot    The slot the armor is in
     * @param _default     Original armor model. Will have attributes set.
     * @return A ModelBiped to render instead of the default
     */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    @Override
    public net.minecraft.client.renderer.entity.model.ModelBiped getArmorModel(
      final EntityLivingBase entityLiving, final ItemStack itemStack, final EntityEquipmentSlot armorSlot, final net.minecraft.client.renderer.entity.model.ModelBiped _default)
    {
        return ModelBiped.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new GetArmorModelContext(LivingBaseEntity.fromForge(entityLiving),
              com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(itemStack),
              EquipmentSlot.fromForge(armorSlot),
              ModelBiped.fromForge(_default)),
            pipeline.getGetArmorModelPipeline(),
            (c) -> ModelBiped.fromForge(
              super.getArmorModel(
                LivingBaseEntity.asForge(c.getEntityLiving()),
                com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getItemStack()),
                EquipmentSlot.asForge(c.getArmorSlot()),
                ModelBiped.asForge(c.get_default())
              )
            )
          )
        );
    }

    /**
     * Called when a entity tries to play the 'swing' animation.
     *
     * @param entityLiving The entity swinging the item.
     * @param stack        The Item stack
     * @return True to cancel any further processing by EntityLiving
     */
    @Override
    public boolean onEntitySwing(final ItemStack stack, final EntityLivingBase entityLiving)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new OnEntitySwingContext(LivingBaseEntity.fromForge(entityLiving), com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getOnEntitySwingPipeline(),
          (c) -> super.onEntitySwing(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()), LivingBaseEntity.asForge(c.getEntityLiving()))
        );
    }

    /**
     * Return the itemDamage represented by this ItemStack. Defaults to the itemDamage field on ItemStack, but can be overridden here for other sources such as NBT.
     *
     * @param stack The itemstack that is damaged
     * @return the damage value
     */
    @Override
    public int getDamage(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetDamageContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getGetDamagePipeline(),
          (c) -> super.getDamage(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()))
        );
    }

    /**
     * Determines if the durability bar should be rendered for this item.
     * Defaults to vanilla stack.isDamaged behavior.
     * But modders can use this for any data they wish.
     *
     * @param stack The current Item Stack
     * @return True if it should render the 'durability' bar.
     */
    @Override
    public boolean showDurabilityBar(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new ShowDurabilityBarContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getShowDurabilityBarPipeline(),
          (c) -> super.showDurabilityBar(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()))
        );
    }

    /**
     * Queries the percentage of the 'Durability' bar that should be drawn.
     *
     * @param stack The current ItemStack
     * @return 0.0 for 100% (no damage / full bar), 1.0 for 0% (fully damaged / empty bar)
     */
    @Override
    public double getDurabilityForDisplay(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetDurabilityForDisplayContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getGetDurabilityForDisplayPipeline(),
          (c) -> super.getDurabilityForDisplay(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()))
        );
    }

    /**
     * Returns the packed int RGB value used to render the durability bar in the GUI.
     * Defaults to a value based on the hue scaled based on {@link #getDurabilityForDisplay}, but can be overriden.
     *
     * @param stack Stack to get durability from
     * @return A packed RGB value for the durability colour (0x00RRGGBB)
     */
    @Override
    public int getRGBDurabilityForDisplay(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetRGBDurabilityForDisplayContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getGetRGBDurabilityForDisplayPipeline(),
          (c) -> super.getRGBDurabilityForDisplay(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()))
        );
    }

    /**
     * Return the maxDamage for this ItemStack. Defaults to the maxDamage field in this item,
     * but can be overridden here for other sources such as NBT.
     *
     * @param stack The itemstack that is damaged
     * @return the damage value
     */
    @Override
    public int getMaxDamage(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetMaxDamageWithStackAsItemStackContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getGetMaxDamageWithStackAsItemStackPipeline(),
          (c) -> super.getMaxDamage(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()))
        );
    }

    /**
     * Return if this itemstack is damaged. Note only called if {@link #isDamageable()} is true.
     *
     * @param stack the stack
     * @return if the stack is damaged
     */
    @Override
    public boolean isDamaged(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsDamagedContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getIsDamagedPipeline(),
          (c) -> super.isDamaged(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()))
        );
    }

    /**
     * Set the damage for this itemstack. Note, this method is responsible for zero checking.
     *
     * @param stack  the stack
     * @param damage the new damage value
     */
    @Override
    public void setDamage(final ItemStack stack, final int damage)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new SetDamageContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack), damage),
          pipeline.getSetDamagePipeline(),
          (c) -> super.setDamage(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()), c.getDamage())
        );
    }

    /**
     * ItemStack sensitive version of {@link #canHarvestBlock(IBlockState)}
     *
     * @param state The block trying to harvest
     * @param stack The itemstack used to harvest the block
     * @return true if can harvest the block
     */
    @Override
    public boolean canHarvestBlock(final ItemStack stack, final IBlockState state)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new CanHarvestBlockWithStateAsIBlockStateAndStackAsItemStackContext(BlockState.fromForge(state),
            com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getCanHarvestBlockWithStateAsIBlockStateAndStackAsItemStackPipeline(),
          (c) -> super.canHarvestBlock(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()), BlockState.asForge(c.getState()))
        );
    }

    /**
     * Gets the maximum number of items that this stack should be able to hold.
     * This is a ItemStack (and thus NBT) sensitive version of Item.getItemStackLimit()
     *
     * @param stack The ItemStack
     * @return The maximum number this item can be stacked to
     */
    @Override
    public int getItemStackLimit(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetItemStackLimitWithStackAsItemStackContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getGetItemStackLimitWithStackAsItemStackPipeline(),
          (c) -> super.getItemStackLimit(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()))
        );
    }

    @Override
    public Set<ToolType> getToolTypes(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetToolClassesContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getGetToolClassesPipeline(),
          (c) -> super.getToolTypes(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack())).stream().map(ToolType::getName).collect(Collectors.toSet())
        ).stream().map(ToolType::get).collect(Collectors.toSet());
    }

    /**
     * Queries the harvest level of this item stack for the specified tool class,
     * Returns -1 if this tool is not of the specified type
     *
     * @param stack      This item stack instance
     * @param toolClass  Tool Class
     * @param player     The player trying to harvest the given blockstate
     * @param blockState The block to harvest
     * @return Harvest level, or -1 if not the specified tool type.
     */
    @Override
    public int getHarvestLevel(
      final ItemStack stack, final ToolType toolClass, @Nullable final EntityPlayer player, @Nullable final IBlockState blockState)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetHarvestLevelContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack),
            toolClass.getName(),
            PlayerEntity.fromForge(player),
            BlockState.fromForge(blockState)),
          pipeline.getGetHarvestLevelPipeline(),
          (c) -> super.getHarvestLevel(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()),
            ToolType.get(c.getToolClass()),
            PlayerEntity.asForge(c.getPlayer()),
            BlockState.asForge(c.getBlockState()))
        );
    }

    /**
     * ItemStack sensitive version of getItemEnchantability
     *
     * @param stack The ItemStack
     * @return the item echantability value
     */
    @Override
    public int getItemEnchantability(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetItemEnchantabilityWithStackAsItemStackContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getGetItemEnchantabilityWithStackAsItemStackPipeline(),
          (c) -> super.getItemEnchantability(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()))
        );
    }

    /**
     * Checks whether an item can be enchanted with a certain enchantment. This applies specifically to enchanting an item in the enchanting table and is called when retrieving the
     * list of possible enchantments for an item.
     * Enchantments may additionally (or exclusively) be doing their own checks in {@link Enchantment#canApplyAtEnchantingTable(ItemStack)}; check the individual implementation for
     * reference.
     * By default this will check if the enchantment type is valid for this item type.
     *
     * @param stack       the item stack to be enchanted
     * @param enchantment the enchantment to be applied
     * @return true if the enchantment can be applied to this item
     */
    @Override
    public boolean canApplyAtEnchantingTable(final ItemStack stack, final Enchantment enchantment)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new CanApplyAtEnchantingTableContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack),
            com.ldtteam.jvoxelizer.launcher.forge_1_13.enchantment.Enchantment
              .fromForge(enchantment)),
          pipeline.getCanApplyAtEnchantingTablePipeline(),
          (c) -> super.canApplyAtEnchantingTable(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()),
            com.ldtteam.jvoxelizer.launcher.forge_1_13.enchantment.Enchantment
              .asForge(c.getEnchantment()))
        );
    }

    /**
     * Whether this Item can be used as a payment to activate the vanilla beacon.
     *
     * @param stack the ItemStack
     * @return true if this Item can be used
     */
    @Override
    public boolean isBeaconPayment(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsBeaconPaymentContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getIsBeaconPaymentPipeline(),
          (c) -> super.isBeaconPayment(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()))
        );
    }

    /**
     * Determine if the player switching between these two item stacks
     *
     * @param oldStack    The old stack that was equipped
     * @param newStack    The new stack
     * @param slotChanged If the current equipped slot was changed,
     *                    Vanilla does not play the animation if you switch between two
     *                    slots that hold the exact same item.
     * @return True to play the item change animation
     */
    @Override
    public boolean shouldCauseReequipAnimation(final ItemStack oldStack, final ItemStack newStack, final boolean slotChanged)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new ShouldCauseReequipAnimationContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(oldStack),
            com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
              .fromForge(newStack),
            slotChanged),
          pipeline.getShouldCauseReequipAnimationPipeline(),
          (c) -> super.shouldCauseReequipAnimation(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getOldStack()),
            com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
              .asForge(c.getNewStack()),
            c.getSlotChanged())
        );
    }

    /**
     * Called when the player is mining a block and the item in his hand changes.
     * Allows to not reset blockbreaking if only NBT or similar changes.
     *
     * @param oldStack The old stack that was used for mining. Item in players main hand
     * @param newStack The new stack
     * @return True to reset block break progress
     */
    @Override
    public boolean shouldCauseBlockBreakReset(final ItemStack oldStack, final ItemStack newStack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new ShouldCauseBlockBreakResetContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(oldStack),
            com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
              .fromForge(newStack)),
          pipeline.getShouldCauseBlockBreakResetPipeline(),
          (c) -> super.shouldCauseBlockBreakReset(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getOldStack()),
            com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
              .asForge(c.getNewStack()))
        );
    }

    /**
     * Called to get the Mod ID of the mod that *created* the ItemStack,
     * instead of the real Mod ID that *registered* it.
     * <p>
     * For example the Forge Universal Bucket creates a subitem for each modded fluid,
     * and it returns the modded fluid's Mod ID here.
     * <p>
     * Mods that register subitems for other mods can override this.
     * Informational mods can call it to show the mod that created the item.
     *
     * @param itemStack the ItemStack to check
     * @return the Mod ID for the ItemStack, or
     * null when there is no specially associated mod and {@link #getRegistryName()} would return null.
     */
    @Nullable
    @Override
    public String getCreatorModId(final ItemStack itemStack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetCreatorModIdContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(itemStack)),
          pipeline.getGetCreatorModIdPipeline(),
          (c) -> super.getCreatorModId(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getItemStack()))
        );
    }

    //TODO: Capability provider logic.

    @Override
    public ImmutableMap<String, ITimeValue> getAnimationParameters(
      final ItemStack stack, final World world, final EntityLivingBase entity)
    {
        return ImmutableMap.copyOf(PipelineProcessor.processTypedPipeline(
          this,
          new GetAnimationParametersContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack),
            Dimension.fromForge(world),
            LivingBaseEntity.fromForge(entity)),
          pipeline.getGetAnimationParametersPipeline(),
          (c) -> ImmutableMap.copyOf(super.getAnimationParameters(
            com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()),
            Dimension.asForge(c.getWorld()),
            LivingBaseEntity.asForge(c.getEntity())
          ).entrySet().stream().map(e -> new Tuple<>(e.getKey(), TimedValue.fromForge(e.getValue()))).collect(Collectors.toMap(Tuple::getA, Tuple::getB)))
        ).entrySet().stream().map(e -> new Tuple<>(e.getKey(), TimedValue.asForge(e.getValue()))).collect(Collectors.toMap(Tuple::getA, Tuple::getB)));
    }

    /**
     * Can this Item disable a shield
     *
     * @param stack    The ItemStack
     * @param shield   The shield in question
     * @param entity   The EntityLivingBase holding the shield
     * @param attacker The EntityLivingBase holding the ItemStack
     */
    @Override
    public boolean canDisableShield(
      final ItemStack stack, final ItemStack shield, final EntityLivingBase entity, final EntityLivingBase attacker)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new CanDisableShieldContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack),
            com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
              .fromForge(shield),
            LivingBaseEntity.fromForge(entity),
            LivingBaseEntity.fromForge(attacker)),
          pipeline.getCanDisableShieldPipeline(),
          (c) -> super.canDisableShield(
            com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()),
            com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getShield()),
            LivingBaseEntity.asForge(c.getEntity()),
            LivingBaseEntity.asForge(c.getAttacker())
          )
        );
    }

    /**
     * Is this Item a shield
     *
     * @param stack  The ItemStack
     * @param entity The Entity holding the ItemStack
     * @return True if the ItemStack is considered a shield
     */
    @Override
    public boolean isShield(final ItemStack stack, @Nullable final EntityLivingBase entity)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsShieldContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack), LivingBaseEntity.fromForge(entity)),
          pipeline.getIsShieldPipeline(),
          (c) -> super.isShield(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()), LivingBaseEntity.asForge(c.getEntity()))
        );
    }

    /**
     * @return the fuel burn time for this itemStack in a furnace.
     * Return 0 to make it not act as a fuel.
     * Return -1 to let the default vanilla logic decide.
     */
    @Override
    public int getBurnTime(final ItemStack itemStack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetItemBurnTimeContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(itemStack)),
          pipeline.getGetItemBurnTimePipeline(),
          (c) -> super.getBurnTime(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getItemStack()))
        );
    }

    /**
     * Returns an enum constant of type {@code HorseArmorType}.
     * The returned enum constant will be used to determine the armor value and texture of this item when equipped.
     *
     * @param stack the armor stack
     * @return an enum constant of type {@code HorseArmorType}. Return HorseArmorType.NONE if this is not horse armor
     */
    @Override
    public HorseArmorType getHorseArmorType(final ItemStack stack)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.passive.HorseArmorType.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new GetHorseArmorTypeContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
            pipeline.getGetHorseArmorTypePipeline(),
            (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.passive.HorseArmorType.fromForge(
              super.getHorseArmorType(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()))
            )
          )
        );
    }

    /**
     * Called every tick from {@link EntityHorse#tick()} on the item in the armor slot.
     *
     * @param world the world the horse is in
     * @param horse the horse wearing this armor
     * @param armor the armor itemstack
     */
    @Override
    public void onHorseArmorTick(final ItemStack armor, final World world, final EntityLiving horse)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new OnHorseArmorTickContext(Dimension.fromForge(world), LivingEntity.fromForge(horse), com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(armor)),
          pipeline.getOnHorseArmorTickPipeline(),
          (c) -> super.onHorseArmorTick(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getArmor()),
            Dimension.asForge(c.getWorld()),
            LivingEntity.asForge(c.getHorse()))
        );
    }

    @Override
    public ItemStack getDefaultInstance()
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new GetDefaultInstanceContext(),
            pipeline.getGetDefaultInstancePipeline(),
            (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(super.getDefaultInstance())
          )
        );
    }

    @Override
    public void addPropertyOverride(final IIdentifier key, final com.ldtteam.jvoxelizer.item.IItemPropertyGetter getter)
    {
        this.addPropertyOverride(Identifier.asForge(key), ItemPropertyGetter.asForge(getter));
    }

    @Override
    public com.ldtteam.jvoxelizer.item.IItemPropertyGetter getPropertyGetter(final IIdentifier key)
    {
        return ItemPropertyGetter.fromForge(this.getPropertyGetter(Identifier.asForge(key)));
    }

    @Override
    public boolean updateItemStackNBT(final INBTCompound nbt)
    {
        return this.updateItemStackNBT(NBTCompound.asForge(nbt));
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
        return ActionResultType.fromForge(
          this.onItemUse(
            PlayerEntity.asForge(player),
            Dimension.asForge(worldIn),
            BlockCoordinate.asForge(pos),
            Hand.asForge(hand),
            Facing.asForge(facing),
            hitX,
            hitY,
            hitZ
          )
        );
    }

    @Override
    public float getDestroySpeed(final IItemStack stack, final com.ldtteam.jvoxelizer.block.state.IBlockState state)
    {
        return getDestroySpeed(
          com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack),
          BlockState.asForge(state)
        );
    }

    @Override
    public IActionResult<IItemStack> onItemRightClick(
      final IDimension worldIn, final IPlayerEntity playerIn, final IHand handIn)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.util.actionresult.ActionResult.fromForge(
          this.onItemRightClick(
            Dimension.asForge(worldIn),
            PlayerEntity.asForge(playerIn),
            Hand.asForge(handIn)
          ),
          com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack::fromForge
        );
    }

    @Override
    public IItemStack onItemUseFinish(
      final IItemStack stack, final IDimension worldIn, final ILivingBaseEntity entityLiving)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(this.onItemUseFinish(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
                                                                                                          .asForge(stack),
          Dimension.asForge(worldIn),
          LivingBaseEntity.asForge(entityLiving)));
    }

    @Override
    public boolean hitEntity(
      final IItemStack stack, final ILivingBaseEntity target, final ILivingBaseEntity attacker)
    {
        return this.hitEntity(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack), LivingBaseEntity.asForge(target), LivingBaseEntity.asForge(attacker));
    }

    @Override
    public boolean onBlockDestroyed(
      final IItemStack stack,
      final IDimension worldIn,
      final com.ldtteam.jvoxelizer.block.state.IBlockState state,
      final IBlockCoordinate pos,
      final ILivingBaseEntity entityLiving)
    {
        return this.onBlockDestroyed(
          com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack),
          Dimension.asForge(worldIn),
          BlockState.asForge(state),
          BlockCoordinate.asForge(pos),
          LivingBaseEntity.asForge(entityLiving)
        );
    }

    @Override
    public boolean canHarvestBlock(final com.ldtteam.jvoxelizer.block.state.IBlockState blockIn)
    {
        return this.canHarvestBlock(
          BlockState.asForge(blockIn)
        );
    }

    @Override
    public boolean itemInteractionForEntity(
      final IItemStack stack, final IPlayerEntity playerIn, final ILivingBaseEntity target, final IHand hand)
    {
        return this.itemInteractionForEntity(
          com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack),
          PlayerEntity.asForge(playerIn),
          LivingBaseEntity.asForge(target),
          Hand.asForge(hand)
        );
    }

    @Override
    public String getUnlocalizedNameInefficiently(final IItemStack stack)
    {
        return this.getTranslationKey(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack));
    }

    @Override
    public String getUnlocalizedName()
    {
        return this.getTranslationKey();
    }

    @Override
    public String getUnlocalizedName(final IItemStack stack)
    {
        return this.getTranslationKey(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack));
    }

    @Override
    public IItem<?> getRemainderItemAfterUse()
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.item.Item.fromForge(this.getContainerItem());
    }

    @Override
    public void onUpdate(
      final IItemStack stack, final IDimension worldIn, final IEntity entityIn, final int itemSlot, final boolean isSelected)
    {
        this.inventoryTick(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack),
          Dimension.asForge(worldIn),
          com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.Entity
            .asForge(entityIn),
          itemSlot,
          isSelected);
    }

    @Override
    public void onCreated(
      final IItemStack stack, final IDimension worldIn, final IPlayerEntity playerIn)
    {
        this.onCreated(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack), Dimension.asForge(worldIn), PlayerEntity.asForge(playerIn));
    }

    @Override
    public IActionType getItemUseAction(final IItemStack stack)
    {
        return ActionType.fromForge(this.getUseAction(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack)));
    }

    @Override
    public int getMaxItemUseDuration(final IItemStack stack)
    {
        return getUseDuration(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack));
    }

    @Override
    public void onPlayerStoppedUsing(
      final IItemStack stack, final IDimension worldIn, final ILivingBaseEntity entityLiving, final int timeLeft)
    {
        this.onPlayerStoppedUsing(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack),
          Dimension.asForge(worldIn),
          LivingBaseEntity.asForge(entityLiving),
          timeLeft);
    }

    @Override
    public void addInformation(
      final IItemStack stack, final IDimension worldIn, final List<String> tooltip, final IToolTipFlag flagIn)
    {
        final List<ITextComponent> textComponents = tooltip.stream().map(TextComponentString::new).collect(Collectors.toList());

        this.addInformation(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack), Dimension.asForge(worldIn), textComponents, ToolTipFlag.asForge(flagIn));
    }

    @Override
    public String getItemStackDisplayName(final IItemStack stack)
    {
        return this.getDisplayName(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack)).getFormattedText();
    }

    @Override
    public boolean hasEffect(final IItemStack stack)
    {
        return this.hasEffect(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack));
    }

    @Override
    public IRarity getRarity(final IItemStack stack)
    {
        return Rarity.fromForge(this.getRarity(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack)));
    }

    @Override
    public boolean isEnchantable(final IItemStack stack)
    {
        return this.isEnchantable(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack));
    }

    @Override
    public void getSubItems(final IItemGroup<?> tab, final List<IItemStack> items)
    {
        final NonNullList<ItemStack> stacks = items.stream().map(i -> com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(i)).collect(
          NonNullListCollector.toList());
        this.fillItemGroup(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.group.ItemGroup.asForge(tab), stacks);

        items.clear();
        items.addAll(stacks.stream().map(i -> com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(i)).collect(Collectors.toList()));
    }

    @Override
    public IItemGroup<?> getItemGroup()
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.item.group.ItemGroup.fromForge(this.getGroup());
    }

    @Override
    public boolean getIsRepairable(final IItemStack toRepair, final IItemStack repair)
    {
        return this.getIsRepairable(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(toRepair), com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
                                                                                                                   .asForge(repair));
    }

    @Override
    public Multimap<String, IAttributeModifier> getItemAttributeModifiers(final IEquipmentSlot equipmentSlot)
    {
        return this.getAttributeModifiers(EquipmentSlot.asForge(equipmentSlot)).entries().stream().map(e -> new Tuple<>(e.getKey(),
          com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.ai.AttributeModifier.fromForge(e.getValue()))).collect(MultiMapCollector.toMultimap(Tuple::getA, Tuple::getB));
    }

    @Override
    public Multimap<String, IAttributeModifier> getAttributeModifiers(
      final IEquipmentSlot slot, final IItemStack stack)
    {
        return this.getAttributeModifiers(EquipmentSlot.asForge(slot), com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack))
                 .entries()
                 .stream()
                 .map(e -> new Tuple<>(e.getKey(),
                   com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.ai.AttributeModifier.fromForge(e.getValue())))
                 .collect(MultiMapCollector.toMultimap(Tuple::getA, Tuple::getB));
    }

    @Override
    public boolean onDroppedByPlayer(final IItemStack IItem, final IPlayerEntity player)
    {
        return this.onDroppedByPlayer(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(IItem), PlayerEntity.asForge(player));
    }

    @Override
    public String getHighlightTip(final IItemStack IItem, final String displayName)
    {
        return this.getHighlightTip(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(IItem), displayName);
    }

    @Override
    public IActionResultType onItemUseFirst(
      final IPlayerEntity player,
      final IDimension IDimension,
      final IBlockCoordinate pos,
      final IFacing side,
      final float hitX,
      final float hitY,
      final float hitZ,
      final IHand hand)
    {
        return ActionResultType.fromForge(
          this.onItemUseFirst(
            PlayerEntity.asForge(player),
            Dimension.asForge(IDimension),
            BlockCoordinate.asForge(pos),
            Hand.asForge(hand),
            Facing.asForge(side),
            hitX,
            hitY,
            hitZ
          )
        );
    }

    @Override
    public INBTCompound getNBTShareTag(final IItemStack stack)
    {
        return NBTCompound.fromForge(this.getShareTag(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack)));
    }

    @Override
    public void readNBTShareTag(final IItemStack stack, final INBTCompound nbt)
    {
        this.readShareTag(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack), NBTCompound.asForge(nbt));
    }

    @Override
    public boolean onBlockStartBreak(
      final IItemStack IItemStack, final IBlockCoordinate pos, final IPlayerEntity player)
    {
        return this.onBlockStartBreak(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(IItemStack), BlockCoordinate.asForge(pos), PlayerEntity.asForge(player));
    }

    @Override
    public void onUsingTick(final IItemStack stack, final ILivingBaseEntity player, final int count)
    {
        this.onUsingTick(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack), LivingBaseEntity.asForge(player), count);
    }

    @Override
    public boolean onLeftClickEntity(
      final IItemStack stack, final IPlayerEntity player, final IEntity IEntity)
    {
        return this.onLeftClickEntity(
          com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack),
          PlayerEntity.asForge(player),
          com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.Entity.asForge(IEntity)
        );
    }

    @Override
    public IItemStack getRemainderItemAfterUse(final IItemStack IItemStack)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(this.getContainerItem(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
                                                                                                           .asForge(IItemStack)));
    }

    @Override
    public boolean hasContainerItem(final IItemStack stack)
    {
        return this.hasContainerItem(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack));
    }

    @Override
    public int getEntityLifespan(final IItemStack IItemStack, final IDimension IDimension)
    {
        return this.getEntityLifespan(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(IItemStack), Dimension.asForge(IDimension));
    }

    @Override
    public boolean hasCustomEntity(final IItemStack stack)
    {
        return this.hasCustomEntity(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack));
    }

    @Override
    public IEntity createEntity(
      final IDimension IDimension, final IEntity location, final IItemStack IItemStack)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.Entity.fromForge(this.createEntity(Dimension.asForge(IDimension),
          com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.Entity.asForge(location), com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(IItemStack)));
    }

    @Override
    public boolean onEntityItemUpdate(final IItemStackEntity entityItem)
    {
        return this.onEntityItemUpdate(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(entityItem.getItemStack()), ItemStackEntity.asForge(entityItem));
    }

    @Override
    public IItemGroup<?>[] getItemGroups()
    {
        return this.getCreativeTabs().stream().map(ItemGroup::fromForge).toArray(IItemGroup<?>[]::new);
    }

    @Override
    public float getSmeltingExperience(final IItemStack IItem)
    {
        return this.getSmeltingExperience(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(IItem));
    }

    @Override
    public boolean doesSneakBypassUse(
      final IItemStack stack, final IDimension world, final IBlockCoordinate pos, final IPlayerEntity player)
    {
        return this.doesSneakBypassUse(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack),
          Dimension.asForge(world),
          BlockCoordinate.asForge(pos),
          PlayerEntity.asForge(player));
    }

    @Override
    public void onArmorTick(
      final IDimension IDimension, final IPlayerEntity player, final IItemStack IItemStack)
    {
        this.onArmorTick(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(IItemStack), Dimension.asForge(IDimension), PlayerEntity.asForge(player));
    }

    @Override
    public boolean isValidArmor(
      final IItemStack stack, final IEquipmentSlot armorType, final IEntity IEntity)
    {
        return this.canEquip(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack),
          EquipmentSlot.asForge(armorType),
          com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.Entity
            .asForge(IEntity));
    }

    @Override
    public IEquipmentSlot getEquipmentSlot(final IItemStack stack)
    {
        return EquipmentSlot.fromForge(this.getEquipmentSlot(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack)));
    }

    @Override
    public boolean isBookEnchantable(final IItemStack stack, final IItemStack book)
    {
        return this.isBookEnchantable(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack), com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
                                                                                                                  .asForge(book));
    }

    @Override
    public String getArmorTexture(
      final IItemStack stack, final IEntity IEntity, final IEquipmentSlot slot, final String type)
    {
        return this.getArmorTexture(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack),
          com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.Entity.asForge(IEntity),
          EquipmentSlot.asForge(slot),
          type);
    }

    @Override
    public IFontRenderer getFontRenderer(final IItemStack stack)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.font.FontRenderer.fromForge(this.getFontRenderer(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
                                                                                                                             .asForge(stack)));
    }

    @Override
    public IModelBiped getArmorModel(
      final ILivingBaseEntity entityLiving, final IItemStack IItemStack, final IEquipmentSlot armorSlot, final IModelBiped _default)
    {
        return ModelBiped.fromForge(
          this.getArmorModel(
            LivingBaseEntity.asForge(entityLiving),
            com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(IItemStack),
            EquipmentSlot.asForge(armorSlot),
            ModelBiped.asForge(_default)
          )
        );
    }

    @Override
    public boolean onEntitySwing(final ILivingBaseEntity entityLiving, final IItemStack stack)
    {
        return this.onEntitySwing(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack), LivingBaseEntity.asForge(entityLiving));
    }

    @Override
    public int getDamage(final IItemStack stack)
    {
        return this.getDamage(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack));
    }

    @Override
    public boolean showDurabilityBar(final IItemStack stack)
    {
        return this.showDurabilityBar(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack));
    }

    @Override
    public double getDurabilityForDisplay(final IItemStack stack)
    {
        return this.getDurabilityForDisplay(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack));
    }

    @Override
    public int getRGBDurabilityForDisplay(final IItemStack stack)
    {
        return this.getRGBDurabilityForDisplay(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack));
    }

    @Override
    public int getMaxDamage(final IItemStack stack)
    {
        return this.getMaxDamage(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack));
    }

    @Override
    public boolean isDamaged(final IItemStack stack)
    {
        return this.isDamaged(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack));
    }

    @Override
    public void setDamage(final IItemStack stack, final int damage)
    {
        this.setDamage(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack), damage);
    }

    @Override
    public boolean canHarvestBlock(final com.ldtteam.jvoxelizer.block.state.IBlockState state, final IItemStack stack)
    {
        return this.canHarvestBlock(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack), BlockState.asForge(state));
    }

    @Override
    public int getItemStackLimit(final IItemStack stack)
    {
        return this.getItemStackLimit(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack));
    }

    @Override
    public Set<String> getToolClasses(final IItemStack stack)
    {
        return this.getToolTypes(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack)).stream().map(ToolType::getName).collect(Collectors.toSet());
    }

    @Override
    public int getHarvestLevel(
      final IItemStack stack, final String toolClass, final IPlayerEntity player, final com.ldtteam.jvoxelizer.block.state.IBlockState blockState)
    {
        return this.getHarvestLevel(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack),
          ToolType.get(toolClass),
          PlayerEntity.asForge(player),
          BlockState.asForge(blockState));
    }

    @Override
    public int getItemEnchantability(final IItemStack stack)
    {
        return this.getItemEnchantability(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack));
    }

    @Override
    public boolean canApplyAtEnchantingTable(final IItemStack stack, final IEnchantment enchantment)
    {
        return this.canApplyAtEnchantingTable(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack),
          com.ldtteam.jvoxelizer.launcher.forge_1_13.enchantment.Enchantment
            .asForge(enchantment));
    }

    @Override
    public boolean isBeaconPayment(final IItemStack stack)
    {
        return this.isBeaconPayment(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack));
    }

    @Override
    public boolean shouldCauseReequipAnimation(final IItemStack oldStack, final IItemStack newStack, final boolean slotChanged)
    {
        return this.shouldCauseReequipAnimation(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(oldStack),
          com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
            .asForge(newStack),
          slotChanged);
    }

    @Override
    public boolean shouldCauseBlockBreakReset(final IItemStack oldStack, final IItemStack newStack)
    {
        return this.shouldCauseBlockBreakReset(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(oldStack),
          com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
            .asForge(newStack));
    }

    @Override
    public String getCreatorModId(final IItemStack IItemStack)
    {
        return this.getCreatorModId(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(IItemStack));
    }

    @Override
    public ImmutableMap<String, ITimedValue> getAnimationParameters(
      final IItemStack stack, final IDimension IDimension, final ILivingBaseEntity IEntity)
    {
        return ImmutableMap.copyOf(
          this.getAnimationParameters(
            com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack),
            Dimension.asForge(IDimension),
            LivingBaseEntity.asForge(IEntity)
          ).entrySet().stream().map(e -> new Tuple<>(e.getKey(), TimedValue.fromForge(e.getValue()))).collect(Collectors.toMap(Tuple::getA, Tuple::getB))
        );
    }

    @Override
    public boolean canDisableShield(
      final IItemStack stack, final IItemStack shield, final ILivingBaseEntity IEntity, final ILivingBaseEntity attacker)
    {
        return this.canDisableShield(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack),
          com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
            .asForge(shield),
          LivingBaseEntity.asForge(IEntity),
          LivingBaseEntity.asForge(attacker));
    }

    @Override
    public boolean isShield(final IItemStack stack, final ILivingBaseEntity IEntity)
    {
        return this.isShield(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack), LivingBaseEntity.asForge(IEntity));
    }

    @Override
    public int getItemBurnTime(final IItemStack IItemStack)
    {
        return this.getBurnTime(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(IItemStack));
    }

    @Override
    public IHorseArmorType getHorseArmorType(final IItemStack stack)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.passive.HorseArmorType.fromForge(this.getHorseArmorType(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
                                                                                                                           .asForge(stack)));
    }

    @Override
    public void onHorseArmorTick(
      final IDimension IDimension, final ILivingEntity horse, final IItemStack armor)
    {
        this.onHorseArmorTick(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(armor), Dimension.asForge(IDimension), LivingEntity.asForge(horse));
    }

    @Override
    public IBlockEntityRenderer getBlockEntityItemStackRenderer()
    {
        return BlockEntityRenderer.fromForge(this.getTileEntityItemStackRenderer());
    }

    @Override
    public IItemStack createDefaultItemStack()
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(this.getDefaultInstance());
    }

    @Override
    public String getTranslationKey(final IItemStack pItemStack1)
    {
        return this.getUnlocalizedName(pItemStack1);
    }

    @Override
    public I getInstanceData()
    {
        return instanceData;
    }

    @Override
    public IItem<I> setRegistryIdentifier(final IIdentifier name)
    {
        this.setRegistryName(Identifier.asForge(name));
        return this;
    }

    @Override
    public IIdentifier getRegistryIdentifier()
    {
        return Identifier.fromForge(this.getRegistryName());
    }

    @Override
    public Class getTypeUsedForRegistration()
    {
        return IItem.class;
    }

    @Override
    public boolean getHasSubtypes()
    {
        return false;
    }

    @Override
    public boolean isFull3D()
    {
        return false;
    }

    @Override
    public boolean shouldRotateAroundWhenRendering()
    {
        return true;
    }

    @Override
    public boolean canItemEditBlocks()
    {
        return true;
    }

    @Override
    public void setHarvestLevel(final String toolClass, final int level)
    {
        //Noop
    }

    private static class ItemPropertiesBuilder<I>
    {
        public Item.Properties build(ForgeItemPipeline<IItem<I>, I> pipeline)
        {
            final Item.Properties properties = new Item.Properties();
            if (!pipeline.getGetMaxDamagePipeline().isEmpty())
                properties.defaultMaxDamage(PipelineProcessor.processTypedPipeline(
                  null,
                  new GetMaxDamageContext(),
                  pipeline.getGetMaxDamagePipeline(),
                  (c) -> 0
                ));

            if (!pipeline.getGetItemStackLimitPipeline().isEmpty())
                properties.maxStackSize(PipelineProcessor.processTypedPipeline(
                  null,
                  new GetItemStackLimitContext(),
                  pipeline.getGetItemStackLimitPipeline(),
                  (c) -> 64
                ));

            if (!pipeline.getGetContainerItemPipeline().isEmpty())
                properties.containerItem(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.Item.asForge(PipelineProcessor.processTypedPipeline(
                  null,
                  new GetContainerItemContext(),
                  pipeline.getGetContainerItemPipeline(),
                  (c) -> null
                )));

            if (!pipeline.getGetCreativeTabPipeline().isEmpty())
                properties.group(ItemGroup.asForge(PipelineProcessor.processTypedPipeline(
                  null,
                  new GetCreativeTabContext(),
                  pipeline.getGetCreativeTabPipeline(),
                  (c) -> null
                )));

            return properties;
        }
    }
}
