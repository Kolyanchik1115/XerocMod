package net.javamod.xeroc.effect;
import net.javamod.xeroc.item.ModItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

class SpaceSuffocation extends MobEffect {

    public SpaceSuffocation(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        AttributeModifier breathModifier = new AttributeModifier("breathReduction", amplifier, AttributeModifier.Operation.MULTIPLY_BASE);

        if (entity.hasItemInSlot(EquipmentSlot.CHEST) && entity.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.COSMIC_CHESTPLATE.get()) {
            removeEffect(entity, breathModifier);
        } else {
            entity.hurt(entity.damageSources().generic(), 4.0F);
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
//todo: need to refactor this code
    public void removeEffect(LivingEntity entity, AttributeModifier breathModifier) {
        entity.getAttributes().getInstance(Attributes.MAX_HEALTH).removeModifier(breathModifier);
        entity.getAttributes().getInstance(Attributes.MAX_HEALTH).setBaseValue(entity.getMaxHealth());
    }
}