package com.zero.service;

import java.util.Date;
import java.util.List;

public interface OracleDataService {
	List getStPPTNRList(Date tm, int pageno, int pagesize);
}
