package com.garam.pasterdelight.event;

import com.garam.pasterdelight.init.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.UUID;

public class AxolotlGraceHandler
{
    private static final UUID RAIN_SPEED_MODIFIER_UUID = UUID.fromString("71d69a91-05b0-493c-8327-8066293757ec");

    private static final double SPEED_BONUS_PER_LEVEL = 0.2;

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event)
    {
        LivingEntity entity = event.getEntity();
        if (entity.level().isClientSide)
        {
            return;
        }

        AttributeInstance speed = entity.getAttribute(Attributes.MOVEMENT_SPEED);
        if (speed == null)
        {
            return;
        }
        MobEffectInstance grace = entity.getEffect(ModEffects.AXOLOTL_GRACE.get());
        boolean shouldBoost = grace != null && entity.level().isRaining();
        AttributeModifier existing = speed.getModifier(RAIN_SPEED_MODIFIER_UUID);

        if (shouldBoost)
        {
            double amount = SPEED_BONUS_PER_LEVEL * (grace.getAmplifier() + 1);
            if (existing == null || existing.getAmount() != amount)
            {
                speed.removeModifier(RAIN_SPEED_MODIFIER_UUID);
                speed.addTransientModifier(new AttributeModifier(
                        RAIN_SPEED_MODIFIER_UUID,
                        "axolotl_grace_rain_speed",
                        amount,
                        AttributeModifier.Operation.MULTIPLY_TOTAL
                ));
            }
        }
        else if (existing != null)
        {
            speed.removeModifier(RAIN_SPEED_MODIFIER_UUID);
        }
    }
}
