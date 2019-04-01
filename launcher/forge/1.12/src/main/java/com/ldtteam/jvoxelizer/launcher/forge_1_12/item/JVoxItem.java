package com.ldtteam.jvoxelizer.launcher.forge_1_12.item;

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
import com.ldtteam.jvoxelizer.launcher.forge_1_12.block.state.BlockState;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.blockentity.BlockEntityRenderer;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.common.animation.TimedValue;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.Dimension;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.DimensionReader;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.item.ItemStackEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.LivingBaseEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.LivingEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player.PlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.group.ItemGroup;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.logic.pipeline.ForgeItemPipeline;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.action.ActionType;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.actionresult.ActionResultType;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.equipmentslot.EquipmentSlot;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.facing.Facing;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.hand.Hand;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.identifier.Identifier;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.coordinate.block.BlockCoordinate;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt.NBTCompound;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.rarity.Rarity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.stream.nonnulllist.NonNullListCollector;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.tooltipflag.ToolTipFlag;
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
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
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
import net.minecraft.world.GameType;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.animation.ITimeValue;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.ai.AttributeModifier.asForge;
import static com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.ai.AttributeModifier.fromForge;
import static com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemStack.asForge;
import static com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemStack.fromForge;

public class JVoxItem<I> extends Item implements IItem<I>
{
    private final I                              instanceData;
    private final ForgeItemPipeline<IItem<I>, I> pipeline;

    public JVoxItem(final I instanceData, final ForgeItemPipeline<IItem<I>, I> pipeline)
    {
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

    @Override
    public Item setMaxStackSize(final int maxStackSize)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new SetMaxStackSizeContext(maxStackSize),
            pipeline.getSetMaxStackSizePipeline(),
            (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.fromForge(super.setMaxStackSize(c.getMaxStackSize()))
          )
        );
    }

    /**
     * Called when a Block is right-clicked with this Item
     */
    @Override
    public EnumActionResult onItemUse(
      final EntityPlayer player, final World worldIn, final BlockPos pos, final EnumHand hand, final EnumFacing facing, final float hitX, final float hitY, final float hitZ)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.util.actionresult.ActionResultType.asForge(
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
            (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_12.util.actionresult.ActionResultType.fromForge(super.onItemUse(PlayerEntity.asForge(c.getPlayer()),
              Dimension.asForge(c.getWorldIn()),
              BlockCoordinate.asForge(c.getPos()),
              Hand.asForge(c.getHand()),
              Facing.asForge(c.getFacing()),
              c.getHitX(),
              c.getHitY(),
              c.getHitZ()))
          )
        );
    }

    @Override
    public float getDestroySpeed(final ItemStack stack, final IBlockState state)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetDestroySpeedContext(fromForge(stack), BlockState.fromForge(state)),
          pipeline.getGetDestroySpeedPipeline(),
          (c) -> super.getDestroySpeed(asForge(c.getStack()), BlockState.asForge(c.getState()))
        );
    }

    /**
     * Called when the equipped item is right clicked.
     */
    @NotNull
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World worldIn, final EntityPlayer playerIn, @NotNull final EnumHand handIn)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.util.actionresult.ActionResult.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new OnItemRightClickContext(Dimension.fromForge(worldIn), PlayerEntity.fromForge(playerIn), Hand.fromForge(handIn)),
            pipeline.getOnItemRightClickPipeline(),
            (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_12.util.actionresult.ActionResult.fromForge(super.onItemRightClick(Dimension.asForge(c.getWorldIn()),
              PlayerEntity.asForge(c.getPlayerIn()),
              Hand.asForge(c.getHandIn())),
              com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemStack::fromForge)
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
        return asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new OnItemUseFinishContext(fromForge(stack), Dimension.fromForge(worldIn), LivingBaseEntity.fromForge(entityLiving)),
            pipeline.getOnItemUseFinishPipeline(),
            (c) -> fromForge(super.onItemUseFinish(asForge(c.getStack()), Dimension.asForge(c.getWorldIn()), LivingBaseEntity.asForge(c.getEntityLiving())))
          )
        );
    }

    /**
     * Returns the maximum size of the stack for a specific item. *Isn't this more a Set than a Get?*
     */
    @Override
    public int getItemStackLimit()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetItemStackLimitContext(),
          pipeline.getGetItemStackLimitPipeline(),
          (c) -> super.getItemStackLimit()
        );
    }

    /**
     * Converts the given ItemStack damage value into a metadata value to be placed in the world when this Item is
     * placed as a Block (mostly used with ItemBlocks).
     */
    @Override
    public int getMetadata(final int damage)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetMetadataContext(damage),
          pipeline.getGetMetadataPipeline(),
          (c) -> super.getMetadata(c.getDamage())
        );
    }

    @Override
    public boolean getHasSubtypes()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetHasSubtypesContext(),
          pipeline.getGetHasSubtypesPipeline(),
          (c) -> super.getHasSubtypes()
        );
    }

    @NotNull
    @Override
    public Item setHasSubtypes(final boolean hasSubtypes)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new SetHasSubtypesContext(hasSubtypes),
          pipeline.getSetHasSubtypesPipeline(),
          (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.fromForge(super.setHasSubtypes(c.getHasSubtypes()))
        ));
    }

    /**
     * Returns the maximum damage an item can take.
     */
    @Override
    public int getMaxDamage()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetMaxDamageContext(),
          pipeline.getGetMaxDamagePipeline(),
          (c) -> super.getMaxDamage()
        );
    }

    /**
     * set max damage of an Item
     */
    @Override
    public Item setMaxDamage(final int maxDamageIn)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new SetMaxDamageContext(maxDamageIn),
          pipeline.getSetMaxDamagePipeline(),
          (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.fromForge(super.setMaxDamage(c.getMaxDamageIn()))
        ));
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
          new HitEntityContext(fromForge(stack), LivingBaseEntity.fromForge(target), LivingBaseEntity.fromForge(attacker)),
          pipeline.getHitEntityPipeline(),
          (c) -> super.hitEntity(asForge(c.getStack()), LivingBaseEntity.asForge(c.getTarget()), LivingBaseEntity.asForge(c.getAttacker()))
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
          new OnBlockDestroyedContext(fromForge(stack),
            Dimension.fromForge(worldIn),
            BlockState.fromForge(state),
            BlockCoordinate.fromForge(pos),
            LivingBaseEntity.fromForge(entityLiving)),
          pipeline.getOnBlockDestroyedPipeline(),
          (c) -> super.onBlockDestroyed(asForge(c.getStack()),
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
          new ItemInteractionForEntityContext(fromForge(stack), PlayerEntity.fromForge(playerIn), LivingBaseEntity.fromForge(target), Hand.fromForge(hand)),
          pipeline.getItemInteractionForEntityPipeline(),
          (c) -> super.itemInteractionForEntity(asForge(c.getStack()), PlayerEntity.asForge(c.getPlayerIn()), LivingBaseEntity.asForge(c.getPlayerIn()), Hand.asForge(c.getHand()))
        );
    }

    /**
     * Sets bFull3D to True and return the object.
     */
    @Override
    public Item setFull3D()
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new SetFull3DContext(),
          pipeline.getSetFull3DPipeline(),
          (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.fromForge(super.setFull3D())));
    }

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    @Override
    public boolean isFull3D()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsFull3DContext(),
          pipeline.getIsFull3DPipeline(),
          (c) -> super.isFull3D());
    }

    /**
     * Returns true if this item should be rotated by 180 degrees around the Y axis when being held in an entities
     * hands.
     */
    @Override
    public boolean shouldRotateAroundWhenRendering()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new ShouldRotateAroundWhenRenderingContext(),
          pipeline.getShouldRotateAroundWhenRenderingPipeline(),
          (c) -> super.shouldRotateAroundWhenRendering());
    }

    /**
     * Sets the unlocalized name of this item to the string passed as the parameter, prefixed by "item."
     */
    @Override
    public Item setUnlocalizedName(@NotNull final String unlocalizedName)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new SetUnlocalizedNameContext(unlocalizedName),
          pipeline.getSetUnlocalizedNamePipeline(),
          (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.fromForge(super.setUnlocalizedName(c.getUnlocalizedName()))));
    }

    /**
     * Translates the unlocalized name of this item, but without the .name suffix, so the translation fails and the
     * unlocalized name itself is returned.
     */
    @Override
    public String getUnlocalizedNameInefficiently(@NotNull final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetUnlocalizedNameInefficientlyContext(fromForge(stack)),
          pipeline.getGetUnlocalizedNameInefficientlyPipeline(),
          (c) -> super.getUnlocalizedNameInefficiently(asForge(c.getStack())));
    }

    /**
     * Returns the unlocalized name of this item.
     */
    @Override
    public String getUnlocalizedName()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetUnlocalizedNameContext(),
          pipeline.getGetUnlocalizedNamePipeline(),
          (c) -> super.getUnlocalizedName());
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    @Override
    public String getUnlocalizedName(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetUnlocalizedNameWithStackAsItemStackContext(fromForge(stack)),
          pipeline.getGetUnlocalizedNameWithStackAsItemStackPipeline(),
          (c) -> super.getUnlocalizedName(asForge(c.getStack())));
    }

    @Override
    public Item setContainerItem(final Item containerItem)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new SetContainerItemContext(com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.fromForge(containerItem)),
          pipeline.getSetContainerItemPipeline(),
          (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.fromForge(super.setContainerItem(com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.asForge(c.getContainerItem())))));
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

    @Nullable
    @Override
    public Item getContainerItem()
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new GetContainerItemContext(),
          pipeline.getGetContainerItemPipeline(),
          (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.fromForge(super.getContainerItem())));
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
    public void onUpdate(final ItemStack stack, final World worldIn, final Entity entityIn, final int itemSlot, final boolean isSelected)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new OnUpdateContext(fromForge(stack), Dimension.fromForge(worldIn),
            com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity.fromForge(entityIn), itemSlot, isSelected),
          pipeline.getOnUpdatePipeline(),
          (c) -> super.onUpdate(asForge(c.getStack()), Dimension.asForge(c.getWorldIn()),
            com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity.asForge(c.getEntityIn()), c.getItemSlot(), c.getIsSelected()));
    }

    /**
     * Called when item is crafted/smelted. Used only by maps so far.
     */
    @Override
    public void onCreated(final ItemStack stack, final World worldIn, final EntityPlayer playerIn)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new OnCreatedContext(fromForge(stack), Dimension.fromForge(worldIn),
            PlayerEntity.fromForge(playerIn)),
          pipeline.getOnCreatedPipeline(),
          (c) -> super.onCreated(asForge(c.getStack()), Dimension.asForge(c.getWorldIn()),
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
          (c) -> super.isMap());
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    @Override
    public EnumAction getItemUseAction(final ItemStack stack)
    {
        return ActionType.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new GetItemUseActionContext(fromForge(stack)),
          pipeline.getGetItemUseActionPipeline(),
          (c) -> ActionType.fromForge(super.getItemUseAction(asForge(c.getStack()))))
        );
    }

    /**
     * How long it takes to use or consume an item
     */
    @Override
    public int getMaxItemUseDuration(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetMaxItemUseDurationContext(fromForge(stack)),
          pipeline.getGetMaxItemUseDurationPipeline(),
          (c) -> super.getMaxItemUseDuration(asForge(c.getStack())));
    }

    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
    @Override
    public void onPlayerStoppedUsing(final ItemStack stack, final World worldIn, final EntityLivingBase entityLiving, final int timeLeft)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new OnPlayerStoppedUsingContext(fromForge(stack), Dimension.fromForge(worldIn),
            LivingBaseEntity.fromForge(entityLiving), timeLeft),
          pipeline.getOnPlayerStoppedUsingPipeline(),
          (c) -> super.onPlayerStoppedUsing(asForge(c.getStack()), Dimension.asForge(c.getWorldIn()),
            LivingBaseEntity.asForge(c.getEntityLiving()), timeLeft));
    }

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    @Override
    public void addInformation(
      final ItemStack stack, @Nullable final World worldIn, final List<String> tooltip, final ITooltipFlag flagIn)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new AddInformationContext(fromForge(stack), Dimension.fromForge(worldIn),
            tooltip, ToolTipFlag.fromForge(flagIn)),
          pipeline.getAddInformationPipeline(),
          (c) -> super.addInformation(asForge(c.getStack()), Dimension.asForge(c.getWorldIn()),
            tooltip, ToolTipFlag.asForge(c.getFlagIn())));
    }

    @NotNull
    @Override
    public String getItemStackDisplayName(@NotNull final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetItemStackDisplayNameContext(fromForge(stack)),
          pipeline.getGetItemStackDisplayNamePipeline(),
          (c) -> super.getItemStackDisplayName(asForge(c.getStack())));
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
          new HasEffectContext(fromForge(stack)),
          pipeline.getHasEffectPipeline(),
          (c) -> super.hasEffect(asForge(c.getStack())));
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
          new GetRarityContext(fromForge(stack)),
          pipeline.getGetRarityPipeline(),
          (c) -> Rarity.fromForge(super.getRarity(asForge(c.getStack()))))
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
          new IsEnchantableContext(fromForge(stack)),
          pipeline.getIsEnchantablePipeline(),
          (c) -> super.isEnchantable(asForge(c.getStack())));
    }

    @NotNull
    @Override
    protected RayTraceResult rayTrace(final World worldIn, final EntityPlayer playerIn, final boolean useLiquids)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.raytraceresult.RayTraceResult.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new RayTraceContext(Dimension.fromForge(worldIn), PlayerEntity.fromForge(playerIn), useLiquids),
          pipeline.getRayTracePipeline(),
          (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.raytraceresult.RayTraceResult.fromForge(super.rayTrace(Dimension.asForge(c.getWorldIn()),
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
    public void getSubItems(@NotNull final CreativeTabs tab, @NotNull final NonNullList<ItemStack> items)
    {
        List<IItemStack> theItems = new ArrayList<>();
        items.forEach(item -> theItems.add(fromForge(item)));

        PipelineProcessor.processVoidPipeline(
          this,
          new GetSubItemsContext(ItemGroup.fromForge(tab), theItems),
          pipeline.getGetSubItemsPipeline(),
          (c) -> super.getSubItems(ItemGroup.asForge(c.getTab()), getNonNullListFromList(c.getItems())));
    }

    @NotNull
    private static NonNullList<ItemStack> getNonNullListFromList(@NotNull final List<IItemStack> theItems)
    {
        final NonNullList<ItemStack> list = NonNullList.create();
        theItems.stream().map(com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemStack::asForge).forEach(list::add);
        return list;
    }

    @Override
    protected boolean isInCreativeTab(final CreativeTabs targetTab)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsInCreativeTabContext(ItemGroup.fromForge(targetTab)),
          pipeline.getIsInCreativeTabPipeline(),
          (c) -> super.isInCreativeTab(ItemGroup.asForge(c.getTargetTab())));
    }

    /**
     * gets the CreativeTab this item is displayed on
     */
    @Nullable
    @Override
    public CreativeTabs getCreativeTab()
    {
        return ItemGroup.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new GetCreativeTabContext(),
          pipeline.getGetCreativeTabPipeline(),
          (c) -> ItemGroup.fromForge(super.getCreativeTab())));
    }

    /**
     * returns this;
     */
    @NotNull
    @Override
    public Item setCreativeTab(@NotNull final CreativeTabs tab)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new SetCreativeTabContext(ItemGroup.fromForge(tab)),
          pipeline.getSetCreativeTabPipeline(),
          (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.fromForge(super.setCreativeTab(ItemGroup.asForge(c.getTab())))));
    }

    /**
     * Returns whether this item is always allowed to edit the world. Forces {@link
     * EntityPlayer#canPlayerEdit EntityPlayer#canPlayerEdit} to return {@code true}.
     *
     * @return whether this item ignores other restrictions on how a player can modify the world.
     *
     * @see ItemStack#canEditBlocks()
     */
    @Override
    public boolean canItemEditBlocks()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new CanItemEditBlocksContext(),
          pipeline.getCanItemEditBlocksPipeline(),
          (c) -> super.canItemEditBlocks());
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
          new GetIsRepairableContext(fromForge(toRepair), fromForge(repair)),
          pipeline.getGetIsRepairablePipeline(),
          (c) -> super.getIsRepairable(asForge(c.getToRepair()), asForge(c.getRepair())));
    }

    /**
     * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
     */
    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(final EntityEquipmentSlot equipmentSlot)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetItemAttributeModifiersContext(EquipmentSlot.fromForge(equipmentSlot)),
          pipeline.getGetItemAttributeModifiersPipeline(),
          (c) -> super.getItemAttributeModifiers(EquipmentSlot.asForge(c.getEquipmentSlot())).entries().stream().map(e -> new Tuple<>(e.getKey(), fromForge(e.getValue()))).collect(
            MultiMapCollector.toMultimap(Tuple::getFirst, Tuple::getSecond))
        ).entries().stream().map(e -> new Tuple<>(e.getKey(), asForge(e.getValue()))).collect(MultiMapCollector.toMultimap(Tuple::getFirst, Tuple::getSecond));
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
          new GetAttributeModifiersContext(EquipmentSlot.fromForge(slot), fromForge(stack)),
          pipeline.getGetAttributeModifiersPipeline(),
          (c) -> super.getAttributeModifiers(EquipmentSlot.asForge(c.getSlot()), asForge(c.getStack()))
                   .entries()
                   .stream()
                   .map(e -> new Tuple<>(e.getKey(), fromForge(e.getValue())))
                   .collect(
                     MultiMapCollector.toMultimap(Tuple::getFirst, Tuple::getSecond))
        ).entries().stream().map(e -> new Tuple<>(e.getKey(), asForge(e.getValue()))).collect(MultiMapCollector.toMultimap(Tuple::getFirst, Tuple::getSecond));
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
          new OnDroppedByPlayerContext(fromForge(item), PlayerEntity.fromForge(player)),
          pipeline.getOnDroppedByPlayerPipeline(),
          (c) -> super.onDroppedByPlayer(asForge(c.getItem()), PlayerEntity.asForge(c.getPlayer()))
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
          new GetHighlightTipContext(fromForge(item), displayName),
          pipeline.getGetHighlightTipPipeline(),
          (c) -> super.getHighlightTip(asForge(c.getItem()), c.getDisplayName())
        );
    }

    /**
     * This is called when the item is used, before the block is activated.
     *
     * @param player The Player that used the item
     * @param world  The Current World
     * @param pos    Target position
     * @param side   The side of the target hit
     * @param hand   Which hand the item is being held in.
     * @return Return PASS to allow vanilla handling, any other to skip normal code.
     */
    @Override
    public EnumActionResult onItemUseFirst(
      final EntityPlayer player, final World world, final BlockPos pos, final EnumFacing side, final float hitX, final float hitY, final float hitZ, final EnumHand hand)
    {
        return ActionResultType.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new OnItemUseFirstContext(PlayerEntity.fromForge(player),
            Dimension.fromForge(world),
            BlockCoordinate.fromForge(pos),
            Facing.fromForge(side),
            hitX,
            hitY,
            hitZ,
            Hand.fromForge(hand)),
          pipeline.getOnItemUseFirstPipeline(),
          (c) -> ActionResultType.fromForge(super.onItemUseFirst(
            PlayerEntity.asForge(c.getPlayer()),
            Dimension.asForge(c.getWorld()),
            BlockCoordinate.asForge(c.getPos()),
            Facing.asForge(c.getSide()),
            c.getHitX(),
            c.getHitY(),
            c.getHitZ(),
            Hand.asForge(c.getHand())
          ))
        ));
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
     * Call to disable repair recipes.
     *
     * @return The current Item instance
     */
    @Override
    public Item setNoRepair()
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new SetNoRepairContext(),
          pipeline.getSetNoRepairPipeline(),
          (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.fromForge(super.setNoRepair())
        ));
    }

    /**
     * Determines the amount of durability the mending enchantment
     * will repair, on average, per point of experience.
     */
    @Override
    public float getXpRepairRatio(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetXpRepairRatioContext(fromForge(stack)),
          pipeline.getGetXpRepairRatioPipeline(),
          (c) -> super.getXpRepairRatio(asForge(c.getStack()))
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
    public NBTTagCompound getNBTShareTag(final ItemStack stack)
    {
        return NBTCompound.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new GetNBTShareTagContext(fromForge(stack)),
            pipeline.getGetNBTShareTagPipeline(),
            (c) -> NBTCompound.fromForge(super.getNBTShareTag(asForge(c.getStack())))
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
    public void readNBTShareTag(final ItemStack stack, @Nullable final NBTTagCompound nbt)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new ReadNBTShareTagContext(fromForge(stack), NBTCompound.fromForge(nbt)),
          pipeline.getReadNBTShareTagPipeline(),
          (c) -> super.readNBTShareTag(asForge(c.getStack()), NBTCompound.asForge(c.getNbt()))
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
          new OnBlockStartBreakContext(fromForge(itemstack), BlockCoordinate.fromForge(pos), PlayerEntity.fromForge(player)),
          pipeline.getOnBlockStartBreakPipeline(),
          (c) -> super.onBlockStartBreak(asForge(c.getItemstack()), BlockCoordinate.asForge(c.getPos()), PlayerEntity.asForge(c.getPlayer()))
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
          new OnUsingTickContext(fromForge(stack), LivingBaseEntity.fromForge(player), count),
          pipeline.getOnUsingTickPipeline(),
          (c) -> super.onUsingTick(asForge(c.getStack()), LivingBaseEntity.asForge(c.getPlayer()), c.getCount())
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
          new OnLeftClickEntityContext(fromForge(stack), PlayerEntity.fromForge(player), com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity.fromForge(entity)),
          pipeline.getOnLeftClickEntityPipeline(),
          (c) -> super.onLeftClickEntity(asForge(c.getStack()),
            PlayerEntity.asForge(c.getPlayer()),
            com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity.asForge(c.getEntity()))
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
        return asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new GetContainerItemWithItemStackAsItemStackContext(fromForge(itemStack)),
            pipeline.getGetContainerItemWithItemStackAsItemStackPipeline(),
            (c) -> fromForge(super.getContainerItem(asForge(c.getItemStack())))
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
          new HasContainerItemWithStackAsItemStackContext(fromForge(stack)),
          pipeline.getHasContainerItemWithStackAsItemStackPipeline(),
          (c) -> super.hasContainerItem(asForge(c.getStack()))
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
          new GetEntityLifespanContext(fromForge(itemStack), Dimension.fromForge(world)),
          pipeline.getGetEntityLifespanPipeline(),
          (c) -> super.getEntityLifespan(asForge(c.getItemStack()), Dimension.asForge(c.getWorld()))
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
          new HasCustomEntityContext(fromForge(stack)),
          pipeline.getHasCustomEntityPipeline(),
          (c) -> super.hasCustomEntity(asForge(c.getStack()))
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
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new CreateEntityContext(Dimension.fromForge(world),
              com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity.fromForge(location),
              fromForge(itemstack)),
            pipeline.getCreateEntityPipeline(),
            (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity.fromForge(
              super.createEntity(
                Dimension.asForge(c.getWorld()),
                com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity.asForge(c.getLocation()),
                asForge(c.getItemstack())
              )
            )
          )
        );
    }

    /**
     * Called by the default implemetation of EntityItem's onUpdate method, allowing for cleaner
     * control over the update of the item without having to write a subclass.
     *
     * @param entityItem The entity Item
     * @return Return true to skip any further update code.
     */
    @Override
    public boolean onEntityItemUpdate(final EntityItem entityItem)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new OnEntityItemUpdateContext(ItemStackEntity.fromForge(entityItem)),
          pipeline.getOnEntityItemUpdatePipeline(),
          (c) -> super.onEntityItemUpdate(ItemStackEntity.asForge(c.getEntityItem()))
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
    public CreativeTabs[] getCreativeTabs()
    {
        return Arrays.stream(
          PipelineProcessor.processTypedPipeline(
            this,
            new GetCreativeTabsContext(),
            pipeline.getGetCreativeTabsPipeline(),
            (c) -> Arrays.stream(
              super.getCreativeTabs()
            ).map(ItemGroup::fromForge).toArray(IItemGroup<?>[]::new)
          )
        ).map(ItemGroup::asForge).toArray(CreativeTabs[]::new);
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
          new GetSmeltingExperienceContext(fromForge(item)),
          pipeline.getGetSmeltingExperiencePipeline(),
          (c) -> super.getSmeltingExperience(asForge(c.getItem()))
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
      final ItemStack stack, final IBlockAccess world, final BlockPos pos, final EntityPlayer player)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new DoesSneakBypassUseContext(fromForge(stack), DimensionReader.fromForge(world), BlockCoordinate.fromForge(pos), PlayerEntity.fromForge(player)),
          pipeline.getDoesSneakBypassUsePipeline(),
          (c) -> super.doesSneakBypassUse(asForge(c.getStack()), DimensionReader.asForge(c.getWorld()), BlockCoordinate.asForge(c.getPos()), PlayerEntity.asForge(c.getPlayer()))
        );
    }

    /**
     * Called to tick armor in the armor slot. Override to do something
     */
    @Override
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new OnArmorTickContext(Dimension.fromForge(world), PlayerEntity.fromForge(player), fromForge(itemStack)),
          pipeline.getOnArmorTickPipeline(),
          (c) -> super.onArmorTick(Dimension.asForge(c.getWorld()), PlayerEntity.asForge(c.getPlayer()), asForge(c.getItemStack()))
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
    public boolean isValidArmor(final ItemStack stack, final EntityEquipmentSlot armorType, final Entity entity)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsValidArmorContext(fromForge(stack), EquipmentSlot.fromForge(armorType), com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity.fromForge(entity)),
          pipeline.getIsValidArmorPipeline(),
          (c) -> super.isValidArmor(asForge(c.getStack()), EquipmentSlot.asForge(c.getArmorType()), com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity.asForge(c.getEntity()))
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
            new GetEquipmentSlotContext(fromForge(stack)),
            pipeline.getGetEquipmentSlotPipeline(),
            (c) -> EquipmentSlot.fromForge(super.getEquipmentSlot(asForge(c.getStack())))
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
          new IsBookEnchantableContext(fromForge(stack), fromForge(book)),
          pipeline.getIsBookEnchantablePipeline(),
          (c) -> super.isBookEnchantable(asForge(c.getStack()), asForge(c.getBook()))
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
          new GetArmorTextureContext(fromForge(stack), com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity.fromForge(entity), EquipmentSlot.fromForge(slot), type),
          pipeline.getGetArmorTexturePipeline(),
          (c) -> super.getArmorTexture(asForge(c.getStack()),
            com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity.asForge(c.getEntity()),
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
    @SideOnly(Side.CLIENT)
    @Nullable
    @Override
    public FontRenderer getFontRenderer(final ItemStack stack)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.font.FontRenderer.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new GetFontRendererContext(fromForge(stack)),
            pipeline.getGetFontRendererPipeline(),
            (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.font.FontRenderer.fromForge(super.getFontRenderer(asForge(c.getStack())))
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
    @SideOnly(Side.CLIENT)
    @Nullable
    @Override
    public ModelBiped getArmorModel(
      final EntityLivingBase entityLiving, final ItemStack itemStack, final EntityEquipmentSlot armorSlot, final ModelBiped _default)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.client.model.ModelBiped.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new GetArmorModelContext(LivingBaseEntity.fromForge(entityLiving), fromForge(itemStack), EquipmentSlot.fromForge(armorSlot),
              com.ldtteam.jvoxelizer.launcher.forge_1_12.client.model.ModelBiped.fromForge(_default)),
            pipeline.getGetArmorModelPipeline(),
            (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_12.client.model.ModelBiped.fromForge(
              super.getArmorModel(
                LivingBaseEntity.asForge(c.getEntityLiving()),
                asForge(c.getItemStack()),
                EquipmentSlot.asForge(c.getArmorSlot()),
                com.ldtteam.jvoxelizer.launcher.forge_1_12.client.model.ModelBiped.asForge(c.get_default())
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
    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new OnEntitySwingContext(LivingBaseEntity.fromForge(entityLiving), fromForge(stack)),
          pipeline.getOnEntitySwingPipeline(),
          (c) -> super.onEntitySwing(LivingBaseEntity.asForge(c.getEntityLiving()), asForge(c.getStack()))
        );
    }

    /**
     * Called when the client starts rendering the HUD, for whatever item the player currently has as a helmet.
     * This is where pumpkins would render there overlay.
     *
     * @param stack        The ItemStack that is equipped
     * @param player       Reference to the current client entity
     * @param resolution   Resolution information about the current viewport and configured GUI Scale
     * @param partialTicks Partial ticks for the renderer, useful for interpolation
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void renderHelmetOverlay(
      final ItemStack stack, final EntityPlayer player, final ScaledResolution resolution, final float partialTicks)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new RenderHelmetOverlayContext(fromForge(stack),
            PlayerEntity.fromForge(player),
            com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.ScaledResolution.fromForge(resolution),
            partialTicks),
          pipeline.getRenderHelmetOverlayPipeline(),
          (c) -> super.renderHelmetOverlay(asForge(c.getStack()),
            PlayerEntity.asForge(c.getPlayer()),
            com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.ScaledResolution.asForge(c.getResolution()),
            c.getPartialTicks())
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
          new GetDamageContext(fromForge(stack)),
          pipeline.getGetDamagePipeline(),
          (c) -> super.getDamage(asForge(c.getStack()))
        );
    }

    /**
     * This used to be 'display damage' but its really just 'aux' data in the ItemStack, usually shares the same variable as damage.
     */
    @Override
    public int getMetadata(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetMetadataWithStackAsItemStackContext(fromForge(stack)),
          pipeline.getGetMetadataWithStackAsItemStackPipeline(),
          (c) -> super.getMetadata(asForge(c.getStack()))
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
          new ShowDurabilityBarContext(fromForge(stack)),
          pipeline.getShowDurabilityBarPipeline(),
          (c) -> super.showDurabilityBar(asForge(c.getStack()))
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
          new GetDurabilityForDisplayContext(fromForge(stack)),
          pipeline.getGetDurabilityForDisplayPipeline(),
          (c) -> super.getDurabilityForDisplay(asForge(c.getStack()))
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
          new GetRGBDurabilityForDisplayContext(fromForge(stack)),
          pipeline.getGetRGBDurabilityForDisplayPipeline(),
          (c) -> super.getRGBDurabilityForDisplay(asForge(c.getStack()))
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
          new GetMaxDamageWithStackAsItemStackContext(fromForge(stack)),
          pipeline.getGetMaxDamageWithStackAsItemStackPipeline(),
          (c) -> super.getMaxDamage(asForge(c.getStack()))
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
          new IsDamagedContext(fromForge(stack)),
          pipeline.getIsDamagedPipeline(),
          (c) -> super.isDamaged(asForge(c.getStack()))
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
          new SetDamageContext(fromForge(stack), damage),
          pipeline.getSetDamagePipeline(),
          (c) -> super.setDamage(asForge(c.getStack()), c.getDamage())
        );
    }

    /**
     * Checked from {@link PlayerControllerMP#onPlayerDestroyBlock(BlockPos pos) PlayerControllerMP.onPlayerDestroyBlock()}
     * when a creative player left-clicks a block with this item.
     * Also checked from {@link ForgeHooks#onBlockBreakEvent(World, GameType, EntityPlayerMP, BlockPos)} ForgeHooks.onBlockBreakEvent()}
     * to prevent sending an event.
     *
     * @return true if the given player can destroy specified block in creative mode with this item
     */
    @Override
    public boolean canDestroyBlockInCreative(
      final World world, final BlockPos pos, final ItemStack stack, final EntityPlayer player)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new CanDestroyBlockInCreativeContext(
            Dimension.fromForge(world),
            BlockCoordinate.fromForge(pos),
            fromForge(stack),
            PlayerEntity.fromForge(player)
          ),
          pipeline.getCanDestroyBlockInCreativePipeline(),
          (c) -> super.canDestroyBlockInCreative(
            Dimension.asForge(c.getWorld()),
            BlockCoordinate.asForge(c.getPos()),
            asForge(c.getStack()),
            PlayerEntity.asForge(c.getPlayer())
          )
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
    public boolean canHarvestBlock(final IBlockState state, final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new CanHarvestBlockWithStateAsIBlockStateAndStackAsItemStackContext(BlockState.fromForge(state), fromForge(stack)),
          pipeline.getCanHarvestBlockWithStateAsIBlockStateAndStackAsItemStackPipeline(),
          (c) -> super.canHarvestBlock(BlockState.asForge(c.getState()), asForge(c.getStack()))
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
          new GetItemStackLimitWithStackAsItemStackContext(fromForge(stack)),
          pipeline.getGetItemStackLimitWithStackAsItemStackPipeline(),
          (c) -> super.getItemStackLimit(asForge(c.getStack()))
        );
    }

    /**
     * Sets or removes the harvest level for the specified tool class.
     *
     * @param toolClass Class
     * @param level     Harvest level:
     *                  Wood:    0
     *                  Stone:   1
     *                  Iron:    2
     *                  Diamond: 3
     */
    @Override
    public void setHarvestLevel(final String toolClass, final int level)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new SetHarvestLevelContext(toolClass, level),
          pipeline.getSetHarvestLevelPipeline(),
          (c) -> super.setHarvestLevel(c.getToolClass(), c.getLevel())
        );
    }

    @Override
    public Set<String> getToolClasses(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetToolClassesContext(fromForge(stack)),
          pipeline.getGetToolClassesPipeline(),
          (c) -> super.getToolClasses(asForge(c.getStack()))
        );
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
      final ItemStack stack, final String toolClass, @Nullable final EntityPlayer player, @Nullable final IBlockState blockState)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetHarvestLevelContext(fromForge(stack), toolClass, PlayerEntity.fromForge(player), BlockState.fromForge(blockState)),
          pipeline.getGetHarvestLevelPipeline(),
          (c) -> super.getHarvestLevel(asForge(c.getStack()), c.getToolClass(), PlayerEntity.asForge(c.getPlayer()), BlockState.asForge(c.getBlockState()))
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
          new GetItemEnchantabilityWithStackAsItemStackContext(fromForge(stack)),
          pipeline.getGetItemEnchantabilityWithStackAsItemStackPipeline(),
          (c) -> super.getItemEnchantability(asForge(c.getStack()))
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
          new CanApplyAtEnchantingTableContext(fromForge(stack), com.ldtteam.jvoxelizer.launcher.forge_1_12.enchantment.Enchantment.fromForge(enchantment)),
          pipeline.getCanApplyAtEnchantingTablePipeline(),
          (c) -> super.canApplyAtEnchantingTable(asForge(c.getStack()), com.ldtteam.jvoxelizer.launcher.forge_1_12.enchantment.Enchantment.asForge(c.getEnchantment()))
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
          new IsBeaconPaymentContext(fromForge(stack)),
          pipeline.getIsBeaconPaymentPipeline(),
          (c) -> super.isBeaconPayment(asForge(c.getStack()))
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
          new ShouldCauseReequipAnimationContext(fromForge(oldStack), fromForge(newStack), slotChanged),
          pipeline.getShouldCauseReequipAnimationPipeline(),
          (c) -> super.shouldCauseReequipAnimation(asForge(c.getOldStack()), asForge(c.getNewStack()), c.getSlotChanged())
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
          new ShouldCauseBlockBreakResetContext(fromForge(oldStack), fromForge(newStack)),
          pipeline.getShouldCauseBlockBreakResetPipeline(),
          (c) -> super.shouldCauseBlockBreakReset(asForge(c.getOldStack()), asForge(c.getNewStack()))
        );
    }

    /**
     * Called while an item is in 'active' use to determine if usage should continue.
     * Allows items to continue being used while sustaining damage, for example.
     *
     * @param oldStack the previous 'active' stack
     * @param newStack the stack currently in the active hand
     * @return true to set the new stack to active and continue using it
     */
    @Override
    public boolean canContinueUsing(final ItemStack oldStack, final ItemStack newStack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new CanContinueUsingContext(fromForge(oldStack), fromForge(newStack)),
          pipeline.getCanContinueUsingPipeline(),
          (c) -> super.canContinueUsing(asForge(c.getOldStack()), asForge(c.getNewStack()))
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
          new GetCreatorModIdContext(fromForge(itemStack)),
          pipeline.getGetCreatorModIdPipeline(),
          (c) -> super.getCreatorModId(asForge(c.getItemStack()))
        );
    }

    //TODO: Capability provider logic.

    @Override
    public ImmutableMap<String, ITimeValue> getAnimationParameters(
      final ItemStack stack, final World world, final EntityLivingBase entity)
    {
        return ImmutableMap.copyOf(PipelineProcessor.processTypedPipeline(
          this,
          new GetAnimationParametersContext(fromForge(stack), Dimension.fromForge(world), LivingBaseEntity.fromForge(entity)),
          pipeline.getGetAnimationParametersPipeline(),
          (c) -> ImmutableMap.copyOf(super.getAnimationParameters(
            asForge(c.getStack()),
            Dimension.asForge(c.getWorld()),
            LivingBaseEntity.asForge(c.getEntity())
          ).entrySet().stream().map(e -> new Tuple<>(e.getKey(), TimedValue.fromForge(e.getValue()))).collect(Collectors.toMap(Tuple::getFirst, Tuple::getSecond)))
        ).entrySet().stream().map(e -> new Tuple<>(e.getKey(), TimedValue.asForge(e.getValue()))).collect(Collectors.toMap(Tuple::getFirst, Tuple::getSecond)));
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
          new CanDisableShieldContext(fromForge(stack), fromForge(shield), LivingBaseEntity.fromForge(entity), LivingBaseEntity.fromForge(attacker)),
          pipeline.getCanDisableShieldPipeline(),
          (c) -> super.canDisableShield(
            asForge(c.getStack()),
            asForge(c.getShield()),
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
          new IsShieldContext(fromForge(stack), LivingBaseEntity.fromForge(entity)),
          pipeline.getIsShieldPipeline(),
          (c) -> super.isShield(asForge(c.getStack()), LivingBaseEntity.asForge(c.getEntity()))
        );
    }

    /**
     * @return the fuel burn time for this itemStack in a furnace.
     * Return 0 to make it not act as a fuel.
     * Return -1 to let the default vanilla logic decide.
     */
    @Override
    public int getItemBurnTime(final ItemStack itemStack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetItemBurnTimeContext(fromForge(itemStack)),
          pipeline.getGetItemBurnTimePipeline(),
          (c) -> super.getItemBurnTime(asForge(c.getItemStack()))
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
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.passive.HorseArmorType.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new GetHorseArmorTypeContext(fromForge(stack)),
            pipeline.getGetHorseArmorTypePipeline(),
            (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.passive.HorseArmorType.fromForge(
              super.getHorseArmorType(asForge(c.getStack()))
            )
          )
        );
    }

    @Override
    public String getHorseArmorTexture(final EntityLiving wearer, final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetHorseArmorTextureContext(LivingEntity.fromForge(wearer), fromForge(stack)),
          pipeline.getGetHorseArmorTexturePipeline(),
          (c) -> super.getHorseArmorTexture(LivingEntity.asForge(c.getWearer()), asForge(c.getStack()))
        );
    }

    /**
     * Called every tick from {@link EntityHorse#onUpdate()} on the item in the armor slot.
     *
     * @param world the world the horse is in
     * @param horse the horse wearing this armor
     * @param armor the armor itemstack
     */
    @Override
    public void onHorseArmorTick(final World world, final EntityLiving horse, final ItemStack armor)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new OnHorseArmorTickContext(Dimension.fromForge(world), LivingEntity.fromForge(horse), fromForge(armor)),
          pipeline.getOnHorseArmorTickPipeline(),
          (c) -> super.onHorseArmorTick(Dimension.asForge(c.getWorld()), LivingEntity.asForge(c.getHorse()), asForge(c.getArmor()))
        );
    }

    @Override
    public void setTileEntityItemStackRenderer(@Nullable final TileEntityItemStackRenderer teisr)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new SetTileEntityItemStackRendererContext(BlockEntityRenderer.fromForge(teisr)),
          pipeline.getSetTileEntityItemStackRendererPipeline(),
          (c) -> super.setTileEntityItemStackRenderer(BlockEntityRenderer.asForge(c.getTeisr()))
        );
    }

    @Override
    public ItemStack getDefaultInstance()
    {
        return asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new GetDefaultInstanceContext(),
            pipeline.getGetDefaultInstancePipeline(),
            (c) -> fromForge(super.getDefaultInstance())
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
    public IItem<I> setMaxItemStackSize(final int maxStackSize)
    {
        this.setMaxStackSize(maxStackSize);
        return this;
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
          asForge(stack),
          BlockState.asForge(state)
        );
    }

    @Override
    public IActionResult<IItemStack> onItemRightClick(
      final IDimension worldIn, final IPlayerEntity playerIn, final IHand handIn)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.util.actionresult.ActionResult.fromForge(
          this.onItemRightClick(
            Dimension.asForge(worldIn),
            PlayerEntity.asForge(playerIn),
            Hand.asForge(handIn)
          ),
          com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemStack::fromForge
        );
    }

    @Override
    public IItemStack onItemUseFinish(
      final IItemStack stack, final IDimension worldIn, final ILivingBaseEntity entityLiving)
    {
        return fromForge(this.onItemUseFinish(asForge(stack), Dimension.asForge(worldIn), LivingBaseEntity.asForge(entityLiving)));
    }

    @Override
    public IItem<I> setHasSubItems(final boolean hasSubtypes)
    {
        this.setHasSubtypes(hasSubtypes);
        return this;
    }

    @Override
    public IItem<I> setMaxSustainableDamage(final int maxDamageIn)
    {
        this.setMaxDamage(maxDamageIn);
        return this;
    }

    @Override
    public boolean hitEntity(
      final IItemStack stack, final ILivingBaseEntity target, final ILivingBaseEntity attacker)
    {
        return this.hitEntity(asForge(stack), LivingBaseEntity.asForge(target), LivingBaseEntity.asForge(attacker));
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
          asForge(stack),
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
          asForge(stack),
          PlayerEntity.asForge(playerIn),
          LivingBaseEntity.asForge(target),
          Hand.asForge(hand)
        );
    }

    @Override
    public IItem<I> setItemIsFull3D()
    {
        this.setFull3D();
        return this;
    }

    @Override
    public IItem<I> setUnlocalizedNameForItem(final String unlocalizedName)
    {
        this.setUnlocalizedName(unlocalizedName);
        return this;
    }

    @Override
    public String getUnlocalizedNameInefficiently(final IItemStack stack)
    {
        return this.getUnlocalizedNameInefficiently(asForge(stack));
    }

    @Override
    public String getUnlocalizedName(final IItemStack stack)
    {
        return this.getUnlocalizedName(asForge(stack));
    }

    @Override
    public IItem<I> setContainerItem(final IItem<I> containerItem)
    {
        this.setContainerItem(com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.asForge(containerItem));
        return this;
    }

    @Override
    public IItem<?> getRemainderItemAfterUse()
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.fromForge(this.getContainerItem());
    }

    @Override
    public void onUpdate(
      final IItemStack stack, final IDimension worldIn, final IEntity entityIn, final int itemSlot, final boolean isSelected)
    {
        this.onUpdate(asForge(stack), Dimension.asForge(worldIn), com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity.asForge(entityIn), itemSlot, isSelected);
    }

    @Override
    public void onCreated(
      final IItemStack stack, final IDimension worldIn, final IPlayerEntity playerIn)
    {
        this.onCreated(asForge(stack), Dimension.asForge(worldIn), PlayerEntity.asForge(playerIn));
    }

    @Override
    public IActionType getItemUseAction(final IItemStack stack)
    {
        return ActionType.fromForge(this.getItemUseAction(asForge(stack)));
    }

    @Override
    public int getMaxItemUseDuration(final IItemStack stack)
    {
        return getMaxItemUseDuration(asForge(stack));
    }

    @Override
    public void onPlayerStoppedUsing(
      final IItemStack stack, final IDimension worldIn, final ILivingBaseEntity entityLiving, final int timeLeft)
    {
        this.onPlayerStoppedUsing(asForge(stack), Dimension.asForge(worldIn), LivingBaseEntity.asForge(entityLiving), timeLeft);
    }

    @Override
    public void addInformation(
      final IItemStack stack, final IDimension worldIn, final List<String> tooltip, final IToolTipFlag flagIn)
    {
        this.addInformation(asForge(stack), Dimension.asForge(worldIn), tooltip, ToolTipFlag.asForge(flagIn));
    }

    @Override
    public String getItemStackDisplayName(final IItemStack stack)
    {
        return this.getItemStackDisplayName(asForge(stack));
    }

    @Override
    public boolean hasEffect(final IItemStack stack)
    {
        return this.hasEffect(asForge(stack));
    }

    @Override
    public IRarity getRarity(final IItemStack stack)
    {
        return Rarity.fromForge(this.getRarity(asForge(stack)));
    }

    @Override
    public boolean isEnchantable(final IItemStack stack)
    {
        return this.isEnchantable(asForge(stack));
    }

    @Override
    public void getSubItems(final IItemGroup<?> tab, final List<IItemStack> items)
    {
        final NonNullList<ItemStack> stacks = items.stream().map(i -> asForge(i)).collect(NonNullListCollector.toList());
        this.getSubItems(ItemGroup.asForge(tab), stacks);

        items.clear();
        items.addAll(stacks.stream().map(i -> fromForge(i)).collect(Collectors.toList()));
    }

    @Override
    public IItemGroup<?> getItemGroup()
    {
        return ItemGroup.fromForge(this.getCreativeTab());
    }

    @Override
    public IItem<I> setItemGroup(final IItemGroup<?> tab)
    {
        this.setCreativeTab(ItemGroup.asForge(tab));
        return this;
    }

    @Override
    public boolean getIsRepairable(final IItemStack toRepair, final IItemStack repair)
    {
        return this.getIsRepairable(asForge(toRepair), asForge(repair));
    }

    @Override
    public Multimap<String, IAttributeModifier> getItemAttributeModifiers(final IEquipmentSlot equipmentSlot)
    {
        return this.getItemAttributeModifiers(EquipmentSlot.asForge(equipmentSlot)).entries().stream().map(e -> new Tuple<>(e.getKey(),
          com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.ai.AttributeModifier.fromForge(e.getValue()))).collect(MultiMapCollector.toMultimap(Tuple::getFirst, Tuple::getSecond));
    }

    @Override
    public Multimap<String, IAttributeModifier> getAttributeModifiers(
      final IEquipmentSlot slot, final IItemStack stack)
    {
        return this.getAttributeModifiers(EquipmentSlot.asForge(slot), asForge(stack)).entries().stream().map(e -> new Tuple<>(e.getKey(),
          com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.ai.AttributeModifier.fromForge(e.getValue()))).collect(MultiMapCollector.toMultimap(Tuple::getFirst, Tuple::getSecond));
    }

    @Override
    public boolean onDroppedByPlayer(final IItemStack IItem, final IPlayerEntity player)
    {
        return this.onDroppedByPlayer(asForge(IItem), PlayerEntity.asForge(player));
    }

    @Override
    public String getHighlightTip(final IItemStack IItem, final String displayName)
    {
        return this.getHighlightTip(asForge(IItem), displayName);
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
            Facing.asForge(side),
            hitX,
            hitY,
            hitZ,
            Hand.asForge(hand)
          )
        );
    }

    @Override
    public IItem<I> disableRepair()
    {
        this.setNoRepair();
        return this;
    }

    @Override
    public float getXpRepairRatio(final IItemStack stack)
    {
        return this.getXpRepairRatio(asForge(stack));
    }

    @Override
    public INBTCompound getNBTShareTag(final IItemStack stack)
    {
        return NBTCompound.fromForge(this.getNBTShareTag(asForge(stack)));
    }

    @Override
    public void readNBTShareTag(final IItemStack stack, final INBTCompound nbt)
    {
        this.readNBTShareTag(asForge(stack), NBTCompound.asForge(nbt));
    }

    @Override
    public boolean onBlockStartBreak(
      final IItemStack IItemStack, final IBlockCoordinate pos, final IPlayerEntity player)
    {
        return this.onBlockStartBreak(asForge(IItemStack), BlockCoordinate.asForge(pos), PlayerEntity.asForge(player));
    }

    @Override
    public void onUsingTick(final IItemStack stack, final ILivingBaseEntity player, final int count)
    {
        this.onUsingTick(asForge(stack), LivingBaseEntity.asForge(player), count);
    }

    @Override
    public boolean onLeftClickEntity(
      final IItemStack stack, final IPlayerEntity player, final IEntity IEntity)
    {
        return this.onLeftClickEntity(
          asForge(stack),
          PlayerEntity.asForge(player),
          com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity.asForge(IEntity)
        );
    }

    @Override
    public IItemStack getRemainderItemAfterUse(final IItemStack IItemStack)
    {
        return fromForge(this.getContainerItem(asForge(IItemStack)));
    }

    @Override
    public boolean hasContainerItem(final IItemStack stack)
    {
        return this.hasContainerItem(asForge(stack));
    }

    @Override
    public int getEntityLifespan(final IItemStack IItemStack, final IDimension IDimension)
    {
        return this.getEntityLifespan(asForge(IItemStack), Dimension.asForge(IDimension));
    }

    @Override
    public boolean hasCustomEntity(final IItemStack stack)
    {
        return this.hasCustomEntity(asForge(stack));
    }

    @Override
    public IEntity createEntity(
      final IDimension IDimension, final IEntity location, final IItemStack IItemStack)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity.fromForge(this.createEntity(Dimension.asForge(IDimension),
          com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity.asForge(location), asForge(IItemStack)));
    }

    @Override
    public boolean onEntityItemUpdate(final IItemStackEntity entityItem)
    {
        return this.onEntityItemUpdate(ItemStackEntity.asForge(entityItem));
    }

    @Override
    public IItemGroup<?>[] getItemGroups()
    {
        return Arrays.stream(this.getCreativeTabs()).map(ItemGroup::fromForge).toArray(IItemGroup<?>[]::new);
    }

    @Override
    public float getSmeltingExperience(final IItemStack IItem)
    {
        return this.getSmeltingExperience(asForge(IItem));
    }

    @Override
    public boolean doesSneakBypassUse(
      final IItemStack stack, final IDimension world, final IBlockCoordinate pos, final IPlayerEntity player)
    {
        return this.doesSneakBypassUse(asForge(stack), Dimension.asForge(world), BlockCoordinate.asForge(pos), PlayerEntity.asForge(player));
    }

    @Override
    public void onArmorTick(
      final IDimension IDimension, final IPlayerEntity player, final IItemStack IItemStack)
    {
        this.onArmorTick(Dimension.asForge(IDimension), PlayerEntity.asForge(player), asForge(IItemStack));
    }

    @Override
    public boolean isValidArmor(
      final IItemStack stack, final IEquipmentSlot armorType, final IEntity IEntity)
    {
        return this.isValidArmor(asForge(stack), EquipmentSlot.asForge(armorType), com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity.asForge(IEntity));
    }

    @Override
    public IEquipmentSlot getEquipmentSlot(final IItemStack stack)
    {
        return EquipmentSlot.fromForge(this.getEquipmentSlot(asForge(stack)));
    }

    @Override
    public boolean isBookEnchantable(final IItemStack stack, final IItemStack book)
    {
        return this.isBookEnchantable(asForge(stack), asForge(book));
    }

    @Override
    public String getArmorTexture(
      final IItemStack stack, final IEntity IEntity, final IEquipmentSlot slot, final String type)
    {
        return this.getArmorTexture(asForge(stack), com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity.asForge(IEntity), EquipmentSlot.asForge(slot), type);
    }

    @Override
    public IFontRenderer getFontRenderer(final IItemStack stack)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.font.FontRenderer.fromForge(this.getFontRenderer(asForge(stack)));
    }

    @Override
    public IModelBiped getArmorModel(
      final ILivingBaseEntity entityLiving, final IItemStack IItemStack, final IEquipmentSlot armorSlot, final IModelBiped _default)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.client.model.ModelBiped.fromForge(
          this.getArmorModel(
            LivingBaseEntity.asForge(entityLiving),
            asForge(IItemStack),
            EquipmentSlot.asForge(armorSlot),
            com.ldtteam.jvoxelizer.launcher.forge_1_12.client.model.ModelBiped.asForge(_default)
          )
        );
    }

    @Override
    public boolean onEntitySwing(final ILivingBaseEntity entityLiving, final IItemStack stack)
    {
        return this.onEntitySwing(LivingBaseEntity.asForge(entityLiving), asForge(stack));
    }

    @Override
    public void renderHelmetOverlay(
      final IItemStack stack, final IPlayerEntity player, final IScaledResolution resolution, final float partialTicks)
    {
        this.renderHelmetOverlay(asForge(stack),
          PlayerEntity.asForge(player),
          com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui.ScaledResolution.asForge(resolution),
          partialTicks);
    }

    @Override
    public int getDamage(final IItemStack stack)
    {
        return this.getDamage(asForge(stack));
    }

    @Override
    public int getMetadata(final IItemStack stack)
    {
        return this.getMetadata(asForge(stack));
    }

    @Override
    public boolean showDurabilityBar(final IItemStack stack)
    {
        return this.showDurabilityBar(asForge(stack));
    }

    @Override
    public double getDurabilityForDisplay(final IItemStack stack)
    {
        return this.getDurabilityForDisplay(asForge(stack));
    }

    @Override
    public int getRGBDurabilityForDisplay(final IItemStack stack)
    {
        return this.getRGBDurabilityForDisplay(asForge(stack));
    }

    @Override
    public int getMaxDamage(final IItemStack stack)
    {
        return this.getMaxDamage(asForge(stack));
    }

    @Override
    public boolean isDamaged(final IItemStack stack)
    {
        return this.isDamaged(asForge(stack));
    }

    @Override
    public void setDamage(final IItemStack stack, final int damage)
    {
        this.setDamage(asForge(stack), damage);
    }

    @Override
    public boolean canDestroyBlockInCreative(
      final IDimension IDimension, final IBlockCoordinate pos, final IItemStack stack, final IPlayerEntity player)
    {
        return this.canDestroyBlockInCreative(Dimension.asForge(IDimension), BlockCoordinate.asForge(pos), asForge(stack), PlayerEntity.asForge(player));
    }

    @Override
    public boolean canHarvestBlock(final com.ldtteam.jvoxelizer.block.state.IBlockState state, final IItemStack stack)
    {
        return this.canHarvestBlock(BlockState.asForge(state), asForge(stack));
    }

    @Override
    public int getItemStackLimit(final IItemStack stack)
    {
        return this.getItemStackLimit(asForge(stack));
    }

    @Override
    public Set<String> getToolClasses(final IItemStack stack)
    {
        return this.getToolClasses(asForge(stack));
    }

    @Override
    public int getHarvestLevel(
      final IItemStack stack, final String toolClass, final IPlayerEntity player, final com.ldtteam.jvoxelizer.block.state.IBlockState blockState)
    {
        return this.getHarvestLevel(asForge(stack), toolClass, PlayerEntity.asForge(player), BlockState.asForge(blockState));
    }

    @Override
    public int getItemEnchantability(final IItemStack stack)
    {
        return this.getItemEnchantability(asForge(stack));
    }

    @Override
    public boolean canApplyAtEnchantingTable(final IItemStack stack, final IEnchantment enchantment)
    {
        return this.canApplyAtEnchantingTable(asForge(stack), com.ldtteam.jvoxelizer.launcher.forge_1_12.enchantment.Enchantment.asForge(enchantment));
    }

    @Override
    public boolean isBeaconPayment(final IItemStack stack)
    {
        return this.isBeaconPayment(asForge(stack));
    }

    @Override
    public boolean shouldCauseReequipAnimation(final IItemStack oldStack, final IItemStack newStack, final boolean slotChanged)
    {
        return this.shouldCauseReequipAnimation(asForge(oldStack), asForge(newStack), slotChanged);
    }

    @Override
    public boolean shouldCauseBlockBreakReset(final IItemStack oldStack, final IItemStack newStack)
    {
        return this.shouldCauseBlockBreakReset(asForge(oldStack), asForge(newStack));
    }

    @Override
    public boolean canContinueUsing(final IItemStack oldStack, final IItemStack newStack)
    {
        return this.canContinueUsing(asForge(oldStack), asForge(newStack));
    }

    @Override
    public String getCreatorModId(final IItemStack IItemStack)
    {
        return this.getCreatorModId(asForge(IItemStack));
    }

    @Override
    public ImmutableMap<String, ITimedValue> getAnimationParameters(
      final IItemStack stack, final IDimension IDimension, final ILivingBaseEntity IEntity)
    {
        return ImmutableMap.copyOf(
          this.getAnimationParameters(
            asForge(stack),
            Dimension.asForge(IDimension),
            LivingBaseEntity.asForge(IEntity)
          ).entrySet().stream().map(e -> new Tuple<>(e.getKey(), TimedValue.fromForge(e.getValue()))).collect(Collectors.toMap(Tuple::getFirst, Tuple::getSecond))
        );
    }

    @Override
    public boolean canDisableShield(
      final IItemStack stack, final IItemStack shield, final ILivingBaseEntity IEntity, final ILivingBaseEntity attacker)
    {
        return this.canDisableShield(asForge(stack), asForge(shield), LivingBaseEntity.asForge(IEntity), LivingBaseEntity.asForge(attacker));
    }

    @Override
    public boolean isShield(final IItemStack stack, final ILivingBaseEntity IEntity)
    {
        return this.isShield(asForge(stack), LivingBaseEntity.asForge(IEntity));
    }

    @Override
    public int getItemBurnTime(final IItemStack IItemStack)
    {
        return this.getItemBurnTime(asForge(IItemStack));
    }

    @Override
    public IHorseArmorType getHorseArmorType(final IItemStack stack)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.passive.HorseArmorType.fromForge(this.getHorseArmorType(asForge(stack)));
    }

    @Override
    public String getHorseArmorTexture(final ILivingEntity wearer, final IItemStack stack)
    {
        return this.getHorseArmorTexture(LivingEntity.asForge(wearer), asForge(stack));
    }

    @Override
    public void onHorseArmorTick(
      final IDimension IDimension, final ILivingEntity horse, final IItemStack armor)
    {
        this.onHorseArmorTick(Dimension.asForge(IDimension), LivingEntity.asForge(horse), asForge(armor));
    }

    @Override
    public IBlockEntityRenderer getBlockEntityItemStackRenderer()
    {
        return BlockEntityRenderer.fromForge(this.getTileEntityItemStackRenderer());
    }

    @Override
    public void setBlockEntityItemStackRenderer(final IBlockEntityRenderer teisr)
    {
        this.setTileEntityItemStackRenderer(BlockEntityRenderer.asForge(teisr));
    }

    @Override
    public IItemStack createDefaultItemStack()
    {
        return fromForge(this.getDefaultInstance());
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
}
