package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeFindByEmpNameService {
	public static void findByEmpName() throws ClassNotFoundException, SQLException, IOException, ParseException {
		System.out.print(ConstantMsg.EMPLOYEE_NAME+":");
		EmployeeNameReader inputName = new EmployeeNameReader();
		String empName = (String) inputName.input();
		List<Employee> employees = EmployeeDAO.findByName(empName);
		ConsoleWriter.showEmployees(employees);
	}
}
