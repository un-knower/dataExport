package com.zero.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * StPptnRId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class StPptnRId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6574382994621283210L;
	private Date tm;
	private String stcd;

	// Constructors

	/** default constructor */
	public StPptnRId() {
	}

	/** full constructor */
	public StPptnRId(Date tm, String stcd) {
		this.tm = tm;
		this.stcd = stcd;
	}

	// Property accessors
	@Temporal(TemporalType.DATE)
	@Column(name = "TM", nullable = false, length = 7)
	public Date getTm() {
		return tm;
	}

	public void setTm(Date tm) {
		this.tm = tm;
	}

	@Column(name = "STCD", nullable = false, length = 16)
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof StPptnRId)) {
			return false;
		}
		StPptnRId castOther = (StPptnRId) other;

		return ((this.getTm() == castOther.getTm()) || (this.getTm() != null
				&& castOther.getTm() != null && this.getTm().equals(
				castOther.getTm())))
				&& ((this.getStcd() == castOther.getStcd()) || (this.getStcd() != null
						&& castOther.getStcd() != null && this.getStcd()
						.equals(castOther.getStcd())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTm() == null ? 0 : this.getTm().hashCode());
		result = 37 * result
				+ (getStcd() == null ? 0 : this.getStcd().hashCode());
		return result;
	}

}