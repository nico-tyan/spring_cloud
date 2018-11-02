package com.nico.web.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_dept")
public class Dept implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1884206922088714052L;

	public Dept() {
		super();
	}

	public Dept(long deptId, String deptName, String deptNo) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptNo = deptNo;
	}

	@Id
	@Column(name = "dept_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long deptId;
	@Column(name = "dept_name")
	private String deptName;

	@Column(name = "dept_no")
	private String deptNo;
	
	@Column(name = "data_source")
	private String dataSource;
	
	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public long getDeptId() {
		return deptId;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

}