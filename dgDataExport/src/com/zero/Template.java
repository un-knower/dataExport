package com.zero;

import java.io.Serializable;

/**
 * 模板
 * 
 * @author jianghao
 * @version 3.0
 */
public class Template implements Serializable {

	private static final long serialVersionUID = -517540800437045215L;

	/**
	 * 类型
	 */
	public enum Type {

		/** 转换 */
		trans
	}

	/** ID */
	private String id;

	/** 类型 */
	private Type type;

	/** 名称 */
	private String name;

	/** 模板文件路径 */
	private String entity;

	/** 开始时间 */
	private String stm;

	/** 描述 */
	private String filePath;

	/**
	 * @return
	 */
	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}


	public String getStm() {
		return stm;
	}

	public void setStm(String stm) {
		this.stm = stm;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * 获取ID
	 * 
	 * @return ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置ID
	 * 
	 * @param id
	 *            ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取类型
	 * 
	 * @return 类型
	 */
	public Type getType() {
		return type;
	}

	/**
	 * 设置类型
	 * 
	 * @param type
	 *            类型
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * 获取名称
	 * 
	 * @return 名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置名称
	 * 
	 * @param name
	 *            名称
	 */
	public void setName(String name) {
		this.name = name;
	}

}