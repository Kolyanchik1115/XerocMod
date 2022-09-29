package net.javamod.xeroc;


import net.javamod.xeroc.effect.ModEffects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static net.javamod.xeroc.Xeroc.MOD_ID;
import static net.javamod.xeroc.item.ModBlock.BLOCKS;
import static net.javamod.xeroc.item.ModItems.ITEMS;


@Mod(MOD_ID)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class Xeroc {
    public static final String MOD_ID = "xeroc";

    public Xeroc() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        BLOCKS.register(bus);
        ModEffects.register(bus);

    }
}
