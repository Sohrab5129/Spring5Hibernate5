package java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEach {

	public static void main(String[] args) {

		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

		for (Map.Entry<String, Integer> entry : items.entrySet()) {
			//System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
		}
		
		//items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
		
		items.forEach((k,v)->{
			System.out.println("Item : " + k + " Count : " + v);
			if("E".equals(k)){
				System.out.println("Hello E");
			}
		});
		
		//list
		
		List<String> item = new ArrayList<>();
		item.add("A");
		item.add("B");
		item.add("C");
		item.add("D");
		item.add("E");

		//lambda
		//Output : A,B,C,D,E
		item.forEach(it->System.out.println(it));
			
		//Output : C
		item.forEach(it->{
			if("C".equals(it)){
				System.out.println(it);
			}
		});
			
		//method reference
		//Output : A,B,C,D,E
		//item.forEach(System.out::println);
		
		//Stream and filter
		//Output : B
		//item.stream().filter(s->s.contains("B")).forEach(System.out::println);
	}
}
