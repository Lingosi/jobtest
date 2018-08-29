package com.zyh.springcloud.jobtest.service.system;

import java.util.List;

import com.zyh.springcloud.jobtest.model.system.TaskItem;

public interface TaskItemService {
	List<TaskItem> getTaskItems();
	
	TaskItem getTaskItemById(int id);
}
