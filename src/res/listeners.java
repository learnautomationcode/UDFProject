package res;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseTest;
import testcases.UDFUtility;

public class listeners extends BaseTest implements ITestListener  {
//BaseTest b=new BaseTest();



	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		//hey i am done
		
		extent.endTest(test);
		extent.flush();
		//extent.close();
		
	}

	public void onStart(ITestResult res) {
		// TODO Auto-generated method stub
		
		
		
		//
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//screenshot

		 TakesScreenshot scrShot =((TakesScreenshot) UDFUtility.driver);

	        //Call getScreenshotAs method to create image file

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	                Random r=new Random();
	        		int val=r.nextInt(1000);
	                
	                String dest=System.getProperty("user.dir")+"\\Screenshot\\"+result.getName()+val+"error.png";
	              File DestFile=new File(dest);
	                
	                String imgpath=dest;
	                

	                //Copy file at destination

	                try {
						FileUtils.copyFile(SrcFile, DestFile);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                
	                String img=test.addScreenCapture(imgpath);
			
			test.log(LogStatus.FAIL, img);

		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult res) {
		// TODO Auto-generated method stub
		
		test=extent.startTest(res.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		 //Convert web driver object to TakeScreenshot

	        TakesScreenshot scrShot =((TakesScreenshot) UDFUtility.driver);

	        //Call getScreenshotAs method to create image file

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	                Random r=new Random();
	        		int val=r.nextInt(1000);
	                
	                String dest=System.getProperty("user.dir")+"\\Screenshot\\"+result.getName()+val+".png";
	              File DestFile=new File(dest);
	                
	                String imgpath=dest;
	                

	                //Copy file at destination

	                try {
						FileUtils.copyFile(SrcFile, DestFile);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                
	                String img=test.addScreenCapture(imgpath);
			
			test.log(LogStatus.PASS, img);

		
	}

}
