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

public class EmployeeFindByEmpNameService {
	public static void findByEmpName() throws ClassNotFoundException, SQLException, IOException, ParseException, SystemErrorException, IllegalInputException {
		List<Employee> employees = EmployeeDAO.findByName();
		ConsoleWriter.showEmployees(employees);
	}
}
