package com.zyh.springcloud.jobtest.service.system.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.springcloud.jobtest.dao.system.TaskCommandDao;
import com.zyh.springcloud.jobtest.model.system.TaskCommand;
import com.zyh.springcloud.jobtest.service.system.TaskCommandService;

@Service
public class TaskCommandServiceImpl implements TaskCommandService {

	@Autowired
	TaskCommandDao taskCommandDao;
	
	@Override
	public TaskCommand getTaskCommandById(int id) {
		return taskCommandDao.getTaskCommand(id);
	}

}
