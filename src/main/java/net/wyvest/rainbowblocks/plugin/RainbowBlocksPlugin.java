package net.wyvest.rainbowblocks.plugin;

import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class RainbowBlocksPlugin implements IMixinConfigPlugin {
    private boolean isOptiFine = false;

    @Override
    public void onLoad(String mixinPackage) {
        try {
            Class.forName("net.optifine.render.RenderEnv");
            System.out.println("OptiFine detected, applying OptiFine compat mixin.");
            isOptiFine = true;
        } catch (ClassNotFoundException e) {
            System.out.println("OptiFine not detected, not applying OptiFine compat mixin.");
            isOptiFine = false;
        }
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.endsWith("_OptiFine")) {
            return isOptiFine;
        } else if (mixinClassName.endsWith("_NoOptiFine")) {
            return !isOptiFine;
        }
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
