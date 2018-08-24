package com.zyh.springcloud.jobtest.service;

public interface JobService {
	void addJob(String jobName, String jobClass, String jobCorn);
	
	boolean deleteJob(String jobName);
}
