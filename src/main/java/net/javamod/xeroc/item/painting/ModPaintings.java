
package net.javamod.xeroc.item.painting;

import net.javamod.xeroc.Xeroc;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public  static  final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, Xeroc.MOD_ID);

    public  static final RegistryObject<PaintingVariant> COSMIC = PAINTING_VARIANTS.register("cosmic_paint",()-> new PaintingVariant(64,64));
    public  static final RegistryObject<PaintingVariant> COSMIC_JOSE = PAINTING_VARIANTS.register("cosmic_jose",()-> new PaintingVariant(64,64));


    public static void register(IEventBus eventBus){
        PAINTING_VARIANTS.register(eventBus);
    }
}