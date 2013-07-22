package com.zero.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.test.util.DateUtil;
import com.zero.CommonAttributes;

/**
 * StPptnR entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ST_PPTN_R")
public class StPptnR implements java.io.Serializable {

	// Fields

	private StPptnRId id;
	private Double drp;
	private Double intv;
	private Double pdr;
	private Double dyp;
	private String wth;
	private String rntypeGd;
	private String mdps;
	private Date mddt;

	// Constructors

	/** default constructor */
	public StPptnR() {
	}

	/** minimal constructor */
	public StPptnR(StPptnRId id) {
		this.id = id;
	}

	/** full constructor */
	public StPptnR(StPptnRId id, Double drp, Double intv, Double pdr,
			Double dyp, String wth, String rntypeGd, String mdps, Date mddt) {
		this.id = id;
		this.drp = drp;
		this.intv = intv;
		this.pdr = pdr;
		this.dyp = dyp;
		this.wth = wth;
		this.rntypeGd = rntypeGd;
		this.mdps = mdps;
		this.mddt = mddt;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "tm", column = @Column(name = "TM", nullable = false, length = 7)),
			@AttributeOverride(name = "stcd", column = @Column(name = "STCD", nullable = false, length = 16)) })
	public StPptnRId getId() {
		return id;
	}

	public void setId(StPptnRId id) {
		this.id = id;
	}

	@Column(name = "DRP", precision = 5, scale = 1)
	public Double getDrp() {
		return drp;
	}

	public void setDrp(Double drp) {
		this.drp = drp;
	}

	@Column(name = "INTV", precision = 5)
	public Double getIntv() {
		return intv;
	}

	public void setIntv(Double intv) {
		this.intv = intv;
	}

	@Column(name = "PDR", precision = 5)
	public Double getPdr() {
		return pdr;
	}

	public void setPdr(Double pdr) {
		this.pdr = pdr;
	}

	@Column(name = "DYP", precision = 5, scale = 1)
	public Double getDyp() {
		return dyp;
	}

	public void setDyp(Double dyp) {
		this.dyp = dyp;
	}

	@Column(name = "WTH", length = 1)
	public String getWth() {
		return wth;
	}

	public void setWth(String wth) {
		this.wth = wth;
	}

	@Column(name = "RNTYPE_GD", length = 1)
	public String getRntypeGd() {
		return rntypeGd;
	}

	public void setRntypeGd(String rntypeGd) {
		this.rntypeGd = rntypeGd;
	}

	@Column(name = "MDPS", length = 30)
	public String getMdps() {
		return mdps;
	}

	public void setMdps(String mdps) {
		this.mdps = mdps;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MDDT", length = 7)
	public Date getMddt() {
		return mddt;
	}

	public void setMddt(Date mddt) {
		this.mddt = mddt;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(id.getStcd() + ",");
		sb.append(DateUtil.getDateStr(id.getTm(),
				CommonAttributes.DATE_PATTERNS[7]));
		return sb.toString();
	}
}