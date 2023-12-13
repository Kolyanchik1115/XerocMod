package net.javamod.xeroc.datagen;

import net.javamod.xeroc.Xeroc;
import net.javamod.xeroc.block.ModBlock;
import net.javamod.xeroc.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> COSMIC_SMELTABLES = List.of(
            ModBlock.COSMIC_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        oreSmelting(pWriter, COSMIC_SMELTABLES, RecipeCategory.MISC, ModItems.COSMIC_INGOT.get(), 0.25f, 200, "cosmic_ingot");
        oreBlasting(pWriter, COSMIC_SMELTABLES, RecipeCategory.MISC, ModItems.COSMIC_INGOT.get(), 0.25f, 100, "cosmic_ingot");


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COSMIC_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" # ")
                .define('#', Items.STICK)
                .define('X', ModItems.COSMIC_INGOT.get())
                .unlockedBy(getHasName(ModItems.COSMIC_SWORD.get()), has(ModItems.COSMIC_SWORD.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COSMIC_PICKAXE.get())
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .define('#', Items.STICK)
                .define('X', ModItems.COSMIC_INGOT.get())
                .unlockedBy(getHasName(ModItems.COSMIC_PICKAXE.get()), has(ModItems.COSMIC_PICKAXE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COSMIC_AXE.get())
                .pattern(" XX")
                .pattern(" #X")
                .pattern(" # ")
                .define('#', Items.STICK)
                .define('X', ModItems.COSMIC_INGOT.get())
                .unlockedBy(getHasName(ModItems.COSMIC_AXE.get()), has(ModItems.COSMIC_AXE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COSMIC_SHOVEL.get())
                .pattern(" X ")
                .pattern(" # ")
                .pattern(" # ")
                .define('#', Items.STICK)
                .define('X', ModItems.COSMIC_INGOT.get())
                .unlockedBy(getHasName(ModItems.COSMIC_SHOVEL.get()), has(ModItems.COSMIC_SHOVEL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COSMIC_DIPLOMA.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.COSMIC_KURS.get())
                .unlockedBy(getHasName(ModItems.COSMIC_DIPLOMA.get()), has(ModItems.COSMIC_DIPLOMA.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COSMIC_HELMET.get())
                .pattern("XXX")
                .pattern("X X")
                .define('X', ModItems.COSMIC_INGOT.get())
                .unlockedBy(getHasName(ModItems.COSMIC_HELMET.get()), has(ModItems.COSMIC_HELMET.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COSMIC_CHESTPLATE.get())
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.COSMIC_INGOT.get())
                .unlockedBy(getHasName(ModItems.COSMIC_CHESTPLATE.get()), has(ModItems.COSMIC_CHESTPLATE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COSMIC_BOOTS.get())
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .define('X', ModItems.COSMIC_INGOT.get())
                .unlockedBy(getHasName(ModItems.COSMIC_BOOTS.get()), has(ModItems.COSMIC_BOOTS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COSMIC_LEGGINGS.get())
                .pattern("X X")
                .pattern("X X")
                .define('X', ModItems.COSMIC_INGOT.get())
                .unlockedBy(getHasName(ModItems.COSMIC_LEGGINGS.get()), has(ModItems.COSMIC_LEGGINGS.get()))
                .save(pWriter);

    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, Xeroc.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}