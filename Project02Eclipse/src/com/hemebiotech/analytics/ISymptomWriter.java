package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

/**
 * Anything that will write data to file. The return value of operation is
 * a file with extension ".out"
 * 
 * @author Arnaud
 * 
 *
 */

public interface ISymptomWriter {
	/**
	 * If data are no available, return empty file
	 * 
	 * @param symptomListFrequency create in AnalyticsCounter class with "symptomListFromFile = symptomReader.getSymptoms();"
	 * @throws IOException if the file path of symptoms.txt file is no define or wrong
	 */
	void writeSymptomDataToFile(Map<String, Integer> symptomListFrequency) throws IOException;
}
