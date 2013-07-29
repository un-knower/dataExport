package com.zero.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.zero.dao.StRsvrRDao;
import com.zero.entity.StRsvrR;

@Repository
public class StRsvrRDaoImpl extends BaseDaoImpl<StRsvrR, Long> implements
StRsvrRDao {
	public List<StRsvrR> findList(Date beginDate, Integer first, Integer count) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StRsvrR> criteriaQuery = criteriaBuilder.createQuery(StRsvrR.class);
		Root<StRsvrR> root = criteriaQuery.from(StRsvrR.class);
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
