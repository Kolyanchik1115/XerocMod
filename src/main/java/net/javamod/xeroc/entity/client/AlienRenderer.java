package net.javamod.xeroc.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.javamod.xeroc.Xeroc;
import net.javamod.xeroc.entity.custom.AlienEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AlienRenderer extends MobRenderer<AlienEntity, AlienModel<AlienEntity>> {
    public AlienRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new AlienModel<>(pContext.bakeLayer(ModModelLayers.ALIEN_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(AlienEntity pEntity) {
        return new ResourceLocation(Xeroc.MOD_ID, "textures/entity/alien.png");
    }

    @Override
    public void render(AlienEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}