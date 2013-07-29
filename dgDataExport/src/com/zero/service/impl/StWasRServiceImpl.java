package com.zero.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zero.Page;
import com.zero.Pageable;
import com.zero.dao.StWasRDao;
import com.zero.entity.StWasR;
import com.zero.service.StWasRService;

@Service
public class StWasRServiceImpl extends BaseServiceImpl<StWasR, Long> implements
StWasRService {
	@Autowired
	@Qualifier("stWasRDaoImpl")
	private StWasRDao stWasRDao;

	@Override
	@Transactional(readOnly = true)
	public Page<StWasR> findPage(Pageable pageable) {
		return stWasRDao.findPage(pageable);
	}
	public List<StWasR> findList(Date beginDate, Integer first, Integer count) {
		return stWasRDao.findList(beginDate,first,count);
	}
}
