package net.javamod.xeroc.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;


public class ModToolTier {
        public static  final ForgeTier COSMIC_INGOT = new ForgeTier( 3, 1061, 8.0F, 3.0F, 18, Tags.Blocks.NEEDS_GOLD_TOOL,
                ()-> Ingredient.of(ModItems.COSMIC_INGOT.get()));

//    public static  final ForgeTier COSMIC_KURS = new ForgeTier( 3, 1061, 8.0F, 3.0F, 18, Tags.Blocks.NEEDS_GOLD_TOOL,
//            ()-> Ingredient.of(ModItems..get()));
//    public static  final ForgeTier COSMIC_DIPLOMA = new ForgeTier( 3, 1061, 8.0F, 3.0F, 18, Tags.Blocks.NEEDS_GOLD_TOOL,
//            ()-> Ingredient.of(ModItems.COSMIC_DIPLOMA.get()));


}
//    public static final Tier COSMIC = TierSortingRegistry.registerTier(
//            new ForgeTier(5, 1500, 5f, 4f, 25,
//                    Tags.Blocks.NEEDS_GOLD_TOOL, () -> Ingredient.of(ModItems.COSMIC_INGOT.get())),
//            new ResourceLocation(Xeroc.MOD_ID, "cosmic_ore"), List.of(Tiers.GOLD), List.of());