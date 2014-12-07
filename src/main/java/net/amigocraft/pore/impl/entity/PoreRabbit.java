package net.amigocraft.pore.impl.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.animal.Rabbit;

public class PoreRabbit extends PoreAnimals implements org.bukkit.entity.Rabbit {

    private static TypeConverter<Rabbit, PoreRabbit> converter;

    @SuppressWarnings("unchecked")
    static TypeConverter<Rabbit, PoreRabbit> getRabbitConverter() {
        if (converter == null) {
            converter = new TypeConverter<Rabbit, PoreRabbit>() {
                @Override
                protected PoreRabbit convert(Rabbit handle) {
                    return new PoreRabbit(handle);
                }
            };
        }
        return converter;
    }

    protected PoreRabbit(Rabbit handle) {
        super(handle);
    }

    public static PoreRabbit of(Rabbit rabbit) {
        return getRabbitConverter().apply(rabbit);
    }

    @Override
    public Rabbit getHandle() {
        return (Rabbit) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.RABBIT;
    }
}
