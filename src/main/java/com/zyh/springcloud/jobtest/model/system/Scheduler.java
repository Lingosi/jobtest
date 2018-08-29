package com.zyh.springcloud.jobtest.model.system;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Scheduler extends BaseModel{
	private String name;
	private String corn;
	private int itemId;
}
