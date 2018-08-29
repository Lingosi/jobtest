package com.zyh.springcloud.jobtest.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zyh.springcloud.jobtest.model.system.Scheduler;

@Mapper
public interface SchedulerDao {
	List<Scheduler> getScheduler();
}
