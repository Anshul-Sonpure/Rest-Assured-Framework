package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ListenerTest implements ITestListener {
   
	public static Logger loger = LogManager.getLogger("gorest");
    
    @Override
    public void onTestStart(ITestResult result) {
       
        String classname = result.getTestClass().getName();
        classname=classname.replace("testEndPoints.","");
        
        loger.log(Level.INFO,"TestName: "+result.getMethod().getMethodName());
        loger.log(Level.INFO,"Author Name: "+System.getProperty("user.name"));
        
         
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	
    	loger.log(Level.INFO,"Test Case: "+result.getMethod().getMethodName()+ " is passed.\n");
    	
        
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	loger.log(Level.INFO,result.getThrowable());
    	loger.log(Level.INFO,"Test Case: "+result.getMethod().getMethodName()+ " is failed.\n");
 
        
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	loger.log(Level.INFO,result.getThrowable());
    	loger.log(Level.INFO,"Test Case: "+result.getMethod().getMethodName()+ " is skipped.\n");
     
     
    }


    @Override
    public void onFinish(ITestContext context) {
    	loger.log(Level.INFO,"All data is being logged in log file\n");
    }
    
    

}
