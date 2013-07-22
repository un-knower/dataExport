package com.zero.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zero.dao.OracleDataDao;
import com.zero.entity.StPptnR;
import com.zero.service.OracleDataService;

@Service("oracleDataServiceImpl")
public class OracleDataServiceImpl implements OracleDataService {
	@Autowired
	@Qualifier("oracleDataDaoImpl")
	private OracleDataDao oracleDataDao;

	public List getStPPTNRList(Date tm, int pageno, int pagesize) {
		Criterion criterions[] = { Restrictions.gt("id.tm", tm) };
		List data = oracleDataDao.getList(criterions, StPptnR.class, pageno,
				pagesize);
		return data;
	}
}
