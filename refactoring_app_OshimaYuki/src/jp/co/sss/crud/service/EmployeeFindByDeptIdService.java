package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeDeptIdReader;

public class EmployeeFindByDeptIdService {
	public static void findByDeptId() throws ClassNotFoundException, SQLException, IOException, ParseException, SystemErrorException, IllegalInputException {
		EmployeeDeptIdReader br = new EmployeeDeptIdReader();
		int searchDeptId = (int) br.input();
		List<Employee> employees = EmployeeDAO.findByDeptId(searchDeptId);
		ConsoleWriter.showEmployees(employees);
	}
}
