package com.zyh.springcloud.jobtest.model.system;

import lombok.Data;

@Data
public class TaskItem extends BaseModel{
	private String name;
	private int commandId;
	private String description;
	private String fieldValue;
}
