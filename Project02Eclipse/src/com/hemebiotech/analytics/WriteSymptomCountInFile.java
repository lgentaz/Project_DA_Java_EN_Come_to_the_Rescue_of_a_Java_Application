package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Creates an output file containing symptoms and their respective count, ordered alphabetically
 * One symptom-count pair per line.
 * Each line correspond to a key-value pair retrieved from a string-integer map
 * No return value.
 * 
 */

public class WriteSymptomCountInFile implements IOccurrenceWriter {
	
	/**
	 * a full or partial path to file.
	 */
	private File filepath;

	/**
	 * Retrieves the filepath.
	 * 
	 * @param path 
	 * 		a full or partial path to file.
	 */
	
	public WriteSymptomCountInFile(File path) {
		this.filepath = path;
	}
		
	/**
	 * Writes the various symptoms and their frequencies into an output file
	 *  
	 * @param frequency
	 * 			a map associating associating each symptom (String key) to its occurrence frequency (Integer value)
	 * @see AnalyticsCounter
	 * @see SymptomFrequencyCounter
	 * @see ReadSymptomDataFromFile
	 */
  
	@Override
	public void createOutput(Map <String, Integer>frequency) {
		if (filepath != null) {
			try (BufferedWriter writer = new BufferedWriter (new FileWriter(filepath))){
				for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
					String line = entry.getKey() + " : " + entry.getValue();
					writer.write(line);
					writer.write(System.getProperty("line.separator"));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("No filepath given.");
		}

	}
}
