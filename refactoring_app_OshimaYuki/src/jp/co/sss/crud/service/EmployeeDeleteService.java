package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeDeleteService {
	public static void EmpDelete() {
		System.out.print(ConstantMsg.DELETE_EMP_ID);
		EmployeeEmpIdReader inputEmpId = new EmployeeEmpIdReader();
		int empId = (int) inputEmpId.input();
		EmployeeDAO.deleteEmployee(empId);
	}
}
