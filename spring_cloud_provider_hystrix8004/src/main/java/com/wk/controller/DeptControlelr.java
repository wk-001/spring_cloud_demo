package com.wk.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wk.pojo.Dept;
import com.wk.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Calendar;
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
	@HystrixCommand(fallbackMethod = "getHystrix")		//指定此方法熔断后调用的备用方法
	public Dept getDept(@PathVariable int id) throws Exception {
		//测试熔断
		if(id==111){
			throw  new Exception("");
		}
		if(id==222){
			Thread.sleep(5000);
		}
		return deptService.findById(id);
	}

	//原方法熔断后的备用方法
	public Dept getHystrix(@PathVariable int id){
		return new Dept(id,"did not get valid data from database","no data");
	}

	@GetMapping("dept")
	@HystrixCommand(fallbackMethod = "getAllHystrix")
	public List<Dept> getAll() throws Exception {
		int time = Calendar.getInstance().get(Calendar.SECOND);
		//获取当前时间秒值，如果能被5整除就抛异常
		if(time%5==0){
			throw new Exception();
		}
		return deptService.findAll();
	}

	public List<Dept> getAllHystrix(){
		return Arrays.asList(new Dept(null,"did not get valid data from database","no data"));
	}
}
