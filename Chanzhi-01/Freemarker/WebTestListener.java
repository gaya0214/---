package com.webtest.core;

import org.testng.annotations.Test;
import com.freemark.hello.demo.Freemark_demo01;
import com.freemark.hello.demo.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;

import com.webtest.utils.Log;

/**
 * author:lihuanzhen
 * 监听器，用例失败，截屏
 */


public class WebTestListener  extends TestListenerAdapter{
	  @Override
	  public void onTestFailure(ITestResult tr) {
		  
		  Log.error(tr.getInstance()+"-"+tr.getName()+"运行失败，需要截屏");
		  BaseTest tb = (BaseTest) tr.getInstance();
          WebDriver driver = tb.getDriver();    
		  SeleniumScreenShot ss = new SeleniumScreenShot(driver);
		  ss.screenShot();
		  
	  }
	  
	  @Test
	  @Override
	public void onFinish(ITestContext testContext) {
		  Map<ITestResult, List> success_path = null ;
		  Map<ITestResult, List> fail_path = null ;
		// TODO 自动生成的方法存根
		super.onFinish(testContext);
		/*List<ITestResult> fail=this.getFailedTests();
		 List<ITestResult> success=this.getPassedTests(); */ 
		
		/*Map<ITestResult,List> mapfail = new HashMap<>();
        for (ITestResult list : fail) {
            mapfail.put(list, fail);
        }
         System.out.println("map失败"+fail);*/
       
      
       /* Map<ITestResult,List> mapsuccess = new HashMap<>();
        for (ITestResult list : success) {
            mapsuccess.put(list, success);
        }
        System.out.println("map成功"+success);*/
		
		/*获取失败的测试用例并将list转换成map类型*/
		Map datalist=new HashMap();
		
		List<ITestResult> fail=this.getFailedTests();
		List<ITestResult> success=this.getPassedTests(); 
		
		datalist.put("success_path",success);
		datalist.put("fail_path",fail);
		
		System.out.println("map成功"+success);
		System.out.println("map失败"+fail);
		
        Freemark_demo01.run("src/com/freemark/hello/templates", "src/com/freemark/hello/demo", "freemarkdemo02.ftl", datalist);
		
		/*1、获取测试结果，map存储
		2、FreemarkerDemo 方法 run 把map内容模板化 作为邮件正文
		3、使用Email类发送邮件
		*/
		
		
	}
	  
}
