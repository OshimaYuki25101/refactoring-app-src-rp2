package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeRegisterService {
public static void empRegist() throws IllegalInputException,SystemErrorException {
	
	EmployeeNameReader inputName = new EmployeeNameReader();
	String empName = (String) inputName.inputName();
	
	EmployeeGenderReader inputGender = new EmployeeGenderReader();
	int gender =(int) inputGender.inputGender();
	
	EmployeeBirthdayReader inputBirthday = new EmployeeBirthdayReader();
	String birthday = (String) inputBirthday.inputBirthday();
	
	EmployeeDeptIdReader inputDeptId = new EmployeeDeptIdReader();
	int DeptId = (int) inputDeptId.inputDeptId();
	
	EmployeeDAO.insertEmployee(empName, gender, birthday, DeptId);
	
	System.out.println(ConstantMsg.INSERT_COMPLET);
	
}
}
