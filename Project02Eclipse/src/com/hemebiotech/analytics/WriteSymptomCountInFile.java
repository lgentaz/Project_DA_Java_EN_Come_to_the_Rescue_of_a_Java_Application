package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class WriteSymptomCountInFile {
	
	private File filepath;

	/**
	 * Retrieves the filepath.
	 * 
	 * @param filepath a full or partial path to file.
	 */
	
	public WriteSymptomCountInFile(File path) {
		this.filepath = path;
	}
		
	/**
	 * 
	 * Writes the various symptoms and their frequencies into an output file
	 * 
	 * @param out
	 * 			Address of the file in which are written the symptoms and their frequency  
	 * @param freq
	 * 			Dictionary associating each symptom to its occurrence frequency in the original file 
	 * @see main
	 * 
	 */
  
	public void createOutput(Map <String, Integer>freq) {
		if (filepath != null) {
			try {
				BufferedWriter writer = new BufferedWriter (new FileWriter(filepath));
				for (Map.Entry<String, Integer> entry : freq.entrySet()) {
					String line = entry.getKey() + " : " + entry.getValue();
					writer.write(line);
					writer.write(System.getProperty("line.separator"));
				}
				writer.close();
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
