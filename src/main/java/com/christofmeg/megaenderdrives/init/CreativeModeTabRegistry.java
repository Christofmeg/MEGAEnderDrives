package com.christofmeg.megaenderdrives.init;

import com.christofmeg.megaenderdrives.CommonConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreativeModeTabRegistry {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CommonConstants.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MEGAENDERDRIVES_TAB = CREATIVE_MODE_TABS.register("megaenderdrives_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.megaenderdrives"))
            .icon(() -> ItemRegistry.ENDER_DISK_256M.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                ItemRegistry.ITEMS.getEntries().forEach(item -> {
                    output.accept(item.get());
                });
            }).build());
}
