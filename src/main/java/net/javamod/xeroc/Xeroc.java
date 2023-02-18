package net.javamod.xeroc;

import net.javamod.xeroc.effect.ModEffects;
import net.javamod.xeroc.entity.ModEntitys;
import net.javamod.xeroc.event.client.AlienRenderer;
import net.javamod.xeroc.item.ModBlock;
import net.javamod.xeroc.item.ModItems;
import net.javamod.xeroc.item.painting.ModPaintings;
import net.javamod.xeroc.villager.ModVillager;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

import static net.javamod.xeroc.Xeroc.MOD_ID;

@Mod(MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Xeroc {
    public static final String MOD_ID = "xeroc";

    public Xeroc() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(bus);
        ModBlock.register(bus);
        ModPaintings.register(bus);
        ModEffects.register(bus);
        ModEntitys.register(bus);
        ModVillager.VILLAGER_PROFESSION.register(bus);
        GeckoLib.initialize();


    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {


            EntityRenderers.register(ModEntitys.ALIEN.get(), AlienRenderer::new);
        }
    }
}

