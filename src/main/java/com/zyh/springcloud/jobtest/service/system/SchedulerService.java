package com.zyh.springcloud.jobtest.service.system;

import java.util.List;

import com.zyh.springcloud.jobtest.model.system.Scheduler;

public interface SchedulerService {
	List<Scheduler> getScheduler();
}
