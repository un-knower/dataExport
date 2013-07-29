package com.zero.service;

import java.util.Date;
import java.util.List;

import com.zero.entity.StRiverR;

public interface StRiverRService extends BaseService<StRiverR, Long> {
	List<StRiverR> findList( Date beginDate, Integer first, Integer count);
}
