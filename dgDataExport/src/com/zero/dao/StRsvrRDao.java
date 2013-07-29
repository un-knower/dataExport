package com.zero.dao;

import java.util.Date;
import java.util.List;

import com.zero.entity.StRsvrR;

public interface StRsvrRDao extends BaseDao<StRsvrR, Long> {
	List<StRsvrR> findList(Date beginDate, Integer first, Integer count);

}
