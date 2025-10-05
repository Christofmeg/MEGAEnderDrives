package com.christofmeg.megaenderdrives;

import appeng.util.InteractionUtil;
import com.christofmeg.megaenderdrives.init.CreativeModeTabRegistry;
import com.christofmeg.megaenderdrives.init.ItemRegistry;
import com.sts15.enderdrives.items.EnderDiskItem;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@Mod(CommonConstants.MOD_ID)
public class MEGAEnderDrives {

    public MEGAEnderDrives(IEventBus modEventBus, ModContainer modContainer) {
        ItemRegistry.ITEMS.register(modEventBus);
        CreativeModeTabRegistry.CREATIVE_MODE_TABS.register(modEventBus);
        ModConfig.register(modContainer);
        NeoForge.EVENT_BUS.register(this);
    }

// TODO separate frequency from items and fluids
// TODO guideME

    @SubscribeEvent
    public void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        if (!InteractionUtil.isInAlternateUseMode(player)) return;
        ItemStack stack = event.getItemStack();
        if (!(stack.getItem() instanceof EnderDiskItem)) return;
        boolean success = Utils.disassembleDrive(stack, event.getLevel(), player);
        if (success) {
            event.setCanceled(true);
            event.setCancellationResult(InteractionResult.SUCCESS);
        }
    }

}