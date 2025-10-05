package com.christofmeg.megaenderdrives;

import appeng.api.storage.StorageCells;
import appeng.api.storage.cells.StorageCell;
import appeng.api.upgrades.IUpgradeInventory;
import appeng.api.upgrades.IUpgradeableItem;
import appeng.core.localization.PlayerMessages;
import appeng.recipes.game.StorageCellDisassemblyRecipe;
import appeng.util.InteractionUtil;
import com.sts15.enderdrives.items.EnderDiskItem;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Objects;

public class Utils {

    public static boolean disassembleDrive(ItemStack stack, Level level, Player player) {
        if (!InteractionUtil.isInAlternateUseMode(player)) {
            return false;
        } else {
            List<ItemStack> disassembledStacks = StorageCellDisassemblyRecipe.getDisassemblyResult(level, stack.getItem());
            if (disassembledStacks.isEmpty()) {
                return false;
            } else {
                Inventory playerInventory = player.getInventory();
                if (playerInventory.getSelected() != stack) {
                    return false;
                } else {
                    boolean isEnderDrive = stack.getItem() instanceof EnderDiskItem;
                    StorageCell inv = StorageCells.getCellInventory(stack, null);
                    if (inv != null && !isEnderDrive && !inv.getAvailableStacks().isEmpty()) {
                        player.displayClientMessage(PlayerMessages.OnlyEmptyCellsCanBeDisassembled.text(), true);
                        return false;
                    } else {
                        playerInventory.setItem(playerInventory.selected, ItemStack.EMPTY);
                        for (ItemStack disassembledStack : disassembledStacks) {
                            playerInventory.placeItemBackInInventory(disassembledStack.copy());
                        }
                        if (stack.getItem() instanceof IUpgradeableItem iUpgradeableItem) {
                            IUpgradeInventory var10000 = iUpgradeableItem.getUpgrades(stack);
                            Objects.requireNonNull(playerInventory);
                            var10000.forEach(playerInventory::placeItemBackInInventory);
                        }
                        return true;
                    }
                }
            }
        }
    }

}
