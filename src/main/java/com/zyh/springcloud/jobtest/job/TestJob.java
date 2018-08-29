package com.zyh.springcloud.jobtest.job;

import java.util.Date;

public class TestJob extends Job{
	public void invoke(String paytype, Date paydate, String userId){
    	System.out.println("我是invoke方法*******");
    	System.out.println("paytype: " + paytype);
    	System.out.println("paydate: " + paydate);
    	System.out.println("userid：" + userId);
    }
}
