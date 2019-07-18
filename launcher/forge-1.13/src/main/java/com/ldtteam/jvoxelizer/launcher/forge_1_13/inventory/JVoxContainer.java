package com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory;

import com.ldtteam.jvoxelizer.core.logic.PipelineProcessor;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.IClickType;
import com.ldtteam.jvoxelizer.inventory.IContainer;
import com.ldtteam.jvoxelizer.inventory.IInventoryPlayer;
import com.ldtteam.jvoxelizer.inventory.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.dimension.Dimension;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.living.player.PlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.logic.pipeline.ForgeContainerPipeline;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.stream.nonnulllist.NonNullListCollector;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Collectors;

import static com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot.fromForge;
import static com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.ContainerListener.asForge;
import static com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.ContainerListener.fromForge;

public class JVoxContainer<I> extends Container implements IContainer<I>
{

    private final I                                        instanceData;
    private final ForgeContainerPipeline<IContainer<I>, I> pipeline;

    public JVoxContainer(
      final I instanceData,
      final ForgeContainerPipeline<IContainer<I>, I> pipeline)
    {
        this.instanceData = instanceData;
        this.pipeline = pipeline;
    }

    /**
     * Adds an item slot to this container
     */
    @Override
    protected Slot addSlot(final Slot slotIn)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new AddSlotToContainerContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot.fromForge(slotIn)),
            pipeline.getAddSlotToContainerPipeline(),
            (c) -> fromForge(super.addSlot(com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot.asForge(c.getSlotIn())))
          )
        );
    }

    @Override
    public void addListener(final IContainerListener listener)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new AddListenerContext(fromForge(listener)),
          pipeline.getAddListenerPipeline(),
          (c) -> super.addListener(asForge(c.getListener()))
        );
    }

    /**
     * returns a list if itemStacks, for each slot.
     */
    @Override
    public NonNullList<ItemStack> getInventory()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetInventoryContext(),
          pipeline.getGetInventoryPipeline(),
          (c) -> super.getInventory().stream().map(i -> com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(i)).collect(Collectors.toList())
        ).stream().map(i -> com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(i)).collect(NonNullListCollector.toList());
    }

    /**
     * Remove the given Listener. Method name is for legacy.
     */
    @Override
    public void removeListener(final IContainerListener listener)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new RemoveListenerContext(fromForge(listener)),
          pipeline.getRemoveListenerPipeline(),
          (c) -> super.removeListener(asForge(c.getListener()))
        );
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    @Override
    public void detectAndSendChanges()
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new DetectAndSendChangesContext(),
          pipeline.getDetectAndSendChangesPipeline(),
          (c) -> super.detectAndSendChanges()
        );
    }

    /**
     * Handles the given Button-click on the server, currently only used by enchanting. Name is for legacy.
     */
    @Override
    public boolean enchantItem(final EntityPlayer playerIn, final int id)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new EnchantItemContext(PlayerEntity.fromForge(playerIn), id),
          pipeline.getEnchantItemPipeline(),
          (c) -> super.enchantItem(PlayerEntity.asForge(c.getPlayerIn()), c.getId())
        );
    }

    @Nullable
    @Override
    public Slot getSlotFromInventory(final IInventory inv, final int slotIn)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new GetSlotFromInventoryContext(Inventory.fromForge(inv), slotIn),
          pipeline.getGetSlotFromInventoryPipeline(),
          (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot.fromForge(super.getSlotFromInventory(Inventory.asForge(c.getInv()), c.getSlotIn()))
        ));
    }

    @Override
    public Slot getSlot(final int slotId)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot.asForge(PipelineProcessor.processTypedPipeline(
          this,
          new GetSlotContext(slotId),
          pipeline.getGetSlotPipeline(),
          (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot.fromForge(super.getSlot(c.getSlotId()))
        ));
    }

    /**
     * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player
     * inventory and the other inventory(s).
     */
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer playerIn, final int index)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new TransferStackInSlotContext(PlayerEntity.fromForge(playerIn), index),
            pipeline.getTransferStackInSlotPipeline(),
            (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(super.transferStackInSlot(PlayerEntity.asForge(c.getPlayerIn()), c.getIndex()))
          )
        );
    }

    @Override
    public ItemStack slotClick(final int slotId, final int dragType, final ClickType clickTypeIn, final EntityPlayer player)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(
          PipelineProcessor.processTypedPipeline(
            this,
            new SlotClickContext(slotId, dragType, com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.ClickType.fromForge(clickTypeIn), PlayerEntity.fromForge(player)),
            pipeline.getSlotClickPipeline(),
            (c) -> com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(super.slotClick(c.getSlotId(), c.getDragType(), com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.ClickType
                                                                                                                                         .asForge(c.getClickTypeIn()), PlayerEntity.asForge(c.getPlayer())))
          )
        );
    }

    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in
     * is null for the initial slot that was double-clicked.
     */
    @Override
    public boolean canMergeSlot(final ItemStack stack, final Slot slotIn)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new CanMergeSlotContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack), com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot.fromForge(slotIn)),
          pipeline.getCanMergeSlotPipeline(),
          (c) -> super.canMergeSlot(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()), com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot.asForge(c.getSlotIn()))
        );
    }

    /**
     * Called when the container is closed.
     */
    @Override
    public void onContainerClosed(final EntityPlayer playerIn)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new OnContainerClosedContext(PlayerEntity.fromForge(playerIn)),
          pipeline.getOnContainerClosedPipeline(),
          (c) -> super.onContainerClosed(PlayerEntity.asForge(c.getPlayerIn()))
        );
    }

    @Override
    protected void clearContainer(final EntityPlayer playerIn, final World worldIn, final IInventory inventoryIn)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new ClearContainerContext(PlayerEntity.fromForge(playerIn), Dimension.fromForge(worldIn), Inventory.fromForge(inventoryIn)),
          pipeline.getClearContainerPipeline(),
          (c) -> super.clearContainer(PlayerEntity.asForge(c.getPlayerIn()), Dimension.asForge(c.getWorldIn()), Inventory.asForge(c.getInventoryIn()))
        );
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    @Override
    public void onCraftMatrixChanged(final IInventory inventoryIn)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new OnCraftMatrixChangedContext(Inventory.fromForge(inventoryIn)),
          pipeline.getOnCraftMatrixChangedPipeline(),
          (c) -> super.onCraftMatrixChanged(Inventory.asForge(c.getInventoryIn()))
        );
    }

    /**
     * Puts an ItemStack in a slot.
     */
    @Override
    public void putStackInSlot(final int slotID, final ItemStack stack)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new PutStackInSlotContext(slotID, com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack)),
          pipeline.getPutStackInSlotPipeline(),
          (c) -> super.putStackInSlot(c.getSlotID(), com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()))
        );
    }

    @Override
    public void setAll(final List<ItemStack> p_190896_1_)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new SetAllContext(p_190896_1_.stream().map(i -> com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(i)).collect(Collectors.toList())),
          pipeline.getSetAllPipeline(),
          (c) -> super.setAll(c.getP_190896_1_().stream().map(i -> com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(i)).collect(Collectors.toList()))
        );
    }

    @Override
    public void updateProgressBar(final int id, final int data)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new UpdateProgressBarContext(id, data),
          pipeline.getUpdateProgressBarPipeline(),
          (c) -> super.updateProgressBar(c.getId(), c.getData())
        );
    }

    /**
     * Gets a unique transaction ID. Parameter is unused.
     */
    @Override
    public short getNextTransactionID(final InventoryPlayer invPlayer)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetNextTransactionIDContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.InventoryPlayer.fromForge(invPlayer)),
          pipeline.getGetNextTransactionIDPipeline(),
          (c) -> super.getNextTransactionID(com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.InventoryPlayer.asForge(c.getInvPlayer()))
        );
    }

    /**
     * gets whether or not the player can craft in this inventory or not
     */
    @Override
    public boolean getCanCraft(final EntityPlayer player)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetCanCraftContext(PlayerEntity.fromForge(player)),
          pipeline.getGetCanCraftPipeline(),
          (c) -> super.getCanCraft(PlayerEntity.asForge(c.getPlayer()))
        );
    }

    /**
     * sets whether the player can craft in this inventory or not
     */
    @Override
    public void setCanCraft(final EntityPlayer player, final boolean canCraft)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new SetCanCraftContext(PlayerEntity.fromForge(player), canCraft),
          pipeline.getSetCanCraftPipeline(),
          (c) -> super.setCanCraft(PlayerEntity.asForge(c.getPlayer()), canCraft)
        );
    }

    /**
     * Merges provided ItemStack with the first avaliable one in the container/player inventor between minIndex
     * (included) and maxIndex (excluded). Args : stack, minIndex, maxIndex, negativDirection. /!\ the Container
     * implementation do not check if the item is valid for the slot
     */
    @Override
    protected boolean mergeItemStack(final ItemStack stack, final int startIndex, final int endIndex, final boolean reverseDirection)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new MergeItemStackContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(stack), startIndex, endIndex, reverseDirection),
          pipeline.getMergeItemStackPipeline(),
          (c) -> super.mergeItemStack(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(c.getStack()), c.getStartIndex(), c.getEndIndex(), c.getReverseDirection())
        );
    }

    /**
     * Reset the drag fields
     */
    @Override
    protected void resetDrag()
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new ResetDragContext(),
          pipeline.getResetDragPipeline(),
          (c) -> super.resetDrag()
        );
    }

    /**
     * Returns true if the player can "drag-spilt" items into this slot,. returns true by default. Called to check if
     * the slot can be added to a list of Slots to split the held ItemStack across.
     */
    @Override
    public boolean canDragIntoSlot(final Slot slotIn)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new CanDragIntoSlotContext(com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot.fromForge(slotIn)),
          pipeline.getCanDragIntoSlotPipeline(),
          (c) -> super.canDragIntoSlot(com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot.asForge(c.getSlotIn()))
        );
    }

    @Override
    protected void slotChangedCraftingGrid(final World worldIn, final EntityPlayer playerIn, final IInventory craftMatrixIn, final InventoryCraftResult craftResultIn)
    {
        PipelineProcessor.processVoidPipeline(
          this,
          new SlotChangedCraftingGridContext(Dimension.fromForge(worldIn), PlayerEntity.fromForge(playerIn),
            com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.InventoryCrafting.fromForge((InventoryCrafting) craftMatrixIn),
            com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.InventoryCraftResult.fromForge(craftResultIn)),
          pipeline.getSlotChangedCraftingGridPipeline(),
          (c) -> super.slotChangedCraftingGrid(
            Dimension.asForge(c.getP_192389_1_()),
            PlayerEntity.asForge(c.getP_192389_2_()),
            com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.InventoryCrafting.asForge(c.getP_192389_3_()),
            com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.InventoryCraftResult.asForge(c.getP_192389_4_())
          )
        );

        super.slotChangedCraftingGrid(worldIn, playerIn, craftMatrixIn, craftResultIn);
    }

    /**
     * Determines whether supplied player can use this container
     */
    @Override
    public boolean canInteractWith(final EntityPlayer playerIn)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new CanInteractWithContext(PlayerEntity.fromForge(playerIn)),
          pipeline.getCanInteractWithPipeline(),
          (c) -> {
              throw new IllegalStateException("Can not call 'canInteractWith' on Container. It is abstract.");
          }
        );
    }

    @Override
    public void addSlotToContainer(final ISlot<?> slot)
    {
        this.addSlot(com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot.asForge(slot));
    }

    @Override
    public void addListener(final com.ldtteam.jvoxelizer.inventory.IContainerListener listener)
    {
        this.addListener(asForge(listener));
    }

    @Override
    public List<IItemStack> getContents()
    {
        return this.getInventory().stream().map(i -> com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(i)).collect(Collectors.toList());
    }

    @Override
    public void removeListener(final com.ldtteam.jvoxelizer.inventory.IContainerListener listener)
    {
        this.removeListener(asForge(listener));
    }

    @Override
    public void updateListeners()
    {
        this.detectAndSendChanges();
    }

    @Override
    public boolean enchantItem(final IPlayerEntity playerIn, final int id)
    {
        return this.enchantItem(PlayerEntity.asForge(playerIn), id);
    }

    @Override
    public ISlot getSlotFromInventory(final com.ldtteam.jvoxelizer.item.handling.IInventory inv, final int slotIn)
    {
        return fromForge(this.getSlotFromInventory(Inventory.asForge(inv), slotIn));
    }

    @Override
    public ISlot getSlotById(final int slotId)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot.fromForge(this.getSlot(slotId));
    }

    @Override
    public IItemStack transferStackInSlot(final IPlayerEntity playerIn, final int index)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(this.transferStackInSlot(PlayerEntity.asForge(playerIn), index));
    }

    @Override
    public IItemStack slotClick(final int slotId, final int dragType, final IClickType clickTypeIn, final IPlayerEntity player)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(this.slotClick(slotId, dragType, com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.ClickType.asForge(clickTypeIn), PlayerEntity.asForge(player)));
    }

    @Override
    public boolean canMergeSlot(final IItemStack stack, final ISlot slotIn)
    {
        return this.canMergeSlot(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack), com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot.asForge(slotIn));
    }

    @Override
    public void onContainerClosed(final IPlayerEntity playerIn)
    {
        this.onContainerClosed(PlayerEntity.asForge(playerIn));
    }

    @Override
    public void onCraftMatrixChanged(final com.ldtteam.jvoxelizer.item.handling.IInventory inventoryIn)
    {
        this.onCraftMatrixChanged(Inventory.asForge(inventoryIn));
    }

    @Override
    public void putStackInSlot(final int slotID, final IItemStack stack)
    {
        this.putStackInSlot(slotID, com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack));
    }

    @Override
    public void setContentsOfAllSlots(final List<IItemStack> p_190896_1_)
    {
        this.setAll(p_190896_1_.stream().map(i -> com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(i)).collect(Collectors.toList()));
    }

    @Override
    public short getNextTransactionID(final IInventoryPlayer invPlayer)
    {
        return this.getNextTransactionID(com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.InventoryPlayer.asForge(invPlayer));
    }

    @Override
    public boolean getCanCraft(final IPlayerEntity player)
    {
        return this.getCanCraft(PlayerEntity.asForge(player));
    }

    @Override
    public void setCanCraft(final IPlayerEntity player, final boolean canCraft)
    {
        this.setCanCraft(PlayerEntity.asForge(player), canCraft);
    }

    @Override
    public boolean canInteractWith(final IPlayerEntity playerIn)
    {
        return this.canInteractWith(PlayerEntity.asForge(playerIn));
    }

    @Override
    public boolean canDragIntoSlot(final ISlot slotIn)
    {
        return this.canDragIntoSlot(com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot.asForge(slotIn));
    }

    @Override
    public List<ISlot<?>> getInventorySlots()
    {
        return this.inventorySlots.stream().map(i -> com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot.fromForge(i)).collect(Collectors.toList());
    }

    /**
     * Clears the container inventory completely!
     */
    public void clearInventory()
    {
        this.inventorySlots.clear();
        this.inventoryItemStacks.clear();
    }

    @Override
    public List<IItemStack> getInventoryItemStacks()
    {
        return this.inventoryItemStacks.stream().map(i -> com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.fromForge(i)).collect(Collectors.toList());
    }

    @Override
    public boolean mergeItemStack(final IItemStack stack, final int startIndex, final int endIndex, final boolean reverseDirection)
    {
        return this.mergeItemStack(com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack.asForge(stack), startIndex, endIndex, reverseDirection);
    }

    @Override
    public I getInstanceData()
    {
        return instanceData;
    }
}
