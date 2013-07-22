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

/**
 * StRsvrR entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ST_RSVR_R")
public class StRsvrR implements java.io.Serializable {

	// Fields

	private StRsvrRId id;
	private Double rz;
	private Double inq;
	private Double w;
	private Double otq;
	private String rwchrcd;
	private String rwptn;
	private Double inqdr;
	private String msqmt;
	private String mdps;
	private Date mddt;

	// Constructors

	/** default constructor */
	public StRsvrR() {
	}

	/** minimal constructor */
	public StRsvrR(StRsvrRId id) {
		this.id = id;
	}

	/** full constructor */
	public StRsvrR(StRsvrRId id, Double rz, Double inq, Double w, Double otq,
			String rwchrcd, String rwptn, Double inqdr, String msqmt,
			String mdps, Date mddt) {
		this.id = id;
		this.rz = rz;
		this.inq = inq;
		this.w = w;
		this.otq = otq;
		this.rwchrcd = rwchrcd;
		this.rwptn = rwptn;
		this.inqdr = inqdr;
		this.msqmt = msqmt;
		this.mdps = mdps;
		this.mddt = mddt;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "stcd", column = @Column(name = "STCD", nullable = false, length = 16)),
			@AttributeOverride(name = "tm", column = @Column(name = "TM", nullable = false, length = 7)) })
	public StRsvrRId getId() {
		return id;
	}

	public void setId(StRsvrRId id) {
		this.id = id;
	}

	@Column(name = "RZ", precision = 7, scale = 3)
	public Double getRz() {
		return rz;
	}

	public void setRz(Double rz) {
		this.rz = rz;
	}

	@Column(name = "INQ", precision = 9, scale = 3)
	public Double getInq() {
		return inq;
	}

	public void setInq(Double inq) {
		this.inq = inq;
	}

	@Column(name = "W", precision = 9, scale = 3)
	public Double getW() {
		return w;
	}

	public void setW(Double w) {
		this.w = w;
	}

	@Column(name = "OTQ", precision = 9, scale = 3)
	public Double getOtq() {
		return otq;
	}

	public void setOtq(Double otq) {
		this.otq = otq;
	}

	@Column(name = "RWCHRCD", length = 1)
	public String getRwchrcd() {
		return rwchrcd;
	}

	public void setRwchrcd(String rwchrcd) {
		this.rwchrcd = rwchrcd;
	}

	@Column(name = "RWPTN", length = 1)
	public String getRwptn() {
		return rwptn;
	}

	public void setRwptn(String rwptn) {
		this.rwptn = rwptn;
	}

	@Column(name = "INQDR", precision = 5)
	public Double getInqdr() {
		return inqdr;
	}

	public void setInqdr(Double inqdr) {
		this.inqdr = inqdr;
	}

	@Column(name = "MSQMT", length = 1)
	public String getMsqmt() {
		return msqmt;
	}

	public void setMsqmt(String msqmt) {
		this.msqmt = msqmt;
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

}