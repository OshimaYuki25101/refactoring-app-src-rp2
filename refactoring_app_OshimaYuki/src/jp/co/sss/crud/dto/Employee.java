package jp.co.sss.crud.dto;

import java.util.Date;

import jp.co.sss.crud.util.ConstantMsg;

public class Employee {
	private int empId;
	private String empName;
	private int gender;
	private Date birthday;
	private int deptId;
	private Department department;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		String gender_ja = "";
		if (this.gender == 1) {
			gender_ja = ConstantMsg.GENDER_MAN;
		} else if (this.gender == 2) {
			gender_ja = ConstantMsg.GENDER_WOMAN;
		}
		return empId + "\t" + empName + "\t" + gender_ja + "\t" + birthday + "\t" + department.getDeptName();
	}
}
