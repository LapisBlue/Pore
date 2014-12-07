package net.amigocraft.pore.impl.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.monster.Endermite;

public class PoreEndermite extends PoreMonster implements org.bukkit.entity.Endermite {

    private static TypeConverter<Endermite, PoreEndermite> converter;

    @SuppressWarnings("unchecked")
    static TypeConverter<Endermite, PoreEndermite> getEndermiteConverter() {
        if (converter == null) {
            converter = new TypeConverter<Endermite, PoreEndermite>() {
                @Override
                protected PoreEndermite convert(Endermite handle) {
                    return new PoreEndermite(handle);
                }
            };
        }
        return converter;
    }

    protected PoreEndermite(Endermite handle) {
        super(handle);
    }

    public static PoreEndermite of(Endermite rabbit) {
        return getEndermiteConverter().apply(rabbit);
    }

    @Override
    public Endermite getHandle() {
        return (Endermite) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.ENDERMITE;
    }


}
