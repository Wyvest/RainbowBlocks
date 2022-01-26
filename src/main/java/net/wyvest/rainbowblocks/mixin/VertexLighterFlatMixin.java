package net.wyvest.rainbowblocks.mixin;

import net.minecraftforge.client.model.pipeline.VertexLighterFlat;
import net.wyvest.rainbowblocks.RainbowBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value = VertexLighterFlat.class, remap = false)
public class VertexLighterFlatMixin {

    @ModifyArgs(method = "processQuad", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/client/model/pipeline/VertexLighterFlat;updateColor([F[FFFFFI)V"))
    private void modifyArgs(Args args) {
        args.set(5, 1.0F);
        args.set(6, RainbowBlocks.timeBasedChroma());
    }
}