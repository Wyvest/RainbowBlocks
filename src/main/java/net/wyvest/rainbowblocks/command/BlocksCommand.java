package net.wyvest.rainbowblocks.command;

import net.wyvest.rainbowblocks.RainbowBlocks;
import gg.essential.api.EssentialAPI;
import gg.essential.api.commands.Command;
import gg.essential.api.commands.DefaultHandler;

public class BlocksCommand extends Command {
    public BlocksCommand() {
        super(RainbowBlocks.ID, true);
    }

    @DefaultHandler
    public void handle() {
        EssentialAPI.getGuiUtil().openScreen(RainbowBlocks.config.gui());
    }
}