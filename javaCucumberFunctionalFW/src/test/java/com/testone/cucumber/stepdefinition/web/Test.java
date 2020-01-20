package com.testone.cucumber.stepdefinition.web;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		
		String str = "Programming world";
		freqCount(str);
		
	}

	private static void freqCount(String str) {
		
		str = str.replace(" ", "");
		Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
		
		for (char ch : str.toCharArray()) {
			if (freqMap.containsKey(ch)) {
				freqMap.put(ch, (Integer)freqMap.get(ch) + 1);
			}
			else
				freqMap.put(ch, 1);
		}
		
		System.out.println(freqMap);
		System.out.println("Test");
		
	}

}
