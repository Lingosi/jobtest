package com.zyh.springcloud.jobtest.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.zyh.springcloud.jobtest.model.system.Scheduler;
import com.zyh.springcloud.jobtest.model.system.TaskCommand;
import com.zyh.springcloud.jobtest.model.system.TaskItem;
import com.zyh.springcloud.jobtest.service.JobService;
import com.zyh.springcloud.jobtest.service.system.SchedulerService;
import com.zyh.springcloud.jobtest.service.system.TaskCommandService;
import com.zyh.springcloud.jobtest.service.system.TaskItemService;

@Component
@Order(value=1)
public class Test1Command implements CommandLineRunner{
	
	//@Autowired
	//private ZookeeperRegistryCenter zookeeperRegistryCenter;
	@Autowired
	JobService jobService;
	
	@Autowired
	TaskItemService taskItemService;
	@Autowired
	SchedulerService schedulerService;
	@Autowired
	TaskCommandService taskCommandService;
	
	static String jobName = "test1";
	static String jobClass = "com.zyh.springcloud.jobtest.config.TestJob";
	static String jobCorn = "0 0/1 * * * ?";

	public void run(String... arg0) throws Exception {
		//第三个执行
		//JobCoreConfiguration jobCoreConfiguration = JobCoreConfiguration.newBuilder(jobName, jobCorn, 1).shardingItemParameters("0=A").build();
		System.out.println("command 1 ............");
		////暂时注释一下 jobService.addJob(jobName, jobClass, jobCorn);
		/*JobCoreConfiguration jobCoreConfiguration = JobCoreConfiguration.newBuilder(jobName, jobCorn, 1).shardingItemParameters("0=id:1&name:张三").build();
        SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(jobCoreConfiguration, getClass(jobClass).getCanonicalName());
        
        JobScheduler jobScheduler = new JobScheduler(zookeeperRegistryCenter, LiteJobConfiguration.newBuilder(simpleJobConfiguration).build());
        try {
            jobScheduler.init();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("定时任务创建失败");
        }*/
		
		List<Scheduler> lsSchedulers = schedulerService.getScheduler();
		System.out.println("定时任务：" + lsSchedulers.size());
		for(Scheduler item:lsSchedulers){
			int taskItemId = item.getItemId();
			String corn = item.getCorn();
			String name = item.getName();
			TaskItem taskItem = taskItemService.getTaskItemById(taskItemId);
			int commandId = taskItem.getCommandId();
			TaskCommand taskCommand = taskCommandService.getTaskCommandById(commandId);
			String jobClass = taskCommand.getJobClass();
			jobService.addJob(name, jobClass, corn, taskItem.getFieldValue());
			System.out.println(String.format("定时任务：%s， jobclass：%s，表达式：%s", name, jobClass, corn));
		}
	}
	
	public static Class<?> getClass(String classname) throws Exception {
		Class<?> class1 = Class.forName(classname);
		return class1;
	}

}
