package com.zero.dao;

import java.util.Date;
import java.util.List;

import com.zero.entity.StRiverR;

public interface StRiverRDao extends BaseDao<StRiverR, Long> {
	List<StRiverR> findList(Date beginDate, Integer first, Integer count);

}
