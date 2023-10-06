//package net.javamod.xeroc.event.loot;
//
//
//import com.google.common.eventbus.Subscribe;
//import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
//import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
//import net.javamod.xeroc.Xeroc;
//import net.javamod.xeroc.entity.ModEntitys;
//import net.javamod.xeroc.entity.custom.AlienEntity;
//import net.javamod.xeroc.item.ModItems;
//import net.minecraft.world.entity.npc.VillagerProfession;
//import net.minecraft.world.entity.npc.VillagerTrades;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.item.trading.MerchantOffer;
//import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
//import net.minecraftforge.event.village.VillagerTradesEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//import java.util.List;
//
//public class ModEvents {
//    @Mod.EventBusSubscriber(modid = Xeroc.MOD_ID)
//
//    public class VillagerEvent {
//        @SubscribeEvent
//        public static void addCustomTrades(VillagerTradesEvent event) {
//            if (event.getType() == VillagerProfession.FARMER) {
//                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//                ItemStack stack = new ItemStack(ModItems.COSMIC_KURS.get(), 1);
//                int villagerLevel = 1;
//                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(new ItemStack(ModItems.COSMIC_SNICKERS.get(), 1), stack, 10, 8, 0.02F));
//            }
//        }
//    }
//
//    @Mod.EventBusSubscriber(modid = Xeroc.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
//    public static class ModEventBusEvents {
//        @SubscribeEvent
//        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
//            event.put(ModEntitys.ALIEN.get(), AlienEntity.setAttributes());
//        }
//    }
//
//
//}
