package com.hemebiotech.analytics;

import java.io.File;
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
	 * @param symptomFrequency
	 * 			Dictionary associating each symptom to its occurrence frequency in the original file
	 * @see ReadSymptomDataFromFile
	 * @see getSymptoms
	 * @see SymptomFrequencyCounter
	 * @see WriteSymptomCountInFile
	 * @see getFrequency
	 */
	
	public static void main(String args[]){
		
		ReadSymptomDataFromFile in = new ReadSymptomDataFromFile(allsymptoms);
		List<String> results = in.getSymptoms();
		SymptomFrequencyCounter symptomFrequency = new SymptomFrequencyCounter(results);
		WriteSymptomCountInFile out = new WriteSymptomCountInFile(output);
		out.createOutput(symptomFrequency.getFrequency());
		
	}
}


