package net.arcticwarmth.noend.noend.server;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.world.rule.GameRule;
import net.minecraft.world.rule.GameRuleCategory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;

public class DisableEndServer  implements DedicatedServerModInitializer {
    /**
     * Runs the mod initializer on the dedicated server environment.
     */
    @Override
    public void onInitializeServer() {
    }
    public static final GameRule<Boolean> DISABLE_END = GameRuleBuilder.forBoolean(false).category(GameRuleCategory.PLAYER).buildAndRegister(Identifier.of("noend", "disable_end"));
    public static final GameRule<Boolean> DISABLE_NETHER = GameRuleBuilder.forBoolean(false).category(GameRuleCategory.PLAYER).buildAndRegister(Identifier.of("noend", "disable_nether"));
}
