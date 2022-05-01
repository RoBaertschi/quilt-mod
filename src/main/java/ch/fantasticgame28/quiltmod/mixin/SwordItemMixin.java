package ch.fantasticgame28.quiltmod.mixin;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.tools.Tool;

@Mixin(SwordItem.class)
public class SwordItemMixin extends ToolItem {

	@Shadow
	@Final
	@Mutable
	private
	Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

	@Final
	@Shadow
	private
	float attackDamage;

	public SwordItemMixin(ToolMaterial toolMaterial, Settings settings) {
		super(toolMaterial, settings);
	}

	@Inject(method = "<init>", at = @At("TAIL"))
	private void changeAttackSpeed(ToolMaterial toolMaterial, int i, float f, Item.Settings settings, CallbackInfo ci) {
		ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(
				EntityAttributes.GENERIC_ATTACK_DAMAGE,
				new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", (double)this.attackDamage, EntityAttributeModifier.Operation.ADDITION)
		);



		builder.put(
				EntityAttributes.GENERIC_ATTACK_SPEED,
				new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", (double)f, EntityAttributeModifier.Operation.ADDITION)
		);
		this.attributeModifiers = builder.build();

	}
}
