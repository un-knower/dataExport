package com.test.cvs;

import java.util.Date;

import com.test.util.DateUtil;
import com.zero.CommonAttributes;

public class StPPTNR {
	private String tpcode;
	private Date tm;
	private Double drp;

	public StPPTNR(String tpcode, Date tm, Double drp) {
		super();
		this.tpcode = tpcode;
		this.tm = tm;
		this.drp = drp;
	}

	public String getTpcode() {
		return tpcode;
	}

	public void setTpcode(String tpcode) {
		this.tpcode = tpcode;
	}

	public Date getTm() {
		return tm;
	}

	public void setTm(Date tm) {
		this.tm = tm;
	}

	public Double getDrp() {
		return drp;
	}

	public void setDrp(Double drp) {
		this.drp = drp;
	}

	@Override
	public String toString() {
		return tpcode + ","
				+ DateUtil.getDateStr(tm, CommonAttributes.DATE_PATTERNS[7])
				+ "" + drp;
	}
}
