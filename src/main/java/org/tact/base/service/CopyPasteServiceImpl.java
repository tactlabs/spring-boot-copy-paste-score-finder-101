package org.tact.base.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CopyPasteServiceImpl implements CopyPasteService {
	
	@Override
	public <T> T getScore(String content1, String content2) {
		
		Cosine_Similarity cs1 = new Cosine_Similarity();
		
		double copyPasteScore = cs1.Cosine_Similarity_Score(content1 , content2);		
		copyPasteScore = copyPasteScore * 100;
		
		copyPasteScore = round(copyPasteScore, 2);
		
		System.out.println("Copy Paste score = "+copyPasteScore+ "%");
		
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		resultMap.put("content_1", content1);
		resultMap.put("content_2", content2);
		resultMap.put("result", "ok");
		resultMap.put("copy_paste_score", copyPasteScore);
		
		return (T) resultMap;
	}	
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
