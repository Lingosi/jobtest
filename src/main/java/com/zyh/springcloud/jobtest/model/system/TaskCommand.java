package com.zyh.springcloud.jobtest.model.system;

import lombok.Data;

@Data
public class TaskCommand extends BaseModel{
	private String name;
	private String jobClass;
}
