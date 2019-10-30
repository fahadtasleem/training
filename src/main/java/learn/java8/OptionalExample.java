package learn.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class OptionalExample {

	static enum DAYS {SUN,MON,TUE};
	public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
		if (c.isEmpty())
			return Optional.empty();
		E result = null;
		for (E e : c)
			if (result == null || e.compareTo(result) > 0)
				result = Objects.requireNonNull(e);
		return Optional.of(result);
	}
//	static Integer i;
	public static void main(String[] args) {
//		if(i==0) {
//			
//		}
		Optional<String> a = max(Arrays.asList("a","b","v"));
		System.out.println(a.orElse("pl"));
		a = max(Collections.EMPTY_LIST);
		System.out.println(a.orElse("nj"));
		System.out.println(ThreadLocalRandom.current().nextInt(0, 100));
		Map<DAYS, String> mp = new HashMap<>();
		mp.put(DAYS.MON, "mon");
		System.out.println(mp.get(DAYS.MON));
		Map<DAYS, String> emp = new EnumMap<DAYS, String>(DAYS.class);
		emp.put(DAYS.MON, "mon");
		System.out.println(emp.get(DAYS.MON));
	}
}
