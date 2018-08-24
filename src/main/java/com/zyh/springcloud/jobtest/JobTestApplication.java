package com.zyh.springcloud.jobtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zyh.springcloud.jobtest.command.ApplicationInitner;
import com.zyh.springcloud.jobtest.command.ApplicationStartup;

@SpringBootApplication
public class JobTestApplication {
    public static void main(String[] args){
    	SpringApplication sa = new SpringApplication(JobTestApplication.class);
    	
    	sa.addInitializers(new ApplicationInitner());
    	sa.addListeners(new ApplicationStartup());
    	sa.run(args);
    	//SpringApplication.run(JobTestApplication.class, args);
        System.out.println( "Hello World!" );
    }
}
