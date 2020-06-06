package com.ahoerr1.witherwasp.client.entity.model;

import com.ahoerr1.witherwasp.entities.WaspEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.debug.BeeDebugRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.ModelUtils;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.capabilities.CapabilityProvider;

// Made with Blockbench 3.5.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class WaspEntityModel<T extends WaspEntity> extends EntityModel<T> {
    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer abdomen;
    private final ModelRenderer leg_front;
    private final ModelRenderer leg_mid;
    private final ModelRenderer leg_back;
    private final ModelRenderer leftwing_bone;
    private final ModelRenderer rightwing_bone;
    private float bodyPitch;

    public WaspEntityModel() {
        textureWidth = 48;
        textureHeight = 48;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 25.0F, -2.0F);
        body.setTextureOffset(0, 10).addBox(-3.0F, -10.0F, -5.0F, 6.0F, 6.0F, 10.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, -9.0F, -6.0F);
        body.addChild(head);
        setRotationAngle(head, 0.5236F, 0.0F, 0.0F);
        head.setTextureOffset(0, 0).addBox(-2.5F, -0.375F, -5.7835F, 5.0F, 4.0F, 6.0F, 0.0F, false);
        head.setTextureOffset(22, 11).addBox(-1.5F, -6.3505F, -2.8F, 1.0F, 6.0F, 2.0F, 0.0F, false);
        head.setTextureOffset(23, 5).addBox(0.5F, -6.3505F, -2.8F, 1.0F, 6.0F, 2.0F, 0.0F, false);

        abdomen = new ModelRenderer(this);
        abdomen.setRotationPoint(0.0F, -9.0F, 3.0F);
        body.addChild(abdomen);
        setRotationAngle(abdomen, -0.2618F, 0.0F, 0.0F);
        abdomen.setTextureOffset(0, 26).addBox(-4.0F, -2.5176F, 1.9319F, 8.0F, 8.0F, 10.0F, 0.0F, false);
        abdomen.setTextureOffset(0, 0).addBox(0.0F, 0.9826F, 11.9193F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        leg_front = new ModelRenderer(this);
        leg_front.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(leg_front);
        leg_front.setTextureOffset(26, 27).addBox(-3.0F, -4.0F, -4.0F, 6.0F, 2.0F, 0.0F, 0.0F, false);

        leg_mid = new ModelRenderer(this);
        leg_mid.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(leg_mid);
        leg_mid.setTextureOffset(26, 29).addBox(-3.0F, -4.0F, -1.0F, 6.0F, 2.0F, 0.0F, 0.0F, false);

        leg_back = new ModelRenderer(this);
        leg_back.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(leg_back);
        leg_back.setTextureOffset(26, 31).addBox(-3.0F, -4.0F, 2.0F, 6.0F, 3.0F, 0.0F, 0.0F, false);

        leftwing_bone = new ModelRenderer(this);
        leftwing_bone.setRotationPoint(3.0F, -10.0F, -2.0F);
        body.addChild(leftwing_bone);
        setRotationAngle(leftwing_bone, -0.2618F, 0.3491F, 0.0F);
        leftwing_bone.setTextureOffset(38, 24).addBox(0.0F, -17.0F, -1.0F, 0.0F, 18.0F, 5.0F, 0.0F, false);

        rightwing_bone = new ModelRenderer(this);
        rightwing_bone.setRotationPoint(-2.0F, -10.0F, -2.0F);
        body.addChild(rightwing_bone);
        setRotationAngle(rightwing_bone, -0.2618F, -0.3491F, 0.0F);
        rightwing_bone.setTextureOffset(38, 0).addBox(-0.9397F, -17.0885F, -0.6696F, 0.0F, 18.0F, 5.0F, 0.0F, true);
    }

    public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
        this.bodyPitch = entityIn.getBodyPitch(partialTick);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.rightwing_bone.rotateAngleX = 0.0F;
        this.body.rotateAngleX = 0.0F;
        this.body.rotationPointY = 19.0F;
        boolean flag = entityIn.onGround && entityIn.getMotion().lengthSquared() < 1.0E-7D;
        if (flag) {
            this.rightwing_bone.rotateAngleY = -0.2618F;
            this.rightwing_bone.rotateAngleZ = 0.0F;
            this.leftwing_bone.rotateAngleX = 0.0F;
            this.leftwing_bone.rotateAngleY = 0.2618F;
            this.leftwing_bone.rotateAngleZ = 0.0F;
            this.leg_front.rotateAngleX = 0.0F;
            this.leg_mid.rotateAngleX = 0.0F;
            this.leg_back.rotateAngleX = 0.0F;
        } else {
            float f = ageInTicks * 2.1F;
            this.rightwing_bone.rotateAngleY = 0.0F;
            this.rightwing_bone.rotateAngleZ = MathHelper.cos(f) * (float)Math.PI * 0.15F;
            this.leftwing_bone.rotateAngleX = this.rightwing_bone.rotateAngleX;
            this.leftwing_bone.rotateAngleY = this.rightwing_bone.rotateAngleY;
            this.leftwing_bone.rotateAngleZ = -this.rightwing_bone.rotateAngleZ;
            this.leg_front.rotateAngleX = ((float)Math.PI / .06F);
            this.leg_mid.rotateAngleX = ((float)Math.PI / .6F);
            this.leg_back.rotateAngleX = ((float)Math.PI / .6F);
            this.body.rotateAngleX = 0.0F;
            this.body.rotateAngleY = 0.0F;
            this.body.rotateAngleZ = 0.0F;
        }

        if (!entityIn.isAngry()) {
            this.body.rotateAngleX = 0.0F;
            this.body.rotateAngleY = 0.0F;
            this.body.rotateAngleZ = 0.0F;
            if (!flag) {
                float f1 = MathHelper.cos(ageInTicks * 0.18F);
                this.body.rotateAngleX = 0.1F + f1 * (float)Math.PI * 0.025F;
                this.leg_front.rotateAngleX = -f1 * (float)Math.PI * 0.1F + ((float)Math.PI / 8F);
                this.leg_back.rotateAngleX = -f1 * (float)Math.PI * 0.05F + ((float)Math.PI / 4F);
                this.body.rotationPointY = 19.0F - MathHelper.cos(ageInTicks * 0.18F) * 0.9F;
            }
        }

        if (this.bodyPitch > 0.0F) {
            this.body.rotateAngleX = ModelUtils.func_228283_a_(this.body.rotateAngleX, 3.0915928F, this.bodyPitch);
        }
    }





    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
    }
}
