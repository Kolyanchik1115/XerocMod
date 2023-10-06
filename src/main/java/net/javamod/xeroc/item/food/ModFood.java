package net.javamod.xeroc.item.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFood {
    public static final FoodProperties COSMIC_MEAT = new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).saturationMod(0.6F).effect(()->
            new MobEffectInstance(MobEffects.LUCK,200),0.4F).build();
    public static final FoodProperties COSMIC_SNICKERS = new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).build();
}
