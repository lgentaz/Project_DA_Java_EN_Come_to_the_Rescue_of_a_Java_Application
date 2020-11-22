package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptoms in an output.
 * Parameter given is a map of string-integer pairs.
 * 
 * The implementation does not specify the output type
 * 
 */

public interface IOccurrenceWriter {
	/**
	 * Takes one parameter, no return value
	 * 
	 * @param frequency
	 * 		a map associating associating each symptom (String key) to its occurrence frequency (Integer value) 
	 */
	
	void createOutput(Map <String, Integer>frequency);

}
