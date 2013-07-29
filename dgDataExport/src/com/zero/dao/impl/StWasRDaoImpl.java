package com.zero.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.zero.dao.StWasRDao;
import com.zero.entity.StWasR;

@Repository
public class StWasRDaoImpl extends BaseDaoImpl<StWasR, Long> implements
StWasRDao {
	public List<StWasR> findList(Date beginDate, Integer first, Integer count) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StWasR> criteriaQuery = criteriaBuilder.createQuery(StWasR.class);
		Root<StWasR> root = criteriaQuery.from(StWasR.class);
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
