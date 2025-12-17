package net.arcticwarmth.noend.noend.server;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class DisableEndServer  implements DedicatedServerModInitializer {
    /**
     * Runs the mod initializer on the dedicated server environment.
     */
    @Override
    public void onInitializeServer() {

    }
    public static final GameRules.Key<GameRules.BooleanRule> DISABLE_END = GameRuleRegistry.register("doDisableEnd", GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(false));
    public static final GameRules.Key<GameRules.BooleanRule> DISABLE_NETHER = GameRuleRegistry.register("doDisableNether", GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(false));
}
