package day25;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class CustomObject implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	
	public CustomObject(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

public class Serialization {

	public static void main(String[] args) {
		CustomObject obj = new CustomObject("Hemanth",30);
		try {
			
			FileOutputStream fileOut = new FileOutputStream("customObject.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(obj);;
			out.close();
			fileOut.close();
			System.out.println("serialized data is saved in customObject.ser");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fileIn = new FileInputStream("customObject.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			CustomObject newObj = (CustomObject) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("Deserialization data:");
			System.out.println("Name:"+newObj.getName());
			System.out.println("Age:"+newObj.getAge());
			
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
		
			
		