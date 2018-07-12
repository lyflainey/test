package com.news.rec.entity;

import java.io.Serializable;

public class LocationCodeInfo1 implements Serializable {
	private static final long serialVersionUID = -896070794850948431L;
	private int id;// id
	private int pid;// 父id
	private String shortname;// 简称
	private String name;// 名称
	private String merger_name;// 全称
	private int level;// 层级 0 1 2 省市区县
	private String pinyin;// 拼音
	private String code;// 长途区号
	private String zip_code;// 邮编
	private String first;// 首字母
	private double lng;// 经度
	private double lat;// 纬度
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMerger_name() {
		return merger_name;
	}
	public void setMerger_name(String merger_name) {
		this.merger_name = merger_name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
}
