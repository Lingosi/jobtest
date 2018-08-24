package com.zyh.springcloud.jobtest.command;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class ApplicationInitner implements ApplicationContextInitializer<ConfigurableApplicationContext>{

	public void initialize(ConfigurableApplicationContext applicationContext) {
		//第一个执行
		System.out.println("initialize..................");
		
	}

}
