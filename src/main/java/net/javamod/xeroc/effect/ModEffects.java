package net.javamod.xeroc.effect;

import net.javamod.xeroc.Xeroc;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Xeroc.MOD_ID);

    public static final RegistryObject<CosmicFreeze> FREEZE = MOB_EFFECTS.register("freeze",
            () -> new CosmicFreeze(MobEffectCategory.HARMFUL, 3124687));

    public static final RegistryObject<SpaceSuffocation> SUFFOCATION = MOB_EFFECTS.register("suffocation",
            () -> new SpaceSuffocation(MobEffectCategory.HARMFUL, 3124687));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }


}