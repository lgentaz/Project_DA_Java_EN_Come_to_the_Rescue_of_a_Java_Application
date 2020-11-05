package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class AnalyticsCounter {
	
	
	public static void main(String args[]) throws Exception {
		
	File filepath = new File("symptoms.txt");
		
		List<String> results = new ArrayList<String>();
													
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
		
		Collections.sort(results);
		
		Set singleSymptoms = new TreeSet(results);
		
		
		Map<String, Integer> symptomFrequency = new TreeMap<String, Integer>();
		

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
		
		System.out.println(symptomFrequency);
		
	}

}


