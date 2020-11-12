package com.hemebiotech.analytics;

import java.lang.Exception;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.*;


/**
 * <b> AnalyticsCounter is a class organizing the symptoms felt by the patient into a comprehensive and ordered frequency list</b>
 * <p>
 * Each symptom is :
 * <ul>
 * <li>Retrieved from an original txt file</li>
 * <li>Counted (number of occurrences)</li>
 * <li>Listed alphabetically</li>
 * </ul>
 * </p>
 * <p>
 * All listed symptoms together with their number of occurrences are exported to an output file.
 * </p>
 * 
 * 
 * @author lgentaz
 */


public class AnalyticsCounter {
	
	static File allsymptoms = new File("symptoms.txt");
	static File output = new File("results.out");

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
	 */
	
	public static void main(String args[]){
		
		ReadSymptomDataFromFile in = new ReadSymptomDataFromFile(allsymptoms);
		List<String> results = in.GetSymptoms();
		Set<String> singleSymptoms = new HashSet<String>(results);	
		SymptomFrequencyCounter symptomFrequency = new SymptomFrequencyCounter(singleSymptoms,results);
		WriteSymptomCountInFile out = new WriteSymptomCountInFile(output);
		out.CreateOutput(symptomFrequency.GetFrequency());
		
	}

}


