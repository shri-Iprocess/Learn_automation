package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {
	
	
	public static String CaptureScreenshot(WebDriver driver,String Screenshotname){
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
          	File src=	ts.getScreenshotAs(OutputType.FILE);
		
			String dest="./ScreenShot/"+Screenshotname+System.currentTimeMillis()+".png";
	
	          try {
				FileUtils.copyFile(src, new File(dest));
			} catch (IOException e) {
				System.out.println("Failed to Capture Screenshot" + e.getMessage());
			}
	          
	          return dest;
	          
	}

}
