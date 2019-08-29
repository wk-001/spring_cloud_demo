package com.wk.service;

import com.wk.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "provider")		//指定要调用的provider微服务名称
public interface DeptClientService {

	@PostMapping("dept")
	public boolean addDept(Dept dept);

	@GetMapping("dept/{id}")
	public Dept getDept(@PathVariable int id);

	@GetMapping("dept")
	public List<Dept> getAll();
}
