package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeRegisterService {
	public static void empRegist() throws ClassNotFoundException, SQLException, IOException, ParseException, SystemErrorException, IllegalInputException {
		
		System.out.print(ConstantMsg.EMPLOYEE_NAME);
		EmployeeNameReader inputName = new EmployeeNameReader();
		String empName = (String) inputName.input();
		
		System.out.print(ConstantMsg.GENDER_TYPE + ":");
		EmployeeGenderReader inputGender = new EmployeeGenderReader();
		int gender =  (int) inputGender.input();
		
		System.out.print(ConstantMsg.BIRTHDAY + ":");
		EmployeeBirthdayReader inputBirthday = new EmployeeBirthdayReader();
		String birthday = (String) inputBirthday.input();
		
		System.out.print(ConstantMsg.DEPT_TYPE + ":");
		EmployeeDeptIdReader inputDeptId = new EmployeeDeptIdReader();
		int deptId =(int) inputDeptId.input();

		EmployeeDAO.insertEmployee(empName,gender,birthday,deptId);
		System.out.println(ConstantMsg.INSERT_COMPLET);
	}
}
