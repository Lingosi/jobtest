package com.zyh.springcloud.jobtest.service.impl;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.zyh.springcloud.jobtest.service.JobService;

@Service
public class JobServiceImpl implements JobService{
	@Autowired
	ZookeeperRegistryCenter zookeeperRegistryCenter;

	public void addJob(String jobName, String jobClass, String jobCorn) {
		try {
			JobCoreConfiguration jobCoreConfiguration = JobCoreConfiguration.newBuilder(jobName, jobCorn, 1).jobParameter("123?aaa").shardingItemParameters("0=id:1&name:张三").build();
	        SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(jobCoreConfiguration, getClass(jobClass).getCanonicalName());
	        
	        JobScheduler jobScheduler = new JobScheduler(zookeeperRegistryCenter, LiteJobConfiguration.newBuilder(simpleJobConfiguration).build());
	        
            jobScheduler.init();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("定时任务创建失败");
        }
	}
	
	public Class<?> getClass(String classname) throws Exception {
		Class<?> class1 = Class.forName(classname);
		return class1;
	}

	public boolean deleteJob(String jobName) {		
		try {
			CuratorFramework client = zookeeperRegistryCenter.getClient();
			client.delete().deletingChildrenIfNeeded().forPath("/" + jobName);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
