package java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambda {
	
	public static void main(String[] args) {

		List<Developer> listDevs = getDevelopers();

		System.out.println("Before Sort");
		for (Developer developer : listDevs) {
			System.out.println(developer);
		}
		
		
		//sort by age
	/*	Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getAge() - o2.getAge();
			}
		});
		
		//sort by name	
		Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
					
		//sort by salary
		Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getSalary().compareTo(o2.getSalary());
			}
		});			
	
		listDevs.sort(new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o2.getAge() - o1.getAge();
			}
		});	
		*/
		
		//lambda here!
		listDevs.sort((Developer o1, Developer o2)->o1.getAge()-o2.getAge());
		
		//lambda
	//	listDevs.sort((Developer o1, Developer o2)->o1.getName().compareTo(o2.getName()));		
		
		//lambda
	//	listDevs.sort((o1, o2)->o1.getName().compareTo(o2.getName()));	
			
		
		//lambda
	//	listDevs.sort((Developer o1, Developer o2)->o1.getSalary().compareTo(o2.getSalary()));
		
		//lambda
	//	listDevs.sort((o1, o2)->o1.getSalary().compareTo(o2.getSalary()));
		
		//java 8 only, lambda also, to print the List
		System.out.println("After Sort");
		//listDevs.forEach((developer)->System.out.println(developer));
		
		listDevs.forEach((dev)-> System.out.println(dev));
//		System.out.println("After Sort");
//		for (Developer developer : listDevs) {
//			System.out.println(developer);
//		}
		
	}

	private static List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
		result.add(new Developer("mkyong", new BigDecimal("70000"), 20));
		result.add(new Developer("jason", new BigDecimal("100000"), 10));
		result.add(new Developer("iris", new BigDecimal("170000"), 15));
		
		return result;

	}
	
}