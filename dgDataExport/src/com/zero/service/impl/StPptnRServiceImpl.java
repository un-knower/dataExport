package com.zero.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zero.Page;
import com.zero.Pageable;
import com.zero.dao.StPptnRDao;
import com.zero.entity.StPptnR;
import com.zero.service.StPptnRService;

@Service
public class StPptnRServiceImpl extends BaseServiceImpl<StPptnR, Long>
		implements StPptnRService {
	@Autowired
	@Qualifier("stPptnRDaoImpl")
	private StPptnRDao stPptnRDao;

	@Override
	@Transactional(readOnly = true)
	public Page<StPptnR> findPage(Pageable pageable) {
		return stPptnRDao.findPage(pageable);
	}

}
