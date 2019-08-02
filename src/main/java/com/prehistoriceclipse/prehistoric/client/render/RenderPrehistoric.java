package com.prehistoriceclipse.prehistoric.client.render;

import com.dabigjoe.obsidianAPI.render.RenderAnimated;
import com.prehistoriceclipse.prehistoric.client.model.ModelPrehistoric;
import com.prehistoriceclipse.prehistoric.server.entity.EntityEgg;
import com.prehistoriceclipse.prehistoric.server.entity.EntityPrehistoric;
import com.prehistoriceclipse.prehistoric.server.entity.aquatic.*;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore.*;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore.*;
import com.prehistoriceclipse.prehistoric.server.entity.flying.*;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderPrehistoric extends RenderAnimated {

    private ModelPrehistoric model;

    public RenderPrehistoric(ModelPrehistoric model) {
        super(model, 0.8F);
        this.model = model;
    }

    public RenderPrehistoric(ModelPrehistoric model, float shadowSize) {
        super(model, shadowSize);
        this.model = model;
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entity, float partialTickTime) {
        super.preRenderCallback(entity, partialTickTime);
        
        double scaleFactor = 1.0D;
        if(entity instanceof EntityDakotaraptor){
            scaleFactor = 0.8D;
            if(((EntityDakotaraptor) entity).isSitting()){
                GlStateManager.translate(0, -1F, 0);
            }
        } else if(entity instanceof EntityPlesiosaurus){
            scaleFactor = 0.50D;
        }  else if(entity instanceof EntityTitanoceratops) {
            scaleFactor = 1.45D;
        } else if(entity instanceof EntityVelociraptor){
            scaleFactor = 0.4D;
        } else if(entity instanceof EntityEgg){
            scaleFactor = 0.1D;
        } else if(entity instanceof EntityDunkleosteus){
            GlStateManager.translate(0, 1.5F, 1);
            scaleFactor = 1.5D;
        } else if(entity instanceof EntityArthropleura){
            GlStateManager.translate(0, 0, -1F);
            scaleFactor = 1.5D;
        } else if(entity instanceof EntityMonolophosaurus){
            GlStateManager.translate(0F, 0F, 0F);
            scaleFactor = 0.8D;
        } else if(entity instanceof EntitySaurichthys){
            GlStateManager.translate(0, 0.4F, 0);
            scaleFactor = 0.50D;
        } else if(entity instanceof EntityTyrannosaurusRex){
            GlStateManager.translate(0, 2.8F, 0);
            scaleFactor = 3.3D;
        } else if(entity instanceof EntitySeaScorpion){
            GlStateManager.translate(0, 0F, 0);
            scaleFactor = 1.0D;
        } else if (entity instanceof EntityPachycephalosaurus) {
            scaleFactor = 0.5D;
        } else if (entity instanceof EntityDragonfly) {
            scaleFactor = 0.55D;
            GlStateManager.translate(0, 0.0F, 0);
        } else if (entity instanceof EntityTupandactylus) {
            GlStateManager.translate(0, 0.68F, 0);
        } else if (entity instanceof EntityAllosaurus){
            GlStateManager.translate(0, 1.8F, 0);
            scaleFactor = 2.3D;
        } else if (entity instanceof EntitySauroposeidon) {
            GlStateManager.translate(0, 2.0F, 0);
            scaleFactor = 2.5D;
        } else if (entity instanceof EntityOnchopristis) {
            GlStateManager.translate(0, 1.0F, 0);
        } else if (entity instanceof EntityMawsonia) {
            GlStateManager.translate(0, 0F, -1F);
        } else if (entity instanceof EntityAmmonite) {
            GlStateManager.translate(0, 1F, 0F);
            scaleFactor = 1.5D;
        } else if(entity instanceof EntityCeratosaurus){
            GlStateManager.translate(0, 0.0F, 0);
            scaleFactor = 1.3D;
        } else if(entity instanceof EntityTherizinosaurus){
            GlStateManager.translate(0, 0.0F, 0);
            scaleFactor = 1.6D;
        } else if(entity instanceof EntitySpinosaurus){
            GlStateManager.translate(0, 0F, 0);
            scaleFactor = 2.0D;
        } else if(entity instanceof EntityArchaeopteryx){
            GlStateManager.translate(0, 0F, 0);
            scaleFactor = 0.2D;
        }

    
        GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
        if(entity instanceof EntityAgeable){
            EntityAgeable ageable = (EntityAgeable)entity;
            if(entity.isChild()){
                GlStateManager.scale(0.2F, 0.2F, 0.2F);
                if (entity instanceof EntityTyrannosaurusRex || entity instanceof EntityDunkleosteus || entity instanceof EntityAllosaurus || entity instanceof EntitySauroposeidon || entity instanceof EntityMawsonia || entity instanceof EntityTupandactylus || entity instanceof EntitySaurichthys || entity instanceof EntityAmmonite) {
                    GlStateManager.translate(0, -3F, 0);
                }
            } else {
                GlStateManager.scale(1.0F, 1.0F, 1.0F);
            }
          }
       }     

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        if (entity instanceof EntityPrehistoric) {
            EntityPrehistoric dinosaur = (EntityPrehistoric) entity;
            if (dinosaur.getVariant() == 1) {
                model.setTexture(dinosaur.getVariantTexture());
                return dinosaur.getVariantTexture();
            }
            model.setTexture(dinosaur.getDefaultTexture());
            return dinosaur.getDefaultTexture();
        }
        return null;
    }
}
