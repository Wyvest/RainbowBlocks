package net.wyvest.rainbowblocks.mixin;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.wyvest.rainbowblocks.RainbowBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import java.util.BitSet;
import java.util.List;

@Mixin(BlockModelRenderer.class)
public class BlockModelRendererMixin_NoOptiFine {
    @ModifyArgs(method = "renderModelAmbientOcclusionQuads", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/WorldRenderer;putColorMultiplier(FFFI)V"))
    private void modifyArgs(Args args, IBlockAccess blockAccessIn, Block blockIn, BlockPos blockPosIn, WorldRenderer worldRendererIn, List<BakedQuad> listQuadsIn, float[] quadBounds, BitSet boundsFlags, BlockModelRenderer.AmbientOcclusionFace aoFaceIn) {
        try {
            RainbowBlocks.handle(args);
        } catch (Exception ignored) {

        }
    }

    @ModifyArgs(method = "renderModelStandardQuads", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/WorldRenderer;putColorMultiplier(FFFI)V"))
    private void modifyArg2s(Args args, IBlockAccess blockAccessIn, Block blockIn, BlockPos blockPosIn, EnumFacing faceIn, int brightnessIn, boolean ownBrightness, WorldRenderer worldRendererIn, List<BakedQuad> listQuadsIn, BitSet boundsFlags) {
        try {
            RainbowBlocks.handle(args);
        } catch (Exception ignored) {

        }
    }
}
