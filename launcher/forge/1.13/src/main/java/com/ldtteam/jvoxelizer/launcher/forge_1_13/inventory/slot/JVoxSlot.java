package com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot;

import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.core.logic.PipelineProcessor;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.inventory.slot.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.handling.IInventory;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.texture.Sprite;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.texture.SpriteMap;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.living.player.PlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.logic.pipeline.ForgeSlotPipeline;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.identifier.Identifier;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

import static com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.Inventory.asForge;
import static com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.Inventory.fromForge;

public class JVoxSlot<I> extends Slot implements ISlot<I>
{
    private final I                              instanceData;
    private final ForgeSlotPipeline<ISlot<I>, I> pipeline;

    public JVoxSlot(
      final net.minecraft.inventory.IInventory inventoryIn,
      final int index,
      final int xPosition,
      final int yPosition,
      final I instanceData,
      final ForgeSlotPipeline<ISlot<I>, I> pipeline)
    {
        super(inventoryIn, index, xPosition, yPosition);
        this.instanceData = instanceData;
        this.pipeline = pipeline;
    }

    @Override
    public void onSlotChange(final ItemStack p_75220_1_, final ItemStack p_75220_2_)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new OnSlotChangeContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(p_75220_1_), com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(p_75220_2_)),
          pipeline.getOnSlotChangePipeline(),
          (c) -> super.onSlotChange(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getOldStack()), com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getNewStack()))
        );
    }

    @Override
    protected void onCrafting(final ItemStack stack, final int amount)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new OnCraftingWithAmountAsintContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack), amount),
          pipeline.getOnCraftingWithAmountAsintPipeline(),
          (c) -> super.onCrafting(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()), c.getAmount())
        );
    }

    @Override
    protected void onSwapCraft(final int p_190900_1_)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new OnSwapCraftContext(p_190900_1_),
          pipeline.getOnSwapCraftPipeline(),
          (c) -> super.onSwapCraft(c.getP_190900_1_())
        );
    }

    @Override
    protected void onCrafting(final ItemStack stack)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new OnCraftingContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getOnCraftingPipeline(),
          (c) -> super.onCrafting(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()))
        );
    }

    @Override
    public ItemStack onTake(final EntityPlayer thePlayer, final ItemStack stack)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new OnTakeContext(PlayerEntity.fromForge(thePlayer), com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
            pipeline.getOnTakePipeline(),
            (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(super.onTake(PlayerEntity.asForge(c.getThePlayer()), com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
                                                                                                                                              .asForge(c.getStack())))
          )
        );
    }

    /**
     * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
     */
    @Override
    public boolean isItemValid(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsItemValidContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getIsItemValidPipeline(),
          (c) -> super.isItemValid(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()))
        );
    }

    /**
     * Helper fnct to get the stack in the slot.
     */
    @Override
    public ItemStack getStack()
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new GetStackContext(),
          pipeline.getGetStackPipeline(),
          (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(super.getStack())
        ));
    }

    /**
     * Returns if this slot contains a stack.
     */
    @Override
    public boolean getHasStack()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetHasStackContext(),
          pipeline.getGetHasStackPipeline(),
          (c) -> super.getHasStack()
        );
    }

    /**
     * Helper method to put a stack in the slot.
     */
    @Override
    public void putStack(final ItemStack stack)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new PutStackContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getPutStackPipeline(),
          (c) -> super.putStack(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()))
        );
    }

    /**
     * Called when the stack in a Slot changes
     */
    @Override
    public void onSlotChanged()
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new OnSlotChangedContext(),
          pipeline.getOnSlotChangedPipeline(),
          (c) -> super.onSlotChanged()
        );
    }

    /**
     * Returns the maximum stack size for a given slot (usually the same as getInventoryStackLimit(), but 1 in the case
     * of armor slots)
     */
    @Override
    public int getSlotStackLimit()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetSlotStackLimitContext(),
          pipeline.getGetSlotStackLimitPipeline(),
          (c) -> super.getSlotStackLimit()
        );
    }

    @Override
    public int getItemStackLimit(final ItemStack stack)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetItemStackLimitContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getGetIItemStackLimitPipeline(),
          (c) -> super.getItemStackLimit(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()))
        );
    }

    @Nullable
    @Override
    public String getSlotTexture()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetSlotTextureContext(),
          pipeline.getGetSlotTexturePipeline(),
          (c) -> super.getSlotTexture()
        );
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    @Override
    public ItemStack decrStackSize(final int amount)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new DecrStackSizeContext(amount),
          pipeline.getDecrStackSizePipeline(),
          (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(super.decrStackSize(c.getAmount()))
        ));
    }

    /**
     * returns true if the slot exists in the given inventory and location
     */
    @Override
    public boolean isHere(final net.minecraft.inventory.IInventory inv, final int slotIn)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsHereContext(fromForge(inv), slotIn),
          pipeline.getIsHerePipeline(),
          (c) -> super.isHere(asForge(c.getInv()), c.getSlotIn())
        );
    }

    /**
     * Return whether this slot's stack can be taken from this slot.
     */
    @Override
    public boolean canTakeStack(final EntityPlayer playerIn)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new CanTakeStackContext(PlayerEntity.fromForge(playerIn)),
          pipeline.getCanTakeStackPipeline(),
          (c) -> super.canTakeStack(PlayerEntity.asForge(c.getPlayerIn()))
        );
    }

    /**
     * Actualy only call when we want to render the white square effect over the slots. Return always True, except for
     * the armor slot of the Donkey/Mule (we can't interact with the Undead and Skeleton horses)
     */
    @Override
    public boolean isEnabled()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsEnabledContext(),
          pipeline.getIsEnabledPipeline(),
          (c) -> super.isEnabled()
        );
    }

    /**
     * Gets the path of the texture file to use for the background image of this slot when drawing the GUI.
     *
     * @return The resource location for the background image
     */
    @Override
    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getBackgroundLocation()
    {
        return Identifier.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new GetBackgroundLocationContext(),
          pipeline.getGetBackgroundLocationPipeline(),
          (c) -> Identifier.fromForge(super.getBackgroundLocation())
        ));
    }

    /**
     * Sets the texture file to use for the background image of the slot when it's empty.
     *
     * @param texture the resourcelocation for the texture
     */
    @Override
    @OnlyIn(Dist.CLIENT)
    public void setBackgroundLocation(final ResourceLocation texture)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new SetBackgroundLocationContext(Identifier.fromForge(texture)),
          pipeline.getSetBackgroundLocationPipeline(),
          (c) -> super.setBackgroundLocation(Identifier.asForge(c.getTexture()))
        );
    }

    /**
     * Sets which icon index to use as the background image of the slot when it's empty.
     *
     * @param name The icon to use, null for none
     */
    @Override
    public void setBackgroundName(@Nullable final String name)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new SetBackgroundNameContext(name),
          pipeline.getSetBackgroundNamePipeline(),
          (c) -> super.setBackgroundName(name)
        );
    }

    @Nullable
    @Override
    @OnlyIn(Dist.CLIENT)
    public TextureAtlasSprite getBackgroundSprite()
    {
        return Sprite.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new GetBackgroundSpriteContext(),
          pipeline.getGetBackgroundSpritePipeline(),
          (c) -> Sprite.fromForge(super.getBackgroundSprite())
        ));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    protected TextureMap getBackgroundMap()
    {
        return SpriteMap.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new GetBackgroundMapContext(),
          pipeline.getGetBackgroundMapPipeline(),
          (c) -> SpriteMap.fromForge(super.getBackgroundMap())
        ));
    }

    /**
     * Retrieves the index in the inventory for this slot, this value should typically not
     * be used, but can be useful for some occasions.
     *
     * @return Index in associated inventory for this slot.
     */
    @Override
    public int getSlotIndex()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetSlotIndexContext(),
          pipeline.getGetSlotIndexPipeline(),
          (c) -> super.getSlotIndex()
        );
    }

    /**
     * Checks if the other slot is in the same inventory, by comparing the inventory reference.
     *
     * @return true if the other slot is in the same inventory
     */
    @Override
    public boolean isSameInventory(final Slot other)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsSameInventoryContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot.fromForge(other)),
          pipeline.getIsSameInventoryPipeline(),
          (c) -> super.isSameInventory(com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot.asForge(c.getOther()))
        );
    }

    @Override
    public void onSlotChange(final IItemStack p_75220_1_, final IItemStack p_75220_2_)
    {
        this.onSlotChange(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(p_75220_1_), com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(p_75220_2_));
    }

    @Override
    public IItemStack onTake(final IPlayerEntity thePlayer, final IItemStack stack)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(this.onTake(PlayerEntity.asForge(thePlayer), com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack
                                                                                                                                  .asForge(stack)));
    }

    @Override
    public boolean isItemValid(final IItemStack stack)
    {
        return this.isItemValid(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack));
    }

    @Override
    public IItemStack getContainedStack()
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(this.getStack());
    }

    @Override
    public void putStack(final IItemStack stack)
    {
        this.putStack(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack));
    }

    @Override
    public int getIItemStackLimit(final IItemStack stack)
    {
        return this.getItemStackLimit(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack));
    }

    @Override
    public boolean isHere(final IInventory inv, final int slotIn)
    {
        return this.isHere(asForge(inv), slotIn);
    }

    @Override
    public boolean canTakeStack(final IPlayerEntity playerIn)
    {
        return this.canTakeStack(PlayerEntity.asForge(playerIn));
    }

    @Override
    public void setBackgroundLocation(final IIdentifier texture)
    {
        this.setBackgroundLocation(Identifier.asForge(texture));
    }

    @Override
    public boolean isSameInventory(final ISlot other)
    {
        return this.isSameInventory(com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot.asForge(other));
    }

    @Override
    public int getSlotNumber()
    {
        return this.slotNumber;
    }

    @Override
    public int getItemStackLimit(final IItemStack itemstack)
    {
        return this.getItemStackLimit(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(itemstack));
    }

    @Override
    public I getInstanceData()
    {
        return instanceData;
    }

    @Override
    public ISprite getBackgroundTexture()
    {
        return Sprite.fromForge(this.getBackgroundSprite());
    }

    @Override
    public IIdentifier getIdentifierOfBackgroundLocation()
    {
        return Identifier.fromForge(this.getBackgroundLocation());
    }

    @Override
    public IItemStack decreaseContainedStacksSize(final int amount)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(this.decrStackSize(amount));
    }
}
