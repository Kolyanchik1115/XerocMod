package net.javamod.xeroc.item.armor;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class ModArmorItem extends ArmorItem {

    private static final Map<ArmorMaterial, MobEffect> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffect>())
                    .put(ModArmorMaterials.COSMIC, MobEffects.HEALTH_BOOST).build();
    private static final Map<ArmorMaterial, MobEffect> MATERIAL_TO_EFFECT_MAP_1 =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffect>())
                    .put(ModArmorMaterials.COSMIC, MobEffects.DAMAGE_BOOST).build();

    public ModArmorItem(ArmorMaterial p_40386_, Type p_266831_, Properties p_40388_) {
        super(p_40386_, p_266831_, p_40388_);
    }


    @Override
    public void inventoryTick(@NotNull ItemStack stack, Level world, @NotNull Entity entity, int slot, boolean selected) {
        if (!world.isClientSide()) {
            if (entity instanceof Player player) {
                if (hasFullSuitOfArmorOn(player)) {
                    evaluateArmorEffects(player);
                    evaluateArmorEffects1(player);
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffect> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffect mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void evaluateArmorEffects1(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffect> entry : MATERIAL_TO_EFFECT_MAP_1.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffect mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial mapArmorMaterial,
                                            MobEffect mapStatusEffect) {
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect);

        if (hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addEffect(new MobEffectInstance(mapStatusEffect, 400));

        }
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {
        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem breastplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }


}