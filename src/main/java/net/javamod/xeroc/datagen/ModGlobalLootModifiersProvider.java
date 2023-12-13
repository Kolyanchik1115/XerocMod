package net.javamod.xeroc.datagen;

import net.javamod.xeroc.Xeroc;
import net.javamod.xeroc.item.ModItems;
import net.javamod.xeroc.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, Xeroc.MOD_ID);
    }

    @Override
    protected void start() {
        add("cosmic_meat_from_creeper", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/creeper")).build()}, ModItems.COSMIC_MEAT.get()));

        add("cosmic_snickers_from_jungle_temples", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/jungle_temple")).build()}, ModItems.COSMIC_SNICKERS.get()));

    }
}