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
 * StRiverR entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ST_RIVER_R")
public class StRiverR implements java.io.Serializable {

	// Fields

	private StRiverRId id;
	private Double z;
	private Double q;
	private Double xsa;
	private Double xsavv;
	private Double xsmxv;
	private String flwchrcd;
	private String wptn;
	private String msqmt;
	private String msamt;
	private String msvmt;
	private String mdps;
	private Date mddt;

	// Constructors

	/** default constructor */
	public StRiverR() {
	}

	/** minimal constructor */
	public StRiverR(StRiverRId id) {
		this.id = id;
	}

	/** full constructor */
	public StRiverR(StRiverRId id, Double z, Double q, Double xsa,
			Double xsavv, Double xsmxv, String flwchrcd, String wptn,
			String msqmt, String msamt, String msvmt, String mdps, Date mddt) {
		this.id = id;
		this.z = z;
		this.q = q;
		this.xsa = xsa;
		this.xsavv = xsavv;
		this.xsmxv = xsmxv;
		this.flwchrcd = flwchrcd;
		this.wptn = wptn;
		this.msqmt = msqmt;
		this.msamt = msamt;
		this.msvmt = msvmt;
		this.mdps = mdps;
		this.mddt = mddt;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "tm", column = @Column(name = "TM", nullable = false, length = 7)),
			@AttributeOverride(name = "stcd", column = @Column(name = "STCD", nullable = false, length = 16)) })
	public StRiverRId getId() {
		return id;
	}

	public void setId(StRiverRId id) {
		this.id = id;
	}

	@Column(name = "Z", precision = 7, scale = 3)
	public Double getZ() {
		return z;
	}

	public void setZ(Double z) {
		this.z = z;
	}

	@Column(name = "Q", precision = 9, scale = 3)
	public Double getQ() {
		return q;
	}

	public void setQ(Double q) {
		this.q = q;
	}

	@Column(name = "XSA", precision = 9, scale = 3)
	public Double getXsa() {
		return xsa;
	}

	public void setXsa(Double xsa) {
		this.xsa = xsa;
	}

	@Column(name = "XSAVV", precision = 5, scale = 3)
	public Double getXsavv() {
		return xsavv;
	}

	public void setXsavv(Double xsavv) {
		this.xsavv = xsavv;
	}

	@Column(name = "XSMXV", precision = 5, scale = 3)
	public Double getXsmxv() {
		return xsmxv;
	}

	public void setXsmxv(Double xsmxv) {
		this.xsmxv = xsmxv;
	}

	@Column(name = "FLWCHRCD", length = 1)
	public String getFlwchrcd() {
		return flwchrcd;
	}

	public void setFlwchrcd(String flwchrcd) {
		this.flwchrcd = flwchrcd;
	}

	@Column(name = "WPTN", length = 1)
	public String getWptn() {
		return wptn;
	}

	public void setWptn(String wptn) {
		this.wptn = wptn;
	}

	@Column(name = "MSQMT", length = 1)
	public String getMsqmt() {
		return msqmt;
	}

	public void setMsqmt(String msqmt) {
		this.msqmt = msqmt;
	}

	@Column(name = "MSAMT", length = 1)
	public String getMsamt() {
		return msamt;
	}

	public void setMsamt(String msamt) {
		this.msamt = msamt;
	}

	@Column(name = "MSVMT", length = 1)
	public String getMsvmt() {
		return msvmt;
	}

	public void setMsvmt(String msvmt) {
		this.msvmt = msvmt;
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