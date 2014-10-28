package net.amigocraft.pore.util;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

public class PoreCollections {

	public static <F, T> List<T> transformToList(Collection<F> from, Function<? super F, ? extends T> function) {
		// If we have a list already we can transform it directly
		if (from instanceof List) {
			return Lists.transform((List<F>) from, function);
		}

		// There is no other good way than copying everything, meh
		List<T> result = Lists.newArrayListWithCapacity(from.size());
		for (F element : from)
			result.add(function.apply(element));
		return result;
	}
}
