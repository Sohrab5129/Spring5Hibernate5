package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterCollect {

	public static void main(String[] args) {

		// Streams filter() and collect()
		List<String> list = Arrays.asList("Sohrab", "Shah", "Husain");

		List<String> result = list.stream() // convert list to stream
				// collect the output and convert
				// streams to a List
				.filter(line -> !"Husain".equals(line)).collect(Collectors.toList());

		result.forEach(System.out::println);

		// Streams filter(), findAny() and orElse()

		List<Person> persons = Arrays.asList(new Person("mkyong", 30), new Person("jack", 20),
				new Person("lawrence", 40));

		Person result1 = persons.stream() // Convert to steam
				.filter(x -> "jack".equals(x.getName())) // we want "jack" only
				.findAny() // If 'findAny' then return found
				.orElse(null); // If not found, return null

		System.out.println(result1);

		Person result2 = persons.stream().filter(x -> "ahmook".equals(x.getName())).findAny().orElse(null);

		System.out.println(result2);

		//

		Person result4 = persons.stream().filter((p) -> "jack".equals(p.getName()) && 20 == p.getAge()).findAny()
				.orElse(null);

		System.out.println("result 1 :" + result4);

		// or like this
		Person result3 = persons.stream().filter(p -> {
			if ("jack".equals(p.getName()) && 20 == p.getAge()) {
				return true;
			}
			return false;
		}).findAny().orElse(null);

		System.out.println("result 2 :" + result3);

		new FilterCollect().map();
	}

	public void map() {
		
		System.out.println("map");
		List<Person> persons = Arrays.asList(
				new Person("mkyong", 30), 
				new Person("jack", 20),
				new Person("lawrence", 40)
			);

		String name = persons.stream().filter(x -> "jack".equals(x.getName()))
				.map(Person::getName) // convert stream to																								// String
				.findAny().orElse("");

		System.out.println("name : " + name);

		List<String> collect = persons.stream()
				.map(Person::getName).collect(Collectors.toList());

		collect.forEach(System.out::println);
	}

}
