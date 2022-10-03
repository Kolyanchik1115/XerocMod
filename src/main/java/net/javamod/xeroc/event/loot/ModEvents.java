package net.javamod.xeroc.event.loot;


import com.google.common.eventbus.Subscribe;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.javamod.xeroc.Xeroc;
import net.javamod.xeroc.item.ModItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Xeroc.MOD_ID)
public class ModEvents {
    @SubscribeEvent
        public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType()== VillagerProfession.FARMER){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades  =event.getTrades();
            ItemStack stack = new ItemStack(ModItems.COSMIC_KURS.get(), 1);
            int villagerLevel = 1;
            trades.get(villagerLevel).add((trader,rand)-> new MerchantOffer(new ItemStack(ModItems.COSMIC_SNICKERS.get(),1),stack ,10,8,0.02F));
        }
    }
}
