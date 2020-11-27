package com.hemebiotech.analytics;

//import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
//import java.util.Set;

/**
 * Parameter given is a list of strings (symptoms), may contain duplicates 
 * Creates a set of string from initial list containing once every symptom retrieved: no duplicates.
 * Counts the number of duplicates in the list for every symptom of the set
 * The return object is a map associating symptoms and duplicate count.
 */

public class SymptomFrequencyCounter implements IFrequencyCount {
	
	private Map<String, Integer> frequency = new TreeMap<String, Integer>();

	/**
	 * 
	 * Enumerates the symptoms and counts the frequency at which they occur in the recorded list 		
	 * @param symptomList
	 * 			Every symptoms demonstrated, lists every single item retrieved from the initial file
	 * @see getFrequency
	 * @see ReadSymptomDataFromFile
	 * @see AnalyticsCounter
	 * 
	 */	
	
	public SymptomFrequencyCounter(List<String> symptomList){	
		for (String symptom : symptomList) {
			if (frequency.containsKey(symptom)) {
				int occurence = frequency.get(symptom) + 1;
				frequency.replace(symptom, occurence);
			} else {
				this.frequency.put(symptom,1);
			}
		}
	}
	
	/**
	 * 
	 * Returns the symptom occurrences 
	 * @return frequency
	 * 			a map associating associating each symptom (String key) to its occurrence frequency (Integer value)
	 * @see SymptomFrequencyCounter
	 * @see AnalyticsCounter
	 * 
	 */	

	@Override
	public Map<String, Integer> getFrequency(){
		return frequency;
	}
}
