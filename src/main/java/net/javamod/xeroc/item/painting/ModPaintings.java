package net.javamod.xeroc.item.painting;

import net.javamod.xeroc.Xeroc;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public  static  final DeferredRegister<Motive> PAINTING_MOVTIES =DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, Xeroc.MOD_ID);

    public  static final RegistryObject<Motive> COSMIC = PAINTING_MOVTIES.register("cosmic_paint",()-> new Motive(64,64));
    public  static final RegistryObject<Motive> COSMIC_JOSE = PAINTING_MOVTIES.register("cosmic_jose",()-> new Motive(64,64));


    public static void register(IEventBus eventBus){
        PAINTING_MOVTIES.register(eventBus);
    }
}
