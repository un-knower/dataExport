package com.zero.service;

import java.util.Date;
import java.util.List;


import com.zero.entity.StPptnR;

public interface StPptnRService extends BaseService<StPptnR, Long> {
	List<StPptnR> findList( Date beginDate, Integer first, Integer count);
}
