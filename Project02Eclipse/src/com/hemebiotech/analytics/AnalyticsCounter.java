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

	/**
	 * 
	 * Reads the file containing the raw list of symptoms and creates an organized output of alphabetically listed symptoms and their frequencies
	 * 
	 * @param results
	 * 			Every symptoms demonstrated, lists every single item retrieved from the initial file
 	 * @param allsymptoms
 			Address of the file containing the symptom list to extract 
	 * @param singleSymptoms
	 * 			Lists once each type of symptom demonstrated by patients
	 * @see ReadSymptomDataFromFile
	 * @see SymptomCounter
	 * @see WriteSymptomCountInFile
	 */
	
	public static void main(String args[]) throws Exception {

		results = ReadSymptomDataFromFile(allsymptoms);
		singleSymptoms = new HashSet<String>(results);	
		SymptomCounter();
		WriteSymptomCountInFile(symptomFrequency, output);
		
	}

	/**
	 * 
	 * Reads the file containing the symptoms recorded and retrieves them in an array list
	 * 
	 * @param filepath
	 * 			Address of the file containing the symptom list to extract 
	 * @return results
	 *			List containing every symptom retrieved from the initial file
	 * 			
	 */
	
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
	
	/**
	 * 
	 * Enumerates the symptoms and counts the frequency at which they occur in the recorded list 
	 * @return symptomFrequency
	 * 			Dictionary associating each symptom to its occurrence frequency in the original file
	 */
	
	public static void SymptomCounter(){
		for (Object s : singleSymptoms) {
			String k = s.toString();
			int v = 0;
			for (String occ : results) {
				int match = occ.equals(k)? 1 : 0;
				v+=match;
			}
			symptomFrequency.put(k,v);
		}	
	}
	
	/**
	 * 
	 * Writes the various symptoms and their frequencies into an output file
	 * 
	 * @param out
	 * 			Address of the file in which are written the symptoms and their frequency  
	 * @param freq
	 * 			Dictionary associating each symptom to its occurrence frequency in the original file 
	 */
	
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


