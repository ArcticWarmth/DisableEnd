package net.arcticwarmth.noend.noend.func;

import net.arcticwarmth.noend.noend.ConfigMgr;
import net.arcticwarmth.noend.noend.objects.RespawnLocation;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.arcticwarmth.noend.noend.DisableEnd.CONFIG;

public class RespawnPosFinder {

    private static String[] respawnBlocks = CONFIG.respawnblocks();
    public static RespawnLocation FindRespawnPos(int X, int Y, int Z, World world) {

        for (int i = 0; i < respawnBlocks.length; i++) {
            if(Registries.BLOCK.getId(world.getBlockState(new BlockPos(X, Y, Z)).getBlock()).toString().equals(respawnBlocks[i])) {
                int[] pos = new int[]{X, Y, Z};
                RespawnLocation respawnLocation = new RespawnLocation(pos, (net.minecraft.server.world.ServerWorld) world);
                return respawnLocation;
            }
        }
        int[] pos = new int[]{world.getSpawnPoint().getPos().getX(), world.getSpawnPoint().getPos().getY(), world.getSpawnPoint().getPos().getZ()};
        RespawnLocation respawnLocation = new RespawnLocation(pos, (net.minecraft.server.world.ServerWorld) world);
        return respawnLocation;
    }
}
