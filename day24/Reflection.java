package day24;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection{
	
	static class Person{
		private String name;
		private int age;
		
		public Person() {
			this.name = "Hemanth";
			this.age = 25;
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
	}
	
	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, 
	NoSuchMethodException, InvocationTargetException{ 
		
			Class<?> personClass = Person.class;
			
			System.out.println("Fields:");
			Field[] fields = personClass.getDeclaredFields();
			for(Field field : fields) {
				System.out.println("  " + field);
			}
			
			System.out.println("Methods:");
			Method[] methods = personClass.getDeclaredMethods();
			for(Method method : methods) {
				System.out.println("  " + method);
			}
			
			System.out.println("Constructors:");
			Constructor<?>[] constructors = personClass.getDeclaredConstructors();
			for(Constructor<?> constructor : constructors) {
				System.out.println("  " + constructor);
			}
			
			Person person = new Person();
			
			Field nameField = personClass.getDeclaredField("name");
			nameField.setAccessible(true);
			nameField.set(person, 25);
			
			Field ageField = personClass.getDeclaredField("age");
			ageField.setAccessible(true);
			ageField.set(person, 25);
			
			Method printDetailsMethod = personClass.getDeclaredMethod("printDetails");
			printDetailsMethod.setAccessible(true);
			printDetailsMethod.invoke(person);
			
			System.out.println("Modified name :"+person.getName());
			System.out.println("Modified age :"+person.getAge());
			
	}
}

			
			
			
			









//package day24;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//
//public class Reflection {
//	
//
//
//	public class Person {
//		
//		private String name;
//		private int age;
//		
//		public Person() {
//		}
//		
//			
//		public Person(String name, int age) {
//			this.name = name;
//			this.age = age;
//		}
//		
//		public String getName() {
//			return name;
//		}
//		private void setName(String name) {
//			this.name = name;
//		}
//		public int getAge() {
//			return age;
//		}
//		
//		private void setAge(int age) {
//			this.age = age;
//		}
//		public String toString() {
//			return "Person{name='" +name+"',age="+age+'}';
//		}
//		}
//		
//	public static void main(String[] args) throws Exception {
//		
//			Class<Person> personClass = Person.class;
//			
//			System.out.println("Fields:");
//			Field[] fields = personClass.getDeclaredFields();
//			for(Field field : fields) {
//				System.out.println(field);
//			}
//			
//			System.out.println("\nConstructors:");
//			Constructor<?>[] constructors = personClass.getDeclaredConstructors();
//			for(Constructor<?> constructor : constructors) {
//				System.out.println(constructor);
//			}
//			
//			System.out.println("\nMethods:");
//			Method[] methods = personClass.getDeclaredMethods();
//			for(Method method : methods) {
//				System.out.println(method);
//			}
//			
//			
//			Person person = personClass.getDeclaredConstructor().newInstance();
//			
//			Field nameField = personClass.getDeclaredField("name");
//			nameField.setAccessible(true);
//			nameField.set(person, "Hemanth");
//			
//			Field ageField = personClass.getDeclaredField("age");
//			ageField.setAccessible(true);
//			ageField.set(person, "30");
//			
//			System.out.println("\nModified Person:"+person);
//			Method setNameMethod = personClass.getDeclaredMethod("setName",String.class);
//			setNameMethod.setAccessible(true);
//			setNameMethod.invoke(person, "Hemanth");
//			
//			Method setAgeMethod = personClass.getDeclaredMethod("setAge",int.class);
//			setAgeMethod.setAccessible(true);
//			setAgeMethod.invoke(person, "25");
//			
//			System.out.println("Modified Person Again:"+person);
//	}
//}
//			
//			
//			
//			
//			