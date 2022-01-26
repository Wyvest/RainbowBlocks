package net.wyvest.rainbowblocks;

import net.wyvest.rainbowblocks.command.BlocksCommand;
import net.wyvest.rainbowblocks.config.BlocksConfig;
import net.wyvest.rainbowblocks.updater.Updater;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import java.awt.*;
import java.io.File;

@Mod(modid = RainbowBlocks.ID, name = RainbowBlocks.NAME, version = RainbowBlocks.VER)
public class RainbowBlocks {
    public static final String NAME = "@NAME@", VER = "@VER@", ID = "@ID@";
    public static File jarFile;
    public static File modDir = new File(new File(Minecraft.getMinecraft().mcDataDir, "W-OVERFLOW"), NAME);
    public static BlocksConfig config;

    @Mod.EventHandler
    protected void onFMLPreInitialization(FMLPreInitializationEvent event) {
        if (!modDir.exists()) modDir.mkdirs();
        jarFile = event.getSourceFile();
    }

    @Mod.EventHandler
    protected void onInitialization(FMLInitializationEvent event) {
        new BlocksCommand().register();
        config = new BlocksConfig();
        config.preload();
        Updater.update();
    }

    /**
     * @return The red value of the provided RGBA value.
     */
    public static int getRed(int rgba) {
        return (rgba >> 16) & 0xFF;
    }

    /**
     * @return The green value of the provided RGBA value.
     */
    public static int getGreen(int rgba) {
        return (rgba >> 8) & 0xFF;
    }

    /**
     * @return The blue value of the provided RGBA value.
     */
    public static int getBlue(int rgba) {
        return (rgba) & 0xFF;
    }

    public static void handle(Args args) {
        int chroma = timeBasedChroma();
        args.set(0, (float) getRed(chroma) / 255);
        args.set(1, (float) getGreen(chroma) / 255);
        args.set(2, (float) getBlue(chroma) / 255);
    }

    public static int timeBasedChroma() {
        return Color.HSBtoRGB((float) (System.currentTimeMillis() % (long) ((int) (10000.0F / (float) BlocksConfig.speed))) / (10000.0F / (float) BlocksConfig.speed), 1.0F, 1.0F);
    }
}
