package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.*;


@RestController
public class controller {
	
	@PostMapping("/bfhl")
	public 	JSONObject postA(@RequestBody String data) {
		

		JSONObject js = new JSONObject();
		JSONParser parser = new JSONParser(); 
		
		JSONObject json = null;
		try {
			json = (JSONObject) parser.parse(data);
			 // get a String from the JSON object
            Object firstName =  json.get("data");
            JSONArray arr = (JSONArray) firstName;
            List<String> numbers = new ArrayList(); 
            List<String> alphabates = new ArrayList();
    		for (int i = 0; i < arr.size(); i++) { 
    			int n; 
    			int count = 0;
    			int num = 0;
    		//	n = Integer.parseInt((String)arr.get(i));
    			if(isNumeric((String)arr.get(i))) {
    				
    	    		System.out.println("true "+(String)arr.get(i));
    	    		numbers.add((String)arr.get(i));
    	    		count++;
    	    	
    			} else {
    	    		System.out.println("halse "+(String)arr.get(i));
    	    		alphabates.add((String)arr.get(i));
    	    		
    			} 
    			
            }
    		//String[] numbers1 =  new String[3];
    		//numbers1[0] = "@1";
    		

    		js.put("is_success", true);
    		js.put("user_id", "john_doe_17091999")	;
    		js.put("email", "john@xyz.com");
    		js.put("roll_number", "ABCD123");
    		js.put("numbers", numbers.toArray(new String[numbers.size()]));
    		js.put("alphabates", alphabates);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return js;
	}
	
	
	
	public  boolean isNumeric(String string) {
	    int intValue;
			
	    System.out.println(String.format("Parsing string: \"%s\"", string));
			
	    if(string == null || string.equals("")) {
	        System.out.println("String cannot be parsed, it is null or empty.");
	        return false;
	    }
	    
	    try {
	        intValue = Integer.parseInt(string);
	        return true;
	    } catch (NumberFormatException e) {
	        System.out.println("Input String cannot be parsed to Integer.");
	    }
	    return false;
	}

}
