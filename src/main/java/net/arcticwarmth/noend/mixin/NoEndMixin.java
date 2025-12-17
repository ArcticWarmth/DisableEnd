package net.arcticwarmth.noend.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.EndPortalBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.arcticwarmth.noend.noend.server.DisableEndServer.DISABLE_END;

@Mixin(EndPortalBlock.class)
public class NoEndMixin {
    @Inject(method = "onEntityCollision", at = @At("HEAD"), cancellable = true)
    private void injectOnEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler, boolean bl, CallbackInfo ci) {
        MinecraftServer s = world.getServer();
        if (s != null
            && s.getOverworld().getGameRules().getValue(DISABLE_END).equals(true)
            && world instanceof ServerWorld
            && entity.getEntityWorld().getRegistryKey() != World.END) {
            ci.cancel();
        }
    }

}
