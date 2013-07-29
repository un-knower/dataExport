package com.zero.dao;

import java.util.Date;
import java.util.List;

import com.zero.entity.StWasR;

public interface StWasRDao extends BaseDao<StWasR, Long> {
	List<StWasR> findList(Date beginDate, Integer first, Integer count);

}
