package com.wk.mapper;

import com.wk.pojo.Dept;

import java.util.List;

public interface DeptMapper {

	Dept findById(Integer deptNo);

	List<Dept> findAll();

	boolean addDept(Dept dept);
}
