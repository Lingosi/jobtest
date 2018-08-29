package com.zyh.springcloud.jobtest.model.system;

import lombok.Data;

@Data
public class TaskParamDef extends BaseModel{
	private int commandId;
	private String displayName;
	private String fieldType;
	private String fieldName;
	private String allowNull;
	private int orderNo;
	
}
