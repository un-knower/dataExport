package com.zero.dao;

import java.util.Date;
import java.util.List;

import com.zero.entity.StPptnR;

public interface StPptnRDao extends BaseDao<StPptnR, Long> {
	List<StPptnR> findList(Date beginDate, Integer first, Integer count);
}
