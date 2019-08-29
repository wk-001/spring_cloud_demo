package com.wk.mapper;

import com.wk.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface DeptMapper {

	Dept findById(Integer deptNo);

	List<Dept> findAll();

	boolean addDept(Dept dept);
}
