package net.arcticwarmth.noend.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EndPortalBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.arcticwarmth.noend.noend.server.DisableEndServer.DISABLE_END;

@Mixin(EndPortalBlock.class)
public class NoEndMixin {
    @Inject(method = "entityInside", at = @At("HEAD"), cancellable = true)
    private void injectOnEntityCollision(BlockState state, Level world, BlockPos pos, Entity entity, InsideBlockEffectApplier handler, boolean bl, CallbackInfo ci) {
        MinecraftServer s = world.getServer();
        if (s != null
            && s.overworld().getGameRules().get(DISABLE_END).equals(true)
            && world instanceof ServerLevel
            && entity.level().dimension() != Level.END) {
            ci.cancel();
        }
    }

}
