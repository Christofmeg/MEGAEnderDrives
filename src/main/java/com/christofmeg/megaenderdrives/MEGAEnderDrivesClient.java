package com.christofmeg.megaenderdrives;

import appeng.api.client.StorageCellModels;
import appeng.api.storage.cells.CellState;
import com.christofmeg.megaenderdrives.init.ItemRegistry;
import com.sts15.enderdrives.EnderDrives;
import com.sts15.enderdrives.client.ClientTapeCache;
import com.sts15.enderdrives.db.TapeDBManager;
import com.sts15.enderdrives.inventory.EnderDiskInventory;
import com.sts15.enderdrives.items.EnderDiskItem;
import com.sts15.enderdrives.items.TapeDiskItem;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.item.ItemProperties;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

import java.util.UUID;

@Mod(value = CommonConstants.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = CommonConstants.MOD_ID, value = Dist.CLIENT)
public class MEGAEnderDrivesClient {

    public MEGAEnderDrivesClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        ItemRegistry.ITEMS.getEntries().stream().filter(item -> item.get() instanceof EnderDiskItem).forEach(disk -> StorageCellModels.registerModel(disk.get(), EnderDrives.id("block/drive/ender_cell")));

        event.enqueueWork(() -> ItemRegistry.ITEMS.getEntries().stream().filter(item -> item.get() instanceof EnderDiskItem).forEach(disk -> ItemProperties.register(disk.get(), EnderDrives.id("status"), (stack, level, entity, seed) -> {
            var state = EnderDiskInventory.getCellStateForStack(stack);
            return switch (state) {
                case ABSENT, EMPTY -> 0.0f;
                case NOT_EMPTY -> 1.0f;
                case TYPES_FULL, FULL -> 2.0f;
            };
        })));
    }

    @SubscribeEvent
    public static void registerColorHandlers(RegisterColorHandlersEvent.Item event) {
        ItemColor itemColor = (stack, tintIndex) -> {
            if (tintIndex == 1) {
                if (stack.getItem() instanceof EnderDiskItem) {
                    CellState state = EnderDiskInventory.getCellStateForStack(stack);
                    return switch (state) {
                        case ABSENT -> 0x000000;
                        case EMPTY -> 0x00FF00;
                        case NOT_EMPTY -> 0x0000FF;
                        case TYPES_FULL, FULL -> 0xFFA500;
                    };
                }
                if (stack.getItem() instanceof TapeDiskItem) {
                    UUID id = TapeDiskItem.getTapeId(stack);
                    if (id == null) return 0x000000;
                    int typeCount = ClientTapeCache.getTypeCount(id);
                    long byteCount = ClientTapeCache.getByteCount(id);
                    int typeLimit = ((TapeDiskItem) stack.getItem()).getTypeLimit(stack);
                    long byteLimit = TapeDBManager.getByteLimit(id);
                    int typePercent = (typeLimit > 0) ? (typeCount * 100 / typeLimit) : 0;
                    int bytePercent = (byteLimit > 0) ? (int) (byteCount * 100 / byteLimit) : 0;
                    int usagePercent = Math.max(typePercent, bytePercent);
                    usagePercent = Math.min(usagePercent, 100);

                    // Now color logic
                    if (usagePercent >= 99) return 0xFF5555;      // Red
                    if (usagePercent >= 75) return 0xFFAA00;      // Orange
                    if (usagePercent > 0)   return 0x00AAFF;      // Blue
                    return 0x00FF00;                             // Green
                }
            }
            return 0xFFFFFFFF;
        };

        ItemRegistry.ITEMS.getEntries().stream().filter(item -> item.get() instanceof EnderDiskItem).forEach(disk -> event.register(itemColor, disk.get()));
    }

}
