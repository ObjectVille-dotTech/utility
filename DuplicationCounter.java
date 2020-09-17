package com.generic.utility.logic;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicationCounter {

	//Find duplicate words from a provided String
	public static void findDuplicatesFromAString(String str) {
		
		String[] strArray = str.split(" ");
		
		HashMap<String, Integer> counterMap = new HashMap<>();
		
		for(String temp : strArray) {
			if(counterMap.containsKey(temp)) {
				counterMap.put(temp, counterMap.get(temp)+1);
			}else {
				counterMap.put(temp, 1);
			}
		}
		
		System.out.println(counterMap);
	}
	
	public static void findDuplicatesFromAStringUsingStream(String str) {	
		
		String[] strArray = str.split(" ");
		
		//1. All string value with their occurrences
		Map<String, Long> counterMap = 
				Arrays.stream(strArray).collect(Collectors.groupingBy(e->e, Collectors.counting()));

		//2. only duplicating Strings
		Map<String, Long> temp = counterMap.entrySet().stream().filter(map->map.getValue() > 1).collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
		System.out.println("test : "+temp);
		
		//3. List of Duplicating Strings
		List<String> masterStrings = Arrays.asList(strArray);
		Set<String> duplicatingStrings = 
				masterStrings.stream().filter(i -> Collections.frequency(masterStrings, i) > 1).collect(Collectors.toSet());

	}
}
