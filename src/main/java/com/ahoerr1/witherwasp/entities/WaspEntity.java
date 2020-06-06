package com.ahoerr1.witherwasp.entities;

import net.minecraft.entity.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class WaspEntity extends BeeEntity {


    public WaspEntity(EntityType<? extends BeeEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue((double)1.8F);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.9F);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(98.0D);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = entityIn.attackEntityFrom(DamageSource.func_226252_a_(this), (float)((int)this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue()));
        if (flag) {
            this.applyEnchantments(this, entityIn);
            if (entityIn instanceof LivingEntity) {
                ((LivingEntity)entityIn).setBeeStingCount(((LivingEntity)entityIn).getBeeStingCount() + 1);
                int i = 0;
                if (this.world.getDifficulty() == Difficulty.NORMAL) {
                    i = 10;
                } else if (this.world.getDifficulty() == Difficulty.HARD) {
                    i = 18;
                }

                if (i > 0) {
                    //((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.POISON, i * 20, 0));
                }
            }

            this.setAttackTarget((LivingEntity)null);
            this.playSound(SoundEvents.ENTITY_BEE_STING, 1.0F, 1.0F);
        }

        return flag;
    }
}
