package com.prehistoriceclipse.prehistoric.server.entity.ai;

import java.util.Random;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
 
import com.prehistoriceclipse.prehistoric.server.init.PEItems;
import com.prehistoriceclipse.prehistoric.server.PrehistoricEclipse;
import com.prehistoriceclipse.prehistoric.server.Reference;

public class MessageFoodParticles implements IMessage {
	   public int dinosaurID;
	    public int foodItemID;
	    public int blockItemID;

	    public MessageFoodParticles(int dinosaurID) {
	        this.dinosaurID = dinosaurID;
	        foodItemID = 0;
	    }

	    public MessageFoodParticles(int dinosaurID, int foodItemID) {
	        this.dinosaurID = dinosaurID;
	        this.foodItemID = foodItemID;
	    }

	    public MessageFoodParticles(int dinosaurID, Block block) {
	        this.dinosaurID = dinosaurID;
	        this.blockItemID = Block.getIdFromBlock(block);
	    }

	    public MessageFoodParticles() {
	    }
	    
	    @SideOnly(Side.CLIENT)
	    public void onClientReceived(Minecraft client, MessageFoodParticles message, EntityPlayer player, MessageContext messageContext) {
	        Entity entity = player.world.getEntityByID(message.dinosaurID);

	        if (entity instanceof EntityExtinct) {
	        	EntityExtinct prehistoric = (EntityExtinct) entity;
	            if (message.foodItemID == 0 && message.blockItemID == 0) {
	                switch (prehistoric.type.diet) {
	                    case HERBIVORE:
	                        spawnItemParticle(prehistoric, Items.REEDS);
	                        spawnItemParticle(prehistoric, Items.REEDS);
	                        spawnItemParticle(prehistoric, Items.REEDS);
	                        spawnItemParticle(prehistoric, Items.REEDS);
	                        break;
	                    case OMNIVORE:
	                        spawnItemParticle(prehistoric, Items.BREAD);
	                        spawnItemParticle(prehistoric, Items.BREAD);
	                        spawnItemParticle(prehistoric, Items.BREAD);
	                        spawnItemParticle(prehistoric, Items.BREAD);
	                        break;
	                    default:
	                        spawnItemParticle(prehistoric, Items.BEEF);
	                        spawnItemParticle(prehistoric, Items.BEEF);
	                        spawnItemParticle(prehistoric, Items.BEEF);
	                        spawnItemParticle(prehistoric, Items.BEEF);
	                        break;

	                }
	            } else {
	                if (message.foodItemID != 0) {
	                    spawnItemParticle(prehistoric, Item.getItemById(message.foodItemID));
	                    spawnItemParticle(prehistoric, Item.getItemById(message.foodItemID));
	                    spawnItemParticle(prehistoric, Item.getItemById(message.foodItemID));
	                    spawnItemParticle(prehistoric, Item.getItemById(message.foodItemID));
	                }
	                if (message.blockItemID != 0) {
	                    spawnBlockParticle(prehistoric, Block.getBlockById(message.blockItemID));
	                    spawnBlockParticle(prehistoric, Block.getBlockById(message.blockItemID));
	                    spawnBlockParticle(prehistoric, Block.getBlockById(message.blockItemID));
	                    spawnBlockParticle(prehistoric, Block.getBlockById(message.blockItemID));
	                    spawnBlockParticle(prehistoric, Block.getBlockById(message.blockItemID));
	                    spawnBlockParticle(prehistoric, Block.getBlockById(message.blockItemID));
	                    spawnBlockParticle(prehistoric, Block.getBlockById(message.blockItemID));
	                    spawnBlockParticle(prehistoric, Block.getBlockById(message.blockItemID));

	                }
	            }

	        }
	    }

	    public static final void spawnItemParticle(Entity entity, Item item) {
	        Random rand = new Random();
	        double motionX = rand.nextGaussian() * 0.07D;
	        double motionY = rand.nextGaussian() * 0.07D;
	        double motionZ = rand.nextGaussian() * 0.07D;
	        float f = (float) (rand.nextFloat() * (entity.getEntityBoundingBox().maxX - entity.getEntityBoundingBox().minX) + entity.getEntityBoundingBox().minX);
	        float f1 = (float) (rand.nextFloat() * (entity.getEntityBoundingBox().maxY - entity.getEntityBoundingBox().minY) + entity.getEntityBoundingBox().minY);
	        float f2 = (float) (rand.nextFloat() * (entity.getEntityBoundingBox().maxZ - entity.getEntityBoundingBox().minZ) + entity.getEntityBoundingBox().minZ);
	        PrehistoricEclipse.PROXY.spawnPacketItemParticles(entity.world, f, f1, f2, motionX, motionY, motionZ, item);
	    }

	    public static final void spawnBlockParticle(Entity entity, Block block) {
	        Random rand = new Random();
	        double motionX = rand.nextGaussian() * 0.07D;
	        double motionY = rand.nextGaussian() * 0.07D;
	        double motionZ = rand.nextGaussian() * 0.07D;
	        float f = (float) (rand.nextFloat() * (entity.getEntityBoundingBox().maxX - entity.getEntityBoundingBox().minX) + entity.getEntityBoundingBox().minX);
	        float f1 = (float) (rand.nextFloat() * (entity.getEntityBoundingBox().maxY - entity.getEntityBoundingBox().minY) + entity.getEntityBoundingBox().minY);
	        float f2 = (float) (rand.nextFloat() * (entity.getEntityBoundingBox().maxZ - entity.getEntityBoundingBox().minZ) + entity.getEntityBoundingBox().minZ);
	        PrehistoricEclipse.PROXY.spawnPacketBlockParticles(entity.world, f, f1, f2, motionX, motionY, motionZ, block);

	    }

	    public void onServerReceived(MinecraftServer server, MessageFoodParticles message, EntityPlayer player, MessageContext messageContext) {

	    }

	    public void fromBytes(ByteBuf buf) {
	        dinosaurID = buf.readInt();
	        foodItemID = buf.readInt();
	        blockItemID = buf.readInt();

	    }

	    public void toBytes(ByteBuf buf) {
	        buf.writeInt(dinosaurID);
	        buf.writeInt(foodItemID);
	        buf.writeInt(blockItemID);

	    }
}
