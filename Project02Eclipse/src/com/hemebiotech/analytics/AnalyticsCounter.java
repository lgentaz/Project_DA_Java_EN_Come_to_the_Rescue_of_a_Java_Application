package com.hemebiotech.analytics;

import java.lang.Exception;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class AnalyticsCounter {
	
	static File allsymptoms = new File("symptoms.txt");
	static File output = new File("results.out");
	static List<String> results = new ArrayList<String>();
	static Set<String> singleSymptoms = new HashSet<String>();
	static Map<String, Integer> symptomFrequency = new TreeMap<String, Integer>();
	
	public static void main(String args[]) throws Exception {

		results = ReadSymptomDataFromFile(allsymptoms);
		singleSymptoms = new HashSet<String>(results);	
		SymptomCounter();
		WriteSymptomCountInFile(symptomFrequency, output);
		
	}

	public static List<String> ReadSymptomDataFromFile(File filepath){
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				while (line != null) {
					results.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		return results;
	}
	
	public static void SymptomCounter(){
		for (Object s : singleSymptoms) {
			String k = s.toString();
			int v = 0;
			for (String occ : results) {
				if (occ.equals(k)) {
					v += 1;
				} else {
					v += 0;
				}
			}
			symptomFrequency.put(k,v);
		}	
	}
	
	public static void WriteSymptomCountInFile(Map<String, Integer> freq, File out) {
		if (freq != null) {
			try {
				BufferedWriter writer = new BufferedWriter (new FileWriter(out));
				for (Map.Entry<String, Integer> entry : freq.entrySet()) {
					String line = entry.getKey() + " : " + entry.getValue();
					writer.write(line);
					writer.write(System.getProperty("line.separator"));
				}
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}

}


