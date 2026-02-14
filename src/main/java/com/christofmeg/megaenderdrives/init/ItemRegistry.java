<<<<<<< Updated upstream
package com.christofmeg.megaenderdrives.init;

import com.christofmeg.megaenderdrives.CommonConstants;
import com.christofmeg.megaenderdrives.ModConfig;
import com.sts15.enderdrives.items.EnderDiskItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CommonConstants.MOD_ID);

    public static final DeferredHolder<Item, Item> ENDER_ITEM_CELL_HOUSING = ITEMS.register("ender_item_cell_housing", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> ENDER_DISK_1M = ITEMS.register("item_storage_cell_1m", () -> new EnderDiskItem(new Item.Properties(), () -> ModConfig.ENDER_DISK_1M_TYPE_LIMIT.get()));
    public static final DeferredHolder<Item, Item> ENDER_DISK_4M = ITEMS.register("item_storage_cell_4m", () -> new EnderDiskItem(new Item.Properties(), () -> ModConfig.ENDER_DISK_4M_TYPE_LIMIT.get()));
    public static final DeferredHolder<Item, Item> ENDER_DISK_16M = ITEMS.register("item_storage_cell_16m", () -> new EnderDiskItem(new Item.Properties(), () -> ModConfig.ENDER_DISK_16M_TYPE_LIMIT.get()));
    public static final DeferredHolder<Item, Item> ENDER_DISK_64M = ITEMS.register("item_storage_cell_64m", () -> new EnderDiskItem(new Item.Properties(), () -> ModConfig.ENDER_DISK_64M_TYPE_LIMIT.get()));
    public static final DeferredHolder<Item, Item> ENDER_DISK_256M = ITEMS.register("item_storage_cell_256m", () -> new EnderDiskItem(new Item.Properties(), () -> ModConfig.ENDER_DISK_256M_TYPE_LIMIT.get()));
    public static final DeferredHolder<Item, Item> ENDER_STORAGE_COMPONENT_1M = ITEMS.register("cell_component_1m", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> ENDER_STORAGE_COMPONENT_4M = ITEMS.register("cell_component_4m", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> ENDER_STORAGE_COMPONENT_16M = ITEMS.register("cell_component_16m", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> ENDER_STORAGE_COMPONENT_64M = ITEMS.register("cell_component_64m", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> ENDER_STORAGE_COMPONENT_256M = ITEMS.register("cell_component_256m", () -> new Item(new Item.Properties()));

}
=======
package com.christofmeg.megaenderdrives.init;

import appeng.api.stacks.AEKeyType;
import appeng.items.storage.StorageTier;
import appeng.menu.me.common.MEStorageMenu;
import com.christofmeg.megaenderdrives.CommonConstants;
import com.christofmeg.megaenderdrives.ModConfig;
import com.christofmeg.megaenderdrives.item.PortableEnderCellItem;
import com.sts15.enderdrives.items.EnderDiskItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CommonConstants.MOD_ID);

    public static final StorageTier SIZE_1M = new StorageTier(1, "1m", 1024, 0.5F, () -> BuiltInRegistries.ITEM.get(ItemRegistry.ENDER_STORAGE_COMPONENT_1M.getId()));

    public static final DeferredHolder<Item, Item> ENDER_ITEM_CELL_HOUSING = ITEMS.register("ender_item_cell_housing", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> ENDER_DISK_1M = ITEMS.register("item_storage_cell_1m", () -> new EnderDiskItem(new Item.Properties(), () -> ModConfig.ENDER_DISK_1M_TYPE_LIMIT.get()));
    public static final DeferredHolder<Item, Item> ENDER_DISK_4M = ITEMS.register("item_storage_cell_4m", () -> new EnderDiskItem(new Item.Properties(), () -> ModConfig.ENDER_DISK_4M_TYPE_LIMIT.get()));
    public static final DeferredHolder<Item, Item> ENDER_DISK_16M = ITEMS.register("item_storage_cell_16m", () -> new EnderDiskItem(new Item.Properties(), () -> ModConfig.ENDER_DISK_16M_TYPE_LIMIT.get()));
    public static final DeferredHolder<Item, Item> ENDER_DISK_64M = ITEMS.register("item_storage_cell_64m", () -> new EnderDiskItem(new Item.Properties(), () -> ModConfig.ENDER_DISK_64M_TYPE_LIMIT.get()));
    public static final DeferredHolder<Item, Item> ENDER_DISK_256M = ITEMS.register("item_storage_cell_256m", () -> new EnderDiskItem(new Item.Properties(), () -> ModConfig.ENDER_DISK_256M_TYPE_LIMIT.get()));
    public static final DeferredHolder<Item, Item> ENDER_STORAGE_COMPONENT_1M = ITEMS.register("cell_component_1m", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> ENDER_STORAGE_COMPONENT_4M = ITEMS.register("cell_component_4m", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> ENDER_STORAGE_COMPONENT_16M = ITEMS.register("cell_component_16m", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> ENDER_STORAGE_COMPONENT_64M = ITEMS.register("cell_component_64m", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> ENDER_STORAGE_COMPONENT_256M = ITEMS.register("cell_component_256m", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> PORTABLE_ENDER_DISK_1M = ITEMS.register("portable_item_storage_cell_1m", () -> new PortableEnderCellItem(AEKeyType.items(), () -> ModConfig.ENDER_DISK_1M_TYPE_LIMIT.get(), MEStorageMenu.PORTABLE_FLUID_CELL_TYPE, SIZE_1M, new Item.Properties(), 0x80caff));
 //   public static final DeferredHolder<Item, Item> PORTABLE_ENDER_DISK_4M = ITEMS.register("portable_item_storage_cell_4m", () -> new PortableEnderCellItem(new Item.Properties(), () -> ModConfig.ENDER_DISK_4M_TYPE_LIMIT.get()));
 //   public static final DeferredHolder<Item, Item> PORTABLE_ENDER_DISK_16M = ITEMS.register("portable_item_storage_cell_16m", () -> new PortableEnderCellItem(new Item.Properties(), () -> ModConfig.ENDER_DISK_16M_TYPE_LIMIT.get()));
 //   public static final DeferredHolder<Item, Item> PORTABLE_ENDER_DISK_64M = ITEMS.register("portable_item_storage_cell_64m", () -> new PortableEnderCellItem(new Item.Properties(), () -> ModConfig.ENDER_DISK_64M_TYPE_LIMIT.get()));
 //   public static final DeferredHolder<Item, Item> PORTABLE_ENDER_DISK_256M = ITEMS.register("portable_item_storage_cell_256m", () -> new PortableEnderCellItem(new Item.Properties(), () -> ModConfig.ENDER_DISK_256M_TYPE_LIMIT.get()));

}
>>>>>>> Stashed changes
