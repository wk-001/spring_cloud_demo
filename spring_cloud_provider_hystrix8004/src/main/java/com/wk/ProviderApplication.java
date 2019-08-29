package com.wk;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.wk.mapper")
//启用eureka客户端功能，使当前微服务可以在eureka中注册/获取服务信息（服务的注册和发现）
@EnableEurekaClient
@EnableCircuitBreaker		//启用断路器功能
public class ProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class,args);
	}

	/**
	 * SpringBoot2.0以上需要添加该组件
	 * hystrixDashboard启动后需要输入的信息：
	 * 	http://localhost:8004/actuator/hystrix.stream
	 * 	8004是被监控的添加熔断机制的微服务端口
	 * @return
	 */
	@Bean
	public ServletRegistrationBean getServlet(){
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/actuator/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}
}
