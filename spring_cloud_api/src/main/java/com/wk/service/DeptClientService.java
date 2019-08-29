package com.wk.service;

import com.wk.pojo.Dept;
import com.wk.service.factory.DeptClientServiceFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//value：指定要调用的provider微服务名称,fallbackFactory：指定服务降级时使用的备选方案工厂
@FeignClient(value = "provider",fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientService {

	@PostMapping("dept")
	public boolean addDept(Dept dept);

	@GetMapping("dept/{id}")
	public Dept getDept(@PathVariable("id") int id);

	@GetMapping("dept")
	public List<Dept> getAll();
}
