//package net.javamod.xeroc.villager;
//
//import com.google.common.collect.ImmutableSet;
//import net.javamod.xeroc.Xeroc;
//import net.javamod.xeroc.item.ModBlock;
//
//import net.minecraft.world.entity.ai.village.poi.PoiType;
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegistryObject;
//
//public class ModPOIs {
//    public static final DeferredRegister<PoiType> POI
//            = DeferredRegister.create(ForgeRegistries.POI_TYPES, Xeroc.MOD_ID);
//
//    public static final RegistryObject<PoiType> XEROC_PORTAL =
//            POI.register("xeroc_portal", () -> new PoiType(
//                    ImmutableSet.copyOf(ModBlock.COSMIC_PORTAL.get().getStateDefinition().getPossibleStates())
//                    , 0, 1));
//
//
//    public static void register(IEventBus eventBus) {
//        POI.register(eventBus);
//    }
//}