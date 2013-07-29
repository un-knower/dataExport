package com.zero.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.zero.dao.StPptnRDao;
import com.zero.entity.StPptnR;

@Repository
public class StPptnRDaoImpl extends BaseDaoImpl<StPptnR, Long> implements
StPptnRDao {

	public List<StPptnR> findList(Date beginDate, Integer first, Integer count) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StPptnR> criteriaQuery = criteriaBuilder.createQuery(StPptnR.class);
		Root<StPptnR> root = criteriaQuery.from(StPptnR.class);
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
