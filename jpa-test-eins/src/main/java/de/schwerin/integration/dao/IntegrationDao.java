package de.schwerin.integration.dao;

import java.util.HashMap;
import java.util.HashSet;

public class IntegrationDao {
	
	

	public IntegrationDao() {
		testFälle = new HashSet<HashMap<String,String>>();
	}

	private HashSet<HashMap<String, String>> testFälle;

	public HashSet<HashMap<String, String>> getTestFälle() {
		return testFälle;
	}

	public void setTestFälle(HashSet<HashMap<String, String>> testFälle) {
		this.testFälle = testFälle;
	}	
	
	

}
