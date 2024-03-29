
package net.javamod.xeroc;

import net.javamod.xeroc.block.ModBlock;
import net.javamod.xeroc.effect.ModEffects;
import net.javamod.xeroc.entity.ModEntity;
import net.javamod.xeroc.entity.client.AlienRenderer;
import net.javamod.xeroc.item.ModCreativeModTabs;
import net.javamod.xeroc.item.ModItems;
import net.javamod.xeroc.item.painting.ModPaintings;
import net.javamod.xeroc.loot.ModLootModifier;
import net.javamod.xeroc.sound.ModSound;
import net.javamod.xeroc.villager.ModVillager;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Xeroc.MOD_ID)
public class Xeroc {
    public static final String MOD_ID = "xeroc";

    public Xeroc() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);

        ModBlock.register(modEventBus);
        ModPaintings.register(modEventBus);

        ModEffects.register(modEventBus);
        ModSound.register(modEventBus);
        ModVillager.register(modEventBus);

        ModLootModifier.register(modEventBus);
//        ModPaintings.register(modEventBus);
        ModEntity.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.COSMIC_INGOT);
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

    @SubscribeEvent
    public void onServerStarting(ServerStartedEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntity.ALIEN.get(), AlienRenderer::new);
        }
    }
}



