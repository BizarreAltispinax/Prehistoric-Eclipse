package com.prehistoriceclipse.prehistoric.server.entity.ai;

import com.prehistoriceclipse.prehistoric.server.entity.aquatic.EntityAquatic;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.math.Vec3d;

public class EntityAISwim extends EntityAIBase {
    private EntityAquatic swimmingEntity;
    private double xPosition;
    private double yPosition;
    private double zPosition;

    public EntityAISwim(EntityAquatic entity) {
        this.swimmingEntity = entity;
        this.setMutexBits(4);

        if (entity.getNavigator() instanceof PathNavigateGround)
        {
            ((PathNavigateGround)entity.getNavigator()).setCanSwim(true);
        }
        else if (entity.getNavigator() instanceof PathNavigateFlying)
        {
            ((PathNavigateFlying)entity.getNavigator()).setCanFloat(true);
        }
    }

	@Override
    public boolean shouldExecute() {
        if (this.swimmingEntity.getRNG().nextFloat() < 0.50) {
            return false;
        }
        Vec3d target = RandomPositionGenerator.findRandomTarget(this.swimmingEntity, 6, 10);
        if (target == null) {
            return false;
        } else {
            this.xPosition = target.x;
            this.yPosition = target.y;
            this.zPosition = target.z;
            return true;
        }
    }
	
    public void updateTask()
    {
        if (this.swimmingEntity.getRNG().nextFloat() < 0.8F);
    }
    
    @Override
    public boolean shouldContinueExecuting() {
        return !this.swimmingEntity.getNavigator().noPath();
    }

    @Override
    public void startExecuting() {
        this.swimmingEntity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, 1.0D);
    }
}
