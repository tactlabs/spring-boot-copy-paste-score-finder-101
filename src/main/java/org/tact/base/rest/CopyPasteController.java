package org.tact.base.rest;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.tact.base.service.CopyPasteService;

@RestController
@RequestMapping(value = "/copy-paste")
public class CopyPasteController {
	
	@Autowired
	private CopyPasteService copyPasteService;
	
	/**
	 * 
	 * @return
	 * 
	 * Possible urls:
	 * 		http://localhost:1878/copy-paste/
	 */
    @GetMapping(value = "")
    public <T> T testBase() {
        
    	Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", "two");
        map.put("three", "four");
        map.put("five", "six");
        map.put("seven", "eight");
        
        return (T) map;
    }
    
    /**
     * 
     * @param spotCD
     * @param name
     * @param request
     * @param response
     * @return
     * 
     * Possible urls:
	 * 		http://localhost:1878/copy-paste/find-score
     * 
     */
    @RequestMapping(value = "/find-score", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody <T> T testCharSet(			
			@RequestParam(value = "content1") String content1,
			@RequestParam(value = "content2") String content2,			
			final HttpServletRequest request, 
			final HttpServletResponse response			
	) {
		
		return copyPasteService.getScore(content1, content2);
	}
    
    public static void print(Object obj){
    	System.out.println(obj);
    }   
    
}
