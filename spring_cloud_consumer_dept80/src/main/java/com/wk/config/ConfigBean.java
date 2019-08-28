package com.wk.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

	@Bean
	@LoadBalanced		//启用ribbon的负载均衡功能
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
