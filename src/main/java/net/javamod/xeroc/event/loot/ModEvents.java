package net.javamod.xeroc.event.loot;


import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.javamod.xeroc.Xeroc;
import net.javamod.xeroc.item.ModItems;
import net.javamod.xeroc.villager.ModVillager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;


@Mod.EventBusSubscriber(modid = Xeroc.MOD_ID)
public class ModEvents {

        @SubscribeEvent
        public static void addCustomTrades(VillagerTradesEvent event) {
            if (event.getType() == VillagerProfession.FARMER) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(ModItems.COSMIC_SNICKERS.get(), 4),
                        new ItemStack(ModItems.COSMIC_KURS.get(), 1),
                        10, 8, 0.02F
                ));
            }
            if(event.getType() == ModVillager.SOUND_MASTER.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(ModItems.COSMIC_SNICKERS.get(), 16),
                        new ItemStack(ModItems.COSMIC_KURS.get(), 1),
                        16, 8, 0.02f));
            }
        }


    @Mod.EventBusSubscriber(modid = Xeroc.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
//            event.put(ModEntitys.ALIEN.get(), AlienEntity.setAttributes());
        }
    }


}
