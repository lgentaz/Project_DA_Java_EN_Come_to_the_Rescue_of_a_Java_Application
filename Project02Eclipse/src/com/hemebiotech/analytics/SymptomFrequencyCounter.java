package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;

public class SymptomFrequencyCounter {
	
	
	private Map<String, Integer> frequency = new TreeMap<String, Integer>();
	
	/**
	 * 
	 * Enumerates the symptoms and counts the frequency at which they occur in the recorded list 
	 * @param singles
	 * 			Lists once each type of symptom demonstrated by patients
	 * @param res
	 * 			Every symptoms demonstrated, lists every single item retrieved from the initial file
	 * @param frequency
	 * 			Dictionary associating each symptom to its occurrence frequency in the original file
	 * @see getFrequency
	 * @see main
	 * 
	 */	
	
	public SymptomFrequencyCounter(Set<String> singles, List<String> res){	
		for (Object s : singles) {
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
	 * Enumerates the symptoms and counts the frequency at which they occur in the recorded list 
	 * @return frequency
	 * @see SymptomFrequencyCounter
	 * @see main
	 * 
	 */	
	public Map<String, Integer> getFrequency(){
		return this.frequency;
	}
}
