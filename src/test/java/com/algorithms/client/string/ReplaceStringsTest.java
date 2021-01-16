package com.algorithms.client.string;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.algorithms.client.string.ReplaceStrings;

public class ReplaceStringsTest {
	
	private Map<String, String> searchReplaceMap;
	
	@Before
	public void init() {
		//First of all. Configure the characters that you like to translate.
		//You can use differents configuration, but for this case only use one.
		searchReplaceMap = new HashMap<>();
		searchReplaceMap.put("A", "4");
        searchReplaceMap.put("a", "4");
        searchReplaceMap.put("E", "3");
        searchReplaceMap.put("e", "3");
        searchReplaceMap.put("B", "8");
        searchReplaceMap.put("b", "8");
        searchReplaceMap.put("I", "1");
        searchReplaceMap.put("i", "1");
        searchReplaceMap.put("O", "0");
        searchReplaceMap.put("o", "0");
        searchReplaceMap.put("s", "6");
        searchReplaceMap.put("S", "6");
	}
	
	@After
	public void cleanUp() {
		searchReplaceMap = null;
	}
	
	@Test
	public void replaceCharacters() {		
        String request = "AEIOBSzzzzaeiobszzzz!";
        String response = ReplaceStrings.replace(request, searchReplaceMap);
        assertEquals("431086zzzz431086zzzz!", response);
	}
	
	@Test
	public void replaceCharactersOtherCase() {		
        String request = "Holaluz is a great place to work";        
        String response = ReplaceStrings.replace(request, searchReplaceMap);
        assertEquals("H0l4luz 16 4 gr34t pl4c3 t0 w0rk", response);
	}

}
