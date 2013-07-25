package com.zero.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zero.Page;
import com.zero.Pageable;
import com.zero.dao.StRiverRDao;
import com.zero.entity.StRiverR;
import com.zero.service.StRiverRService;

@Service
public class StRiverRServiceImpl extends BaseServiceImpl<StRiverR, Long>
		implements StRiverRService {
	@Autowired
	@Qualifier("stRiverRDaoImpl")
	private StRiverRDao stRiverRDao;

	@Override
	@Transactional(readOnly = true)
	public Page<StRiverR> findPage(Pageable pageable) {
		return stRiverRDao.findPage(pageable);
	}

}
