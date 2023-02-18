package net.javamod.xeroc.entity;

import net.javamod.xeroc.Xeroc;
import net.javamod.xeroc.entity.custom.AlienEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntitys {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Xeroc.MOD_ID);

    public static final RegistryObject<EntityType<AlienEntity>> ALIEN = ENTITY_TYPES.register("alien", () ->
            EntityType.Builder.of(AlienEntity::new, MobCategory.MONSTER).sized(0.4f, 1.5f).build(
                    new ResourceLocation(Xeroc.MOD_ID, "alien").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }


}
