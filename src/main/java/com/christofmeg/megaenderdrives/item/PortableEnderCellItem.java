package com.christofmeg.megaenderdrives.item;

import appeng.api.stacks.AEKeyType;
import appeng.items.storage.StorageTier;
import appeng.items.tools.powered.PortableCellItem;
import gripe._90.megacells.MEGACells;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;

import java.util.Objects;
import java.util.function.Supplier;

public class PortableEnderCellItem extends PortableCellItem {

    private final Supplier<Integer> typeLimit;

    public PortableEnderCellItem(AEKeyType keyType, Supplier<Integer> typeLimit, MenuType<?> menuType, StorageTier tier, Properties props, int defaultColor) {

        super(
                keyType,
                getTypeLimit(),
                menuType,
                tier,
                props.stacksTo(1),
                defaultColor);
        this.typeLimit = typeLimit;
    }

    public int getTypeLimit() {
        return (Integer)this.typeLimit.get();
    }

    @Override
    public double getIdleDrain() {
        return 1.0;
    }

    @Override
    public ResourceLocation getRecipeId() {
        return MEGACells.makeId(
                "cells/portable/" + Objects.requireNonNull(getRegistryName()).getPath());
    }

    @Override
    public double getChargeRate(ItemStack stack) {
        return super.getChargeRate(stack) * 2;
    }

    @Override
    public double getAEMaxPower(ItemStack stack) {
        return super.getAEMaxPower(stack) * 8;
    }

}
