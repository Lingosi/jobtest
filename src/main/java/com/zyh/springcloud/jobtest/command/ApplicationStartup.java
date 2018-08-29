package com.zyh.springcloud.jobtest.command;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent>{

	public void onApplicationEvent(ContextRefreshedEvent event) {
		//第二个执行
		System.out.println("startup..............");
		
	}

}
