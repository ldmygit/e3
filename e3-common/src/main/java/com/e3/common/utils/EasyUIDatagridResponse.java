package com.e3.common.utils;

import java.io.Serializable;
import java.util.List;

/**
 * 
     * Title: EasyUIResponse.java    
     * Description:后台封装数据给前台easyui datagrid页面
     * @author xyz       
     * @created 2017-5-10 上午8:40:17
 */
public class EasyUIDatagridResponse implements Serializable {

	private Long total;//总条数
	private List<?> rows;//记录数
	private List<?> footer;//合计
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	public List<?> getFooter() {
		return footer;
	}
	public void setFooter(List<?> footer) {
		this.footer = footer;
	}
	
}
