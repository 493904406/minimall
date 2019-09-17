package com.minimall.user.service.impl;


import com.minimall.db.domain.LitemallRegion;
import com.minimall.db.service.LitemallRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yxb
 * @date 2019-09-17
 **/
@Component
public class GetRegionService {

	@Autowired
	private LitemallRegionService regionService;

	private static List<LitemallRegion> litemallRegions;

	protected List<LitemallRegion> getLitemallRegions() {
		if(litemallRegions==null){
			createRegion();
		}
		return litemallRegions;
	}

	private synchronized void createRegion(){
		if (litemallRegions == null) {
			litemallRegions = regionService.getAll();
		}
	}
}
