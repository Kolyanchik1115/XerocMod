package net.javamod.xeroc.event;


import net.javamod.xeroc.Xeroc;
import net.javamod.xeroc.entity.ModEntity;
import net.javamod.xeroc.entity.custom.AlienEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Xeroc.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntity.ALIEN.get(), AlienEntity.createAttributes().build());
    }
}