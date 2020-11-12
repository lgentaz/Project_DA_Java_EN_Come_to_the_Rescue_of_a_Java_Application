package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;

public class SymptomFrequencyCounter {

	/**
	 * 
	 * Enumerates the symptoms and counts the frequency at which they occur in the recorded list 
	 * @return symptomFrequency
	 * 			Dictionary associating each symptom to its occurrence frequency in the original file
	 * @see main
	 * 
	 */
	
	private Map<String, Integer> frequency = new TreeMap<String, Integer>();
	
	
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
	
	public Map<String, Integer> GetFrequency(){
		return this.frequency;
	}
}
