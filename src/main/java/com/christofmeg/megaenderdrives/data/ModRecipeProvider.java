package com.christofmeg.megaenderdrives.data;

import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;
import appeng.core.definitions.ItemDefinition;
import appeng.items.materials.MaterialItem;
import com.christofmeg.megaenderdrives.CommonConstants;
import com.christofmeg.megaenderdrives.init.ItemRegistry;
import com.glodblock.github.extendedae.common.EAESingletons;
import com.sts15.enderdrives.items.ItemInit;
import gripe._90.megacells.definition.MEGAItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.pedroksl.advanced_ae.common.definitions.AAEItems;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {

        makeEnderCell(ItemInit.ENDER_DISK_1K, ItemInit.ENDER_STORAGE_COMPONENT_1K, recipeOutput);
        makeEnderCell(ItemInit.ENDER_DISK_4K, ItemInit.ENDER_STORAGE_COMPONENT_4K, recipeOutput);
        makeEnderCell(ItemInit.ENDER_DISK_16K, ItemInit.ENDER_STORAGE_COMPONENT_16K, recipeOutput);
        makeEnderCell(ItemInit.ENDER_DISK_64K, ItemInit.ENDER_STORAGE_COMPONENT_64K, recipeOutput);
        makeEnderCell(ItemInit.ENDER_DISK_256K, ItemInit.ENDER_STORAGE_COMPONENT_256K, recipeOutput);

        // MEGA Ender Disk
        // 1M MEGA
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.ENDER_STORAGE_COMPONENT_1M.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', AEItems.SKY_DUST)
                .define('b', MEGAItems.ACCUMULATION_PROCESSOR)
                .define('c', ItemInit.ENDER_STORAGE_COMPONENT_256K.get())
                .define('d', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .unlockedBy(String.format("has_%s", MEGAItems.ACCUMULATION_PROCESSOR.id().getPath()), has(MEGAItems.ACCUMULATION_PROCESSOR))
                .save(recipeOutput.withConditions(
                        modLoaded("megacells")
                ), String.format("%s_mega", ItemRegistry.ENDER_STORAGE_COMPONENT_1M.getId()));

        // 1M VANILLA
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.ENDER_STORAGE_COMPONENT_1M.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', AEItems.SKY_DUST)
                .define('b', AEItems.SPATIAL_128_CELL_COMPONENT)
                .define('c', ItemInit.ENDER_STORAGE_COMPONENT_256K.get())
                .define('d', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .unlockedBy(String.format("has_%s", AEItems.SPATIAL_128_CELL_COMPONENT.id().getPath()), has(AEItems.SPATIAL_128_CELL_COMPONENT))
                .save(recipeOutput.withConditions(
                        not(modLoaded("megacells"))
                ), String.format("%s_vanilla", ItemRegistry.ENDER_STORAGE_COMPONENT_1M.getId()));

        // 4M MEGA
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.ENDER_STORAGE_COMPONENT_4M.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', AEItems.ENDER_DUST)
                .define('b', MEGAItems.ACCUMULATION_PROCESSOR)
                .define('c', ItemRegistry.ENDER_STORAGE_COMPONENT_1M.get())
                .define('d', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .unlockedBy(String.format("has_%s", MEGAItems.ACCUMULATION_PROCESSOR.id().getPath()), has(MEGAItems.ACCUMULATION_PROCESSOR))
                .save(recipeOutput.withConditions(
                        modLoaded("megacells")
                ), String.format("%s_mega", ItemRegistry.ENDER_STORAGE_COMPONENT_4M.getId()));

        // 4M VANILLA
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.ENDER_STORAGE_COMPONENT_4M.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', AEItems.ENDER_DUST)
                .define('b', AEItems.SPATIAL_128_CELL_COMPONENT)
                .define('c', ItemRegistry.ENDER_STORAGE_COMPONENT_1M.get())
                .define('d', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .unlockedBy(String.format("has_%s", AEItems.SPATIAL_128_CELL_COMPONENT.id().getPath()), has(AEItems.SPATIAL_128_CELL_COMPONENT))
                .save(recipeOutput.withConditions(
                        not(modLoaded("megacells"))
                ), String.format("%s_vanilla", ItemRegistry.ENDER_STORAGE_COMPONENT_4M.getId()));

        // 16M MEGA
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.ENDER_STORAGE_COMPONENT_16M.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', AEItems.ENDER_DUST)
                .define('b', MEGAItems.ACCUMULATION_PROCESSOR)
                .define('c', ItemRegistry.ENDER_STORAGE_COMPONENT_4M.get())
                .define('d', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .unlockedBy(String.format("has_%s", MEGAItems.ACCUMULATION_PROCESSOR.id().getPath()), has(MEGAItems.ACCUMULATION_PROCESSOR))
                .save(recipeOutput.withConditions(
                        modLoaded("megacells")
                ), String.format("%s_mega", ItemRegistry.ENDER_STORAGE_COMPONENT_16M.getId()));

        // 16M VANILLA
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.ENDER_STORAGE_COMPONENT_16M.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', AEItems.ENDER_DUST)
                .define('b', AEItems.SPATIAL_128_CELL_COMPONENT)
                .define('c', ItemRegistry.ENDER_STORAGE_COMPONENT_4M.get())
                .define('d', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .unlockedBy(String.format("has_%s", AEItems.SPATIAL_128_CELL_COMPONENT.id().getPath()), has(AEItems.SPATIAL_128_CELL_COMPONENT))
                .save(recipeOutput.withConditions(
                        not(modLoaded("megacells"))
                ), String.format("%s_vanilla", ItemRegistry.ENDER_STORAGE_COMPONENT_16M.getId()));

        // 64M MEGA
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.ENDER_STORAGE_COMPONENT_64M.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', AEItems.MATTER_BALL)
                .define('b', MEGAItems.ACCUMULATION_PROCESSOR)
                .define('c', ItemRegistry.ENDER_STORAGE_COMPONENT_16M.get())
                .define('d', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .unlockedBy(String.format("has_%s", MEGAItems.ACCUMULATION_PROCESSOR.id().getPath()), has(MEGAItems.ACCUMULATION_PROCESSOR))
                .save(recipeOutput.withConditions(
                        modLoaded("megacells")
                ), String.format("%s_mega", ItemRegistry.ENDER_STORAGE_COMPONENT_64M.getId()));

        // 64M VANILLA
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.ENDER_STORAGE_COMPONENT_64M.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', AEItems.MATTER_BALL)
                .define('b', AEItems.SPATIAL_128_CELL_COMPONENT)
                .define('c', ItemRegistry.ENDER_STORAGE_COMPONENT_16M.get())
                .define('d', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .unlockedBy(String.format("has_%s", AEItems.SPATIAL_128_CELL_COMPONENT.id().getPath()), has(AEItems.SPATIAL_128_CELL_COMPONENT))
                .save(recipeOutput.withConditions(
                        not(modLoaded("megacells"))
                ), String.format("%s_vanilla", ItemRegistry.ENDER_STORAGE_COMPONENT_64M.getId()));

        // 256M MEGA
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.ENDER_STORAGE_COMPONENT_256M.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', AEItems.MATTER_BALL)
                .define('b', MEGAItems.ACCUMULATION_PROCESSOR)
                .define('c', ItemRegistry.ENDER_STORAGE_COMPONENT_64M.get())
                .define('d', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .unlockedBy(String.format("has_%s", MEGAItems.ACCUMULATION_PROCESSOR.id().getPath()), has(MEGAItems.ACCUMULATION_PROCESSOR))
                .save(recipeOutput.withConditions(
                        modLoaded("megacells")
                ), String.format("%s_mega", ItemRegistry.ENDER_STORAGE_COMPONENT_256M.getId()));

        // 256M VANILLA
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.ENDER_STORAGE_COMPONENT_256M.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', AEItems.MATTER_BALL)
                .define('b', AEItems.SPATIAL_128_CELL_COMPONENT)
                .define('c', ItemRegistry.ENDER_STORAGE_COMPONENT_64M.get())
                .define('d', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .unlockedBy(String.format("has_%s", AEItems.SPATIAL_128_CELL_COMPONENT.id().getPath()), has(AEItems.SPATIAL_128_CELL_COMPONENT))
                .save(recipeOutput.withConditions(
                        not(modLoaded("megacells"))
                ), String.format("%s_vanilla", ItemRegistry.ENDER_STORAGE_COMPONENT_256M.getId()));

        makeMEGAEnderCell(ItemRegistry.ENDER_DISK_1M, ItemRegistry.ENDER_STORAGE_COMPONENT_1M, recipeOutput);
        makeMEGAEnderCell(ItemRegistry.ENDER_DISK_4M, ItemRegistry.ENDER_STORAGE_COMPONENT_4M, recipeOutput);
        makeMEGAEnderCell(ItemRegistry.ENDER_DISK_16M, ItemRegistry.ENDER_STORAGE_COMPONENT_16M, recipeOutput);
        makeMEGAEnderCell(ItemRegistry.ENDER_DISK_64M, ItemRegistry.ENDER_STORAGE_COMPONENT_64M, recipeOutput);
        makeMEGAEnderCell(ItemRegistry.ENDER_DISK_256M, ItemRegistry.ENDER_STORAGE_COMPONENT_256M, recipeOutput);

        makeEnderCellHousing(ItemRegistry.ENDER_ITEM_CELL_HOUSING, AEItems.SKY_DUST, recipeOutput);
    }

    private void makeEnderCellHousing(DeferredHolder<Item, ? extends Item> housing, ItemDefinition<MaterialItem> hasItem, RecipeOutput output) {
        // Vanilla
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, housing.get())
                .pattern("aba")
                .pattern("c c")
                .pattern("ded")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', AEItems.CALCULATION_PROCESSOR)
                .define('c', AEItems.SKY_DUST)
                .define('d', Tags.Items.INGOTS_NETHERITE)
                .define('e', Tags.Items.CHESTS_ENDER)
                .unlockedBy(String.format("has_%s", hasItem.id().getPath()), has(hasItem.get()))
                .save(output.withConditions(
                                not(modLoaded("megacells")),
                                not(modLoaded("extendedae")),
                                not(modLoaded("advanced_ae"))
                        ), String.format("%s_vanilla", housing.getId())
                );

        // Mega
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, housing.get())
                .pattern("aba")
                .pattern("c c")
                .pattern("ded")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', MEGAItems.ACCUMULATION_PROCESSOR)
                .define('c', AEItems.SKY_DUST)
                .define('d', MEGAItems.SKY_STEEL_INGOT)
                .define('e', Tags.Items.CHESTS_ENDER)
                .unlockedBy(String.format("has_%s", hasItem.id().getPath()), has(hasItem.get()))
                .save(output.withConditions(
                                modLoaded("megacells"),
                                not(modLoaded("advanced_ae"))
                        ), String.format("%s_mega", housing.getId())
                );

        // Extended
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, housing.get())
                .pattern("aba")
                .pattern("c c")
                .pattern("ded")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', EAESingletons.CONCURRENT_PROCESSOR)
                .define('c', AEItems.SKY_DUST)
                .define('d', EAESingletons.ENTRO_BLOCK)
                .define('e', Tags.Items.CHESTS_ENDER)
                .unlockedBy(String.format("has_%s", hasItem.id().getPath()), has(hasItem.get()))
                .save(output.withConditions(
                                modLoaded("extendedae"),
                                not(modLoaded("megacells")),
                                not(modLoaded("advanced_ae"))
                        ), String.format("%s_extended", housing.getId())
                );

        // Advanced
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, housing.get())
                .pattern("aba")
                .pattern("c c")
                .pattern("ded")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', AAEItems.QUANTUM_PROCESSOR)
                .define('c', AEItems.SKY_DUST)
                .define('d', AAEItems.QUANTUM_ALLOY_PLATE)
                .define('e', Tags.Items.CHESTS_ENDER)
                .unlockedBy(String.format("has_%s", hasItem.id().getPath()), has(hasItem.get()))
                .save(output.withConditions(
                                modLoaded("advanced_ae")
                        ), String.format("%s_advanced", housing.getId())
                );
    }

    private void makeMEGAEnderCell(DeferredHolder<Item, ? extends Item> disk, DeferredHolder<Item, ? extends Item> component, RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, disk.get())
                .pattern("aba")
                .pattern("bcb")
                .pattern("ddd")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', AEItems.SKY_DUST)
                .define('c', component.get())
                .define('d', MEGAItems.SKY_STEEL_INGOT)
                .unlockedBy(String.format("has_%s", component.getId().getPath()), has(component.get()))
                .save(output.withConditions(
                                modLoaded("megacells")
                        ), String.format("%s_mega", disk.getId())
                );

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, disk.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("efe")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', AAEItems.QUANTUM_PROCESSOR)
                .define('c', AEItems.SKY_DUST)
                .define('d', component.get())
                .define('e', AAEItems.QUANTUM_ALLOY_PLATE)
                .define('f', Tags.Items.CHESTS_ENDER)
                .unlockedBy(String.format("has_%s", component.getId().getPath()), has(component.get()))
                .save(output.withConditions(
                                modLoaded("advanced_ae"),
                                not(modLoaded("megacells"))
                        ), String.format("%s_advanced_ae", disk.getId())
                );

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, disk.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("efe")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', AEItems.CALCULATION_PROCESSOR)
                .define('c', AEItems.SKY_DUST)
                .define('d', component.get())
                .define('e', Tags.Items.INGOTS_NETHERITE)
                .define('f', Tags.Items.CHESTS_ENDER)
                .unlockedBy(String.format("has_%s", component.getId().getPath()), has(component.get()))
                .save(output.withConditions(
                                not(modLoaded("advanced_ae")),
                                not(modLoaded("megacells"))
                        ), String.format("%s_vanilla", disk.getId())
                );

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, disk.get())
                .requires(MEGAItems.MEGA_ITEM_CELL_HOUSING)
                .requires(component.get())
                .unlockedBy(String.format("has_%s", component.getId().getPath()), has(component.get()))
                .save(output.withConditions(
                                modLoaded("megacells")
                        ), String.format("%s_housing_mega", disk.getId())
                );

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, disk.get())
                .requires(ItemRegistry.ENDER_ITEM_CELL_HOUSING.get())
                .requires(component.get())
                .unlockedBy(String.format("has_%s", component.getId().getPath()), has(component.get()))
                .save(output.withConditions(
                                not(modLoaded("megacells"))
                        ), String.format("%s_housing_vanilla", disk.getId())
                );
    }

    private void makeEnderCell(DeferredHolder<Item, ? extends Item> disk, DeferredHolder<Item, ? extends Item> component, RecipeOutput output) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, disk.get())
                .requires(ItemRegistry.ENDER_ITEM_CELL_HOUSING.get())
                .requires(component.get())
                .unlockedBy(String.format("has_%s", component.getId().getPath()), has(component.get()))
                .save(output, String.format("%s_housing_vanilla", ResourceLocation.fromNamespaceAndPath(CommonConstants.MOD_ID, disk.getId().getPath()))
                );
    }

}