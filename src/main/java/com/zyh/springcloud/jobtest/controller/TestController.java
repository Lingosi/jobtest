package com.zyh.springcloud.jobtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zyh.springcloud.jobtest.model.system.Scheduler;
import com.zyh.springcloud.jobtest.model.system.TaskCommand;
import com.zyh.springcloud.jobtest.model.system.TaskItem;
import com.zyh.springcloud.jobtest.service.JobService;
import com.zyh.springcloud.jobtest.service.system.SchedulerService;
import com.zyh.springcloud.jobtest.service.system.TaskCommandService;
import com.zyh.springcloud.jobtest.service.system.TaskItemService;

@RestController
@RequestMapping("/jobtest")
public class TestController {
	@Autowired
	JobService jobService;
	@Autowired
	TaskItemService taskItemService;
	@Autowired
	SchedulerService schedulerService;
	@Autowired
	TaskCommandService taskCommandService;
	
	@ResponseBody
	@GetMapping(value="/delete")
	public String delete(String jobName){
		jobService.deleteJob(jobName);
		return "success";
	}
	
	@GetMapping(value="/getScheduler")
	public String getScheduler(){
		List<Scheduler> lsSchedulers = schedulerService.getScheduler();
		for(Scheduler item:lsSchedulers){
			int taskItemId = item.getItemId();
			String corn = item.getCorn();
			String name = item.getName();
			TaskItem taskItem = taskItemService.getTaskItemById(taskItemId);
			int commandId = taskItem.getCommandId();
			TaskCommand taskCommand = taskCommandService.getTaskCommandById(commandId);
			String jobClass = taskCommand.getJobClass();
			jobService.addJob(name, jobClass, corn, taskItem.getFieldValue());
		}
		System.out.println(lsSchedulers.size());
		return "taskitem";
	}
	
}
