package com.zyh.springcloud.jobtest.dao.system;

import org.apache.ibatis.annotations.Mapper;

import com.zyh.springcloud.jobtest.model.system.TaskCommand;

@Mapper
public interface TaskCommandDao {
	TaskCommand getTaskCommand(int id);
}
