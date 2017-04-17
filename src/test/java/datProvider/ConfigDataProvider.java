	package datProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	
	Properties prop;
	
	public ConfigDataProvider(){
		
		
		File src=new File("./Configuration/Config.properties");
		
		try {
			
			FileInputStream file=new FileInputStream(src);
			
			 prop=new Properties();
			
			prop.load(file);
		
		} catch (Exception e) {
		
			System.out.println("Exception is "+e.getMessage());
		}
		
	}
	
	
	public String getApplicationURL(){
		
		
		String url=prop.getProperty("url");
		
		return url;
		
	}
	
	
	
public String getChromePath(){
		
		
		String chromepath=prop.getProperty("chromepath");
		
		return chromepath;
		
	}



public String getfirefoxpath(){
	
	
	String firefoxpath=prop.getProperty("firefoxpath");
	
	return firefoxpath;
	
}
public String getIEPath(){
	
	
	String IEpath=prop.getProperty("IE");
	
	return IEpath;
	
}
	

}
