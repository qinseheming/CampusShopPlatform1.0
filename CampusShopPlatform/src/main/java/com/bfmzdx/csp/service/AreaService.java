package com.bfmzdx.csp.service;

import java.util.List;

import com.bfmzdx.csp.entity.Area;

public interface AreaService {
	public static final String AREALISTKEY = "arealist";

	/**
	 * 获取区域列表，优先从缓存获取
	 * 
	 * @return
	 */
	List<Area> getAreaList();
}
