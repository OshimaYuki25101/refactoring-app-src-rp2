package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.EmployeeEmpIdReader;

public class EmployeeDeleteService {
	
	public static void EmpDelete() throws IllegalInputException,SystemErrorException{
		
		EmployeeEmpIdReader inputEmpId = new EmployeeEmpIdReader();
		
		int empId = (int) inputEmpId.inputEmpId();
		
		EmployeeDAO.deleteEmployee(empId);
	}
}
