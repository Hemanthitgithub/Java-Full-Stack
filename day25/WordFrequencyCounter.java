package day25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {

	public static void main(String[] args) {
		String inputFilePath = "input.txt";
		String outputFilePath = "output.txt";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
//			FileWriter writer = new FileWriter(outputFile){
				
			
			Map<String,Integer> wordFrequencyMap = new HashMap<>();
			
			String line;
			while((line = reader.readLine()) != null) {
				String[] words = line.split("\\s+");
				for(String word : words) {
					word = word.replaceAll("[^a-zA-Z]","").toLowerCase();
//					if(!word.isEmpty()) {
						wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(words, 0)+1);
					}
				}
			
			reader.close();
//			
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

//			FileWriter writer = new FileWriter(outputFile);
			for(Map.Entry<String,Integer> entry : wordFrequencyMap.entrySet()) {
				writer.write(entry.getKey() + ": " + entry.getValue() +"\n");
			}
			writer.close();
			System.out.println("Word frequencies counted successfully. Results written to " + outputFilePath); 
		} catch (IOException e) {
			System.out.println("Error reading or writing file:"+ e.getMessage());
			
//			e.printStackTrace();
		}
	}
}