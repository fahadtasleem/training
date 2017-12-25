package learn.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println(filtered);
		strings.forEach(System.out::println);
		System.out.println(strings.stream().map((s)->s+"he").collect(Collectors.toList()));
		System.out.println(strings.stream().limit(3).collect(Collectors.toList()));
		System.out.println(strings.stream().sorted().collect(Collectors.toList()));
		System.out.println(strings.stream().reduce("REDUCED-", (a,b)->a+b));
		System.out.println(strings.parallelStream().reduce("PARALLEL-REDUCED-", (a,b)->a+b));
		
		System.out.println(strings.stream().filter((string)->string.isEmpty()).count());
		System.out.println(strings.parallelStream().filter((string)->string.isEmpty()).count());
		
		IntSummaryStatistics stats = strings.stream().mapToInt((x) -> x.length()).summaryStatistics();
		
		System.out.println("Longest str in List : " + stats.getMax());
		System.out.println("shortest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());
	}
}
