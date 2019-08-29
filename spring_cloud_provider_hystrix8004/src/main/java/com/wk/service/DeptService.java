package com.wk.service;

import com.wk.pojo.Dept;

import java.util.List;

public interface DeptService {

	Dept findById(Integer deptNo);

	List<Dept> findAll();

	boolean addDept(Dept dept);
}
