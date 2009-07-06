package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Properties;

public class SystemConfiguration {

	public static String getProxNum() throws FileNotFoundException, IOException{
		Properties properties = new Properties();
		properties.load(new FileInputStream("config.properties"));
		
		return properties.getProperty("proxNum");
		
	}
	
	public static void setProxNum() throws FileNotFoundException, IOException{
		String proxNum = getProxNum();
		int prox = Integer.parseInt(proxNum);
		prox++;
		
		Properties properties = new Properties();
		File file = new File("config.properties");
		properties.load(new FileInputStream(file));
		
		properties.setProperty("proxNum",String.valueOf(prox));
		
		properties.store(new FileOutputStream(file), null);
		
	}
	
	
	public static void createFileConfig() throws FileNotFoundException, IOException{
		
		File file = new File("config.properties");
		if(!file.exists()){
			Properties properties = new Properties();
			@SuppressWarnings("unused") ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			properties.load(new FileInputStream(file));
			properties.setProperty("proxNum","54");
			properties.store(new FileOutputStream(file), null);
		}
	}
	/*public static String getDirPhotos(){
		
	}
	public static String getDirMinutas(){
		
	}
	public static String getDirHistoricoMembros(){
		
	}
	public static String getDirHistDep(){
		
	}*/
	
	
}
