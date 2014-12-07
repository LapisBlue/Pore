package net.amigocraft.pore.impl.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.monster.Guardian;

public class PoreGuardian extends PoreMonster implements org.bukkit.entity.Guardian {

    private static TypeConverter<Guardian, PoreGuardian> converter;

    @SuppressWarnings("unchecked")
    static TypeConverter<Guardian, PoreGuardian> getGuardianConverter() {
        if (converter == null) {
            converter = new TypeConverter<Guardian, PoreGuardian>() {
                @Override
                protected PoreGuardian convert(Guardian handle) {
                    return new PoreGuardian(handle);
                }
            };
        }
        return converter;
    }

    protected PoreGuardian(Guardian handle) {
        super(handle);
    }

    public static PoreGuardian of(Guardian rabbit) {
        return getGuardianConverter().apply(rabbit);
    }

    @Override
    public Guardian getHandle() {
        return (Guardian) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.GUARDIAN;
    }


}
