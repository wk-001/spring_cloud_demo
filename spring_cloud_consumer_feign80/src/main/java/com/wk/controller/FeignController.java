package com.wk.controller;

import com.wk.pojo.Dept;
import com.wk.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignController {

	@Autowired
	private DeptClientService deptClientService;

	@PostMapping("dept")
	public boolean add(Dept dept){
		return deptClientService.addDept(dept);
	}

	@GetMapping("dept/{id}")
	public Dept get(@PathVariable int id){
		return deptClientService.getDept(id);
	}

	@GetMapping("dept")
	public List<Dept> getAll(){
		return deptClientService.getAll();
	}

}
