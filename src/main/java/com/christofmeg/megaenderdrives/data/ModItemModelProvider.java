package com.christofmeg.megaenderdrives.data;

import com.christofmeg.megaenderdrives.CommonConstants;
import com.christofmeg.megaenderdrives.init.ItemRegistry;
import com.sts15.enderdrives.Constants;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.ArrayList;
import java.util.Arrays;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CommonConstants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        enderDiskColors(ItemRegistry.ENDER_DISK_1M);
        enderDiskColors(ItemRegistry.ENDER_DISK_4M);
        enderDiskColors(ItemRegistry.ENDER_DISK_16M);
        enderDiskColors(ItemRegistry.ENDER_DISK_64M);
        enderDiskColors(ItemRegistry.ENDER_DISK_256M);

        generated(ItemRegistry.ENDER_ITEM_CELL_HOUSING);
        generated(ItemRegistry.ENDER_STORAGE_COMPONENT_1M);
        generated(ItemRegistry.ENDER_STORAGE_COMPONENT_4M);
        generated(ItemRegistry.ENDER_STORAGE_COMPONENT_16M);
        generated(ItemRegistry.ENDER_STORAGE_COMPONENT_64M);
        generated(ItemRegistry.ENDER_STORAGE_COMPONENT_256M);
    }

    private void generated(DeferredHolder<Item, ? extends Item> item) {
        getBuilder(item.getId().getPath())
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", modLoc(String.format("item/%s", item.getId().getPath())));
    }

    private void enderDiskColors(DeferredHolder<Item, ? extends Item> disk) {
        ArrayList<ModelFile> colors = new ArrayList<>();
        ResourceLocation status = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "status");

        // 0 = green, 1 = blue, 2 = yellow, 3 = red
        for (String color : Arrays.asList("green", "blue", "yellow", "red")) {
            colors.add(getBuilder(String.format("%s_%s", disk.getId().getPath(), color))
                    .parent(getExistingFile(mcLoc("item/generated")))
                    .texture("layer0", modLoc(String.format("item/%s", disk.getId().getPath())))
                    .texture("layer1", modLoc(String.format("item/ender_disk_led_%s", color))));
        }

        getBuilder(disk.getId().getPath())
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", modLoc(String.format("item/%s", disk.getId().getPath())))
                .texture("layer1", modLoc("item/ender_disk_led_green"))
                .override().predicate(status, 1).model(colors.get(1)).end()  // blue
                .override().predicate(status, 2).model(colors.get(2)).end()  // yellow
                .override().predicate(status, 3).model(colors.get(3)).end(); // red
    }
}
