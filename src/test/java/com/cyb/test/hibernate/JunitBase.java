package com.cyb.test.hibernate;

import org.jbpm.api.ExecutionService;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.RepositoryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class JunitBase {
	public ProcessEngine processEngine ;
	public RepositoryService repositoryService;
	public ExecutionService executionService;
	public ApplicationContext fac=null;
	public ApplicationContext ac = null;
	public JunitBase(){
		/*fac =new FileSystemXmlApplicationContext(	
						"classpath:applicationContext_base.xml",
						"classpath:applicationContext_druid.xml",
						"classpath:applicationContext_druid_1.xml",
						"classpath:applicationContext_mail.xml",
						"classpath:applicationContext_quatarz.xml",
						"classpath:applicationContext_websocket.xml"
				);*/
		ac = new ClassPathXmlApplicationContext(
						"classpath:applicationContext_base.xml",
						"classpath:applicationContext_druid.xml",
						//"classpath:applicationContext_druid_1.xml",
						"classpath:applicationContext_mail.xml",
						"classpath:applicationContext_quatarz.xml",
						"classpath:applicationContext_websocket.xml"
						);// 从classpath中加载
	 //repositoryService =  (RepositoryService) ac.getBean("repositoryService");
	 //executionService =  (ExecutionService) ac.getBean("executionService");
	}
}
