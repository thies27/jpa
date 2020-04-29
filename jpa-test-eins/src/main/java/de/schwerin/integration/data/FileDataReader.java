package de.schwerin.integration.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import de.schwerin.integration.dao.IntegrationDao;

public class FileDataReader implements DataReader{
	
	private String path;

	private static final String GRUPPE = "gruppe";

	private static final String KLASSE = "klasse";

	private static final String METHODE = "methode";
	
	
	public FileDataReader(String path) {
		super();
		this.path = path;
	}

	public IntegrationDao readData(IntegrationDao dao) {		

		File file = new File(path);
		assert file.exists() : true;

		if (!file.canRead() || !file.isFile())
			System.exit(0);

		BufferedReader in = null;		

		try {
			in = new BufferedReader(new FileReader(path));
			String zeile = null;
			while ((zeile = in.readLine()) != null) {
				System.out.println("Gelesene Zeile: " + zeile);
				String[] str1 = zeile.split("\\.");
				Map<String, String> map = new HashMap<>();
				map.put(GRUPPE, str1[0]);
				map.put(KLASSE, str1[1]);
				map.put(METHODE, str1[2]);
				dao.getTestFälle().add(map);				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
				}
		}
		
		return dao;

	}

	public void setPath(String path) {
		this.path = path;
	}

}
