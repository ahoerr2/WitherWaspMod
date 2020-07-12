package com.ahoerr1.witherwasp.client.entity.render;

import com.ahoerr1.witherwasp.WitherWasp;
import com.ahoerr1.witherwasp.client.entity.model.WaspEntityModel;
import com.ahoerr1.witherwasp.entities.WaspEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class WaspRenderHandler extends MobRenderer<WaspEntity, WaspEntityModel<WaspEntity>> {

    protected static final ResourceLocation TEXTURES = new ResourceLocation(WitherWasp.MODID,"textures/entity/wither_wasp.png");

    public WaspRenderHandler(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new WaspEntityModel<>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(WaspEntity entity) {
        return TEXTURES;
    }

}
