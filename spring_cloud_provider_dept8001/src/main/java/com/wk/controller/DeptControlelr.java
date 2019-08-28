package com.wk.controller;

import com.wk.pojo.Dept;
import com.wk.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptControlelr {

	@Autowired
	private DeptService deptService;

	/**
	 * @RequestBody：将请求体中的json数据转换为java对象，
	 * 调用此方法的请求体需要是一个json类型的，指定类型content-type也得是json类型的
	 * @param dept
	 * @return
	 */
	@PostMapping("dept")
	public boolean addDept(@RequestBody Dept dept){
		return deptService.addDept(dept);
	}

	@GetMapping("dept/{id}")
	public Dept getDept(@PathVariable int id){
		return deptService.findById(id);
	}

	@GetMapping("dept")
	public List<Dept> getAll(){
		return deptService.findAll();
	}
}
