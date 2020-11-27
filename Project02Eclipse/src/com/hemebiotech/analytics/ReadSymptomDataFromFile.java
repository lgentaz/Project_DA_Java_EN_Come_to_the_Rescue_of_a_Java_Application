package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Reads symptom data from a file
 * The return value is a list of strings (symptoms) with some possible duplicates.
 * The list is ordered alphabetically.
 * 
 */

public class ReadSymptomDataFromFile implements ISymptomReader {
	
	/**
	 * a full or partial path to file.
	 */
	private File filepath;
	
	/**
	 * Every symptoms present in the file. It lists every single item retrieved from the initial file, sorted in alphabetical order
	 */
	private List<String> results = new ArrayList<String>();
	
	/**
	 * Retrieves the filepath.
	 * 
	 * @param path 
	 * 		a full or partial path to file.
	 */
	
	public ReadSymptomDataFromFile(File path) {
		this.filepath = path;
	}

	/**
	 * Reads each recorded symptoms from file (one per line) and records them in an array list "result".
	 * 
	 * @return results
	 *			Every symptoms present in the file. It lists every single item retrieved from the initial file, sorted in alphabetical order
	 * @see AnalyticsCounter
	 */
	
	@Override
	public List<String> getSymptoms() {
		
		if (filepath != null) {
			//try with resources ==> reader automatially closed after the program is finished with it
			try (BufferedReader reader = new BufferedReader (new FileReader(filepath))){
				String line = reader.readLine();
				
				while (line != null) {
					results.add(line);
					line = reader.readLine();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Please enter correct filepath.");
		}
		return results;
	}
}
