package com.christofmeg.megaenderdrives;

import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.ModConfigSpec;

public class ModConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static ModConfigSpec.BooleanValue ENDER_DISK_1M_TOGGLE;
    public static ModConfigSpec.BooleanValue ENDER_DISK_4M_TOGGLE;
    public static ModConfigSpec.BooleanValue ENDER_DISK_16M_TOGGLE;
    public static ModConfigSpec.BooleanValue ENDER_DISK_64M_TOGGLE;
    public static ModConfigSpec.BooleanValue ENDER_DISK_256M_TOGGLE;

    public static ModConfigSpec.IntValue ENDER_DISK_1M_TYPE_LIMIT;
    public static ModConfigSpec.IntValue ENDER_DISK_4M_TYPE_LIMIT;
    public static ModConfigSpec.IntValue ENDER_DISK_16M_TYPE_LIMIT;
    public static ModConfigSpec.IntValue ENDER_DISK_64M_TYPE_LIMIT;
    public static ModConfigSpec.IntValue ENDER_DISK_256M_TYPE_LIMIT;

    public static void register(ModContainer container) {
        generalToggleConfig();
        enderDiskTypeLimits();
        container.registerConfig(net.neoforged.fml.config.ModConfig.Type.SERVER, BUILDER.build());
    }

    private static void generalToggleConfig() {
        BUILDER.comment("Enable/disable individual storage cells").push("general");
        ENDER_DISK_1M_TOGGLE = BUILDER.define("enable_item_storage_cell_1m", true);
        ENDER_DISK_4M_TOGGLE = BUILDER.define("enable_item_storage_cell_4m", true);
        ENDER_DISK_16M_TOGGLE = BUILDER.define("enable_item_storage_cell_16m", true);
        ENDER_DISK_64M_TOGGLE = BUILDER.define("enable_item_storage_cell_64m", true);
        ENDER_DISK_256M_TOGGLE = BUILDER.define("enable_item_storage_cell_256m", true);
        BUILDER.pop();
    }

    private static void enderDiskTypeLimits() {
        BUILDER.comment("MEGA Ender Drives type limits.").push("ender_disk");
        ENDER_DISK_1M_TYPE_LIMIT = BUILDER.comment("Max item types for Item Storage Cell 1m").defineInRange("type_limit_1m", 63, 1, 1024);
        ENDER_DISK_4M_TYPE_LIMIT = BUILDER.comment("Max item types for Item Storage Cell 4k").defineInRange("type_limit_4m", 127, 1, 1024);
        ENDER_DISK_16M_TYPE_LIMIT = BUILDER.comment("Max item types for Item Storage Cell 16k").defineInRange("type_limit_16m", 255, 1, 1024);
        ENDER_DISK_64M_TYPE_LIMIT = BUILDER.comment("Max item types for Item Storage Cell 64k").defineInRange("type_limit_64m", 511, 1, 1024);
        ENDER_DISK_256M_TYPE_LIMIT = BUILDER.comment("Max item types for Item Storage Cell 256k").defineInRange("type_limit_256m", 1023, 1, 1024);
        BUILDER.pop();
    }

}
