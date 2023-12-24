package net.javamod.xeroc.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.javamod.xeroc.entity.animations.ModAnimationDefinitions;
import net.javamod.xeroc.entity.custom.AlienEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class AlienModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart alien;
    public AlienModel(ModelPart root) {
        this.alien = root.getChild("alien");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition alien = partdefinition.addOrReplaceChild("alien", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = alien.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body_base = body.addOrReplaceChild("body_base", CubeListBuilder.create().texOffs(22, 0).addBox(-4.0F, -6.9995F, -1.0771F, 8.0F, 5.0F, 2.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0005F, 4.2771F));

        PartDefinition body_base_r1 = body_base.addOrReplaceChild("body_base_r1", CubeListBuilder.create().texOffs(0, 17).addBox(-4.0F, -2.9F, -0.8F, 8.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.2202F, -0.701F, 0.1309F, 0.0F, 0.0F));

        PartDefinition body_base_r2 = body_base.addOrReplaceChild("body_base_r2", CubeListBuilder.create().texOffs(0, 9).addBox(-4.0F, -2.7F, -1.8F, 8.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5005F, 0.2229F, -0.1309F, 0.0F, 0.0F));

        PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-2.0F, -7.0F, 4.0F));

        PartDefinition right_foot = right_leg.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(12, 24).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.5F, -0.5F));

        PartDefinition upper_right_leg = right_leg.addOrReplaceChild("upper_right_leg", CubeListBuilder.create(), PartPose.offset(-2.0F, 7.0F, -4.0F));

        PartDefinition upper_right_leg_r1 = upper_right_leg.addOrReplaceChild("upper_right_leg_r1", CubeListBuilder.create().texOffs(16, 29).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -5.5F, 4.5F, 0.0873F, 0.0F, 0.0F));

        PartDefinition lower_right_leg = right_leg.addOrReplaceChild("lower_right_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 2.7502F, 0.5044F));

        PartDefinition lower_right_leg_r1 = lower_right_leg.addOrReplaceChild("lower_right_leg_r1", CubeListBuilder.create().texOffs(8, 29).addBox(-1.0F, -1.7F, -1.0F, 2.0F, 3.3F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.7498F, -0.0044F, -0.0873F, 0.0F, 0.0F));

        PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, -6.8F, 4.3F));

        PartDefinition upper_left_leg = left_leg.addOrReplaceChild("upper_left_leg", CubeListBuilder.create(), PartPose.offset(0.1F, 1.3F, 0.2F));

        PartDefinition upper_left_leg_r1 = upper_left_leg.addOrReplaceChild("upper_left_leg_r1", CubeListBuilder.create().texOffs(0, 29).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition lower_left_leg = left_leg.addOrReplaceChild("lower_left_leg", CubeListBuilder.create(), PartPose.offset(0.1F, 4.3F, 0.2F));

        PartDefinition lower_left_leg_r1 = lower_left_leg.addOrReplaceChild("lower_left_leg_r1", CubeListBuilder.create().texOffs(24, 24).addBox(-1.0F, -1.7F, -1.0F, 2.0F, 3.3F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

        PartDefinition left_foot = left_leg.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.1F, 6.3F, -0.8F));

        PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition left_arm = arms.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(4.0F, -16.5F, 4.3F));

        PartDefinition upper_left_arm = left_arm.addOrReplaceChild("upper_left_arm", CubeListBuilder.create().texOffs(30, 32).addBox(4.0F, -17.0F, 4.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 16.5F, -4.3F));

        PartDefinition middle_left_arm = left_arm.addOrReplaceChild("middle_left_arm", CubeListBuilder.create(), PartPose.offset(-4.0F, 16.5F, -4.3F));

        PartDefinition middle_left_arm_r1 = middle_left_arm.addOrReplaceChild("middle_left_arm_r1", CubeListBuilder.create().texOffs(32, 26).addBox(-0.1565F, -0.5F, -0.005F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.3515F, -16.5F, 4.2515F, 0.0F, 0.7854F, 0.0F));

        PartDefinition lower_left_arm = left_arm.addOrReplaceChild("lower_left_arm", CubeListBuilder.create(), PartPose.offset(-4.0F, 16.5F, -4.3F));

        PartDefinition lower_left_arm_r1 = lower_left_arm.addOrReplaceChild("lower_left_arm_r1", CubeListBuilder.create().texOffs(31, 28).addBox(0.0F, -0.5F, 0.2F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.9728F, -16.5F, 3.0301F, 0.0F, 1.5708F, 0.0F));

        PartDefinition left_hand = left_arm.addOrReplaceChild("left_hand", CubeListBuilder.create(), PartPose.offset(-4.0F, 16.5F, -4.3F));

        PartDefinition left_hand_r1 = left_hand.addOrReplaceChild("left_hand_r1", CubeListBuilder.create().texOffs(24, 31).addBox(1.5F, -1.0F, -2.2F, 1.5F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.7728F, -16.5F, 1.5301F, 0.0F, 1.5708F, 0.0F));

        PartDefinition right_arm = arms.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.7F, -16.4F, 4.4F, 0.0F, 0.0F, -3.1416F));

        PartDefinition upper_right_arm = right_arm.addOrReplaceChild("upper_right_arm", CubeListBuilder.create().texOffs(29, 30).addBox(4.0F, -17.0F, 4.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.3F, 16.4F, -4.4F));

        PartDefinition middle_right_arm = right_arm.addOrReplaceChild("middle_right_arm", CubeListBuilder.create(), PartPose.offset(-4.3F, 16.4F, -4.4F));

        PartDefinition middle_right_arm_r1 = middle_right_arm.addOrReplaceChild("middle_right_arm_r1", CubeListBuilder.create().texOffs(30, 24).addBox(-1.5F, -0.5F, -1.7F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.5F, -16.5F, 4.5F, 0.0F, 0.7854F, 0.0F));

        PartDefinition lower_right_arm = right_arm.addOrReplaceChild("lower_right_arm", CubeListBuilder.create(), PartPose.offset(-4.3F, 16.4F, -4.4F));

        PartDefinition lower_right_arm_r1 = lower_right_arm.addOrReplaceChild("lower_right_arm_r1", CubeListBuilder.create().texOffs(22, 29).addBox(-1.5F, -0.5F, -1.6F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.7728F, -16.5F, 1.5301F, 0.0F, 1.5708F, 0.0F));

        PartDefinition right_hand = right_arm.addOrReplaceChild("right_hand", CubeListBuilder.create(), PartPose.offset(-4.3F, 16.4F, -4.4F));

        PartDefinition right_hand_r1 = right_hand.addOrReplaceChild("right_hand_r1", CubeListBuilder.create().texOffs(8, 24).addBox(1.5F, -1.0F, -2.2F, 1.5F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.7728F, -16.5F, 1.5301F, 0.0F, 1.5708F, 0.0F));

        PartDefinition head = alien.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -3.0F, -0.1667F, 8.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(22, 20).addBox(-4.0F, -3.0F, -1.1667F, 8.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 12).addBox(-4.0F, 0.0F, -1.1667F, 8.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -23.0F, 3.1667F));

        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, -3.1667F));

        PartDefinition upperjaw = jaw.addOrReplaceChild("upperjaw", CubeListBuilder.create(), PartPose.offset(0.0F, -25.8646F, 2.4818F));

        PartDefinition upperjaw_r1 = upperjaw.addOrReplaceChild("upperjaw_r1", CubeListBuilder.create().texOffs(21, 16).addBox(-4.0F, -1.5F, -0.7F, 8.0F, 3.5F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.3646F, -0.9818F, -0.7854F, 0.0F, 0.0F));

        PartDefinition lowerjaw = jaw.addOrReplaceChild("lowerjaw", CubeListBuilder.create(), PartPose.offset(0.0F, -20.2301F, 2.4172F));

        PartDefinition lowerjaw_r1 = lowerjaw.addOrReplaceChild("lowerjaw_r1", CubeListBuilder.create().texOffs(21, 8).addBox(-4.0F, 0.2F, -2.8F, 8.0F, 3.4F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.2699F, -0.9172F, 0.7854F, 0.0F, 0.0F));

        PartDefinition righteye = head.addOrReplaceChild("righteye", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, -3.1667F));

        PartDefinition right_lower_eyestock = righteye.addOrReplaceChild("right_lower_eyestock", CubeListBuilder.create().texOffs(1, 1).addBox(-0.25F, -1.0F, -0.25F, 0.5F, 2.0F, 0.5F, new CubeDeformation(0.0F)), PartPose.offset(-2.25F, -27.0F, 4.75F));

        PartDefinition right_upper_eyestock = righteye.addOrReplaceChild("right_upper_eyestock", CubeListBuilder.create().texOffs(0, 1).addBox(-0.25F, -1.0F, -0.25F, 0.5F, 2.0F, 0.5F, new CubeDeformation(0.0F)), PartPose.offset(-2.25F, -29.0F, 4.75F));

        PartDefinition right_eye = righteye.addOrReplaceChild("right_eye", CubeListBuilder.create().texOffs(10, 34).addBox(-0.75F, -0.75F, -0.75F, 1.5F, 1.5F, 1.5F, new CubeDeformation(0.0F)), PartPose.offset(-2.25F, -30.75F, 4.75F));

        PartDefinition lefteye = head.addOrReplaceChild("lefteye", CubeListBuilder.create(), PartPose.offset(3.6F, 23.0F, -3.1667F));

        PartDefinition left_lower_eyestock = lefteye.addOrReplaceChild("left_lower_eyestock", CubeListBuilder.create().texOffs(0, 1).addBox(-1.5F, -28.0F, 4.5F, 0.5F, 2.0F, 0.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition left_upper_eyestock = lefteye.addOrReplaceChild("left_upper_eyestock", CubeListBuilder.create().texOffs(1, 1).addBox(-1.5F, -30.0F, 4.5F, 0.5F, 2.0F, 0.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition left_eye = lefteye.addOrReplaceChild("left_eye", CubeListBuilder.create().texOffs(17, 34).addBox(-0.75F, -0.75F, -0.75F, 1.5F, 1.5F, 1.5F, new CubeDeformation(0.0F)), PartPose.offset(-1.2975F, -30.75F, 4.571F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animateWalk(ModAnimationDefinitions.ALIEN_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);

        this.animate(((AlienEntity) entity).idleAnimationState, ModAnimationDefinitions.ALIEN_IDLE, ageInTicks, 1f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        alien.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

	@Override
	public ModelPart root() {
		return alien;
	}
}