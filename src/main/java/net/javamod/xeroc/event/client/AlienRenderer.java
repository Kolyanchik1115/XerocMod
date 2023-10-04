package net.javamod.xeroc.event.client;

import net.javamod.xeroc.Xeroc;
import net.javamod.xeroc.entity.custom.AlienEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AlienRenderer extends GeoEntityRenderer<AlienEntity> {
    public AlienRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AlienModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(AlienEntity instance) {
        return new ResourceLocation(Xeroc.MOD_ID, "textures/entity/alien_texture.png");
    }

}