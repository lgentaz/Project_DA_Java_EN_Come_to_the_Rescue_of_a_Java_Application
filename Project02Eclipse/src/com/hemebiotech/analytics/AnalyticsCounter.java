package com.hemebiotech.analytics;

import java.io.File;
import java.util.*;

/**
 * <b> AnalyticsCounter is a class organizing the symptoms felt by the patient into a comprehensive and ordered frequency list</b>
 * Each symptom is :
 * <ul>
 * <li>Retrieved from an original txt file</li>
 * <li>Counted (number of occurrences)</li>
 * <li>Listed alphabetically</li>
 * </ul>
 * All listed symptoms together with their number of occurrences are exported to an output file.
 * 
 * 
 * @author lgentaz
 */

public class AnalyticsCounter {
	
	/**
	 * 		Address of the file containing the symptom list to extract
	 */
	static File allsymptoms = new File("symptoms.txt");
	
	/**
	 * 		Address of the output file where symptom count are stored
	 * */
	static File output = new File("results.out");

	/**
	 * 
	 * Reads the file containing the raw list of symptoms and creates an organized output of alphabetically listed symptoms and their frequencies
	 * @see ReadSymptomDataFromFile
	 * @see SymptomFrequencyCounter
	 * @see WriteSymptomCountInFile
	 * @param args
	 * 		Input and output data files
	 */
	
	public static void main(String args[]){
		
		ReadSymptomDataFromFile in = new ReadSymptomDataFromFile(allsymptoms);
		List<String> results = in.getSymptoms();
		SymptomFrequencyCounter symptomFrequency = new SymptomFrequencyCounter(results);
		WriteSymptomCountInFile out = new WriteSymptomCountInFile(output);
		out.createOutput(symptomFrequency.getFrequency());
		
	}
}


