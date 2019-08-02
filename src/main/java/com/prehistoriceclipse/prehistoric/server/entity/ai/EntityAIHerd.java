package com.prehistoriceclipse.prehistoric.server.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

import java.util.HashMap;
import java.util.Map;

public class EntityAIHerd extends EntityAIBase {

    private static final Map<Class<? extends EntityLiving>, EntityLiving> KINGS = new HashMap<>();
    private final EntityLiving entity;
    private final double distance;

    public EntityAIHerd(EntityLiving entity) {
        this(entity, 3);
    }

    public EntityAIHerd(EntityLiving entity, double distance) {
        this.entity = entity;
        this.distance = distance;
    }

    @Override
    public boolean shouldExecute() {
        return entity.isEntityAlive();
    }

    @Override
    public void updateTask() {
        EntityLiving found = null;
        for (EntityLiving e : entity.world.getEntitiesWithinAABB(entity.getClass(), entity.getEntityBoundingBox().grow(18))) if (found == null || e.getDistanceSqToEntity(entity) < found.getDistanceSqToEntity(entity)) found = e;
        if (found != null) if (!KINGS.containsKey(this.entity.getClass())) KINGS.put(entity.getClass(), found);
        EntityLiving king = KINGS.get(this.entity.getClass());
        if (king != entity && king != null && entity.getDistanceSqToEntity(king) > distance*distance) entity.getMoveHelper().setMoveTo(king.posX, king.posY, king.posZ, 1.0D);
        super.updateTask();
    }
}
