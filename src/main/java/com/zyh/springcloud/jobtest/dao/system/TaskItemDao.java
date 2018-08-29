package com.zyh.springcloud.jobtest.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zyh.springcloud.jobtest.model.system.TaskItem;

@Mapper
public interface TaskItemDao {
	TaskItem getTaskItem(int id);
	
	List<TaskItem> getTaskItems();
}
