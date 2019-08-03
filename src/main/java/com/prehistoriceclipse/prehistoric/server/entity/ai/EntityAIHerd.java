package com.prehistoriceclipse.prehistoric.server.entity.ai;

import com.prehistoriceclipse.prehistoric.server.entity.EntityPrehistoric;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class EntityAIHerd extends EntityAIBase {

    private final EntityPrehistoric entity;
    private final double distance;

    public EntityAIHerd(EntityPrehistoric entity) {
        this(entity, 3);
    }

    public EntityAIHerd(EntityPrehistoric entity, double distance) {
        this.entity = entity;
        this.distance = distance;
    }

    @Override
    public boolean shouldExecute() {
        return this.entity.isEntityAlive() && this.shouldTravelToKing();
    }

    @Override
    public void updateTask() {
        EntityLiving king = this.getKing();
        double nearDistance = this.distance / 2;
        if (king != null && this.entity.getDistanceSqToEntity(king) > nearDistance * nearDistance) {
            this.entity.getMoveHelper().setMoveTo(king.posX, king.posY, king.posZ, 1.0D);
        }
        super.updateTask();
    }

    @Override
    public void resetTask() {
        super.resetTask();
    }

    @Nullable
    private EntityLiving getKing() {
        // Existing King:
        if(this.entity.kingTarget != null) {
            return this.entity.kingTarget;
        }

        // New King:
        EntityPrehistoric king = null;
        boolean foundKing = false; // Used to prioritize entities that are already marked as kings.
        for (EntityPrehistoric e : this.entity.world.getEntitiesWithinAABB(this.entity.getClass(), this.entity.getEntityBoundingBox().grow(this.distance * 2))) {
            if (king == null) {
                king = e;
                continue;
            }
            if (foundKing && !e.isKing) {
                continue;
            }
            if(e.getDistanceSqToEntity(this.entity) < king.getDistanceSqToEntity(this.entity)) {
                king = e;
                foundKing = king.isKing;
            }
        }
        if(king == null) {
            return null;
        }
        this.entity.kingTarget = king;
        this.entity.kingTarget.isKing = true;
        return king;
    }

    private boolean shouldTravelToKing() {
        // Is King:
        if(this.entity.isKing) {
            return false;
        }

        EntityLiving king = this.getKing();
        if(king == null || king == this.entity) {
            return false;
        }
        return this.entity.getDistanceSqToEntity(king) > this.distance * this.distance;
    }
}
