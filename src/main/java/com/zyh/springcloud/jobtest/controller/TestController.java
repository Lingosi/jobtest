package com.zyh.springcloud.jobtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zyh.springcloud.jobtest.service.JobService;

@RestController
@RequestMapping("/jobtest")
public class TestController {
	@Autowired
	JobService jobService;
	
	@ResponseBody
	@GetMapping(value="/delete")
	public String delete(String jobName){
		jobService.deleteJob(jobName);
		return "success";
	}
}
