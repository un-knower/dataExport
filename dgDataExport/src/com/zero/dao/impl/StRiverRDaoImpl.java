package com.zero.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.zero.dao.StRiverRDao;
import com.zero.entity.StRiverR;

@Repository
public class StRiverRDaoImpl extends BaseDaoImpl<StRiverR, Long> implements
StRiverRDao {

	public List<StRiverR> findList(Date beginDate, Integer first, Integer count) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StRiverR> criteriaQuery = criteriaBuilder.createQuery(StRiverR.class);
		Root<StRiverR> root = criteriaQuery.from(StRiverR.class);
		criteriaQuery.select(root);
		Predicate restrictions = criteriaBuilder.conjunction();
		if (beginDate != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.greaterThan(root.get("id").<Date> get("tm"), beginDate));
		}
		criteriaQuery.where(restrictions);
		criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id").<Date> get("tm")));
		return super.findList(criteriaQuery, first, count, null, null);
	}
}
