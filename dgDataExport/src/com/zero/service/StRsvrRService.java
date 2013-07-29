package com.zero.service;

import java.util.Date;
import java.util.List;

import com.zero.entity.StRsvrR;

public interface StRsvrRService extends BaseService<StRsvrR, Long> {
	List<StRsvrR> findList( Date beginDate, Integer first, Integer count);

}
