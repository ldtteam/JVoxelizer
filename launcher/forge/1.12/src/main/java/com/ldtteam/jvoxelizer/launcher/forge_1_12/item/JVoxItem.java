package com.ldtteam.jvoxelizer.launcher.forge_1_12.item;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
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
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.group.IItemGroup;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.logic.pipeline.ForgeItemPipeline;
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
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;

public class JVoxItem<I> extends Item implements IItem<I>
{
    private final I instanceData;
    private final ForgeItemPipeline<IItem<I>, I> pipeline;

    public JVoxItem(final I instanceData, final ForgeItemPipeline<IItem<I>, I> pipeline) {
        this.instanceData = instanceData;
        this.pipeline = pipeline;
    }

    //////////////////////////////////////////////////////////////
    /// Raycoms: Implement pipeline processing from here down
    //////////////////////////////////////////////////////////////

    @Nullable
    @Override
    public IItemPropertyGetter getPropertyGetter(final ResourceLocation key)
    {
        return super.getPropertyGetter(key);
    }

    /**
     * Called when an ItemStack with NBT data is read to potentially that ItemStack's NBT data
     */
    @Override
    public boolean updateItemStackNBT(final NBTTagCompound nbt)
    {
        return super.updateItemStackNBT(nbt);
    }

    @Override
    public boolean hasCustomProperties()
    {
        return super.hasCustomProperties();
    }

    @Override
    public Item setMaxStackSize(final int maxStackSize)
    {
        return super.setMaxStackSize(maxStackSize);
    }

    /**
     * Called when a Block is right-clicked with this Item
     */
    @Override
    public EnumActionResult onItemUse(
      final EntityPlayer player, final World worldIn, final BlockPos pos, final EnumHand hand, final EnumFacing facing, final float hitX, final float hitY, final float hitZ)
    {
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public float getDestroySpeed(final ItemStack stack, final IBlockState state)
    {
        return super.getDestroySpeed(stack, state);
    }

    /**
     * Called when the equipped item is right clicked.
     */
    @Override
    public ActionResult<ItemStack> onItemRightClick(
      final World worldIn, final EntityPlayer playerIn, final EnumHand handIn)
    {
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    @Override
    public ItemStack onItemUseFinish(final ItemStack stack, final World worldIn, final EntityLivingBase entityLiving)
    {
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }

    /**
     * Returns the maximum size of the stack for a specific item. *Isn't this more a Set than a Get?*
     */
    @Override
    public int getItemStackLimit()
    {
        return super.getItemStackLimit();
    }

    /**
     * Converts the given ItemStack damage value into a metadata value to be placed in the world when this Item is
     * placed as a Block (mostly used with ItemBlocks).
     */
    @Override
    public int getMetadata(final int damage)
    {
        return super.getMetadata(damage);
    }

    @Override
    public boolean getHasSubtypes()
    {
        return super.getHasSubtypes();
    }

    @Override
    public Item setHasSubtypes(final boolean hasSubtypes)
    {
        return super.setHasSubtypes(hasSubtypes);
    }

    /**
     * Returns the maximum damage an item can take.
     */
    @Override
    public int getMaxDamage()
    {
        return super.getMaxDamage();
    }

    /**
     * set max damage of an Item
     */
    @Override
    public Item setMaxDamage(final int maxDamageIn)
    {
        return super.setMaxDamage(maxDamageIn);
    }

    @Override
    public boolean isDamageable()
    {
        return super.isDamageable();
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    @Override
    public boolean hitEntity(final ItemStack stack, final EntityLivingBase target, final EntityLivingBase attacker)
    {
        return super.hitEntity(stack, target, attacker);
    }

    /**
     * Called when a Block is destroyed using this Item. Return true to trigger the "Use Item" statistic.
     */
    @Override
    public boolean onBlockDestroyed(
      final ItemStack stack, final World worldIn, final IBlockState state, final BlockPos pos, final EntityLivingBase entityLiving)
    {
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }

    /**
     * Check whether this Item can harvest the given Block
     */
    @Override
    public boolean canHarvestBlock(final IBlockState blockIn)
    {
        return super.canHarvestBlock(blockIn);
    }

    /**
     * Returns true if the item can be used on the given entity, e.g. shears on sheep.
     */
    @Override
    public boolean itemInteractionForEntity(
      final ItemStack stack, final EntityPlayer playerIn, final EntityLivingBase target, final EnumHand hand)
    {
        return super.itemInteractionForEntity(stack, playerIn, target, hand);
    }

    /**
     * Sets bFull3D to True and return the object.
     */
    @Override
    public Item setFull3D()
    {
        return super.setFull3D();
    }

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    @Override
    public boolean isFull3D()
    {
        return super.isFull3D();
    }

    /**
     * Returns true if this item should be rotated by 180 degrees around the Y axis when being held in an entities
     * hands.
     */
    @Override
    public boolean shouldRotateAroundWhenRendering()
    {
        return super.shouldRotateAroundWhenRendering();
    }

    /**
     * Sets the unlocalized name of this item to the string passed as the parameter, prefixed by "item."
     */
    @Override
    public Item setUnlocalizedName(final String unlocalizedName)
    {
        return super.setUnlocalizedName(unlocalizedName);
    }

    /**
     * Translates the unlocalized name of this item, but without the .name suffix, so the translation fails and the
     * unlocalized name itself is returned.
     */
    @Override
    public String getUnlocalizedNameInefficiently(final ItemStack stack)
    {
        return super.getUnlocalizedNameInefficiently(stack);
    }

    /**
     * Returns the unlocalized name of this item.
     */
    @Override
    public String getUnlocalizedName()
    {
        return super.getUnlocalizedName();
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    @Override
    public String getUnlocalizedName(final ItemStack stack)
    {
        return super.getUnlocalizedName(stack);
    }

    @Override
    public Item setContainerItem(final Item containerItem)
    {
        return super.setContainerItem(containerItem);
    }

    /**
     * If this function returns true (or the item is damageable), the ItemStack's NBT tag will be sent to the client.
     */
    @Override
    public boolean getShareTag()
    {
        return super.getShareTag();
    }

    @Nullable
    @Override
    public Item getContainerItem()
    {
        return super.getContainerItem();
    }

    /**
     * True if this Item has a container item (a.k.a. crafting result)
     */
    @Override
    public boolean hasContainerItem()
    {
        return super.hasContainerItem();
    }

    /**
     * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
     * update it's contents.
     */
    @Override
    public void onUpdate(final ItemStack stack, final World worldIn, final Entity entityIn, final int itemSlot, final boolean isSelected)
    {
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    /**
     * Called when item is crafted/smelted. Used only by maps so far.
     */
    @Override
    public void onCreated(final ItemStack stack, final World worldIn, final EntityPlayer playerIn)
    {
        super.onCreated(stack, worldIn, playerIn);
    }

    /**
     * false for all Items except sub-classes of ItemMapBase
     */
    @Override
    public boolean isMap()
    {
        return super.isMap();
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    @Override
    public EnumAction getItemUseAction(final ItemStack stack)
    {
        return super.getItemUseAction(stack);
    }

    /**
     * How long it takes to use or consume an item
     */
    @Override
    public int getMaxItemUseDuration(final ItemStack stack)
    {
        return super.getMaxItemUseDuration(stack);
    }

    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
    @Override
    public void onPlayerStoppedUsing(final ItemStack stack, final World worldIn, final EntityLivingBase entityLiving, final int timeLeft)
    {
        super.onPlayerStoppedUsing(stack, worldIn, entityLiving, timeLeft);
    }

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    @Override
    public void addInformation(
      final ItemStack stack, @Nullable final World worldIn, final List<String> tooltip, final ITooltipFlag flagIn)
    {
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public String getItemStackDisplayName(final ItemStack stack)
    {
        return super.getItemStackDisplayName(stack);
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
        return super.hasEffect(stack);
    }

    /**
     * Return an item rarity from EnumRarity
     */
    @Override
    public EnumRarity getRarity(final ItemStack stack)
    {
        return super.getRarity(stack);
    }

    /**
     * Checks isDamagable and if it cannot be stacked
     */
    @Override
    public boolean isEnchantable(final ItemStack stack)
    {
        return super.isEnchantable(stack);
    }

    @Override
    protected RayTraceResult rayTrace(final World worldIn, final EntityPlayer playerIn, final boolean useLiquids)
    {
        return super.rayTrace(worldIn, playerIn, useLiquids);
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    @Override
    public int getItemEnchantability()
    {
        return super.getItemEnchantability();
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @Override
    public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> items)
    {
        super.getSubItems(tab, items);
    }

    @Override
    protected boolean isInCreativeTab(final CreativeTabs targetTab)
    {
        return super.isInCreativeTab(targetTab);
    }

    /**
     * gets the CreativeTab this item is displayed on
     */
    @Nullable
    @Override
    public CreativeTabs getCreativeTab()
    {
        return super.getCreativeTab();
    }

    /**
     * returns this;
     */
    @Override
    public Item setCreativeTab(final CreativeTabs tab)
    {
        return super.setCreativeTab(tab);
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
        return super.canItemEditBlocks();
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
        return super.getIsRepairable(toRepair, repair);
    }

    /**
     * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
     */
    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(final EntityEquipmentSlot equipmentSlot)
    {
        return super.getItemAttributeModifiers(equipmentSlot);
    }

    /**
     * ItemStack sensitive version of getItemAttributeModifiers
     */
    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(
      final EntityEquipmentSlot slot, final ItemStack stack)
    {
        return super.getAttributeModifiers(slot, stack);
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
        return super.onDroppedByPlayer(item, player);
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
        return super.getHighlightTip(item, displayName);
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
        return super.onItemUseFirst(player, world, pos, side, hitX, hitY, hitZ, hand);
    }

    /**
     * Called by CraftingManager to determine if an item is reparable.
     *
     * @return True if reparable
     */
    @Override
    public boolean isRepairable()
    {
        return super.isRepairable();
    }

    /**
     * Call to disable repair recipes.
     *
     * @return The current Item instance
     */
    @Override
    public Item setNoRepair()
    {
        return super.setNoRepair();
    }

    /**
     * Determines the amount of durability the mending enchantment
     * will repair, on average, per point of experience.
     */
    @Override
    public float getXpRepairRatio(final ItemStack stack)
    {
        return super.getXpRepairRatio(stack);
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
        return super.getNBTShareTag(stack);
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
        super.readNBTShareTag(stack, nbt);
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
        return super.onBlockStartBreak(itemstack, pos, player);
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
        super.onUsingTick(stack, player, count);
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
        return super.onLeftClickEntity(stack, player, entity);
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
        return super.getContainerItem(itemStack);
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
        return super.hasContainerItem(stack);
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
        return super.getEntityLifespan(itemStack, world);
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
        return super.hasCustomEntity(stack);
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
        return super.createEntity(world, location, itemstack);
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
        return super.onEntityItemUpdate(entityItem);
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
        return super.getCreativeTabs();
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
        return super.getSmeltingExperience(item);
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
        return super.doesSneakBypassUse(stack, world, pos, player);
    }

    /**
     * Called to tick armor in the armor slot. Override to do something
     */
    @Override
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack)
    {
        super.onArmorTick(world, player, itemStack);
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
        return super.isValidArmor(stack, armorType, entity);
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
        return super.getEquipmentSlot(stack);
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
        return super.isBookEnchantable(stack, book);
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
        return super.getArmorTexture(stack, entity, slot, type);
    }

    /**
     * Returns the font renderer used to render tooltips and overlays for this item.
     * Returning null will use the standard font renderer.
     *
     * @param stack The current item stack
     * @return A instance of FontRenderer or null to use default
     */
    @Nullable
    @Override
    public FontRenderer getFontRenderer(final ItemStack stack)
    {
        return super.getFontRenderer(stack);
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
    @Nullable
    @Override
    public ModelBiped getArmorModel(
      final EntityLivingBase entityLiving, final ItemStack itemStack, final EntityEquipmentSlot armorSlot, final ModelBiped _default)
    {
        return super.getArmorModel(entityLiving, itemStack, armorSlot, _default);
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
        return super.onEntitySwing(entityLiving, stack);
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
    @Override
    public void renderHelmetOverlay(
      final ItemStack stack, final EntityPlayer player, final ScaledResolution resolution, final float partialTicks)
    {
        super.renderHelmetOverlay(stack, player, resolution, partialTicks);
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
        return super.getDamage(stack);
    }

    /**
     * This used to be 'display damage' but its really just 'aux' data in the ItemStack, usually shares the same variable as damage.
     */
    @Override
    public int getMetadata(final ItemStack stack)
    {
        return super.getMetadata(stack);
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
        return super.showDurabilityBar(stack);
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
        return super.getDurabilityForDisplay(stack);
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
        return super.getRGBDurabilityForDisplay(stack);
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
        return super.getMaxDamage(stack);
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
        return super.isDamaged(stack);
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
        super.setDamage(stack, damage);
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
        return super.canDestroyBlockInCreative(world, pos, stack, player);
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
        return super.canHarvestBlock(state, stack);
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
        return super.getItemStackLimit(stack);
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
        super.setHarvestLevel(toolClass, level);
    }

    @Override
    public Set<String> getToolClasses(final ItemStack stack)
    {
        return super.getToolClasses(stack);
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
        return super.getHarvestLevel(stack, toolClass, player, blockState);
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
        return super.getItemEnchantability(stack);
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
        return super.canApplyAtEnchantingTable(stack, enchantment);
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
        return super.isBeaconPayment(stack);
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
        return super.shouldCauseReequipAnimation(oldStack, newStack, slotChanged);
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
        return super.shouldCauseBlockBreakReset(oldStack, newStack);
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
        return super.canContinueUsing(oldStack, newStack);
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
        return super.getCreatorModId(itemStack);
    }

    /**
     * Called from ItemStack.setItem, will hold extra data for the life of this ItemStack.
     * Can be retrieved from stack.getCapabilities()
     * The NBT can be null if this is not called from readNBT or if the item the stack is
     * changing FROM is different then this item, or the previous item had no capabilities.
     * <p>
     * This is called BEFORE the stacks item is set so you can use stack.getItem() to see the OLD item.
     * Remember that getItem CAN return null.
     *
     * @param stack The ItemStack
     * @param nbt   NBT of this item serialized, or null.
     * @return A holder instance associated with this ItemStack where you can hold capabilities for the life of this item.
     */
    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(
      final ItemStack stack, @Nullable final NBTTagCompound nbt)
    {
        return super.initCapabilities(stack, nbt);
    }

    @Override
    public ImmutableMap<String, ITimeValue> getAnimationParameters(
      final ItemStack stack, final World world, final EntityLivingBase entity)
    {
        return super.getAnimationParameters(stack, world, entity);
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
        return super.canDisableShield(stack, shield, entity, attacker);
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
        return super.isShield(stack, entity);
    }

    /**
     * @return the fuel burn time for this itemStack in a furnace.
     * Return 0 to make it not act as a fuel.
     * Return -1 to let the default vanilla logic decide.
     */
    @Override
    public int getItemBurnTime(final ItemStack itemStack)
    {
        return super.getItemBurnTime(itemStack);
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
        return super.getHorseArmorType(stack);
    }

    @Override
    public String getHorseArmorTexture(final EntityLiving wearer, final ItemStack stack)
    {
        return super.getHorseArmorTexture(wearer, stack);
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
        super.onHorseArmorTick(world, horse, armor);
    }



    @Override
    public void setTileEntityItemStackRenderer(@Nullable final TileEntityItemStackRenderer teisr)
    {
        super.setTileEntityItemStackRenderer(teisr);
    }

    @Override
    public ItemStack getDefaultInstance()
    {
        return super.getDefaultInstance();
    }




    //////////////////////////////////////////////////////////////
    /// Raycoms: Implement pipeline processing up until here
    //////////////////////////////////////////////////////////////


    //////////////////////////////////////////////////////////////
    /// Raycoms: Implement JVox to Forge conversion from here down
    //////////////////////////////////////////////////////////////

    @Override
    public void addPropertyOverride(final IIdentifier key, final com.ldtteam.jvoxelizer.item.IItemPropertyGetter getter)
    {

    }

    @Override
    public com.ldtteam.jvoxelizer.item.IItemPropertyGetter getPropertyGetter(final IIdentifier key)
    {
        return null;
    }

    @Override
    public boolean updateItemStackNBT(final INBTCompound nbt)
    {
        return false;
    }

    @Override
    public IItem<I> setMaxItemStackSize(final int maxStackSize)
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
    public float getDestroySpeed(final IItemStack stack, final com.ldtteam.jvoxelizer.block.state.IBlockState state)
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
    public IItemStack onItemUseFinish(
      final IItemStack stack, final IDimension worldIn, final ILivingBaseEntity entityLiving)
    {
        return null;
    }

    @Override
    public IItem<I> setHasSubItems(final boolean hasSubtypes)
    {
        return null;
    }

    @Override
    public IItem<I> setMaxSustainableDamage(final int maxDamageIn)
    {
        return null;
    }

    @Override
    public boolean hitEntity(
      final IItemStack stack, final ILivingBaseEntity target, final ILivingBaseEntity attacker)
    {
        return false;
    }

    @Override
    public boolean onBlockDestroyed(
      final IItemStack stack,
      final IDimension worldIn,
      final com.ldtteam.jvoxelizer.block.state.IBlockState state,
      final IBlockCoordinate pos,
      final ILivingBaseEntity entityLiving)
    {
        return false;
    }

    @Override
    public boolean canHarvestBlock(final com.ldtteam.jvoxelizer.block.state.IBlockState blockIn)
    {
        return false;
    }

    @Override
    public boolean itemInteractionForEntity(
      final IItemStack stack, final IPlayerEntity playerIn, final ILivingBaseEntity target, final IHand hand)
    {
        return false;
    }

    @Override
    public IItem<I> setItemIsFull3D()
    {
        return null;
    }

    @Override
    public IItem<I> setUnlocalizedNameForItem(final String unlocalizedName)
    {
        return null;
    }

    @Override
    public String getUnlocalizedNameInefficiently(final IItemStack stack)
    {
        return null;
    }

    @Override
    public String getUnlocalizedName(final IItemStack stack)
    {
        return null;
    }

    @Override
    public IItem<I> setContainerItem(final IItem<I> containerItem)
    {
        return null;
    }

    @Override
    public IItem<I> getRemainderItemAfterUse()
    {
        return null;
    }

    @Override
    public void onUpdate(
      final IItemStack stack, final IDimension worldIn, final IEntity entityIn, final int itemSlot, final boolean isSelected)
    {

    }

    @Override
    public void onCreated(
      final IItemStack stack, final IDimension worldIn, final IPlayerEntity playerIn)
    {

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
    public void onPlayerStoppedUsing(
      final IItemStack stack, final IDimension worldIn, final ILivingBaseEntity entityLiving, final int timeLeft)
    {

    }

    @Override
    public void addInformation(
      final IItemStack stack, final IDimension worldIn, final List<String> tooltip, final IToolTipFlag flagIn)
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
    public void getSubItems(final IItemGroup<?> tab, final List<IItemStack> items)
    {

    }

    @Override
    public IItemGroup<?> getItemGroup()
    {
        return null;
    }

    @Override
    public IItem<I> setItemGroup(final IItemGroup<?> tab)
    {
        return null;
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
    public Multimap<String, IAttributeModifier> getAttributeModifiers(
      final IEquipmentSlot slot, final IItemStack stack)
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
        return null;
    }

    @Override
    public IItem<I> disableRepair()
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
    public boolean onBlockStartBreak(
      final IItemStack IItemStack, final IBlockCoordinate pos, final IPlayerEntity player)
    {
        return false;
    }

    @Override
    public void onUsingTick(final IItemStack stack, final ILivingBaseEntity player, final int count)
    {

    }

    @Override
    public boolean onLeftClickEntity(
      final IItemStack stack, final IPlayerEntity player, final IEntity IEntity)
    {
        return false;
    }

    @Override
    public IItemStack getRemainderItemAfterUse(final IItemStack IItemStack)
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
    public IEntity createEntity(
      final IDimension IDimension, final IEntity location, final IItemStack IItemStack)
    {
        return null;
    }

    @Override
    public boolean onEntityItemUpdate(final IItemStackEntity entityItem)
    {
        return false;
    }

    @Override
    public IItemGroup<?>[] getItemGroups()
    {
        return new IItemGroup[0];
    }

    @Override
    public float getSmeltingExperience(final IItemStack IItem)
    {
        return 0;
    }

    @Override
    public boolean doesSneakBypassUse(
      final IItemStack stack, final IDimension world, final IBlockCoordinate pos, final IPlayerEntity player)
    {
        return false;
    }

    @Override
    public void onArmorTick(
      final IDimension IDimension, final IPlayerEntity player, final IItemStack IItemStack)
    {

    }

    @Override
    public boolean isValidArmor(
      final IItemStack stack, final IEquipmentSlot armorType, final IEntity IEntity)
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
    public String getArmorTexture(
      final IItemStack stack, final IEntity IEntity, final IEquipmentSlot slot, final String type)
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
    public void renderHelmetOverlay(
      final IItemStack stack, final IPlayerEntity player, final IScaledResolution resolution, final float partialTicks)
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
    public boolean canDestroyBlockInCreative(
      final IDimension IDimension, final IBlockCoordinate pos, final IItemStack stack, final IPlayerEntity player)
    {
        return false;
    }

    @Override
    public boolean canHarvestBlock(final com.ldtteam.jvoxelizer.block.state.IBlockState state, final IItemStack stack)
    {
        return false;
    }

    @Override
    public int getItemStackLimit(final IItemStack stack)
    {
        return 0;
    }

    @Override
    public Set<String> getToolClasses(final IItemStack stack)
    {
        return null;
    }

    @Override
    public int getHarvestLevel(
      final IItemStack stack, final String toolClass, final IPlayerEntity player, final com.ldtteam.jvoxelizer.block.state.IBlockState blockState)
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
    public ImmutableMap<String, ITimedValue> getAnimationParameters(
      final IItemStack stack, final IDimension IDimension, final ILivingBaseEntity IEntity)
    {
        return null;
    }

    @Override
    public boolean canDisableShield(
      final IItemStack stack, final IItemStack shield, final ILivingBaseEntity IEntity, final ILivingBaseEntity attacker)
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
    public void onHorseArmorTick(
      final IDimension IDimension, final ILivingEntity horse, final IItemStack armor)
    {

    }

    @Override
    public IBlockEntityRenderer getBlockEntityItemStackRenderer()
    {
        return null;
    }

    @Override
    public void setBlockEntityItemStackRenderer(final IBlockEntityRenderer teisr)
    {

    }

    @Override
    public IItemStack createDefaultItemStack()
    {
        return null;
    }

    @Override
    public String getTranslationKey(final IItemStack pItemStack1)
    {
        return null;
    }

    @Override
    public I getInstanceData()
    {
        return null;
    }

    @Override
    public IItem<I> setRegistryIdentifier(final IIdentifier name)
    {
        return null;
    }

    @Override
    public IIdentifier getRegistryIdentifier()
    {
        return null;
    }

    @Override
    public Class getTypeUsedForRegistration()
    {
        return IItem.class;
    }

    //////////////////////////////////////////////////////////////
    /// Raycoms: Implement JVox to Forge conversion up until here.
    //////////////////////////////////////////////////////////////
}
