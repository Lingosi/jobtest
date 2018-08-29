package com.zyh.springcloud.jobtest.config;

import java.lang.annotation.*;

import org.springframework.context.annotation.Import;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(
		{DataSourceConfig.class,
		MybatisPlusConfig.class}
		)
public @interface EnableMybatisPlus {

}
