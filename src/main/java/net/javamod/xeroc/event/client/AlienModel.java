package net.javamod.xeroc.event.client;

import net.javamod.xeroc.Xeroc;
import net.javamod.xeroc.entity.custom.AlienEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AlienModel extends AnimatedGeoModel<AlienEntity> {
    @Override
    public ResourceLocation getModelLocation(AlienEntity object) {
        return new ResourceLocation(Xeroc.MOD_ID, "geo/alien.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(AlienEntity object) {
        return new ResourceLocation(Xeroc.MOD_ID, "textures/entity/alien_texture.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(AlienEntity animatable) {
        return new ResourceLocation(Xeroc.MOD_ID, "animations/alien.animation.json");
    }
}
