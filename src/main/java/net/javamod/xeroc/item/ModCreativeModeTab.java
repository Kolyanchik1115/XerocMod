package net.javamod.xeroc.item;

import net.javamod.xeroc.Xeroc;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Xeroc.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {
    public static CreativeModeTab TUTORIAL_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        TUTORIAL_TAB = event.registerCreativeModeTab(new ResourceLocation(Xeroc.MOD_ID, "tutorial_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.COSMIC_SWORD.get())).title(Component.literal("Tutorial Tab")).build());
    }
}