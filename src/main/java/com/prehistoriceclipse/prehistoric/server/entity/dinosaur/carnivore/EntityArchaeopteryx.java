package com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore;

import com.prehistoriceclipse.prehistoric.server.Reference;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIDinoMate;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIEat;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIRunFromEntity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityArchaeopteryx extends EntityCarnivore {

    private static final DataParameter<Byte> CLIMBING = EntityDataManager.<Byte>createKey(EntityDakotaraptor.class, DataSerializers.BYTE);
    
    public EntityArchaeopteryx(World world){
        super(world);
        this.setSize(0.3F, 0.3F);
    }

    @Override
    protected void initEntityAI()
    {
        super.initEntityAI();
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityTyrannosaurusRex.class, 30.0F, 1.5D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntitySpinosaurus.class, 30.0F, 1.5D));
        this.aiEat = new EntityAIEat(this);
        this.tasks.addTask(2, this.aiEat);
        this.tasks.addTask(7, new EntityAIDinoMate(this, 1.0D));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
        
    }

    @Override
    public EntityArchaeopteryx createChild(EntityAgeable ageable){
        return new EntityArchaeopteryx(this.world);
    }

    @Override
    public ResourceLocation getDefaultTexture(){
        return new ResourceLocation(Reference.MOD_ID, "models/entity/archaeo/male.png");
    }
    
	 public double getMountedYOffset()
	    {
	        return (double)(this.height * 0.5F);
	    }
	protected PathNavigate createNavigator(World worldIn)
	{
	return new PathNavigateClimber(this, worldIn);
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataManager.register(CLIMBING, Byte.valueOf((byte)0));
	}

	public boolean isOnLadder()
	{
	return this.isBesideClimbableBlock();
	}

	public boolean isBesideClimbableBlock()
	{
	return (((Byte)this.dataManager.get(CLIMBING)).byteValue() & 1) != 0;
	}

	public void setInWeb()
	{
	}

	public void setBesideClimbableBlock(boolean climbing)
	{
		byte b0 = ((Byte)this.dataManager.get(CLIMBING)).byteValue();

		if (climbing)
		{
			b0 = (byte)(b0 | 1);
		}
		else
		{
			b0 = (byte)(b0 & -2);
		}

		this.dataManager.set(CLIMBING, Byte.valueOf(b0));
	}

	public EnumCreatureAttribute getCreatureAttribute()
	    {
	        return EnumCreatureAttribute.ARTHROPOD;
	    }

	@Override
	public float getFallResistance() {
		return 100;
	}

	@Override
	public double getFallingMod() {
		return 0.9D;
	}
}
