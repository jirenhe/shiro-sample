package com.gihub.sample.shiro.common.util;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class Page<T> {

	private int totalCount;

	private int totalPage;

	private int pageSize;

	private int currentPageNo;

	private List<T> records;

	private RowBounds rowBounds;

	public Page(int pageSize, int currentPageNo) {
		if (currentPageNo < 1)
			this.currentPageNo = 1;
		else
			this.currentPageNo = pageSize;
		this.pageSize = pageSize;
		this.rowBounds = new RowBounds((currentPageNo - 1) * pageSize, currentPageNo * pageSize);
	}

	public Page(RowBounds rowBounds) {
		this.rowBounds = rowBounds;
		this.pageSize = this.rowBounds.getLimit() - this.rowBounds.getOffset();
		this.currentPageNo = this.rowBounds.getLimit() / this.pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		if (currentPageNo > totalPage)
			currentPageNo = totalPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public int getOffset() {
		return this.rowBounds.getOffset();
	}

	public int getLimit() {
		return this.rowBounds.getLimit();
	}
}
