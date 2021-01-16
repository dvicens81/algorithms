package com.algorithms.client.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public abstract class ReplaceStrings {
	
	private ReplaceStrings() {}

	/**
     * replace, This replaces multiple strings in a section of text, according to the supplied
     * search and replace definitions. 
     */
    public static String replace(final String sourceText, final Map<String, String> searchReplaceDefinitions) {        
	    final ArrayList<String> searchList = new ArrayList<>();
	    final ArrayList<String> replaceList = new ArrayList<>();
	    searchList.addAll(searchReplaceDefinitions.entrySet().stream().map(Entry::getKey).collect(Collectors.toList()));
	    replaceList.addAll(searchReplaceDefinitions.entrySet().stream().map(Entry::getValue).collect(Collectors.toList()));
	    return replaceUsingStringUtilsAlgorithm(sourceText, searchList, replaceList);
        
    }
    
    private static String replaceUsingStringUtilsAlgorithm(final String sourceText,
        final List<String> searchList, final List<String> replacementList) {
        final String[] searchArray = searchList.toArray(new String[]{});
        final String[] replacementArray = replacementList.toArray(new String[]{});
        return StringUtils.replaceEach(sourceText, searchArray, replacementArray);
    }
}
