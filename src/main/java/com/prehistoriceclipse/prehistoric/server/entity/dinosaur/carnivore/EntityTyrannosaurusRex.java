package com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore;

import com.google.common.base.Predicate;
import com.prehistoriceclipse.prehistoric.server.Reference;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIDinoMate;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAICall;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIEat;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIStartle;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.EntityDinosaur;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore.*;
import com.prehistoriceclipse.prehistoric.server.init.PEItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityTyrannosaurusRex extends EntityCarnivore {

    public EntityTyrannosaurusRex(World worldIn) {
        super(worldIn);
        this.setSize(3.5F, 5.0F);
    }
    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.aiCall = new EntityAICall(this);
        this.aiEat = new EntityAIEat(this);
        this.aiStartle = new EntityAIStartle(this);
        this.tasks.addTask(2, this.aiEat);
        this.tasks.addTask(3, this.aiCall);
        this.tasks.addTask(7, new EntityAIDinoMate(this, 1.0D));
        this.tasks.addTask(8, this.aiStartle);
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityPlayer.class, 25.0F));
        this.targetTasks.addTask(5, new EntityAITargetNonTamed(this, EntityDinosaur.class, true, new Predicate<Entity>() {
            public boolean apply(@Nullable Entity entity) {
                return entity instanceof EntityDakotaraptor || entity instanceof EntityMonolophosaurus || entity instanceof EntityPlateosaurus || entity instanceof EntityPig || entity instanceof EntitySheep || entity instanceof EntityCow || entity instanceof EntityProtoceratops || entity instanceof EntityTitanoceratops || entity instanceof EntityPachycephalosaurus || entity instanceof EntityTherizinosaurus;
            }
        }));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(44.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(14.0D);
    }

    @Override
    public EntityTyrannosaurusRex createChild(EntityAgeable ageable) {
        return new EntityTyrannosaurusRex(this.world);
    }
    public void applyEntityAttributesBonus()
    {
        if (this.isChild())
        {
        	super.applyEntityAttributes();
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.149D);
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
            this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
        }
    }
    @Override
    public ResourceLocation getDefaultTexture() {
        return new ResourceLocation(Reference.MOD_ID + ":models/entity/trex/rex.png");
    }
    
	@Override
	  protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier){
		  this.dropItem(PEItems.REX_MEAT, 1);
	    }
}
