package com.wk.service.factory;

import com.wk.pojo.Dept;
import com.wk.service.DeptClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * consumer服务降级,提供备选方案
 * 当前类作为降级机制的备用方案，必须实现FallbackFactory接口，接口泛型的类型是feign接口类型
 */

@Component		//当前类的对象被扫描后加入到IOC容器，要保证该类所在包能被扫描到
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable throwable) {
		return new DeptClientService() {
			@Override
			public boolean addDept(Dept dept) {
				return false;
			}

			@Override
			public Dept getDept(int id) {
				//在consumer提供一个provider调用失败后的备用返回值
				return new Dept(id,"provider method call failed，return custom data","provider method call failed，return custom data");
			}

			@Override
			public List<Dept> getAll() {
				return null;
			}
		};
	}
}
