package com.zero.dao.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.zero.dao.OracleDataDao;

public class OracleDataDaoImpl implements OracleDataDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List getList(Criterion criterion[], Class c, final int pageno,
			final int pagesize) {
		DetachedCriteria dc = DetachedCriteria.forClass(c);
		for (Criterion criterion2 : criterion) {
			dc.add(criterion2);
		}
		List data = hibernateTemplate.findByCriteria(dc, (pageno - 1)
				* pagesize, pagesize);
		return data;
	}

}
