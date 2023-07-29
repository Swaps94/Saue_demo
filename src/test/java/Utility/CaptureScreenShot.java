package Utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.base.BaseClass;

public class CaptureScreenShot extends BaseClass{

//Screenshot Capturing code for failed test cases
	public static void ScreenShot(String nameOfMethod) throws IOException
	{   
		Date date=new Date();
		String d=date.toString().replace(" ", "-").replace(":", "_") + ".jpg";
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\java\\channelproject\\screenshots\\"+nameOfMethod+"---"+d);
		FileHandler.copy(src, des);
		
	}

}
