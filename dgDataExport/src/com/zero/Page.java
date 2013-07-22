package com.zero;

import java.util.List;

/**
 * 分页bean.
 * 
 * @author 姜浩
 */

public class Page {
	/**
	 * 默认的每次记录数.
	 */
	protected int pagesize = 10;

	/**
	 * 总页数.
	 */
	protected int pagetotal = 0;
	/**
	 * 总记录数.
	 */
	protected int rectotal = 0;

	/**
	 * @return pagesize : 返回 pagesize.
	 */
	/**
	 * 当前页数.
	 */
	protected int pageno = 1;

	/**
	 * 数据列表.
	 */
	protected List<? extends Object> list;

	public Page() {

	}

	public Page(int pageno, int pagesize) {
		super();
		this.pagesize = pagesize;
		this.pageno = pageno;
	}

	public int getPagesize() {
		return pagesize;
	}

	/**
	 * @param pagesize
	 *            : 设置 pagesize.
	 */
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	/**
	 * @return pageno : 返回 pageno.
	 */
	public int getPageno() {
		return pageno;
	}

	/**
	 * @param pageno
	 *            : 设置 pageno.
	 */
	public void setPageno(int pageno) {
		this.pageno = pageno;
	}

	/**
	 * @return rectotal : 返回 rectotal.
	 */
	public int getRectotal() {
		return rectotal;
	}

	/**
	 * @param rectotal
	 *            : 设置 rectotal.
	 */
	public void setRectotal(int rectotal) {
		this.rectotal = rectotal;
	}

	/**
	 * @return pagetotal : 返回 pagetotal.
	 */
	public int getPagetotal() {
		return pagetotal;
	}

	/**
	 * @param pagetotal
	 *            : 设置 pagetotal.
	 */
	public void setPagetotal(int pagetotal) {
		this.pagetotal = pagetotal;
	}

	/**
	 * @return list : 返回 list.
	 */
	public List<? extends Object> getList() {
		return list;
	}

	/**
	 * @param list
	 *            : 设置 list.
	 */
	public void setList(List<? extends Object> list) {
		this.list = list;
	}

}
