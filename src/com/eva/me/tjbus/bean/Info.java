package com.eva.me.tjbus.bean;

import java.io.Serializable;

/**
 * 用户输入的所有信息
 * @author EVA
 *
 */
public class Info implements Serializable {
	
	private String order;

	private String name;
	private String no;
	
	private String time;

	private String path;
	
	private String routesBgn;
	private String routesDes;
	
	private int imgResID;

	
	public Info(String order, String name, String no, String time, String path,
			String routesBgn, String routesDes, int imgResID) {
		super();
		this.order = order;
		this.name = name;
		this.no = no;
		this.time = time;
		this.path = path;
		this.routesBgn = routesBgn;
		this.routesDes = routesDes;
		this.imgResID = imgResID;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getRoutesBgn() {
		return routesBgn;
	}

	public void setRoutesBgn(String routesBgn) {
		this.routesBgn = routesBgn;
	}

	public String getRoutesDes() {
		return routesDes;
	}

	public void setRoutesDes(String routesDes) {
		this.routesDes = routesDes;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getImgResID() {
		return imgResID;
	}

	public void setImgResID(int imgResID) {
		this.imgResID = imgResID;
	}
	
	
	
	
}
