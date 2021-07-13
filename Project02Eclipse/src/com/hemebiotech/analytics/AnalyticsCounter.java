package com.hemebiotech.analytics;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.io.IOException;
/**
 * This class call methods to have a compact static void main
 * @author Arnaud
 *
 */
public class AnalyticsCounter {

	public static void main(String args[]) throws IOException{
		
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(); 

		ISymptomReader symptomReader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");

		List<String> symptomListFromFile;
		try{
			symptomListFromFile = symptomReader.getSymptoms();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		Map<String, Integer> symptomMapFrequencies;
		try{
			symptomMapFrequencies = analyticsCounter.countSymptomFrequency(symptomListFromFile);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	
	
		ISymptomWriter symptomWriter = new WriteSymptomDataToFile("Project02Eclipse/results.out");
		try{
			symptomWriter.writeSymptomDataToFile(symptomMapFrequencies);
		}	
		catch(IOException e){
			e.printStackTrace();
			return;
		}
	}
	/**
	 * cross the symptom list "symptomListFromFile" and count the frequencies and write data in Map symptomMapFrequencies. 
	 * 
	 * @param symptomListFromFile
	 * @return symptomMapFrequencies
	 * 
	 */
	public TreeMap<String, Integer> countSymptomFrequency(List<String> symptomListFromFile) {

		TreeMap<String, Integer> processMap = new TreeMap<String, Integer>(); 
		
		if(symptomListFromFile != null) {
			for(String symptom : symptomListFromFile) {
				processMap.put(symptom, Collections.frequency(symptomListFromFile, symptom));
			}
		}
		return processMap;	
	}
}