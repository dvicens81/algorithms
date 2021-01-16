package com.algorithms.client.sort;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.algorithms.client.dto.ClientReading;

/*
 * This interface it is used for sort list of clients.
 *  
 */
public interface ClientSorted {
	/**
	 * 
	 * @param clients list of clients to sort
	 * @param comparator comparison function that will be applied in the list of clients
	 * @return list of client DTO sorted by comparator specified
	 */
	public static List<ClientReading> getTopClients(List<ClientReading> clients, Comparator<ClientReading> comparator){
		return clients.stream().sorted(comparator).collect(Collectors.toList());
	}
}
