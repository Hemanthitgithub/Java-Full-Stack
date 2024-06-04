package day24;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface {
		
		public  static class Person {
			
			private String name;
			private int age;
			
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
			
			public void setName(String name) {
				this.name = name;
			}
			
			public void setAge(int age) {
				this.age = age;
			}
			
			
			public String toString() {
				return "Person{name='" +name+"',age="+age+'}';
			}
			}
		
		public static void operateOnPerson(Person person,Predicate<Person>predicate,Function<Person,Person> function,
				Consumer<Person> consumer,Supplier<Person> supplier) {
			if(predicate.test(person)) {
				Person transformedPerson = function.apply(person);
				consumer.accept(transformedPerson);;
			}else {
				Person newPerson = supplier.get();
				consumer.accept(newPerson);
			}
		}
		
	public static void main(String[] args) {
		Person person = new Person("Darling",25);
		
		Predicate<Person> isAdult = p -> p.getAge() >= 18;
		Function<Person,Person>makeOlder = p ->{
			p.setAge(p.getAge() + 1);
			return p;
	};
	
	Consumer<Person> printPerson = p -> System.out.println("Result:"+p);
	Supplier<Person> createNewPerson = () -> new Person("Chandu",20);
	
	operateOnPerson(person, isAdult,makeOlder,printPerson,createNewPerson);
	}
}

	
	
	
	
		