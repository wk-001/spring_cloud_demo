package com.wk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer			//标记当前微服务为注册中心，接受其他微服务的注册
public class EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class,args);
	}

}
