package net.javamod.xeroc;

import net.javamod.xeroc.effect.ModEffects;
import net.javamod.xeroc.entity.ModEntitys;
import net.javamod.xeroc.event.client.AlienRenderer;
import net.javamod.xeroc.item.ModBlock;
import net.javamod.xeroc.item.ModCreativeModeTab;
import net.javamod.xeroc.item.ModItems;
import net.javamod.xeroc.item.painting.ModPaintings;
import net.javamod.xeroc.villager.ModVillager;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib.GeckoLib;

import static net.javamod.xeroc.Xeroc.MOD_ID;

@Mod(MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Xeroc {
    public static final String MOD_ID = "xeroc";

    public Xeroc() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();


        ModCreativeModeTab.register(bus);
        ModItems.register(bus);
        ModBlock.register(bus);
        ModEffects.register(bus);
        ModEntitys.register(bus);
        ModPaintings.register(bus);
        ModVillager.VILLAGER_PROFESSION.register(bus);
        bus.addListener(this::addCreative);
        bus.addListener(this::commonSetup);
        GeckoLib.initialize();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.
                    register(ModEntitys.ALIEN.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);


        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

        if(event.getTab() == ModCreativeModeTab.TUTORIAL_TAB.get()) {
            event.accept(ModItems.COSMIC_KURS);
            event.accept(ModItems.COSMIC_KURS);

            event.accept(ModItems.COSMIC_SWORD);
            event.accept(ModItems.COSMIC_ORE);
            event.accept(ModItems.AlIEN_SPAWN_EGG);
            event.accept(ModItems.COSMIC_KURS);
            event.accept(ModItems.COSMIC_SNICKERS);

            event.accept(ModItems.COSMIC_SHOVEL);
            event.accept(ModItems.COSMIC_PICKAXE);
            event.accept(ModItems.COSMIC_MEAT);
            event.accept(ModItems.COSMIC_LEGGINGS);
            event.accept(ModItems.COSMIC_CHESTPLATE);
            event.accept(ModItems.COSMIC_HELMET);
            event.accept(ModItems.COSMIC_AXE);
            event.accept(ModItems.COSMIC_BOOTS);
            event.accept(ModItems.COSMIC_DIPLOMA);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            EntityRenderers.register(ModEntitys.ALIEN.get(), AlienRenderer::new);
        }
    }
}

