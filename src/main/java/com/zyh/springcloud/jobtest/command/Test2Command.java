package com.zyh.springcloud.jobtest.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=1)
public class Test2Command implements CommandLineRunner{

	public void run(String... arg0) throws Exception {
		//第四个执行
		System.out.println("command 2 ............");
		
	}

}
