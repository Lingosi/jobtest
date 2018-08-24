package com.zyh.springcloud.jobtest.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.zyh.springcloud.jobtest.service.JobService;

@Component
@Order(value=1)
public class Test1Command implements CommandLineRunner{
	
	//@Autowired
	//private ZookeeperRegistryCenter zookeeperRegistryCenter;
	@Autowired
	JobService jobService;
	
	static String jobName = "test1";
	static String jobClass = "com.zyh.springcloud.jobtest.config.TestJob";
	static String jobCorn = "0 0/1 * * * ?";

	public void run(String... arg0) throws Exception {
		//第三个执行
		//JobCoreConfiguration jobCoreConfiguration = JobCoreConfiguration.newBuilder(jobName, jobCorn, 1).shardingItemParameters("0=A").build();
		System.out.println("command 1 ............");
		jobService.addJob(jobName, jobClass, jobCorn);
		/*JobCoreConfiguration jobCoreConfiguration = JobCoreConfiguration.newBuilder(jobName, jobCorn, 1).shardingItemParameters("0=id:1&name:张三").build();
        SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(jobCoreConfiguration, getClass(jobClass).getCanonicalName());
        
        JobScheduler jobScheduler = new JobScheduler(zookeeperRegistryCenter, LiteJobConfiguration.newBuilder(simpleJobConfiguration).build());
        try {
            jobScheduler.init();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("定时任务创建失败");
        }*/
	}
	
	public static Class<?> getClass(String classname) throws Exception {
		Class<?> class1 = Class.forName(classname);
		return class1;
	}

}
