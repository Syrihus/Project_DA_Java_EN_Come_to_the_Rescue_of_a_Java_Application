package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * write symptom frequencies in file "results.out"
 * 
 * @author Arnaud
 * @see ISymptomWriter interface
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
	private String resultFileName;

	/**
	 * Constructor to change file name in static void main
	 * 
	 * @param resultFileName file path and name of file
	 */
	public WriteSymptomDataToFile(String resultFileName) {
		this.resultFileName = resultFileName;
	}

	/**
	 * if symptomListFrequency is not null, write the symptoms list in file
	 * "result.out" or return a empty file
	 * 
	 * @author Arnaud
	 * @param symptomListFrequency a Map with symptoms and count duplications. On per line. Ex: fever=7; param return of methode countSymptomFrequency
	 * @throws IOException if the file path is no define or wrong
	 */
	@Override
	public void writeSymptomDataToFile(Map<String, Integer> symptomListFrequency) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(resultFileName));
		if (symptomListFrequency != null) {
			for (Map.Entry<String, Integer> element : symptomListFrequency.entrySet()) {
				writer.write(element.getKey() + "=" + element.getValue() + ";");
				writer.newLine();
			}
		}
		writer.close();
	}
}