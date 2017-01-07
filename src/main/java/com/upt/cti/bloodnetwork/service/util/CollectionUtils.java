package com.upt.cti.bloodnetwork.service.util;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionUtils {

	private CollectionUtils() {}
	
	@SafeVarargs
	public static <K, V> Map<K, V> pairsToMap(Pair<K, V>... pairs) {
		return Arrays
				.stream(pairs)
				.collect(Collectors.toMap(Pair::getFirst, Pair::getSecond));
	}
}
