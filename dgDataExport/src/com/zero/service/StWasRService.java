package com.zero.service;

import java.util.Date;
import java.util.List;

import com.zero.entity.StWasR;

public interface StWasRService extends BaseService<StWasR, Long> {
	List<StWasR> findList( Date beginDate, Integer first, Integer count);

}
