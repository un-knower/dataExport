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
 * StWasR entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ST_WAS_R")
public class StWasR implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5760574181865176749L;
	private StWasRId id;
	private Double upz;
	private Double dwz;
	private Double tgtq;
	private String swchrcd;
	private String supwptn;
	private String sdwwptn;
	private String mdps;
	private Date mddt;

	// Constructors

	/** default constructor */
	public StWasR() {
	}

	/** minimal constructor */
	public StWasR(StWasRId id) {
		this.id = id;
	}

	/** full constructor */
	public StWasR(StWasRId id, Double upz, Double dwz, Double tgtq,
			String swchrcd, String supwptn, String sdwwptn, String mdps,
			Date mddt) {
		this.id = id;
		this.upz = upz;
		this.dwz = dwz;
		this.tgtq = tgtq;
		this.swchrcd = swchrcd;
		this.supwptn = supwptn;
		this.sdwwptn = sdwwptn;
		this.mdps = mdps;
		this.mddt = mddt;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "tm", column = @Column(name = "TM", nullable = false, length = 7)),
			@AttributeOverride(name = "stcd", column = @Column(name = "STCD", nullable = false, length = 16)) })
	public StWasRId getId() {
		return id;
	}

	public void setId(StWasRId id) {
		this.id = id;
	}

	@Column(name = "UPZ", precision = 7, scale = 3)
	public Double getUpz() {
		return upz;
	}

	public void setUpz(Double upz) {
		this.upz = upz;
	}

	@Column(name = "DWZ", precision = 7, scale = 3)
	public Double getDwz() {
		return dwz;
	}

	public void setDwz(Double dwz) {
		this.dwz = dwz;
	}

	@Column(name = "TGTQ", precision = 9, scale = 3)
	public Double getTgtq() {
		return tgtq;
	}

	public void setTgtq(Double tgtq) {
		this.tgtq = tgtq;
	}

	@Column(name = "SWCHRCD", length = 1)
	public String getSwchrcd() {
		return swchrcd;
	}

	public void setSwchrcd(String swchrcd) {
		this.swchrcd = swchrcd;
	}

	@Column(name = "SUPWPTN", length = 1)
	public String getSupwptn() {
		return supwptn;
	}

	public void setSupwptn(String supwptn) {
		this.supwptn = supwptn;
	}

	@Column(name = "SDWWPTN", length = 1)
	public String getSdwwptn() {
		return sdwwptn;
	}

	public void setSdwwptn(String sdwwptn) {
		this.sdwwptn = sdwwptn;
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
		sb.append(id.getStcd());
		sb.append(",");
		sb.append(DateUtil.getDateStr(id.getTm(),
				CommonAttributes.DATE_PATTERNS[7]));
		sb.append(",");
		sb.append(this.getUpz() == null ? "" : this.getUpz().toString());
		sb.append(",");
		sb.append(this.getDwz() == null ? "" : this.getDwz().toString());
		sb.append(",");
		sb.append(this.getTgtq() == null ? "" : this.getTgtq().toString());
		sb.append(",");
		sb.append(this.getSwchrcd() == null ? "" : this.getSwchrcd());
		sb.append(",");
		sb.append(this.getSdwwptn() == null ? "" : this.getSdwwptn());
		sb.append(",");
		sb.append(this.getSupwptn() == null ? "" : this.getSupwptn());
		sb.append(",");
		return sb.toString();
	}

}