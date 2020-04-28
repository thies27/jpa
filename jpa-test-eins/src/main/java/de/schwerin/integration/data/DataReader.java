package de.schwerin.integration.data;

import java.awt.desktop.FilesEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import de.schwerin.integration.dao.IntegrationDao;

public class DataReader {
	
	
	public void readFromFile() {
		
		String path = "/home/mathias/temp/testcases.txt";
				
		File file = new File(path);
		assert file.exists() : true;
		
        if (!file.canRead() || !file.isFile())
            System.exit(0);

            BufferedReader in = null;
            IntegrationDao dao = new IntegrationDao();
            
        try {
            in = new BufferedReader(new FileReader(path));
            String zeile = null;
            while ((zeile = in.readLine()) != null) {
                System.out.println("Gelesene Zeile: " + zeile);
                String[] str1 = zeile.split(".");
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
		
	}

}
