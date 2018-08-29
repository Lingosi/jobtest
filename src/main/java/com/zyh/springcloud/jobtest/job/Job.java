package com.zyh.springcloud.jobtest.job;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.util.ReflectionUtils;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.zyh.springcloud.jobtest.util.StringUtil;
import com.zyh.springcloud.jobtest.util.TypeConverter;

public class Job implements SimpleJob {
	private static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final String METHOD_NAME = "invoke";
	private static final String USER_ID = "server";

    public void execute(ShardingContext shardingContext) {
        System.out.println(String.format("------Time：%s,Thread ID: %s, 任务总片数: %s, " +
                        "当前分片项: %s.当前参数: %s,"+
                        "当前任务名称: %s.当前任务参数: %s"
                ,
                sdfTime.format(new Date()),
                Thread.currentThread().getId(),
                shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(),
                shardingContext.getShardingParameter(),
                shardingContext.getJobName(),
                shardingContext.getJobParameter()
                
        ));
        try{
	        String taskParams = shardingContext.getJobParameter();
	        taskParams += "operatorid:"+USER_ID;
	        String[] arguments = taskParams.split("#");
			Method[] targetObjMethods = ReflectionUtils.getAllDeclaredMethods(this.getClass());
			System.out.println("当前对象：" + this + "，当前类：" + this.getClass());
			Object[] actualArguments = new Object[arguments.length];
			getTaskMethodParams(METHOD_NAME, arguments, targetObjMethods, actualArguments, USER_ID);
			MethodUtils.invokeMethod(this, METHOD_NAME, actualArguments);
        }catch(Exception ex){
        	ex.printStackTrace();
        }
    }
    
    
    
    
    private void getTaskMethodParams(final String targetMethod, final String[] arguments, final Method[] targetObjMethods, Object[] actualArguments, final String userId) {
		int paramLength = arguments.length - 1;
		for (Method methodObject : targetObjMethods) {
			if (methodObject.getName().equals(targetMethod)&&methodObject.getParameterTypes().length == arguments.length) {
				Class<?>[] paramTypes = methodObject.getParameterTypes();
				int index = 0;
				for (Class<?> clazz : paramTypes) {
					String param = arguments[index];
					String[] params = param.split(":");// 参数的形式如orgids:0_develop
					String tempParam = "";
					if (params.length == 2) {
						tempParam = params[1];
					}
					if (List.class.isAssignableFrom(clazz)) {
						List<String> list = new ArrayList<String>();
						StringUtil.string2List(tempParam, list);
						actualArguments[index] = list;
					}else if (Date.class.isAssignableFrom(clazz)) {
						if(tempParam.indexOf("-")<1){
							actualArguments[index]=DateUtils.addDays(DateUtils.truncate(new Date(), Calendar.DATE), Integer.parseInt(tempParam));
						}else{
							actualArguments[index] = TypeConverter.convertToBasicType(clazz, tempParam);
						}
					}else {
						// 任务调用函数入参最后一个参数约定为任务调用者，直接进行指定给任务方法
						if (paramLength == index) {
							actualArguments[index] = userId;
						} else {
							actualArguments[index] = TypeConverter.convertToBasicType(clazz, tempParam);
						}
					}
					index++;
				}
				break;
			}
		}
	}
    
    

}
