package com.zyh.springcloud.jobtest.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.springcloud.jobtest.dao.system.SchedulerDao;
import com.zyh.springcloud.jobtest.model.system.Scheduler;
import com.zyh.springcloud.jobtest.service.system.SchedulerService;

@Service
public class SchedulerServiceImpl implements SchedulerService {

	@Autowired
	SchedulerDao schedulerDao;
	
	@Override
	public List<Scheduler> getScheduler() {
		return schedulerDao.getScheduler();
	}

}
