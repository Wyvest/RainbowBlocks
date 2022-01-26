package net.wyvest.rainbowblocks.config;

import net.wyvest.rainbowblocks.RainbowBlocks;
import net.wyvest.rainbowblocks.updater.DownloadGui;
import net.wyvest.rainbowblocks.updater.Updater;
import gg.essential.api.EssentialAPI;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;

import java.io.File;

public class BlocksConfig extends Vigilant {

    @Property(
            type = PropertyType.NUMBER,
            name = "Chroma Speed",
            description = "Choose the speed of the chroma colour.",
            category = "General",
            min = 1,
            max = 10
    )
    public static int speed = 5;

    @Property(
            type = PropertyType.SWITCH,
            name = "Show Update Notification",
            description = "Show a notification when you start Minecraft informing you of new updates.",
            category = "Updater"
    )
    public static boolean showUpdate = true;

    @Property(
            type = PropertyType.BUTTON,
            name = "Update Now",
            description = "Update by clicking the button.",
            category = "Updater"
    )
    public void update() {
        if (Updater.shouldUpdate) EssentialAPI.getGuiUtil()
                .openScreen(new DownloadGui());
        else EssentialAPI.getNotifications()
                .push(RainbowBlocks.NAME, "No update had been detected at startup, and thus the update GUI has not been shown.");
    }

    public BlocksConfig() {
        super(new File(RainbowBlocks.modDir, RainbowBlocks.ID + ".toml"), RainbowBlocks.NAME);
        initialize();
    }
}
