package com.zero.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

public interface OracleDataDao {
	List getList(Criterion criterion[], Class c, int pageno, int pagesize);
}
