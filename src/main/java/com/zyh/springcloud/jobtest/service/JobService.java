package com.zyh.springcloud.jobtest.service;

public interface JobService {
	void addJob(String jobName, String jobClass, String jobCorn, String jobParameter);
	
	boolean deleteJob(String jobName);
}
