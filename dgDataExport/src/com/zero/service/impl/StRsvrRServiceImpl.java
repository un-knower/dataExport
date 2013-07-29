package com.zero.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zero.Page;
import com.zero.Pageable;
import com.zero.dao.StRsvrRDao;
import com.zero.entity.StRsvrR;
import com.zero.service.StRsvrRService;

@Service
public class StRsvrRServiceImpl extends BaseServiceImpl<StRsvrR, Long>
		implements StRsvrRService {
	@Autowired
	@Qualifier("stRsvrRDaoImpl")
	private StRsvrRDao stRsvrRDao;

	@Override
	@Transactional(readOnly = true)
	public Page<StRsvrR> findPage(Pageable pageable) {
		return stRsvrRDao.findPage(pageable);
	}

	public List<StRsvrR> findList(Date beginDate, Integer first, Integer count) {
		return stRsvrRDao.findList(beginDate,first,count);
	}

}
