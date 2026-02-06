package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeUpdateService {
	public static void empUpdate() throws ClassNotFoundException, SQLException, IOException, ParseException {
		System.out.print(ConstantMsg.UPDATE_EMP_ID + ":");
		EmployeeEmpIdReader inputEmpId = new EmployeeEmpIdReader();
		int empId = (int) inputEmpId.input();
		EmployeeDAO.updateEmployee(empId);
		System.out.println(ConstantMsg.UPDATE_COMPLETE);
	}
}
