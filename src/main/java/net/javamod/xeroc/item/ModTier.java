package net.javamod.xeroc.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;


public class ModTier {
    public static  final ForgeTier COSMIC_INGOT = new ForgeTier( 3, 1061, 8.0F, 3.0F, 18, Tags.Blocks.NEEDS_GOLD_TOOL,
            ()-> Ingredient.of(ModItems.COSMIC_INGOT.get()));
    public static  final ForgeTier COSMIC_KURS = new ForgeTier( 3, 1061, 8.0F, 3.0F, 18, Tags.Blocks.NEEDS_GOLD_TOOL,
            ()-> Ingredient.of(ModItems.COSMIC_KURS.get()));
    public static  final ForgeTier COSMIC_DIPLOMA = new ForgeTier( 3, 1061, 8.0F, 3.0F, 18, Tags.Blocks.NEEDS_GOLD_TOOL,
            ()-> Ingredient.of(ModItems.COSMIC_DIPLOMA.get()));

}