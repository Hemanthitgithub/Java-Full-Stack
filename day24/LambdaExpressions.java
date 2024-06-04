package day24;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressions {
	
	public  static class Person {
		
		private String name;
		private int age;
		
		public Person() {
		}
		
			
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		public String getName() {
			return name;
		}
		
		public int getAge() {
			return age;
		}
		
		
		public String toString() {
			return "Person{name='" +name+"',age="+age+'}';
		}
		}

	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Hemanth",25));
		people.add(new Person("Chandu",45));
		people.add(new Person("Darling",35));
		people.add(new Person("Ramesh",15));
		
		people.sort(Comparator.comparingInt(Person::getAge));
		
		System.out.println("Sorted by Age:");
		for(Person person : people) {
			System.out.println(person);
		}
	}
}

		
