package net.javamod.xeroc.event.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.javamod.xeroc.Xeroc;
import net.javamod.xeroc.entity.custom.AlienEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import software.bernie.geckolib.renderer.GeoEntityRenderer;

import javax.annotation.Nullable;

public class AlienRenderer extends GeoEntityRenderer<AlienEntity> {
    public AlienRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AlienModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(AlienEntity instance) {
        return new ResourceLocation(Xeroc.MOD_ID, "textures/entity/alien_texture.png");
    }

//    public RenderType getRenderType(AlienEntity animatable, float partialTicks, PoseStack stack,
//                                    @Nullable MultiBufferSource renderTypeBuffer,
//                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
//                                    ResourceLocation textureLocation) {
//        stack.scale(0.8f, 0.8f, 0.8f);
//        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
//    }
}