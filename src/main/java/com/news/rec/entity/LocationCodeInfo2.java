package com.news.rec.entity;

import java.io.Serializable;

public class LocationCodeInfo2 implements Serializable {
	private static final long serialVersionUID = 2199431518586565603L;
	private String code;// 邮编
	private String parentCode;// 邮编
	private String name;// 名称
	private int level;// 层级 0 1 2 省市区县
	private double longitude;// 经度
	private double latitude;// 纬度
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
}
