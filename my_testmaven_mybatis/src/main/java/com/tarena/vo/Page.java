package com.tarena.vo;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3480267746811239379L;
    private  int currentPage;//当前页
    private int pageSize;//每页显示多少条记录
    private int totalCount;//总记录数
    private int totalPage;//总页数
    private int previousPage;//前一页
    private int nextPage;//下一页
    
    private List data;//当前页的数据
    private int begin;//分页的开始记录号
    
    private String userNameKeyword;
    private String userPasswordKeyword;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPreviousPage() {
		return previousPage;
	}
	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public int getBegin() {
		begin=(currentPage-1)*pageSize;
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public String getUserNameKeyword() {
		userNameKeyword=(userNameKeyword==null)?"%%":"%"+userNameKeyword+"%";
		return userNameKeyword;
	}
	public void setUserNameKeyword(String userNameKeyword) {
		this.userNameKeyword = userNameKeyword;
	}
	public String getUserPasswordKeyword() {
		userPasswordKeyword=(userPasswordKeyword==null)?"%%":"%"+userPasswordKeyword+"%";
		return userPasswordKeyword;
	}
	public void setUserPasswordKeyword(String userPasswordKeyword) {
		this.userPasswordKeyword = userPasswordKeyword;
	}
    
} 
