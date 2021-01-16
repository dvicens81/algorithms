package com.algorithms.sort;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.algorithms.client.dto.ClientReading;
import com.algorithms.client.sort.ClientSorted;

public class ClientSortedTest {
	
	private static final String NAME_CLIENT1 = "Bram";
	private static final String NAME_CLIENT2 = "Larry";
	private static final String NAME_CLIENT3 = "Manny";
	private static final String NAME_CLIENT4 = "Jax";
	
	private List<ClientReading> testClients;
	
	@Before
	public void init() {
		//Create test clients 
		ClientReading client1 = new ClientReading();
		client1.setName(NAME_CLIENT1);
		client1.setReading(100);
		
		ClientReading client2 = new ClientReading();
		client2.setName(NAME_CLIENT2);
		client2.setReading(500);
		
		ClientReading client3 = new ClientReading();
		client3.setName(NAME_CLIENT3);
		client3.setReading(50);
		
		ClientReading client4 = new ClientReading();
		client4.setName(NAME_CLIENT4);
		client4.setReading(501);
		
		testClients = Stream.of(client1, client2, client3, client4).collect(Collectors.toList());
	}
	
	@After
	public void cleanUp() {
		testClients = null;
	}

	/*
	 * Test check order descending
	 */
	@Test
	public void getClientsOrderByReadingDesc() {		
		List<ClientReading> response = ClientSorted.getTopClients(testClients, Comparator.comparing(ClientReading::getReading).reversed());
		assertEquals(NAME_CLIENT4, response.get(0).getName());
		assertEquals(NAME_CLIENT2, response.get(1).getName());
		assertEquals(NAME_CLIENT1, response.get(2).getName());
		assertEquals(NAME_CLIENT3, response.get(3).getName());
	}
	
	/*
	 * Test check order ascending
	 */
	
	@Test
	public void getClientsOrderByReadingAsc() {		
		List<ClientReading> response = ClientSorted.getTopClients(testClients, Comparator.comparing(ClientReading::getReading));
		assertEquals(NAME_CLIENT3, response.get(0).getName());
		assertEquals(NAME_CLIENT1, response.get(1).getName());
		assertEquals(NAME_CLIENT2, response.get(2).getName());
		assertEquals(NAME_CLIENT4, response.get(3).getName());
	}
	
	@Test
	public void strings() {
		String a = "Javier";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "4");
		map.put("i", "3");
		System.out.println(map.entrySet().stream().map(entry->this.read(entry, a)).collect(Collectors.joining()));
				
	}
	
	private String read(Map.Entry<String, String> d, String word) {
		return word.replaceAll(d.getKey(), d.getValue());
	} 
}
