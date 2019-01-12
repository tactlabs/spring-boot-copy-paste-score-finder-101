package org.tact.base.service;

import java.io.IOException;

public class CopyPasteScoreFinder {
	
	public static String FILE_BASE = "D:/test/similarity/";
	
	// https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
	public static void main1(String[] args) throws IOException {
		
		Cosine_Similarity cs1 = new Cosine_Similarity();
		
		String content1 = TextFileReader.readFile(FILE_BASE + "content1.txt");
		String content2 = TextFileReader.readFile(FILE_BASE + "content2.txt");
		
		double copyPasteScore = cs1.Cosine_Similarity_Score(content1 , content2);		
		copyPasteScore = copyPasteScore * 100;
		
		copyPasteScore = round(copyPasteScore, 2);
		
		System.out.println("Copy Paste score = "+copyPasteScore+ "%");
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
