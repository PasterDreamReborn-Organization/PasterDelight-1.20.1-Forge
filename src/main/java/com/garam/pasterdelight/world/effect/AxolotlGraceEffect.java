package com.garam.pasterdelight.world.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.common.ForgeMod;

public class AxolotlGraceEffect extends MobEffect {
    private static final String SWIM_SPEED_MODIFIER_UUID = "2368a80d-4aa7-4244-9927-8a744040369d";
    private static final double SWIM_SPEED_BONUS = 4.0;

    public AxolotlGraceEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xF48FB1);
        addAttributeModifier(
                ForgeMod.SWIM_SPEED.get(),
                SWIM_SPEED_MODIFIER_UUID,
                SWIM_SPEED_BONUS,
                AttributeModifier.Operation.MULTIPLY_TOTAL
        );
    }
}
