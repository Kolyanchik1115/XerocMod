package net.javamod.xeroc.world.dimension;

import net.javamod.xeroc.Xeroc;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimension {
    public static final ResourceKey<Level> XEROC_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(Xeroc.MOD_ID, "cosmo"));
    public static final ResourceKey<DimensionType> XEROC_TYPE =
            ResourceKey.create(Registries.DIMENSION_TYPE,
                    new ResourceLocation(Xeroc.MOD_ID, "cosmo"));

    public static void register() {
        System.out.println("Registering ModDimensions for " + Xeroc.MOD_ID);
    }
}