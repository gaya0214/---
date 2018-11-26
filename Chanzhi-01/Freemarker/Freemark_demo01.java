package com.freemark.hello.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.ITestResult;
import org.testng.annotations.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class Freemark_demo01 {
	@Test
public static void run(String TEMPLATE_PATH,String CLASS_PATH ,String ftl,Map datalist){
		// step1 创建freeMarker配置实例
    Configuration configuration = new Configuration();
    Writer out = null;
    try {
    	// step2 获取模版路径
        configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
        // step3 创建数据模型
        // step4 加载模版文件
        Template template = configuration.getTemplate(ftl);
        // step5 生成数据
        File docFile = new File(CLASS_PATH + "\\" + "demo3.html");
        out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
        // step6 输出文件
        template.process(datalist, out);
        System.out.println("demo1120.html生成了");
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (null != out) {
                out.flush();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
	
}
