package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class ReadSymptomDataFromFile implements ISymptomReader {
	
	private File filepath;
	private List<String> result = new ArrayList<String>();
	
	/**
	 * Retrieves the filepath.
	 * 
	 * @param filepath a full or partial path to file.
	 */
	
	public ReadSymptomDataFromFile(File path) {
		this.filepath = path;
	}

	/**
	 * 
	 * Reads each recorded symptoms from file (one per line) and records them in an array list "result".
	 * 
	 * @return result
	 *			Every symptoms demonstrated, lists every single item retrieved from the initial file
	 * @see main
	 * 			
	 */
	
	@Override
	public List<String> getSymptoms() {
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Please enter correct filepath.");
		}
		Collections.sort(result);
		return result;
	}
}
