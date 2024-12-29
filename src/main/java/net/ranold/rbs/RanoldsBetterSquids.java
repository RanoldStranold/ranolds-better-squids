package net.ranold.rbs;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;

public class RanoldsBetterSquids implements ModInitializer {

	@Override
	public void onInitialize() {
		// Register the squid blindness event listener
		AttackEntityCallback.EVENT.register((player,, world, hand, entity, hitResult) -> {
			// Check if the attacked entity is a squid
			if (entity.getType().toString().equals("minecraft:squid")) {
				// Apply blindness effect if the attacker is a player
				if (player instanceof ServerPlayerEntity) {
					// Apply blindness for 5 seconds (100 ticks)
					player.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 100, 1));
				}
				return ActionResult.SUCCESS;
			}
			return ActionResult.PASS;
		});
	}
}
