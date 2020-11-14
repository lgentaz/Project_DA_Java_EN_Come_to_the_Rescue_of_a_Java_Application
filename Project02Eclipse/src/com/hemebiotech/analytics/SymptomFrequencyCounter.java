package com.hemebiotech.analytics;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;

public class SymptomFrequencyCounter {
	
	private Map<String, Integer> frequency = new TreeMap<String, Integer>();
	private Set<String> singleSymptoms;	

	/**
	 * 
	 * Enumerates the symptoms and counts the frequency at which they occur in the recorded list 
	 * @param singlesSymptoms
	 * 			Lists once each type of symptom demonstrated by patients
	 * @param res
	 * 			Every symptoms demonstrated, lists every single item retrieved from the initial file
	 * @param frequency
	 * 			Dictionary associating each symptom to its occurrence frequency in the original file
	 * @see getFrequency
	 * @see main
	 * 
	 */	
	
	public SymptomFrequencyCounter(List<String> res){	
		this.singleSymptoms = new HashSet<String>(res);
		for (Object s : singleSymptoms) {
			String k = s.toString();
			int v = 0;
			for (String occ : res) {
				int match = occ.equals(k)? 1 : 0;
				v+=match;
			}
			this.frequency.put(k,v);
		}
	}
	
	/**
	 * 
	 * Returns the symptom occurrences 
	 * @return frequency
	 * @see SymptomFrequencyCounter
	 * @see main
	 * 
	 */	

	public Map<String, Integer> getFrequency(){
		return frequency;
	}
}
