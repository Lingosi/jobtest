package com.zyh.springcloud.jobtest.model.system;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class BaseModel implements Serializable{
	private int id;
	private Date createdOn;
	private String createdBy;
	private Date lastModifiedOn;
	private String lastModifiedBy;
}
