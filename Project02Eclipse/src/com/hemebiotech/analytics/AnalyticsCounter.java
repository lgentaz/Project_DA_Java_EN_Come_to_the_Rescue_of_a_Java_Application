package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {

		
		//Creating 
		File filepath = new File("symptoms.txt");
		File output = new File("results.out");
		List<String> results = new ArrayList<String>();
		Map<String, Integer> symptomFrequency = new TreeMap<String, Integer>();
													
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
		
		Set<String> singleSymptoms = new HashSet<String>(results);
	
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
		
		if (symptomFrequency != null) {
			try {
				BufferedWriter writer = new BufferedWriter (new FileWriter(output));
				for (Map.Entry<String, Integer> entry : symptomFrequency.entrySet()) {
					String line = entry.getKey() + " : " + entry.getValue();
					writer.write(line);
					writer.write(System.getProperty( "line.separator" ));
				}
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		
		
		
	}


}


