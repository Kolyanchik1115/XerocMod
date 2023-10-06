package net.javamod.xeroc.item;

import net.javamod.xeroc.Xeroc;
import net.javamod.xeroc.block.ModBlock;
import net.javamod.xeroc.item.armor.ModArmorMaterials;
import net.javamod.xeroc.item.food.ModFood;
import net.javamod.xeroc.item.painting.ModPaintings;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Xeroc.MOD_ID);

    public static final RegistryObject<CreativeModeTab> XEROC_TAB = CREATIVE_MODE_TABS.register("xeroc_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COSMIC_INGOT.get()))
                    .title(Component.translatable("creativetab.xeroc_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.COSMIC_INGOT.get());

                        pOutput.accept(ModItems.COSMIC_MEAT.get());
                        pOutput.accept(ModItems.COSMIC_SNICKERS.get());

                        pOutput.accept(ModItems.COSMIC_AXE.get());
                        pOutput.accept(ModItems.COSMIC_PICKAXE.get());
                        pOutput.accept(ModItems.COSMIC_SHOVEL.get());
                        pOutput.accept(ModItems.COSMIC_SWORD.get());

                        pOutput.accept(ModItems.COSMIC_DIPLOMA.get());
                        pOutput.accept(ModItems.COSMIC_KURS.get());

                        pOutput.accept(ModItems.COSMIC_HELMET.get());
                        pOutput.accept(ModItems.COSMIC_CHESTPLATE.get());
                        pOutput.accept(ModItems.COSMIC_LEGGINGS.get());
                        pOutput.accept(ModItems.COSMIC_BOOTS.get());

                        pOutput.accept(ModBlock.COSMIC_ORE.get());




                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}