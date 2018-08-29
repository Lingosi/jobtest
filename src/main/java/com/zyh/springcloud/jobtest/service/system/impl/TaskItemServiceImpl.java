package com.zyh.springcloud.jobtest.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.springcloud.jobtest.dao.system.TaskItemDao;
import com.zyh.springcloud.jobtest.model.system.TaskItem;
import com.zyh.springcloud.jobtest.service.system.TaskItemService;

@Service
public class TaskItemServiceImpl implements TaskItemService {
	@Autowired
	TaskItemDao taskItemDao;
	
	@Override
	public List<TaskItem> getTaskItems() {
		
		return taskItemDao.getTaskItems();
	}

	@Override
	public TaskItem getTaskItemById(int id) {
		return taskItemDao.getTaskItem(id);
	}

}
