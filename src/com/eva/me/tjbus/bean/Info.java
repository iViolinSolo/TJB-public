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

	private String pathBgn;
	private String pathDes;

	private String routes;
	
	private int imgResID;

	
	public Info(String order, String name, String no, String time,
			String pathBgn, String pathDes, String routes, int imgResID) {
		super();
		this.order = order;
		this.name = name;
		this.no = no;
		this.time = time;
		this.pathBgn = pathBgn;
		this.pathDes = pathDes;
		this.routes = routes;
		this.imgResID = imgResID;
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

	public String getPathBgn() {
		return pathBgn;
	}

	public void setPathBgn(String pathBgn) {
		this.pathBgn = pathBgn;
	}

	public String getPathDes() {
		return pathDes;
	}

	public void setPathDes(String pathDes) {
		this.pathDes = pathDes;
	}

	public String getRoutes() {
		return routes;
	}

	public void setRoutes(String routes) {
		this.routes = routes;
	}

	public int getImgResID() {
		return imgResID;
	}

	public void setImgResID(int imgResID) {
		this.imgResID = imgResID;
	}
	
	
	
	
}
