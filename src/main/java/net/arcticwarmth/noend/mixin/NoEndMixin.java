package net.arcticwarmth.noend.mixin;


import net.arcticwarmth.noend.noend.server.DisableEndServer;
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

@Mixin(EndPortalBlock.class)
public class NoEndMixin {
    @Inject(method = "onEntityCollision", at = @At("HEAD"), cancellable = true)
    private void injectOnEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler, CallbackInfo ci) {
        MinecraftServer s = world.getServer();
        if (s != null
            && s.getGameRules().getBoolean(DisableEndServer.DISABLE_END)
            && world instanceof ServerWorld
            && entity.canUsePortals(true)
            && !entity.hasVehicle()
            && !entity.hasPassengers()
            && entity.getWorld().getRegistryKey() != World.END) {
            ci.cancel();
        }
    }

}
