package com.zero.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * StRsvrRId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class StRsvrRId implements java.io.Serializable {

	// Fields

	private String stcd;
	private Date tm;

	// Constructors

	/** default constructor */
	public StRsvrRId() {
	}

	/** full constructor */
	public StRsvrRId(String stcd, Date tm) {
		this.stcd = stcd;
		this.tm = tm;
	}

	// Property accessors

	@Column(name = "STCD", nullable = false, length = 16)
	public String getStcd() {
		return this.stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TM", nullable = false, length = 7)
	public Date getTm() {
		return this.tm;
	}

	public void setTm(Date tm) {
		this.tm = tm;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StRsvrRId))
			return false;
		StRsvrRId castOther = (StRsvrRId) other;

		return ((this.getStcd() == castOther.getStcd()) || (this.getStcd() != null
				&& castOther.getStcd() != null && this.getStcd().equals(
				castOther.getStcd())))
				&& ((this.getTm() == castOther.getTm()) || (this.getTm() != null
						&& castOther.getTm() != null && this.getTm().equals(
						castOther.getTm())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getStcd() == null ? 0 : this.getStcd().hashCode());
		result = 37 * result + (getTm() == null ? 0 : this.getTm().hashCode());
		return result;
	}

}